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
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.tenghen.ireader.CommonUtils;
import com.tenghen.ireader.R;
import com.tenghen.ireader.ui.activity.SettingActivity;

/**
 * Created by chengx on 18-2-8.
 */

public class LogoutDialog extends Dialog implements View.OnClickListener {

    Context context;

    public LogoutDialog(@NonNull Context context) {
        super(context, R.style.ActionSheetDialogStyle);
        this.context = context;
    }

    public LogoutDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(true);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_logout, null);
        TextView logoutBtn = (TextView) inflate.findViewById(R.id.logoutBtn);
        TextView cancelBtn = (TextView) inflate.findViewById(R.id.cancelBtn);
        logoutBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
        setContentView(inflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = getWindow();
        //设置Dialog从窗体底部弹出
        WindowManager m = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.height = (int) (d.getHeight()*0.4); // 高度设置为屏幕的0.6
        p.width = (int) (d.getWidth() * 1f); // 宽度设置为屏幕的0.65
        dialogWindow.setAttributes(p);
        dialogWindow.setGravity( Gravity.BOTTOM);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.logoutBtn:
                CommonUtils.clearUserInfo();
                if (context instanceof Activity){
                    ((Activity) context).finish();
                }
                break;
        }
        dismiss();
    }
}
