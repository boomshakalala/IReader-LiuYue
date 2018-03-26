package com.tenghen.ireader.base;

import com.chengx.mvp.base.IPresent;
import com.chengx.mvp.base.XActivity;
import com.tenghen.ireader.module.User;

/**
 * 作者：chengx
 * 日期：2017/2/22
 * 描述：
 */

public abstract   class  BaseActivity<T extends IPresent> extends XActivity<T> {


    @Override
    public void showProgress() {
        showDialog();
    }

    @Override
    public void hideProgress() {
        dismissDialog();
    }

    @Override
    public void showTip(String msg) {
        showToast(msg);
    }

    public boolean isLogin(){
        return   getUserInfo() != null;
    }

    public User getUserInfo(){
        return sp.getObject("user",null);
    }

}
