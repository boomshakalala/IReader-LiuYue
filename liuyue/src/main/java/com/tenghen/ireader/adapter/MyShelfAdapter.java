package com.tenghen.ireader.adapter;

import android.content.Context;

import com.chengx.mvp.adapter.CommonRecyclerAdapter;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Book;

import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class MyShelfAdapter extends CommonRecyclerAdapter<Book> {
    public MyShelfAdapter(Context context, int layoutId, List<Book> data) {
        super(context, layoutId, data);
    }

    @Override
    public void convert(RecyclerViewHolder holder, Book book) {
        holder.setText(R.id.bookNameTv,book.getName());
        holder.setImageUrl(R.id.bookIv,book.getCover());
    }
}
