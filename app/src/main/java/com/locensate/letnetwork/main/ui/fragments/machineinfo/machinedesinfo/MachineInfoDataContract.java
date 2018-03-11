package com.locensate.letnetwork.main.ui.fragments.machineinfo.machinedesinfo;

import android.os.Bundle;

import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;
import com.locensate.letnetwork.bean.MachineInfoEntity;


/**
 * 设备-信息
 *
 * @author xiaobinghe
 */

public interface MachineInfoDataContract {

    interface Model extends BaseModel {
        /**
         * 获取数据
         *
         * @return
         */
        String getData();
    }

    interface View extends BaseView {

        void dispatchData(MachineInfoEntity.DataBean data);

        Bundle getMotorInfo();
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        /**
         * 初始化数据
         */
       public abstract void initData();
    }
}
