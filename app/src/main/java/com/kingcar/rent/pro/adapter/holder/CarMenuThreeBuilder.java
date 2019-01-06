package com.kingcar.rent.pro.adapter.holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.widget.DashLineDecoration;

public class CarMenuThreeBuilder extends BaseHolerBuilder<CarMenuThreeBuilder.ViewHolder> {

    public CarMenuThreeBuilder(Context context, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_car_menu_three, parent, false);
        viewHolder = new ViewHolder(view);
    }

    public ViewHolder build() {
        return viewHolder;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private RecyclerView recyclerView;

        public ViewHolder(View itemView) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.recyclerView);
            init();
        }

        private void init(){
            LinearLayoutManager manager=new LinearLayoutManager(itemView.getContext());
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(manager);
            recyclerView.addItemDecoration(new DashLineDecoration());
            recyclerView.setAdapter(new CarMenuThreeBuilder.CarMenuThreeAdapter(itemView.getContext()));
        }
    }
    class CarMenuThreeAdapter extends RecyclerView.Adapter{
        private Context context;

        public CarMenuThreeAdapter(Context context) {
            this.context = context;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_car_menu_three, parent, false);
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
            return 5;
        }
    }
}
