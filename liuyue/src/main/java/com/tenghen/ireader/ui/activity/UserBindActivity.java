package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.widget.TextView;

import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseActivity;
import com.tenghen.ireader.module.BindInfo;
import com.tenghen.ireader.ui.present.UserBindPresent;

import butterknife.BindInt;
import butterknife.BindView;

/**
 * Created by chengx on 18-2-8.
 */

public class UserBindActivity extends BaseActivity<UserBindPresent> {

    @BindView(R.id.btn_bind_wx)
    TextView bindWechatBtn;
    @BindView(R.id.btn_bind_qq)
    TextView bindQQBtn;
    @BindView(R.id.btn_bind_sina)
    TextView bindSinaBtn;

    public static void launch(Context context){
        Intent intent = new Intent(context,UserBindActivity.class);
        context.startActivity(intent);
    }
    @Override
    public void initToolBar() {
        toolbar.setTitle("第三方帐号绑定");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_user_bind;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initViews() {
        getPresent().getBindInfo();
    }

    @Override
    public void setListener() {

    }

    @Override
    public UserBindPresent newPresent() {
        return new UserBindPresent();
    }

    public void setBindInfo(BindInfo bindInfo){
        if (bindInfo.getQq().equals("1")){
            bindQQBtn.setClickable(false);
            bindQQBtn.setText("已绑定");
            bindQQBtn.setBackgroundColor(getResources().getColor(R.color.colorGray));
        }else {
            bindQQBtn.setClickable(true);
            bindQQBtn.setText("去绑定");
            bindQQBtn.setBackgroundColor(getResources().getColor(R.color.color_toolbar));
        }
        if (bindInfo.getWechat().equals("1")){
            bindWechatBtn.setClickable(false);
            bindWechatBtn.setText("已绑定");
            bindWechatBtn.setBackgroundColor(getResources().getColor(R.color.colorGray));
        }else {
            bindWechatBtn.setClickable(true);
            bindWechatBtn.setText("去绑定");
            bindWechatBtn.setBackgroundColor(getResources().getColor(R.color.color_toolbar));
        }
        if (bindInfo.getSina().equals("1")){
            bindSinaBtn.setClickable(false);
            bindSinaBtn.setText("已绑定");
            bindSinaBtn.setBackgroundColor(getResources().getColor(R.color.colorGray));
        }else {
            bindSinaBtn.setClickable(true);
            bindSinaBtn.setText("去绑定");
            bindSinaBtn.setBackgroundColor(getResources().getColor(R.color.color_toolbar));
        }
    }
}
