package com.locensate.letnetwork.main.ui.fragments.machineinfo.machinedesinfo;

import com.locensate.letnetwork.api.Api;
import com.locensate.letnetwork.base.RxSchedulers;
import com.locensate.letnetwork.bean.MachineInfoEntity;

import io.reactivex.functions.Consumer;

/**
 * 设备-信息
 *
 * @author xiaobinghe
 */

public class MachineInfoDataPresenter extends MachineInfoDataContract.Presenter {
    private long motorId;

    @Override
    public void onStart() {
        motorId = mView.getMotorInfo().getLong("motorId");
        initData();
    }


    @Override
    public void initData() {
        Api.getInstance().service.getMachineInfoData(motorId).compose(RxSchedulers.<MachineInfoEntity>applyObservableAsync()).subscribe(new Consumer<MachineInfoEntity>() {
            @Override
            public void accept(MachineInfoEntity machineInfoEntity) throws Exception {
                MachineInfoEntity.DataBean data = machineInfoEntity.getData();
                mView.dispatchData(data);
            }
        });
    }
}
