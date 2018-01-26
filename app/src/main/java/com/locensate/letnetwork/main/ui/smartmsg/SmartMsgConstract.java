package com.locensate.letnetwork.main.ui.smartmsg;

import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;
import com.locensate.letnetwork.entity.SmartMsgEntity;

import java.util.List;


/**
 *  
 * @author xiaobinghe
 */


public interface SmartMsgConstract {
    interface Model extends BaseModel{
        List<SmartMsgEntity> getInitData();
    }

    interface View extends BaseView{

    }

    abstract class Presenter extends BasePresenter<Model,View>{

    }

}

