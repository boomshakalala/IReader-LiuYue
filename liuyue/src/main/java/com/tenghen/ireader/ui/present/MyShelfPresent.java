package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.activity.MyShelfActivity;

import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class MyShelfPresent extends BaseListPresent<MyShelfActivity> {
    @Override
    protected void requestData() {
        getV().showProgress();
        Api.userMyBookCase(currentPage, new ResponseCallback<List<Book>>() {
            @Override
            public void onSuccess(List<Book> data) {
                if (data == null || data.size() == 0) {
                    if (currentPage == 1) {
                        getV().showEmpty();
                    } else {
                        getV().closeLoadMore();
                    }
                    return;
                }
                if (currentPage == 1) {
                    getV().refresh(data);
                } else {
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
