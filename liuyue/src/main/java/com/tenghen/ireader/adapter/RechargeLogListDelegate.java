package com.tenghen.ireader.adapter;

import android.text.Html;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Recharge;

import java.util.Objects;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class RechargeLogListDelegate implements ItemViewDelegate<Object> {
    @Override
    public int getItemLayoutId() {
        return R.layout.item_recharge_log;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof Recharge;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {
        Recharge recharge = (Recharge) o;
        String status = "";
        String type = "";
        switch (recharge.getType()){
            case "1":
                type = "支付宝";
                break;
            case "2":
                type = "微信";
                break;
            case "3":
                type = "银联";
                break;
            case "5":
                type = "wap支付宝";
                break;
            case "8":
                type = "wap银联";
                break;
            case "9":
                type = "wap微信";
                break;

        }
        status = recharge.getResult().equals("Y")?"成功":"失败";
        holder.setText(R.id.logTv, Html.fromHtml("充值"+recharge.getNumber()+"元"+"["+"<font color=\"#ff0000\">"+status+"</font>"+"]"));
        holder.setText(R.id.rechargeTimeTv,recharge.getResult_date());
        holder.setText(R.id.rechargeTypeTv,type+"充值");
    }
}
