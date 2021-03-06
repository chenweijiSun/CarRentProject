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
package com.kingcar.rent.pro.widget.popup.rentcar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.ui.carsource.CarSourceListActivity;
import com.kingcar.rent.pro.widget.SpaceItemDecoration;

import razerdp.basepopup.BasePopupWindow;
import razerdp.util.SimpleAnimationUtils;

/**
 * @author chenweiji
 * @version Id: PublishPopup.java, v 0.1 2019/1/4 15:14 chenweiji Exp $$
 */
public class SearchWangDianPopup extends BasePopupWindow {

    private RecyclerView recyclerView;
    public SearchWangDianPopup(Context context) {
        super(context);

        setPopupGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        //模糊背景
        setBlurBackgroundEnable(true);

        recyclerView=findViewById(R.id.recyclerView);

        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new SpaceItemDecoration(5));
        recyclerView.setAdapter(new SearchWangDianAdapter());
    }

    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.popup_search_wangdian);
    }

    @Override
    protected Animation onCreateShowAnimation() {
        return SimpleAnimationUtils.getTranslateVerticalAnimation(1f, 0, 500);
    }

    @Override
    protected Animation onCreateDismissAnimation() {
        return SimpleAnimationUtils.getTranslateVerticalAnimation(0, 1f, 500);
    }

    class SearchWangDianAdapter extends RecyclerView.Adapter{

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_search_wangdian, parent, false);
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
            return 10;
        }
    }
}