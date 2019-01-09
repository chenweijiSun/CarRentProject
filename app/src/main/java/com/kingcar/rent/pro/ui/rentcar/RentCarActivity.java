package com.kingcar.rent.pro.ui.rentcar;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.base.BaseFragment;
import com.kingcar.rent.pro.base.ToolBarActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class RentCarActivity extends ToolBarActivity {

    @Bind(R.id.tablayout)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager viewPager;

    private FmPagerAdapter pagerAdapter;
    private ArrayList<BaseFragment> fragments = new ArrayList<>();
    private String[] titles = new String[]{"分时租","普通租","闲时租","商务租","婚庆租","王者代驾"};

    @Override
    protected int getLayoutResId() {
        return R.layout.act_rent_car;
    }

    @Override
    protected void init() {
        initTitleAndCanBack("一键租车");

        fragments.add(new FenShiZuFragment());
        tabLayout.addTab(tabLayout.newTab());

        fragments.add(new XianShiZuFragment());
        tabLayout.addTab(tabLayout.newTab());

        fragments.add(new ShangWuZuFragment());
        tabLayout.addTab(tabLayout.newTab());

        fragments.add(new ShangWuZuFragment());
        tabLayout.addTab(tabLayout.newTab());

        fragments.add(new HunQinZuFragment());
        tabLayout.addTab(tabLayout.newTab());

        fragments.add(new DaiJiaFragment());
        tabLayout.addTab(tabLayout.newTab());


        tabLayout.setupWithViewPager(viewPager,false);
        pagerAdapter = new FmPagerAdapter(fragments,getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        for(int i=0;i<titles.length;i++){
            tabLayout.getTabAt(i).setText(titles[i]);
        }
    }




    class FmPagerAdapter extends FragmentPagerAdapter {
        private List<BaseFragment> fragmentList;

        public FmPagerAdapter(List<BaseFragment> fragmentList, FragmentManager fm) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public int getCount() {
            return fragmentList != null && !fragmentList.isEmpty() ? fragmentList.size() : 0;
        }

        @Override
        public BaseFragment getItem(int position) {
            return fragmentList.get(position);
        }
    }
}
