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
        void setData(ArrayList<PieEntry> pieEntries);

        int getOrganizationId();

        long getStartMills();

        long getEndMills();

        void setNumData(String[] counts, String[] powerRates, String[] countRate);

        void setNoData();
    }

    interface Model extends BaseModel{
        ArrayList<PieEntry> initMockData();
    }

    abstract class Presenter extends BasePresenter<Model,View>{

        public abstract void requestData(int organizationId, long startMills, long endMills);

    }

}
