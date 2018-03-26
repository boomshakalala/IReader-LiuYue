package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.adapter.ViewSupportModel;
import com.tenghen.ireader.base.BaseListPresent;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.module.Charts;
import com.tenghen.ireader.module.Label;
import com.tenghen.ireader.module.UserInfo;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.activity.MonthlyActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/3/1
 * 描述：
 */

public class MonthlyPresent extends BaseListPresent<MonthlyActivity> {
    @Override
    protected void requestData() {
        final List<Object> data = new ArrayList<>();
        Api.userUserInfo(new ResponseCallback<UserInfo>() {
            @Override
            public void onSuccess(UserInfo userInfo) {
                data.add(userInfo);
                data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
                Api.chartMonthlyCharts(new ResponseCallback<List<Charts>>() {
                    @Override
                    public void onSuccess(List<Charts> chartses) {
                        for (Charts charts : chartses) {
                            Label label = new Label();
                            label.setText(charts.getName());
                            data.add(label);
                            if (charts.getPosition().equals("byxs")){
                                List<Book> books = charts.getBook();
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
                            data.addAll(charts.getBook());
                            data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
                            Api.userMonthlyRank(new ResponseCallback<List<Book>>() {
                                @Override
                                public void onSuccess(List<Book> books) {
                                    if (books == null||books.size()==0)
                                        return;
                                    Label label = new Label();
                                    label.setText("人气排行");
                                    data.add(label);
                                    for (int i = 0; i < books.size(); i++) {
                                        Book book = books.get(i);
                                        if (i==0){
                                            book.isRec = true;
                                            book.shouRank = true;
                                            data.add(book);
                                            data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_LINE));
                                            continue;
                                        }
                                        book.isRank = true;
                                        data.add(book);
                                        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_LINE));
                                    }
                                    getV().refresh(data);

                                }

                                @Override
                                public void onFailure(int errCode, String info) {
                                    getV().refresh(data);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFailure(int errCode, String info) {
                        Api.userMonthlyRank(new ResponseCallback<List<Book>>() {
                            @Override
                            public void onSuccess(List<Book> books) {
                                for (int i = 0; i < books.size(); i++) {
                                    Book book = books.get(i);
                                    if (i==0){
                                        book.isRec = true;
                                        book.shouRank = true;
                                        data.add(book);
                                        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_LINE));
                                        continue;
                                    }
                                    book.isRank = true;
                                    data.add(book);
                                    data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_LINE));
                                }
                                getV().refresh(data);
                            }

                            @Override
                            public void onFailure(int errCode, String info) {
                                getV().refresh(data);
                            }
                        });
                    }
                });
            }

            @Override
            public void onFailure(int errCode, String info) {
                data.add(new UserInfo());
                data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
                Api.chartMonthlyCharts(new ResponseCallback<List<Charts>>() {
                    @Override
                    public void onSuccess(List<Charts> chartses) {
                        for (Charts charts : chartses) {
                            Label label = new Label();
                            label.setText(charts.getName());
                            data.add(label);
                            if (charts.getPosition().equals("byxs")){
                                List<Book> books = charts.getBook();
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
                            data.addAll(charts.getBook());
                            data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_SPACE));
                            Api.userMonthlyRank(new ResponseCallback<List<Book>>() {
                                @Override
                                public void onSuccess(List<Book> books) {
                                    if (books == null||books.size()==0)
                                    return;
                                    Label label = new Label();
                                    label.setText("人气排行");
                                    data.add(label);
                                    for (int i = 0; i < books.size(); i++) {
                                        Book book = books.get(i);
                                        if (i==0){
                                            book.isRec = true;
                                            book.shouRank = true;
                                            data.add(book);
                                            data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_LINE));
                                            continue;
                                        }
                                        book.isRank = true;
                                        data.add(book);
                                        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_LINE));
                                    }
                                    getV().refresh(data);

                                }

                                @Override
                                public void onFailure(int errCode, String info) {
                                    getV().refresh(data);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFailure(int errCode, String info) {
                        Api.userMonthlyRank(new ResponseCallback<List<Book>>() {
                            @Override
                            public void onSuccess(List<Book> books) {
                                for (int i = 0; i < books.size(); i++) {
                                    Book book = books.get(i);
                                    if (i==0){
                                        book.isRec = true;
                                        book.shouRank = true;
                                        data.add(book);
                                        data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_LINE));
                                        continue;
                                    }
                                    book.isRank = true;
                                    data.add(book);
                                    data.add(new ViewSupportModel(ViewSupportModel.VIEW_TYPE_SPLIT_LINE));
                                }
                                getV().refresh(data);
                            }

                            @Override
                            public void onFailure(int errCode, String info) {
                                getV().refresh(data);
                            }
                        });
                    }
                });
            }
        });



    }


}
