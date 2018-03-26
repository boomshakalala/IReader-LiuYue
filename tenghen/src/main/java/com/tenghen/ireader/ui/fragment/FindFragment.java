package com.tenghen.ireader.ui.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseFragment;
import com.tenghen.ireader.ui.activity.DynamicActivity;
import com.tenghen.ireader.ui.activity.RankActivity;
import com.tenghen.ireader.ui.activity.SearchActivity;
import com.tenghen.ireader.ui.activity.TopicActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：chengx
 * 日期：2017/2/23
 * 描述：
 */

public class FindFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.searchBtn)
    public TextView searchBtn;

    @Override
    public void initToolBar() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_find;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initViews() {

    }

    @Override
    public void setListener() {
        searchBtn.setOnClickListener(this);
    }

    @Override
    public Object newPresent() {
        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.searchBtn:
                SearchActivity.launch(getContext(),"");
                break;
        }
    }

    @OnClick(R.id.topicBtn)
    public void toTopic(){
        TopicActivity.launch(getContext());
    }

    @OnClick(R.id.dynamicBtn)
    public void toDynamic(){
        DynamicActivity.launch(getContext());
    }

    @OnClick(R.id.rankBtn)
    public void toRank(){
        RankActivity.launch(getContext());
    }
}
