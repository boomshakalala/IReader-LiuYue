package com.tenghen.ireader.adapter;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.GiftLog;

/**
 * 作者：chengx
 * 日期：2017/3/7
 * 描述：
 */

public class BookDetailGiftLogDelegate implements ItemViewDelegate<Object>{
    int[] giftImages = {R.drawable.ic_gift_coin,R.drawable.ic_gift_flower,R.drawable.ic_gift_beer,R.drawable.ic_gift_mac,
            R.drawable.ic_gift_car,R.drawable.ic_gif_house};
    @Override
    public int getItemLayoutId() {
        return R.layout.item_book_detail_gift_log;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof GiftLog;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {
        GiftLog giftLog = (GiftLog) o;
        holder.setText(R.id.nickNameTv,giftLog.getUserName());
        holder.setText(R.id.giftCountTv,1+"个");
        holder.setImageResource(R.id.giftIv,giftImages[5-3]);
    }
}
