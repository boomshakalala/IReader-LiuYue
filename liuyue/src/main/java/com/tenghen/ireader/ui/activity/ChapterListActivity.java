package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;

import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.ChapterAdapter;
import com.tenghen.ireader.adapter.CostLogAdapter;
import com.tenghen.ireader.base.BaseListActivity;
import com.tenghen.ireader.module.Chapter;
import com.tenghen.ireader.ui.present.ChapterListPresent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/4/004.
 */

public class ChapterListActivity extends BaseListActivity<ChapterListPresent,Chapter> {
    List<Chapter> data;
    String bookId;

    public static void launch(Context context,String bookId){
        Intent intent = new Intent(context,ChapterListActivity.class);
        intent.putExtra("bookId",bookId);
        context.startActivity(intent);
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("目录");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        initData();
        initViews();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_chapter_list;
    }

    @Override
    public void initData() {
        data = new ArrayList<>();
        adapter = new ChapterAdapter(this,R.layout.item_chapter,data);
        bookId = getIntent().getStringExtra("bookId");
        ((ChapterListPresent)getPresent()).setBookId(bookId);
    }

    @Override
    public void initViews() {
        super.initViews();
        recyclerView.setCanloadMore(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        getPresent().refresh();
    }

    @Override
    public void setListener() {

    }

    @Override
    public ChapterListPresent newPresent() {
        return new ChapterListPresent();
    }
}
