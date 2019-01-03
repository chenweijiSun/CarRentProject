package com.kingcar.rent.pro.adapter;

import android.content.Context;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.adapter.base.BaseHoler;
import com.kingcar.rent.pro.adapter.base.CWJBaseAdapter;
import com.kingcar.rent.pro.model.entity.CarSourceInfo;

public class CarSourceAdapter extends CWJBaseAdapter<CarSourceInfo,BaseHoler> {
    public CarSourceAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseHoler bindHoler() {
        return null;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.item_car_source;
    }

    @Override
    public void bindData(BaseHoler holder, int position, CarSourceInfo item) {

    }
}
