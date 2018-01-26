package com.locensate.letnetwork.base;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * 用于管理RxBus的事件和Rxjava相关代码的生命周期处理
 * Created by baixiaokang on 16/4/28.
 */
public class RxManager {

    public RxBus mRxBus = RxBus.get();
    private Map<String, Flowable<?>> mObservables = new HashMap<>();// 管理观察源
    private CompositeDisposable mCompositeSubscription = new CompositeDisposable();// 管理订阅者者


    public void on(String eventName, Consumer<Object> action1) {
        Flowable<?> mObservable = (Flowable<?>) mRxBus.register();
        mObservables.put(eventName, mObservable);
        mCompositeSubscription.add(mObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(action1));
    }

    public void add(Disposable m) {
        mCompositeSubscription.add(m);
    }

    public void clear() {
        mCompositeSubscription.dispose();
        for (Map.Entry<String, Flowable<?>> entry : mObservables.entrySet()) {
            mRxBus.unRegister();// 移除观察
        }
    }

    public void post( Object content) {
        mRxBus.post(content);
    }


}
