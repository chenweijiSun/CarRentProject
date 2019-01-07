package com.kingcar.rent.pro.ui.mine;

import android.content.Intent;
import android.widget.Button;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class EditPhoneActivity extends ToolBarActivity {
    @Bind(R.id.btn_next)
    Button btnNext;

    @Override
    protected int getLayoutResId() {
        return R.layout.act_edit_phone;
    }

    @Override
    protected void init() {

    }

    @OnClick(R.id.btn_next)
    public void onClick() {

        startActivity(new Intent(this,EditPhoneActivity.class));

    }
}
