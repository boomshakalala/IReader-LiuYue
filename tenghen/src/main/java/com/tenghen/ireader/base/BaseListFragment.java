package com.tenghen.ireader.base;

import android.support.v7.widget.RecyclerView;

import com.chengx.mvp.base.IListPresent;
import com.chengx.mvp.base.XListFragment;
import com.chengx.mvp.base.XListPresent;
import com.chengx.mvp.widget.XRecyclerView;
import com.chengx.mvp.widget.pull2refresh.PullToRefreshBase;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.User;

/**
 * 作者：chengx
 * 日期：2017/2/23
 * 描述：
 */

public abstract class BaseListFragment<T extends IListPresent,M> extends XListFragment<T,M> implements PullToRefreshBase.OnRefreshListener2<RecyclerView> {

    @Override
    public void initViews() {
        recyclerView = (XRecyclerView) rootView.findViewById(R.id.xRecyclerView);
        recyclerView.setRefreshListener(this);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
        if (getPresent() != null && getPresent() instanceof XListPresent) {
            ((XListPresent)getPresent()).refresh();
        }
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
        if (getPresent() != null && getPresent() instanceof XListPresent) {
            ((XListPresent)getPresent()).loadMore();
        }
    }

    public boolean isLogin(){
        return   getUserInfo() != null;
    }

    public User getUserInfo(){
        return sp.getObject("user",null);
    }
}
