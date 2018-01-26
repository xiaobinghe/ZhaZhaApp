package com.locensate.letnetwork.base;

import android.content.Context;

import com.locensate.letnetwork.utils.LogUtil;

import io.reactivex.disposables.CompositeDisposable;


/**
 * basePresenter
 *
 * @author xiaobinghe
 */

public abstract class BasePresenter<M, T> {

    public Context context;
    public M mModel;
    public T mView;
    /**
     * 管理订阅者者
     */
    protected CompositeDisposable mCompositeSubscription = new CompositeDisposable();


    void setVM(T v, M m) {
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }

    /**
     * Presenter运行
     */
    public abstract void onStart();

    public void onDestroy() {
        LogUtil.e("destroy", "+++++++++++++++++=======destroy!");
        mCompositeSubscription.clear();
    }
}
