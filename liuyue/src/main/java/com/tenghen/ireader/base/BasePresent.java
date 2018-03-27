package com.tenghen.ireader.base;

import com.chengx.mvp.base.IView;
import com.chengx.mvp.base.XPresent;
import com.tenghen.ireader.net.Api;

import static com.chengx.mvp.utils.KLog.V;

/**
 * 作者：chengx
 * 日期：2017/2/23
 * 描述：
 */

public class BasePresent<V extends IView> extends XPresent<V> {
    Api api = new Api();
}
