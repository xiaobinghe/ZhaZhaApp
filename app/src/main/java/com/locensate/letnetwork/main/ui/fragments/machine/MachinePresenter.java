package com.locensate.letnetwork.main.ui.fragments.machine;


import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.RxSchedulers;
import com.locensate.letnetwork.bean.MachineDataBean;
import com.locensate.letnetwork.bean.MachineFilterTag;
import com.locensate.letnetwork.bean.Organizations;
import com.locensate.letnetwork.utils.OrganizationsOption;
import com.locensate.letnetwork.utils.ToastUtil;

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
//        mView.showPop(mModel.getGroupTree());
        // TODO: 2018/1/23 加载组织结构
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
    }
}
