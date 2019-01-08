package com.kingcar.rent.pro.ui.mine.order;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

public class TuiKuanActivity extends ToolBarActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.act_tuikuan;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("申请退款");

    }
}
