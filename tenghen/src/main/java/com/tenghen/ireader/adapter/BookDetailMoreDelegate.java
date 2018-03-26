package com.tenghen.ireader.adapter;

import android.content.Context;
import android.view.View;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Label;
import com.tenghen.ireader.ui.activity.MoreCommentActivity;
import com.tenghen.ireader.ui.activity.MoreGiftActivity;

/**
 * 作者：chengx
 * 日期：2017/3/7
 * 描述：
 */

public class BookDetailMoreDelegate implements ItemViewDelegate<Object> {

    private Context context;

    public BookDetailMoreDelegate(Context context) {
        this.context = context;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_book_detail_more;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof Label && ((Label)o).getCategory() == Label.BOOK_DETAIL_MORE;
    }

    @Override
    public void convert(RecyclerViewHolder holder, final Object o, int position) {
        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            final Label label = (Label) o;
            @Override
            public void onClick(View v) {
                switch (label.getTag()){
                    case 2:
                        MoreCommentActivity.launch(context,label.getId());
                        break;
                    case 1:
                        MoreGiftActivity.launch(context,label.getId());
                        break;
                }
            }
        });

    }
}
