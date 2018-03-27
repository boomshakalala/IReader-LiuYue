package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.tenghen.ireader.CommonUtils;
import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseActivity;
import com.tenghen.ireader.widget.LogoutDialog;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/2/4/004.
 */

public class SettingActivity extends BaseActivity {

    @BindView(R.id.userBindBtn)
    RelativeLayout userBindBtn;
    @BindView(R.id.logoutBtn)
    RelativeLayout logoutBtn;



    public static void launch(Context context){
        Intent intent = new Intent(context,SettingActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("设置");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initViews() {
        if (CommonUtils.isLogin()){
            logoutBtn.setVisibility(View.VISIBLE);
            userBindBtn.setVisibility(View.VISIBLE);
        }else {
            logoutBtn.setVisibility(View.GONE);
            userBindBtn.setVisibility(View.GONE);
        }
    }

    @Override
    public void setListener() {

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public Object newPresent() {
        return null;
    }


    @OnClick({R.id.logoutBtn,R.id.userBindBtn,R.id.clearCacheBtn,R.id.checkUpdateBtn})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.logoutBtn:
                new LogoutDialog(this).show();
                break;
            case R.id.userBindBtn:
                UserBindActivity.launch(this);
                break;
            case R.id.clearCacheBtn:
                break;
            case R.id.checkUpdateBtn:
                break;
        }
    }
}
