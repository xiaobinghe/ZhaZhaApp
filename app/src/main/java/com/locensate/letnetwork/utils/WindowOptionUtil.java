package com.locensate.letnetwork.utils;

import android.app.Activity;
import android.view.WindowManager;

import com.locensate.letnetwork.R;


/**
 *
 * @author xiaobinghe
 */


public class WindowOptionUtil {


    public static void darkBackGround(float v, Activity activity) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.windowAnimations = R.anim.fade_in;
        lp.alpha = v;
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        activity.getWindow().setAttributes(lp);
    }


}
