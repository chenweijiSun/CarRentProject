package com.kingcar.rent.pro.adapter.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kingcar.rent.pro.R;

import cn.bingoogolapple.bgabanner.BGABanner;

public class CarMenuOneBuilder extends BaseHolerBuilder<CarMenuOneBuilder.ViewHolder>{

    public CarMenuOneBuilder(Context context, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.view_home_car_menu_one, parent, false);
        viewHolder=new ViewHolder(view);
    }

    public ViewHolder build(){
        return viewHolder;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{


        public ViewHolder(View itemView) {
            super(itemView);

            init();
        }

        private void init(){

        }
    }
}
