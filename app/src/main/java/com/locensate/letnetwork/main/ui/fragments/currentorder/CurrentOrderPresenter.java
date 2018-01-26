package com.locensate.letnetwork.main.ui.fragments.currentorder;

/**
 *  
 * @author xiaobinghe
 */

public class CurrentOrderPresenter extends CurrentOrderContract.Presenter {
    @Override
    public void onStart() {
        fillData();
    }

    @Override
    public void fillData() {
        mView.fillData(mModel.getData());
    }
}
