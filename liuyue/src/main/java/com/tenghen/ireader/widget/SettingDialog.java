package com.tenghen.ireader.widget;

import android.app.Dialog;
import android.app.ExpandableListActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.chengx.mvp.base.AppConfig;
import com.chengx.mvp.utils.SPUtils;
import com.tenghen.ireader.R;
import com.tenghen.ireader.ui.activity.ReadActivity;

import de.greenrobot.event.EventBus;

/**
 * Created by chengx on 18-2-7.
 */

public class SettingDialog extends Dialog implements View.OnClickListener {


    TextView addTextSizeBtn;
    TextView scalTextSizeBtn;
    TextView bg01;
    TextView bg02;
    TextView bg03;
    TextView bg04;
    TextView bg05;
    ImageView dayBtn;
    ImageView nightBtn;
    ImageView scrollBtn;

    boolean isAutoScroll = false;



    public SettingDialog(@NonNull Context context) {
        super(context, R.style.ActionSheetDialogStyle);
    }

    public SettingDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(true);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_setting, null);
        addTextSizeBtn = (TextView) inflate.findViewById(R.id.addTextSizeBtn);
        scalTextSizeBtn = (TextView) inflate.findViewById(R.id.scalTextSizeBtn);
        bg01 = (TextView) inflate.findViewById(R.id.bg01);
        bg02 = (TextView) inflate.findViewById(R.id.bg02);
        bg03 = (TextView) inflate.findViewById(R.id.bg03);
        bg04 = (TextView) inflate.findViewById(R.id.bg04);
        bg05 = (TextView) inflate.findViewById(R.id.bg05);

        dayBtn = (ImageView) inflate.findViewById(R.id.dayBtn);
        nightBtn = (ImageView) inflate.findViewById(R.id.nightBtn);
        scrollBtn = (ImageView) inflate.findViewById(R.id.autoScrollBtn);

        addTextSizeBtn.setOnClickListener(this);
        scalTextSizeBtn.setOnClickListener(this);
        bg01.setOnClickListener(this);
        bg02.setOnClickListener(this);
        bg03.setOnClickListener(this);
        bg04.setOnClickListener(this);
        bg05.setOnClickListener(this);
        dayBtn.setOnClickListener(this);
        nightBtn.setOnClickListener(this);
        scrollBtn.setOnClickListener(this);

        int mode = new SPUtils(getContext(),AppConfig.SP_NAME).getInt("mode",1);
        setMode(mode);

        setContentView(inflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = getWindow();
        //设置Dialog从窗体底部弹出
        WindowManager m = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.height = WindowManager.LayoutParams.WRAP_CONTENT; // 高度设置为屏幕的0.6
        p.width = (int) (d.getWidth() * 1f); // 宽度设置为屏幕的0.65
        dialogWindow.setAttributes(p);
        dialogWindow.setGravity( Gravity.BOTTOM);
    }

    @Override
    public void onClick(View v) {
        SPUtils sp = new SPUtils(getContext(), AppConfig.SP_NAME);
        int mode = sp.getInt("mode",1);

        switch (v.getId()){
            case R.id.addTextSizeBtn:
                float currentTextSize = sp.getFloat("textSize",ReadActivity.MidTextSize);
                if (currentTextSize == ReadActivity.MidTextSize)
                    sp.putFloat("textSize",ReadActivity.LargeTextSize);
                else if (currentTextSize == ReadActivity.SmallTextSize)
                    sp.putFloat("textSize",ReadActivity.MidTextSize);
                break;
            case R.id.scalTextSizeBtn:
                float currentTextSize1 = sp.getFloat("textSize",ReadActivity.MidTextSize);
                if (currentTextSize1 == ReadActivity.MidTextSize)
                    sp.putFloat("textSize",ReadActivity.SmallTextSize);
                else if (currentTextSize1 == ReadActivity.LargeTextSize)
                    sp.putFloat("textSize",ReadActivity.MidTextSize);
                break;
            case R.id.dayBtn:
                sp.putInt("mode",1);
                setMode(1);
                break;
            case R.id.nightBtn:
                sp.putInt("mode",2);
                setMode(2);
                break;
            case R.id.autoScrollBtn:
                break;
            case R.id.bg01:
                if (mode == 1)
                    sp.putString("dayColor","#dcdcdc");
                else
                    sp.putString("nightColor","#727272");
                break;
            case R.id.bg02:
                if (mode == 1)
                    sp.putString("dayColor","#fee8ea");
                else
                    sp.putString("nightColor","#634848");
                break;
            case R.id.bg03:
                if (mode == 1)
                    sp.putString("dayColor","#aab5a7");
                else
                    sp.putString("nightColor","#364832");
                break;
            case R.id.bg04:
                if (mode == 1)
                    sp.putString("dayColor","#acbeca");
                else
                    sp.putString("nightColor","#3d5265");
                break;
            case R.id.bg05:
                if (mode == 1)
                    sp.putString("dayColor","#cdc7b1");
                else
                    sp.putString("nightColor","#64563c");
                break;
        }
        mode = sp.getInt("mode",1);
        setMode(mode);
        EventBus.getDefault().post(mode);

    }

    private void setMode(int mode){
        switch (mode){
            case 1:
                addTextSizeBtn.setTextColor(Color.parseColor("#fb9394"));
                dayBtn.setImageResource(R.drawable.day);
                nightBtn.setImageResource(R.drawable.night);
                bg01.setBackgroundColor(Color.parseColor("#dcdcdc"));
                bg02.setBackgroundColor(Color.parseColor("#fee8ea"));
                bg03.setBackgroundColor(Color.parseColor("#aab5a7"));
                bg04.setBackgroundColor(Color.parseColor("#acbeca"));
                bg05.setBackgroundColor(Color.parseColor("#cdc7b1"));
                break;
            case 2:
                addTextSizeBtn.setTextColor(Color.parseColor("#671010"));
                dayBtn.setImageResource(R.drawable.night_day);
                nightBtn.setImageResource(R.drawable.night_night);
                bg01.setBackgroundColor(Color.parseColor("#727272"));
                bg02.setBackgroundColor(Color.parseColor("#634848"));
                bg03.setBackgroundColor(Color.parseColor("#364832"));
                bg04.setBackgroundColor(Color.parseColor("#3d5265"));
                bg05.setBackgroundColor(Color.parseColor("#64563c"));
                break;
        }
    }
}
