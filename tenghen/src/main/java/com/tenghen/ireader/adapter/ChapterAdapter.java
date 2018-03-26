package com.tenghen.ireader.adapter;

import android.content.Context;
import android.view.View;

import com.chengx.mvp.adapter.CommonRecyclerAdapter;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Chapter;
import com.tenghen.ireader.ui.activity.ReadActivity;

import java.util.List;

/**
 * Created by Administrator on 2018/2/4/004.
 */

public class ChapterAdapter extends CommonRecyclerAdapter<Chapter> {
    public ChapterAdapter(Context context, int layoutId, List<Chapter> data) {
        super(context, layoutId, data);
    }

    @Override
    public void convert(RecyclerViewHolder holder, final Chapter chapter) {
        holder.setText(R.id.chapterNameTv,chapter.getCname());
//        if (chapter.getIs_vip().equals("N")){
//            holder.setVisibility(R.id.vipTagView, View.VISIBLE);
//        }else {
//            holder.setVisibility(R.id.vipTagView, View.GONE);
//        }
        holder.setVisibility(R.id.vipTagView, View.GONE);
        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadActivity.launch(context,chapter.getBook_id(),chapter.getId());
            }
        });
    }
}
