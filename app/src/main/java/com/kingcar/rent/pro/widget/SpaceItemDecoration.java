package com.kingcar.rent.pro.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.kingcar.rent.pro.utils.jutils.JUtils;

/**
 * Created by cwj on 2018/3/16.
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int space;
    public SpaceItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = JUtils.dip2px(space);
    }
}
