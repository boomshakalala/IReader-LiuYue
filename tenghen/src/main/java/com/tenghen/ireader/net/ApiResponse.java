package com.tenghen.ireader.net;


import java.io.Serializable;

/**
 * 作者：chengx
 * 日期：2017/2/22
 * 描述：
 */

public class ApiResponse<T> implements Serializable{
    private static final long serialVersionUID = -5437048962915606356L;

    private int code; // code=0 为请求成功 code=1 参数错误 code=2 属于服务器错误 code=9 未登录
    private String message; //返回时间
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess(){
        return code == 0;
    }
}
