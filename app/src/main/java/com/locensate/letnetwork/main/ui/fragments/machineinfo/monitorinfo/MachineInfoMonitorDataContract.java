package com.locensate.letnetwork.main.ui.fragments.machineinfo.monitorinfo;

import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;
import com.locensate.letnetwork.bean.BaseSubEquipment;
import com.locensate.letnetwork.bean.EquipmentsEntity;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;


/**
 * 设备-信息
 *
 * @author xiaobinghe
 */


public interface MachineInfoMonitorDataContract {

    interface Model extends BaseModel {

        /**
         * 获取电机数据
         *
         * @return
         */
        List<MonitoringData> getMonitorData();

        /**
         * 获取依附的设备列表（控制设备，监测设备，滤波补偿设备等）
         *
         * @return
         */
        Observable<EquipmentsEntity> getEquipments();

        /**
         * 获取监测设备的最新数据
         *
         * @param id
         * @return
         */
        ObservableSource<BaseSubEquipment> getMonitorLatestData(long id);

        /**
         * 获取控制设备的最新数据
         *
         * @param id
         * @return
         */
        ObservableSource<BaseSubEquipment> getControlLatestData(long id);

        /**
         * 获取滤波补偿设备的最新数据
         *
         * @param id
         * @return
         */
        ObservableSource<BaseSubEquipment> getFilterCompensationLatestData(long id);
    }

    interface View extends BaseView {

        /**
         * 填充数据
         *
         * @param runningStateData
         */
        void fillData(List<MonitoringData> runningStateData);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        abstract void initData();
    }
}
