package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager;

import android.support.v4.app.Fragment;

import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;

/**
 *  
 * @author xiaobinghe
 */


public interface MachineInfoEnergyManagerContract {
    interface View extends BaseView {
        void initData(Fragment[] fragments);

    }

    interface Model extends BaseModel {
        Fragment[] getFragments();
    }

    abstract class Presenter extends BasePresenter<Model, View> {

    }
}
