package com.kingcar.rent.pro.ui;

import android.os.Bundle;
import android.widget.*;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.BaseActivity;

import static android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends BaseActivity implements OnCheckedChangeListener {


    @Bind(R.id.fra_content)
    FrameLayout fraContent;
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
    private int mState = 0;

    @Override
    protected int getLayoutResId() {
        return R.layout.act_main;
    }

    @Override
    protected void init() {

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
                break;

            case 1:
                mainTabSecond.setChecked(true);
                break;

            case 2:
                mainTabThree.setChecked(true);
                break;

            case 3:
                mainTabFour.setChecked(true);
                break;

            case 4:
                mainTabFive.setChecked(true);
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
