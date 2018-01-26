package com.locensate.letnetwork.main.ui.message;

/**
 *  
 * @author xiaobinghe
 */

public class MessagePresenter extends MessageContract.Presenter {
    @Override
    public void onStart() {
        mView.initData(mModel.getMessageFragments());
    }
}
