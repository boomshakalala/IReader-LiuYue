package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.base.BasePresent;
import com.tenghen.ireader.module.BindInfo;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.ui.activity.UserBindActivity;

/**
 * Created by chengx on 18-2-8.
 */

public class UserBindPresent extends BasePresent<UserBindActivity> {

    public void getBindInfo(){
        getV().showProgress();
        Api.userAccountBIndStatus(new ResponseCallback<BindInfo>() {
            @Override
            public void onSuccess(BindInfo data) {
                getV().dismissDialog();
                if (data != null) {
                    getV().setBindInfo(data);
                }
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().dismissDialog();
                getV().showTip(info);
            }
        });
    }

    public void bind(String type,String uid){

    }
}
