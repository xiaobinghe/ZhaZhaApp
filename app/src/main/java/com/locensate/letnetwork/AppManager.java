package com.locensate.letnetwork;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 *  
 * @author xiaobinghe
 */


public class AppManager {

    private static List<Activity> mActivities = new ArrayList<>();

    public static boolean addActivity(Activity activity) {
        return mActivities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        mActivities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : mActivities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        mActivities.clear();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    /**
     * 清空界面
     */
    public static synchronized void clear() {
        for (int i = mActivities.size() - 1; i > -1; i--) {
            Activity a = mActivities.get(i);
            removeActivity(a);
            a.finish();
            i = mActivities.size();
        }
    }

    /**
     * @param clazz
     * @param bundle
     * @param activity
     */
    public static void skipActivityWithData(Class<?> clazz, Bundle bundle, Context activity) {
        Intent intent = new Intent(activity, clazz);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    /**
     * @param clazz
     */
    public static void skipActivity(Class<?> clazz, Context context) {
        context.startActivity(new Intent(context, clazz));
    }

}
