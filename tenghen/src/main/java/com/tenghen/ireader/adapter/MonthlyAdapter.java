package com.tenghen.ireader.adapter;

import android.content.Context;

import com.chengx.mvp.adapter.MultiItemCommonAdapter;

import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/3/1
 * 描述：
 */

public class MonthlyAdapter extends MultiItemCommonAdapter<Object> {
    public MonthlyAdapter(Context context, List<Object> data) {
        super(context, data);
        addItemViewDelegate(new MonthlyHeadDelegate());
        addItemViewDelegate(new SpaceDividerItemDelegate());
        addItemViewDelegate(new FeaturedLeble());
        addItemViewDelegate(new FeatureRecDelegate(context));
        addItemViewDelegate(new FeaturedBookDelegate(context));
        addItemViewDelegate(new LineDividerItemDelegate());
        addItemViewDelegate(new MonthlyHotBookDelegate(context));
    }
}
