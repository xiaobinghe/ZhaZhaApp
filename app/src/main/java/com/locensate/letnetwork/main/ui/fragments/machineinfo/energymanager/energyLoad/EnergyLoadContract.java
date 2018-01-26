package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyLoad;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;

import java.util.ArrayList;


/**
 *
 * @author xiaobinghe
 */

public interface EnergyLoadContract {

    interface View extends BaseView {
        void setBarData(ArrayList<BarEntry> barData);

        void setPieData(ArrayList<PieEntry> pieData);


        void setLineData(ArrayList<Entry> lineData, String[] dataLabels);
    }

    interface Model extends BaseModel {

        ArrayList<BarEntry> getBarData();

        ArrayList<PieEntry> getPieData();

        ArrayList<Entry> getLineData();

        String[] getDataLabels();
    }

    abstract class Presenter extends BasePresenter<Model, View> {

    }

}
