package com.kingcar.rent.pro.adapter.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kingcar.rent.pro.R;

public class CarMenuTwoBuilder extends BaseHolerBuilder<CarMenuTwoBuilder.ViewHolder>{

    public CarMenuTwoBuilder(Context context, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.view_car_menu_two, parent, false);
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
