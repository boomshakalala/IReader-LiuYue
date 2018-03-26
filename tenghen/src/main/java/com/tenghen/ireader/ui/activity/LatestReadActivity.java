package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;

import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.LatestBookListAdapter;
import com.tenghen.ireader.base.BaseListActivity;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.module.LatestBook;
import com.tenghen.ireader.ui.present.LatestReadPresent;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class LatestReadActivity extends BaseListActivity<LatestReadPresent,LatestBook> {
    List<LatestBook> data;

    public static void launch(Context context){
        Intent intent = new Intent(context,LatestReadActivity.class);
        context.startActivity(intent);
    }
    @Override
    public void initToolBar() {
        toolbar.setTitle("最近阅读");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_latest_read;
    }

    @Override
    public void initViews() {
        super.initViews();
        getPresent().refresh();
    }

    @Override
    public void initData() {
        data = new ArrayList<>();
        adapter = new LatestBookListAdapter(this,R.layout.item_latest_read,data);
    }

    @Override
    public void setListener() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public LatestReadPresent newPresent() {
        return new LatestReadPresent();
    }
}
