package com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager;


/**
 *  
 * @author xiaobinghe
 */

public class MachineInfoFixManagerPresenter extends MachineInfoFixManagerContract.Presenter{
    @Override
    public void onStart() {
        mView.fillData(mModel.getFragments());
    }
}
