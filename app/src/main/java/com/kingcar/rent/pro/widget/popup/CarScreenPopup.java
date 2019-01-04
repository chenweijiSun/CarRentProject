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
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import com.kingcar.rent.pro.R;
import razerdp.basepopup.BasePopupWindow;
import razerdp.util.SimpleAnimationUtils;

/**
 *
 * @author chenweiji
 * @version Id: CarScreenPopup.java, v 0.1 2019/1/4 14:12 chenweiji Exp $$
 */
public class CarScreenPopup extends BasePopupWindow {
    public CarScreenPopup(Context context) {
        super(context);

        setAdjustInputMethod(false, WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
        //设置Popup上方不需要背景下方需要的场景
        setAlignBackground(true);
        setAlignBackgroundGravity(Gravity.TOP);
    }

    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.popup_car_screen);
    }


    @Override
    protected Animation onCreateShowAnimation() {
        return SimpleAnimationUtils.getTranslateVerticalAnimation(-1f, 0, 300);
    }

    @Override
    protected Animation onCreateDismissAnimation() {
        return SimpleAnimationUtils.getTranslateVerticalAnimation(0, -1f, 300);
    }
}