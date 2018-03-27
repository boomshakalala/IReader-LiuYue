package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.MyRehargeRecord;
import com.tenghen.ireader.module.Recharge;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.activity.RechargeLogActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class RechargeLogPresent extends BaseListPresent<RechargeLogActivity> {
    final List<Object> data = new ArrayList<>();
    @Override
    protected void requestData() {
        getV().showProgress();
        Api.userMyRechargeRecord(currentPage, new ResponseCallback<MyRehargeRecord>() {
            @Override
            public void onSuccess(MyRehargeRecord rehargeRecord) {
                String money = rehargeRecord.getMoney();
                if (currentPage == 1)
                    data.clear();
                    data.add(money);
                List<Recharge> datalist = rehargeRecord.getRecord();
                if (datalist == null || datalist.size() == 0){
                    if (currentPage != 1){
                        getV().closeLoadMore();
                    }else {
                        getV().refresh(data);
                    }
                    return;
                }
                data.addAll(datalist);
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
