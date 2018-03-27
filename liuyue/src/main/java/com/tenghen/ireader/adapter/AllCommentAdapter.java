package com.tenghen.ireader.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.chengx.mvp.adapter.CommonRecyclerAdapter;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Comment;

import java.util.List;

/**
 * Created by chengx on 18-2-1.
 */

public class AllCommentAdapter extends CommonRecyclerAdapter<Comment> {
    public AllCommentAdapter(Context context, int layoutId, List<Comment> data) {
        super(context,layoutId, data);
    }

    @Override
    public void convert(RecyclerViewHolder holder, Comment comment) {
        holder.setText(R.id.contentTv,comment.getContent());
        holder.setText(R.id.nickNameTv,comment.getNickName());
        holder.setText(R.id.replyCountTv,comment.getFid());
        holder.setText(R.id.commentTimeTv,comment.getCreateDate());
        List<Comment> subComment = comment.getSub_comment();
        if (subComment != null&&subComment.size()>0) {
            holder.getView(R.id.replyLayout).setVisibility(View.VISIBLE);
            ListView listView = holder.getView(R.id.listReply);
            ReplyAdapter adapter = new ReplyAdapter(context,subComment,R.layout.item_reply);
            listView.setAdapter(adapter);
        }else {
            holder.getView(R.id.replyLayout).setVisibility(View.GONE);
        }
    }
}
