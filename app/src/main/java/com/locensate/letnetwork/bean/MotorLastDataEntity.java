package com.locensate.letnetwork.bean;

import java.io.Serializable;
import java.util.List;


/**
 * $String
 *
 * @author xiaobinghe
 */

public class MotorLastDataEntity implements Serializable {


    /**
     * operCode : 1
     * data : {"monitorInstrumentLastData":{"dataList":[{"unit":null,"name":"MC_Zd4","value":0,"desc":"振动值4"},{"unit":null,"name":"MC_Zd5","value":0,"desc":"振动值5"},{"unit":null,"name":"MC_Zd6","value":0,"desc":"振动值6"},{"unit":null,"name":"MC_Zd7","value":0,"desc":"振动值7"},{"unit":null,"name":"MC_Zd8","value":0,"desc":"振动值8"},{"unit":null,"name":"MC_Zd1","value":0,"desc":"振动值1"},{"unit":null,"name":"MC_Zd2","value":0,"desc":"振动值2"},{"unit":null,"name":"MC_Zd3","value":0,"desc":"振动值3"}],"equipmentInfo":{"status":1,"createTime":"2018-03-06 20:26:19.0","updateTime":"2018-03-06 20:27:11.0","monitorEquipmentId":26,"monitorEquipmentName":"震动传感器","electricMotorId":13,"electricMotorName":"4b皮带机1电机","equipmentClassificationId":19,"equipmentClassificationName":"监测设备","equipmentTypeId":22,"equipmentTypeName":"震动传感器","brandId":47,"brandName":"杭江","seriesId":35,"seriesName":"HJ-9002","modelNumberId":96,"modelNumberName":"HJ-9002","gatewayDeviceId":0,"channel":"0","slave":"0","monitorEquipmentInstallationTime":"2018-03-06"}},"electricInstrumentLastData":{"dataList":[{"unit":null,"name":"MS_Pfs","value":0.857,"desc":"总功率因数"},{"unit":"V","name":"MS_Us","value":416.7,"desc":"电源电压"},{"unit":"V","name":"MS_Uab","value":416.6,"desc":"AB线电压"},{"unit":"V","name":"MS_Ubc","value":417.2,"desc":"BC线电压"},{"unit":"V","name":"MS_Uac","value":416.6,"desc":"AC线电压"},{"unit":"A","name":"IO","value":110.84,"desc":"输出电流"},{"unit":"A","name":"MS_Ia","value":110.16,"desc":"A相电流"},{"unit":"A","name":"MS_Ib","value":110.24,"desc":"B相电流"},{"unit":"A","name":"MS_Ic","value":112.16,"desc":"C相电流"},{"unit":"kW","name":"P1","value":68.8,"desc":"输出功率"},{"unit":null,"name":"MS_Pa","value":22.84,"desc":"A相有功功率"},{"unit":null,"name":"MS_Pb","value":23.16,"desc":"B相有功功率"},{"unit":null,"name":"MS_Pc","value":23.48,"desc":"C相有功功率"},{"unit":null,"name":"MS_E1","value":36170.8,"desc":"累计输入电量"},{"unit":null,"name":"MS_Q","value":41.36,"desc":"无功功率"},{"unit":null,"name":"MS_Kvarh","value":32006,"desc":"无功耗电量"},{"unit":null,"name":"DK_Ct","value":0,"desc":"互感器变比"},{"unit":null,"name":"MS_THDUa","value":0,"desc":"A相电压谐波总含量"},{"unit":null,"name":"MS_THDUb","value":0,"desc":"B相电压谐波总含量"},{"unit":null,"name":"MS_THDUc","value":0,"desc":"C相电压谐波总含量"},{"unit":null,"name":"MS_THDIa","value":0,"desc":"A相电流谐波总含量"},{"unit":null,"name":"MS_THDIb","value":0,"desc":"B相电流谐波总含量"},{"unit":null,"name":"MS_THDIc","value":0,"desc":"C相电流谐波总含量"},{"unit":null,"name":"MS_THDIa","value":0,"desc":"A相电流谐波总含量"}],"equipmentInfo":{"status":1,"createTime":"2018-01-18 11:26:25.0","updateTime":"2018-01-18 11:30:05.0","monitorEquipmentId":7,"monitorEquipmentName":"电力仪表","electricMotorId":13,"electricMotorName":"4b皮带机1电机","equipmentClassificationId":19,"equipmentClassificationName":"监测设备","equipmentTypeId":23,"equipmentTypeName":"电力仪表","brandId":35,"brandName":"安科瑞","seriesId":25,"seriesName":"AMC16-E4","modelNumberId":95,"modelNumberName":"AMC16-E4 5A","gatewayDeviceId":10,"sn":"2-26001-171218-00004","channel":"C1","slave":"B1","monitorEquipmentInstallationTime":"2018-01-18"}},"electricMotorDataList":[{"unit":null,"name":"P2","value":64.95759808148624,"desc":"轴功率"},{"unit":null,"name":"Q5","value":0.5029022013458115,"desc":"近5分钟电子过热"},{"unit":null,"name":"Q30","value":0.5526404190899638,"desc":"近30分钟电子过热"},{"unit":null,"name":"BETA","value":0.7217510897942915,"desc":"实时负载率"},{"unit":null,"name":"ETA","value":0.9441511349053233,"desc":"实时效率"},{"unit":null,"name":"totalRunTime","value":1458925,"desc":"总运行时间"},{"unit":null,"name":"totalPower","value":8894.000000000033,"desc":"总运行耗电量"},{"unit":null,"name":"totalStartTimes","value":231,"desc":"总启动次数"}]}
     */

    private int operCode;
    private DataBean data;

    public int getOperCode() {
        return operCode;
    }

