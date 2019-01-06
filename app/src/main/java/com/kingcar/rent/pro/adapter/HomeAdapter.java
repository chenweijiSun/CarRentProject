package com.kingcar.rent.pro.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kingcar.rent.pro.ITEM_TYPE;
import com.kingcar.rent.pro.adapter.holder.BannerHolderBuilder;
import com.kingcar.rent.pro.adapter.holder.BaoXianBuilder;
import com.kingcar.rent.pro.adapter.holder.CarMenuOneBuilder;
import com.kingcar.rent.pro.adapter.holder.CarMenuThreeBuilder;
import com.kingcar.rent.pro.adapter.holder.CarMenuTwoBuilder;
import com.kingcar.rent.pro.adapter.holder.ClassificationHolderBuilder;
import com.kingcar.rent.pro.adapter.holder.SecondKillBuilder;
import com.kingcar.rent.pro.model.HomeData;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter {
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<HomeData> dataList;

    public HomeAdapter(Context context) {
        mContext = context;
        dataList = new ArrayList<>();
        mLayoutInflater = LayoutInflater.from(context);
    }
    public List<HomeData> getDataList() {
        return dataList;
    }

    public void setDataList(List<HomeData> dataList) {
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    public void addData(HomeData homeData) {
        dataList.add(homeData);
        notifyDataSetChanged();
    }

    public void addData(HomeData homeData, int position) {
        dataList.add(position, homeData);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.BANNER_TYPE.ordinal()) {
            return new BannerHolderBuilder(mContext,parent).build();

        } else if (viewType == ITEM_TYPE.CLASSIFICATION_TYPE.ordinal()) {
            return new ClassificationHolderBuilder(mContext,parent).build();

        } else if (viewType == ITEM_TYPE.CAR_MENU_ONE.ordinal()) {
            return new CarMenuOneBuilder(mContext,parent).build();

        } else if (viewType == ITEM_TYPE.SECOND_KILL.ordinal()) {
            return new SecondKillBuilder(mContext,parent).build();

        } else if (viewType == ITEM_TYPE.CAR_MENU_TWO.ordinal()) {
            return new CarMenuTwoBuilder(mContext,parent).build();

        } else if (viewType == ITEM_TYPE.BAO_XIAN.ordinal()) {
            return new BaoXianBuilder(mContext,parent).build();

        } else if (viewType == ITEM_TYPE.CAR_MENU_THREE.ordinal()) {
            return new CarMenuThreeBuilder(mContext,parent).build();

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeData homeData = dataList.get(position);

        if (holder instanceof BannerHolderBuilder.ViewHolder) {
            BannerHolderBuilder.ViewHolder viewHolder = (BannerHolderBuilder.ViewHolder) holder;

        } else if (holder instanceof ClassificationHolderBuilder.ViewHolder) {
            ClassificationHolderBuilder.ViewHolder viewHolder = (ClassificationHolderBuilder.ViewHolder) holder;

        } else if (holder instanceof CarMenuOneBuilder.ViewHolder) {
            CarMenuOneBuilder.ViewHolder viewHolder = (CarMenuOneBuilder.ViewHolder) holder;

        } else if (holder instanceof SecondKillBuilder.ViewHolder) {
            SecondKillBuilder.ViewHolder viewHolder = (SecondKillBuilder.ViewHolder) holder;

        } else if (holder instanceof CarMenuTwoBuilder.ViewHolder) {
            CarMenuTwoBuilder.ViewHolder viewHolder = (CarMenuTwoBuilder.ViewHolder) holder;

        } else if (holder instanceof BaoXianBuilder.ViewHolder) {
            BaoXianBuilder.ViewHolder viewHolder = (BaoXianBuilder.ViewHolder) holder;

        } else if (holder instanceof CarMenuThreeBuilder.ViewHolder) {
            CarMenuThreeBuilder.ViewHolder viewHolder = (CarMenuThreeBuilder.ViewHolder) holder;

        }

    }

    @Override
    public int getItemViewType(int position) {
        return dataList.get(position).getType().ordinal();
    }

    @Override
    public int getItemCount() {
        return dataList.size();

    }
}
