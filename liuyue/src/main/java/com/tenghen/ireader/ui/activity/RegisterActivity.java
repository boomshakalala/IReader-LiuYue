package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseActivity;
import com.tenghen.ireader.ui.present.RegisterPresent;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class RegisterActivity extends BaseActivity<RegisterPresent> {

    @BindView(R.id.phoneNumEt)
    EditText phoneNumEt;
    @BindView(R.id.emailEt)
    EditText emailEt;
    @BindView(R.id.verifyCodeEt)
    EditText verifyCodeEt;
    @BindView(R.id.pwdEt)
    EditText pwdEt;
    @BindView(R.id.confirmPwdEt)
    EditText confirmPwdEt;
    @BindView(R.id.nickNameEt)
    EditText nickNameEt;
    @BindView(R.id.verifyCodeLayout)
    LinearLayout verifyCodeLayout;
    @BindView(R.id.getVerifyBtn)
    TextView getVerifyBtn;

    private int type = 5;
    private String uid = "";





    public static void launch(Context context){
        Intent intent = new Intent(context,RegisterActivity.class);
        context.startActivity(intent);
    }
    @Override
    public void initToolBar() {
        toolbar.setTitle("注册");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initViews() {
        emailEt.setVisibility(View.GONE);
        verifyCodeLayout.setVisibility(View.VISIBLE);
        verifyCodeEt.setVisibility(View.VISIBLE);
    }

    @Override
    public void setListener() {

    }

    @Override
    public RegisterPresent newPresent() {
        return new RegisterPresent();
    }

    @OnClick({R.id.phoneRegisterBtn,R.id.emailRegisterBtn,R.id.getVerifyBtn,R.id.registerBtn})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.phoneRegisterBtn:
                emailEt.setVisibility(View.GONE);
                verifyCodeLayout.setVisibility(View.VISIBLE);
                verifyCodeEt.setVisibility(View.VISIBLE);
                type = 5;
                break;
            case R.id.emailRegisterBtn:
                emailEt.setVisibility(View.VISIBLE);
                verifyCodeLayout.setVisibility(View.GONE);
                verifyCodeEt.setVisibility(View.GONE);
                type = 1;
                break;
            case R.id.getVerifyBtn:
                String phoneNum = phoneNumEt.getText().toString().trim();
                getPresent().getVerifyCode(phoneNum);
                break;
            case R.id.registerBtn:
                String email = emailEt.getText().toString().trim();
                String mobile = phoneNumEt.getText().toString().trim();
                String verifyCode = verifyCodeEt.getText().toString().trim();
                String pwd = pwdEt.getText().toString().trim();
                String confirmPwd = confirmPwdEt.getText().toString().trim();
                String name = nickNameEt.getText().toString().trim();
                if (confirmPwd.equals(pwd)){
                    getPresent().register(type,verifyCode,pwd,name,mobile,email,uid);
                }else {
                    showTip("两次输入的密码不一致");
                }
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
