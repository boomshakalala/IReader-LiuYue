package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.CommonUtils;
import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.Chapter;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.activity.ChapterListActivity;

import java.util.List;

/**
 * Created by Administrator on 2018/2/4/004.
 */

public class ChapterListPresent extends BaseListPresent<ChapterListActivity> {
    String bookId;

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override
    protected void requestData() {
        getV().showProgress();
        Api.chapterBookChapters(bookId,currentPage, new ResponseCallback<List<Chapter>>() {
            @Override
            public void onSuccess(List<Chapter> data) {
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
