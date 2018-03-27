package com.tenghen.ireader.adapter;

import android.content.Context;
import android.view.View;

import com.chengx.mvp.adapter.CommonAdapter;
import com.chengx.mvp.adapter.ViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.RechareMoney;

import java.util.List;

public class RechargeMoneyAdapter extends CommonAdapter<RechareMoney> {
    public RechargeMoneyAdapter(Context context, List<RechareMoney> data, int itemLayoutId) {
        super(context, data, itemLayoutId);
    }

    @Override
    public void convert(ViewHolder holder, RechareMoney rechareMoney) {
        holder.setText(R.id.moneyTv,rechareMoney.tengbi + "腾币");
        if (rechareMoney.zTengbi == 0)
            holder.getView(R.id.zMoneyLayout).setVisibility(View.GONE);
        else{
            holder.getView(R.id.zMoneyLayout).setVisibility(View.VISIBLE);
            holder.setText(R.id.moneyTv,rechareMoney.tengbi + "腾币");
        }
        holder.setText(R.id.zMoneyTv,rechareMoney.zTengbi + "腾币");
        holder.setText(R.id.costTv,rechareMoney.money + "元");
    }
}