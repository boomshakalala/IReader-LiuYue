package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.adapter.ViewSupportModel;
import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.ActiveRank;
import com.tenghen.ireader.module.Banner;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.module.Comment;
import com.tenghen.ireader.ui.activity.DynamicActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 时间：${Date}
 * 描述：
 */
public class DynamicPresent extends BaseListPresent<DynamicActivity> {
    @Override
    protected void requestData() {
        List<Object> data = new ArrayList<>();
        data.add(new Banner());
        data.add(new ActiveRank());
        data.add(new Book());
        data.add(new Book());
        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
        for (int i = 0; i < 10; i++) {
            data.add(new Comment());
        }
        getV().refresh(data);
    }
}
