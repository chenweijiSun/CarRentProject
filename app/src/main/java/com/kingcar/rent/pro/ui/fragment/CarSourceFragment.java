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
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.kingcar.rent.pro.Constant;
import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.adapter.CarSourceAdapter;
import com.kingcar.rent.pro.base.BaseFragment;
import com.kingcar.rent.pro.model.entity.CarSourceInfo;
import com.kingcar.rent.pro.ui.carsource.CarSourceListActivity;
import com.kingcar.rent.pro.widget.WordsNavigation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 车源
 *
 * @author chenweiji
 * @version Id: CarSourceFragment.java, v 0.1 2019/1/3 10:20 chenweiji Exp $$
 */
public class CarSourceFragment extends BaseFragment implements
        WordsNavigation.onWordsChangeListener, AbsListView.OnScrollListener {

    @Bind(R.id.listView)
    ListView listView;
    @Bind(R.id.words_nav_view)
    WordsNavigation wordsNavView;
    @Bind(R.id.tv_words_nav)
    TextView tvWordsNav;

    private List<CarSourceInfo> list;


    @Override
    protected int getLayoutResId() {
        return R.layout.frag_car_source;
    }

    @Override
    protected void init() {
        //初始化数据
        initData();
        //初始化列表
        initListView();

        //设置列表点击滑动监听
        wordsNavView.setOnWordsChangeListener(this);
    }

    private void initListView() {
        CarSourceAdapter adapter = new CarSourceAdapter(mActivity);
        adapter.setData(list);
        listView.setAdapter(adapter);
        listView.setOnScrollListener(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(mActivity,CarSourceListActivity.class));
            }
        });
    }

    @Override
    protected void ui(int what, Message msg) {

    }

    /**
     * 初始化联系人列表信息
     */
    private void initData() {
        list = new ArrayList<>();
        List<CarSourceInfo> usuallyInfos=new ArrayList<>();
        usuallyInfos.add(new CarSourceInfo("Dave"));
        usuallyInfos.add(new CarSourceInfo("张晓飞"));
        usuallyInfos.add(new CarSourceInfo("杨光福"));
        usuallyInfos.add(new CarSourceInfo("阿钟"));
        usuallyInfos.add(new CarSourceInfo("胡继群"));
        list.add(new CarSourceInfo("常用","0",Constant.LOG_STAR,usuallyInfos));
        list.add(new CarSourceInfo("Dave"));
        list.add(new CarSourceInfo("张晓飞"));
        list.add(new CarSourceInfo("杨光福"));
        list.add(new CarSourceInfo("阿钟"));
        list.add(new CarSourceInfo("胡继群"));
        list.add(new CarSourceInfo("徐歌阳"));
        list.add(new CarSourceInfo("钟泽兴"));
        list.add(new CarSourceInfo("宋某人"));
        list.add(new CarSourceInfo("刘某人"));
        list.add(new CarSourceInfo("Tony"));
        list.add(new CarSourceInfo("老刘"));
        list.add(new CarSourceInfo("隔壁老王"));
        list.add(new CarSourceInfo("安传鑫"));
        list.add(new CarSourceInfo("温松"));
        list.add(new CarSourceInfo("成龙"));
        list.add(new CarSourceInfo("那英"));
        list.add(new CarSourceInfo("刘甫"));
        list.add(new CarSourceInfo("沙宝亮"));
        list.add(new CarSourceInfo("张猛"));
        list.add(new CarSourceInfo("张大爷"));
        list.add(new CarSourceInfo("张哥"));
        list.add(new CarSourceInfo("张娃子"));
        list.add(new CarSourceInfo("樟脑丸"));
        list.add(new CarSourceInfo("吴亮"));
        list.add(new CarSourceInfo("Tom"));
        list.add(new CarSourceInfo("阿三"));
        list.add(new CarSourceInfo("肖奈"));
        list.add(new CarSourceInfo("贝微微"));
        list.add(new CarSourceInfo("赵二喜"));
        list.add(new CarSourceInfo("曹光"));
        list.add(new CarSourceInfo("姜宇航"));

        //对集合排序
        Collections.sort(list, new Comparator<CarSourceInfo>() {
            @Override
            public int compare(CarSourceInfo lhs, CarSourceInfo rhs) {
                //根据拼音进行排序
                return lhs.getPinyin().compareTo(rhs.getPinyin());
            }
        });
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        //当滑动列表的时候，更新右侧字母列表的选中状态
        wordsNavView.setTouchIndex(list.get(firstVisibleItem).getHeaderWord());
    }

    @Override
    public void wordsChange(String words) {
        updateWord(words);
        updateListView(words);
    }

    /**
     * @param words 首字母
     */
    private void updateListView(String words) {
        for (int i = 0; i < list.size(); i++) {
            String headerWord = list.get(i).getHeaderWord();
            //将手指按下的字母与列表中相同字母开头的项找出来
            if (words.equals(headerWord)) {
                //将列表选中哪一个
                listView.setSelection(i);
                //找到开头的一个即可
                return;
            }
        }
    }

    /**
     * 更新中央的字母提示
     *
     * @param words 首字母
     */
    private void updateWord(String words) {
        tvWordsNav.setText(words);
        tvWordsNav.setVisibility(View.VISIBLE);
        //清空之前的所有消息
        mHandler.removeCallbacksAndMessages(null);
        //1s后让tv隐藏
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tvWordsNav.setVisibility(View.GONE);
            }
        }, 500);
    }

}