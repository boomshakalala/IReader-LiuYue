package com.chengx.mvp.base;

import android.support.v7.widget.RecyclerView;

import com.chengx.mvp.R;
import com.chengx.mvp.adapter.CommonRecyclerAdapter;
import com.chengx.mvp.adapter.HeaderAndFooterCommonAdapter;
import com.chengx.mvp.adapter.MultiItemCommonAdapter;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.chengx.mvp.utils.KLog;
import com.chengx.mvp.widget.XRecyclerView;

import java.util.List;

import butterknife.BindView;

/**
 * 作者：chengx
 * 日期：2017/2/23
 * 描述：
 */

public abstract class XListFragment<T extends IListPresent,M> extends XFragment implements IListView<T,M> {
    protected XRecyclerView recyclerView;
    protected RecyclerView.Adapter<RecyclerViewHolder> adapter;


    @Override
    public void refresh(List<M> data) {
        log("refreshData");
        if (adapter instanceof CommonRecyclerAdapter){
            ((CommonRecyclerAdapter)adapter).setData(data);
        }else if (adapter instanceof HeaderAndFooterCommonAdapter){
            ((HeaderAndFooterCommonAdapter)adapter).setData(data);
        }else if (adapter instanceof MultiItemCommonAdapter){
            ((MultiItemCommonAdapter)adapter).setData(data);
        }
        recyclerView.onRefreshComplete();
    }

    @Override
    public void loadMore(List<M> data) {
        if (adapter instanceof CommonRecyclerAdapter){
            ((CommonRecyclerAdapter)adapter).loadMore(data);
        }else if (adapter instanceof HeaderAndFooterCommonAdapter){
            ((HeaderAndFooterCommonAdapter)adapter).loadMore(data);
        }else if (adapter instanceof MultiItemCommonAdapter){
            ((MultiItemCommonAdapter)adapter).loadMore(data);
        }
        recyclerView.onRefreshComplete();
    }

    @Override
    public void showTip(String msg) {
        showToast(msg);
    }

    @Override
    public void showEmpty() {
        recyclerView.showEmpty();
    }

    @Override
    public void showError() {
        recyclerView.showError();
    }

    @Override
    public void closeLoadMore() {
        recyclerView.closeLoadMore();
    }

    @Override
    public void showProgress() {
        recyclerView.showProgress();
    }

    @Override
    public void hideProgress() {
        recyclerView.showContent();
    }

}
