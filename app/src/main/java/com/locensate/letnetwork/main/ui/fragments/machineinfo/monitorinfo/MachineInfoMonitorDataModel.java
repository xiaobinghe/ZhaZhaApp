package com.locensate.letnetwork.main.ui.fragments.machineinfo.monitorinfo;

import android.text.TextUtils;

import com.locensate.letnetwork.bean.BaseSubEquipment;
import com.locensate.letnetwork.bean.EquipmentsEntity;
import com.locensate.letnetwork.bean.TestBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

/**
 * @author xiaobinghe
 */

public class MachineInfoMonitorDataModel implements MachineInfoMonitorDataContract.Model {

//
//    @Override
//    public List<MonitoringData> getMonitorData() {
//        ArrayList<MonitoringData> entities = new ArrayList<>();
//        entities.add(new MonitoringData(true, "SGY电机智能优化控制器", false, true));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "运行状态", "运行", false)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "电源电压", "380V", false)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "输出电压", "320V", false)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "输入电流A相", "55A", false)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "输入电流B相", "55A", false)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "输入电流C相", "55A", false)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "输出电流", "55A", false)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "输出频率", "50Hz", false)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "模拟热容量", "12%", false)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "节能水平", "20%", false)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "无功功率", "5Kvar", false)));
//
//        entities.add(new MonitoringData(true, "YD2060温度监测", true, false));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "电源电压", "380V", true)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "输出电压", "320V", true)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "输入电流A相", "55A", true)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "输入电流B相", "55A", true)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "输入电流C相", "55A", true)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "输出电流", "55A", true)));
//
//        entities.add(new MonitoringData(true, "电机统计数据", false, false));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "轴功率", "16kw", false)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "近5分钟电子过热Q5", "30%", false)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "近30分钟电子过热Q30", "50%", false)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "实时负载率", "0.85", false)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "总运行时间", "5850h", false)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "总运行耗电量", "110000kWh", false)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "总启动次数", "158次", false)));
//       /* entities.add(new MonitoringData(new RunningStateEntity(0, "变频器温度", "45度",false)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "变频器热状态", "10%",false)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "总运行时间", "1.5万小时",false)));
//        entities.add(new MonitoringData(new RunningStateEntity(0, "总停止时间", "0.5万小时",false)));*/
//        return entities;
//    }

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

