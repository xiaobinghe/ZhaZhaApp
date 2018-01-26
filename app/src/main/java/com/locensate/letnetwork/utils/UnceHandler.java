package com.locensate.letnetwork.utils;

import android.app.Application;
import android.os.Looper;
import android.os.SystemClock;

import java.io.File;
import java.io.PrintWriter;


/**
 * @author xiaobinghe
 */


public class UnceHandler implements Thread.UncaughtExceptionHandler {

    private Thread.UncaughtExceptionHandler mDefaultUncaught;
    private Application mApplication;

    public UnceHandler(Application application) {
        //获取系统的UncaughtExcceptionHandler
        mDefaultUncaught = Thread.getDefaultUncaughtExceptionHandler();
        this.mApplication = application;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        if (!handleException(throwable) && mDefaultUncaught != null) {
            //如果用户没有处理则由系统默认的异常处理器处理
            mDefaultUncaught.uncaughtException(thread, throwable);
        }
    }

    private boolean handleException(Throwable throwable) {
        if (throwable == null) {
            return false;
        }
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                ToastUtil.show("很抱歉，程序出现异常，即将退出。");
                Looper.loop();
            }
        }.start();

        File file = new File(mApplication.getCacheDir().getAbsolutePath(), "/err/");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            PrintWriter writer = new PrintWriter(mApplication.getCacheDir().getAbsolutePath() + "/err/" + SystemClock.currentThreadTimeMillis() + ".log");
            throwable.printStackTrace(writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return false;
    }
}
