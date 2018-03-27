package com.tenghen.ireader.adapter;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class AdapterEmptyDelegate implements ItemViewDelegate<Object> {
    @Override
    public int getItemLayoutId() {
        return R.layout.common_empty_view;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof ViewSupportModel && ((ViewSupportModel) o).getViewType() == ViewSupportModel.VIEW_TYPE_EMPTY;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {

    }
}
