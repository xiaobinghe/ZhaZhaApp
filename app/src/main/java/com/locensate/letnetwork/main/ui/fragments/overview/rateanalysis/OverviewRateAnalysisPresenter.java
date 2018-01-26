package com.locensate.letnetwork.main.ui.fragments.overview.rateanalysis;

/**
 * @author xiaobinghe
 */


public class OverviewRateAnalysisPresenter extends OverviewRateAnalysisContract.Presenter {
    @Override
    public void onStart() {
        mView.fillData(mModel.initData());
    }
}
