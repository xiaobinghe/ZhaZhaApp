package com.locensate.letnetwork.main.ui.fragments.machineinfo.machinedesinfo;

import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;


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
        /**
         * 初始化View
         *
         * @param data
         */
        void initView(String data);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
            abstract void initData();
    }
}
