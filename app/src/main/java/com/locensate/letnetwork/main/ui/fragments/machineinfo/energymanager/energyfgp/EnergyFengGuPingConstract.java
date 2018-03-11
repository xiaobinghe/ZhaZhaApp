package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyfgp;

import com.github.mikephil.charting.data.PieEntry;
import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;

import java.util.ArrayList;


/**
 * @author xiaobinghe
 */

public interface EnergyFengGuPingConstract {
    interface View extends BaseView {
         void setPieData(ArrayList<PieEntry> entries);
    }

    interface Model extends BaseModel {
        ArrayList<PieEntry> getPieMockData();

    }

    abstract class Presenter extends BasePresenter<Model, View> {

    }

}
