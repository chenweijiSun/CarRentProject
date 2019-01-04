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
package com.kingcar.rent.pro.ui.fragment;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.kingcar.rent.pro.ITEM_TYPE;
import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.adapter.HomeAdapter;
import com.kingcar.rent.pro.base.BaseFragment;
import com.kingcar.rent.pro.model.HomeData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenweiji
 * @version Id: HomeFragment.java, v 0.1 2019/1/3 11:00 chenweiji Exp $$
 */
public class HomeFragment extends BaseFragment {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    private HomeAdapter homeAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.frag_home;
    }

    @Override
    protected void init() {
        LinearLayoutManager manager = new LinearLayoutManager(mActivity);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        homeAdapter=new HomeAdapter(mActivity);
        recyclerView.setAdapter(homeAdapter);
        initData();

        recyclerView.setNestedScrollingEnabled(false);

    }
    private void initData(){
        List<HomeData> dataList=new ArrayList<>();
        dataList.add(new HomeData(ITEM_TYPE.BANNER_TYPE));
        dataList.add(new HomeData(ITEM_TYPE.CLASSIFICATION_TYPE));
        homeAdapter.setDataList(dataList);
    }

    @Override
    protected void ui(int what, Message msg) {

    }

}