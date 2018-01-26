package com.locensate.letnetwork.main.ui.orderdetail;

import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;

/**
 *  
 * @author xiaobinghe
 */


public interface OrderDetailContract {

    interface View extends BaseView{
        void initData();
    }

    interface Model extends BaseModel{
    }

    abstract class  Presenter extends BasePresenter<Model,View>{

    }
}
