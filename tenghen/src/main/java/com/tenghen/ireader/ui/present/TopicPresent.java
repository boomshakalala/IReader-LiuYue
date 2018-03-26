package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.Cost;
import com.tenghen.ireader.module.Topic;
import com.tenghen.ireader.ui.activity.CostLogActivity;
import com.tenghen.ireader.ui.activity.TopicActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class TopicPresent extends BaseListPresent<TopicActivity> {
    @Override
    protected void requestData() {
        List<Topic> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(new Topic());
        }
        getV().refresh(data);
    }
}
