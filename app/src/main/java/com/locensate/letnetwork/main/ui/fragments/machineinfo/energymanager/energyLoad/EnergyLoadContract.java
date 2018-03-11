package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyLoad;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;
import com.locensate.letnetwork.bean.MotorEfficiencyLoadEntity;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author xiaobinghe
 */

public interface EnergyLoadContract {

    interface View extends BaseView {
        void setBarData(ArrayList<BarEntry> barData);

        void setPieData(ArrayList<PieEntry> pieData);


        void setLineData(List<Entry> lineData, String[] dataLabels);

        void setLoadRate(MotorEfficiencyLoadEntity.DataBean data, long sumTime, String average_loading, String current_loading);

        void pullRequest();
    }

    interface Model extends BaseModel {

        ArrayList<BarEntry> getBarData();

        ArrayList<PieEntry> getPieData();

        ArrayList<Entry> getLineData();

        String[] getDataLabels();
    }

    abstract class Presenter extends BasePresenter<Model, View> {

        public abstract void requestData(long motorId, long startMills, long endMills);

        public abstract void requestHistory(long motorId, String beta, long startMills, long endMills, String agg, String sampling, String interpolation);
    }

}
