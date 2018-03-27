package com.tenghen.ireader.adapter;

import android.content.Context;

import com.chengx.mvp.adapter.CommonRecyclerAdapter;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Comment;
import com.tenghen.ireader.module.MyCommentBean;
import com.tenghen.ireader.module.ParentComment;

import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class MyCommentAdapter extends CommonRecyclerAdapter<MyCommentBean> {
    public MyCommentAdapter(Context context, int layoutId, List<MyCommentBean> data) {
        super(context, layoutId, data);
    }

    @Override
    public void convert(RecyclerViewHolder holder, MyCommentBean comment) {
        ParentComment com = comment.getParent_comment();
        if (com == null)
            holder.setText(R.id.nickNameTv,comment.getNick_name()+" 评论 ");
        else
            holder.setText(R.id.nickNameTv,comment.getNick_name()+" 回复我 ");
        if (com == null)
            holder.setText(R.id.bookNameTv,comment.getBook().getName());
        else
            holder.setText(R.id.bookNameTv,com.getContent());
        holder.setText(R.id.contentTv,comment.getContent());
        holder.setText(R.id.dateTv,comment.getCreate_date());
    }
}
