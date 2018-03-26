package com.tenghen.ireader.ui.fragment;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chengx.mvp.widget.CircleImageView;
import com.tenghen.ireader.CommonUtils;
import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseFragment;
//import com.tenghen.ireader.qqapi.QQAPI;
import com.tenghen.ireader.module.UserInfo;
import com.tenghen.ireader.module.Wallet;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.activity.AboutActivity;
import com.tenghen.ireader.ui.activity.BindPhoneActivity;
import com.tenghen.ireader.ui.activity.CostLogActivity;
import com.tenghen.ireader.ui.activity.LatestReadActivity;
import com.tenghen.ireader.ui.activity.LoginActivity;
import com.tenghen.ireader.ui.activity.ModifyPwdActivity;
import com.tenghen.ireader.ui.activity.MyCommentActivity;
import com.tenghen.ireader.ui.activity.MyMsgActivity;
import com.tenghen.ireader.ui.activity.MyShelfActivity;
import com.tenghen.ireader.ui.activity.ProblemsActivity;
import com.tenghen.ireader.ui.activity.RechargeActivity;
import com.tenghen.ireader.ui.activity.RechargeLogActivity;
import com.tenghen.ireader.ui.activity.SettingActivity;
import com.tenghen.ireader.ui.present.UserPresent;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：chengx
 * 日期：2017/2/23
 * 描述：
 */

public class UserFragment extends BaseFragment<UserPresent> {
    public static final int OPT_TO_RECHARGE = 1;
    public static final int OPT_TO_MY_SHELF = 2;
    public static final int OPT_TO_RECHARGE_LOG = 3;
    public static final int OPT_TO_COST_LOG = 4;
    public static final int OPT_TO_LETAST_READ = 5;
    public static final int OPT_TO_MY_COMMENT = 6;
    public static final int OPT_TO_MY_MSG = 7;
    public static final int OPT_TO_DOWNLOAD = 8;
    public static final int OPT_TO_RESET_PSD = 9;
    public static final int OPT_TO_SETTING = 10;

    @BindView(R.id.avatarIv)
    CircleImageView avatarIv;
    @BindView(R.id.nickNameTv)
    TextView nickNameTv;
    @BindView(R.id.userIdTv)
    TextView userIdTv;
    @BindView(R.id.phoneNumTv)
    TextView phoneNumTv;
    @BindView(R.id.walletTv)
    TextView walletTv;
    @Override
    public void initToolBar() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    public void initData() {
        getPresent();
    }

    @Override
    public void initViews() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public UserPresent newPresent() {
        return new UserPresent();
    }

