package com.tenghen.ireader.adapter;

import android.content.Context;
import android.view.View;

import com.chengx.mvp.adapter.CommonRecyclerAdapter;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.ui.activity.BookDetailActivity;

import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/2/27
 * 描述：
 */

public class HotBookAdapter extends CommonRecyclerAdapter<Book> {
    public HotBookAdapter(Context context, int layoutId, List<Book> data) {
        super(context, layoutId, data);
    }

    @Override
    public void convert(RecyclerViewHolder holder, final Book book) {
        holder.setText(R.id.bookNameTv,book.getName());
        holder.setImageUrl(R.id.bookIv,book.getCover());
        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookDetailActivity.launch(context,book.getId());
            }
        });
    }
}
