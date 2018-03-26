package com.chengx.mvp.base;

/**
 * 作者：chengx
 * 日期：2017/2/9
 * 描述：
 */

public interface IListPresent<V extends IListView> extends IPresent<V> {
    void refresh();
    void loadMore();
}
