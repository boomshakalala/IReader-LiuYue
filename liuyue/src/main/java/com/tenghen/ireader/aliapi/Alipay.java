package com.tenghen.ireader.aliapi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.chengx.mvp.utils.AppUtils;

import java.util.Map;

public class Alipay {

    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;
    public static final String RSA2_PRIVATE = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAugHLG98l9zxRj9blcWzJ" +
            "xGZ7sbE8BCbOStRnxkkU6CJ6W12BG8zi205DkiklAXr22bJ+ragVzjbFoFmQIo3s" +
            "kbytxhnup+2ZEKcynlwA+e/DJcJbKYAVHmTmDW8LaAmrTRMd+MiE3JIborRSnriq" +
            "bHWoG6gxQrDeikfvPdzC7+0cad4/NrocJgxDB9YOx0RzOjNz0DZSA3cRwEe1X8LD" +
            "CbX8Ssc2NfKFq+uTJPDuXYplf+j3xCXZGIPwO8JsnCYXqL106CH1/wr2J+Kp07Nw" +
            "PSnCUZczDQHzVklDB6sVswKXp03dP0kJUcHH+qaxIlV0STZgE/bq1JK67GpZjsgZ" +
            "0QIDAQAB";

    private static Alipay mInstance;

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
            public boolean handleMessage(Message msg) {
                switch (msg.what) {
                    case SDK_PAY_FLAG: {
                        @SuppressWarnings("unchecked")
                        PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                        /**
                         对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                         */
                        String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                        String resultStatus = payResult.getResultStatus();
                        // 判断resultStatus 为9000则代表支付成功
                        if (TextUtils.equals(resultStatus, "9000")) {
                            // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                            Toast.makeText(AppUtils.getAppContext(), "支付成功", Toast.LENGTH_SHORT).show();
                        } else {
                            // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                            Toast.makeText(AppUtils.getAppContext(), "支付失败", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    }
                    case SDK_AUTH_FLAG: {
                        @SuppressWarnings("unchecked")
                        AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                        String resultStatus = authResult.getResultStatus();

                        // 判断resultStatus 为“9000”且result_code
                        // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                        if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                            // 获取alipay_open_id，调支付时作为参数extern_token 的value
                            // 传入，则支付账户为该授权账户
                            Toast.makeText(AppUtils.getAppContext(),
                                    "授权成功\n" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT)
                                    .show();
                        } else {
                            // 其他状态值则为授权失败
                            Toast.makeText(AppUtils.getAppContext(),
                                    "授权失败" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT).show();

                        }
                        break;
                    }
                    default:
                        break;
                }
                return false;
            }
        }
    );


    public static synchronized Alipay getInstance(){
        if (mInstance == null)
            mInstance = new Alipay();
        return mInstance;
    }


    public void pay(final Activity context, final String orderInfo){
        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(context);
                Map<String, String> result = alipay.payV2(orderInfo, true);
                Log.i("msp", result.toString());

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }
}