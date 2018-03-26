package com.tenghen.ireader.adapter;

import android.content.Context;
import android.view.View;

import com.chengx.mvp.adapter.CommonRecyclerAdapter;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.module.BookDetail;
import com.tenghen.ireader.module.CategoryBook;
import com.tenghen.ireader.ui.activity.BookDetailActivity;

import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/2/28
 * 描述：
 */

public class BookTypeAdapter extends CommonRecyclerAdapter<CategoryBook> {
    public BookTypeAdapter(Context context, int layoutId, List<CategoryBook> data) {
        super(context, layoutId, data);
    }

    @Override
    public void convert(RecyclerViewHolder holder, final CategoryBook book) {
        holder.setImageUrl(R.id.bookIv,book.getCover());
        holder.setText(R.id.bookNameTv,book.getName());
        holder.setText(R.id.bookDescTv,book.getDescription());
        holder.setText(R.id.wordCountTv,book.getWord_count()+"字");
        holder.setText(R.id.clickCountTv,book.getAll_click()+"人次");
        holder.setText(R.id.authorNameTv,book.getPen_name());
        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookDetailActivity.launch(context,book.getId());
            }
        });
    }
}
