package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseActivity;
import com.tenghen.ireader.module.Wallet;
import com.tenghen.ireader.net.Api;

import butterknife.BindView;
import butterknife.OnClick;

public class RechargeActivity extends BaseActivity {


    @BindView(R.id.moneyTv)
    TextView moneyTv;

    public static void launch(Context context){
        context.startActivity(new Intent(context,RechargeActivity.class));
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("充值");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_recharge;
    }

    @Override
    public void initData() {
        startRequestForGetMoney();
    }

    private void startRequestForGetMoney() {
        Api.userMyWallet(new ResponseCallback<Wallet>() {
            @Override
            public void onSuccess(Wallet data) {
                moneyTv.setText(Html.fromHtml("余额："+"<font color=\"#3fbfcc\">"+data.getMoney()+"</font>"+"腾币"));
            }

            @Override
            public void onFailure(int errCode, String info) {
                moneyTv.setText(Html.fromHtml("余额："+"<font color=\"#3fbfcc\">"+0+"</font>"+"腾币"));
            }
        });
    }

    @Override
    public void initViews() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public Object newPresent() {
        return null;
    }

    @OnClick({R.id.btn_recharge_alipay,R.id.btn_recharge_wechat})
    public void toRecharge(View v){
        switch (v.getId()){
            case R.id.btn_recharge_alipay:
                RechargeMoneyActivity.launch(this,"1");
                break;
            case R.id.btn_recharge_wechat:
                RechargeMoneyActivity.launch(this,"2");
                break;
        }
    }
}