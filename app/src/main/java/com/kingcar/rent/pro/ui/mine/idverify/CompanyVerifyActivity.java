package com.kingcar.rent.pro.ui.mine.idverify;

import android.content.Intent;
import android.widget.Button;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class CompanyVerifyActivity extends ToolBarActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.act_company_verify;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("公司认证");
    }

    @OnClick(R.id.btn_next)
    public void onClick() {
        startActivity(new Intent(this,CompanyVerifySureActivity.class));
    }
}
