package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;

import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.RechargeLogAdapter;
import com.tenghen.ireader.base.BaseListActivity;
import com.tenghen.ireader.ui.present.RechargeLogPresent;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class RechargeLogActivity extends BaseListActivity<RechargeLogPresent,Object> {
    List<Object> data;

    public static void launch(Context context){
        Intent intent = new Intent(context,RechargeLogActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("充值记录");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_recharge_log;
    }

    @Override
    public void initData() {
        data = new ArrayList<>();
        adapter = new RechargeLogAdapter(this,data);
    }

    @Override
    public void initViews() {
        super.initViews();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        getPresent().refresh();
    }

    @Override
    public void setListener() {

    }

    @Override
    public RechargeLogPresent newPresent() {
        return new RechargeLogPresent();
    }
}
