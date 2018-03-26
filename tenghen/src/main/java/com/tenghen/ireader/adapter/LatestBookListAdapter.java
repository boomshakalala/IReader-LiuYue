package com.tenghen.ireader.adapter;

import android.content.Context;
import android.view.View;

import com.chengx.mvp.adapter.CommonRecyclerAdapter;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.module.LatestBook;
import com.tenghen.ireader.ui.activity.ReadActivity;

import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class LatestBookListAdapter extends CommonRecyclerAdapter<LatestBook> {
    public LatestBookListAdapter(Context context, int layoutId, List<LatestBook> data) {
        super(context, layoutId, data);
    }

    @Override
    public void convert(RecyclerViewHolder holder, final LatestBook latestBook) {
        holder.setImageUrl(R.id.bookIv,latestBook.getBook_cover());
        holder.setText(R.id.bookNameTv,latestBook.getPen_name());
        holder.setText(R.id.readTimeTv,latestBook.getCreate_date());
        holder.setOnclickListener(R.id.readBtn, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadActivity.launch(context,latestBook.getBook_id(),latestBook.getChapter_id());
            }
        });

        holder.setOnclickListener(R.id.delBtn, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2018/1/31/031 删除逻辑

            }
        });
    }
}
