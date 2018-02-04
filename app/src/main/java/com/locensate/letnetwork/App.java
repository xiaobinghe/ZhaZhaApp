package com.locensate.letnetwork;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.locensate.letnetwork.utils.DisplayUtil;
import com.locensate.letnetwork.utils.UnceHandler;
import com.zhy.autolayout.config.AutoLayoutConifg;

import org.litepal.LitePalApplication;

import cn.jpush.android.api.JPushInterface;


/**
 * @author xiaobinghe
 */


public class App extends LitePalApplication {

    private static Application mApp;
    public static boolean isMock = true;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
    /* if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        mRefWatcher = LeakCanary.install(this);*/
        AutoLayoutConifg.getInstance().useDeviceSize();
        DisplayUtil.init(this);
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }

   /* public static RefWatcher getRefWatcher(Context context) {
        App applicationContext = (App)context.getApplicationContext();
        return applicationContext.mRefWatcher;
    }*/

    public static Context getApplication() {
        return mApp;
    }


    /**
     * 捕获全局Exception 重启界面
     */
    public void initCatchException() {
       /* 设置该CrashHandler为程序的默认处理器*/
        UnceHandler catchExcep = new UnceHandler(this);
        Thread.setDefaultUncaughtExceptionHandler(catchExcep);
    }


    public static Resources getResource() {
        return mApp.getResources();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }
}

