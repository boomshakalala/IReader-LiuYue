package com.tenghen.ireader.adapter;

import android.content.Context;

import com.chengx.mvp.adapter.CommonAdapter;
import com.chengx.mvp.adapter.ViewHolder;
import com.tenghen.ireader.R;

import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/2/27
 * 描述：
 */

public class SearchTagAdapter extends CommonAdapter<String> {

    public SearchTagAdapter(Context context, List<String> data, int itemLayoutId) {
        super(context, data, itemLayoutId);
    }

    @Override
    public void convert(ViewHolder holder, String s) {
        holder.setText(R.id.searchTagTv,s);
    }
}
