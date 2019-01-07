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

import android.content.Intent;
import android.os.Message;
import android.view.View;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.BaseFragment;
import com.kingcar.rent.pro.ui.mine.AddressActivity;
import com.kingcar.rent.pro.ui.mine.CouponActivity;
import com.kingcar.rent.pro.ui.mine.MessageActivity;
import com.kingcar.rent.pro.ui.mine.SettingActivity;
import com.kingcar.rent.pro.ui.mine.idverify.IdVerifyActivity;
import com.kingcar.rent.pro.ui.mine.order.OrderHomeActivity;

import butterknife.OnClick;

/**
 * @author chenweiji
 * @version Id: MineFragment.java, v 0.1 2019/1/3 11:01 chenweiji Exp $$
 */
public class MineFragment extends BaseFragment {
    @Override
    protected int getLayoutResId() {
        return R.layout.frag_mine;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void ui(int what, Message msg) {

    }

    @OnClick({R.id.iv_setting, R.id.iv_message, R.id.tv_coupon})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_setting:
                startActivity(new Intent(mActivity, SettingActivity.class));
                break;
            case R.id.iv_message:
                startActivity(new Intent(mActivity, MessageActivity.class));
                break;
            case R.id.tv_coupon:
                startActivity(new Intent(mActivity, CouponActivity.class));
                break;
            case R.id.rel_verify_id:
                startActivity(new Intent(mActivity, IdVerifyActivity.class));
                break;

            case R.id.tv_address:
                startActivity(new Intent(mActivity, AddressActivity.class));
                break;
            case R.id.ll_order:
                startActivity(new Intent(mActivity, OrderHomeActivity.class));
                break;

        }
    }
}