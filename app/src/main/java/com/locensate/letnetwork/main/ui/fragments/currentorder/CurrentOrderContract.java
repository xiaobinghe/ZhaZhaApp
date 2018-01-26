package com.locensate.letnetwork.main.ui.fragments.currentorder;

import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;
import com.locensate.letnetwork.entity.OrderItemEntity;

import java.util.List;

/**
 * @author xiaobinghe
 */


interface CurrentOrderContract {

    interface Model extends BaseModel {
        List<OrderItemEntity> getData();
    }

    interface View extends BaseView {
        void fillData(List<OrderItemEntity> data);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void fillData();
    }
}
