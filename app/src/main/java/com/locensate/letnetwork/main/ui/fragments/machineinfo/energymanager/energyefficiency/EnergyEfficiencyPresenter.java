package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyefficiency;


/**
 *  
 * @author xiaobinghe
 */


public class EnergyEfficiencyPresenter extends EnergyEfficiencyContract.Presenter {
    @Override
    public void onStart() {
        mView.setPieData(mModel.getPieData());
        mView.setLineData(mModel.getLineData(),mModel.getLineLabels());
    }
}
