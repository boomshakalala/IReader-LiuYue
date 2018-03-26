package com.tenghen.ireader.aliapi;

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
//    public static final String RSA2_PRIVATE = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDCZheb6LtfqZ8OGI8oUw8TP9TDNmXluVoookShn2scRVosU7CFRvOHybGJQR/3oN25UwvVg5cZF7v77+kND2s4nxakmvTuL6DeFblTqSI1JPlATDjiAN66UBQa0zW6BjjCWGD25qeoC6sE9T9QmKleNnMxYWTBwWFHspI5oX3w+xa7sgKJxwX6g+3v+avoIYcSONhr/xl0uJztvWS5UblkWnkTtQi5HvdTDnaAKuUJJUK5qtiVSNIku488MnHrEVDrrf+gbVfr9XJc4Mru/nxuMtg76OZ1VLI82N69kVx1Iie2op8u9DUeORdpcusUoc7kki7Zit1UVL0h4FBmlIXTAgMBAAECggEAVtoF8kIodLTzuvh9/SYethruk8jZ/aix/zWANDVlRVw2zVcWpnTsmN4j046lGZ1lckcIInyIJU3VTtoA5TTeUo3BMAmLJF9jH9XU1uvZvKSoN3HWeCKrX9InKVTzzAi7kxipOaYTgaC056Iqh3etM8pf7M/2lBoxvDar3dOo0OCUmTCL6NOZH1pYzhXYuzhPufXpuTtHk19djaCaMvwZnxoX0at9AX4mCVTI1vGV2G2JCGPcuFznK3zYWUUd8QsvVH7DShcBHHpgHRirsNXPgIK/y5BO5T9QutrpJk8I1YrPj1Q/pFwxRmnVcmK8qIfieTQ5yXyHZMxwyAJ51jf4AQKBgQD73DkjM6eTVxWOtBJSvH/ePuTXA5skHqYst22K0gcvU3ZDEfDPt+YE/nL6jvTzBEbsCvL96BjRgffBAwTObFusrTGzPwIbKiw/L2/01o7fDSYp7gVSO/1C8GkINHI3fzs9jxPcfWGWOW3bHeFkjYaqqMk4jbAig53ktIBcM541oQKBgQDFmBU5w4WNDUxOpzYv5LKhZDSjRNCBqIv+yX45+h8QH4wowRuqe4d/1aHCn9fTtw9JnvALq9gnu1m8H72F7JV2pHuH5YaO16X6LTlc3fLUTQaF4/2lqWjebDrsoLEO0VvRlcIcAi+rLmtOg5fUNV7AnzBQr4qQjoMtTU+13ybe8wKBgQDRLfvqp7kzX22RIy/gtZxB2ty3U9BjdG0x0HrThFLhVKFxXRIzgxow5aBbR6ZbvB6nZwSgK0eJojdCgB5az5ZoWURhCiDWrPUo2V5T7GunB8W9p2mV/ir/kKq7XMvMGgj6vL2TMDN/0FzUUwHjQMQrM5pENTGnyMa3r864RUrOYQKBgH1waAEsu+rox0mjY4YSFMjaeYQw2oGFg6JzPhwGSpQMwwjYVvzqwQGJmNCacwSn0R+2s8NlC6tlh7kjGUkdAWG5V+bU8pBaHLdu4FyxVkgqwfpb25nAq5+Qa/Puq5ixli2+eeUYCjUNGfhVGB0S6J02MhD27+uHXYVz8CeQi/e7AoGBAPBsndlxxbslFBDE/snzU8Opp+FR2HXDM3wWHBAA19NK8slGjDGcgoXV8FPeQGuzyM02Tan40FayULQTyezo0gguH7UZQ6RLNfNT20PdhG4kFo+j1LowNbP4XDVwLGrCQgx0g0/5M2yiXgH4TcpbaTZuupP8Fb151UPE+zoVqxXy";
    public static final String RSA2_PRIVATE = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAugHLG98l9zxRj9blcWzJ" +
            "xGZ7sbE8BCbOStRnxkkU6CJ6W12BG8zi205DkiklAXr22bJ+ragVzjbFoFmQIo3s" +
            "kbytxhnup+2ZEKcynlwA+e/DJcJbKYAVHmTmDW8LaAmrTRMd+MiE3JIborRSnriq" +
            "bHWoG6gxQrDeikfvPdzC7+0cad4/NrocJgxDB9YOx0RzOjNz0DZSA3cRwEe1X8LD" +
            "CbX8Ssc2NfKFq+uTJPDuXYplf+j3xCXZGIPwO8JsnCYXqL106CH1/wr2J+Kp07Nw" +
            "PSnCUZczDQHzVklDB6sVswKXp03dP0kJUcHH+qaxIlV0STZgE/bq1JK67GpZjsgZ" +
            "0QIDAQAB";

    private static Alipay mInstance;

    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
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
        };
    };


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