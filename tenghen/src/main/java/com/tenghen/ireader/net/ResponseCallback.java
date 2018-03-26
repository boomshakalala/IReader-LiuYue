package com.tenghen.ireader.net;

/**
 * 作者：chengx
 * 日期：2017/2/10
 * 描述：
 */

public interface ResponseCallback<T> {
    void onSuccess(T data);

    void onFailure(int errCode,String info);
}
