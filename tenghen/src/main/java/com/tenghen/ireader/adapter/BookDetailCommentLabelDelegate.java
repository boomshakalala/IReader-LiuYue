package com.tenghen.ireader.adapter;

import android.content.Context;
import android.view.View;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Label;
import com.tenghen.ireader.widget.CommentDialog;

/**
 * 作者：chengx
 * 日期：2017/3/7
 * 描述：
 */

public class BookDetailCommentLabelDelegate implements ItemViewDelegate<Object> {
    private Context context;

    public BookDetailCommentLabelDelegate(Context context) {
        this.context = context;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_book_detail_comment_label;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof Label && ((Label)o).getCategory() == Label.BOOK_DETAIL_COMMENT;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {
        final Label commentLabel = (Label) o;
        holder.setOnclickListener(R.id.commentBtn, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CommentDialog(context,commentLabel.getId(),"").show();
            }
        });
    }
}
