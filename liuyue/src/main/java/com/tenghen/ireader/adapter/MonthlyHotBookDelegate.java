package com.tenghen.ireader.adapter;

import android.content.Context;
import android.view.View;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.chengx.mvp.utils.KLog;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.ui.activity.BookDetailActivity;

/**
 * 作者：chengx
 * 日期：2017/3/1
 * 描述：
 */

public class MonthlyHotBookDelegate implements ItemViewDelegate<Object> {

    Context context;

    public MonthlyHotBookDelegate(Context context) {
        this.context = context;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_monthly_rank;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        if (o instanceof Book){
            Book book = (Book) o;
            return book.isRank;
        }else {
            return false;
        }
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {
        final Book book = (Book) o;
        KLog.d("RANK",book);
        holder.setText(R.id.rankTv,book.getView_id());
        holder.setText(R.id.bookNameTv,book.getName());
        long clickSum = Long.valueOf(book.getAll_click());
        holder.setText(R.id.clickCountTv,clickSum/10000+"万人气");
        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookDetailActivity.launch(context,book.getId());
            }
        });
    }
}
