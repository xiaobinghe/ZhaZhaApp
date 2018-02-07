package com.locensate.letnetwork.main.ui.fragments.machineinfo.monitorinfo;

import com.locensate.letnetwork.App;

/**
 * @author xiaobinghe
 */

public class MachineInfoMonitorDataPresenter extends MachineInfoMonitorDataContract.Presenter {
    @Override
    public void onStart() {



    }

    @Override
    void initData() {
        if (App.isMock) {
            mView.fillData(mModel.getMonitorData());
            mModel.getMonitorData();
            return;
        }

/*
        *//*1、读取依附的设备列表（控制设备，监测设备，滤波补偿设备）*//*
        mModel.getEquipments().compose(RxSchedulers.<EquipmentsEntity>applyObservableAsync()).flatMap(new Function<EquipmentsEntity, ObservableSource<BaseSubEquipment>>() {
            @Override
            public ObservableSource<BaseSubEquipment> apply(EquipmentsEntity equipmentsEntity) throws Exception {
                *//*2、获取各类设备的可读取参数*//*
                //遍历equipmentsEntity中的设备，拿到Type判断是属于什么设备
                for (int i = 0; i < 5; i++) {
                    String type = "";
                    if (type.equals("监测设备")) {
                        MonitorEquipmentEntity monitor = (MonitorEquipmentEntity) equipmentsEntity.getData().get(i);
                        return mModel.getMonitorLatestData(monitor.getId());
                    } else if (type.equals("控制设备")) {
                        ControlEquipmentEntity control = (ControlEquipmentEntity) equipmentsEntity.getData().get(i);
                        return mModel.getControlLatestData(control.getId());
                    } else if (type.equals("滤波补偿")) {
                        FilterCompensationEntity filter = (FilterCompensationEntity) equipmentsEntity.getData().get(i);
                        return mModel.getFilterCompensationLatestData(filter.getId());
                    }
                }
                return null;
            }
        }).flatMap(new Function<BaseSubEquipment, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(BaseSubEquipment baseSubEquipment) throws Exception {
                return null;
            }
        });

        *//*3、获取可读取参数的最新值*//*

        *//*4、*/

    }
}
