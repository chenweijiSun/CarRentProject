package com.kingcar.rent.pro.utils;

import android.content.Context;
import android.text.TextUtils;

import java.io.File;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;

/**
 * Created by Administrator on 2016/3/16.
 */
public class ShareUtil {
    /**
     * 分享方式——微信
     */
    public static final int SHARE_TO_WECHAT = 0x123;
    /**
     * 分享方式——朋友圈
     */
    public static final int SHARE_TO_WECHAT_CIRCLE = 0x124;
    /**
     * 分享方式——QQ
     */
    public static final int SHARE_TO_QQ = 0x125;
    /**
     * 分享方式——QQ空间
     */
    public static final int SHARE_TO_QQZONE = 0x126;
    /**
     * 分享方式——复制链接
     */
    public static final int SHARE_TO_COPY = 0x127;
    /**
     * 分享方式——短信
     */
    public static final int SHARE_TO_SMS = 0x128;

    public static void sendShareMsg(Context context, int method, String shareImageUrl, String shareImageFile, String shareText, String shareTitle, String shareUrl, String wxShareurl) {
        Platform platform = null;

        File file = null;
        // 暂时移到这里，开放分享图片后移到最前面
        if (!TextUtils.isEmpty(shareImageFile)) {
            file = new File(shareImageFile);
        }
        switch (method) {
            case SHARE_TO_WECHAT:
                platform = ShareSDK.getPlatform(context, Wechat.NAME);
                Wechat.ShareParams params = new Wechat.ShareParams();
                if(shareUrl!=null){
                    params.setShareType(Platform.SHARE_WEBPAGE);
                }
                if (file != null) {
                    params.setImagePath(file.getAbsolutePath());
                    params.setShareType(Platform.SHARE_IMAGE);
                }
//                if(shareImageUrl!=null){
//                    params.setImageUrl(shareImageUrl);
//                }
                params.setTitle(shareTitle);
                params.setText(shareText);
                params.setTitleUrl(wxShareurl);
                params.setUrl(wxShareurl);
                platform.share(params);
                break;
            case SHARE_TO_WECHAT_CIRCLE:
                platform = ShareSDK.getPlatform(context, WechatMoments.NAME);
                WechatMoments.ShareParams paramsWE = new WechatMoments.ShareParams();
                if(shareUrl!=null){
                    paramsWE.setShareType(Platform.SHARE_WEBPAGE);
                }
                if (file != null) {
                    paramsWE.setImagePath(file.getAbsolutePath());
                    paramsWE.setShareType(Platform.SHARE_IMAGE);
                }
//                if(shareImageUrl!=null){
//                    paramsWE.setImageUrl(shareImageUrl);
//                }
                paramsWE.setUrl(wxShareurl);
                paramsWE.setTitle(StringUtils.buildString(shareText,"（",shareTitle,"）"));
			    paramsWE.setText(shareText);
                platform.share(paramsWE);
                break;
            case SHARE_TO_QQ:
                platform = ShareSDK.getPlatform(context, QQ.NAME);
                QQ.ShareParams paramss = new QQ.ShareParams();
//			    if (file != null)
//				    paramss.setImagePath(file.getAbsolutePath());
                if (!TextUtils.isEmpty(shareImageUrl)){
                    paramss.setImageUrl(shareImageUrl);
                }
                paramss.setTitle(shareTitle);
                paramss.setText(shareText);
                paramss.setTitleUrl(shareUrl);
                paramss.setSiteUrl(shareUrl);
                paramss.setUrl(shareUrl);
                platform.share(paramss);
                break;
            case SHARE_TO_QQZONE:
                platform = ShareSDK.getPlatform(context, QZone.NAME);
                QZone.ShareParams QZParams = new QZone.ShareParams();
                if (!TextUtils.isEmpty(shareImageUrl)) {
                    QZParams.setImageUrl(shareImageUrl);
                } else if (file != null) {
                    QZParams.setImagePath(file.getAbsolutePath());
                }
                QZParams.setTitle(shareTitle);
                QZParams.setText(shareText);
                QZParams.setTitleUrl(shareUrl);
                QZParams.setSite(shareText);
                QZParams.setSiteUrl(shareUrl);
                platform.share(QZParams);
                break;
        }
    }
}
