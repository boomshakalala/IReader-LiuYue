package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.base.BasePresent;
import com.tenghen.ireader.module.VerifyCode;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.ui.activity.ForgetPassWordActivity;

import java.util.List;

public class ForgetPassWordPresent extends BasePresent<ForgetPassWordActivity> {


    public void getVerifyCode(String phoneNum){
        getV().showProgress();
        Api.userGetVerifyCode(phoneNum, "2", new ResponseCallback<List<VerifyCode>>() {
            @Override
            public void onSuccess(List<VerifyCode> data) {
                getV().dismissDialog();
                getV().showTip("获取成功");
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().dismissDialog();
                getV().showTip(info);
            }
        });
    }

    public void resetPwd(String verifyCode,String phoneNum,String newPwd){

    }
}