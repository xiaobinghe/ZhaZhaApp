package com.locensate.letnetwork.main.ui.fragments.historyorder;

/**
 *  
 * @author xiaobinghe
 */

public class HistoryOrderPresenter extends HistoryOrderContract.Presenter{
    @Override
    public void onStart() {
        mView.fillData(mModel.getData());
    }
}
