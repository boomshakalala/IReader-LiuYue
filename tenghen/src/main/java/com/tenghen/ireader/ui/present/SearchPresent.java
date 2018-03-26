package com.tenghen.ireader.ui.present;

import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.base.BasePresent;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.ui.fragment.SearchFragment;

import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/2/23
 * 描述：
 */

public class SearchPresent extends BasePresent<SearchFragment> {
    int currentPage = 1;
    public void requestData(){
        Api.getAllViewBooks(new ResponseCallback<List<Book>>() {
            @Override
            public void onSuccess(List<Book> data) {
                if (data != null && data.size()>0) {
                    getV().setBooks(data);
                    getV().scrollToHead();
                }

            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().showTip(info);
            }
        });
    }

    public void requestHotWords() {
        Api.getBookKeywords(currentPage, new ResponseCallback<List<String>>() {
            @Override
            public void onSuccess(List<String> data) {
                if (data != null && data.size()>0) {
                    getV().setHotWords(data);
                    getV().scrollToHead();
                }
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().showTip(info);
            }
        });
        currentPage++;
    }
}
