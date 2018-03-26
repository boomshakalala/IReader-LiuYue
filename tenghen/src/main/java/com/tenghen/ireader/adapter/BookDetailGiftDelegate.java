package com.tenghen.ireader.adapter;

import android.content.ClipData;
import android.view.View;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Gift;

import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/3/7
 * 描述：
 */

public class BookDetailGiftDelegate implements ItemViewDelegate<Object> {
    public OnGiftClickListener onGiftClickListener;


    public void setOnGiftClickListener(OnGiftClickListener onGiftClickListener) {
        this.onGiftClickListener = onGiftClickListener;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_book_detail_gift;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof Gift;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, final int position) {
        final Gift gift = (Gift) o;
        holder.setImageResource(R.id.giftIv,gift.getGiftImage());
        if (gift.isChecked){
            holder.setVisibility(R.id.checkbox, View.VISIBLE);
        }else {
            holder.setVisibility(R.id.checkbox, View.GONE);
        }
        holder.setOnclickListener(R.id.checkBtn,new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onGiftClickListener!=null){
                    onGiftClickListener.onGiftClick(gift,position);
                }
            }
        });
    }

    public interface OnGiftClickListener{
        void onGiftClick(Gift gift,int position);
    }
}
