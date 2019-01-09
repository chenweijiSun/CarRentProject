package com.kingcar.rent.pro.ui.rentcar;

import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.BaseFragment;
import com.kingcar.rent.pro.ui.carsource.CarSourceListActivity;
import com.kingcar.rent.pro.widget.DashLineDecoration;
import com.kingcar.rent.pro.widget.SpaceItemDecoration;
import com.kingcar.rent.pro.widget.dialog.DialogFragmentHelper;
import com.kingcar.rent.pro.widget.dialog.IDialogResultListener;

import butterknife.Bind;

public class FenShiZuFragment extends BaseFragment {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected int getLayoutResId() {
        return R.layout.frag_fenshizu;
    }

    @Override
    protected void init() {

        LinearLayoutManager manager = new LinearLayoutManager(mActivity);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DashLineDecoration());
        recyclerView.setAdapter(new FenShiZuFragment.UseCarAdapter());
    }

    @Override
    protected void ui(int what, Message msg) {

    }

    class UseCarAdapter extends RecyclerView.Adapter{

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mActivity).inflate(R.layout.item_use_car, parent, false);
            view.findViewById(R.id.tv_use).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] items={"到店自提","送车上门","取消"};
                    DialogFragment dialog = DialogFragmentHelper.showListDialog(mActivity.getSupportFragmentManager(), null, items, new IDialogResultListener<Integer>() {
                        @Override
                        public void onDataResult(Integer result) {
                            if(result==0){

                            }else if(result==1){

                            }
                        }
                    }, true);
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
            return 3;
        }
    }
}
