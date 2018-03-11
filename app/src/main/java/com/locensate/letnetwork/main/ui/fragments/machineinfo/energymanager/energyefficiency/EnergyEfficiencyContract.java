package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyefficiency;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;
import com.locensate.letnetwork.bean.MotorEfficiencyData;

import java.util.ArrayList;
import java.util.List;


/**
 * @author xiaobinghe
 */


public interface EnergyEfficiencyContract {

    interface View extends BaseView {
        void setPieData(ArrayList<PieEntry> pieData);

        long motorId();

        long getStartMills();

        long getEndMills();

        void setLineData(List<List<Entry>> lineData, String[] lineLabels);

        void setPieDesData(MotorEfficiencyData.DataBean data, long sumTime);

        void pullRequest();
    }

    interface Model extends BaseModel {
        ArrayList<PieEntry> getPieData();

        List<List<Entry>> getLineData();

        String[] getLineLabels();
    }

    abstract class Presenter extends BasePresenter<Model, View> {

        public abstract void requestData(long motorId, long startMills, long endMills);

        public abstract  void requestHistory(long motorId, String tagName, long startTime, long endTime, String aggregator, String samplingValue, String interpolation);

        public abstract double getDefaultE();
    }
}
