package com.kingcar.rent.pro.ui.mine.order;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

public class BuyCarDetailActivity extends ToolBarActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.act_buy_car_detail;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("订单详情");

    }
}
