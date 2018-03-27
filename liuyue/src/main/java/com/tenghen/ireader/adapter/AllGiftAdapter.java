package com.tenghen.ireader.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.chengx.mvp.adapter.CommonRecyclerAdapter;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Comment;
import com.tenghen.ireader.module.Gift;
import com.tenghen.ireader.module.GiftLog;

import java.util.List;

/**
 * Created by chengx on 18-2-1.
 */

public class AllGiftAdapter extends CommonRecyclerAdapter<GiftLog> {
    int[] giftImages = {R.drawable.ic_gift_coin,R.drawable.ic_gift_flower,R.drawable.ic_gift_beer,R.drawable.ic_gift_mac,
            R.drawable.ic_gift_car,R.drawable.ic_gif_house};
    public AllGiftAdapter(Context context, int layoutId, List<GiftLog> data) {
        super(context,layoutId, data);
    }

    @Override
    public void convert(RecyclerViewHolder holder, GiftLog giftLog) {
        holder.setText(R.id.nickNameTv,giftLog.getUserName());
        holder.setText(R.id.giftCountTv,giftLog.getNum()+"个");
        holder.setImageResource(R.id.giftIv,giftImages[Integer.valueOf(giftLog.getMoneyType())-3]);
    }
}
