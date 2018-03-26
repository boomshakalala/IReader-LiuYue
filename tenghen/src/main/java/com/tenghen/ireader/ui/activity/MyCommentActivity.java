package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;

import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.MyCommentAdapter;
import com.tenghen.ireader.base.BaseListActivity;
import com.tenghen.ireader.module.Comment;
import com.tenghen.ireader.module.MyCommentBean;
import com.tenghen.ireader.ui.present.MyCommentPresent;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.sax.TemplatesHandler;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class MyCommentActivity extends BaseListActivity<MyCommentPresent,MyCommentBean> {
    List<MyCommentBean> data;

    public static void launch(Context context){
        Intent intent = new Intent(context,MyCommentActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("我的评论");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_comment;
    }

    @Override
    public void initData() {
        data = new ArrayList<>();
        adapter = new MyCommentAdapter(this,R.layout.item_my_comment,data);
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
    public MyCommentPresent newPresent() {
        return new MyCommentPresent();
    }
}
