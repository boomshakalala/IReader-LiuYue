package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.CommonUtils;
import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.adapter.ViewSupportModel;
import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.Banner;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.module.Charts;
import com.tenghen.ireader.module.IndexBanner;
import com.tenghen.ireader.module.Label;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.fragment.FeaturedFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/2/23
 * 描述：
 */

public class FeaturedPresent extends BaseListPresent<FeaturedFragment> {

    @Override
    protected void requestData() {
        log("RequestData");
        final List<Object> data = new ArrayList<>();

        Api.bannerIndexBanner(new ResponseCallback<List<IndexBanner>>() {
            @Override
            public void onSuccess(List<IndexBanner> bannerData) {
                final Banner banner = new Banner();
                banner.setImgDatas(bannerData);
                data.add(banner);
                data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
                Label label1 = new Label();
                label1.setText("主编推荐");
                data.add(label1);
                Api.chartIndexCharts(new ResponseCallback<List<Charts>>() {
                    @Override
                    public void onSuccess(List<Charts> chartses) {
                        for (Charts chartse : chartses) {
                           if(chartse.getName().equals("主编力荐")){
                                List<Book> books = chartse.getBook();
                                for (int i = 0; i < books.size(); i++) {
                                    Book book = books.get(i);
                                    book.isRec = true;
                                    data.add(books.get(i));
                                    if (i!=books.size()-1)
                                        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_LINE));
                                }
                                data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
                                continue;
                            }
                            Label label = new Label();
                            label.setText(chartse.getName());
                            data.add(label);
                            data.addAll(chartse.getBook());
                            data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
                        }

                        getV().refresh(data);

                    }

                    @Override
                    public void onFailure(int errCode, String info) {

                    }
                });
            }

            @Override
            public void onFailure(int errCode, String info) {
                Api.chartIndexCharts(new ResponseCallback<List<Charts>>() {
                    @Override
                    public void onSuccess(List<Charts> chartses) {
                        for (Charts chartse : chartses) {
                            if(chartse.getName().equals("主编力荐")){
                                List<Book> books = chartse.getBook();
                                for (int i = 0; i < books.size(); i++) {
                                    Book book = books.get(i);
                                    book.isRec = true;
                                    data.add(books.get(i));
                                    if (i!=books.size()-1)
                                        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_LINE));
                                }
                                data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
                                continue;
                            }
                            Label label = new Label();
                            label.setText(chartse.getName());
                            data.add(label);
                            data.addAll(chartse.getBook());
                            data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
                        }

                        getV().refresh(data);

                    }

                    @Override
                    public void onFailure(int errCode, String info) {

                    }
                });
                CommonUtils.error(errCode,getV().getActivity());

            }
        });

    }
}
