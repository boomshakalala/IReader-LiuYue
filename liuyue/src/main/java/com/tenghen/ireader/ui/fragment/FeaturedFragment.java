package com.tenghen.ireader.ui.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.chengx.mvp.adapter.MultiItemCommonAdapter;
import com.chengx.mvp.base.XListPresent;
import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.FeaturedAdapter;
import com.tenghen.ireader.adapter.FeaturedBookDelegate;
import com.tenghen.ireader.base.BaseListFragment;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.ui.activity.BookDetailActivity;
import com.tenghen.ireader.ui.activity.SearchActivity;
import com.tenghen.ireader.ui.present.FeaturedPresent;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

import butterknife.BindView;

/**
 * 作者：chengx
 * 日期：2017/2/23
 * 描述：
 */

public class FeaturedFragment extends BaseListFragment<FeaturedPresent,Object> implements View.OnClickListener, MultiItemCommonAdapter.OnItemClickListener {
    @BindView(R.id.searchBtn)
    public TextView searchBtn;

    private List<Object> data;

    @Override
    public void initToolBar() {
        toolbar.setNavigationIcon(R.drawable.btn_back);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_featured;
    }

    @Override
    public void initData() {
        data = new ArrayList<>();
        adapter = new FeaturedAdapter(getContext(),data);

    }

    @Override
    public void initViews() {
        super.initViews();
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),3);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int viewType = adapter.getItemViewType(position);
                return ((FeaturedAdapter)adapter).getItemViewDelegate(viewType) instanceof FeaturedBookDelegate ? 1 : 3;
            }
        });
        recyclerView.setCanloadMore(false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        ((XListPresent)getPresent()).refresh();
    }

    @Override
    public void setListener() {
        searchBtn.setOnClickListener(this);
//        ((FeaturedAdapter)adapter).setOnItemClickListener(this);
    }

    @Override
    public FeaturedPresent newPresent() {
        return new FeaturedPresent();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.searchBtn:
                SearchActivity.launch(getContext(),"");
                break;
        }
    }

    @Override
    public void onItemClick(View view, Object data) {
       if (data instanceof Book){
           Book book = (Book) data;
           BookDetailActivity.launch(getActivity(),book.getId());
       }

    }
}