    public void setOperCode(int operCode) {
        this.operCode = operCode;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * monitorInstrumentLastData : {"dataList":[{"unit":null,"name":"MC_Zd4","value":0,"desc":"振动值4"},{"unit":null,"name":"MC_Zd5","value":0,"desc":"振动值5"},{"unit":null,"name":"MC_Zd6","value":0,"desc":"振动值6"},{"unit":null,"name":"MC_Zd7","value":0,"desc":"振动值7"},{"unit":null,"name":"MC_Zd8","value":0,"desc":"振动值8"},{"unit":null,"name":"MC_Zd1","value":0,"desc":"振动值1"},{"unit":null,"name":"MC_Zd2","value":0,"desc":"振动值2"},{"unit":null,"name":"MC_Zd3","value":0,"desc":"振动值3"}],"equipmentInfo":{"status":1,"createTime":"2018-03-06 20:26:19.0","updateTime":"2018-03-06 20:27:11.0","monitorEquipmentId":26,"monitorEquipmentName":"震动传感器","electricMotorId":13,"electricMotorName":"4b皮带机1电机","equipmentClassificationId":19,"equipmentClassificationName":"监测设备","equipmentTypeId":22,"equipmentTypeName":"震动传感器","brandId":47,"brandName":"杭江","seriesId":35,"seriesName":"HJ-9002","modelNumberId":96,"modelNumberName":"HJ-9002","gatewayDeviceId":0,"channel":"0","slave":"0","monitorEquipmentInstallationTime":"2018-03-06"}}
         * electricInstrumentLastData : {"dataList":[{"unit":null,"name":"MS_Pfs","value":0.857,"desc":"总功率因数"},{"unit":"V","name":"MS_Us","value":416.7,"desc":"电源电压"},{"unit":"V","name":"MS_Uab","value":416.6,"desc":"AB线电压"},{"unit":"V","name":"MS_Ubc","value":417.2,"desc":"BC线电压"},{"unit":"V","name":"MS_Uac","value":416.6,"desc":"AC线电压"},{"unit":"A","name":"IO","value":110.84,"desc":"输出电流"},{"unit":"A","name":"MS_Ia","value":110.16,"desc":"A相电流"},{"unit":"A","name":"MS_Ib","value":110.24,"desc":"B相电流"},{"unit":"A","name":"MS_Ic","value":112.16,"desc":"C相电流"},{"unit":"kW","name":"P1","value":68.8,"desc":"输出功率"},{"unit":null,"name":"MS_Pa","value":22.84,"desc":"A相有功功率"},{"unit":null,"name":"MS_Pb","value":23.16,"desc":"B相有功功率"},{"unit":null,"name":"MS_Pc","value":23.48,"desc":"C相有功功率"},{"unit":null,"name":"MS_E1","value":36170.8,"desc":"累计输入电量"},{"unit":null,"name":"MS_Q","value":41.36,"desc":"无功功率"},{"unit":null,"name":"MS_Kvarh","value":32006,"desc":"无功耗电量"},{"unit":null,"name":"DK_Ct","value":0,"desc":"互感器变比"},{"unit":null,"name":"MS_THDUa","value":0,"desc":"A相电压谐波总含量"},{"unit":null,"name":"MS_THDUb","value":0,"desc":"B相电压谐波总含量"},{"unit":null,"name":"MS_THDUc","value":0,"desc":"C相电压谐波总含量"},{"unit":null,"name":"MS_THDIa","value":0,"desc":"A相电流谐波总含量"},{"unit":null,"name":"MS_THDIb","value":0,"desc":"B相电流谐波总含量"},{"unit":null,"name":"MS_THDIc","value":0,"desc":"C相电流谐波总含量"},{"unit":null,"name":"MS_THDIa","value":0,"desc":"A相电流谐波总含量"}],"equipmentInfo":{"status":1,"createTime":"2018-01-18 11:26:25.0","updateTime":"2018-01-18 11:30:05.0","monitorEquipmentId":7,"monitorEquipmentName":"电力仪表","electricMotorId":13,"electricMotorName":"4b皮带机1电机","equipmentClassificationId":19,"equipmentClassificationName":"监测设备","equipmentTypeId":23,"equipmentTypeName":"电力仪表","brandId":35,"brandName":"安科瑞","seriesId":25,"seriesName":"AMC16-E4","modelNumberId":95,"modelNumberName":"AMC16-E4 5A","gatewayDeviceId":10,"sn":"2-26001-171218-00004","channel":"C1","slave":"B1","monitorEquipmentInstallationTime":"2018-01-18"}}
         * electricMotorDataList : [{"unit":null,"name":"P2","value":64.95759808148624,"desc":"轴功率"},{"unit":null,"name":"Q5","value":0.5029022013458115,"desc":"近5分钟电子过热"},{"unit":null,"name":"Q30","value":0.5526404190899638,"desc":"近30分钟电子过热"},{"unit":null,"name":"BETA","value":0.7217510897942915,"desc":"实时负载率"},{"unit":null,"name":"ETA","value":0.9441511349053233,"desc":"实时效率"},{"unit":null,"name":"totalRunTime","value":1458925,"desc":"总运行时间"},{"unit":null,"name":"totalPower","value":8894.000000000033,"desc":"总运行耗电量"},{"unit":null,"name":"totalStartTimes","value":231,"desc":"总启动次数"}]
         */

        private MonitorInstrumentLastDataBean monitorInstrumentLastData;
        private ElectricInstrumentLastDataBean electricInstrumentLastData;
        private List<ElectricMotorDataListBean> electricMotorDataList;
        private ControlEquipmentLastDataBean controlEquipmentLastDataBean;
        private SmartSwitchLastDataBean smartSwitchLastData;
        private FilterEquipmentLastDataBean filterEquipmentLastData;


        public ControlEquipmentLastDataBean getControlEquipmentLastDataBean() {
            return controlEquipmentLastDataBean;
        }

        public void setControlEquipmentLastDataBean(ControlEquipmentLastDataBean controlEquipmentLastDataBean) {
            this.controlEquipmentLastDataBean = controlEquipmentLastDataBean;
        }

        public MonitorInstrumentLastDataBean getMonitorInstrumentLastData() {
            return monitorInstrumentLastData;
        }

        public void setMonitorInstrumentLastData(MonitorInstrumentLastDataBean monitorInstrumentLastData) {
            this.monitorInstrumentLastData = monitorInstrumentLastData;
        }

        public ElectricInstrumentLastDataBean getElectricInstrumentLastData() {
            return electricInstrumentLastData;
        }

        public void setElectricInstrumentLastData(ElectricInstrumentLastDataBean electricInstrumentLastData) {
            this.electricInstrumentLastData = electricInstrumentLastData;
        }

        public List<ElectricMotorDataListBean> getElectricMotorDataList() {
            return electricMotorDataList;
        }

        public void setElectricMotorDataList(List<ElectricMotorDataListBean> electricMotorDataList) {
            this.electricMotorDataList = electricMotorDataList;
        }

        public SmartSwitchLastDataBean getSmartSwitchLastData() {
            return smartSwitchLastData;
        }

        public void setSmartSwitchLastData(SmartSwitchLastDataBean smartSwitchLastData) {
            this.smartSwitchLastData = smartSwitchLastData;
        }


        public FilterEquipmentLastDataBean getFilterEquipmentLastData() {
            return filterEquipmentLastData;
        }

        public void setFilterEquipmentLastData(FilterEquipmentLastDataBean filterEquipmentLastData) {
            this.filterEquipmentLastData = filterEquipmentLastData;
        }

        public static class FilterEquipmentLastDataBean implements Serializable {
            /**
             * dataList : [{"unit":"kW","name":"P1","value":88888888,"desc":"功率"}]
             * equipmentInfo : {"status":1,"createTime":"2018-03-10 11:16:12.0","updateTime":"2018-03-10 11:16:12.0","filterCompensationId":9,"filterCompensationName":"滤波器","electricMotorId":47,"electricMotorName":"生产线1运料皮带机电机","equipmentClassificationId":20,"equipmentClassificationName":"滤波补偿设备","equipmentTypeId":20,"equipmentTypeName":"滤波器","brandId":42,"brandName":"智光","seriesId":27,"seriesName":"ZG-dSVC","modelNumberId":83,"modelNumberName":"ZG-dSVC-5MVar","gatewayDeviceId":0,"channel":"0","slave":"0","filterCompensationDescription":"滤波备注"}
             */

            private EquipmentInfoBean equipmentInfo;
            private List<DataListBean> dataList;

            public EquipmentInfoBean getEquipmentInfo() {
                return equipmentInfo;
            }

            public void setEquipmentInfo(EquipmentInfoBean equipmentInfo) {
                this.equipmentInfo = equipmentInfo;
            }

            public List<DataListBean> getDataList() {
                return dataList;
            }

            public void setDataList(List<DataListBean> dataList) {
                this.dataList = dataList;
            }

            public static class EquipmentInfoBean {
                /**
                 * status : 1
                 * createTime : 2018-03-10 11:16:12.0
                 * updateTime : 2018-03-10 11:16:12.0
                 * filterCompensationId : 9
                 * filterCompensationName : 滤波器
                 * electricMotorId : 47
                 * electricMotorName : 生产线1运料皮带机电机
                 * equipmentClassificationId : 20
                 * equipmentClassificationName : 滤波补偿设备
                 * equipmentTypeId : 20
                 * equipmentTypeName : 滤波器
                 * brandId : 42
                 * brandName : 智光
                 * seriesId : 27
                 * seriesName : ZG-dSVC
                 * modelNumberId : 83
                 * modelNumberName : ZG-dSVC-5MVar
                 * gatewayDeviceId : 0
                 * channel : 0
                 * slave : 0
                 * filterCompensationDescription : 滤波备注
                 */

                private int status;
                private String createTime;
                private String updateTime;
                private int filterCompensationId;
                private String filterCompensationName;
                private int electricMotorId;
                private String electricMotorName;
                private int equipmentClassificationId;
                private String equipmentClassificationName;
                private int equipmentTypeId;
                private String equipmentTypeName;
                private int brandId;
                private String brandName;
                private int seriesId;
                private String seriesName;
                private int modelNumberId;
                private String modelNumberName;
                private int gatewayDeviceId;
                private String channel;
                private String slave;
                private String sn;
                private String filterCompensationDescription;

                public String getSn() {
                    return sn;
                }

                public void setSn(String sn) {
                    this.sn = sn;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(String updateTime) {
                    this.updateTime = updateTime;
                }

                public int getFilterCompensationId() {
                    return filterCompensationId;
                }

                public void setFilterCompensationId(int filterCompensationId) {
                    this.filterCompensationId = filterCompensationId;
                }

                public String getFilterCompensationName() {
                    return filterCompensationName;
                }

                public void setFilterCompensationName(String filterCompensationName) {
                    this.filterCompensationName = filterCompensationName;
                }

                public int getElectricMotorId() {
                    return electricMotorId;
                }

                public void setElectricMotorId(int electricMotorId) {
                    this.electricMotorId = electricMotorId;
                }

                public String getElectricMotorName() {
                    return electricMotorName;
                }

                public void setElectricMotorName(String electricMotorName) {
                    this.electricMotorName = electricMotorName;
                }

                public int getEquipmentClassificationId() {
                    return equipmentClassificationId;
                }

                public void setEquipmentClassificationId(int equipmentClassificationId) {
                    this.equipmentClassificationId = equipmentClassificationId;
                }

                public String getEquipmentClassificationName() {
                    return equipmentClassificationName;
                }

                public void setEquipmentClassificationName(String equipmentClassificationName) {
                    this.equipmentClassificationName = equipmentClassificationName;
                }

                public int getEquipmentTypeId() {
                    return equipmentTypeId;
                }

                public void setEquipmentTypeId(int equipmentTypeId) {
                    this.equipmentTypeId = equipmentTypeId;
                }

                public String getEquipmentTypeName() {
                    return equipmentTypeName;
                }

                public void setEquipmentTypeName(String equipmentTypeName) {
                    this.equipmentTypeName = equipmentTypeName;
                }

                public int getBrandId() {
                    return brandId;
                }

                public void setBrandId(int brandId) {
                    this.brandId = brandId;
                }

                public String getBrandName() {
                    return brandName;
                }

                public void setBrandName(String brandName) {
                    this.brandName = brandName;
                }

                public int getSeriesId() {
                    return seriesId;
                }

                public void setSeriesId(int seriesId) {
                    this.seriesId = seriesId;
                }

                public String getSeriesName() {
                    return seriesName;
                }

                public void setSeriesName(String seriesName) {
                    this.seriesName = seriesName;
                }

                public int getModelNumberId() {
                    return modelNumberId;
                }

                public void setModelNumberId(int modelNumberId) {
                    this.modelNumberId = modelNumberId;
                }

                public String getModelNumberName() {
                    return modelNumberName;
                }

                public void setModelNumberName(String modelNumberName) {
                    this.modelNumberName = modelNumberName;
                }

                public int getGatewayDeviceId() {
                    return gatewayDeviceId;
                }

                public void setGatewayDeviceId(int gatewayDeviceId) {
                    this.gatewayDeviceId = gatewayDeviceId;
                }

                public String getChannel() {
                    return channel;
                }

                public void setChannel(String channel) {
                    this.channel = channel;
                }

                public String getSlave() {
                    return slave;
                }

                public void setSlave(String slave) {
                    this.slave = slave;
                }

                public String getFilterCompensationDescription() {
                    return filterCompensationDescription;
                }

                public void setFilterCompensationDescription(String filterCompensationDescription) {
                    this.filterCompensationDescription = filterCompensationDescription;
                }
            }

            public static class DataListBean {
                /**
                 * unit : kW
                 * name : P1
                 * value : 88888888
                 * desc : 功率
                 */

                private String unit;
                private String name;
                private int value;
                private String desc;

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String unit) {
                    this.unit = unit;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }
            }
        }

        public static class SmartSwitchLastDataBean implements Serializable {
            /**
             * dataList : [{"unit":"kW","name":"P1","value":88888888,"desc":"输入功率"}]
             * equipmentInfo : {"status":1,"createTime":"2018-03-10 11:14:49.0","updateTime":"2018-03-10 11:14:49.0","monitorEquipmentId":40,"monitorEquipmentName":"智能开关","electricMotorId":47,"electricMotorName":"生产线1运料皮带机电机","equipmentClassificationId":19,"equipmentClassificationName":"监测设备","equipmentTypeId":28,"equipmentTypeName":"智能开关","brandId":46,"brandName":"施耐德","seriesId":32,"seriesName":"ZNKK","modelNumberId":91,"modelNumberName":"ZZKK-150","gatewayDeviceId":0,"channel":"0","slave":"0","ratedVoltageId":2,"ratedVoltageName":"380V","ratedCurrent":150,"monitorEquipmentInstallationTime":"2018-03-10","monitorEquipmentDescription":"智能开关备注"}
             */

            private EquipmentInfoBean equipmentInfo;
            private List<DataListBean> dataList;

            public EquipmentInfoBean getEquipmentInfo() {
                return equipmentInfo;
            }

            public void setEquipmentInfo(EquipmentInfoBean equipmentInfo) {
                this.equipmentInfo = equipmentInfo;
            }

            public List<DataListBean> getDataList() {
                return dataList;
            }

            public void setDataList(List<DataListBean> dataList) {
                this.dataList = dataList;
            }

            public static class EquipmentInfoBean {
                /**
                 * status : 1
                 * createTime : 2018-03-10 11:14:49.0
                 * updateTime : 2018-03-10 11:14:49.0
                 * monitorEquipmentId : 40
                 * monitorEquipmentName : 智能开关
                 * electricMotorId : 47
                 * electricMotorName : 生产线1运料皮带机电机
                 * equipmentClassificationId : 19
                 * equipmentClassificationName : 监测设备
                 * equipmentTypeId : 28
                 * equipmentTypeName : 智能开关
                 * brandId : 46
                 * brandName : 施耐德
                 * seriesId : 32
                 * seriesName : ZNKK
                 * modelNumberId : 91
                 * modelNumberName : ZZKK-150
                 * gatewayDeviceId : 0
                 * channel : 0
                 * slave : 0
                 * ratedVoltageId : 2
                 * ratedVoltageName : 380V
                 * ratedCurrent : 150
                 * monitorEquipmentInstallationTime : 2018-03-10
                 * monitorEquipmentDescription : 智能开关备注
                 */

                private int status;
                private String createTime;
                private String updateTime;
                private int monitorEquipmentId;
                private String monitorEquipmentName;
                private int electricMotorId;
                private String electricMotorName;
                private int equipmentClassificationId;
                private String equipmentClassificationName;
                private int equipmentTypeId;
                private String equipmentTypeName;
                private int brandId;
                private String brandName;
                private int seriesId;
                private String seriesName;
                private int modelNumberId;
                private String modelNumberName;
                private int gatewayDeviceId;
                private String channel;
                private String slave;
                private String sn;
                private int ratedVoltageId;
                private String ratedVoltageName;
                private int ratedCurrent;
                private String monitorEquipmentInstallationTime;
                private String monitorEquipmentDescription;

                public String getSn() {
                    return sn;
                }

                public void setSn(String sn) {
                    this.sn = sn;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(String updateTime) {
                    this.updateTime = updateTime;
                }

                public int getMonitorEquipmentId() {
                    return monitorEquipmentId;
                }

                public void setMonitorEquipmentId(int monitorEquipmentId) {
                    this.monitorEquipmentId = monitorEquipmentId;
                }

                public String getMonitorEquipmentName() {
                    return monitorEquipmentName;
                }

                public void setMonitorEquipmentName(String monitorEquipmentName) {
                    this.monitorEquipmentName = monitorEquipmentName;
                }

                public int getElectricMotorId() {
                    return electricMotorId;
                }

                public void setElectricMotorId(int electricMotorId) {
                    this.electricMotorId = electricMotorId;
                }

                public String getElectricMotorName() {
                    return electricMotorName;
                }

                public void setElectricMotorName(String electricMotorName) {
                    this.electricMotorName = electricMotorName;
                }

                public int getEquipmentClassificationId() {
                    return equipmentClassificationId;
                }

                public void setEquipmentClassificationId(int equipmentClassificationId) {
                    this.equipmentClassificationId = equipmentClassificationId;
                }

                public String getEquipmentClassificationName() {
                    return equipmentClassificationName;
                }

                public void setEquipmentClassificationName(String equipmentClassificationName) {
                    this.equipmentClassificationName = equipmentClassificationName;
                }

                public int getEquipmentTypeId() {
                    return equipmentTypeId;
                }

                public void setEquipmentTypeId(int equipmentTypeId) {
                    this.equipmentTypeId = equipmentTypeId;
                }

                public String getEquipmentTypeName() {
                    return equipmentTypeName;
                }

                public void setEquipmentTypeName(String equipmentTypeName) {
                    this.equipmentTypeName = equipmentTypeName;
                }

                public int getBrandId() {
                    return brandId;
                }

                public void setBrandId(int brandId) {
                    this.brandId = brandId;
                }

                public String getBrandName() {
                    return brandName;
                }

                public void setBrandName(String brandName) {
                    this.brandName = brandName;
                }

                public int getSeriesId() {
                    return seriesId;
                }

                public void setSeriesId(int seriesId) {
                    this.seriesId = seriesId;
                }

                public String getSeriesName() {
                    return seriesName;
                }

                public void setSeriesName(String seriesName) {
                    this.seriesName = seriesName;
                }

                public int getModelNumberId() {
                    return modelNumberId;
                }

                public void setModelNumberId(int modelNumberId) {
                    this.modelNumberId = modelNumberId;
                }

                public String getModelNumberName() {
                    return modelNumberName;
                }

                public void setModelNumberName(String modelNumberName) {
                    this.modelNumberName = modelNumberName;
                }

                public int getGatewayDeviceId() {
                    return gatewayDeviceId;
                }

                public void setGatewayDeviceId(int gatewayDeviceId) {
                    this.gatewayDeviceId = gatewayDeviceId;
                }

                public String getChannel() {
                    return channel;
                }

                public void setChannel(String channel) {
                    this.channel = channel;
                }

                public String getSlave() {
                    return slave;
                }

                public void setSlave(String slave) {
                    this.slave = slave;
                }

                public int getRatedVoltageId() {
                    return ratedVoltageId;
                }

                public void setRatedVoltageId(int ratedVoltageId) {
                    this.ratedVoltageId = ratedVoltageId;
                }

                public String getRatedVoltageName() {
                    return ratedVoltageName;
                }

                public void setRatedVoltageName(String ratedVoltageName) {
                    this.ratedVoltageName = ratedVoltageName;
                }

                public int getRatedCurrent() {
                    return ratedCurrent;
                }

                public void setRatedCurrent(int ratedCurrent) {
                    this.ratedCurrent = ratedCurrent;
                }

                public String getMonitorEquipmentInstallationTime() {
                    return monitorEquipmentInstallationTime;
                }

                public void setMonitorEquipmentInstallationTime(String monitorEquipmentInstallationTime) {
                    this.monitorEquipmentInstallationTime = monitorEquipmentInstallationTime;
                }

                public String getMonitorEquipmentDescription() {
                    return monitorEquipmentDescription;
                }

                public void setMonitorEquipmentDescription(String monitorEquipmentDescription) {
                    this.monitorEquipmentDescription = monitorEquipmentDescription;
                }
            }

            public static class DataListBean {
                /**
                 * unit : kW
                 * name : P1
                 * value : 88888888
                 * desc : 输入功率
                 */

                private String unit;
                private String name;
                private int value;
                private String desc;

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String unit) {
                    this.unit = unit;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }
            }
        }

        public static class MonitorInstrumentLastDataBean implements Serializable {
            /**
             * dataList : [{"unit":null,"name":"MC_Zd4","value":0,"desc":"振动值4"},{"unit":null,"name":"MC_Zd5","value":0,"desc":"振动值5"},{"unit":null,"name":"MC_Zd6","value":0,"desc":"振动值6"},{"unit":null,"name":"MC_Zd7","value":0,"desc":"振动值7"},{"unit":null,"name":"MC_Zd8","value":0,"desc":"振动值8"},{"unit":null,"name":"MC_Zd1","value":0,"desc":"振动值1"},{"unit":null,"name":"MC_Zd2","value":0,"desc":"振动值2"},{"unit":null,"name":"MC_Zd3","value":0,"desc":"振动值3"}]
             * equipmentInfo : {"status":1,"createTime":"2018-03-06 20:26:19.0","updateTime":"2018-03-06 20:27:11.0","monitorEquipmentId":26,"monitorEquipmentName":"震动传感器","electricMotorId":13,"electricMotorName":"4b皮带机1电机","equipmentClassificationId":19,"equipmentClassificationName":"监测设备","equipmentTypeId":22,"equipmentTypeName":"震动传感器","brandId":47,"brandName":"杭江","seriesId":35,"seriesName":"HJ-9002","modelNumberId":96,"modelNumberName":"HJ-9002","gatewayDeviceId":0,"channel":"0","slave":"0","monitorEquipmentInstallationTime":"2018-03-06"}
             */

            private EquipmentInfoBean equipmentInfo;
            private List<DataListBean> dataList;

            public EquipmentInfoBean getEquipmentInfo() {
                return equipmentInfo;
            }

            public void setEquipmentInfo(EquipmentInfoBean equipmentInfo) {
                this.equipmentInfo = equipmentInfo;
            }

            public List<DataListBean> getDataList() {
                return dataList;
            }

            public void setDataList(List<DataListBean> dataList) {
                this.dataList = dataList;
            }

            public static class EquipmentInfoBean implements Serializable {
                /**
                 * status : 1
                 * createTime : 2018-03-06 20:26:19.0
                 * updateTime : 2018-03-06 20:27:11.0
                 * monitorEquipmentId : 26
                 * monitorEquipmentName : 震动传感器
                 * electricMotorId : 13
                 * electricMotorName : 4b皮带机1电机
                 * equipmentClassificationId : 19
                 * equipmentClassificationName : 监测设备
                 * equipmentTypeId : 22
                 * equipmentTypeName : 震动传感器
                 * brandId : 47
                 * brandName : 杭江
                 * seriesId : 35
                 * seriesName : HJ-9002
                 * modelNumberId : 96
                 * modelNumberName : HJ-9002
                 * gatewayDeviceId : 0
                 * channel : 0
                 * slave : 0
                 * monitorEquipmentInstallationTime : 2018-03-06
                 */

                private int status;
                private String sn;
                private String createTime;
                private String updateTime;
                private int monitorEquipmentId;
                private String monitorEquipmentName;
                private int electricMotorId;
                private String electricMotorName;
                private int equipmentClassificationId;
                private String equipmentClassificationName;
                private int equipmentTypeId;
                private String equipmentTypeName;
                private int brandId;
                private String brandName;
                private int seriesId;
                private String seriesName;
                private int modelNumberId;
                private String modelNumberName;
                private int gatewayDeviceId;
                private String channel;
                private String slave;
                private String monitorEquipmentInstallationTime;

                public String getSn() {
                    return sn;
                }

                public void setSn(String sn) {
                    this.sn = sn;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(String updateTime) {
                    this.updateTime = updateTime;
                }

                public int getMonitorEquipmentId() {
                    return monitorEquipmentId;
                }

                public void setMonitorEquipmentId(int monitorEquipmentId) {
                    this.monitorEquipmentId = monitorEquipmentId;
                }

                public String getMonitorEquipmentName() {
                    return monitorEquipmentName;
                }

                public void setMonitorEquipmentName(String monitorEquipmentName) {
                    this.monitorEquipmentName = monitorEquipmentName;
                }

                public int getElectricMotorId() {
                    return electricMotorId;
                }

                public void setElectricMotorId(int electricMotorId) {
                    this.electricMotorId = electricMotorId;
                }

                public String getElectricMotorName() {
                    return electricMotorName;
                }

                public void setElectricMotorName(String electricMotorName) {
                    this.electricMotorName = electricMotorName;
                }

                public int getEquipmentClassificationId() {
                    return equipmentClassificationId;
                }

                public void setEquipmentClassificationId(int equipmentClassificationId) {
                    this.equipmentClassificationId = equipmentClassificationId;
                }

                public String getEquipmentClassificationName() {
                    return equipmentClassificationName;
                }

                public void setEquipmentClassificationName(String equipmentClassificationName) {
                    this.equipmentClassificationName = equipmentClassificationName;
                }

                public int getEquipmentTypeId() {
                    return equipmentTypeId;
                }

                public void setEquipmentTypeId(int equipmentTypeId) {
                    this.equipmentTypeId = equipmentTypeId;
                }

                public String getEquipmentTypeName() {
                    return equipmentTypeName;
                }

                public void setEquipmentTypeName(String equipmentTypeName) {
                    this.equipmentTypeName = equipmentTypeName;
                }

                public int getBrandId() {
                    return brandId;
                }

                public void setBrandId(int brandId) {
                    this.brandId = brandId;
                }

                public String getBrandName() {
                    return brandName;
                }

                public void setBrandName(String brandName) {
                    this.brandName = brandName;
                }

                public int getSeriesId() {
                    return seriesId;
                }

                public void setSeriesId(int seriesId) {
                    this.seriesId = seriesId;
                }

                public String getSeriesName() {
                    return seriesName;
                }

                public void setSeriesName(String seriesName) {
                    this.seriesName = seriesName;
                }

                public int getModelNumberId() {
                    return modelNumberId;
                }

                public void setModelNumberId(int modelNumberId) {
                    this.modelNumberId = modelNumberId;
                }

                public String getModelNumberName() {
                    return modelNumberName;
                }

                public void setModelNumberName(String modelNumberName) {
                    this.modelNumberName = modelNumberName;
                }

                public int getGatewayDeviceId() {
                    return gatewayDeviceId;
                }

                public void setGatewayDeviceId(int gatewayDeviceId) {
                    this.gatewayDeviceId = gatewayDeviceId;
                }

                public String getChannel() {
                    return channel;
                }

                public void setChannel(String channel) {
                    this.channel = channel;
                }

                public String getSlave() {
                    return slave;
                }

                public void setSlave(String slave) {
                    this.slave = slave;
                }

                public String getMonitorEquipmentInstallationTime() {
                    return monitorEquipmentInstallationTime;
                }

                public void setMonitorEquipmentInstallationTime(String monitorEquipmentInstallationTime) {
                    this.monitorEquipmentInstallationTime = monitorEquipmentInstallationTime;
                }
            }

            public static class DataListBean {
                /**
                 * unit : null
                 * name : MC_Zd4
                 * value : 0
                 * desc : 振动值4
                 */

                private String unit;
                private String name;
                private double value;
                private String desc;

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String unit) {
                    this.unit = unit;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }
            }
        }

        public static class ElectricInstrumentLastDataBean implements Serializable {
            /**
             * dataList : [{"unit":null,"name":"MS_Pfs","value":0.857,"desc":"总功率因数"},{"unit":"V","name":"MS_Us","value":416.7,"desc":"电源电压"},{"unit":"V","name":"MS_Uab","value":416.6,"desc":"AB线电压"},{"unit":"V","name":"MS_Ubc","value":417.2,"desc":"BC线电压"},{"unit":"V","name":"MS_Uac","value":416.6,"desc":"AC线电压"},{"unit":"A","name":"IO","value":110.84,"desc":"输出电流"},{"unit":"A","name":"MS_Ia","value":110.16,"desc":"A相电流"},{"unit":"A","name":"MS_Ib","value":110.24,"desc":"B相电流"},{"unit":"A","name":"MS_Ic","value":112.16,"desc":"C相电流"},{"unit":"kW","name":"P1","value":68.8,"desc":"输出功率"},{"unit":null,"name":"MS_Pa","value":22.84,"desc":"A相有功功率"},{"unit":null,"name":"MS_Pb","value":23.16,"desc":"B相有功功率"},{"unit":null,"name":"MS_Pc","value":23.48,"desc":"C相有功功率"},{"unit":null,"name":"MS_E1","value":36170.8,"desc":"累计输入电量"},{"unit":null,"name":"MS_Q","value":41.36,"desc":"无功功率"},{"unit":null,"name":"MS_Kvarh","value":32006,"desc":"无功耗电量"},{"unit":null,"name":"DK_Ct","value":0,"desc":"互感器变比"},{"unit":null,"name":"MS_THDUa","value":0,"desc":"A相电压谐波总含量"},{"unit":null,"name":"MS_THDUb","value":0,"desc":"B相电压谐波总含量"},{"unit":null,"name":"MS_THDUc","value":0,"desc":"C相电压谐波总含量"},{"unit":null,"name":"MS_THDIa","value":0,"desc":"A相电流谐波总含量"},{"unit":null,"name":"MS_THDIb","value":0,"desc":"B相电流谐波总含量"},{"unit":null,"name":"MS_THDIc","value":0,"desc":"C相电流谐波总含量"},{"unit":null,"name":"MS_THDIa","value":0,"desc":"A相电流谐波总含量"}]
             * equipmentInfo : {"status":1,"createTime":"2018-01-18 11:26:25.0","updateTime":"2018-01-18 11:30:05.0","monitorEquipmentId":7,"monitorEquipmentName":"电力仪表","electricMotorId":13,"electricMotorName":"4b皮带机1电机","equipmentClassificationId":19,"equipmentClassificationName":"监测设备","equipmentTypeId":23,"equipmentTypeName":"电力仪表","brandId":35,"brandName":"安科瑞","seriesId":25,"seriesName":"AMC16-E4","modelNumberId":95,"modelNumberName":"AMC16-E4 5A","gatewayDeviceId":10,"sn":"2-26001-171218-00004","channel":"C1","slave":"B1","monitorEquipmentInstallationTime":"2018-01-18"}
             */

            private EquipmentInfoBeanX equipmentInfo;
            private List<DataListBeanX> dataList;

            public EquipmentInfoBeanX getEquipmentInfo() {
                return equipmentInfo;
            }

            public void setEquipmentInfo(EquipmentInfoBeanX equipmentInfo) {
                this.equipmentInfo = equipmentInfo;
            }

            public List<DataListBeanX> getDataList() {
                return dataList;
            }

            public void setDataList(List<DataListBeanX> dataList) {
                this.dataList = dataList;
            }

            public static class EquipmentInfoBeanX {
                /**
                 * status : 1
                 * createTime : 2018-01-18 11:26:25.0
                 * updateTime : 2018-01-18 11:30:05.0
                 * monitorEquipmentId : 7
                 * monitorEquipmentName : 电力仪表
                 * electricMotorId : 13
                 * electricMotorName : 4b皮带机1电机
                 * equipmentClassificationId : 19
                 * equipmentClassificationName : 监测设备
                 * equipmentTypeId : 23
                 * equipmentTypeName : 电力仪表
                 * brandId : 35
                 * brandName : 安科瑞
                 * seriesId : 25
                 * seriesName : AMC16-E4
                 * modelNumberId : 95
                 * modelNumberName : AMC16-E4 5A
                 * gatewayDeviceId : 10
                 * sn : 2-26001-171218-00004
                 * channel : C1
                 * slave : B1
                 * monitorEquipmentInstallationTime : 2018-01-18
                 */

                private int status;
                private String createTime;
                private String updateTime;
                private int monitorEquipmentId;
                private String monitorEquipmentName;
                private int electricMotorId;
                private String electricMotorName;
                private int equipmentClassificationId;
                private String equipmentClassificationName;
                private int equipmentTypeId;
                private String equipmentTypeName;
                private int brandId;
                private String brandName;
                private int seriesId;
                private String seriesName;
                private int modelNumberId;
                private String modelNumberName;
                private int gatewayDeviceId;
                private String sn;
                private String channel;
                private String slave;
                private String monitorEquipmentInstallationTime;

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(String updateTime) {
                    this.updateTime = updateTime;
                }

                public int getMonitorEquipmentId() {
                    return monitorEquipmentId;
                }

                public void setMonitorEquipmentId(int monitorEquipmentId) {
                    this.monitorEquipmentId = monitorEquipmentId;
                }

                public String getMonitorEquipmentName() {
                    return monitorEquipmentName;
                }

                public void setMonitorEquipmentName(String monitorEquipmentName) {
                    this.monitorEquipmentName = monitorEquipmentName;
                }

                public int getElectricMotorId() {
                    return electricMotorId;
                }

                public void setElectricMotorId(int electricMotorId) {
                    this.electricMotorId = electricMotorId;
                }

                public String getElectricMotorName() {
                    return electricMotorName;
                }

                public void setElectricMotorName(String electricMotorName) {
                    this.electricMotorName = electricMotorName;
                }

                public int getEquipmentClassificationId() {
                    return equipmentClassificationId;
                }

                public void setEquipmentClassificationId(int equipmentClassificationId) {
                    this.equipmentClassificationId = equipmentClassificationId;
                }

                public String getEquipmentClassificationName() {
                    return equipmentClassificationName;
                }

                public void setEquipmentClassificationName(String equipmentClassificationName) {
                    this.equipmentClassificationName = equipmentClassificationName;
                }

                public int getEquipmentTypeId() {
                    return equipmentTypeId;
                }

                public void setEquipmentTypeId(int equipmentTypeId) {
                    this.equipmentTypeId = equipmentTypeId;
                }

                public String getEquipmentTypeName() {
                    return equipmentTypeName;
                }

                public void setEquipmentTypeName(String equipmentTypeName) {
                    this.equipmentTypeName = equipmentTypeName;
                }

                public int getBrandId() {
                    return brandId;
                }

                public void setBrandId(int brandId) {
                    this.brandId = brandId;
                }

                public String getBrandName() {
                    return brandName;
                }

                public void setBrandName(String brandName) {
                    this.brandName = brandName;
                }

                public int getSeriesId() {
                    return seriesId;
                }

                public void setSeriesId(int seriesId) {
                    this.seriesId = seriesId;
                }

                public String getSeriesName() {
                    return seriesName;
                }

                public void setSeriesName(String seriesName) {
                    this.seriesName = seriesName;
                }

                public int getModelNumberId() {
                    return modelNumberId;
                }

                public void setModelNumberId(int modelNumberId) {
                    this.modelNumberId = modelNumberId;
                }

                public String getModelNumberName() {
                    return modelNumberName;
                }

                public void setModelNumberName(String modelNumberName) {
                    this.modelNumberName = modelNumberName;
                }

                public int getGatewayDeviceId() {
                    return gatewayDeviceId;
                }

                public void setGatewayDeviceId(int gatewayDeviceId) {
                    this.gatewayDeviceId = gatewayDeviceId;
                }

                public String getSn() {
                    return sn;
                }

                public void setSn(String sn) {
                    this.sn = sn;
                }

                public String getChannel() {
                    return channel;
                }

                public void setChannel(String channel) {
                    this.channel = channel;
                }

                public String getSlave() {
                    return slave;
                }

                public void setSlave(String slave) {
                    this.slave = slave;
                }

                public String getMonitorEquipmentInstallationTime() {
                    return monitorEquipmentInstallationTime;
                }

                public void setMonitorEquipmentInstallationTime(String monitorEquipmentInstallationTime) {
                    this.monitorEquipmentInstallationTime = monitorEquipmentInstallationTime;
                }
            }

            public static class DataListBeanX {
                /**
                 * unit : null
                 * name : MS_Pfs
                 * value : 0.857
                 * desc : 总功率因数
                 */

                private String unit;
                private String name;
                private double value;
                private String desc;

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String unit) {
                    this.unit = unit;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }
            }
        }

