package com.tenghen.ireader.ui.present;

import com.chengx.mvp.base.XListPresent;
import com.tenghen.ireader.module.GiftLog;
import com.tenghen.ireader.module.RewardsLog;
import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.module.Comment;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.activity.MoreCommentActivity;
import com.tenghen.ireader.ui.activity.MoreGiftActivity;

import java.util.List;

/**
 * Created by chengx on 18-2-1.
 */

public class MoreGiftPresent extends XListPresent<MoreGiftActivity> {

    String bookId;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override
    protected void requestData() {
        getV().showProgress();
        Api.bookGift(bookId,currentPage, new ResponseCallback<RewardsLog>() {
            @Override
            public void onSuccess(RewardsLog RewardsLog) {
                if (RewardsLog != null) {
                    List<GiftLog> data = RewardsLog.getList();
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
                }else {
                    if (currentPage == 1){
                        getV().showEmpty();
                    }else {
                        getV().closeLoadMore();
                    }
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
