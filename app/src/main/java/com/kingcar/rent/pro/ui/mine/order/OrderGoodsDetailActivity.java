package com.kingcar.rent.pro.ui.mine.order;

import android.content.Intent;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

import butterknife.OnClick;

public class OrderGoodsDetailActivity extends ToolBarActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.act_order_detail;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("订单详情");

    }

    @OnClick(R.id.btn_comment)
    public void onClick() {
        startActivity(new Intent(this,CommentActivity.class));
    }
}
