/**
 * Software License Declaration.
 * <p>
 * wandaph.com, Co,. Ltd.
 * Copyright ? 2017 All Rights Reserved.
 * <p>
 * Copyright Notice
 * This documents is provided to wandaph contracting agent or authorized programmer only.
 * This source code is written and edited by wandaph Co,.Ltd Inc specially for financial
 * business contracting agent or authorized cooperative company, in order to help them to
 * install, programme or central control in certain project by themselves independently.
 * <p>
 * Disclaimer
 * If this source code is needed by the one neither contracting agent nor authorized programmer
 * during the use of the code, should contact to wandaph Co,. Ltd Inc, and get the confirmation
 * and agreement of three departments managers  - Research Department, Marketing Department and
 * Production Department.Otherwise wandaph will charge the fee according to the programme itself.
 * <p>
 * Any one,including contracting agent and authorized programmer,cannot share this code to
 * the third party without the agreement of wandaph. If Any problem cannot be solved in the
 * procedure of programming should be feedback to wandaph Co,. Ltd Inc in time, Thank you!
 */
package com.kingcar.rent.pro.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.adapter.base.BaseHoler;
import com.kingcar.rent.pro.adapter.base.CWJBaseAdapter;
import com.kingcar.rent.pro.model.entity.CarSourceInfo;

/**
 * @author chenweiji
 * @version Id: CarSourceUsuallyAdapter.java, v 0.1 2019/1/3 15:20 chenweiji Exp $$
 */
public class CarSourceUsuallyAdapter extends CWJBaseAdapter<CarSourceInfo, CarSourceUsuallyAdapter.ViewHolder> {
    public CarSourceUsuallyAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder bindHoler() {
        return new ViewHolder();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.item_car_source_usually;
    }

    @Override
    public void bindData(ViewHolder holder, int position, CarSourceInfo item) {

    }

    static class ViewHolder extends BaseHoler{
        @Bind(R.id.iv_logo)
        ImageView ivLogo;
        @Bind(R.id.tv_name)
        TextView tvName;
    }
}