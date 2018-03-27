package com.tenghen.ireader.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chengx.mvp.adapter.CommonRecyclerAdapter;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.chengx.mvp.utils.KLog;
import com.chengx.mvp.widget.auto.AutoHorizontalScrollView;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.module.Chapter;
import com.tenghen.ireader.module.Cost;
import com.tenghen.ireader.ui.activity.BookDetailActivity;
import com.tenghen.ireader.ui.activity.ReadActivity;

import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class CostLogAdapter extends CommonRecyclerAdapter<Cost> {
    public CostLogAdapter(Context context, int layoutId, List<Cost> data) {
        super(context, layoutId, data);
    }

    @Override
    public void convert(RecyclerViewHolder holder, Cost cost) {
        final Book book = cost.getBook();
        Chapter chapter = cost.getChapter();
        holder.setImageUrl(R.id.bookIv,book.getCover());
        holder.setText(R.id.bookNameTv,book.getName());
        holder.setText(R.id.cNameTv,"订阅"+chapter.getCname());
        holder.setText(R.id.costTv,"于"+cost.getCreate_date()+" "+cost.getCreate_time()+" 花费 "+cost.getPrice()+"腾币");
        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookDetailActivity.launch(context,book.getId());
            }
        });

        TextView textView = holder.getView(R.id.costTv);
        textView.setText("于"+cost.getCreate_date()+" "+cost.getCreate_time()+" 花费 "+cost.getPrice()+"腾币");
        final ImageView imageView = holder.getView(R.id.bookIv);
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                KLog.d("size",imageView.getHeight());
            }
        });
    }
}
