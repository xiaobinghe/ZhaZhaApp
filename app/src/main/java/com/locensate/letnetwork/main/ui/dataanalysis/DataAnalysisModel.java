package com.locensate.letnetwork.main.ui.dataanalysis;

import com.github.mikephil.charting.data.Entry;
import com.locensate.letnetwork.api.Api;
import com.locensate.letnetwork.bean.MonitorEquipmentHistoryData;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * @author xiaobinghe
 */

public class DataAnalysisModel implements DataAnalysisContract.Model {

    private long startTime;

    @Override
    public List<Entry> getData() {

        ArrayList<Entry> entries = new ArrayList<>();

        for (int i = 0; i < 300; i++) {
            entries.add(new Entry(i, (int) (Math.random() * 65) + 40));
        }
        return entries;
    }

    @Override
    public Observable<MonitorEquipmentHistoryData> getOriginData(long monitorEquipmentId, String rangeType, String tagName,long sTime, long endTime) {
//        startTime = 1517319601000L;
        startTime = sTime;
        return Api.getInstance().service.getMonitorEquipmentHistoryData(monitorEquipmentId,tagName , rangeType, startTime, endTime);
    }

    @Override
    public long getStartTime() {
        return startTime;
    }


}
