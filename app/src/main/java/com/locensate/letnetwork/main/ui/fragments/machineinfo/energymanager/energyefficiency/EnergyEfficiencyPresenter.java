package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyefficiency;


import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.api.Api;
import com.locensate.letnetwork.base.RxSchedulers;
import com.locensate.letnetwork.bean.MonitorEquipmentHistoryData;
import com.locensate.letnetwork.bean.MotorEfficiencyData;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * @author xiaobinghe
 */


public class EnergyEfficiencyPresenter extends EnergyEfficiencyContract.Presenter {

    private double mDefaultEfficiency = 0;
    private List<Entry> set0;
    private long mSumTime;
    private long starMills;

    @Override
    public void onStart() {
        if (App.isMock) {
            mView.setPieData(mModel.getPieData());
            mView.setLineData(mModel.getLineData(), mModel.getLineLabels());
        }
//        mView.setLineData(mModel.getLineData(), mModel.getLineLabels());
        mView.pullRequest();
    }

    @Override
    public void requestData(long motorId, long startMills, long endMills) {
        requestEfficiency(motorId, startMills, endMills);
    }


    @Override
    public void requestHistory(long motorId, String tagName, long startTime, long endTime, String aggregator, String samplingValue, String interpolation) {
        this.starMills = startTime;
        Api.getInstance().service.getMonitorEquipmentHistoryData(motorId, tagName, startTime, endTime, aggregator, samplingValue, interpolation).compose(RxSchedulers.<MonitorEquipmentHistoryData>applyObservableAsync()).map(new Function<MonitorEquipmentHistoryData, List<Entry>>() {

            @Override
            public List<Entry> apply(MonitorEquipmentHistoryData monitorEquipmentHistoryData) throws Exception {
                LogUtil.e("MonitorEquipmentEntity", "--------------------" + monitorEquipmentHistoryData.toString());
                List<Entry> entries = new ArrayList<>();
                List<MonitorEquipmentHistoryData.DataBean> data = monitorEquipmentHistoryData.getData();
                for (int i = 0; i < data.size(); i++) {
                    MonitorEquipmentHistoryData.DataBean dataBean = data.get(i);
                    entries.add(new Entry((dataBean.getTime() - starMills) / 1000, (float) dataBean.getValue()));
                    LogUtil.e("shabile ", "---------------dataBean-----" + dataBean.getTime() + "==Y" + dataBean.getValue());
                }
                return entries;
            }
        }).subscribe(new Consumer<List<Entry>>() {
            @Override
            public void accept(List<Entry> entries) throws Exception {
                LogUtil.e("MonitorEquipmentEntity", "--------------------" + entries.get(0).getY() + "---" + entries.get(0).getX());
                set0 = entries;
                handleData();
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                ToastUtil.show(App.getApplication().getString(R.string.load_fail_retry));
            }
        });
    }

    @Override
    public double getDefaultE() {
        return mDefaultEfficiency;
    }

    private void handleData() {
        if (set0 == null || set0.size() == 0 || mDefaultEfficiency == 0) {
            return;
        }

        LogUtil.e("mDefaultEfficiency","---------"+mDefaultEfficiency);
        int size = set0.size();
        ArrayList<Entry> set1 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            set1.add(new Entry(set0.get(i).getX(), (float) mDefaultEfficiency));
        }


        ArrayList<Entry> set2 = new ArrayList<>();
        float value2 = (float) (1.25 * mDefaultEfficiency - 0.25f);
        for (int i = 0; i < size; i++) {
            set2.add(new Entry(set0.get(i).getX(), value2));
        }


        List<List<Entry>> lists = new ArrayList<>();
        lists.add(set0);
        lists.add(set2);
        lists.add(set1);
        mView.setLineData(lists, mModel.getLineLabels());
    }

    private void requestEfficiency(long motorId, long startMills, long endMills) {
        mSumTime = endMills - startMills;
        Api.getInstance().service.getMotorEfficiencyData(motorId, startMills, endMills).compose(RxSchedulers.<MotorEfficiencyData>applyObservableAsync()).subscribe(new Consumer<MotorEfficiencyData>() {
            @Override
            public void accept(MotorEfficiencyData motorEfficiencyData) throws Exception {
                MotorEfficiencyData.DataBean data = motorEfficiencyData.getData();
                dispatchData(data);
            }
        });
    }

    private void dispatchData(MotorEfficiencyData.DataBean data) {
        mDefaultEfficiency = data.getDefault_efficiency();
        long sumMills = mSumTime / 1000;
        handleData();
        long diseconomic_running_time = data.getDiseconomic_running_time();
        long economic_running_time = data.getEconomic_running_time();
        long easonable_running_time = data.getEasonable_running_time();
        long stop_time = sumMills - diseconomic_running_time - economic_running_time - easonable_running_time;
        if (stop_time < 1) {
            stop_time = 0;
        }
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        LogUtil.e("sumTime", "-----" + sumMills);
        if (0 != sumMills) {
            pieEntries.add(new PieEntry(economic_running_time / (float) sumMills));
            pieEntries.add(new PieEntry(easonable_running_time / (float) sumMills));
            pieEntries.add(new PieEntry(diseconomic_running_time / (float) sumMills));
            pieEntries.add(new PieEntry(stop_time / (float) sumMills));
        }
        mView.setPieData(pieEntries);
        mView.setPieDesData(data, sumMills);
    }
}
