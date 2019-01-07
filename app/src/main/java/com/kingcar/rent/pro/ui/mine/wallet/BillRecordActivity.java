package com.kingcar.rent.pro.ui.mine.wallet;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

public class BillRecordActivity extends ToolBarActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.act_bill_record;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("账单记录");
    }
}
