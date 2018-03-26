package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.chengx.mvp.base.XListFragment;
import com.chengx.mvp.base.XListPresent;
import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.BookRankAdapter;
import com.tenghen.ireader.base.BaseListActivity;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.module.RankBook;
import com.tenghen.ireader.ui.present.RankPresent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 作者：chengx
 * 日期：2017/2/28
 * 描述：
 */

public class RankActivity extends BaseListActivity<RankPresent,RankBook> implements View.OnClickListener {

    public static final int INDEX_WEEK = 0;
    public static final int INDEX_MONTH = 1;
    public static final int INDEX_ALL = 2;

    @BindView(R.id.weekRankBtn)
    public TextView weekRankBtn;
    @BindView(R.id.monthRankBtn)
    public TextView monthRankBtn;
    @BindView(R.id.allRankBtn)
    public TextView allRankBtn;

    List<RankBook> data;
    private int rankId;
    private String category;

    public static void launch(Context context,int rankId,String category){
        Intent intent = new Intent(context,RankActivity.class);
        intent.putExtra("rankId",rankId);
        intent.putExtra("category",category);
        context.startActivity(intent);
    }

    public static void launch(Context context){
        Intent intent = new Intent(context,RankActivity.class);
        intent.putExtra("rankId",1);
        intent.putExtra("category","点击榜");
        context.startActivity(intent);
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle(category);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_rank;
    }

    @Override
    public void initData() {
        data = new ArrayList<>();
        adapter = new BookRankAdapter(this,R.layout.item_book_rank,data);
        rankId = getIntent().getIntExtra("rankId",0);
        category = getIntent().getStringExtra("category");
    }

    @Override
    public void initViews() {
        super.initViews();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        setSelected(INDEX_WEEK);
    }

    @Override
    public void setListener() {
        weekRankBtn.setOnClickListener(this);
        monthRankBtn.setOnClickListener(this);
        allRankBtn.setOnClickListener(this);
    }

    @Override
    public RankPresent newPresent() {
        return new RankPresent();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.weekRankBtn:
                setSelected(INDEX_WEEK);
                break;
            case R.id.monthRankBtn:
                setSelected(INDEX_MONTH);
                break;
            case R.id.allRankBtn:
                setSelected(INDEX_ALL);
                break;
        }
    }

    private void setSelected(int index){
        resetBtn();
        switch (index){
            case INDEX_WEEK:
                weekRankBtn.setSelected(true);
                break;
            case INDEX_MONTH:
                monthRankBtn.setSelected(true);
                break;
            case INDEX_ALL:
                allRankBtn.setSelected(true);
                break;
        }
        ((RankPresent)getPresent()).setDate_id(index);
        ((RankPresent)getPresent()).setRanking_id(rankId);
        getPresent().refresh();
    }

    private void resetBtn(){
        weekRankBtn.setSelected(false);
        monthRankBtn.setSelected(false);
        allRankBtn.setSelected(false);
    }
}
