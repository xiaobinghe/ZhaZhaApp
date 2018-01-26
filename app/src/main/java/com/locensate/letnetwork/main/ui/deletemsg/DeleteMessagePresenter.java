package com.locensate.letnetwork.main.ui.deletemsg;

/**
 *
 * @author xiaobinghe
 */


public class DeleteMessagePresenter extends DeleteMessageContract.Presenter {
    @Override
    public void onStart() {
        mView.initData();
    }
}
