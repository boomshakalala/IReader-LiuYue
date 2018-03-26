package com.chengx.mvp.base;

import com.chengx.mvp.utils.KLog;

import de.greenrobot.event.EventBus;

/**
 * 作者：chengx
 * 日期：2017/2/9
 * 描述：
 */

public class XPresent<V extends IView> implements IPresent<V> {
    private final String TAG = getClass().getSimpleName();
    private V v;

    @Override
    public void attachV(V v) {
        this.v = v;
    }

    @Override
    public void detachV() {
        v = null;
    }

    protected V getV(){
        if (v == null){
            throw new IllegalStateException("v不能为null");
        }
        return v;
    }

    public void log(Object... objects){
        KLog.d(TAG, objects);
    }

    public void logJson(String json){
        KLog.json(TAG, json);
    }

}
