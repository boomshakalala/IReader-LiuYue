package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.Msg;
import com.tenghen.ireader.ui.activity.MyMsgActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class MyMsgPresent extends BaseListPresent<MyMsgActivity> {
    @Override
    protected void requestData() {
        List<Msg> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(new Msg());
        }
        getV().refresh(data);
    }
}
