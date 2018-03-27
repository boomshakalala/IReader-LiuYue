package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.base.BasePresent;
import com.tenghen.ireader.module.UserInfo;
import com.tenghen.ireader.module.Wallet;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.fragment.UserFragment;


/**
 * 作者：chengx
 * 日期：2017/2/23
 * 描述：
 */

public class UserPresent extends BasePresent<UserFragment> {
    @Override
    public void attachV(UserFragment userFragment) {
        super.attachV(userFragment);
    }

    @Override
    public void detachV() {
        super.detachV();
    }


    public void getWalletData(){
      Api.userMyWallet(new ResponseCallback<Wallet>() {
          @Override
          public void onSuccess(Wallet data) {
              if (data != null) {
                  getV().setWalletInfo(data);
              }
          }

          @Override
          public void onFailure(int errCode, String info) {
                getV().showTip(info);
          }
      });
    }

    public void getUserData(){
        Api.userUserInfo(new ResponseCallback<UserInfo>() {
            @Override
            public void onSuccess(UserInfo data) {
                if (data != null) {
                    getV().setUserInfo(data);
                }
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().showTip(info);
            }
        });
    }

    public void getSignData(){

    }



}
