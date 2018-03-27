package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.BookTypeAdapter;
import com.tenghen.ireader.base.BaseListActivity;
import com.tenghen.ireader.module.CategoryBook;
import com.tenghen.ireader.ui.present.SearchResultPresent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 作者：chengx
 * 日期：2017/3/6
 * 描述：
 */

public class SearchActivity extends BaseListActivity<SearchResultPresent,CategoryBook> implements View.OnClickListener, TextView.OnEditorActionListener {

    @BindView(R.id.searchView)
    public EditText searchView;
    @BindView(R.id.cancelBtn)
    public TextView cancelBtn;

    private String keyword;
    private List<CategoryBook> data;

    public static void launch(Context context,String keyword){
        Intent intent = new Intent(context,SearchActivity.class);
        intent.putExtra("keyword",keyword);
        context.startActivity(intent);
    }


    @Override
    public void initToolBar() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initData() {
        keyword = getIntent().getStringExtra("keyword");
        data = new ArrayList<>();
        adapter = new BookTypeAdapter(this,R.layout.item_book_type,data);
    }

    @Override
    public void initViews() {
        super.initViews();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.closeRefresh();
        if (keyword != null && !keyword.isEmpty()) {
            ((SearchResultPresent)getPresent()).setKeyword(keyword);
            searchView.setText(keyword);
            getPresent().refresh();
        }
    }

    @Override
    public void setListener() {
        cancelBtn.setOnClickListener(this);
        searchView.setOnEditorActionListener(this);
    }

    @Override
    public SearchResultPresent newPresent() {
        return new SearchResultPresent();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cancelBtn:
                finish();
                break;
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if(i == EditorInfo.IME_ACTION_SEARCH) {
            keyword = searchView.getText().toString().trim();
            if (keyword.isEmpty()) {
                showTip("请输入关键字");
                return false;
            }
            ((SearchResultPresent)getPresent()).setKeyword(keyword);
            getPresent().refresh();
        }
        return false;
    }
}