    @Override
    public List<MonitoringData> handleData(long motorId, TestBean.DataBean data) {
        ArrayList<MonitoringData> entities = new ArrayList<>();
        List<TestBean.DataBean.ElectricMotorDataListBean> electricMotorDataList = data.getElectricMotorDataList();
        TestBean.DataBean.ElectricInstrumentLastDataBean electricInstrumentLastData = data.getElectricInstrumentLastData();
        TestBean.DataBean.MonitorInstrumentLastDataBean monitorInstrumentLastData = data.getMonitorInstrumentLastData();
        TestBean.DataBean.ControlEquipmentLastDataBean controlEquipmentLastDataBean = data.getControlEquipmentLastData();
        TestBean.DataBean.SmartSwitchLastDataBean smartSwitchLastData = data.getSmartSwitchLastData();
        TestBean.DataBean.FilterEquipmentLastDataBean filterEquipmentLastData = data.getFilterEquipmentLastData();
        if (null != electricInstrumentLastData) {
            TestBean.DataBean.ElectricInstrumentLastDataBean.EquipmentInfoBeanXXX equipmentInfo = electricInstrumentLastData.getEquipmentInfo();
            if (!TextUtils.isEmpty(equipmentInfo.getSn())) {
                List<TestBean.DataBean.ElectricInstrumentLastDataBean.DataListBeanXXX> dataList = electricInstrumentLastData.getDataList();
                entities.add(new MonitoringData(true, equipmentInfo.getMonitorEquipmentName(), equipmentInfo.getSeriesName(), false, false));
                for (int i = 0; i < dataList.size(); i++) {
                    TestBean.DataBean.ElectricInstrumentLastDataBean.DataListBeanXXX dataListBean = dataList.get(i);
                    entities.add(new MonitoringData(new RunningStateEntity(motorId, dataListBean.getName(), equipmentInfo.getMonitorEquipmentName(), dataListBean.getDesc(), dataListBean.getValue(), dataListBean.getUnit(), false)));
                }
            }
        }

        if (null != monitorInstrumentLastData) {
            TestBean.DataBean.MonitorInstrumentLastDataBean.EquipmentInfoBeanXX info = monitorInstrumentLastData.getEquipmentInfo();
            if (!TextUtils.isEmpty(info.getSn())) {

                List<TestBean.DataBean.MonitorInstrumentLastDataBean.DataListBeanXX> beans = monitorInstrumentLastData.getDataList();
                entities.add(new MonitoringData(true, info.getMonitorEquipmentName(), info.getSeriesName(), false, false));
                for (int i = 0; i < beans.size(); i++) {
                    TestBean.DataBean.MonitorInstrumentLastDataBean.DataListBeanXX listBean = beans.get(i);
                    entities.add(new MonitoringData(new RunningStateEntity(motorId, listBean.getName(), info.getMonitorEquipmentName(), listBean.getDesc(), listBean.getValue(), listBean.getUnit(), false)));
                }
            }
        }

        if (null != controlEquipmentLastDataBean) {
            TestBean.DataBean.ControlEquipmentLastDataBean.EquipmentInfoBean infoBean = controlEquipmentLastDataBean.getEquipmentInfo();
            if (!TextUtils.isEmpty(infoBean.getSn())) {
                List<TestBean.DataBean.ControlEquipmentLastDataBean.DataListBean> dataList = controlEquipmentLastDataBean.getDataList();
                entities.add(new MonitoringData(true, infoBean.getEquipmentTypeName(), infoBean.getSeriesName(), false, false));
                for (int i = 0; i < dataList.size(); i++) {
                    TestBean.DataBean.ControlEquipmentLastDataBean.DataListBean dataListBean = dataList.get(i);
                    entities.add(new MonitoringData(new RunningStateEntity(motorId, dataListBean.getName(), infoBean.getEquipmentTypeName(), dataListBean.getDesc(), dataListBean.getValue(), dataListBean.getUnit(), false)));
                }
            }
        }

        if (null != smartSwitchLastData) {
            TestBean.DataBean.SmartSwitchLastDataBean.EquipmentInfoBeanX smartSwitchInfo = smartSwitchLastData.getEquipmentInfo();
            if (!TextUtils.isEmpty(smartSwitchInfo.getSn())) {
                List<TestBean.DataBean.SmartSwitchLastDataBean.DataListBeanX> smartList = smartSwitchLastData.getDataList();
                entities.add(new MonitoringData(true, smartSwitchInfo.getEquipmentTypeName(), smartSwitchInfo.getSeriesName(), false, false));
                for (int i = 0; i < smartList.size(); i++) {
                    TestBean.DataBean.SmartSwitchLastDataBean.DataListBeanX smart = smartList.get(i);
                    entities.add(new MonitoringData(new RunningStateEntity(motorId, smart.getName(), smartSwitchInfo.getEquipmentTypeName(), smart.getDesc(), smart.getValue(), smart.getUnit(), false)));
                }
            }
        }
        if (null != filterEquipmentLastData) {
            TestBean.DataBean.FilterEquipmentLastDataBean.EquipmentInfoBeanXXXX filterDataInfo = filterEquipmentLastData.getEquipmentInfo();
            List<TestBean.DataBean.FilterEquipmentLastDataBean.DataListBeanXXXX> filterDataList = filterEquipmentLastData.getDataList();
            if (!TextUtils.isEmpty(filterDataInfo.getSn())) {
                entities.add(new MonitoringData(true, filterDataInfo.getEquipmentTypeName(), filterDataInfo.getSeriesName(), false, false));
                for (int i = 0; i < filterDataList.size(); i++) {
                    TestBean.DataBean.FilterEquipmentLastDataBean.DataListBeanXXXX filter = filterDataList.get(i);
                    entities.add(new MonitoringData(new RunningStateEntity(motorId, filter.getName(), filterDataInfo.getEquipmentTypeName(), filter.getDesc(), filter.getValue(), filter.getUnit(), false)));
                }
            }
        }

        if (null != electricMotorDataList) {
            entities.add(new MonitoringData(true, "", "电机统计数据", false, false));
            for (int i = 0; i < electricMotorDataList.size(); i++) {
                TestBean.DataBean.ElectricMotorDataListBean bean = electricMotorDataList.get(i);
                entities.add(new MonitoringData(new RunningStateEntity(motorId, bean.getName(), "电机统计数据", bean.getDesc(), bean.getValue(), bean.getUnit(), false)));
            }
        }

        return entities;
    }
}
