package com.kingcar.rent.pro.ui.mine;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

public class AddressEditActivity extends ToolBarActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.act_address_edit;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("新增收货地址");
    }
}
