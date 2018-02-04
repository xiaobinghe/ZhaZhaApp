package com.locensate.letnetwork.main.ui.dataanalysis;

import com.github.mikephil.charting.data.Entry;
import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;
import com.locensate.letnetwork.bean.MonitorEquipmentHistoryData;

import java.util.Date;
import java.util.List;

import io.reactivex.Observable;


/**
 * @author xiaobinghe
 */

public interface DataAnalysisContract {

    interface View extends BaseView {


        void initData();

        void fillChartData(List<Entry> data);
    }

    interface Model extends BaseModel {

        /**
         * mock数据
         *
         * @return
         */
        List<Entry> getData();

        /**
         * 获取历史数据
         *
         * @param monitorEquipmentId
         * @param rangeType
         * @param tagName
         * @param startTime
         * @param endTime
         * @return
         */
        Observable<MonitorEquipmentHistoryData> getOriginData(long monitorEquipmentId, String rangeType, String tagName, long startTime, long endTime);

        /**
         * 获取起始时间
         *
         * @return
         */
        long getStartTime();

    }

    abstract class Presenter extends BasePresenter<Model, View> {

        /**
         * 刷新数据
         *
         * @param id
         * @param rangeType
         * @param tagName
         * @param startDate
         */
        abstract void setUp(long id, String rangeType, String tagName, Date startDate);
    }
}
