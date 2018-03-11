package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyLoad;


import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.api.Api;
import com.locensate.letnetwork.base.RxSchedulers;
import com.locensate.letnetwork.bean.MonitorEquipmentHistoryData;
import com.locensate.letnetwork.bean.MotorEfficiencyLoadEntity;
import com.locensate.letnetwork.bean.MotorEfficiencyLoadPercentEntity;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.ToastUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * @author xiaobinghe
 */

public class EnergyLoadPresenter extends EnergyLoadContract.Presenter {

    private long mSumMills;
    private long mStartMills;

    @Override
    public void onStart() {
        if (App.isMock) {
            mView.setBarData(mModel.getBarData());
            mView.setPieData(mModel.getPieData());
            mView.setLineData(mModel.getLineData(), mModel.getDataLabels());
        }
//        mView.setLineData(mModel.getLineData(), mModel.getDataLabels());
        mView.pullRequest();
    }

    @Override
    public void requestData(long motorId, long startMills, long endMills) {
        requestLoad(motorId, startMills, endMills);
        requestLoadPercent(motorId, startMills, endMills);
    }

    @Override
    public void requestHistory(long motorId, String beta, long startMills, long endMills, String agg, String sampling, String interpolation) {
        mStartMills = startMills;
        Api.getInstance().service.getMonitorEquipmentHistoryData(motorId, beta, startMills, endMills, agg, sampling, interpolation).compose(RxSchedulers.<MonitorEquipmentHistoryData>applyObservableAsync()).subscribe(new Consumer<MonitorEquipmentHistoryData>() {
            @Override
            public void accept(MonitorEquipmentHistoryData monitorEquipmentHistoryData) throws Exception {
                List<Entry> entries = new ArrayList<>();
                List<MonitorEquipmentHistoryData.DataBean> data = monitorEquipmentHistoryData.getData();
                if (null != data) {
                    for (int i = 0; i < data.size(); i++) {
                        MonitorEquipmentHistoryData.DataBean dataBean = data.get(i);
//                        LogUtil.e("shabile ", "---------------dataBean-----" + dataBean.getTime() + "==" + mStartMills);
                        entries.add(new Entry((dataBean.getTime() - mStartMills), (float) dataBean.getValue()));
                    }
                }
                mView.setLineData(entries, mModel.getDataLabels());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                ToastUtil.show(App.getApplication().getString(R.string.load_fail_retry) + "loadHistory");
            }
        });
    }

    private void requestLoadPercent(long motorId, long startMills, long endMills) {
        LogUtil.e("requestLoadPercent", "------------motorId=" + motorId);
        Api.getInstance().service.getMotorEfficiencyLoadPercentData(motorId, startMills, endMills).compose(RxSchedulers.<MotorEfficiencyLoadPercentEntity>applyObservableAsync()).subscribe(new Consumer<MotorEfficiencyLoadPercentEntity>() {
            @Override
            public void accept(MotorEfficiencyLoadPercentEntity motorEfficiencyLoadPercentEntity) throws Exception {
                MotorEfficiencyLoadPercentEntity.DataBean data = motorEfficiencyLoadPercentEntity.getData();
                LogUtil.e("MotorEfficiencyPercentData", "---------" + data.toString() + "-----------dataT151=" + data.getT151());
                handleLoadPercentData(data);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                LogUtil.e("Throwable", "----" + throwable.toString());
                ToastUtil.show(R.string.data_load_fail + "loadPercent");

            }
        });
    }

    private void requestLoad(long motorId, long startMills, long endMills) {
        mSumMills = endMills - startMills;
        Api.getInstance().service.getMotorEfficiencyLoadData(motorId, startMills, endMills).compose(RxSchedulers.<MotorEfficiencyLoadEntity>applyObservableAsync()).subscribe(new Consumer<MotorEfficiencyLoadEntity>() {
            @Override
            public void accept(MotorEfficiencyLoadEntity motorEfficiencyLoadEntity) throws Exception {
                MotorEfficiencyLoadEntity.DataBean data = motorEfficiencyLoadEntity.getData();
                handleData(data);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                LogUtil.e("Throwable", "----" + throwable.toString());
                ToastUtil.show(R.string.data_load_fail + "loadPie");
            }
        });
    }

