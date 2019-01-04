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
package com.kingcar.rent.pro.ui.carsource;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;
import com.kingcar.rent.pro.widget.SpaceItemDecoration;
import com.kingcar.rent.pro.widget.popup.CarScreenPopup;
import com.kingcar.rent.pro.widget.popup.CarTypePopup;
import razerdp.basepopup.BasePopupWindow;

import static com.kingcar.rent.pro.widget.popup.CarTypePopup.CAR_TYPE_STYLE_XML_1;
import static com.kingcar.rent.pro.widget.popup.CarTypePopup.CAR_TYPE_STYLE_XML_2;
import static razerdp.basepopup.BasePopupWindow.*;

/**
 * @author chenweiji
 * @version Id: CarSourceListActivity.java, v 0.1 2019/1/3 16:40 chenweiji Exp $$
 */
public class CarSourceListActivity extends ToolBarActivity {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.radioBtn1)
    RadioButton radioBtn1;
    @Bind(R.id.radioBtn2)
    RadioButton radioBtn2;
    @Bind(R.id.radioBtn3)
    RadioButton radioBtn3;
    @Bind(R.id.radioBtn4)
    RadioButton radioBtn4;
    @Bind(R.id.radioGroup)
    RadioGroup radioGroup;

    private CarTypePopup carTypePopup;
    private CarTypePopup facadePopup;
    private CarTypePopup areaPopup;
    private CarScreenPopup screenPopup;

    @Override
    protected int getLayoutResId() {
        return R.layout.act_car_source_list;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("奥迪A6");
        initPopup();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new SpaceItemDecoration(5));
        recyclerView.setAdapter(new CarSourceListAdapter());

    }

    private void initPopup() {
        carTypePopup = new CarTypePopup(this,CAR_TYPE_STYLE_XML_1);
        facadePopup = new CarTypePopup(this,CAR_TYPE_STYLE_XML_2);
        areaPopup = new CarTypePopup(this,CAR_TYPE_STYLE_XML_2);
        screenPopup=new CarScreenPopup(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioBtn1) {
                    carTypePopup.showPopupWindow(R.id.radioGroup);
                }else  if (checkedId == R.id.radioBtn2) {
                    facadePopup.showPopupWindow(R.id.radioGroup);
                }else  if (checkedId == R.id.radioBtn3) {
                    areaPopup.showPopupWindow(R.id.radioGroup);
                }else  if (checkedId == R.id.radioBtn4) {
                    screenPopup.showPopupWindow(R.id.radioGroup);
                }
            }
        });

//        areaPopup.setOnDismissListener(new OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                radioBtn3.setChecked(false);
//            }
//        });
//
//        facadePopup.setOnDismissListener(new OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                radioBtn2.setChecked(false);
//            }
//        });
//
//        screenPopup.setOnDismissListener(new OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                radioBtn4.setChecked(false);
//            }
//        });
//
//
//        carTypePopup.setOnDismissListener(new OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                radioBtn1.setChecked(false);
//            }
//        });

    }

    class CarSourceListAdapter extends RecyclerView.Adapter {

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(CarSourceListActivity.this).inflate(R.layout.item_car_source_list, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 10;
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }

}