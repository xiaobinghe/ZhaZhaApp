package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyefficiency;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;

import java.util.ArrayList;
import java.util.List;


/**
 *  
 * @author xiaobinghe
 */


public interface EnergyEfficiencyContract {

    interface View extends BaseView {
        void setPieData(ArrayList<PieEntry> pieData);

        void setLineData(List<List<Entry>> lineData, String[] lineLabels);
    }

    interface Model extends BaseModel {
       ArrayList<PieEntry> getPieData();

        List<List<Entry>> getLineData();

        String[] getLineLabels();
    }

    abstract class Presenter extends BasePresenter<Model, View> {

    }
}
