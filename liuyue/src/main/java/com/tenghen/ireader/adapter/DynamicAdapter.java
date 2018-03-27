package com.tenghen.ireader.adapter;

import android.content.Context;

import com.chengx.mvp.adapter.MultiItemCommonAdapter;

import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class DynamicAdapter extends MultiItemCommonAdapter<Object> {
    public DynamicAdapter(Context context, List<Object> data) {
        super(context, data);
        addItemViewDelegate(new DynamicBannerDelegate(context));
        addItemViewDelegate(new ActiveRankHeaderDelegate());
        addItemViewDelegate(new ActiveRankDelegate());
        addItemViewDelegate(new DynamicCommentHeaderDelegate());
        addItemViewDelegate(new DynamicCommentDelegate());
    }
}
