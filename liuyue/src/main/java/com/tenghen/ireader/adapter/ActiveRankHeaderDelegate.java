package com.tenghen.ireader.adapter;


import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.ActiveRank;
import com.tenghen.ireader.module.Book;

import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class ActiveRankHeaderDelegate implements ItemViewDelegate<Object> {
    @Override
    public int getItemLayoutId() {
        return R.layout.item_rank_active_header;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof ActiveRank;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {

    }
}
