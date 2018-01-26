package com.locensate.letnetwork.utils;

import android.view.animation.Animation;


/**
 * 动画工具
 *
 * @author xiaobinghe
 */

public class AnimationUtil {

    public static void setAnimationListener(Animation aninm, final AnimListener listener) {
        aninm.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                listener.onAnimFinish();
                LogUtil.e("tag", "===================" + "6");

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    public interface AnimListener {
        /**
         * 当动画完成时调用
         */
        void onAnimFinish();
    }
}
