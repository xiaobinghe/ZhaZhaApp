package com.locensate.letnetwork.main.ui.fragments.machineinfo.machinedesinfo;

/**
 * 设备-信息
 *
 * @author xiaobinghe
 */

public class MachineInfoDataPresenter extends MachineInfoDataContract.Presenter {
    @Override
    public void onStart() {
    }


    @Override
    void initData() {
        mView.initView(mModel.getData());
    }
}
