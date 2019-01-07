package com.kingcar.rent.pro.ui.mine;

import android.content.Intent;
import android.view.View;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

import butterknife.OnClick;

public class MessageActivity extends ToolBarActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.act_message;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("消息");
    }

    @OnClick({R.id.rel_yueche, R.id.rel_order, R.id.rel_zuche, R.id.rel_pingtai})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rel_yueche:
                startActivity(new Intent(this,MessageDetailActivity.class));
                break;
            case R.id.rel_order:
                startActivity(new Intent(this,MessageDetailActivity.class));
                break;
            case R.id.rel_zuche:
                startActivity(new Intent(this,MessageDetailActivity.class));
                break;
            case R.id.rel_pingtai:
                startActivity(new Intent(this,MessageDetailActivity.class));
                break;
        }
    }
}
