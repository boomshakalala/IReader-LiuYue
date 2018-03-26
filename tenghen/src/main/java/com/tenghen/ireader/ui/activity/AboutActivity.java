package com.tenghen.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;

import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseActivity;

/**
 * Created by Administrator on 2018/2/4/004.
 */

public class AboutActivity extends BaseActivity {
    public static void launch(Context context){
        Intent intent = new Intent(context,AboutActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("关于我们");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initViews() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public Object newPresent() {
        return null;
    }
}
