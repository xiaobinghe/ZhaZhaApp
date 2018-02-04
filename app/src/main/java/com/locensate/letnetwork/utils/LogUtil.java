package com.locensate.letnetwork.utils;

import android.util.Log;

import com.locensate.letnetwork.Constant;


/**
 * log
 *
 * @author xiaobinghe
 */

public class LogUtil {
    public static void d(String tag, String data) {
        if (!Constant.DEBUG) {
            return;
        }
        Log.d(tag, data);
    }

    public static void e(String tag, String data) {
        if (!Constant.DEBUG) {
            return;
        }
        Log.e(tag, data);
    }

    public static void w(String tag, String data) {
        if (!Constant.DEBUG) {
            return;
        }
        Log.w(tag, data);
    }

    public static void i(String tag, String data) {
        if (!Constant.DEBUG) {
            return;
        }
        Log.i(tag, data);
    }
}
