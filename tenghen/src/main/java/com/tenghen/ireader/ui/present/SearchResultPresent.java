package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.CategoryBook;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.activity.SearchActivity;

import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/3/6
 * 描述：
 */

public class SearchResultPresent extends BaseListPresent<SearchActivity> {

    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    protected void requestData() {
        Api.getSearchBooks(keyword, currentPage, new ResponseCallback<List<CategoryBook>>() {
            @Override
            public void onSuccess(List<CategoryBook> data) {
            if (data == null || data.size() == 0){
                if (currentPage == 1){
                    getV().showEmpty();
                }else {
                    getV().closeLoadMore();
                }
                return;
            }
            if (currentPage == 1){
                getV().refresh(data);
            }else {
                getV().loadMore(data);
            }
        }

        @Override
        public void onFailure(int errCode, String info) {
            getV().showTip(info);
            getV().showError();
        }
        });
    }
}
