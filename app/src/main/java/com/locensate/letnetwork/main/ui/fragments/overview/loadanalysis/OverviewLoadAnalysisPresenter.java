package com.locensate.letnetwork.main.ui.fragments.overview.loadanalysis;

/**
 *
 * @author xiaobinghe
 */

public class OverviewLoadAnalysisPresenter extends OverviewLoadAnalysisContract.Presenter {
    @Override
    public void onStart() {
        mView.fillData(mModel.initData());
    }
}
