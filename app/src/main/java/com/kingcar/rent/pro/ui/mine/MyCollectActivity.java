package com.kingcar.rent.pro.ui.mine;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

public class MyCollectActivity extends ToolBarActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.act_collect;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("我的收藏");
    }
}
