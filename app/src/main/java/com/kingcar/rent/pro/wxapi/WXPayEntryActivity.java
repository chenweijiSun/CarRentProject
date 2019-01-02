package com.kingcar.rent.pro.wxapi;


import android.content.Intent;
import android.text.TextUtils;


import com.kingcar.rent.pro.Constant;
import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


public class WXPayEntryActivity extends ToolBarActivity implements IWXAPIEventHandler {



    private IWXAPI api;

    @Override
    protected int getLayoutResId() {
        return R.layout.act_pay_result;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("支付订单");
        api = WXAPIFactory.createWXAPI(this, Constant.APPID);
        api.handleIntent(getIntent(), this);
        Intent intent = getIntent();

        String payId = intent.getStringExtra("PayId");
        String status = intent.getStringExtra(Constant.EXTRA_VALUE);
        if (TextUtils.equals("alipay", payId)) {
            if(TextUtils.equals(status,"succ")){

            }else{

            }
        } else if (TextUtils.equals("recharge", payId)){
            if(TextUtils.equals(status,"succ")){

            }else{

            }
        }

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {

    }

    @Override
    public void onResp(BaseResp resp) {

        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {

            if (resp.errCode == 0) {
//                showToast("支付成功");


            } else if (resp.errCode == -2) {
//                showToast("取消支付");

            } else {
//                showToast("支付失败");

            }
        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}