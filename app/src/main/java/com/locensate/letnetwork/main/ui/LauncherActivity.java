package com.locensate.letnetwork.main.ui;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.main.ui.home.HomeActivity;
import com.locensate.letnetwork.main.ui.login.LoginActivity;
import com.locensate.letnetwork.utils.AnimationUtil;
import com.locensate.letnetwork.utils.LogUtil;

import java.lang.reflect.Field;

import butterknife.BindView;

/**
 * @author xiaobinghe
 */


public class LauncherActivity extends BaseActivity {

    @BindView(R.id.iv_flash)
    ImageView ivFlash;
    @BindView(R.id.activity_launcher)
    CoordinatorLayout activityLauncher;

    @Override
    public int getLayoutId() {
        setTheme(R.style.LauncherTheme);
        return R.layout.activity_launcher;
    }

    @Override
    public void initView() {
        AnimationSet animationSet = new AnimationSet(true);
        RotateAnimation anim = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(100);
        animationSet.addAnimation(anim);
        LogUtil.e(TAG, "===================" + TAG + "4");
        LogUtil.e(TAG, "===================" + System.currentTimeMillis());
        ivFlash.startAnimation(animationSet);
        LogUtil.e(TAG, "===================" + TAG + "5");
        AnimationUtil.setAnimationListener(anim, new AnimationUtil.AnimListener() {
            @Override
            public void onAnimFinish() {
                if (App.isMock) {
                    startActivity(new Intent(mContext, HomeActivity.class));
                } else {
                    startActivity(new Intent(mContext, LoginActivity.class));
                }

                finish();
            }
        });
    }

    @Override
    protected void onResume() {


        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, sbar = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            sbar = getResources().getDimensionPixelSize(x);

            LogUtil.e("status_bar_size", "---------" + sbar);
        } catch (Exception e1) {
            LogUtil.e("Ec", "get status bar height fail");
            e1.printStackTrace();
        }
        super.onResume();
    }
}
