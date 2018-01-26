package com.locensate.letnetwork.main.ui.dataanalysis;

/**
 *
 * @author xiaobinghe
 */

public class DataAnalysisPresenter extends DataAnalysisContract.Presenter{
    @Override
    public void onStart() {
        mView.initData(mModel.getData());
    }
}
