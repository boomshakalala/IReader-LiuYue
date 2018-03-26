package com.tenghen.ireader.ui.fragment;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.chengx.mvp.utils.SizeUtils;
import com.chengx.mvp.widget.FullyGridLayoutManager;
import com.chengx.mvp.widget.taglayout.TagItemClickListener;
import com.chengx.mvp.widget.taglayout.TagLayout;
import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.FeaturedAdapter;
import com.tenghen.ireader.adapter.HotBookAdapter;
import com.tenghen.ireader.adapter.SearchTagAdapter;
import com.tenghen.ireader.base.BaseFragment;
import com.tenghen.ireader.base.BaseListFragment;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.ui.activity.BookTypeActivity;
import com.tenghen.ireader.ui.activity.FreeBookActivity;
import com.tenghen.ireader.ui.activity.MainActivity;
import com.tenghen.ireader.ui.activity.MonthlyActivity;
import com.tenghen.ireader.ui.activity.SearchActivity;
import com.tenghen.ireader.ui.present.FeaturedPresent;
import com.tenghen.ireader.ui.present.SearchPresent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：chengx
 * 日期：2017/2/23
 * 描述：
 */

public class SearchFragment extends BaseFragment<SearchPresent> implements View.OnClickListener {

    @BindView(R.id.tagLayout)
    public TagLayout tagLayout;
    @BindView(R.id.recyclerView)
    public RecyclerView recyclerView;
    @BindView(R.id.searchBtn)
    public TextView searchBtn;
    @BindView(R.id.refreshKeywordsBtn)
    public TextView refreshKeywordsBtn;
    @BindView(R.id.scrollView)
    public ScrollView scrollView;

    private SearchTagAdapter tagAdapter;
    private HotBookAdapter bookAdapter;
    private List<String> tags;
    private List<Book> books;



    @Override
    public void initToolBar() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    public void initData() {
        tags = new ArrayList<>();
        books = new ArrayList<>();
        tagAdapter = new SearchTagAdapter(getContext(),tags,R.layout.item_search_tag);
        bookAdapter = new HotBookAdapter(getContext(),R.layout.item_hot_book,books);
    }

    @Override
    public void initViews() {
        tagLayout.setLineSpacing(SizeUtils.dp2px(getContext(),9));
        tagLayout.setTagSpacing(SizeUtils.dp2px(getContext(),16));
        recyclerView.setLayoutManager(new FullyGridLayoutManager(getContext(),4));
        recyclerView.setAdapter(bookAdapter);
        tagLayout.setAdapter(tagAdapter);
        getPresent().requestHotWords();
        getPresent().requestData();
    }

    @Override
    public void setListener() {
        tagLayout.setTagItemListener(new TagItemClickListener() {
            @Override
            public void itemClick(int position) {
                String keyword = tags.get(position);
                SearchActivity.launch(getContext(),keyword);
            }
        });
        searchBtn.setOnClickListener(this);
        refreshKeywordsBtn.setOnClickListener(this);
    }

    @Override
    public SearchPresent newPresent() {
        return new SearchPresent();
    }

    public void setHotWords(List<String> tags){
        tagAdapter.setData(tags);
    }

    public void setBooks(List<Book> books){
        bookAdapter.setData(books);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.searchBtn:
                SearchActivity.launch(getContext(),"");
                break;
            case R.id.refreshKeywordsBtn:
                getPresent().requestHotWords();
                break;
        }
    }

    @OnClick({R.id.freeBtn,R.id.monthBtn,R.id.allBtn,R.id.stacksBtn})
    public void click(View v){
        switch (v.getId()){
            case R.id.freeBtn:
                FreeBookActivity.launch(getContext());
                break;
            case R.id.monthBtn:
                MonthlyActivity.launch(getContext());
                break;
            case R.id.allBtn:
                    BookTypeActivity.launch(getContext(),BookTypeActivity.INDEX_TYPE_ALL);
                break;
            case R.id.stacksBtn:
                Activity activity = getActivity();
                if (activity instanceof MainActivity){
                    ((MainActivity)activity).setSelected(MainActivity.INDEX_STACKS);
                }
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        scrollView.scrollTo(0,0);
        getPresent().requestHotWords();
        getPresent().requestData();
    }

    public void scrollToHead(){
        scrollView.scrollTo(0,0);
    }
}