        public static class ElectricMotorDataListBean implements Serializable {
            /**
             * unit : null
             * name : P2
             * value : 64.95759808148624
             * desc : 轴功率
             */

            private String unit;
            private String name;
            private double value;
            private String desc;

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public double getValue() {
                return value;
            }

            public void setValue(double value) {
                this.value = value;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }
        }

        public static class ControlEquipmentLastDataBean implements Serializable {
            /**
             * dataList : [{"unit":null,"name":"Isl","value":88888888,"desc":"节能水平"},{"unit":"kVar","name":"MS_Q","value":88888888,"desc":"无功功率"},{"unit":"A","name":"IO","value":88888888,"desc":"输出电流"},{"unit":null,"name":"MS_Pfo","value":88888888,"desc":"功率因数"},{"unit":"kW","name":"P1","value":88888888,"desc":"输出功率"},{"unit":"C","name":"MS_Tvsd","value":88888888,"desc":"温度"}]
             * equipmentInfo : {"sort":0,"status":1,"createTime":"2018-03-08 18:21:42.0","updateTime":"2018-03-08 18:21:42.0","controlEquipmentId":38,"controlEquipmentName":"Fairford控制器","controlEquipmentDescription":"测试运料皮带机","controlEquipmentInstallationTime":"2018-03-08","electricMotorId":47,"electricMotorName":"生产线1运料皮带机电机","equipmentClassificationId":18,"equipmentClassificationName":"控制设备","equipmentTypeId":19,"equipmentTypeName":"Fairford控制器","brandId":39,"brandName":"Fairford","seriesId":14,"seriesName":"SGY","modelNumberId":61,"ratedVoltageId":2,"ratedVoltageName":"380V","bypassSchemeId":4,"bypassSchemeName":"无","kp":1.25,"gatewayDeviceId":16,"sn":"2-26001-171218-00007","channel":"C1","slave":"B1"}
             */

