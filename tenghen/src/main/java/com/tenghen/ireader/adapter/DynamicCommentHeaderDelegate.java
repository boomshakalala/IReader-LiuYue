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
public class DynamicCommentHeaderDelegate implements ItemViewDelegate<Object> {
    @Override
    public int getItemLayoutId() {
        return R.layout.item_dynamic_comment_header;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof ViewSupportModel;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {

    }
}
