package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;

import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.MyShelfAdapter;
import com.tenghen.ireader.base.BaseListActivity;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.ui.present.MyShelfPresent;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class MyShelfActivity extends BaseListActivity<MyShelfPresent,Book> {

    List<Book> data;

    public static void launch(Context context){
        Intent intent = new Intent(context,MyShelfActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("我的书架");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_shelf;
    }

    @Override
    public void initData() {
        data = new ArrayList<>();
        adapter = new MyShelfAdapter(this,R.layout.item_book,data);
    }

    @Override
    public void initViews() {
        super.initViews();
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(adapter);
        getPresent().refresh();
    }

    @Override
    public void setListener() {

    }

    @Override
    public MyShelfPresent newPresent() {
        return new MyShelfPresent();
    }
}