            private ControlEquipmentLastDataBean.EquipmentInfoBean equipmentInfo;
            private List<ControlEquipmentLastDataBean.DataListBean> dataList;

            public ControlEquipmentLastDataBean.EquipmentInfoBean getEquipmentInfo() {
                return equipmentInfo;
            }

            public void setEquipmentInfo(ControlEquipmentLastDataBean.EquipmentInfoBean equipmentInfo) {
                this.equipmentInfo = equipmentInfo;
            }

            public List<ControlEquipmentLastDataBean.DataListBean> getDataList() {
                return dataList;
            }

            public void setDataList(List<ControlEquipmentLastDataBean.DataListBean> dataList) {
                this.dataList = dataList;
            }

            public static class EquipmentInfoBean {
                /**
                 * sort : 0
                 * status : 1
                 * createTime : 2018-03-08 18:21:42.0
                 * updateTime : 2018-03-08 18:21:42.0
                 * controlEquipmentId : 38
                 * controlEquipmentName : Fairford控制器
                 * controlEquipmentDescription : 测试运料皮带机
                 * controlEquipmentInstallationTime : 2018-03-08
                 * electricMotorId : 47
                 * electricMotorName : 生产线1运料皮带机电机
                 * equipmentClassificationId : 18
                 * equipmentClassificationName : 控制设备
                 * equipmentTypeId : 19
                 * equipmentTypeName : Fairford控制器
                 * brandId : 39
                 * brandName : Fairford
                 * seriesId : 14
                 * seriesName : SGY
                 * modelNumberId : 61
                 * ratedVoltageId : 2
                 * ratedVoltageName : 380V
                 * bypassSchemeId : 4
                 * bypassSchemeName : 无
                 * kp : 1.25
                 * gatewayDeviceId : 16
                 * sn : 2-26001-171218-00007
                 * channel : C1
                 * slave : B1
                 */

