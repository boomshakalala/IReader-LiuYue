package com.tenghen.ireader.wxapi;

import android.support.v7.app.AlertDialog;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.umeng.socialize.weixin.view.WXCallbackActivity;

/**
 * 作者: 陈冠希
 * 日期: 2018/3/26
 * 描述:
 */

public class WXPayEntryActivity extends WXCallbackActivity {

    @Override
    public void onResp(BaseResp resp) {
        super.onResp(resp);
        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("支付结果");
            builder.setMessage(resp.errCode + "");
            builder.show();
        }
    }
}
