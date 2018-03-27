package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.CommonUtils;
import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.Cost;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.activity.CostLogActivity;

import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class CostLogPresent extends BaseListPresent<CostLogActivity> {
    @Override
    protected void requestData() {
        getV().showProgress();
        Api.userMyConsumeRecord(currentPage, new ResponseCallback<List<Cost>>() {
            @Override
            public void onSuccess(List<Cost> data) {
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
}
