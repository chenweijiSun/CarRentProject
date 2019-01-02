package com.kingcar.rent.pro.model.entity;

import java.io.Serializable;

/**
 * Created by cwj on 2017/4/12.
 */

public class WeChat implements Serializable {

    private String sign;
    private String timestamp;
    private String nonceStr;
    private String partnerId;
    private String prepayId ;
    private String appId;

    public String getSign() {
        return sign;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public String getAppId() {
        return appId;
    }
}
