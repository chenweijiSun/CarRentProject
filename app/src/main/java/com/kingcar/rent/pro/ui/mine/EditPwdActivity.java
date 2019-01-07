package com.kingcar.rent.pro.ui.mine;

import android.content.Intent;
import android.widget.Button;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class EditPwdActivity extends ToolBarActivity {


    @Override
    protected int getLayoutResId() {
        return R.layout.act_edit_phone;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("修改密码");
    }

    public void onClick() {


    }
}
