package com.kingcar.rent.pro.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.BaseActivity;
import com.kingcar.rent.pro.ui.login.ForgotPwdActivity;
import com.kingcar.rent.pro.ui.login.LoginActivity;
import com.kingcar.rent.pro.ui.login.LoginByPwdActivity;
import com.kingcar.rent.pro.ui.login.RegisterActivity;

import static android.widget.CompoundButton.*;

public class MainActivity extends BaseActivity implements OnCheckedChangeListener {

    @Bind(android.R.id.tabcontent)
    FrameLayout tabcontent;
    @Bind(android.R.id.tabs)
    TabWidget tabs;
    @Bind(R.id.main_tab_first)
    RadioButton mainTabFirst;
    @Bind(R.id.main_tab_first_unread_tv)
    TextView mainTabFirstUnreadTv;
    @Bind(R.id.main_tab_second)
    RadioButton mainTabSecond;
    @Bind(R.id.main_tab_second_unread_tv)
    TextView mainTabSecondUnreadTv;
    @Bind(R.id.main_tab_three)
    RadioButton mainTabThree;
    @Bind(R.id.main_tab_three_prospect_tv)
    TextView mainTabThreeProspectTv;
    @Bind(R.id.main_tab_four)
    RadioButton mainTabFour;
    @Bind(R.id.main_tab_four_new_tv)
    TextView mainTabFourNewTv;
    @Bind(R.id.main_tab_five)
    RadioButton mainTabFive;
    @Bind(R.id.main_tab_group)
    LinearLayout mainTabGroup;
    @Bind(android.R.id.tabhost)
    TabHost tabHost;

    private Intent firstIntent;
    private Intent secondIntent;
    private Intent thirdIntent;
    private Intent fourthIntent;
    private Intent fifthIntent;

    private int mState = 0;

    @Override
    protected int getLayoutResId() {
        return R.layout.act_main;
    }

    @Override
    protected void init() {
        tabHost.setup();

        firstIntent = new Intent(this, LoginActivity.class);
        secondIntent = new Intent(this, LoginByPwdActivity.class);
        thirdIntent = new Intent(this, RegisterActivity.class);
        fourthIntent = new Intent(this, ForgotPwdActivity.class);
        fifthIntent = new Intent(this, LoginActivity.class);

        tabHost.addTab(tabHost.newTabSpec("first").setIndicator("first").setContent(firstIntent));
        tabHost.addTab(tabHost.newTabSpec("second").setIndicator("second").setContent(secondIntent));
        tabHost.addTab(tabHost.newTabSpec("third").setIndicator("third").setContent(thirdIntent));
        tabHost.addTab(tabHost.newTabSpec("fourth").setIndicator("fourth").setContent(fourthIntent));
        tabHost.addTab(tabHost.newTabSpec("fifth").setIndicator("fifth").setContent(fifthIntent));


        mainTabFirst.setOnCheckedChangeListener(this);
        mainTabSecond.setOnCheckedChangeListener(this);
        mainTabThree.setOnCheckedChangeListener(this);
        mainTabFour.setOnCheckedChangeListener(this);
        mainTabFive.setOnCheckedChangeListener(this);

    }

    public void setCurrentTab(int index) {
        switchState(index);
    }

    private void switchState(int state) {
        if (mState == state) {
            return;
        }

        mState = state;
        mainTabFirst.setChecked(false);
        mainTabSecond.setChecked(false);
        mainTabThree.setChecked(false);
        mainTabFour.setChecked(false);
        mainTabFive.setChecked(false);

        switch (mState) {
            case 0:
                mainTabFirst.setChecked(true);
                tabHost.setCurrentTabByTag("first");
                break;

            case 1:
                mainTabSecond.setChecked(true);
                tabHost.setCurrentTabByTag("second");
                break;

            case 2:
                mainTabThree.setChecked(true);
                tabHost.setCurrentTabByTag("third");
                break;

            case 3:
                mainTabFour.setChecked(true);
                tabHost.setCurrentTabByTag("fourth");
                break;

            case 4:
                mainTabFive.setChecked(true);
                tabHost.setCurrentTabByTag("fifth");
                break;

            default:
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            switch (buttonView.getId()) {
                case R.id.main_tab_first:
                    switchState(0);
                    break;
                case R.id.main_tab_second:
                    switchState(1);
                    break;
                case R.id.main_tab_three:
                    switchState(2);
                    break;
                case R.id.main_tab_four:
                    switchState(3);
                    break;
                case R.id.main_tab_five:
                    switchState(4);
                    break;

                default:
                    break;
            }
        }
    }
}
