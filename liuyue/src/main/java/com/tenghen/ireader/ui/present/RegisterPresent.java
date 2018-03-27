package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.CommonUtils;
import com.tenghen.ireader.base.BasePresent;
import com.tenghen.ireader.module.Comment;
import com.tenghen.ireader.module.User;
import com.tenghen.ireader.module.VerifyCode;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.ui.activity.RegisterActivity;

import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class RegisterPresent extends BasePresent<RegisterActivity> {

    public void register(int type,String verifyCode,String pwd,String name,String mobile,String email,String uid){
        getV().showProgress();
        Api.userRegister(type, email, mobile, verifyCode, pwd, uid, name, new ResponseCallback<User>() {
            @Override
            public void onSuccess(User data) {
                getV().dismissDialog();
                if (data != null) {
                    CommonUtils.saveUserInfo(data);
                    getV().finish();
                }else {
                    getV().showTip("注册失败");
                }
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().dismissDialog();
                getV().showTip(info);
            }
        });

    }

    public void getVerifyCode(String mobile){
        getV().showProgress();
        Api.userGetVerifyCode(mobile, "0", new ResponseCallback<List<VerifyCode>>() {
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
