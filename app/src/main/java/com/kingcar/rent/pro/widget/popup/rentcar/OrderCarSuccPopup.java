package com.kingcar.rent.pro.widget.popup.rentcar;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;

import com.kingcar.rent.pro.R;

import razerdp.basepopup.BasePopupWindow;
import razerdp.util.SimpleAnimationUtils;

public class OrderCarSuccPopup extends BasePopupWindow {

    public OrderCarSuccPopup(Context context) {
        super(context);

        setPopupGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        //模糊背景
        setBlurBackgroundEnable(true);
    }

    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.popup_order_car_succ);
    }

    @Override
    protected Animation onCreateShowAnimation() {
        return SimpleAnimationUtils.getTranslateVerticalAnimation(1f, 0, 500);
    }

    @Override
    protected Animation onCreateDismissAnimation() {
        return SimpleAnimationUtils.getTranslateVerticalAnimation(0, 1f, 500);
    }

}