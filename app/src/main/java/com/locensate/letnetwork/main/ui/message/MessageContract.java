package com.locensate.letnetwork.main.ui.message;

import android.support.v4.app.Fragment;

import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;

/**
 *  
 * @author xiaobinghe
 */


public interface MessageContract {
    interface Model extends BaseModel {
        Fragment[] getMessageFragments();
    }

    interface View extends BaseView {
        void initData(Fragment[] messageFragments);
    }

    abstract class Presenter extends BasePresenter<Model, View> {

    }
}
