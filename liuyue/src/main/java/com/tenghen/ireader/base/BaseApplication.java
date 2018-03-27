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
        PlatformConfig.setWeixin("wx0be45c8b5fc6cbd4","b3b3665d351d4033aa791fd6e37b5057");
        PlatformConfig.setQQZone("1106049570","");
        PlatformConfig.setSinaWeibo("958722460","179761d7876545d49f2a252c00dba5e1","");
    }

}
