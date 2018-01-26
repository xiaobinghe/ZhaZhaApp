package com.locensate.letnetwork.main.ui.machineinfo;

import android.support.v4.app.Fragment;

import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;


/**
 *
 * @author xiaobinghe
 */

public interface MachineInfoContract {

    interface Model extends BaseModel {

        Fragment[] getFragments();
    }

    interface View extends BaseView {
        void addVPAdapter(Fragment[] fragments);

        void showPop();
    }

    abstract class Presenter extends BasePresenter<Model, View> {

        abstract void setVPAdapter();

        abstract void showPop();
    }
}
