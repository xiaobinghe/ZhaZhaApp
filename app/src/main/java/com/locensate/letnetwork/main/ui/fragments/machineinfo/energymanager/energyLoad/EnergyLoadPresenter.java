package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyLoad;


/**
 *
 * @author xiaobinghe
 */

public class EnergyLoadPresenter extends EnergyLoadContract.Presenter {
    @Override
    public void onStart() {
        mView.setBarData(mModel.getBarData());
        mView.setPieData(mModel.getPieData());
        mView.setLineData(mModel.getLineData(), mModel.getDataLabels());
    }
}
