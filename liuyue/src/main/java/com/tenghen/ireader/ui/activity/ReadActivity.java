package com.tenghen.ireader.ui.activity;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.chengx.mvp.utils.AppUtils;
import com.chengx.mvp.utils.SizeUtils;
import com.chengx.mvp.widget.auto.AutoScrollView;
import com.google.android.gms.auth.firstparty.shared.FACLConfig;
import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseActivity;
import com.tenghen.ireader.module.ChapterContent;
import com.tenghen.ireader.ui.present.ReadPresent;
import com.tenghen.ireader.widget.CommentDialog;
import com.tenghen.ireader.widget.GifDialog;
import com.tenghen.ireader.widget.SettingDialog;

import java.util.TimerTask;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

/**
 * 作者：chengx
 * 日期：2017/3/8
 * 描述：
 */

public class ReadActivity extends BaseActivity<ReadPresent>{

    public  static float LargeTextSize = SizeUtils.sp2px(AppUtils.getAppContext(),12);
    public  static float MidTextSize = SizeUtils.sp2px(AppUtils.getAppContext(),9);
    public  static float SmallTextSize = SizeUtils.sp2px(AppUtils.getAppContext(),6);

    @BindView(R.id.bookContentTv)
    public TextView bookContentTv;
    @BindView(R.id.readRootView)
    public LinearLayout readRootView;
    @BindView(R.id.readPopView)
    public FrameLayout readPopView;
    @BindView(R.id.chapterNameTv)
    public TextView chapterNameTv;
    @BindView(R.id.bookNameTv)
    public TextView bookNameTv;
    @BindView(R.id.collectBtn)
    ImageView collectBtn;
    @BindView(R.id.zddyBtn)
    TextView zddyBtn;
    @BindView(R.id.scrollView)
    ScrollView scrollView;

    String bookId = "";
    String chapterId = "";

    String lastId;
    String nextId;

    boolean zddy;



    private int mode = 1;

    public static void launch(Context context,String bookId,String chapterId){
        Intent intent = new Intent(context,ReadActivity.class);
        intent.putExtra("bookId",bookId);
        intent.putExtra("chapterId",chapterId);
        context.startActivity(intent);
    }

    public void showUserState(ChapterContent.User_status userStatus){
        if (userStatus.getIs_collect() == 1){
            collectBtn.setClickable(false);
            collectBtn.setImageResource(R.drawable.btn_read_collect_p);
        }else {
            collectBtn.setClickable(true);
            collectBtn.setImageResource(R.drawable.btn_read_collect);
        }
        if (userStatus.getIs_auto_subscribe() == 1){
            zddy  = true;
            zddyBtn.setSelected(true);
        }else {
            zddyBtn.setSelected(false);
            zddy  = false;
        }
    }

