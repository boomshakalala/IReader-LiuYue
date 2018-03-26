package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;

import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.DynamicAdapter;
import com.tenghen.ireader.base.BaseListActivity;
import com.tenghen.ireader.ui.present.DynamicPresent;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class DynamicActivity extends BaseListActivity<DynamicPresent,Object> {
    List<Object> data;

    public static void launch(Context context){
        Intent intent = new Intent(context,DynamicActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("书友动态");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_dynamic;
    }

    @Override
    public void initData() {
        data = new ArrayList<>();
        adapter = new DynamicAdapter(this,data);
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
    public DynamicPresent newPresent() {
        return new DynamicPresent();
    }
}
