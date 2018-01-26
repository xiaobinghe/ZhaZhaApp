package com.locensate.letnetwork.view;

import android.os.SystemClock;
import android.view.View;

/**
 * 防止重复点击的监听
 *
 * @author xiaobinghe
 */
abstract class BaseSingleClickListener implements View.OnClickListener {


    private long lastTime;


    @Override
    public void onClick(View view) {
        if (fastClick()) {
            return;
        }
        onSingleClick(view);
    }

    /**
     * single click 防止快速重复点击
     *
     * @param view view
     */
    abstract void onSingleClick(View view);

    private boolean fastClick() {
        long delayTime = 1000;
        long clickTime = SystemClock.currentThreadTimeMillis();
        long dTime = clickTime - lastTime;
        if (dTime > delayTime) {
            lastTime = clickTime;
            return false;
        }
        return true;
    }
}
