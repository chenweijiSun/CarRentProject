package com.kingcar.rent.pro.ui.mine.order;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;

import butterknife.Bind;

public class BuyCarActivity extends ToolBarActivity {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected int getLayoutResId() {
        return R.layout.act_buy_car;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("买车订单");
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new BuyCarAdapter());
    }

    class BuyCarAdapter extends RecyclerView.Adapter {

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(BuyCarActivity.this).inflate(R.layout.item_buy_car, parent, false);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(BuyCarActivity.this,BuyCarDetailActivity.class));
                }
            });
            return new RecyclerView.ViewHolder(view) {
                @Override
                public String toString() {
                    return super.toString();
                }
            };
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }
}
