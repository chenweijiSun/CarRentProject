package com.kingcar.rent.pro.ui.mine.wallet;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

import butterknife.OnClick;

public class WalletActivity extends ToolBarActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.act_wallet;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("钱包");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_zhangdan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_zhangdan) {
            startActivity(new Intent(this, BillRecordActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.rel_recharge, R.id.rel_payment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rel_recharge:
                startActivity(new Intent(this,RechargeActivity.class));
                break;
            case R.id.rel_payment:
                startActivity(new Intent(this,PaymentActivity.class));

                break;
        }
    }
}
