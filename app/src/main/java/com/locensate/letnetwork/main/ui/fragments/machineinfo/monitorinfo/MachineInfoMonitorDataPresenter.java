package com.locensate.letnetwork.main.ui.fragments.machineinfo.monitorinfo;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.api.Api;
import com.locensate.letnetwork.base.RxSchedulers;
import com.locensate.letnetwork.bean.TestBean;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.ToastUtil;

import io.reactivex.functions.Consumer;

/**
 * @author xiaobinghe
 */

public class MachineInfoMonitorDataPresenter extends MachineInfoMonitorDataContract.Presenter {
    private long motorId;

    @Override
    public void onStart() {
        motorId = mView.getMotorId();
        initData();
    }

    @Override
    public void initData() {
        Api.getInstance().service.getMotorLastData(motorId).compose(RxSchedulers.<TestBean>applyObservableAsync()).subscribe(new Consumer<TestBean>() {
            @Override
            public void accept(TestBean motorLastDataEntity) throws Exception {
                TestBean.DataBean data = motorLastDataEntity.getData();
                mView.fillData(mModel.handleData(motorId, data));
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                LogUtil.e("getMotorLastData", "-------throwable=" + throwable.toString());
                ToastUtil.show(R.string.data_load_fail);
            }
        });
    }
}
