package com.locensate.letnetwork.main.ui.fragments.overview.rateanalysis;

import com.github.mikephil.charting.data.PieEntry;
import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;

import java.util.ArrayList;

/**
 *
 * @author xiaobinghe
 */


public interface OverviewRateAnalysisContract {
    interface View extends BaseView{
        void fillData(ArrayList<PieEntry> pieEntries);

    }

    interface Model extends BaseModel{
        ArrayList<PieEntry> initData();
    }

    abstract class Presenter extends BasePresenter<Model,View>{

    }

}
