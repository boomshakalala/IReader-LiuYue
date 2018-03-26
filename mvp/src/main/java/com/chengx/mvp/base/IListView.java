package com.chengx.mvp.base;

import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/2/22
 * 描述：
 */

public interface IListView<V,M> extends IView {
    void refresh(List<M> data);
    void loadMore(List<M> data);
    void showEmpty();
    void showError();
    void closeLoadMore();
}
