package com.kingcar.rent.pro.ui.mine.wallet;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

public class RechargeActivity extends ToolBarActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.act_recharge;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("充值");

    }
}
