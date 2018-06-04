package com.tenghen.ireader.base;

import android.app.Application;

import com.chengx.mvp.base.AppConfig;
import com.chengx.mvp.utils.AppUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;
import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * 作者：chengx
 * 日期：2017/2/22
 * 描述：
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppUtils.init(this);
        AutoLayoutConifg.getInstance().useDeviceSize();
        Config.DEBUG = true;
    }

    {
        PlatformConfig.setWeixin("wxe8cdf24a5df779a1","91c5b97649df33e75ecd612f021f41e0");
        PlatformConfig.setQQZone("101472315","28ad3a2e26d5c4wa6a587bd8680f82dc");
        PlatformConfig.setSinaWeibo("958722460","179761d7876545d49f2a252c00dba5e1","");
    }

}
