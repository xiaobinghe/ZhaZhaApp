package com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager;

import android.support.v4.app.Fragment;

import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;

import java.util.List;

/**
 *  
 * @author xiaobinghe
 */

public interface MachineInfoFixManagerContract {

    interface Model extends BaseModel {
        List<Fragment> getFragments();
    }

    interface View extends BaseView {
        void fillData(List<Fragment> fragments);

        String getMachineName();
    }

    abstract class Presenter extends BasePresenter<Model, View> {

    }
}
