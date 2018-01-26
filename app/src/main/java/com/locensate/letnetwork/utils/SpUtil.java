package com.locensate.letnetwork.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.locensate.letnetwork.Constant;

/**
 * SharePreference工具
 *
 * @author xiaobinghe
 */

public class SpUtil {
    public static SharedPreferences sp;

    /**
     * 保存boolean类型的数据
     *
     * @param context
     * @param key
     * @param value
     */
    public static void saveBoolean(Context context, String key, boolean value) {
        if (sp == null) {
            sp = context.getSharedPreferences(Constant.CONFIG, Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key, value).commit();
    }

    /**
     * 获取boolean类型的数据
     *
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static boolean getBoolean(Context context, String key, boolean defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(Constant.CONFIG, Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key, defValue);
    }

    public static void saveString(Context context, String key, String value) {
        if (sp == null) {
            sp = context.getSharedPreferences(Constant.CONFIG, Context.MODE_PRIVATE);
        }
        //保存操作
        sp.edit().putString(key, value).commit();
    }

    public static String getString(Context context, String key, String defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(Constant.CONFIG, Context.MODE_PRIVATE);
        }
        return sp.getString(key, defValue);//defValue : 默认值
    }


    public static void saveInt(Context context, String key, int value) {
        if (sp == null) {
            sp = context.getSharedPreferences(Constant.CONFIG, Context.MODE_PRIVATE);
        }
        sp.edit().putInt(key, value).commit();
    }

    public static int getInt(Context context, String key, int defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(Constant.CONFIG, Context.MODE_PRIVATE);
        }
        return sp.getInt(key, defValue);//defValue : 默认值
    }
}
