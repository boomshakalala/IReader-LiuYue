package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;

import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.BookListDelegate;
import com.tenghen.ireader.adapter.FreeBookAdapter;
import com.tenghen.ireader.adapter.FreeBookDelegate;
import com.tenghen.ireader.base.BaseListActivity;
import com.tenghen.ireader.ui.present.FreeBookPresent;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/3/1
 * 描述：
 */

public class FreeBookActivity extends BaseListActivity<FreeBookPresent,Object> {
    List<Object> data;

    public static void launch(Context context){
        Intent intent = new Intent(context, FreeBookActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("免费");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_monthly;
    }

    @Override
    public void initData() {
        data = new ArrayList<>();
        adapter = new FreeBookAdapter(this,data);
    }

    @Override
    public void initViews() {
        super.initViews();
        GridLayoutManager layoutManager = new GridLayoutManager(this,6);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int viewType = adapter.getItemViewType(position);
                if (((FreeBookAdapter)adapter).getItemViewDelegate(viewType) instanceof FreeBookDelegate){
                    return 2;
                }else if (((FreeBookAdapter)adapter).getItemViewDelegate(viewType) instanceof BookListDelegate){
                    return 3;
                }else {
                    return 6;
                }
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        getPresent().refresh();
    }

    @Override
    public void setListener() {

    }

    @Override
    public FreeBookPresent newPresent() {
        return new FreeBookPresent();
    }
}
