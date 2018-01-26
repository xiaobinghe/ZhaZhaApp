package com.locensate.letnetwork.main.ui.home;

import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;

/**
 *
 * @author xiaobinghe
 */

public interface HomeContract {
    interface Model extends BaseModel {

    }

    interface View extends BaseView{
        void getFragments();
    }

    abstract static class Presentor extends BasePresenter<Model,View> {
       public abstract void showFragments();
    }
}
