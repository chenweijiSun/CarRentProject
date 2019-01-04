package com.kingcar.rent.pro.adapter.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.bingoogolapple.bgabanner.BGABanner;
import com.bumptech.glide.Glide;
import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.ui.MainActivity;

public class BannerHolderBuilder extends BaseHolerBuilder<BannerHolderBuilder.ViewHolder>{

    public BannerHolderBuilder(Context context, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.view_home_banner_item, parent, false);
        viewHolder=new ViewHolder(view);
    }

    public ViewHolder build(){
        return viewHolder;
    }
    public  class ViewHolder extends RecyclerView.ViewHolder{

        private BGABanner bgaBanner;

        public ViewHolder(View itemView) {
            super(itemView);
            bgaBanner=itemView.findViewById(R.id.banner_guide);

            init();
        }

        private void init(){

            bgaBanner.setData(null, ImageView.ScaleType.CENTER_CROP,
                    R.mipmap.d_icon_car_banner,
                    R.mipmap.d_icon_car_banner,
                    R.mipmap.d_icon_car_banner);
        }
    }
}
