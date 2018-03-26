package com.chengx.mvp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.chengx.mvp.R;
import com.chengx.mvp.utils.ToastUtils;
import com.chengx.mvp.widget.pull2refresh.PullToRefreshBase;
import com.chengx.mvp.widget.pull2refresh.PullToRefreshRecyclerView;

/**
 * 作者：chengx
 * 日期：2017/2/22
 * 描述：
 */

public class XRecyclerView extends FrameLayout {
    private PullToRefreshRecyclerView recyclerView;
    private ViewGroup emptyView;
    private ViewGroup errorView;
    private ViewGroup progressView;
    private TextView tipView;
    private int emptyViewId;
    private int errorViewId;
    private int progressViewId;

    private boolean canloadMore = true;

    private Context context;

    public XRecyclerView(Context context) {
        this(context,null);
    }

    public XRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public XRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        if (attrs != null){
            initAttrs(attrs);
        }
        initView();
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.XRecyclerView);
        try {
            emptyViewId = a.getResourceId(R.styleable.XRecyclerView_emptyView,R.layout.common_empty_view);
            errorViewId = a.getResourceId(R.styleable.XRecyclerView_errorView,R.layout.common_net_error_view);
            progressViewId = a.getResourceId(R.styleable.XRecyclerView_progressView,R.layout.common_progress_view);
        } finally {
            a.recycle();
        }
    }

    private void initView(){
        View v = LayoutInflater.from(getContext()).inflate(R.layout.common_recyclerview,this);
        recyclerView = (PullToRefreshRecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.getLoadingLayoutProxy(true, true).setLoadingDrawable(getResources().getDrawable(R.drawable.default_ptr_rotate));
        setCanloadMore(true);
        progressView = (FrameLayout) findViewById(R.id.progressView);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        progressView.setLayoutParams(params);
        emptyView = (ViewGroup) findViewById(R.id.emptyView);
        errorView = (ViewGroup) findViewById(R.id.errorView);

        if (progressViewId != 0)

             progressView.addView(LayoutInflater.from(getContext()).inflate(progressViewId,null));
        progressView = (ViewGroup) v.findViewById(R.id.progressView);
        if (emptyViewId != 0)
            emptyView.addView(LayoutInflater.from(getContext()).inflate(emptyViewId,null));
        emptyView = (ViewGroup) v.findViewById(R.id.emptyView);
        if (errorViewId != 0)
            errorView.addView(LayoutInflater.from(getContext()).inflate(errorViewId,null));
        errorView = (ViewGroup) v.findViewById(R.id.errorView);
    }

    private void hideAll(){
        emptyView.setVisibility(GONE);
        progressView.setVisibility(GONE);
        errorView.setVisibility(GONE);
        recyclerView.setVisibility(INVISIBLE);
    }

    public void showEmpty(){
        recyclerView.onRefreshComplete();
        if (emptyView.getChildCount()>0){
            hideAll();
            emptyView.setVisibility(VISIBLE);
        }else {
            showContent();
        }
    }

    public void showError(){
        recyclerView.onRefreshComplete();
        if (errorView.getChildCount()>0){
            hideAll();
            errorView.setVisibility(VISIBLE);
            recyclerView.onRefreshComplete();
        }else {
            showContent();
        }
    }

    public void showProgress(){
        if (progressView.getChildCount()>0){
            hideAll();
            progressView.setVisibility(VISIBLE);
        }else {
            showContent();
        }
    }

    public void showContent(){
        hideAll();
        recyclerView.setVisibility(VISIBLE);
    }

    public void setAdapter(RecyclerView.Adapter adapter){
        recyclerView.setAdapter(adapter);
    }

    public void setLayoutManager(RecyclerView.LayoutManager manager){
        recyclerView.setLayoutManager(manager);
    }

    public void closeLoadMore(){
        ToastUtils.showToast(context,"别撸了 到底儿了");
        recyclerView.onRefreshComplete();
    }

    public void closeRefresh(){
        recyclerView.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
    }

    public void setRefreshListener(PullToRefreshBase.OnRefreshListener2<RecyclerView> refreshListener) {
        recyclerView.setOnRefreshListener(refreshListener);
    }

    public void onRefreshComplete(){
        recyclerView.onRefreshComplete();
    }

    public void setOnErrorClickListener(OnClickListener listener){
        errorView.setOnClickListener(listener);
    }

    public boolean isRefreshing(){
        return recyclerView.isRefreshing();
    }

    public void smoothToTop(){
        recyclerView.getRefreshableView().smoothScrollToPosition(0);
    }

    public void setCanloadMore(boolean canloadMore) {
        // 下拉刷新时的提示文本设置
        recyclerView.getLoadingLayoutProxy(true, false).setPullLabel("下拉刷新");
        recyclerView.getLoadingLayoutProxy(true, false).setRefreshingLabel("正在加载...");
        recyclerView.getLoadingLayoutProxy(true, false).setReleaseLabel("放开以刷新");
        // 上拉加载更多时的提示文本设置
        if (canloadMore){
            recyclerView.setMode(PullToRefreshBase.Mode.BOTH);
            recyclerView.getLoadingLayoutProxy(false, true).setPullLabel("上拉加载");
            recyclerView.getLoadingLayoutProxy(false, true).setRefreshingLabel("正在加载...");
            recyclerView.getLoadingLayoutProxy(false, true).setReleaseLabel("放开以加载");
        }else {
            recyclerView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        }
        requestLayout();
    }
}
