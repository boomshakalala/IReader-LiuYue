package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;

import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.FeaturedBookDelegate;
import com.tenghen.ireader.adapter.MonthlyAdapter;
import com.tenghen.ireader.base.BaseListActivity;
import com.tenghen.ireader.ui.present.MonthlyPresent;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/3/1
 * 描述：
 */

public class MonthlyActivity extends BaseListActivity<MonthlyPresent,Object> {

    List<Object> data;


    public static void launch(Context context){
        Intent intent = new Intent(context,MonthlyActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initViews() {
        super.initViews();
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int viewType = adapter.getItemViewType(position);
                return ((MonthlyAdapter)adapter).getItemViewDelegate(viewType) instanceof FeaturedBookDelegate ? 1 : 3;
            }
        });
        recyclerView.setCanloadMore(false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        getPresent().refresh();
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("包月");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_monthly;
    }

    @Override
    public void initData() {
        data = new ArrayList<>();
        adapter = new MonthlyAdapter(this,data);
    }

    @Override
    public void setListener() {

    }

    @Override
    public MonthlyPresent newPresent() {
        return new MonthlyPresent();
    }
}
