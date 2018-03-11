package com.locensate.letnetwork.main.ui.fragments.machineinfo.healthmanager;

import android.os.Bundle;

import com.github.mikephil.charting.data.PieEntry;
import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;
import com.locensate.letnetwork.bean.MachineInfoHealthyManagerEntity;

import java.util.ArrayList;
import java.util.Date;


/**
 * 设备-健康管理
 *
 * @author xiaobinghe
 */


public interface MachineInfoHealthyManagerContract {
    interface View extends BaseView {

        void fillData(MachineInfoHealthyManagerEntity.DataBean data, ArrayList<PieEntry> pieTempData, ArrayList<PieEntry> pieSharkData, ArrayList<PieEntry> pieElectHotterQ5, ArrayList<PieEntry> pieElectHotterQ30, ArrayList<PieEntry> pieStartCount, ArrayList<PieEntry> pieCurrentOver);

        void initTimeTypeAndValue(String timeType, Date[] startAndEnd);

        Bundle getMachineInfo();
    }

    interface Model extends BaseModel {
        /**
         * 获取填充数据
         *
         * @return 数据List
         */
        ArrayList<PieEntry> getPieTempData();

        ArrayList<PieEntry> getPieSharkData();

        ArrayList<PieEntry> getPieElectHotterData();

        ArrayList<PieEntry> getPieStartCountData();

        ArrayList<PieEntry> getPieCurrentOverData();

        ArrayList<PieEntry> getPieElectHotter30Data();
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        abstract void initData();
    }

}
