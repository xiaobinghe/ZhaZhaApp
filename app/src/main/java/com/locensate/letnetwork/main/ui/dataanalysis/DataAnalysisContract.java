package com.locensate.letnetwork.main.ui.dataanalysis;

import com.github.mikephil.charting.data.Entry;
import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;

import java.util.List;


/**
 *
 * @author xiaobinghe
 */

public interface DataAnalysisContract {

    interface View extends BaseView {

        void initData(List<Entry> data);
    }
    interface Model extends BaseModel{

        List<Entry> getData();
    }

    abstract class Presenter extends BasePresenter<Model,View>{

    }
}
