package com.kingcar.rent.pro.ui.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends ToolBarActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.act_setting;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("设置");

    }

    @OnClick({R.id.rel_edit_phone,R.id.rel_edit_pwd})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rel_edit_phone:
                startActivity(new Intent(this,EditPhoneActivity.class));
                break;

            case R.id.rel_edit_pwd:
                startActivity(new Intent(this,EditPwdActivity.class));
                break;
        }
    }


}
