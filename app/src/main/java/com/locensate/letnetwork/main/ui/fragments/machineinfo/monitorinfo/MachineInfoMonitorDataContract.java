package com.locensate.letnetwork.main.ui.fragments.machineinfo.monitorinfo;

import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;

import java.util.List;


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

    }
}
