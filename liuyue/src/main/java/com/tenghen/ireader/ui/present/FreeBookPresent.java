package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.adapter.ViewSupportModel;
import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.BookList;
import com.tenghen.ireader.module.FreeBook;
import com.tenghen.ireader.module.Label;
import com.tenghen.ireader.ui.activity.FreeBookActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/3/1
 * 描述：
 */

public class FreeBookPresent extends BaseListPresent<FreeBookActivity> {
    @Override
    protected void requestData() {
        List<Object> data = new ArrayList<>();
        Label label1 = new Label();
        label1.setText("重磅免费！倒计时→");
        label1.setNeedTimmer(true);
        data.add(label1);
        for (int i = 0; i < 3; i++) {
            data.add(new FreeBook());
        }
        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
        Label label2= new Label();
        label2.setText("明日预告！距离免费还有→");
        label2.setNeedTimmer(true);
        data.add(label2);
        for (int i = 0; i < 3; i++) {
            data.add(new FreeBook());
        }
        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
        Label label3 = new Label();
        label3.setText("床上读物23:00-05:00免费读");
        label3.setNeedTimmer(false);
        data.add(label3);
        for (int i = 0; i < 3; i++) {
            data.add(new FreeBook());
        }
        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
        Label label4 = new Label();
        label4.setText("促销神书");
        label4.setNeedTimmer(false);
        data.add(label4);
        for (int i = 0; i < 3; i++) {
            data.add(new FreeBook());
        }
        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
        Label label5 = new Label();
        label5.setText("免费新书！");
        label5.setNeedTimmer(false);
        data.add(label5);
        for (int i = 0; i < 3; i++) {
            data.add(new FreeBook());
        }
        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
        Label label6 = new Label();
        label6.setText("精选书单");
        label6.setNeedTimmer(false);
        data.add(label6);
        for (int i = 0; i < 3; i++) {
            data.add(new BookList());
        }
        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
        getV().refresh(data);
    }

}
