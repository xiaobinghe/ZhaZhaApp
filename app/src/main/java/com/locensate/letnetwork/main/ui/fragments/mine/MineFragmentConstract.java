package com.locensate.letnetwork.main.ui.fragments.mine;

import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;

/**
 *  
 * @author xiaobinghe
 */


public interface MineFragmentConstract {


    interface View extends BaseView {
    }

    interface Model extends BaseModel {
    }

    abstract class Presenter extends BasePresenter<Model, View> {

    }

}
