package com.locensate.letnetwork.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.locensate.letnetwork.utils.InstanceUtil;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.TUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.ContentValues.TAG;

/**
 * baseFragment
 *
 * @author xiaobinghe
 */

public abstract class BaseFragment<T extends BasePresenter, V extends BaseModel> extends Fragment {

    public Context mContext;
    public T mPresenter;
    public V mModel;
    private View rootView;
    private Unbinder mUnbinder;
    public static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";
    private boolean isInit = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (isSupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commit();
        }
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = LayoutInflater.from(mContext).inflate(getInflaterView(), null);
        }
        mUnbinder = ButterKnife.bind(this, rootView);
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        if (this instanceof BaseView) {
            mPresenter = InstanceUtil.getInstance(TUtil.getClass(this, 0));
            mModel = InstanceUtil.getInstance(TUtil.getClass(this, 1));
        }
        initView();
        if (this instanceof BaseView) {
            mPresenter.setVM(this, mModel);
        }
        isInit = true;
        return rootView;
    }


    /**
     * 当Activity创建时调用
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    protected boolean isVisible;

    /**
     * setUserVisibleHint  adapter中的每个fragment切换的时候都会被调用，如果是切换到当前页，那么isVisibleToUser==true，否则为false
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    /**
     * 可见
     */
    protected void onVisible() {
        if (isInit) {
            lazyLoad();
        }
    }


    /**
     * 不可见
     */
    protected void onInvisible() {

    }

    /**
     * Fragment的布局填充
     *
     * @return
     */
    public abstract int getInflaterView();

    /**
     * 初始化界面
     */
    protected abstract void initView();

    /**
     * 延迟加载
     * 子类必须重写此方法
     */
    protected abstract void lazyLoad();


    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
        LogUtil.e(TAG, "destroy view!" + rootView.getId());
//        RefWatcher refWatcher = App.getRefWatcher(getActivity());
//        refWatcher.watch(this);
    }

}