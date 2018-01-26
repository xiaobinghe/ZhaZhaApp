package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyfgp;

import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;


/**
 *  
 * @author xiaobinghe
 */

public interface EnergyFengGuPingConstract {
    interface View extends BaseView{}

    interface Model extends BaseModel{}

    abstract class Presenter extends BasePresenter<Model,View>{

    }

}
