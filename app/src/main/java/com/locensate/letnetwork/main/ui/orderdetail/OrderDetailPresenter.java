package com.locensate.letnetwork.main.ui.orderdetail;


/**
 *  
 * @author xiaobinghe
 */

public class OrderDetailPresenter extends OrderDetailContract.Presenter {
    @Override
    public void onStart() {
        mView.initData();
    }
}
