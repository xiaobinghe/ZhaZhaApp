package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyfgp;

/**
 * @author xiaobinghe
 */


public class EnergyFengGuPingPresenter extends EnergyFengGuPingConstract.Presenter {
    @Override
    public void onStart() {

//        Api.getInstance().service.getMotorFgpData();

        mView.setPieData(mModel.getPieMockData());
    }
}
