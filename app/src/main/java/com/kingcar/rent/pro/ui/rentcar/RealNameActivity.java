package com.kingcar.rent.pro.ui.rentcar;

import android.content.Intent;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

import butterknife.OnClick;

public class RealNameActivity extends ToolBarActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.act_real_name;
    }

    @Override
    protected void init() {

        initTitleAndCanBack("身份认证");


    }

    @OnClick(R.id.btn_next)
    public void onClick() {
        startActivity(new Intent(this,JiaShiVerifyActivity.class));
    }
}
