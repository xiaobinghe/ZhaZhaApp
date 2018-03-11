package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager;

import android.support.v4.app.Fragment;

import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;
import com.locensate.letnetwork.bean.MotorEfficiencyBaseEntity;

import java.util.Date;

/**
 * @author xiaobinghe
 */


public interface MachineInfoEnergyManagerContract {
    interface View extends BaseView {
        void initData();

        long getMotorId();

        void initTimeTypeAndValue(String type, Date[] startAndEnd);

        void fillBaseData(MotorEfficiencyBaseEntity.DataBean data);

        Fragment[] getChildFragments();

        String getTimeType();
    }

    interface Model extends BaseModel {
        Fragment[] getFragments();
    }

    abstract class Presenter extends BasePresenter<Model, View> {

        public abstract void notifyChild();

        public abstract void setTimeRange(long timeInMillis, long time);
    }
}
