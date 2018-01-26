package com.locensate.letnetwork.main.ui.fragments.machineinfo.monitorinfo;

/**
 *  
 * @author xiaobinghe
 */

public class MachineInfoMonitorDataPresenter extends  MachineInfoMonitorDataContract.Presenter{
    @Override
    public void onStart() {
        mView.fillData(mModel.getMonitorData());
    }
}