    @OnClick(R.id.avatarIv)
    public void login(){
        if (isLogin()){

        }else {
            LoginActivity.launch(this,0);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        if (CommonUtils.isLogin()){
            getData();
        }else {
            clearUserInfo();
        }
    }

    @OnClick(R.id.phoneNumTv)
    public void bindPhone(View v){
        BindPhoneActivity.launch(getContext());
    }

    @OnClick(R.id.latestReadBtn)
    public void toLatestRead(){
        if (isLogin())
            LatestReadActivity.launch(getContext());
        else
            LoginActivity.launch(this,OPT_TO_LETAST_READ);
    }

    @OnClick(R.id.myShelfBtn)
    public void toMyShelf(){
        if (isLogin())
            MyShelfActivity.launch(getContext());
        else
            LoginActivity.launch(this,OPT_TO_MY_SHELF);
    }

    @OnClick(R.id.rechargeLogBtn)
    public void toRechargeLog(){
        if (isLogin())
            RechargeLogActivity.launch(getContext());
        else
            LoginActivity.launch(this,OPT_TO_RECHARGE_LOG);
    }

    @OnClick(R.id.costLogBtn)
    public void toCostLog(){
        if (isLogin())
            CostLogActivity.launch(getContext());
        else
            LoginActivity.launch(this,OPT_TO_COST_LOG);
    }

    @OnClick(R.id.myCommentBtn)
    public void toMyComment(){
        if (isLogin())
            MyCommentActivity.launch(getContext());
        else
            LoginActivity.launch(this,OPT_TO_MY_COMMENT);
    }

    @OnClick(R.id.myMsgBtn)
    public void toMyMsg(){
        if (isLogin())
            MyMsgActivity.launch(getContext());
        else
            LoginActivity.launch(this,OPT_TO_MY_MSG);
    }


    private void getData(){
        getPresent().getUserData();
        getPresent().getSignData();
        getPresent().getWalletData();
    }

    public void setUserInfo(UserInfo userInfo){
        UserInfo.BaseInfo baseInfo = userInfo.getBase_info();
        if (baseInfo != null) {
            userIdTv.setText("ID:"+baseInfo.getId());
            Glide.with(this).load(Api.IMG_HOST+baseInfo.getUser_image()).into(avatarIv);
            String phoneNum = baseInfo.getMobile();
            phoneNumTv.setText(TextUtils.isEmpty(phoneNum)?"绑定手机":phoneNum);
            phoneNumTv.setClickable(TextUtils.isEmpty(phoneNum));
            nickNameTv.setText(baseInfo.getName());
            phoneNumTv.setVisibility(View.VISIBLE);
            userIdTv.setVisibility(View.VISIBLE);
        }
    }

    public void setWalletInfo(Wallet walletInfo){
        walletTv.setVisibility(View.VISIBLE);
        walletTv.setText(walletInfo.getMoney()+"腾币");
    }


    public void clearUserInfo(){
        nickNameTv.setText("注册/登录");
        avatarIv.setImageResource(R.drawable.ic_user_avatar);
        userIdTv.setVisibility(View.GONE);
        phoneNumTv.setVisibility(View.GONE);
        walletTv.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (isLogin())
            getData();
        else
            clearUserInfo();
        switch (requestCode){
            case OPT_TO_LETAST_READ:
                if (isLogin())
                    LatestReadActivity.launch(getContext());
                break;
            case OPT_TO_MY_SHELF:
                if (isLogin())
                    MyShelfActivity.launch(getContext());
                break;
            case OPT_TO_RECHARGE_LOG:
                if (isLogin())
                    RechargeLogActivity.launch(getContext());
                break;
            case OPT_TO_COST_LOG:
                if (isLogin())
                    CostLogActivity.launch(getContext());
                break;
            case OPT_TO_MY_COMMENT:
                if (isLogin())
                    MyCommentActivity.launch(getContext());
                break;
            case OPT_TO_MY_MSG:
                if (isLogin())
                    MyMsgActivity.launch(getContext());
                break;
            case OPT_TO_RECHARGE:
                if (isLogin())
                    RechargeActivity.launch(getContext());
                break;
            case OPT_TO_RESET_PSD:
                if (isLogin())
                    ModifyPwdActivity.launch(getContext(),"2");
                break;
        }

    }

    @OnClick(R.id.rechargeBtn)
    public void recharge(View view){
        if (isLogin())
            RechargeActivity.launch(getContext());
        else
            LoginActivity.launch(this,OPT_TO_RECHARGE);
    }

    @OnClick(R.id.modifyPwdBtn)
    public void modifyPwd(View view){
        if (isLogin())
            ModifyPwdActivity.launch(getContext(),"2");
        else
            LoginActivity.launch(this,OPT_TO_RESET_PSD);
    }

    @OnClick(R.id.shareBtn)
    public void share(View view){

    }
    @OnClick(R.id.problemBtn)
    public void toProblem(View view){
        ProblemsActivity.launch(getContext());
    }
    @OnClick(R.id.aboutBtn)
    public void toAbout(View view){
        AboutActivity.launch(getContext());
    }
    @OnClick(R.id.settingBtn)
    public void toSetting(View view){
        SettingActivity.launch(getContext());
    }

}
