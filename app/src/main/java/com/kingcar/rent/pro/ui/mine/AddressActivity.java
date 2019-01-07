package com.kingcar.rent.pro.ui.mine;

import android.content.Intent;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

import butterknife.OnClick;

public class AddressActivity extends ToolBarActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.act_address;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("收货地址");
    }

    @OnClick(R.id.btn_add)
    public void onClick() {
        startActivity(new Intent(this, AddressEditActivity.class));
    }
}
