package com.tenghen.ireader.adapter;


import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;

/**
 * 作者: chengx
 * 日期: 2016/10/27.
 * 描述:
 */
public class SpaceDividerItemDelegate implements ItemViewDelegate<Object> {
    @Override
    public int getItemLayoutId() {
        return R.layout.item_space_divider;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof ViewSupportModel && ((ViewSupportModel) o).getViewType() == ViewSupportModel.VIEW_TYPE_SPLIT_SPACE;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {

    }
}
