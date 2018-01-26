package com.locensate.letnetwork.main.ui.home;

/**
 *
 * @author xiaobinghe
 */

public class HomePresenter extends HomeContract.Presentor{
    @Override
    public void onStart() {

    }

    @Override
    public void showFragments() {
        mView.getFragments();
    }
}
