package com.tenghen.ireader.ui.present;

import android.support.v4.app.INotificationSideChannel;

import com.tenghen.ireader.base.BasePresent;
import com.tenghen.ireader.module.VerifyCode;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.ui.activity.BindPhoneActivity;

import java.util.List;

public class BindPhonePresent extends BasePresent<BindPhoneActivity> {
    private String phoneNum;
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }


    public void bindPhone(String phone,String verifyCode){
        Api.userAccountBinding("5", "", phone, verifyCode, new ResponseCallback<Void>() {
            @Override
            public void onSuccess(Void data) {
                getV().showTip("绑定成功");
                getV().finish();
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().showTip(info);
            }
        });
    }

    public void getVerifyCode(){
        Api.userGetVerifyCode(phoneNum, "2", new ResponseCallback<List<VerifyCode>>() {
            @Override
            public void onSuccess(List<VerifyCode> data) {
                getV().showTip("验证码获取成功");
                getV().startCountDown();
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().showTip(info);
            }
        });

    }
}