                private int sort;
                private int status;
                private String createTime;
                private String updateTime;
                private int controlEquipmentId;
                private String controlEquipmentName;
                private String controlEquipmentDescription;
                private String controlEquipmentInstallationTime;
                private int electricMotorId;
                private String electricMotorName;
                private int equipmentClassificationId;
                private String equipmentClassificationName;
                private int equipmentTypeId;
                private String equipmentTypeName;
                private int brandId;
                private String brandName;
                private int seriesId;
                private String seriesName;
                private int modelNumberId;
                private int ratedVoltageId;
                private String ratedVoltageName;
                private int bypassSchemeId;
                private String bypassSchemeName;
                private double kp;
                private int gatewayDeviceId;
                private String sn;
                private String channel;
                private String slave;
                private String modelNumberName;

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(String updateTime) {
                    this.updateTime = updateTime;
                }

                public int getControlEquipmentId() {
                    return controlEquipmentId;
                }

                public void setControlEquipmentId(int controlEquipmentId) {
                    this.controlEquipmentId = controlEquipmentId;
                }

                public String getControlEquipmentName() {
                    return controlEquipmentName;
                }

                public void setControlEquipmentName(String controlEquipmentName) {
                    this.controlEquipmentName = controlEquipmentName;
                }

                public String getControlEquipmentDescription() {
                    return controlEquipmentDescription;
                }

