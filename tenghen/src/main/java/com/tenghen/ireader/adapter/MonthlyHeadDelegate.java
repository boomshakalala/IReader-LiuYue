package com.tenghen.ireader.adapter;

import android.view.View;

import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.UserInfo;
import com.tenghen.ireader.net.Api;

/**
 * 作者：chengx
 * 日期：2017/3/1
 * 描述：
 */

public class MonthlyHeadDelegate implements ItemViewDelegate<Object> {
    @Override
    public int getItemLayoutId() {
        return R.layout.item_monthly_head;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof UserInfo;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {
        UserInfo userInfo = (UserInfo) o;
        if (userInfo != null) {
            UserInfo.BaseInfo baseInfo = userInfo.getBase_info();
            if (baseInfo != null) {
                holder.setText(R.id.userNameTv,baseInfo.getName());
                holder.setImageUrl(R.id.avatarIv, Api.IMG_HOST+baseInfo.getUser_image());
                holder.setOnclickListener(R.id.openMonthlyBtn, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO: 2018/1/30 跳转开通包月

                    }
                });
            }
        }
    }
}
