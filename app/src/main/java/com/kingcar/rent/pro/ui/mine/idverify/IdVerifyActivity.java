package com.kingcar.rent.pro.ui.mine.idverify;

import android.content.Intent;
import android.view.View;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

import butterknife.OnClick;

public class IdVerifyActivity extends ToolBarActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.act_id_verify;
    }

    @Override
    protected void init() {

        initTitleAndCanBack("身份认证/所属公司");
    }

    @OnClick({R.id.rel_id, R.id.rel_company})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rel_id:
                startActivity(new Intent(this,IdVerifyIdActivity.class));
                break;
            case R.id.rel_company:
                startActivity(new Intent(this,CompanyVerifyActivity.class));
                break;
        }
    }
}
