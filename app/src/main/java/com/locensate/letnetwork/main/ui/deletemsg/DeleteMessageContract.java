package com.locensate.letnetwork.main.ui.deletemsg;

import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;
import com.locensate.letnetwork.entity.MessageEntity;

import java.util.ArrayList;

/**
 *  删除消息
 * @author xiaobinghe
 */


public interface DeleteMessageContract {

    interface View extends BaseView {

        /**
         * 初始化数据
         */
        void initData();
    }

    interface Model extends BaseModel {

        ArrayList<MessageEntity> getAlertMsg();

        ArrayList<MessageEntity> getEnergyMsg();

        ArrayList<MessageEntity> getOrderMsg();

        ArrayList<MessageEntity> getRemindMsg();
    }

    abstract class Presenter extends BasePresenter<Model, View> {
    }
}
