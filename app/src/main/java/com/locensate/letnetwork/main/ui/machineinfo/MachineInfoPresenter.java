package com.locensate.letnetwork.main.ui.machineinfo;

/**
 *
 * @author xiaobinghe
 */

public class MachineInfoPresenter extends MachineInfoContract.Presenter {

    private static final String TAG = "MachineInfoPresenter";

    @Override
    public void onStart() {
        setVPAdapter();
    }

    @Override
    public void setVPAdapter() {
        mView.addVPAdapter(mModel.getFragments());
    }

    @Override
    public void showPop() {
        mView.showPop();
    }
}