    private void handleLoadPercentData(MotorEfficiencyLoadPercentEntity.DataBean data) {
        int t5 = data.getT5();
        int t10 = data.getT10();
        int t15 = data.getT15();
        int t20 = data.getT20();
        int t25 = data.getT25();
        int t30 = data.getT30();
        int t35 = data.getT35();
        int t40 = data.getT40();
        int t45 = data.getT45();
        int t50 = data.getT50();
        int t55 = data.getT55();
        int t60 = data.getT60();
        int t65 = data.getT65();
        int t70 = data.getT70();
        int t75 = data.getT75();
        int t80 = data.getT80();
        int t85 = data.getT85();
        int t90 = data.getT90();
        int t95 = data.getT95();
        int t100 = data.getT100();
        int t110 = data.getT110();
        int t120 = data.getT120();
        int t150 = data.getT150();
        int t151 = data.getT151();
        ArrayList<BarEntry> barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(1f, (t5 + t10) / (float) 3600));
        barEntries.add(new BarEntry(2f, (t15 + t20) / (float) 3600));
        barEntries.add(new BarEntry(3f, (t25 + t30) / (float) 3600));
        barEntries.add(new BarEntry(4f, (t35 + t40) / (float) 3600));
        barEntries.add(new BarEntry(5f, (t45 + t50) / (float) 3600));
        barEntries.add(new BarEntry(6f, (t55 + t60) / (float) 3600));
        barEntries.add(new BarEntry(7f, (t65 + t70) / (float) 3600));
        barEntries.add(new BarEntry(8f, (t75 + t80) / (float) 3600));
        barEntries.add(new BarEntry(9f, (t85 + t90) / (float) 3600));
        barEntries.add(new BarEntry(10f, (t95 + t100) / (float) 3600));
        barEntries.add(new BarEntry(11f, (t110) / (float) 3600));
        barEntries.add(new BarEntry(12f, (t120) / (float) 3600));
        barEntries.add(new BarEntry(13f, (t150 + t151) / (float) 3600));
        mView.setBarData(barEntries);
    }

    private void handleData(MotorEfficiencyLoadEntity.DataBean data) {
        long sumSecond = mSumMills / 1000;

        double average_loading = data.getAverage_loading();
        double current_loading = data.getCurrent_loading();
        long half_load_time = data.getHalf_load_time();
        long heavy_loading_time = data.getHeavy_loading_time();
        long light_loading_time = data.getLight_loading_time();
        long no_loading_time = data.getNo_loading_time();
        long over_loading_time = data.getOver_loading_time();
        long stop_time = sumSecond - half_load_time - light_loading_time - no_loading_time - heavy_loading_time - over_loading_time;
        if (stop_time < 1) {
            stop_time = 0;
        }
        LogUtil.e("handleData", "----sumsecond=" + sumSecond + "-----stoptime=" + stop_time);

//        long sumTime = half_load_time + light_loading_time + heavy_loading_time + over_loading_time + stop_time + no_loading_time;
        DecimalFormat df = new DecimalFormat("0.00");
        if (sumSecond != 0) {
            ArrayList<PieEntry> pieEntries = new ArrayList<>();
            pieEntries.add(new PieEntry(no_loading_time / (float) sumSecond, "空载"));
            pieEntries.add(new PieEntry(light_loading_time / (float) sumSecond, "轻载"));
            pieEntries.add(new PieEntry(half_load_time / (float) sumSecond, "半载"));
            pieEntries.add(new PieEntry(heavy_loading_time / (float) sumSecond, "重载"));
            pieEntries.add(new PieEntry(over_loading_time / (float) sumSecond, "过载"));
            pieEntries.add(new PieEntry(stop_time / (float) sumSecond, "停止"));
            mView.setPieData(pieEntries);
        } else {
            mView.setPieData(null);
        }
        mView.setLoadRate(data, sumSecond, df.format(average_loading), df.format(current_loading));
    }
}
