package com.chengx.mvp.base;

/**
 * 作者：chengx
 * 日期：2017/2/9
 * 描述：
 */

public interface IPresent<V> {
    void attachV(V v);

    void detachV();
}
