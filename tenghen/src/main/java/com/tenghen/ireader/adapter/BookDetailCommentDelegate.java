package com.tenghen.ireader.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Comment;
import com.tenghen.ireader.widget.CommentDialog;

import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/3/7
 * 描述：
 */

public class BookDetailCommentDelegate implements ItemViewDelegate<Object> {
    Context context;
    String bookId;

    public BookDetailCommentDelegate(Context context,String bookId) {
        this.context = context;
        this.bookId = bookId;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_book_detail_comment;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof Comment;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {
        final Comment comment = (Comment) o;
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
        holder.setOnclickListener(R.id.replyBtn, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CommentDialog(context,bookId,comment.getId()).show();
            }
        });
    }
}
