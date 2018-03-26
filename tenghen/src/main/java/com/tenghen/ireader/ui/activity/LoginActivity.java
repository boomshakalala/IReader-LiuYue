package com.tenghen.ireader.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chengx.mvp.utils.PhoneUtils;
import com.chengx.mvp.utils.RegexUtils;
import com.chengx.mvp.utils.StringUtils;
import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseActivity;
import com.tenghen.ireader.ui.present.LoginPresent;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class LoginActivity extends BaseActivity<LoginPresent> implements UMAuthListener {

    @BindView(R.id.loginUserNameEt)
    EditText userNameEt;
    @BindView(R.id.loginPasswordEt)
    EditText passwordEt;

    @BindView(R.id.verifyCodeLayout)
    LinearLayout verifyCodeLayout;

    @BindView(R.id.verifyCodeEt)
    EditText verifyCodeEt;

    @BindView(R.id.getVerifyBtn)
    TextView getVerifyBtn;

    @BindView(R.id.emailRegisterBtn)
    TextView emailLoginBtn;
    @BindView(R.id.phoneRegisterBtn)
    TextView phoneLoginBtn;

    int type;

    public static void launch(Activity context,int requestCode){
        Intent intent = new Intent(context,LoginActivity.class);
        context.startActivityForResult(intent,requestCode);
    }

    public static void launch(Fragment context,int requestCode){
        Intent intent = new Intent(context.getContext(),LoginActivity.class);
        context.startActivityForResult(intent, requestCode);
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("账号登录");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
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
    public LoginPresent newPresent() {
        return new LoginPresent();
    }

    @OnClick(R.id.resetPwdBtn)
    public void resetPwd(View textView){
       ModifyPwdActivity.launch(this,"1");
    }

    @OnClick(R.id.phoneRegisterBtn)
    public void phoneLogin(TextView textView){
        verifyCodeLayout.setVisibility(View.VISIBLE);
        passwordEt.setVisibility(View.GONE);
        type = 5;
    }

    @OnClick(R.id.emailRegisterBtn)
    public void emailLogin(TextView textView){
        verifyCodeLayout.setVisibility(View.GONE);
        passwordEt.setVisibility(View.VISIBLE);
        type = 1;
    }

    @OnClick(R.id.getVerifyBtn)
    public void getVerify(TextView textView){
        String phoneNum = userNameEt.getText().toString().trim();
        getPresent().getVerifyCode(phoneNum);
    }


    @OnClick(R.id.registerBtn)
    public void register(TextView textView){
        RegisterActivity.launch(this);
    }

    @OnClick(R.id.loginBtn)
    public void login(){
        String userName = userNameEt.getText().toString().trim();
        String password = passwordEt.getText().toString().trim();
        if (RegexUtils.isEmail(userName)){
            type = 1;
        }else if (RegexUtils.isMobileExact(userName)){
            type = 5;
        }else {
            showTip("请输入正确的邮箱或手机号");
            return;
        }
        getPresent().login(userName,password,type,userName,"");
    }
    @OnClick(R.id.wxLoginBtn)
    public void wxLogin(){
        UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.WEIXIN, this);

    }
    @OnClick(R.id.qqLoginBtn)
    public void qqLogin(){
        UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.QQ, this);

    }
    @OnClick(R.id.wbLoginBtn)
    public void wbLogin(){
        UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.SINA, this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode,resultCode,data);
    }


    @Override
    public void onStart(SHARE_MEDIA share_media) {

    }

    @Override
    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

        log(TAG,map);

        switch (share_media){
            case QQ:
                break;
            case WEIXIN:
                break;
            case SINA:
                break;
        }
    }

    @Override
    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
        showToast("登录失败");
    }

    @Override
    public void onCancel(SHARE_MEDIA share_media, int i) {
        showToast("取消登录");
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
