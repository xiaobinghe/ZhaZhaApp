package com.locensate.letnetwork.main.ui;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.main.ui.login.LoginActivity;
import com.locensate.letnetwork.utils.AnimationUtil;
import com.locensate.letnetwork.utils.LogUtil;

import butterknife.BindView;

/**
 *  
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
        LogUtil.e(TAG, "===================" +System.currentTimeMillis());
        ivFlash.startAnimation(animationSet);
        LogUtil.e(TAG, "===================" + TAG + "5");
        AnimationUtil.setAnimationListener(anim, new AnimationUtil.AnimListener() {
            @Override
            public void onAnimFinish() {
                startActivity(new Intent(mContext, LoginActivity.class));
//                startActivity(new Intent(mContext, HomeActivity.class));
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
