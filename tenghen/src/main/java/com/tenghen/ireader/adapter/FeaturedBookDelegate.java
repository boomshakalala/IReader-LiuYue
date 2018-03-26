package com.tenghen.ireader.adapter;

import android.content.Context;
import android.view.View;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.module.BookDetail;
import com.tenghen.ireader.ui.activity.BookDetailActivity;

/**
 * 作者：chengx
 * 日期：2017/2/24
 * 描述：
 */

public class FeaturedBookDelegate implements ItemViewDelegate<Object> {
    Context context;

    public FeaturedBookDelegate(Context context) {
        this.context = context;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_book;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        if (o instanceof  Book){
            Book book = (Book) o;
            return !book.isRec&&!book.isRank;
        }
        return false;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {
        final Book book = (Book) o;
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
