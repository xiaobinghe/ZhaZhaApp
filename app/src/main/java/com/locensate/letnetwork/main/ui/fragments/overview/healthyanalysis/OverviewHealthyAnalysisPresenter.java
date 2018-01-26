package com.locensate.letnetwork.main.ui.fragments.overview.healthyanalysis;

/**
 *  
 * @author xiaobinghe
 */

public class OverviewHealthyAnalysisPresenter extends OverviewHealthyAnalysisContract.Presenter {
    @Override
    public void onStart() {
        mView.fillData(mModel.initData());
    }
}
