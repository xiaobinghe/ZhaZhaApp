package com.locensate.letnetwork.main.ui.search;


/**
 *
 * @author xiaobinghe
 */

public class SearchPresenter extends SearchContract.Presenter {
    @Override
    public void onStart() {
        mView.fillData();
    }

    @Override
    public void clearData() {

    }
}
