package com.locensate.letnetwork.main.ui.fragments.machineinfo.healthmanager;


import com.github.mikephil.charting.data.PieEntry;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.api.Api;
import com.locensate.letnetwork.base.RxSchedulers;
import com.locensate.letnetwork.bean.MachineInfoHealthyManagerEntity;
import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.ToastUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import io.reactivex.functions.Consumer;

/**
 * 设备-健康管理
 *
 * @author xiaobinghe
 */

public class MachineInfoHealthyManagerPresenter extends MachineInfoHealthyManagerContract.Presenter {
    private long startMills;
    private long endMills;

    @Override
    public void onStart() {
        Date date = new Date();
        Date[] startAndEnd = DateUtils.getFirstAndEndDayDateOfWeek(date);
        startMills = startAndEnd[0].getTime();
        endMills = startAndEnd[1].getTime();
//        fillMonitorOverviewData(organizationId);
        mView.initTimeTypeAndValue("周", startAndEnd);
        initData();
    }

    private void handleData(MachineInfoHealthyManagerEntity.DataBean data) {
        double io_max = data.getIo_max();
        long io_max_time = data.getIo_max_time();
        double si = data.getSi();
        int max_start = data.getMax_start();
        long max_start_time = data.getMax_start_time();
        double sst = data.getSst();
        double q5_max = data.getQ5_max();
        long q5_max_time = data.getQ5_max_time();
        double sq5 = data.getSq5();
        double q30_max = data.getQ30_max();
        long q30_max_time = data.getQ30_max_time();
        double sq30 = data.getSq30();
        double tem_max = data.getTem_max();
        long tem_max_time = data.getTem_max_time();
        double stem = data.getStem();
        double zd_max = data.getZd_max();
        long zd_max_time = data.getZd_max_time();
        double szd = data.getSzd();

        LogUtil.e("handleData", "-----stem=" + stem + "--szd=" + szd + "--q5=" + sq5 + "--sq30=" + sq30 + "--sst=" + sst + "--sio=" + si);
        mView.fillData(data, switchScore(tem_max_time == 0 ? 0 : stem), switchScore(zd_max_time == 0 ? 0 : szd), switchScore(q5_max_time == 0 ? 0 : sq5), switchScore(q30_max_time == 0 ? 0 : sq30), switchScore(max_start_time == 0 ? 0 : sst), switchScore(io_max_time == 0 ? 0 : si));

    }

    private ArrayList<PieEntry> switchScore(double s) {
        DecimalFormat df = new DecimalFormat("0.0");
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(Float.valueOf(df.format(s * 100))));
        entries.add(new PieEntry(Float.valueOf(df.format((1 - s) * 100))));
        return entries;
    }

    @Override
    public void initData() {
        if (App.isMock) {
            mView.fillData(null, mModel.getPieTempData(), mModel.getPieSharkData(), mModel.getPieElectHotterData(), mModel.getPieElectHotter30Data(), mModel.getPieStartCountData(), mModel.getPieCurrentOverData());
            return;
        }
        LogUtil.e("motorId", "---------------" + mView.getMachineInfo().getInt("machineId")
        );
        Api.getInstance().service.getMachineInfoHealthyManagerData(mView.getMachineInfo().getLong("motorId"), startMills, endMills).compose(RxSchedulers.<MachineInfoHealthyManagerEntity>applyObservableAsync()).subscribe(new Consumer<MachineInfoHealthyManagerEntity>() {
            @Override
            public void accept(MachineInfoHealthyManagerEntity machineInfoHealthyManagerEntity) throws Exception {
                MachineInfoHealthyManagerEntity.DataBean data = machineInfoHealthyManagerEntity.getData();
                handleData(data);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                ToastUtil.show(App.getApplication().getString(R.string.data_load_fail));
            }
        });
    }

    public void setTimeRange(long timeInMillis, long time) {
        if (timeInMillis == startMills && time == endMills) {
            return;
        }

        this.startMills = timeInMillis;
        this.endMills = time;
        initData();
    }

    public long getStartMills() {
        return startMills;
    }

    public long getEndMills() {
        return endMills;
    }
}
