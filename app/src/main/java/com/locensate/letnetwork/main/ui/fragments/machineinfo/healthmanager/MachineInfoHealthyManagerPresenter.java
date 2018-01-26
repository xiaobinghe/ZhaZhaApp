package com.locensate.letnetwork.main.ui.fragments.machineinfo.healthmanager;


/**
 * 设备-健康管理
 *
 * @author xiaobinghe
 */

public class MachineInfoHealthyManagerPresenter extends MachineInfoHealthyManagerContract.Presenter {
    @Override
    public void onStart() {
        mView.fillData(mModel.getPieTempData(), mModel.getPieSharkData(), mModel.getPieElectHotterData(), mModel.getPieStartCountData(), mModel.getPieCurrentOverData());
    }
}