                public void setControlEquipmentDescription(String controlEquipmentDescription) {
                    this.controlEquipmentDescription = controlEquipmentDescription;
                }

                public String getControlEquipmentInstallationTime() {
                    return controlEquipmentInstallationTime;
                }

                public void setControlEquipmentInstallationTime(String controlEquipmentInstallationTime) {
                    this.controlEquipmentInstallationTime = controlEquipmentInstallationTime;
                }

                public int getElectricMotorId() {
                    return electricMotorId;
                }

                public void setElectricMotorId(int electricMotorId) {
                    this.electricMotorId = electricMotorId;
                }

                public String getElectricMotorName() {
                    return electricMotorName;
                }

                public void setElectricMotorName(String electricMotorName) {
                    this.electricMotorName = electricMotorName;
                }

                public int getEquipmentClassificationId() {
                    return equipmentClassificationId;
                }

                public void setEquipmentClassificationId(int equipmentClassificationId) {
                    this.equipmentClassificationId = equipmentClassificationId;
                }

                public String getEquipmentClassificationName() {
                    return equipmentClassificationName;
                }

                public void setEquipmentClassificationName(String equipmentClassificationName) {
                    this.equipmentClassificationName = equipmentClassificationName;
                }

                public int getEquipmentTypeId() {
                    return equipmentTypeId;
                }

