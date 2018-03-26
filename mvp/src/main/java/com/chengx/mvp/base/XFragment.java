package com.chengx.mvp.base;

import android.app.usage.UsageEvents;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.chengx.mvp.R;
import com.chengx.mvp.utils.KLog;
import com.chengx.mvp.utils.SPUtils;
import com.chengx.mvp.utils.ToastUtils;
import com.chengx.mvp.widget.auto.AutoToolbar;
import com.chengx.mvp.widget.loadding.CustomDialog;

import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * 作者：chengx
 * 日期：2017/2/9
 * 描述：
 */

public abstract class XFragment<P extends IPresent> extends Fragment implements IView<P> {

    public final String TAG = getClass().getSimpleName();
    private P present;
    protected View rootView;
    protected SPUtils sp;
    private boolean needFullScreen;
    private boolean needBack = true;
    private CustomDialog dialog;
    protected AutoToolbar toolbar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (useEventBus()){
            EventBus.getDefault().register(this);
        }
        sp = new SPUtils(getActivity(),AppConfig.SP_NAME);
        if (needFullScreen){
            getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FIRST_SUB_WINDOW);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutId(),container,false);
            ButterKnife.bind(this,rootView);
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        toolbar = (AutoToolbar) rootView.findViewById(R.id.common_toolbar);
        log("toolbar = null?" + toolbar != null);
        if (toolbar != null) {
            if (needBack)
                toolbar.setNavigationIcon(R.drawable.btn_back);
            initToolBar();
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initViews();
        setListener();
    }

    protected P getPresent(){
        if (present == null) {
            present = newPresent();
            if (present != null) {
                present.attachV(this);
            }
        }
        return present;
    }


    public boolean isNeedBack() {
        return needBack;
    }

    public void setNeedBack(boolean needBack) {
        this.needBack = needBack;
    }

    @Override
    public boolean useEventBus() {
        return false;
    }


    public CustomDialog getDialog(){
        if (dialog == null) {
            dialog = CustomDialog.instance(getActivity());
            dialog.setCancelable(true);
        }
        return dialog;
    }

    public void showDialog(){
        getDialog().show();
    }

    public void log(Object... objects){
        KLog.d(TAG, objects);
    }

    public void logJson(String json){
        KLog.json(TAG, json);
    }

    public void dismissDialog(){
        if (dialog != null) {
            dialog.hide();
            dialog = null;
        }
    }

    public void showToast(String str){
        ToastUtils.showToast(getContext(),str);
    }

    public boolean isNeedFullScreen() {
        return needFullScreen;
    }

    public void setNeedFullScreen(boolean needFullScreen) {
        this.needFullScreen = needFullScreen;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (useEventBus() && EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }
        if (getPresent() != null){
            present.detachV();
        }
        dismissDialog();
        present = null;
    }
}
