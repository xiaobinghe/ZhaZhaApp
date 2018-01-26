package com.locensate.letnetwork.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;

import com.gyf.barlibrary.ImmersionBar;
import com.locensate.letnetwork.AppManager;
import com.locensate.letnetwork.utils.InstanceUtil;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.TUtil;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * BaseActivity
 *
 * @author xiaobinghe
 */

public abstract class BaseActivity<T extends BasePresenter, E extends BaseModel> extends AutoLayoutActivity {
    public T mPresenter;
    public E mModel;
    public Context mContext;
    private Unbinder mUnBinder;
    protected String TAG = this.getClass().getName();
    private ImmersionBar mImmersionBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.addActivity(this);
        this.setContentView(this.getLayoutId());
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.hide();
        }
        mUnBinder = ButterKnife.bind(this);
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
        mContext = this;
        if (this instanceof BaseView) {
            LogUtil.e(TAG, this.getClass().getName() + "        created!");
            mPresenter = InstanceUtil.getInstance(TUtil.getClass(this, 0));
            mModel = InstanceUtil.getInstance(TUtil.getClass(this, 1));
        }
        this.initView();

        if (this instanceof BaseView) {
            LogUtil.e(TAG, this.getClass().getName() + "           init presenter!");
            mPresenter.setVM(this, mModel);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
        mImmersionBar.destroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        AppManager.removeActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    public void reload() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    /**
     * 获取布局文件
     *
     * @return 布局文件id
     */
    public abstract int getLayoutId();

    /**
     * 初始化View
     */
    public abstract void initView();

    /**
     * 启动activity
     */
    protected void startActivity(Class<?> clazz) {
        Intent intent = new Intent(getApplication(), clazz);
        startActivity(intent);
    }
}
