package com.locensate.letnetwork.main.ui.ordermsg;

import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;
import com.locensate.letnetwork.entity.OrderMsgEntity;

import java.util.List;

/**
 *  
 * @author xiaobinghe
 */

public interface OrderMsgContract {
    interface Model extends BaseModel{
        List<OrderMsgEntity> getInitDate();
    }

    interface View extends BaseView{
    }

    abstract class Presenter extends BasePresenter<Model,View>{

    }
}
