package com.kingcar.rent.pro.adapter.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BannerHolderBuilder extends BaseHolerBuilder<BannerHolderBuilder.ViewHolder>{

    public BannerHolderBuilder(Context context,ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.home_banner_item, parent, false);
        viewHolder=new ViewHolder(view);
    }

    public ViewHolder build(){
        return viewHolder;
    }
    static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
