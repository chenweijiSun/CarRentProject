package com.kingcar.rent.pro.ui.mine;

import android.widget.Button;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class EditPhoneNewActivity extends ToolBarActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.act_edit_phone_new;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("输入新手机号");
    }

    @OnClick(R.id.btn_next)
    public void onClick() {

    }
}
