package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;

import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.BookDetailAdapter;
import com.tenghen.ireader.adapter.BookDetailGiftDelegate;
import com.tenghen.ireader.base.BaseListActivity;
import com.tenghen.ireader.ui.present.BookDetailPresent;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * 作者：chengx
 * 日期：2017/3/7
 * 描述：
 */

public class BookDetailActivity extends BaseListActivity<BookDetailPresent,Object> {
    List<Object> data;

    public static void launch(Context context,String bookId){
        Intent intent = new Intent(context,BookDetailActivity.class);
        intent.putExtra("bookId",bookId);
        context.startActivity(intent);
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("图书详情");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_book_detail;
    }

    @Override
    public void initData() {
        String bookId = getIntent().getStringExtra("bookId");
        if(bookId!=null)
            ((BookDetailPresent)getPresent()).setBookId(bookId);
        data = new ArrayList<>();
        adapter = new BookDetailAdapter(this,data,bookId);
        EventBus.getDefault().register(this);
    }

    @Override
    public void initViews() {
        super.initViews();
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int viewType = adapter.getItemViewType(position);
                return ((BookDetailAdapter)adapter).getItemViewDelegate(viewType) instanceof BookDetailGiftDelegate ? 1 : 3;
            }
        });
        recyclerView.setCanloadMore(false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        getPresent().refresh();
    }

    @Override
    public void setListener() {

    }

    @Override
    public BookDetailPresent newPresent() {
        return new BookDetailPresent();
    }

    public void onEventMainThread(String str){
        if (str.equals("refresh")){
            getPresent().refresh();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
