package com.tenghen.ireader.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseActivity;
import com.tenghen.ireader.ui.fragment.FeaturedFragment;
import com.tenghen.ireader.ui.fragment.FindFragment;
import com.tenghen.ireader.ui.fragment.SearchFragment;
import com.tenghen.ireader.ui.fragment.StacksFragment;
import com.tenghen.ireader.ui.fragment.UserFragment;
import com.tenghen.ireader.ui.present.MainPresent;


import butterknife.BindView;

/**
 * 作者：chengx
 * 日期：2017/2/23
 * 描述：
 */

public class MainActivity extends BaseActivity<MainPresent> implements View.OnClickListener {

    public final static int INDEX_FEATURED = 1;
    public final static int INDEX_STACKS = 2;
    public final static int INDEX_SEARCH = 3;
    public final static int INDEX_FIND = 4;
    public final static int INDEX_USER = 5;

    @BindView(R.id.mainFeaturedBtn)
    public TextView featuredBtn;
    @BindView(R.id.mainStacksBtn)
    public TextView stacksBtn;
    @BindView(R.id.mainSearchBtn)
    public TextView searchBtn;
    @BindView(R.id.mainFindBtn)
    public TextView findBtn;
    @BindView(R.id.mainUserBtn)
    public TextView userBtn;

    private FeaturedFragment featuredFragment;
    private StacksFragment stacksFragment;
    private SearchFragment searchFragment;
    private FindFragment findFragment;
    private UserFragment userFragment;


    public static void launch(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initViews() {
        setSelected(INDEX_FEATURED);
    }

    @Override
    public void setListener() {
        featuredBtn.setOnClickListener(this);
        stacksBtn.setOnClickListener(this);
        searchBtn.setOnClickListener(this);
        findBtn.setOnClickListener(this);
        userBtn.setOnClickListener(this);
    }

    @Override
    public MainPresent newPresent() {
        return new MainPresent();
    }

    private void resetBtn(){
        featuredBtn.setSelected(false);
        stacksBtn.setSelected(false);
        searchBtn.setSelected(false);
        findBtn.setSelected(false);
        userBtn.setSelected(false);
    }

    private void hideTransaction(FragmentTransaction ft){
        if (featuredFragment != null) {
            ft.hide(featuredFragment);
        }
        if (stacksFragment != null) {
            ft.hide(stacksFragment);
        }
        if (searchFragment != null) {
            ft.hide(searchFragment);
        }
        if (findFragment != null) {
            ft.hide(findFragment);
        }
        if (userFragment != null) {
            ft.hide(userFragment);
        }
    }

    public void setSelected(int index){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        hideTransaction(ft);
        resetBtn();
        switch (index){
            case INDEX_FEATURED:
                if (featuredFragment == null) {
                    featuredFragment = new FeaturedFragment();
                    ft.add(R.id.mainContainerLayout,featuredFragment);
                }
                ft.show(featuredFragment);
                featuredBtn.setSelected(true);
                break;
            case INDEX_STACKS:
                if (stacksFragment == null) {
                    stacksFragment = new StacksFragment();
                    ft.add(R.id.mainContainerLayout,stacksFragment);
                }
                ft.show(stacksFragment);
                stacksBtn.setSelected(true);
                break;
            case INDEX_SEARCH:
                if (searchFragment == null) {
                    searchFragment = new SearchFragment();
                    ft.add(R.id.mainContainerLayout,searchFragment);
                }
                ft.show(searchFragment);
                searchBtn.setSelected(true);
                break;
            case INDEX_FIND:
                if (findFragment == null) {
                    findFragment = new FindFragment();
                    ft.add(R.id.mainContainerLayout,findFragment);
                }
                ft.show(findFragment);
                findBtn.setSelected(true);
                break;
            case INDEX_USER:
                if (userFragment == null) {
                    userFragment = new UserFragment();
                    ft.add(R.id.mainContainerLayout,userFragment);
                }
                ft.show(userFragment);
                userBtn.setSelected(true);
                break;
            default:
                break;
        }
        ft.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mainFeaturedBtn:
                setSelected(INDEX_FEATURED);
                break;
            case R.id.mainStacksBtn:
                setSelected(INDEX_STACKS);
                break;
            case R.id.mainSearchBtn:
                setSelected(INDEX_SEARCH);
                break;
            case R.id.mainFindBtn:
                setSelected(INDEX_FIND);
                break;
            case R.id.mainUserBtn:
                setSelected(INDEX_USER);
                break;

        }
    }
}
