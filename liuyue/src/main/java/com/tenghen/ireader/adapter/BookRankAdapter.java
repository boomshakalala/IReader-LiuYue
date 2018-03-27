package com.tenghen.ireader.adapter;

import android.content.Context;
import android.view.View;

import com.chengx.mvp.adapter.CommonRecyclerAdapter;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.module.RankBook;
import com.tenghen.ireader.ui.activity.BookDetailActivity;

import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/2/28
 * 描述：
 */

public class BookRankAdapter extends CommonRecyclerAdapter<RankBook> {
    public BookRankAdapter(Context context, int layoutId, List<RankBook> data) {
        super(context, layoutId, data);
    }

    @Override
    public void convert(RecyclerViewHolder holder, final RankBook book) {
        holder.setImageUrl(R.id.bookIv,book.getCover());
        holder.setText(R.id.bookNameTv,book.getView_id()+"."+book.getName());
        holder.setText(R.id.bookDescTv,book.getDescription());
        holder.setText(R.id.authorNameTv,book.getPen_name());
        holder.setText(R.id.categoryNameTv,book.getCategory_name());
        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookDetailActivity.launch(context, book.getId());
            }
        });

    }
}
