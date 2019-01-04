package com.kingcar.rent.pro.model;

import com.kingcar.rent.pro.ITEM_TYPE;

import java.io.Serializable;

/**
 * Created by cwj on 2018/3/15.
 */

public class HomeData implements Serializable {

    private ITEM_TYPE type;

    public HomeData(ITEM_TYPE type) {
        this.type = type;
    }

    public ITEM_TYPE getType() {
        return type;
    }

    public void setType(ITEM_TYPE type) {
        this.type = type;
    }
}
