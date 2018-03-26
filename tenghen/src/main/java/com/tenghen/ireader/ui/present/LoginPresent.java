package com.tenghen.ireader.ui.present;

import com.chengx.mvp.base.AppConfig;
import com.tenghen.ireader.module.VerifyCode;
import com.tenghen.ireader.net.ResponseCallback;
import com.chengx.mvp.utils.AppUtils;
import com.chengx.mvp.utils.SPUtils;
import com.tenghen.ireader.base.BasePresent;
import com.tenghen.ireader.module.User;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.activity.LoginActivity;

import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class LoginPresent extends BasePresent<LoginActivity> {

    public void login(String userName,String password,int type,String mobile,String uid){
        getV().showProgress();
        Api.userLogin(type, userName, password, uid,mobile,new ResponseCallback<User>() {
            @Override
            public void onSuccess(User data) {
                saveUserInfo(data);
                getV().dismissDialog();
                getV().finish();
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().showTip(info);
                getV().dismissDialog();
            }
        });
    }

    private void saveUserInfo(User user){
        new SPUtils(AppUtils.getAppContext(), AppConfig.SP_NAME).putObject("user",user);
    }

    public void getVerifyCode(String mobile){
        getV().showProgress();
        Api.userGetVerifyCode(mobile, "1", new ResponseCallback<List<VerifyCode>>() {
            @Override
            public void onSuccess(List<VerifyCode> data) {
                getV().showTip("获取验证码成功");
                getV().startCountDown();
                getV().dismissDialog();
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().showTip(info);
                getV().dismissDialog();
            }
        });
    }

}
