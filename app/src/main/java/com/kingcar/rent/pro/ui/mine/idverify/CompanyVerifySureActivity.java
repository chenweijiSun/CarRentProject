package com.kingcar.rent.pro.ui.mine.idverify;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

public class CompanyVerifySureActivity extends ToolBarActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.act_company_verify_sure;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("公司认证");

    }
}
