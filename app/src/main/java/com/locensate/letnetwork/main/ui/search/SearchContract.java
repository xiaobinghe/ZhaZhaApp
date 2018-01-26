package com.locensate.letnetwork.main.ui.search;

import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;


/**
 *
 * @author xiaobinghe
 */


public interface SearchContract {

    interface Model extends BaseModel{


    }

    interface View extends BaseView{
        void fillData();

    }

    abstract class Presenter extends BasePresenter<Model,View> {

        public abstract void clearData();
    }
}
