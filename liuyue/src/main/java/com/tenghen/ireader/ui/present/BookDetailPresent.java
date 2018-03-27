package com.tenghen.ireader.ui.present;

import com.google.android.gms.common.AccountPicker;
import com.tenghen.ireader.CommonUtils;
import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.R;
import com.tenghen.ireader.adapter.ViewSupportModel;
import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.BookDetail;
import com.tenghen.ireader.module.Comment;
import com.tenghen.ireader.module.Gift;
import com.tenghen.ireader.module.GiftLog;
import com.tenghen.ireader.module.Label;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.activity.BookDetailActivity;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * 作者：chengx
 * 日期：2017/3/7
 * 描述：
 */

public class BookDetailPresent extends BaseListPresent<BookDetailActivity> {
    String bookId;
    int[] giftImages = {R.drawable.ic_gift_coin,R.drawable.ic_gift_flower,R.drawable.ic_gift_beer,R.drawable.ic_gift_mac,
            R.drawable.ic_gift_car,R.drawable.ic_gif_house};

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override
    protected void requestData() {
        getV().showProgress();
        Api.getBookInfo(bookId, new ResponseCallback<BookDetail>() {
            @Override
            public void onSuccess(BookDetail data) {
                List<Object> dataList = new ArrayList<>();
                dataList.add(data.getBook());
                dataList.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
                Label giftLabel = new Label();
                giftLabel.setCategory(Label.BOOK_DETAIL_GIFT);
                giftLabel.setText("捧场总数:" + data.getRewards().getAmount());
                dataList.add(giftLabel);
                for (int i = 0; i < 6; i++) {
                    dataList.add(new Gift(i+3+"",giftImages[i]));
                }

                Label giftLogLabel = new Label();
                giftLogLabel.setCategory(Label.BOOK_DETAIL_GIFT_LOG);
                dataList.add(giftLogLabel);
                if (data.getRewards().getList().isEmpty()){
                    dataList.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_EMPTY));
                }else {
                    for (GiftLog giftLog : data.getRewards().getList()) {
                        dataList.add(giftLog);
                    }
                    Label giftMoreLabel = new Label();
                    giftMoreLabel.setTag(1);
                    giftMoreLabel.setId(bookId);
                    giftMoreLabel.setCategory(Label.BOOK_DETAIL_MORE);
                    dataList.add(giftMoreLabel);
                }

                dataList.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
                Label commentLabel = new Label();
                commentLabel.setId(bookId);
                commentLabel.setCategory(Label.BOOK_DETAIL_COMMENT);
                dataList.add(commentLabel);

                if (data.getComments().isEmpty()){
                    dataList.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_EMPTY));
                }else {
                    for (Comment comment : data.getComments()) {
                        dataList.add(comment);
                    }
                    Label commentMoreLabel = new Label();
                    commentMoreLabel.setCategory(Label.BOOK_DETAIL_MORE);
                    commentMoreLabel.setTag(2);
                    commentMoreLabel.setId(bookId);
                    dataList.add(commentMoreLabel);
                }
                getV().refresh(dataList);
            }

            @Override
            public void onFailure(int errCode, String info) {
                CommonUtils.error(errCode,getV());
                getV().showTip(info);
                getV().showError();
            }

        });


    }

    public void sendGift(String giftType){
        Api.userRewardBook(bookId, giftType, "1", new ResponseCallback<Void>() {
            @Override
            public void onSuccess(Void data) {
                getV().showTip("感谢捧场");
                EventBus.getDefault().post("refresh");
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().showTip(info);
            }
        });
    }
}
