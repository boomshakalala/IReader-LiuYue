package com.tenghen.ireader.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.ui.activity.RechargeActivity;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class RechargeHeaderDelegate implements ItemViewDelegate<Object> {
    Context context;

    public RechargeHeaderDelegate(Context context) {
        this.context = context;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.layout_recharge_log_header;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof String;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {
        String money = (String) o;
        holder.setText(R.id.moneyTv,"您的余额"+money+"腾币");
        holder.setOnclickListener(R.id.rechargeBtn, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RechargeActivity.launch(context);
            }
        });

    }
}
