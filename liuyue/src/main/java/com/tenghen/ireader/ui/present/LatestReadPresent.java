package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.LatestBook;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.activity.LatestReadActivity;

import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class LatestReadPresent extends BaseListPresent<LatestReadActivity> {
    @Override
    protected void requestData() {
        getV().showProgress();
        Api.userMyReadRecord(currentPage, new ResponseCallback<List<LatestBook>>() {
            @Override
            public void onSuccess(List<LatestBook> data) {
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
