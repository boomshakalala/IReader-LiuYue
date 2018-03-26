package com.tenghen.ireader;

import android.app.Activity;
import android.content.Context;

import com.chengx.mvp.base.AppConfig;
import com.chengx.mvp.utils.AppUtils;
import com.chengx.mvp.utils.SPUtils;
import com.chengx.mvp.utils.ToastUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import com.tenghen.ireader.module.User;
import com.tenghen.ireader.ui.activity.LoginActivity;

public class CommonUtils {
    public static boolean isLogin(){
        return   getUserInfo() != null;
    }

    public static User getUserInfo(){
        SPUtils sp = new SPUtils(AppUtils.getAppContext(), AppConfig.SP_NAME);
        return sp.getObject("user",null);
    }

    public static void clearUserInfo(){
        SPUtils sp = new SPUtils(AppUtils.getAppContext(),AppConfig.SP_NAME);
        sp.putObject("user",null);
    }

    public static void loginAndToast(Activity context){
        ToastUtils.showToast(AppUtils.getAppContext(),"请登录");
        LoginActivity.launch(context,0);
    }

    public static void error(int errCode,Activity activity){
        if (errCode == 9){
            loginAndToast(activity);
        }
    }

    public static void saveUserInfo(User user){
        SPUtils sp = new SPUtils(AppUtils.getAppContext(),AppConfig.SP_NAME);
        sp.putObject("user",user);
    }
}