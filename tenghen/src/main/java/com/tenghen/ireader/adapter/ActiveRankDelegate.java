package com.tenghen.ireader.adapter;


import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Book;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class ActiveRankDelegate implements ItemViewDelegate<Object> {
    @Override
    public int getItemLayoutId() {
        return R.layout.item_rank_active;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof Book;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {

    }
}
