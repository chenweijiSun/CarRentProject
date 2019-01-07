package com.kingcar.rent.pro.ui.mine.idverify;

import android.widget.Toolbar;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

public class IdVerifyIdActivity extends ToolBarActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.act_id_verify_id;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("身份证信息认证");

    }
}
