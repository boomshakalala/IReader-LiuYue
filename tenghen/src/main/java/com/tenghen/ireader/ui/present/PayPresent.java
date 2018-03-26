package com.tenghen.ireader.ui.present;

import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.aliapi.Alipay;
import com.tenghen.ireader.base.BasePresent;
import com.tenghen.ireader.module.OrderInfo;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.activity.RechargeMoneyActivity;

public class PayPresent extends BasePresent<RechargeMoneyActivity> {
    private IWXAPI wxApi;

    public PayPresent(){
    }

    @Override
    public void attachV(RechargeMoneyActivity rechargeMoneyActivity) {
        super.attachV(rechargeMoneyActivity);
        wxApi =  WXAPIFactory.createWXAPI(getV(),"wx3d9ce0777f5b1e26");
    }

    public void pay(int money, final String payType){
        getV().showProgress();
        Api.orderRecharge(String.valueOf(money), payType, "1", "", new ResponseCallback<OrderInfo>() {
            @Override
            public void onSuccess(OrderInfo data) {
                String orderInfo = data.getResponse();
                switch (payType){
                    case "1":
                        Alipay.getInstance().pay(getV(),orderInfo);
                        break;
                    case "2":
                        PayReq req = new PayReq();
                        req.appId = data.getAppId();
                        req.partnerId = data.getPartnerId();
                        //预支付订单
                        req.prepayId = data.getPrepayId();
                        req.nonceStr = data.getNonceStr();
                        req.timeStamp = data.getTimeStamp()+"";
                        req.packageValue = data.getPackageValue();
                        req.sign = data.getSign();
                        wxApi.sendReq(req);
                        break;
                }
                getV().dismissDialog();
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().dismissDialog();
                getV().showTip(info);
            }
        });
    }

}