                public void setEquipmentTypeId(int equipmentTypeId) {
                    this.equipmentTypeId = equipmentTypeId;
                }

                public String getEquipmentTypeName() {
                    return equipmentTypeName;
                }

                public void setEquipmentTypeName(String equipmentTypeName) {
                    this.equipmentTypeName = equipmentTypeName;
                }

                public int getBrandId() {
                    return brandId;
                }

                public void setBrandId(int brandId) {
                    this.brandId = brandId;
                }

                public String getBrandName() {
                    return brandName;
                }

                public void setBrandName(String brandName) {
                    this.brandName = brandName;
                }

                public int getSeriesId() {
                    return seriesId;
                }

                public void setSeriesId(int seriesId) {
                    this.seriesId = seriesId;
                }

                public String getSeriesName() {
                    return seriesName;
                }

                public void setSeriesName(String seriesName) {
                    this.seriesName = seriesName;
                }

                public int getModelNumberId() {
                    return modelNumberId;
                }

                public void setModelNumberId(int modelNumberId) {
                    this.modelNumberId = modelNumberId;
                }

                public int getRatedVoltageId() {
                    return ratedVoltageId;
                }

                public void setRatedVoltageId(int ratedVoltageId) {
                    this.ratedVoltageId = ratedVoltageId;
                }

