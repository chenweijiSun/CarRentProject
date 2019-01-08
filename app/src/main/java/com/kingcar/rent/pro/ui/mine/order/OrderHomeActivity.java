package com.kingcar.rent.pro.ui.mine.order;

import android.content.Intent;
import android.view.View;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

import butterknife.OnClick;

public class OrderHomeActivity extends ToolBarActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.act_order_home;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("订单");

    }

    @OnClick({R.id.rel_rent_car, R.id.rel_buy_car, R.id.rel_sale_car, R.id.rel_goods, R.id.rel_wuliu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rel_rent_car:
                startActivity(new Intent(this,RentSaleCarActivity.class));
                break;
            case R.id.rel_buy_car:
                startActivity(new Intent(this,BuyCarActivity.class));
                break;
            case R.id.rel_sale_car:
                startActivity(new Intent(this,RentSaleCarActivity.class));
                break;
            case R.id.rel_goods:
                startActivity(new Intent(this,OrderGoodsActivity.class));
                break;
            case R.id.rel_wuliu:
                break;
        }
    }
}
