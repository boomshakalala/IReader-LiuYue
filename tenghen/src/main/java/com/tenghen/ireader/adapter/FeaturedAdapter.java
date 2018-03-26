package com.tenghen.ireader.adapter;

import android.content.Context;

import com.chengx.mvp.adapter.MultiItemCommonAdapter;

import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/2/24
 * 描述：
 */

public class FeaturedAdapter extends MultiItemCommonAdapter<Object> {
    public FeaturedAdapter(Context context, List<Object> data) {
        super(context, data);
        addItemViewDelegate(new FeaturedHeaderDelegate(context));
        addItemViewDelegate(new FeaturedLeble());
        addItemViewDelegate(new FeatureRecDelegate(context));
        addItemViewDelegate(new FeaturedBookDelegate(context));
        addItemViewDelegate(new SpaceDividerItemDelegate());
        addItemViewDelegate(new LineDividerItemDelegate());
    }
}
