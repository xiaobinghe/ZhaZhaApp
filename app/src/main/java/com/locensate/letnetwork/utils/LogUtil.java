package com.locensate.letnetwork.utils;

import android.util.Log;

import com.locensate.letnetwork.Constant;


/**
 * log
 *
 * @author xiaobinghe
 */

public class LogUtil {

    private static final int JSON_INDENT = 4;

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

//        try {
//            Log.d(tag, new JSONObject(data).toString(JSON_INDENT));
//        } catch (JSONException e) {
//            try {
//                Log.d(tag, new JSONArray(data).toString(JSON_INDENT));
//            } catch (JSONException ei) {
//                Log.d(tag, data);
//            }
//        }
    }
}
