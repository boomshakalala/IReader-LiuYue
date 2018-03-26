package com.tenghen.ireader.adapter;

import android.content.Context;

import com.chengx.mvp.adapter.CommonRecyclerAdapter;
import com.chengx.mvp.adapter.MultiItemCommonAdapter;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.module.Recharge;

import java.util.List;
import java.util.Objects;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class RechargeLogAdapter extends MultiItemCommonAdapter<Object> {

    public RechargeLogAdapter(Context context, List<Object> data) {
        super(context, data);
        addItemViewDelegate(new RechargeHeaderDelegate(context));
        addItemViewDelegate(new RechargeLogListDelegate());
    }
}
