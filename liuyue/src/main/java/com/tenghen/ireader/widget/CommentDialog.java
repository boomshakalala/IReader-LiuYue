package com.tenghen.ireader.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.text.TextUtils;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.tenghen.ireader.net.ResponseCallback;
import com.chengx.mvp.utils.ToastUtils;
import com.tenghen.ireader.R;
import com.tenghen.ireader.net.Api;

import de.greenrobot.event.EventBus;

/**
 * Created by Administrator on 2018/2/4/004.
 */

public class CommentDialog extends Dialog implements View.OnClickListener {
    String bookId;
    String replyId;
    EditText contentEt;
    public CommentDialog(@NonNull Context context,String bookId,String replyId) {
        super(context, R.style.ActionSheetDialogStyle);
        this.bookId = bookId;
        this.replyId = replyId;
    }

    public CommentDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(true);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_comment, null);
        contentEt = (EditText) inflate.findViewById(R.id.commentEt);
        Button sendBtn = (Button) inflate.findViewById(R.id.sendBtn);
        sendBtn.setOnClickListener(this);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //将布局设置给Dialog
        inflate.setLayoutParams(params);
        setContentView(inflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = getWindow();
        //设置Dialog从窗体底部弹出
        WindowManager m = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.height = WindowManager.LayoutParams.WRAP_CONTENT; // 高度设置为屏幕的0.6
        p.width = (int) (d.getWidth() * 1.0f); // 宽度设置为屏幕的0.65
        dialogWindow.setAttributes(p);
        dialogWindow.setGravity( Gravity.BOTTOM);
    }

    private void sendComment(String content){
        Api.userAddComment(bookId, replyId, content, new ResponseCallback<Void>() {
            @Override
            public void onSuccess(Void data) {
                ToastUtils.showToast(getContext(),"评论成功");
                dismiss();
                EventBus.getDefault().post("refresh");
            }

            @Override
            public void onFailure(int errCode, String info) {
                ToastUtils.showToast(getContext(),info);
            }
        });
    }


    @Override
    public void onClick(View view) {
        String content = contentEt.getText().toString().trim();
        if (TextUtils.isEmpty(content)){
            ToastUtils.showToast(getContext(),"请输入评论内容");
            return;
        }
        sendComment(content);
    }
}