                public String getRatedVoltageName() {
                    return ratedVoltageName;
                }

                public void setRatedVoltageName(String ratedVoltageName) {
                    this.ratedVoltageName = ratedVoltageName;
                }

                public int getBypassSchemeId() {
                    return bypassSchemeId;
                }

                public void setBypassSchemeId(int bypassSchemeId) {
                    this.bypassSchemeId = bypassSchemeId;
                }

                public String getBypassSchemeName() {
                    return bypassSchemeName;
                }

                public void setBypassSchemeName(String bypassSchemeName) {
                    this.bypassSchemeName = bypassSchemeName;
                }

                public double getKp() {
                    return kp;
                }

                public void setKp(double kp) {
                    this.kp = kp;
                }

                public int getGatewayDeviceId() {
                    return gatewayDeviceId;
                }

                public void setGatewayDeviceId(int gatewayDeviceId) {
                    this.gatewayDeviceId = gatewayDeviceId;
                }

                public String getSn() {
                    return sn;
                }

                public void setSn(String sn) {
                    this.sn = sn;
                }

                public String getChannel() {
                    return channel;
                }

                public void setChannel(String channel) {
                    this.channel = channel;
                }

                public String getSlave() {
                    return slave;
                }

                public void setSlave(String slave) {
                    this.slave = slave;
                }

                public String getModelNumberName() {
                    return modelNumberName;
                }

                public void setModelNumberName(String modelNumberName) {
                    this.modelNumberName = modelNumberName;
                }
            }

            public static class DataListBean {
                /**
                 * unit : null
                 * name : Isl
                 * value : 88888888
                 * desc : 节能水平
                 */

                private String unit;
                private String name;
                private int value;
                private String desc;

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String unit) {
                    this.unit = unit;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }
            }
        }
    }
}
