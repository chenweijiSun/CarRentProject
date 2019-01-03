package com.kingcar.rent.pro.adapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.kingcar.rent.pro.Constant;
import com.kingcar.rent.pro.R;
import com.kingcar.rent.pro.adapter.base.BaseHoler;
import com.kingcar.rent.pro.adapter.base.CWJBaseAdapter;
import com.kingcar.rent.pro.model.entity.CarSourceInfo;
import com.kingcar.rent.pro.widget.MyGridView;
import com.kingcar.rent.pro.widget.MyListView;

public class CarSourceAdapter extends CWJBaseAdapter<CarSourceInfo, CarSourceAdapter.ViewHolder> {

    private CarSourceUsuallyAdapter adapter;
    public CarSourceAdapter(Context context) {
        super(context);
        adapter=new CarSourceUsuallyAdapter(context);
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
        if (Constant.LOG_STAR.equals(word)){
            if(info.getUsuallyInfo()!=null){
                holder.tv_word.setText(Constant.LOG_STAR+"常用");
                holder.ll_name.setVisibility(View.GONE);
                holder.line.setVisibility(View.GONE);
                holder.gridView.setVisibility(View.VISIBLE);
                if(holder.gridView.getAdapter()==null){
                    holder.gridView.setAdapter(adapter);
                }
                adapter.setData(info.getUsuallyInfo());
            }

        }else{
            holder.gridView.setVisibility(View.GONE);
            holder.ll_name.setVisibility(View.VISIBLE);
            holder.line.setVisibility(View.VISIBLE);
        }
    }

    class ViewHolder extends BaseHoler {
        @Bind(R.id.tv_word)
        TextView tv_word;
        @Bind(R.id.tv_name)
        TextView tv_name;
        @Bind(R.id.gridView)
        MyGridView gridView;
        @Bind(R.id.view_line)
        View line;
        @Bind(R.id.ll_name)
        LinearLayout ll_name;

    }
}
