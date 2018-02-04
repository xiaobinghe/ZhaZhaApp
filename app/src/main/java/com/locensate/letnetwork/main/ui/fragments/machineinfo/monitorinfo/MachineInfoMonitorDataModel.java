package com.locensate.letnetwork.main.ui.fragments.machineinfo.monitorinfo;

import com.locensate.letnetwork.bean.BaseSubEquipment;
import com.locensate.letnetwork.bean.EquipmentsEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

/**
 * @author xiaobinghe
 */

public class MachineInfoMonitorDataModel implements MachineInfoMonitorDataContract.Model {


    @Override
    public List<MonitoringData> getMonitorData() {
        ArrayList<MonitoringData> entities = new ArrayList<>();
        entities.add(new MonitoringData(true, "SGY电机智能优化控制器", false, true));
        entities.add(new MonitoringData(new RunningStateEntity("0", "运行状态", "运行", false)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "电源电压", "380V", false)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "输出电压", "320V", false)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "输入电流A相", "55A", false)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "输入电流B相", "55A", false)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "输入电流C相", "55A", false)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "输出电流", "55A", false)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "输出频率", "50Hz", false)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "模拟热容量", "12%", false)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "节能水平", "20%", false)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "无功功率", "5Kvar", false)));

        entities.add(new MonitoringData(true, "YD2060温度监测", true, false));
        entities.add(new MonitoringData(new RunningStateEntity("0", "电源电压", "380V", true)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "输出电压", "320V", true)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "输入电流A相", "55A", true)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "输入电流B相", "55A", true)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "输入电流C相", "55A", true)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "输出电流", "55A", true)));

        entities.add(new MonitoringData(true, "电机统计数据", false, false));
        entities.add(new MonitoringData(new RunningStateEntity("0", "轴功率", "16kw", false)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "近5分钟电子过热Q5", "30%", false)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "近30分钟电子过热Q30", "50%", false)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "实时负载率", "0.85", false)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "总运行时间", "5850h", false)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "总运行耗电量", "110000kWh", false)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "总启动次数", "158次", false)));
       /* entities.add(new MonitoringData(new RunningStateEntity("0", "变频器温度", "45度",false)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "变频器热状态", "10%",false)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "总运行时间", "1.5万小时",false)));
        entities.add(new MonitoringData(new RunningStateEntity("0", "总停止时间", "0.5万小时",false)));*/
        return entities;
    }

    @Override
    public Observable<EquipmentsEntity> getEquipments() {
        return null;
    }

    @Override
    public ObservableSource<BaseSubEquipment> getMonitorLatestData(long id) {
        return null;
    }

    @Override
    public ObservableSource<BaseSubEquipment> getControlLatestData(long id) {
        return null;
    }

    @Override
    public ObservableSource<BaseSubEquipment> getFilterCompensationLatestData(long id) {
        return null;
    }
}
