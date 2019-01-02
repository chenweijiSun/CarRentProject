package com.kingcar.rent.pro.base;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import com.alipay.sdk.app.PayTask;
import com.google.gson.Gson;
import com.kingcar.rent.pro.Constant;
import com.kingcar.rent.pro.model.entity.PayResultInfo;
import com.kingcar.rent.pro.model.entity.WeChat;
import com.kingcar.rent.pro.utils.jutils.JUtils;
import com.kingcar.rent.pro.wxapi.WXPayEntryActivity;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.json.JSONObject;

public abstract class BasePayActivity<T extends BasePresenter> extends ToolBarActivity<T> {
    public static final int PAY_RESULT_CONFIRM = 0x123;//订单正在确认中
    public static final int PAY_RESULT_FAILED = 0x124;//订单支付失败
    public static final int PAY_RESULT_SUCESS = 0x125;//订单支付成功
    private static final int SDK_PAY_FLAG = 1;//支付宝回调结果状态
    private static final int SDK_CHECK_FLAG = 2;//支付宝回调的检查结果
    public String resultStatus = null;
    private OnPayResultListener listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resultStatus = null;//支付宝支付状态
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResultInfo payResult = new PayResultInfo((String) msg.obj);
                    // 支付宝返回此次支付结果及加签，建议对支付宝签名信息拿签约时支付宝提供的公钥做验签
                    String resultInfo = payResult.getResult();

                    resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        JUtils.Toast("支付成功");
                        if (listener != null) {
                            listener.onPaySucc();
                        }
                    } else {
                        // 判断resultStatus 为非“9000”则代表可能支付失败“8000”代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            JUtils.Toast("支付结果确认中...");
                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            JUtils.Toast("支付失败");
                            if (listener != null) {
                                listener.onPayFail();
                            }
                        }
                    }
                    break;
                }
                case SDK_CHECK_FLAG: {
//				JUtils.Toast("检查结果为：" + msg.obj);
                    break;
                }
            }
        }
    };

    public void aliPay(String sign, OnPayResultListener listener) {
        this.listener = listener;
//		final String sign= AliPaySignUtil.getOrderInfo(jsonObject);
        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                // 构造PayTask对象
                PayTask alipay = new PayTask(BasePayActivity.this);
                // 调用支付接口，获取支付结果
                try {
                    String result = alipay.pay(sign, true);
                    Message msg = new Message();
                    msg.what = SDK_PAY_FLAG;
                    msg.obj = result;
                    mHandler.sendMessage(msg);
                } catch (Exception e) {
                }
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    //微信支付
    public void wx_pay(WeChat result) {
        IWXAPI msgApi = WXAPIFactory.createWXAPI(this, Constant.APPID);
        if (result == null)
            return;

        String appid = result.getAppId();
//		Run.savePrefs(mActivity,"order_id_cache",result.optString("order_id"));
//		if(result.has("total_amount")){
//			Run.savePrefs(mActivity,"order_money_cache",result.optString("total_amount"));
//		}else if(result.has("cur_money")){
//			Run.savePrefs(mActivity,"order_money_cache",result.optString("cur_money"));
//		}
//		Run.savePrefs(mActivity,Run.APP_ID,appid);
        String partnerid = result.getPartnerId();
        String prepayid = result.getPrepayId();
        String timestamp = result.getTimestamp();
        String packages = "Sign=WXpay";
        String noncestr = result.getNonceStr();
        String sign = result.getSign();
        PayReq req = new PayReq();
        req.appId = appid;
        req.partnerId = partnerid;
        req.prepayId = prepayid;
        req.packageValue = packages;
        req.nonceStr = noncestr;
        req.timeStamp = timestamp;

        req.sign = sign;
        msgApi.registerApp(appid);
        msgApi.sendReq(req);
    }

    public void setActivityResult() {
        Bundle mBundle = new Bundle();
        this.setActivityResult(mBundle);
    }

    public void setActivityResult(Bundle bundle) {
        Intent mIntent = new Intent();
        mIntent.putExtras(bundle);
        setResult(Activity.RESULT_OK, mIntent);
    }

    public interface OnPayResultListener {
        void onPaySucc();

        void onPayFail();
    }

    public void toPay(JSONObject resultJson) {

        int type = resultJson.optInt("type");
        String payUrl = resultJson.optString("payUrl");
        if (type == 0) {
            String appId = resultJson.optString("appId");
            String partnerId = resultJson.optString("partnerId");
            String prepayId = resultJson.optString("prepayId");
            String timestamp = resultJson.optString("timestamp");
            String packages = resultJson.optString("packages");
            String nonceStr = resultJson.optString("nonceStr");
            WeChat weChat = new Gson().fromJson(resultJson.toString(), WeChat.class);
            BaseApplication.getInstance().weChatPayMode = "purchase";
            wx_pay(weChat);

        } else if (type == 1) {
            String sign = resultJson.optString("sign");
            aliPay(sign, new OnPayResultListener() {
                @Override
                public void onPaySucc() {
                    Intent intent = new Intent(BasePayActivity.this, WXPayEntryActivity.class);
                    intent.putExtra("PayId", "alipay");
                    intent.putExtra(Constant.EXTRA_VALUE, "succ");
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onPayFail() {
                    Intent intent = new Intent(BasePayActivity.this, WXPayEntryActivity.class);
                    intent.putExtra("PayId", "alipay");
                    intent.putExtra(Constant.EXTRA_VALUE, "fail");
                    startActivity(intent);
                    finish();
                }
            });
        } else if (type == 2) {
            //银联支付
            if (!payUrl.isEmpty()) {

            }
        } else if (type == 3) {
            //余额支付
            int status = resultJson.optInt("status");
            if (status == 0) {
//                showToast("余额不足");
                Intent intent = new Intent(BasePayActivity.this, WXPayEntryActivity.class);
                intent.putExtra("PayId", "alipay");
                intent.putExtra(Constant.EXTRA_VALUE, "fail");
                startActivity(intent);
                finish();

            } else if (status == 1) {
//                showToast("支付成功");
                Intent intent = new Intent(BasePayActivity.this, WXPayEntryActivity.class);
                intent.putExtra("PayId", "alipay");
                intent.putExtra(Constant.EXTRA_VALUE, "succ");
                startActivity(intent);
                finish();

            } else if (status == 2) {
//                showToast("支付失败");
                Intent intent = new Intent(BasePayActivity.this, WXPayEntryActivity.class);
                intent.putExtra("PayId", "alipay");
                intent.putExtra(Constant.EXTRA_VALUE, "fail");
                startActivity(intent);
                finish();
            }
        }
    }
}
