package com.tenghen.ireader.adapter;

import android.content.Context;

import com.chengx.mvp.adapter.MultiItemCommonAdapter;

import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/3/1
 * 描述：
 */

public class FreeBookAdapter extends MultiItemCommonAdapter<Object> {

    public FreeBookAdapter(Context context, List<Object> data) {
        super(context, data);
        addItemViewDelegate(new FeaturedLeble());
        addItemViewDelegate(new SpaceDividerItemDelegate());
        addItemViewDelegate(new FreeBookDelegate());
        addItemViewDelegate(new BookListDelegate());
    }
}