    public void showMsg(ChapterContent.Msg msg){
        if (msg.getCostCode() == 8 || msg.getCostCode() == 9){
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle("提示")
                    .setMessage(msg.getWarning())
                    .create();
            dialog.setButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    getPresent().buyChapter(bookId,chapterId);
                    dialog.dismiss();
                }
            });
            dialog.setButton2("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finish();
                }
            });

            dialog.show();

        }else if (msg.getCostCode() == 1 || msg.getCostCode() == 3 || msg.getCostCode() == 4){
            showTip(msg.getWarning());
        }else {
            showTip(msg.getWarning());
        }


    }

    public void showTextData(ChapterContent.Text text){
        bookContentTv.setText(text.getContent());
    }

    public void showBookInfo(ChapterContent.BookInfo bookInfo){
        bookNameTv.setText(bookInfo.getName());
    }

    public void showChapterInfo(ChapterContent.ChapterInfo chapterInfo){
        chapterNameTv.setText(chapterInfo.getName());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        initData();
        initViews();
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public int getLayoutId() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_read;
    }

    @Override
    public void initData() {
        bookId = getIntent().getStringExtra("bookId");
        chapterId = getIntent().getStringExtra("chapterId");
        mode = sp.getInt("mode",1);
        setMode(mode);
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    public void setMode(int mode){
        String bgColor = "#ffffff";
        switch (mode){
            case 1:
                bgColor = sp.getString("dayColor","#ffffff");
                chapterNameTv.setTextColor(Color.parseColor("#77d1da"));
                bookNameTv.setTextColor(Color.parseColor("#77d1da"));
                bookContentTv.setTextColor(getResources().getColor(R.color.black));
                break;
            case 2:
                bgColor = sp.getString("nightColor","#ffffff");
                bookContentTv.setTextColor(Color.parseColor("#636363"));
                chapterNameTv.setTextColor(Color.parseColor("#636363"));
                bookNameTv.setTextColor(Color.parseColor("#636363"));
                break;
        }
        float textSize = sp.getFloat("textSize",MidTextSize);
        readRootView.setBackgroundColor(Color.parseColor(bgColor));
        bookContentTv.setTextSize(textSize);
    }

    @Override
    public void initViews() {
        getPresent().getChapterContent(bookId,chapterId);
    }

    @Override
    public void setListener() {

    }

    @Override
    public ReadPresent newPresent() {
        return new ReadPresent();
    }

    public void showCollected() {
        collectBtn.setClickable(false);
        collectBtn.setImageResource(R.drawable.btn_read_collect_p);
    }

    public void showAddSub() {
        zddyBtn.setSelected(true);
        zddy = true;
    }

    public void showDelSub() {
        zddyBtn.setSelected(false);
        zddy = false;
    }

    public void setContextInfo(ChapterContent.LastAndNext context) {
            lastId = context.getPre_chapter_id();
            nextId = context.getNext_chapter_id();
    }

    class AutoScrollTask extends TimerTask {
        public void run(){
            Message msg=new Message();
            msg.what=1;
            handler.sendMessage(msg);
        }
    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            if(msg.what==1){
                //如果没有到底端，Y偏移量增加10
                if(scrollView.getScrollY()<bookContentTv.getMeasuredHeight()-10){
                    scrollView.scrollBy(0, 10);
                }
                else {
                    //直接到底端
                    scrollView.scrollTo(0, bookContentTv.getMeasuredHeight());
                }
            }
            super.handleMessage(msg);
        }
    };

    @OnClick({R.id.giftBtn,
            R.id.commentBtn,R.id.settingBtn,R.id.lastChapterBtn,R.id.nextChapterBtn,R.id.btn_back,R.id.homeBtn,
            R.id.collectBtn,R.id.readRootView,R.id.readPopView,R.id.zddyBtn,
            R.id.last,R.id.next,R.id.chapterList,R.id.scrollView,R.id.bookContentTv})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.giftBtn:
                new GifDialog(this,bookId).show();
                break;
            case R.id.commentBtn:
                new CommentDialog(this,bookId,"").show();
                break;
            case R.id.settingBtn:
                new SettingDialog(this).show();
                break;
            case R.id.collectBtn:
                getPresent().addBookCase(bookId);
                break;
            case R.id.homeBtn:
                MainActivity.launch(this);
                break;
            case R.id.zddyBtn:
                if (zddy)
                getPresent().delSub(bookId);
                else
                getPresent().addSub(bookId,chapterId);
                break;
            case R.id.lastChapterBtn:
                if (Long.valueOf(lastId)==-1){
                    showTip("没有上一章了");
                    return;
                }else {
                    chapterId = lastId;
                    getPresent().getChapterContent(bookId,lastId);
                }
                break;
            case R.id.nextChapterBtn:
                if (Long.valueOf(nextId)==-1){
                    showTip("没有下一章了");
                    return;
                }else {
                    chapterId = nextId;
                    getPresent().getChapterContent(bookId,nextId);
                }
                break;
            case R.id.last:
                if (Long.valueOf(lastId)==-1){
                    showTip("没有上一章了");
                    return;
                }else {
                    chapterId = lastId;
                    getPresent().getChapterContent(bookId,lastId);
                }
                break;
            case R.id.next:
                if (Long.valueOf(nextId)==-1){
                    showTip("没有下一章了");
                    return;
                }else {
                    chapterId = nextId;
                    getPresent().getChapterContent(bookId,nextId);
                }
                break;

            case R.id.chapterList:
                ChapterListActivity.launch(this,bookId);
                break;

            case R.id.btn_back:
                finish();
                break;
            case R.id.readRootView:
                readPopView.setVisibility(View.VISIBLE);
                break;
            case R.id.readPopView:
                readPopView.setVisibility(View.GONE);
                break;
            case R.id.bookContentTv:
                readPopView.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void onEventMainThread(Integer mode){
        setMode(mode);
    }


    public void scrollToHead(){
        scrollView.scrollTo(0,0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
