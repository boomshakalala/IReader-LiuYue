package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseActivity;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.present.ModifyPresent;

import butterknife.BindView;

public class ModifyPwdActivity extends BaseActivity<ModifyPresent> implements View.OnClickListener {

    @BindView(R.id.oldPwdEt)
    EditText oldPwdEt;
    @BindView(R.id.newPwdEt)
    EditText newPwdEt;
    @BindView(R.id.confirmPwdEt)
    EditText confirmPwdEt;
    @BindView(R.id.verifyCodeEt)
    EditText verifyEt;
    @BindView(R.id.getVerifyBtn)
    TextView getVerifyBtn;
    @BindView(R.id.modifyBtn)
    Button modifyBtn;
    @BindView(R.id.phoneLayout)
    LinearLayout phoneLayout;
    @BindView(R.id.oldPwdLayout)
    LinearLayout oldPwdLayout;
    @BindView(R.id.phoneEt)
    EditText phoneEt;

    String type;

    public static void launch(Context context,String type){
        Intent intent = new Intent(context,ModifyPwdActivity.class);
        intent.putExtra("type",type);
        context.startActivity(intent);
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("修改密码");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_modify_pwd;
    }

    @Override
    public void initData() {
        type = getIntent().getStringExtra("type");
        if (type.equals("2")){
            getPresent().getUserInfo();
        }
    }

    @Override
    public void initViews() {
        if (type.equals("1")){
            oldPwdLayout.setVisibility(View.GONE);
            phoneLayout.setVisibility(View.VISIBLE);
        }else {
            oldPwdLayout.setVisibility(View.VISIBLE);
            phoneLayout.setVisibility(View.GONE);
        }
    }

    @Override
    public void setListener() {
        modifyBtn.setOnClickListener(this);
        getVerifyBtn.setOnClickListener(this);
    }

    @Override
    public ModifyPresent newPresent() {
        return new ModifyPresent();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.modifyBtn:
                String oldPwd = oldPwdEt.getText().toString().trim();
                String newPwd = newPwdEt.getText().toString().trim();
                String confirmPwd = confirmPwdEt.getText().toString().trim();
                String verifyCode = verifyEt.getText().toString().trim();
                String phone = phoneEt.getText().toString().trim();
                if (TextUtils.isEmpty(phone)&&type.equals("1")){
                    showTip("请输入手机号");
                    return;
                }
                if (TextUtils.isEmpty(oldPwd)&&type.equals("2")){
                    showTip("请输入旧密码");
                    return;
                }
                if (TextUtils.isEmpty(newPwd)){
                    showTip("请输入新密码");
                    return;
                }
                if (TextUtils.isEmpty(confirmPwd)){
                    showTip("请确认新密码");
                    return;
                }
                if (TextUtils.isEmpty(verifyCode)&&type.equals("1")){
                    showTip("请输入验证码");
                    return;
                }
                if (!newPwd.equals(confirmPwd)) {
                    showTip("两次密码不一致");
                    return;

                }
                if (type.equals("2"))
                    getPresent().modifyPwd(oldPwd,newPwd,verifyCode);
                else
                    getPresent().resetPwd(newPwd,verifyCode,phone);

                break;
            case R.id.getVerifyBtn:
                String phoneNo = phoneEt.getText().toString().trim();
                if (TextUtils.isEmpty(phoneNo)){
                    showTip("请输入手机号");
                    return;
                }
                getPresent().setPhoneNum(phoneNo);
                getPresent().getVerifyCode();
                break;
        }

    }

    public void startCountDown(){
        new CountDown(60000,1000).start();
    }

    class CountDown extends CountDownTimer {

        public CountDown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            getVerifyBtn.setTextColor(getResources().getColor(R.color.text_color_gray));
            getVerifyBtn.setClickable(false);
            getVerifyBtn.setText(l/1000 + "s");
        }

        @Override
        public void onFinish() {
            getVerifyBtn.setTextColor(Color.parseColor("#1585b1"));
            getVerifyBtn.setClickable(true);
            getVerifyBtn.setText("重试");
        }
    }
}