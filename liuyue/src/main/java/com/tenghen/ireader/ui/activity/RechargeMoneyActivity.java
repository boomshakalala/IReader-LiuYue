package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.RechargeMoneyAdapter;
import com.tenghen.ireader.base.BaseActivity;
import com.tenghen.ireader.module.RechareMoney;
import com.tenghen.ireader.ui.present.PayPresent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class RechargeMoneyActivity extends BaseActivity<PayPresent> implements AdapterView.OnItemClickListener {


    List<RechareMoney> dataList = new ArrayList<>();
    private String payType;

    public static void launch(Context context,String payType){
        Intent intent = new Intent(context,RechargeMoneyActivity.class);
        intent.putExtra("payType",payType);
        context.startActivity(intent);
    }

    @BindView(R.id.listView)
    ListView listView;
    @Override

    public void initToolBar() {
        toolbar.setTitle("充值");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_recharge_money;
    }

    @Override
    public void initData() {
        payType = getIntent().getStringExtra("payType");

        dataList.add(new RechareMoney(3000,0,30));
        dataList.add(new RechareMoney(5000,1000,50));
        dataList.add(new RechareMoney(10000,2000,100));
        dataList.add(new RechareMoney(20000,6000,200));
        dataList.add(new RechareMoney(50000,20000,500));
        dataList.add(new RechareMoney(100000,50000,1000));

    }

    @Override
    public void initViews() {
        RechargeMoneyAdapter adapter = new RechargeMoneyAdapter(this,dataList,R.layout.item_recharge_money);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void setListener() {

    }

    @Override
    public PayPresent newPresent() {
        return new PayPresent();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        RechareMoney money = dataList.get(position);
        getPresent().pay(money.money,payType);
    }
}