package com.kingcar.rent.pro.ui.mine;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

public class MessageDetailActivity extends ToolBarActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.act_message_detail;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("消息");

    }
}
