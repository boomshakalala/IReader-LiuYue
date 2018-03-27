package com.tenghen.ireader.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.chengx.mvp.utils.ToastUtils;
import com.tenghen.ireader.CommonUtils;
import com.tenghen.ireader.R;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.ui.activity.LoginActivity;
import com.tenghen.ireader.ui.activity.RechargeActivity;

import de.greenrobot.event.EventBus;

/**
 * Created by Administrator on 2018/2/4/004.
 */

public class GifDialog extends Dialog implements View.OnClickListener {
    String bookId;


    FrameLayout coinBtn;
    FrameLayout flowerBtn;
    FrameLayout beerBtn;
    FrameLayout macBtn;
    FrameLayout carBtn;
    FrameLayout houseBtn;

    TextView rechargeBtn;
    TextView sendBtn;

    String type = "";


    public GifDialog(@NonNull Context context,String bookId) {
        super(context, R.style.ActionSheetDialogStyle);
        this.bookId = bookId;
    }

    public GifDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(true);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_gift, null);
        coinBtn = (FrameLayout) inflate.findViewById(R.id.coinBtn);
        flowerBtn = (FrameLayout) inflate.findViewById(R.id.flowerBtn);
        beerBtn = (FrameLayout) inflate.findViewById(R.id.beerBtn);
        macBtn = (FrameLayout) inflate.findViewById(R.id.macBtn);
        carBtn = (FrameLayout) inflate.findViewById(R.id.carBtn);
        houseBtn = (FrameLayout) inflate.findViewById(R.id.houseBtn);
        rechargeBtn = (TextView) inflate.findViewById(R.id.rechargeBtn);
        sendBtn = (TextView) inflate.findViewById(R.id.sendBtn);
        coinBtn.setOnClickListener(this);
        flowerBtn.setOnClickListener(this);
        beerBtn.setOnClickListener(this);
        macBtn.setOnClickListener(this);
        carBtn.setOnClickListener(this);
        houseBtn.setOnClickListener(this);
        rechargeBtn.setOnClickListener(this);
        sendBtn.setOnClickListener(this);
        setContentView(inflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = getWindow();
        //设置Dialog从窗体底部弹出
        WindowManager m = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.height = WindowManager.LayoutParams.WRAP_CONTENT; // 高度设置为屏幕的0.6
        p.width = (int) (d.getWidth() * 0.8f); // 宽度设置为屏幕的0.65
        dialogWindow.setAttributes(p);
        dialogWindow.setGravity( Gravity.CENTER);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.coinBtn:
                resetCheck();
                coinBtn.getChildAt(1).setVisibility(View.VISIBLE);
                type = "3";
                break;
            case R.id.flowerBtn:
                resetCheck();
                flowerBtn.getChildAt(1).setVisibility(View.VISIBLE);
                type = "4";
                break;
            case R.id.beerBtn:
                resetCheck();
                beerBtn.getChildAt(1).setVisibility(View.VISIBLE);
                type = "5";
                break;
            case R.id.macBtn:
                resetCheck();
                macBtn.getChildAt(1).setVisibility(View.VISIBLE);
                type = "6";
                break;
            case R.id.carBtn:
                resetCheck();
                carBtn.getChildAt(1).setVisibility(View.VISIBLE);
                type = "7";
                break;
            case R.id.houseBtn:
                resetCheck();
                houseBtn.getChildAt(1).setVisibility(View.VISIBLE);
                type = "8";
                break;
            case R.id.rechargeBtn:
                if (CommonUtils.isLogin()){
                    RechargeActivity.launch(getContext());
                }else {
                    LoginActivity.launch((Activity) getContext(),0);
                }
                break;
            case R.id.sendBtn:
                Api.userRewardBook(bookId, type, "1", new ResponseCallback<Void>() {
                    @Override
                    public void onSuccess(Void data) {
                        ToastUtils.showToast(getContext(),"感谢捧场");
                        EventBus.getDefault().post("refresh");
                        dismiss();
                    }

                    @Override
                    public void onFailure(int errCode, String info) {
                        ToastUtils.showToast(getContext(),info);
                        dismiss();
                    }
                });
                break;
        }
    }

    public void resetCheck(){
        coinBtn.getChildAt(1).setVisibility(View.GONE);
        flowerBtn.getChildAt(1).setVisibility(View.GONE);
        beerBtn.getChildAt(1).setVisibility(View.GONE);
        macBtn.getChildAt(1).setVisibility(View.GONE);
        carBtn.getChildAt(1).setVisibility(View.GONE);
        houseBtn.getChildAt(1).setVisibility(View.GONE);
    }
}
