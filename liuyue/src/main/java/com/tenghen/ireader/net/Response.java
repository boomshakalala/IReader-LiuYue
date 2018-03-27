package com.tenghen.ireader.net;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * 作者：chengx
 * 日期：2017/2/22
 * 描述：
 */

public class Response<T> implements Serializable {
    private static final long serialVersionUID = -6401869905868406915L;
    String json;
    int code;
    ResponseCallback<T> callback;
    Type typeOfClass;

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResponseCallback<T> getCallback() {
        return callback;
    }

    public void setCallback(ResponseCallback<T> callback) {
        this.callback = callback;
    }

    public Type getTypeOfClass() {
        return typeOfClass;
    }

    public void setTypeOfClass(Type typeOfClass) {
        this.typeOfClass = typeOfClass;
    }
}
