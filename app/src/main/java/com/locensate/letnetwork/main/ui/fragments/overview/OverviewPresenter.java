package com.locensate.letnetwork.main.ui.fragments.overview;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.locensate.letnetwork.bean.Organizations;
import com.locensate.letnetwork.bean.OverviewMotor;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.OrganizationsOption;
import com.locensate.letnetwork.base.RxSchedulers;
import com.locensate.letnetwork.utils.ToastUtil;

import java.util.List;

import io.reactivex.functions.Consumer;

import static android.content.ContentValues.TAG;

/**
 * @author xiaobinghe
 */

public class OverviewPresenter extends OverviewContract.Presenter {
    @Override
    public void onStart() {
        mModel.getBaseDate().compose(RxSchedulers.<OverviewMotor>applyObservableAsync()).subscribe(new Consumer<OverviewMotor>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull OverviewMotor overviewMotor) throws Exception {
                mView.initData(overviewMotor);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull Throwable throwable) throws Exception {

            }
        });
        mView.fillContain(mModel.getContainFragment(mView.getRangeItem()));
    }

    @Override
    public void showPop() {
//        mView.showPop(mModel.getGroupTree());

        mModel.getOrganizations().compose(RxSchedulers.<Organizations>applyObservableAsync()).subscribe(new Consumer<Organizations>() {
            @Override
            public void accept(@NonNull Organizations organizations) throws Exception {
                LogUtil.e(TAG, "----------" + organizations.getOperCode()+"------"+organizations.getData().toString());
                List<MultiItemEntity> entities = OrganizationsOption.handleOrganizations(organizations);
                mView.showPop(entities);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                LogUtil.e(TAG, "------------" + throwable);
                ToastUtil.show("服务器开小差了，请稍后重试");
            }
        });
    }
}
