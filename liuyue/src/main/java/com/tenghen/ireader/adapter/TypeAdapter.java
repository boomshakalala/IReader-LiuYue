package com.tenghen.ireader.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.chengx.mvp.adapter.CommonRecyclerAdapter;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Type;

import java.util.List;

/**
 * 作者: 陈冠希
 * 日期: 2018/3/29
 * 描述:
 */

public class TypeAdapter extends CommonRecyclerAdapter<Type> {

    public TypeAdapter(Context context, int layoutId, List<Type> data) {
        super(context, layoutId, data);
    }

    @Override
    public void convert(RecyclerViewHolder holder, Type type) {
        holder.setText(R.id.typeTv,type.getText());
        holder.getView(R.id.typeTv).setSelected(type.isSelected());
    }
}
