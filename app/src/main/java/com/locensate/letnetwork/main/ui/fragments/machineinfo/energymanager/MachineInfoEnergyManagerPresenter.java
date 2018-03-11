package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager;


import android.support.v4.app.Fragment;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.api.Api;
import com.locensate.letnetwork.base.RxSchedulers;
import com.locensate.letnetwork.bean.MotorEfficiencyBaseEntity;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyLoad.EnergyLoadFragment;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyefficiency.EnergyEfficiencyFragment;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyfgp.EnergyFengGuPingFragment;
import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.ToastUtil;

import java.util.Date;

import io.reactivex.functions.Consumer;

/**
 * @author xiaobinghe
 */

public class MachineInfoEnergyManagerPresenter extends MachineInfoEnergyManagerContract.Presenter {
    private long startMills;
    private long endMills;
    private long mMotorId;

    @Override
    public void onStart() {
        mView.initData();
        Date date = new Date();
        Date[] startAndEnd = DateUtils.getFirstAndEndDayDateOfWeek(date);
        startMills = startAndEnd[0].getTime();
        endMills = System.currentTimeMillis();
//        fillMonitorOverviewData(organizationId);
        mView.initTimeTypeAndValue("周", startAndEnd);
        mMotorId = mView.getMotorId();
        notifyChild();
    }

    private void baseData() {
        Api.getInstance().service.getEfficiencyBaseData(mMotorId, startMills, endMills).compose(RxSchedulers.<MotorEfficiencyBaseEntity>applyObservableAsync()).subscribe(new Consumer<MotorEfficiencyBaseEntity>() {
            @Override
            public void accept(MotorEfficiencyBaseEntity motorEfficiencyBaseEntity) throws Exception {
                LogUtil.e("motorEfficiencyData", "---" + motorEfficiencyBaseEntity.toString());
                MotorEfficiencyBaseEntity.DataBean data = motorEfficiencyBaseEntity.getData();
                if (null != data) {
                    mView.fillBaseData(data);
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                ToastUtil.show(R.string.data_load_fail);
            }
        });
    }

    @Override
    public void notifyChild() {
        baseData();
        Fragment[] childFragments = mView.getChildFragments();
        ((EnergyEfficiencyFragment) childFragments[0]).notifyData(mMotorId, startMills, endMills,mView.getTimeType());
        ((EnergyLoadFragment) childFragments[1]).notifyData(mMotorId, startMills, endMills,mView.getTimeType());
        ((EnergyFengGuPingFragment) childFragments[2]).notifyData(mMotorId, startMills, endMills,mView.getTimeType());
    }

    @Override
    public void setTimeRange(long timeInMillis, long time) {
        if (this.startMills == timeInMillis && this.endMills == time) {
            return;
        }
        this.startMills = timeInMillis;
        this.endMills = time;
        notifyChild();
    }
}
