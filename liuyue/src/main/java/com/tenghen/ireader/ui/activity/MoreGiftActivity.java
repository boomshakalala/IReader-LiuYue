package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;

import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.AllCommentAdapter;
import com.tenghen.ireader.adapter.AllGiftAdapter;
import com.tenghen.ireader.base.BaseListActivity;
import com.tenghen.ireader.module.Comment;
import com.tenghen.ireader.module.Gift;
import com.tenghen.ireader.module.GiftLog;
import com.tenghen.ireader.ui.present.MoreCommentPresent;
import com.tenghen.ireader.ui.present.MoreGiftPresent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengx on 18-2-1.
 */

public class MoreGiftActivity extends BaseListActivity<MoreGiftPresent,GiftLog> {
    List<GiftLog> data;

    public static void launch(Context context,String bookId){
        Intent intent = new Intent(context,MoreGiftActivity.class);
        intent.putExtra("bookId",bookId);
        context.startActivity(intent);
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("捧场记录");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_more_comment;
    }

    @Override
    public void initData() {
        data = new ArrayList<>();
        adapter = new AllGiftAdapter(this, R.layout.item_book_detail_gift_log,data);
        ((MoreGiftPresent)getPresent()).setBookId(getIntent().getStringExtra("bookId"));
    }

    @Override
    public void initViews() {
        super.initViews();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setCanloadMore(true);
        getPresent().refresh();
    }

    @Override
    public void setListener() {

    }

    @Override
    public MoreGiftPresent newPresent() {
        return new MoreGiftPresent();
    }
}
