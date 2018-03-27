package com.tenghen.ireader.adapter;

import android.content.Context;

import com.chengx.mvp.adapter.CommonAdapter;
import com.chengx.mvp.adapter.ViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Comment;

import java.util.List;

public class ReplyAdapter extends CommonAdapter<Comment> {
    public ReplyAdapter(Context context, List<Comment> data, int itemLayoutId) {
        super(context, data, itemLayoutId);
    }

    @Override
    public void convert(ViewHolder holder, Comment comment) {
        holder.setText(R.id.replyNameTv,comment.getNickName()+":");
        holder.setText(R.id.replyContentTv,comment.getContent());
        holder.setText(R.id.replyTimeTv,comment.getCreateDate());
    }
}