package com.kingcar.rent.pro.ui.mine;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

public class CouponActivity extends ToolBarActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.act_coupon;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("优惠券");
    }
}
