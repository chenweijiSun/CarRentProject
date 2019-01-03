package com.kingcar.rent.pro.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.adapter.base.BaseHoler;
import com.kingcar.rent.pro.adapter.base.CWJBaseAdapter;
import com.kingcar.rent.pro.model.entity.CarSourceInfo;

public class CarSourceAdapter extends CWJBaseAdapter<CarSourceInfo, CarSourceAdapter.ViewHolder> {

    public CarSourceAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder bindHoler() {
        return new ViewHolder();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.item_car_source;
    }

    @Override
    public void bindData(ViewHolder holder, int position, CarSourceInfo item) {
        CarSourceInfo info = getItem(position);
        String word = info.getHeaderWord();
        holder.tv_word.setText(word);
        holder.tv_name.setText(info.getName());
        //将相同字母开头的合并在一起
        if (position == 0) {
            //第一个是一定显示的
            holder.tv_word.setVisibility(View.VISIBLE);
        } else {
            //后一个与前一个对比,判断首字母是否相同，相同则隐藏
            String headerWord = getItem(position - 1).getHeaderWord();
            if (word.equals(headerWord)) {
                holder.tv_word.setVisibility(View.GONE);
            } else {
                holder.tv_word.setVisibility(View.VISIBLE);
            }
        }
    }

    static class ViewHolder extends BaseHoler {
        @Bind(R.id.tv_word)
        TextView tv_word;
        @Bind(R.id.tv_name)
        TextView tv_name;

    }
}
