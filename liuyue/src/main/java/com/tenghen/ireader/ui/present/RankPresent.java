package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.RankBook;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.activity.RankActivity;

import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/2/28
 * 描述：
 */

public class RankPresent extends BaseListPresent<RankActivity> {
    private int ranking_id;
    private int date_id;

    public int getRanking_id() {
        return ranking_id;
    }

    public void setRanking_id(int ranking_id) {
        this.ranking_id = ranking_id;
    }

    public int getDate_id() {
        return date_id;
    }

    public void setDate_id(int date_id) {
        this.date_id = date_id;
    }

    @Override
    protected void requestData() {
        getV().showProgress();
        Api.getRankingList(ranking_id, date_id, currentPage, new ResponseCallback<List<RankBook>>() {
            @Override
            public void onSuccess(List<RankBook> data) {
                if (data == null || data.isEmpty()){
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
