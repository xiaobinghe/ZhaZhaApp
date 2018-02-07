package com.locensate.letnetwork.main.ui.fragments.machine;


import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.RxSchedulers;
import com.locensate.letnetwork.bean.MachineDataBean;
import com.locensate.letnetwork.bean.MachineFilterTag;
import com.locensate.letnetwork.bean.Organizations;
import com.locensate.letnetwork.main.ui.fragments.overview.OverviewModel;
import com.locensate.letnetwork.utils.OrganizationsOption;
import com.locensate.letnetwork.utils.ToastUtil;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * @author xiaobinghe
 */

public class MachinePresenter extends MachineContract.Presenter {
    @Override
    public void onStart() {

    }

    @Override
    public void showPop() {
        if (App.isMock) {
            mView.showPop(new OverviewModel().getGroupTree());
            return;
        }
        mModel.getOrganizations().compose(RxSchedulers.<Organizations>applyObservableAsync()).subscribe(new Consumer<Organizations>() {
            @Override
            public void accept(@NonNull Organizations organizations) throws Exception {
                mView.showPop(OrganizationsOption.handleOrganizations(organizations));
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                ToastUtil.show(App.getApplication().getString(R.string.load_fail));
            }
        });
    }

    @Override
    public void markImportant(MachineDataBean item) {
        mModel.postImpotantMachine(item);
    }

    @Override
    public void initData() {
        // TODO: 2018/1/26 请求设备列表
        mView.fillData(mModel.getMachineList());

    }

    @Override
    public void refreshFilter() {
        if (App.isMock) {
            mView.fillFilter(mModel.getFilterDefault());
            return;
        }

        mModel.getFilterTags().compose(RxSchedulers.<MachineFilterTag>applyObservableAsync()).subscribe(new Consumer<MachineFilterTag>() {
            @Override
            public void accept(MachineFilterTag machineFilterTag) throws Exception {
                mView.fillFilter(machineFilterTag);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                ToastUtil.show(App.getApplication().getString(R.string.load_fail));
            }
        });
    }

    @Override
    public void setImportantMachine(String id, String importantMachine, boolean important) {
//        mView.showDialog(important);
//        isImprotant();
    }

    @Override
    public void sort() {
        // TODO: 2018/1/26 功率排序
        Observable.just("1").delay(2000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                mView.sortComplete(mModel.getMachineList());
            }
        });
    }
}
