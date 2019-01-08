package com.kingcar.rent.pro.ui.mine.order;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

public class CommentActivity extends ToolBarActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.act_comment;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("评价");
    }
}
