package com.chengx.mvp.base;

import android.content.Context;

/**
 * 作者：chengx
 * 日期：2017/2/9
 * 描述：
 */

public interface IView<P> {

    void showProgress();

    void hideProgress();

    void showTip(String msg);

    void initToolBar();

    int getLayoutId();

    void initData();

    void initViews();

    void setListener();

    boolean useEventBus();

    P newPresent();
}
