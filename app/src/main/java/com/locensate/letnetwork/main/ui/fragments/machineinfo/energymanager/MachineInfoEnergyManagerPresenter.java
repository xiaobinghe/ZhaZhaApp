package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager;


/**
 *  
 * @author xiaobinghe
 */

public class MachineInfoEnergyManagerPresenter extends MachineInfoEnergyManagerContract.Presenter {
    @Override
    public void onStart() {
      mView.initData(mModel.getFragments());
    }
}
