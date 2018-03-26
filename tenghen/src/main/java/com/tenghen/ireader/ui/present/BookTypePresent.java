package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.CommonUtils;
import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.CategoryBook;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.activity.BookTypeActivity;

import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/2/28
 * 描述：
 */

public class BookTypePresent extends BaseListPresent<BookTypeActivity> {
    private int category = 0;
    private int cost = 0;
    private int rate = 0;
    private int sort = 1;

    @Override
    protected void requestData() {
        getV().showProgress();
        Api.getCategoryBooks(category, cost, rate,sort,currentPage, new ResponseCallback<List<CategoryBook>>() {
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
                CommonUtils.error(errCode,getV());
            }
        });
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
