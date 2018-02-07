package com.locensate.letnetwork.main.ui.fragments.machineinfo.healthmanager;

import com.github.mikephil.charting.data.PieEntry;
import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;

import java.util.ArrayList;


/**
 * 设备-健康管理
 *
 * @author xiaobinghe
 */


public interface MachineInfoHealthyManagerContract {
    interface View extends BaseView {
        /**
         * 填充数据
         *
         * @param pieTempData
         * @param pieSharkData
         * @param pie1Data
         * @param pie2Data
         * @param pieEntries
         */
        void fillData(ArrayList<PieEntry> pieTempData, ArrayList<PieEntry> pieSharkData, ArrayList<PieEntry> pie1Data, ArrayList<PieEntry> pie2Data, ArrayList<PieEntry> pieEntries);
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
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        abstract void initData();
    }

}
