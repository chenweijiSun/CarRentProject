package com.kingcar.rent.pro.adapter.holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.bingoogolapple.bgabanner.BGABanner;
import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.utils.jutils.JUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassificationHolderBuilder extends BaseHolerBuilder<ClassificationHolderBuilder.ViewHolder>{

    public ClassificationHolderBuilder(Context context, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.view_classification_item, parent, false);
        viewHolder=new ViewHolder(view);
    }

    public ViewHolder build(){
        return viewHolder;
    }
    public  class ViewHolder extends RecyclerView.ViewHolder{

        private BGABanner bgaBanner;
        public ViewHolder(View itemView) {
            super(itemView);
            bgaBanner=itemView.findViewById(R.id.banner);

            List<List<String>> data=new ArrayList<>();
            List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");
            data.add(list);
            List<String> list2 = Arrays.asList("1", "2", "3", "4");
            data.add(list2);

            List<View> views=new ArrayList<>();
            for(List<String> lists:data){
                GridLayoutManager manager=new GridLayoutManager(itemView.getContext(),4);
                RecyclerView recyclerView=new RecyclerView(itemView.getContext());
                recyclerView.setLayoutManager(manager);
                recyclerView.setNestedScrollingEnabled(false);
                recyclerView.setAdapter(new MenuAdapter(itemView.getContext(),lists));
                views.add(recyclerView);
            }

            bgaBanner.setData(views);
        }
    }

    private class MenuAdapter extends RecyclerView.Adapter{

        private Context context;

        private List<String> data;

        public MenuAdapter(Context context, List<String> data) {
            this.context = context;
            this.data = data;
        }


        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_home_menu, parent, false);
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
            return data.size();
        }
    }


}
