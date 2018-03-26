package com.tenghen.ireader.adapter;

import android.content.Context;

import com.chengx.mvp.adapter.MultiItemCommonAdapter;
import com.chengx.mvp.utils.ToastUtils;
import com.tenghen.ireader.module.Gift;
import com.tenghen.ireader.ui.activity.BookDetailActivity;
import com.tenghen.ireader.ui.present.BookDetailPresent;

import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/3/7
 * 描述：
 */

public class BookDetailAdapter extends MultiItemCommonAdapter<Object> implements BookDetailGiftDelegate.OnGiftClickListener, BookDetailGiftLabelDelegate.OnSendGiftListener {
    public BookDetailAdapter(Context context, List<Object> data,String bookId) {
        super(context, data);
        addItemViewDelegate(new BookDetailCommentDelegate(context,bookId));
        addItemViewDelegate(new BookDetailCommentLabelDelegate(context));
        BookDetailGiftDelegate giftDelegate = new BookDetailGiftDelegate();
        giftDelegate.setOnGiftClickListener(this);
        addItemViewDelegate(giftDelegate);
        BookDetailGiftLabelDelegate sendGiftLabel = new BookDetailGiftLabelDelegate();
        sendGiftLabel.setOnSendGiftListener(this);
        addItemViewDelegate(sendGiftLabel);
        addItemViewDelegate(new BookDetailGiftLogDelegate());
        addItemViewDelegate(new BookDetailGiftLogLabelDelegate());
        addItemViewDelegate(new BookDetailHeaderDelegate(context));
        addItemViewDelegate(new BookDetailMoreDelegate(context));
        addItemViewDelegate(new SpaceDividerItemDelegate());
        addItemViewDelegate(new AdapterEmptyDelegate());
    }

    @Override
    public void onGiftClick(Gift gift, int position) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) instanceof Gift){
                ((Gift) data.get(i)).isChecked = false;
            }
        }
        ((Gift) data.get(position)).isChecked = true;
        notifyDataSetChanged();
    }

    @Override
    public void sendGift() {
        int checkedPosition = -1;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) instanceof Gift){
                if(((Gift) data.get(i)).isChecked){
                    checkedPosition = i;
                    break;
                }
            }
        }
        if (checkedPosition == -1){
            ToastUtils.showToast(context,"请选择礼物");
        }else {
            ((BookDetailPresent)((BookDetailActivity)context)
                    .getPresent())
                    .sendGift(((Gift)data
                            .get(checkedPosition))
                            .getGiftId());
        }
    }
}
