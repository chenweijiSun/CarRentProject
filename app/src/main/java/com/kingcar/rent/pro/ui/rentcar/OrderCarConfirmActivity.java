package com.kingcar.rent.pro.ui.rentcar;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.ToolBarActivity;
import com.kingcar.rent.pro.widget.popup.rentcar.OrderCarSuccPopup;

import butterknife.OnClick;

public class OrderCarConfirmActivity extends ToolBarActivity {
    OrderCarSuccPopup orderCarSuccPopup;
    @Override
    protected int getLayoutResId() {
        return R.layout.act_order_car_confirm;
    }

    @Override
    protected void init() {

        initTitleAndCanBack("预约門店自提");
        orderCarSuccPopup=new OrderCarSuccPopup(this);

    }

    @OnClick(R.id.btn_sure)
    public void onClick() {
        orderCarSuccPopup.showPopupWindow();
    }
}
