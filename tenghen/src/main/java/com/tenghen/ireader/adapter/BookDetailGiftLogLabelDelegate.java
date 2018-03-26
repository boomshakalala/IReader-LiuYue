package com.tenghen.ireader.adapter;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Comment;
import com.tenghen.ireader.module.Label;

/**
 * 作者：chengx
 * 日期：2017/3/7
 * 描述：
 */

public class BookDetailGiftLogLabelDelegate implements ItemViewDelegate<Object> {
    @Override
    public int getItemLayoutId() {
        return R.layout.item_book_detail_gift_log_label;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof Label && ((Label)o).getCategory() == Label.BOOK_DETAIL_GIFT_LOG;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {

    }
}
