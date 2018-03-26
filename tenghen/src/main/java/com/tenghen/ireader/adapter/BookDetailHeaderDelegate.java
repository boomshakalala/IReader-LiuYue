package com.tenghen.ireader.adapter;

import android.content.Context;
import android.view.View;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.google.android.gms.common.api.Api;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.BookDetail;
import com.tenghen.ireader.module.BookDetailHeader;
import com.tenghen.ireader.module.UserRecord;
import com.tenghen.ireader.ui.activity.ChapterListActivity;
import com.tenghen.ireader.ui.activity.ReadActivity;

import java.io.BufferedOutputStream;

/**
 * 作者：chengx
 * 日期：2017/3/7
 * 描述：
 */

public class BookDetailHeaderDelegate implements ItemViewDelegate<Object> {
    private Context context;

    public BookDetailHeaderDelegate(Context context) {
        this.context = context;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_book_detail_header;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof BookDetailHeader;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {
        final BookDetailHeader book = (BookDetailHeader) o;
        holder.setText(R.id.bookNameTv,book.getName());
        holder.setText(R.id.authorNameTv,book.getPenName());
        holder.setText(R.id.wordCountTv,book.getWordCount());
        holder.setText(R.id.priceTv,book.getWordCount());
        UserRecord record = book.getUserRecord();
        String  lastCommonChapterName;
        final String chapterId;
        if (record != null) {
            lastCommonChapterName = record.cname;
            if (lastCommonChapterName.isEmpty()){
                holder.setText(R.id.lastReadChapterTv,lastCommonChapterName);
                holder.setText(R.id.readBookBtn,"开始阅读");
                chapterId = book.getFirstChapterId();
            }else {
                holder.setText(R.id.lastReadChapterTv,lastCommonChapterName);
                holder.setText(R.id.readBookBtn,"继续阅读");
                chapterId = record.id;
            }
        }else {
            lastCommonChapterName = "暂未阅读,开始吧";
            holder.setText(R.id.lastReadChapterTv,lastCommonChapterName);
            holder.setText(R.id.readBookBtn,"开始阅读");
            chapterId = book.getFirstChapterId();
        }

        holder.setText(R.id.bookDescTv,book.getDescription());
        String bookStatus = "";
        if (book.getIsFinish().equals("Y")){
            bookStatus = "已完结";
        }else{
            bookStatus = "连载中";
        }
        holder.setText(R.id.bookStatusTv,bookStatus);
        holder.setText(R.id.lastUpdateChapterTv,book.getLastUpdateChapterName());
        holder.setImageUrl(R.id.bookIv,book.getCover());
        holder.setOnclickListener(R.id.readBookBtn, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReadActivity.launch(context,book.getId(), chapterId );
            }
        });
        holder.setOnclickListener(R.id.chapterListBtn, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChapterListActivity.launch(context,book.getId());
            }
        });
    }
}
