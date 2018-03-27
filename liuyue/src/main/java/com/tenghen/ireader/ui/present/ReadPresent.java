package com.tenghen.ireader.ui.present;

import android.app.AlertDialog;
import android.content.DialogInterface;

import com.tenghen.ireader.base.BasePresent;
import com.tenghen.ireader.module.ChapterContent;
import com.tenghen.ireader.net.Api;
import com.tenghen.ireader.net.ResponseCallback;
import com.tenghen.ireader.ui.activity.LoginActivity;
import com.tenghen.ireader.ui.activity.ReadActivity;

public class ReadPresent extends BasePresent<ReadActivity> {

    public void getChapterContent(String bookId,String chapterId){
        getV().showProgress();
        Api.chapterChapterContent(bookId, chapterId, new ResponseCallback<ChapterContent>() {
            @Override
            public void onSuccess(ChapterContent data) {
                getV().dismissDialog();
                ChapterContent.User_status user_status = data.getUser_status();
                if (user_status != null) {
                    getV().showUserState(user_status);
                }

                ChapterContent.Msg msg = data.getMsg();
                if (msg != null) {
                    getV().showMsg(msg);
                }
                ChapterContent.Text text = data.getText();
                if (text != null) {
                    getV().showTextData(text);
                }
                ChapterContent.BookInfo bookInfo = data.getBook_info();
                if (bookInfo != null) {
                    getV().showBookInfo(bookInfo);
                }
                ChapterContent.ChapterInfo chapterInfo = data.getChapter_info();
                if (chapterInfo != null) {
                    getV().showChapterInfo(chapterInfo);
                }

                ChapterContent.LastAndNext context = data.getContext();
                getV().setContextInfo(context);
                getV().scrollToHead();
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().dismissDialog();
                getV().showTip(info);

                if (errCode == 9){
                    final AlertDialog dialog = new AlertDialog.Builder(getV()).create();
                    dialog.setTitle("提示");
                    dialog.setMessage("该章节为收费章节，请先登录");
                    dialog.setButton("去登陆", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialog.dismiss();
                            LoginActivity.launch(getV(),0);
                            getV().finish();
                        }
                    });
                    dialog.setCancelable(false);
                    dialog.show();
                }else {
                    getV().finish();
                }

            }
        });
    }

    public void addBookCase(String bookId){
        Api.userAddBookCase(bookId, new ResponseCallback<Void>() {
            @Override
            public void onSuccess(Void data) {
                getV().showCollected();
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().showTip(info);
            }
        });
    }

    public void addSub(String bookId,String chapterId){
        Api.userAddSubscribe(bookId,chapterId, new ResponseCallback<Void>() {
            @Override
            public void onSuccess(Void data) {
                getV().showAddSub();
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().showTip(info);
            }
        });
    }

    public void delSub(String bookId){
        Api.userDelSubscribe(bookId, new ResponseCallback<Void>() {
            @Override
            public void onSuccess(Void data) {
                getV().showDelSub();
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().showTip(info);
            }
        });
    }

    public void buyChapter(final String bookId, final String chapterId){
        Api.userBuyChapter(bookId, chapterId, new ResponseCallback<Void>() {
            @Override
            public void onSuccess(Void data) {
                getChapterContent(bookId,chapterId);
            }

            @Override
            public void onFailure(int errCode, String info) {
                getV().showTip(info);
            }
        });
    }
}