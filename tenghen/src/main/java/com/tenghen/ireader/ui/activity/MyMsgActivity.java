package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;

import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.MyMsgAdapter;
import com.tenghen.ireader.base.BaseListActivity;
import com.tenghen.ireader.module.Msg;
import com.tenghen.ireader.ui.present.MyMsgPresent;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class MyMsgActivity extends BaseListActivity<MyMsgPresent,Msg> {
    List<Msg> data;

    public static void launch(Context context){
        Intent intent = new Intent(context,MyMsgActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("我的消息");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_msg_log;
    }

    @Override
    public void initData() {
        data = new ArrayList<>();
        adapter = new MyMsgAdapter(this,R.layout.item_my_msg,data);
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
    public MyMsgPresent newPresent() {
        return new MyMsgPresent();
    }
}
