package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.AllCommentAdapter;
import com.tenghen.ireader.adapter.MyMsgAdapter;
import com.tenghen.ireader.base.BaseListActivity;
import com.tenghen.ireader.module.Comment;
import com.tenghen.ireader.module.Msg;
import com.tenghen.ireader.ui.present.MoreCommentPresent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengx on 18-2-1.
 */

public class MoreCommentActivity extends BaseListActivity<MoreCommentPresent,Comment> {
    List<Comment> data;

    public static void launch(Context context,String bookId){
        Intent intent = new Intent(context,MoreCommentActivity.class);
        intent.putExtra("bookId",bookId);
        context.startActivity(intent);
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("全部评论");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_more_comment;
    }

    @Override
    public void initData() {
        data = new ArrayList<>();
        adapter = new AllCommentAdapter(this, R.layout.item_book_detail_comment,data);
        ((MoreCommentPresent)getPresent()).setBookId(getIntent().getStringExtra("bookId"));
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
    public MoreCommentPresent newPresent() {
        return new MoreCommentPresent();
    }
}
