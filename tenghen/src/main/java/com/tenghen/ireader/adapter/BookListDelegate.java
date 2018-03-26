package com.tenghen.ireader.adapter;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.BookList;

/**
 * 作者：chengx
 * 日期：2017/3/1
 * 描述：
 */

public class BookListDelegate implements ItemViewDelegate<Object> {
    @Override
    public int getItemLayoutId() {
        return R.layout.item_free_book_list;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof BookList;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {

    }
}
