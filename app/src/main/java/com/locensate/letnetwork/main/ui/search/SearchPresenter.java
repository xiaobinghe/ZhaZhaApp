package com.locensate.letnetwork.main.ui.search;


/**
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

    @Override
    public void currentlySearch(String s) {
        // TODO: 2018/2/6 搜索业务
    }
}
