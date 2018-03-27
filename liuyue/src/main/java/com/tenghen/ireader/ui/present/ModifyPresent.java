package com.tenghen.ireader.ui.present;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.TextUtils;

import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.base.BasePresent;
import com.tenghen.ireader.module.UserInfo;
import com.tenghen.ireader.module.VerifyCode;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.activity.ModifyPwdActivity;

import java.util.List;

public class ModifyPresent extends BasePresent<ModifyPwdActivity> {

    String phoneNum = "";

    public void modifyPwd(String oldPwd,String newPwd,String verifyCode){
        Api.userChengePwd(oldPwd, newPwd, verifyCode, new ResponseCallback<Void>() {
            @Override
            public void onSuccess(Void data) {
                getV().showTip("修改成功");
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

    public void getUserInfo(){
        getV().showProgress();
        Api.userUserInfo(new ResponseCallback<UserInfo>() {
            @Override
            public void onSuccess(UserInfo data) {
                getV().dismissDialog();
                if (data!=null){
                    UserInfo.BaseInfo baseInfo = data.getBase_info();
                    if (baseInfo != null){
                        phoneNum = baseInfo.getMobile();
                        if (TextUtils.isEmpty(phoneNum)){
                            final AlertDialog dialog = new AlertDialog.Builder(getV()).create();
                                    dialog.setTitle("提示");
                                    dialog.setMessage("您尚未绑定手机号，手机端暂不支持修改密码，请到PC官网进行修改");
                                    dialog.setButton("确定", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialog.dismiss();
                                            getV().finish();
                                        }
                                    });
                            dialog.setCancelable(false);
                            dialog.show();
                        }
                    }
                }
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().dismissDialog();
                final AlertDialog dialog = new AlertDialog.Builder(getV()).create();
                dialog.setTitle("提示");
                dialog.setMessage(info);
                dialog.setButton("重试", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialog.dismiss();
                        getUserInfo();
                    }
                });
                dialog.setButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialog.dismiss();
                        getV().finish();
                    }
                });
                dialog.setCancelable(false);
                dialog.show();
            }
        });
    }

    public void resetPwd(String newPwd,String verifyCode,String phone){
        Api.userResetPwd(newPwd, verifyCode,phone ,new ResponseCallback<Void>() {
            @Override
            public void onSuccess(Void data) {
                getV().showTip("修改成功");
                getV().finish();
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().showTip(info);
            }
        });
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}