package com.locensate.letnetwork.main.ui.riplanmsg;

import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;
import com.locensate.letnetwork.entity.RiplanMsgEntity;

import java.util.List;

/**
 *  
 * @author xiaobinghe
 */

public interface RiPlanMsgContract {
    interface Model extends BaseModel{
        List<RiplanMsgEntity>  getInitData();
    }

    interface View extends BaseView {

    }

    abstract class Presenter extends BasePresenter<Model,View>{

    }

}
