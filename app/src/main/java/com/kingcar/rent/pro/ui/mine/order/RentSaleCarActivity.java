package com.kingcar.rent.pro.ui.mine.order;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

public class RentSaleCarActivity extends ToolBarActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.act_rent_sale_car;
    }

    @Override
    protected void init() {

        initTitleAndCanBack("租车订单");
    }
}
