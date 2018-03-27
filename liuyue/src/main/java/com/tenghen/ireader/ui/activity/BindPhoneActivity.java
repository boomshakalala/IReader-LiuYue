package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseActivity;
import com.tenghen.ireader.ui.present.BindPhonePresent;

import butterknife.BindView;
import butterknife.OnClick;

public class BindPhoneActivity extends BaseActivity<BindPhonePresent> {

    @BindView(R.id.phoneEt)
    EditText phoneEt;
    @BindView(R.id.verifyCodeEt)
    EditText verifyEt;
    @BindView(R.id.getVerifyBtn)
    TextView getVerifyBtn;

    public static void launch(Context context){
        Intent intent = new Intent(context,BindPhoneActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("绑定手机号");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_bind_phone;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initViews() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public BindPhonePresent newPresent() {
        return new BindPhonePresent();
    }

    @OnClick({R.id.getVerifyBtn,R.id.bindBtn})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.getVerifyBtn:
                String phoneNo = phoneEt.getText().toString().trim();
                if (TextUtils.isEmpty(phoneNo)){
                    showTip("请输入手机号");
                    return;
                }
                getPresent().setPhoneNum(phoneNo);
                getPresent().getVerifyCode();
                break;
            case R.id.bindBtn:
                String verifyCode = verifyEt.getText().toString().trim();
                String phone = phoneEt.getText().toString().trim();
                if (TextUtils.isEmpty(phone)){
                    showTip("请输入手机号");
                    return;
                }
                if (TextUtils.isEmpty(verifyCode)){
                    showTip("请输入验证码");
                    return;
                }
                getPresent().bindPhone(phone,verifyCode);
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