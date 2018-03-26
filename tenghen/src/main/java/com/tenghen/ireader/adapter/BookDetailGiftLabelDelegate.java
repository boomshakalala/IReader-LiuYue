package com.tenghen.ireader.adapter;

import android.content.ClipData;
import android.content.IntentFilter;
import android.view.View;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Label;

/**
 * 作者：chengx
 * 日期：2017/3/7
 * 描述：
 */

public class BookDetailGiftLabelDelegate implements ItemViewDelegate<Object> {
    public OnSendGiftListener onSendGiftListener;

    public void setOnSendGiftListener(OnSendGiftListener onSendGiftListener) {
        this.onSendGiftListener = onSendGiftListener;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_book_detail_gift_label;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof Label && ((Label)o).getCategory() == Label.BOOK_DETAIL_GIFT;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {
            Label label = (Label) o;
        holder.setText(R.id.giftCountTv,label.getText());
        holder.setOnclickListener(R.id.giftBtn, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSendGiftListener!=null){
                    onSendGiftListener.sendGift();
                }
            }
        });
    }

    public interface OnSendGiftListener{
        void sendGift();
    }
}
