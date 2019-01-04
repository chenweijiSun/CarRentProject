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
package com.kingcar.rent.pro.widget.popup;

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
import razerdp.basepopup.BasePopupWindow;
import razerdp.util.SimpleAnimationUtils;

/**
 * @author chenweiji
 * @version Id: CarTypePopupWindow.java, v 0.1 2019/1/4 10:13 chenweiji Exp $$
 */
public class CarTypePopup extends BasePopupWindow {

    public static final int CAR_TYPE_STYLE_XML_1=1;
    public static final int CAR_TYPE_STYLE_XML_2=2;

    private RecyclerView recyclerView;

    public CarTypePopup(Context context,int style) {
        super(context);
        recyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        if(style==CAR_TYPE_STYLE_XML_1){
            recyclerView.setAdapter(new CarTypeAdapter());
        }else{
            recyclerView.setAdapter(new FacadeAreaAdapter());
        }

        //设置Popup上方不需要背景下方需要的场景
        setAlignBackground(true);
        setAlignBackgroundGravity(Gravity.TOP);
    }


    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.popup_car_type);
    }

    /**
     * 返回作用于PopupWindow的show和dismiss动画，本库提供了默认的几款动画，这里可以自由实现
     */
    @Override
    protected Animation onCreateShowAnimation() {
//        TranslateAnimation translateAnimation = new TranslateAnimation(0f, 0f, -DimensUtils.dipToPx(getContext(), 350f), 0);
//        translateAnimation.setDuration(450);
//        translateAnimation.setInterpolator(new OvershootInterpolator(1));
//        return translateAnimation;

        return SimpleAnimationUtils.getTranslateVerticalAnimation(-1f, 0, 300);
    }

    @Override
    protected Animation onCreateDismissAnimation() {
//        TranslateAnimation translateAnimation = new TranslateAnimation(0f, 0f, 0, -DimensUtils.dipToPx(getContext(), 350f));
//        translateAnimation.setDuration(450);
//        translateAnimation.setInterpolator(new OvershootInterpolator(-4));
//        return translateAnimation;

        return SimpleAnimationUtils.getTranslateVerticalAnimation(0, -1f, 300);
    }

    /**
     * 外观和地区
     */
    class FacadeAreaAdapter extends RecyclerView.Adapter{

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_facade_area_pop, parent, false);
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

    /**
     * 车型
     */
    class CarTypeAdapter extends RecyclerView.Adapter{

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_car_type_pop, parent, false);
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