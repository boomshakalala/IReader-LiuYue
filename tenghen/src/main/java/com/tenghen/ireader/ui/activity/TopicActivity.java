package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;

import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.TopicAdapter;
import com.tenghen.ireader.base.BaseListActivity;
import com.tenghen.ireader.module.Topic;
import com.tenghen.ireader.ui.present.TopicPresent;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class TopicActivity extends BaseListActivity<TopicPresent,Topic> {
    List<Topic> data;

    public static void launch(Context context){
        Intent intent = new Intent(context,TopicActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("最新活动");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_topic_list;
    }

    @Override
    public void initData() {
        data = new ArrayList<>();
        adapter = new TopicAdapter(this,R.layout.item_topic_list,data);
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
    public TopicPresent newPresent() {
        return new TopicPresent();
    }
}
