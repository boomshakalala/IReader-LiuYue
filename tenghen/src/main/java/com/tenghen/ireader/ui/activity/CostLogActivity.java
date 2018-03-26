package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;

import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.CostLogAdapter;
import com.tenghen.ireader.base.BaseListActivity;
import com.tenghen.ireader.module.Cost;
import com.tenghen.ireader.ui.present.CostLogPresent;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class CostLogActivity extends BaseListActivity<CostLogPresent,Cost> {
    List<Cost> data;

    public static void launch(Context context){
        Intent intent = new Intent(context,CostLogActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("消费记录");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_cost_log;
    }

    @Override
    public void initData() {
        data = new ArrayList<>();
        adapter = new CostLogAdapter(this,R.layout.item_cost_log,data);
    }

    @Override
    public void initViews() {
        super.initViews();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setListener() {

    }

    @Override
    public CostLogPresent newPresent() {
        return new CostLogPresent();
    }
}
