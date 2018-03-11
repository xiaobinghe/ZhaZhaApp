package com.locensate.letnetwork.bean;

import java.io.Serializable;


/**
 * $String
 *
 * @author xiaobinghe
 */

public class MachineInfoEntity implements Serializable {

    /**
     * operCode : 1
     * data : {"smart_switch_info":{"electric_motor_name":"4b皮带机1电机","equipment_classification_name":"监测设备","rated_voltage_name":"380V","equipment_type_name":"智能开关","create_time":1520402050000,"monitor_equipment_id":31,"rated_current":150,"electric_motor_id":13,"channel":"0","brand_name":"施耐德","monitor_equipment_installation_time":"2018-03-07","monitor_equipment_name":"智能开关","equipment_classification_id":19,"brand_id":46,"series_id":32,"slave":"0","equipment_type_id":28,"gateway_device_id":0,"update_time":1520402547000,"rated_voltage_id":2,"model_number_id":91,"series_name":"ZNKK","model_number_name":"ZZKK-150","status":1},"electric_instrument_info":{"electric_motor_name":"4b皮带机1电机","equipment_classification_name":"监测设备","equipment_type_name":"电力仪表","create_time":1516245985000,"monitor_equipment_id":7,"electric_motor_id":13,"channel":"C1","brand_name":"安科瑞","monitor_equipment_installation_time":"2018-01-18","monitor_equipment_name":"电力仪表","equipment_classification_id":19,"brand_id":35,"series_id":25,"slave":"B1","equipment_type_id":23,"gateway_device_id":10,"update_time":1516246205000,"model_number_id":95,"series_name":"AMC16-E4","model_number_name":"AMC16-E4 5A","sn":"2-26001-171218-00004","status":1},"meter_info":{"electric_motor_name":"4b皮带机1电机","equipment_classification_name":"监测设备","equipment_type_name":"震动传感器","create_time":1520339179000,"monitor_equipment_id":26,"electric_motor_id":13,"channel":"0","brand_name":"杭江","monitor_equipment_installation_time":"2018-03-06","monitor_equipment_name":"震动传感器","equipment_classification_id":19,"brand_id":47,"series_id":35,"slave":"0","equipment_type_id":22,"gateway_device_id":0,"update_time":1520339231000,"model_number_id":96,"series_name":"HJ-9002","model_number_name":"HJ-9002","status":1},"whole_equipment_info":{"whole_equipment_id":24,"create_time":1516244521000,"whole_equipment_description":"要改","sort":0,"whole_equipment_type_description":"皮带机","organization_name":"供料车间","whole_equipment_type_id":3,"update_time":1520303447000,"whole_equipment_type_name":"皮带机","whole_equipment_name":"4B皮带机1","organization_id":51,"whole_equipment_location":"4B配电室","status":1},"motor_info":{"cooling_way_name":"IC411","smart_switch_id":31,"q30_alarm":100,"kbz":0.65,"q5_alarm":100,"electric_motor_name":"4b皮带机1电机","rated_current":167,"installation_id":9,"installation_year":"2010.02.06","equipment_type_id":24,"filter_equipment_id":5,"energy_efficiency_grade_id":4,"pole_number_id":2,"zd_alarm":4.5,"kkz":0.15,"pole_number_name":"4","rated_voltage_name":"380V","equipment_type_name":"三相异步电机","create_time":1516245114000,"rated_speed_name":"1500","control_equipment_name":"直接启动","brand_name":"湘潭电机厂","organization_name":"供料车间","sort":0,"energy_efficiency_grade_name":"普通能效","stn":5,"io_alarm":110,"brand_id":38,"electric_instrument_id":7,"filter_equipment_name":"滤波器","control_equipment_id":16,"cooling_way_id":8,"whole_equipment_name":"4b皮带机1","organization_id":51,"monitor_instrument_name":"震动传感器","electric_motor_description":"要改","status":1,"smart_switch_name":"智能开关","rated_efficiency":0.942,"update_time":1520402547000,"model_number_id":70,"installation_name":"0","kqz":0.35,"series_name":"Y2","model_number_name":"Y2-280M-4 ","rated_speed_id":10,"rated_noload_loss":1.995,"whole_equipment_id":24,"tkz":10,"rated_power":90,"electric_instrument_name":"电力仪表","electric_motor_id":13,"tem_alarm":65,"kzz":0.95,"series_id":15,"rated_voltage_id":2,"monitor_instrument_id":26},"apf_pfc_info":{"electric_motor_name":"4b皮带机1电机","equipment_classification_name":"滤波补偿设备","equipment_type_name":"滤波器","create_time":1520402163000,"electric_motor_id":13,"channel":"0","brand_name":"智光","equipment_classification_id":20,"brand_id":42,"series_id":27,"slave":"0","equipment_type_id":20,"gateway_device_id":0,"update_time":1520402163000,"model_number_id":82,"filter_compensation_description":"其它","filter_compensation_name":"滤波器","series_name":"ZG-dSVC","model_number_name":"ZG-dSVC-3MVar","filter_compensation_id":5,"status":1},"control_machine_info":{"equipment_type_id":4,"update_time":1516246135000,"electric_motor_name":"4b皮带机1电机","equipment_classification_name":"控制设备","control_equipment_id":16,"equipment_type_name":"直接启动","create_time":1516246135000,"control_equipment_name":"直接启动","electric_motor_id":13,"sort":0,"equipment_classification_id":18,"status":1}}
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
         * smart_switch_info : {"electric_motor_name":"4b皮带机1电机","equipment_classification_name":"监测设备","rated_voltage_name":"380V","equipment_type_name":"智能开关","create_time":1520402050000,"monitor_equipment_id":31,"rated_current":150,"electric_motor_id":13,"channel":"0","brand_name":"施耐德","monitor_equipment_installation_time":"2018-03-07","monitor_equipment_name":"智能开关","equipment_classification_id":19,"brand_id":46,"series_id":32,"slave":"0","equipment_type_id":28,"gateway_device_id":0,"update_time":1520402547000,"rated_voltage_id":2,"model_number_id":91,"series_name":"ZNKK","model_number_name":"ZZKK-150","status":1}
         * electric_instrument_info : {"electric_motor_name":"4b皮带机1电机","equipment_classification_name":"监测设备","equipment_type_name":"电力仪表","create_time":1516245985000,"monitor_equipment_id":7,"electric_motor_id":13,"channel":"C1","brand_name":"安科瑞","monitor_equipment_installation_time":"2018-01-18","monitor_equipment_name":"电力仪表","equipment_classification_id":19,"brand_id":35,"series_id":25,"slave":"B1","equipment_type_id":23,"gateway_device_id":10,"update_time":1516246205000,"model_number_id":95,"series_name":"AMC16-E4","model_number_name":"AMC16-E4 5A","sn":"2-26001-171218-00004","status":1}
         * meter_info : {"electric_motor_name":"4b皮带机1电机","equipment_classification_name":"监测设备","equipment_type_name":"震动传感器","create_time":1520339179000,"monitor_equipment_id":26,"electric_motor_id":13,"channel":"0","brand_name":"杭江","monitor_equipment_installation_time":"2018-03-06","monitor_equipment_name":"震动传感器","equipment_classification_id":19,"brand_id":47,"series_id":35,"slave":"0","equipment_type_id":22,"gateway_device_id":0,"update_time":1520339231000,"model_number_id":96,"series_name":"HJ-9002","model_number_name":"HJ-9002","status":1}
         * whole_equipment_info : {"whole_equipment_id":24,"create_time":1516244521000,"whole_equipment_description":"要改","sort":0,"whole_equipment_type_description":"皮带机","organization_name":"供料车间","whole_equipment_type_id":3,"update_time":1520303447000,"whole_equipment_type_name":"皮带机","whole_equipment_name":"4B皮带机1","organization_id":51,"whole_equipment_location":"4B配电室","status":1}
         * motor_info : {"cooling_way_name":"IC411","smart_switch_id":31,"q30_alarm":100,"kbz":0.65,"q5_alarm":100,"electric_motor_name":"4b皮带机1电机","rated_current":167,"installation_id":9,"installation_year":"2010.02.06","equipment_type_id":24,"filter_equipment_id":5,"energy_efficiency_grade_id":4,"pole_number_id":2,"zd_alarm":4.5,"kkz":0.15,"pole_number_name":"4","rated_voltage_name":"380V","equipment_type_name":"三相异步电机","create_time":1516245114000,"rated_speed_name":"1500","control_equipment_name":"直接启动","brand_name":"湘潭电机厂","organization_name":"供料车间","sort":0,"energy_efficiency_grade_name":"普通能效","stn":5,"io_alarm":110,"brand_id":38,"electric_instrument_id":7,"filter_equipment_name":"滤波器","control_equipment_id":16,"cooling_way_id":8,"whole_equipment_name":"4b皮带机1","organization_id":51,"monitor_instrument_name":"震动传感器","electric_motor_description":"要改","status":1,"smart_switch_name":"智能开关","rated_efficiency":0.942,"update_time":1520402547000,"model_number_id":70,"installation_name":"0","kqz":0.35,"series_name":"Y2","model_number_name":"Y2-280M-4 ","rated_speed_id":10,"rated_noload_loss":1.995,"whole_equipment_id":24,"tkz":10,"rated_power":90,"electric_instrument_name":"电力仪表","electric_motor_id":13,"tem_alarm":65,"kzz":0.95,"series_id":15,"rated_voltage_id":2,"monitor_instrument_id":26}
         * apf_pfc_info : {"electric_motor_name":"4b皮带机1电机","equipment_classification_name":"滤波补偿设备","equipment_type_name":"滤波器","create_time":1520402163000,"electric_motor_id":13,"channel":"0","brand_name":"智光","equipment_classification_id":20,"brand_id":42,"series_id":27,"slave":"0","equipment_type_id":20,"gateway_device_id":0,"update_time":1520402163000,"model_number_id":82,"filter_compensation_description":"其它","filter_compensation_name":"滤波器","series_name":"ZG-dSVC","model_number_name":"ZG-dSVC-3MVar","filter_compensation_id":5,"status":1}
         * control_machine_info : {"equipment_type_id":4,"update_time":1516246135000,"electric_motor_name":"4b皮带机1电机","equipment_classification_name":"控制设备","control_equipment_id":16,"equipment_type_name":"直接启动","create_time":1516246135000,"control_equipment_name":"直接启动","electric_motor_id":13,"sort":0,"equipment_classification_id":18,"status":1}
         */

        private SmartSwitchInfoBean smart_switch_info;
        private ElectricInstrumentInfoBean electric_instrument_info;
        private MeterInfoBean meter_info;
        private WholeEquipmentInfoBean whole_equipment_info;
        private MotorInfoBean motor_info;
        private ApfPfcInfoBean apf_pfc_info;
        private ControlMachineInfoBean control_machine_info;

        public SmartSwitchInfoBean getSmart_switch_info() {
            return smart_switch_info;
        }

        public void setSmart_switch_info(SmartSwitchInfoBean smart_switch_info) {
            this.smart_switch_info = smart_switch_info;
        }

        public ElectricInstrumentInfoBean getElectric_instrument_info() {
            return electric_instrument_info;
        }

        public void setElectric_instrument_info(ElectricInstrumentInfoBean electric_instrument_info) {
            this.electric_instrument_info = electric_instrument_info;
        }

        public MeterInfoBean getMeter_info() {
            return meter_info;
        }

        public void setMeter_info(MeterInfoBean meter_info) {
            this.meter_info = meter_info;
        }

        public WholeEquipmentInfoBean getWhole_equipment_info() {
            return whole_equipment_info;
        }

        public void setWhole_equipment_info(WholeEquipmentInfoBean whole_equipment_info) {
            this.whole_equipment_info = whole_equipment_info;
        }

        public MotorInfoBean getMotor_info() {
            return motor_info;
        }

        public void setMotor_info(MotorInfoBean motor_info) {
            this.motor_info = motor_info;
        }

        public ApfPfcInfoBean getApf_pfc_info() {
            return apf_pfc_info;
        }

        public void setApf_pfc_info(ApfPfcInfoBean apf_pfc_info) {
            this.apf_pfc_info = apf_pfc_info;
        }

        public ControlMachineInfoBean getControl_machine_info() {
            return control_machine_info;
        }

        public void setControl_machine_info(ControlMachineInfoBean control_machine_info) {
            this.control_machine_info = control_machine_info;
        }

        public static class SmartSwitchInfoBean implements Serializable{
            /**
             * electric_motor_name : 4#炉粒化器水泵电机
             * rated_current : 150
             * channel : C4
             * monitor_equipment_description : 4号智能开关备注
             * slave : B4
             * equipment_type_id : 28
             * update_time : 1520486347000
             * model_number_id : 91
             * series_name : ZNKK
             * model_number_name : ZZKK-150
             * sn : 2-26001-171218-00005
             * equipment_classification_name : 监测设备
             * rated_voltage_name : 380V
             * equipment_type_name : 智能开关
             * create_time : 1520486347000
             * monitor_equipment_id : 32
             * electric_motor_id : 6
             * brand_name : 施耐德
             * monitor_equipment_installation_time : 2018-03-08
             * monitor_equipment_name : 智能开关
             * equipment_classification_id : 19
             * brand_id : 46
             * series_id : 32
             * gateway_device_id : 11
             * rated_voltage_id : 2
             * status : 1
             */

            private String electric_motor_name;
            private int rated_current;
            private String channel;
            private String monitor_equipment_description;
            private String slave;
            private int equipment_type_id;
            private long update_time;
            private int model_number_id;
            private String series_name;
            private String model_number_name;
            private String sn;
            private String equipment_classification_name;
            private String rated_voltage_name;
            private String equipment_type_name;
            private long create_time;
            private int monitor_equipment_id;
            private int electric_motor_id;
            private String brand_name;
            private String monitor_equipment_installation_time;
            private String monitor_equipment_name;
            private int equipment_classification_id;
            private int brand_id;
            private int series_id;
            private int gateway_device_id;
            private int rated_voltage_id;
            private int status;

            public String getElectric_motor_name() {
                return electric_motor_name;
            }

            public void setElectric_motor_name(String electric_motor_name) {
                this.electric_motor_name = electric_motor_name;
            }

            public int getRated_current() {
                return rated_current;
            }

            public void setRated_current(int rated_current) {
                this.rated_current = rated_current;
            }

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public String getMonitor_equipment_description() {
                return monitor_equipment_description;
            }

            public void setMonitor_equipment_description(String monitor_equipment_description) {
                this.monitor_equipment_description = monitor_equipment_description;
            }

            public String getSlave() {
                return slave;
            }

            public void setSlave(String slave) {
                this.slave = slave;
            }

            public int getEquipment_type_id() {
                return equipment_type_id;
            }

            public void setEquipment_type_id(int equipment_type_id) {
                this.equipment_type_id = equipment_type_id;
            }

            public long getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(long update_time) {
                this.update_time = update_time;
            }

            public int getModel_number_id() {
                return model_number_id;
            }

            public void setModel_number_id(int model_number_id) {
                this.model_number_id = model_number_id;
            }

            public String getSeries_name() {
                return series_name;
            }

            public void setSeries_name(String series_name) {
                this.series_name = series_name;
            }

            public String getModel_number_name() {
                return model_number_name;
            }

            public void setModel_number_name(String model_number_name) {
                this.model_number_name = model_number_name;
            }

            public String getSn() {
                return sn;
            }

            public void setSn(String sn) {
                this.sn = sn;
            }

            public String getEquipment_classification_name() {
                return equipment_classification_name;
            }

            public void setEquipment_classification_name(String equipment_classification_name) {
                this.equipment_classification_name = equipment_classification_name;
            }

            public String getRated_voltage_name() {
                return rated_voltage_name;
            }

            public void setRated_voltage_name(String rated_voltage_name) {
                this.rated_voltage_name = rated_voltage_name;
            }

            public String getEquipment_type_name() {
                return equipment_type_name;
            }

            public void setEquipment_type_name(String equipment_type_name) {
                this.equipment_type_name = equipment_type_name;
            }

            public long getCreate_time() {
                return create_time;
            }

            public void setCreate_time(long create_time) {
                this.create_time = create_time;
            }

            public int getMonitor_equipment_id() {
                return monitor_equipment_id;
            }

            public void setMonitor_equipment_id(int monitor_equipment_id) {
                this.monitor_equipment_id = monitor_equipment_id;
            }

            public int getElectric_motor_id() {
                return electric_motor_id;
            }

            public void setElectric_motor_id(int electric_motor_id) {
                this.electric_motor_id = electric_motor_id;
            }

            public String getBrand_name() {
                return brand_name;
            }

            public void setBrand_name(String brand_name) {
                this.brand_name = brand_name;
            }

            public String getMonitor_equipment_installation_time() {
                return monitor_equipment_installation_time;
            }

            public void setMonitor_equipment_installation_time(String monitor_equipment_installation_time) {
                this.monitor_equipment_installation_time = monitor_equipment_installation_time;
            }

            public String getMonitor_equipment_name() {
                return monitor_equipment_name;
            }

            public void setMonitor_equipment_name(String monitor_equipment_name) {
                this.monitor_equipment_name = monitor_equipment_name;
            }

            public int getEquipment_classification_id() {
                return equipment_classification_id;
            }

            public void setEquipment_classification_id(int equipment_classification_id) {
                this.equipment_classification_id = equipment_classification_id;
            }

            public int getBrand_id() {
                return brand_id;
            }

            public void setBrand_id(int brand_id) {
                this.brand_id = brand_id;
            }

            public int getSeries_id() {
                return series_id;
            }

            public void setSeries_id(int series_id) {
                this.series_id = series_id;
            }

            public int getGateway_device_id() {
                return gateway_device_id;
            }

            public void setGateway_device_id(int gateway_device_id) {
                this.gateway_device_id = gateway_device_id;
            }

            public int getRated_voltage_id() {
                return rated_voltage_id;
            }

            public void setRated_voltage_id(int rated_voltage_id) {
                this.rated_voltage_id = rated_voltage_id;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }

        public static class ElectricInstrumentInfoBean implements Serializable{
            /**
             * electric_motor_name : 4#炉粒化器水泵电机
             * equipment_classification_name : 监测设备
             * equipment_type_name : 电力仪表
             * create_time : 1520486387000
             * monitor_equipment_id : 33
             * electric_motor_id : 6
             * channel : C4
             * loop_mark : 3
             * brand_name : 安科瑞
             * monitor_equipment_description : 4号电力仪表备注
             * monitor_equipment_installation_time : 2018-03-08
             * monitor_equipment_name : 电力仪表
             * equipment_classification_id : 19
             * brand_id : 35
             * series_id : 25
             * slave : B5
             * equipment_type_id : 23
             * gateway_device_id : 11
             * update_time : 1520486387000
             * model_number_id : 95
             * series_name : AMC16-E4
             * model_number_name : AMC16-E4 5A
             * sn : 2-26001-171218-00005
             * status : 1
             */

            private String electric_motor_name;
            private String equipment_classification_name;
            private String equipment_type_name;
            private long create_time;
            private int monitor_equipment_id;
            private int electric_motor_id;
            private String channel;
            private String loop_mark;
            private String brand_name;
            private String monitor_equipment_description;
            private String monitor_equipment_installation_time;
            private String monitor_equipment_name;
            private int equipment_classification_id;
            private int brand_id;
            private int series_id;
            private String slave;
            private int equipment_type_id;
            private int gateway_device_id;
            private long update_time;
            private int model_number_id;
            private String series_name;
            private String model_number_name;
            private String sn;
            private int status;

            public String getElectric_motor_name() {
                return electric_motor_name;
            }

            public void setElectric_motor_name(String electric_motor_name) {
                this.electric_motor_name = electric_motor_name;
            }

            public String getEquipment_classification_name() {
                return equipment_classification_name;
            }

            public void setEquipment_classification_name(String equipment_classification_name) {
                this.equipment_classification_name = equipment_classification_name;
            }

            public String getEquipment_type_name() {
                return equipment_type_name;
            }

            public void setEquipment_type_name(String equipment_type_name) {
                this.equipment_type_name = equipment_type_name;
            }

            public long getCreate_time() {
                return create_time;
            }

            public void setCreate_time(long create_time) {
                this.create_time = create_time;
            }

            public int getMonitor_equipment_id() {
                return monitor_equipment_id;
            }

            public void setMonitor_equipment_id(int monitor_equipment_id) {
                this.monitor_equipment_id = monitor_equipment_id;
            }

            public int getElectric_motor_id() {
                return electric_motor_id;
            }

            public void setElectric_motor_id(int electric_motor_id) {
                this.electric_motor_id = electric_motor_id;
            }

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public String getLoop_mark() {
                return loop_mark;
            }

            public void setLoop_mark(String loop_mark) {
                this.loop_mark = loop_mark;
            }

            public String getBrand_name() {
                return brand_name;
            }

            public void setBrand_name(String brand_name) {
                this.brand_name = brand_name;
            }

            public String getMonitor_equipment_description() {
                return monitor_equipment_description;
            }

            public void setMonitor_equipment_description(String monitor_equipment_description) {
                this.monitor_equipment_description = monitor_equipment_description;
            }

            public String getMonitor_equipment_installation_time() {
                return monitor_equipment_installation_time;
            }

            public void setMonitor_equipment_installation_time(String monitor_equipment_installation_time) {
                this.monitor_equipment_installation_time = monitor_equipment_installation_time;
            }

            public String getMonitor_equipment_name() {
                return monitor_equipment_name;
            }

            public void setMonitor_equipment_name(String monitor_equipment_name) {
                this.monitor_equipment_name = monitor_equipment_name;
            }

            public int getEquipment_classification_id() {
                return equipment_classification_id;
            }

            public void setEquipment_classification_id(int equipment_classification_id) {
                this.equipment_classification_id = equipment_classification_id;
            }

            public int getBrand_id() {
                return brand_id;
            }

            public void setBrand_id(int brand_id) {
                this.brand_id = brand_id;
            }

            public int getSeries_id() {
                return series_id;
            }

            public void setSeries_id(int series_id) {
                this.series_id = series_id;
            }

            public String getSlave() {
                return slave;
            }

            public void setSlave(String slave) {
                this.slave = slave;
            }

            public int getEquipment_type_id() {
                return equipment_type_id;
            }

            public void setEquipment_type_id(int equipment_type_id) {
                this.equipment_type_id = equipment_type_id;
            }

            public int getGateway_device_id() {
                return gateway_device_id;
            }

            public void setGateway_device_id(int gateway_device_id) {
                this.gateway_device_id = gateway_device_id;
            }

            public long getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(long update_time) {
                this.update_time = update_time;
            }

            public int getModel_number_id() {
                return model_number_id;
            }

            public void setModel_number_id(int model_number_id) {
                this.model_number_id = model_number_id;
            }

            public String getSeries_name() {
                return series_name;
            }

            public void setSeries_name(String series_name) {
                this.series_name = series_name;
            }

            public String getModel_number_name() {
                return model_number_name;
            }

            public void setModel_number_name(String model_number_name) {
                this.model_number_name = model_number_name;
            }

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
        }

        public static class MeterInfoBean implements Serializable{
            /**
             * electric_motor_name : 4#炉粒化器水泵电机
             * equipment_classification_name : 监测设备
             * equipment_type_name : 温度传感器
             * create_time : 1520486419000
             * monitor_equipment_id : 34
             * electric_motor_id : 6
             * channel : C4
             * brand_name : 杭江
             * monitor_equipment_description : 4号温度备注
             * monitor_equipment_installation_time : 2018-03-08
             * monitor_equipment_name : 温度传感器
             * equipment_classification_id : 19
             * brand_id : 47
             * series_id : 36
             * slave : B6
             * equipment_type_id : 21
             * gateway_device_id : 11
             * update_time : 1520486419000
             * model_number_id : 97
             * series_name : HJ-w-01
             * model_number_name : HJ-w-01
             * sn : 2-26001-171218-00005
             * status : 1
             */

            private String electric_motor_name;
            private String equipment_classification_name;
            private String equipment_type_name;
            private long create_time;
            private int monitor_equipment_id;
            private int electric_motor_id;
            private String channel;
            private String brand_name;
            private String monitor_equipment_description;
            private String monitor_equipment_installation_time;
            private String monitor_equipment_name;
            private int equipment_classification_id;
            private int brand_id;
            private int series_id;
            private String slave;
            private int equipment_type_id;
            private int gateway_device_id;
            private long update_time;
            private int model_number_id;
            private String series_name;
            private String model_number_name;
            private String sn;
            private int status;

            public String getElectric_motor_name() {
                return electric_motor_name;
            }

            public void setElectric_motor_name(String electric_motor_name) {
                this.electric_motor_name = electric_motor_name;
            }

            public String getEquipment_classification_name() {
                return equipment_classification_name;
            }

            public void setEquipment_classification_name(String equipment_classification_name) {
                this.equipment_classification_name = equipment_classification_name;
            }

            public String getEquipment_type_name() {
                return equipment_type_name;
            }

            public void setEquipment_type_name(String equipment_type_name) {
                this.equipment_type_name = equipment_type_name;
            }

            public long getCreate_time() {
                return create_time;
            }

            public void setCreate_time(long create_time) {
                this.create_time = create_time;
            }

            public int getMonitor_equipment_id() {
                return monitor_equipment_id;
            }

            public void setMonitor_equipment_id(int monitor_equipment_id) {
                this.monitor_equipment_id = monitor_equipment_id;
            }

            public int getElectric_motor_id() {
                return electric_motor_id;
            }

            public void setElectric_motor_id(int electric_motor_id) {
                this.electric_motor_id = electric_motor_id;
            }

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public String getBrand_name() {
                return brand_name;
            }

            public void setBrand_name(String brand_name) {
                this.brand_name = brand_name;
            }

            public String getMonitor_equipment_description() {
                return monitor_equipment_description;
            }

            public void setMonitor_equipment_description(String monitor_equipment_description) {
                this.monitor_equipment_description = monitor_equipment_description;
            }

            public String getMonitor_equipment_installation_time() {
                return monitor_equipment_installation_time;
            }

            public void setMonitor_equipment_installation_time(String monitor_equipment_installation_time) {
                this.monitor_equipment_installation_time = monitor_equipment_installation_time;
            }

            public String getMonitor_equipment_name() {
                return monitor_equipment_name;
            }

            public void setMonitor_equipment_name(String monitor_equipment_name) {
                this.monitor_equipment_name = monitor_equipment_name;
            }

            public int getEquipment_classification_id() {
                return equipment_classification_id;
            }

            public void setEquipment_classification_id(int equipment_classification_id) {
                this.equipment_classification_id = equipment_classification_id;
            }

            public int getBrand_id() {
                return brand_id;
            }

            public void setBrand_id(int brand_id) {
                this.brand_id = brand_id;
            }

            public int getSeries_id() {
                return series_id;
            }

            public void setSeries_id(int series_id) {
                this.series_id = series_id;
            }

            public String getSlave() {
                return slave;
            }

            public void setSlave(String slave) {
                this.slave = slave;
            }

            public int getEquipment_type_id() {
                return equipment_type_id;
            }

            public void setEquipment_type_id(int equipment_type_id) {
                this.equipment_type_id = equipment_type_id;
            }

            public int getGateway_device_id() {
                return gateway_device_id;
            }

            public void setGateway_device_id(int gateway_device_id) {
                this.gateway_device_id = gateway_device_id;
            }

            public long getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(long update_time) {
                this.update_time = update_time;
            }

            public int getModel_number_id() {
                return model_number_id;
            }

            public void setModel_number_id(int model_number_id) {
                this.model_number_id = model_number_id;
            }

            public String getSeries_name() {
                return series_name;
            }

            public void setSeries_name(String series_name) {
                this.series_name = series_name;
            }

            public String getModel_number_name() {
                return model_number_name;
            }

            public void setModel_number_name(String model_number_name) {
                this.model_number_name = model_number_name;
            }

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
        }

        public static class WholeEquipmentInfoBean implements Serializable {
            /**
             * whole_equipment_id : 24
             * create_time : 1516244521000
             * whole_equipment_description : 要改
             * sort : 0
             * whole_equipment_type_description : 皮带机
             * organization_name : 供料车间
             * whole_equipment_type_id : 3
             * update_time : 1520303447000
             * whole_equipment_type_name : 皮带机
             * whole_equipment_name : 4B皮带机1
             * organization_id : 51
             * whole_equipment_location : 4B配电室
             * status : 1
             */

            private int whole_equipment_id;
            private long create_time;
            private String whole_equipment_description;
            private int sort;
            private String whole_equipment_type_description;
            private String organization_name;
            private int whole_equipment_type_id;
            private long update_time;
            private String whole_equipment_type_name;
            private String whole_equipment_name;
            private int organization_id;
            private String whole_equipment_location;
            private int status;

            public int getWhole_equipment_id() {
                return whole_equipment_id;
            }

            public void setWhole_equipment_id(int whole_equipment_id) {
                this.whole_equipment_id = whole_equipment_id;
            }

            public long getCreate_time() {
                return create_time;
            }

            public void setCreate_time(long create_time) {
                this.create_time = create_time;
            }

            public String getWhole_equipment_description() {
                return whole_equipment_description;
            }

            public void setWhole_equipment_description(String whole_equipment_description) {
                this.whole_equipment_description = whole_equipment_description;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getWhole_equipment_type_description() {
                return whole_equipment_type_description;
            }

            public void setWhole_equipment_type_description(String whole_equipment_type_description) {
                this.whole_equipment_type_description = whole_equipment_type_description;
            }

            public String getOrganization_name() {
                return organization_name;
            }

            public void setOrganization_name(String organization_name) {
                this.organization_name = organization_name;
            }

            public int getWhole_equipment_type_id() {
                return whole_equipment_type_id;
            }

            public void setWhole_equipment_type_id(int whole_equipment_type_id) {
                this.whole_equipment_type_id = whole_equipment_type_id;
            }

            public long getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(long update_time) {
                this.update_time = update_time;
            }

            public String getWhole_equipment_type_name() {
                return whole_equipment_type_name;
            }

            public void setWhole_equipment_type_name(String whole_equipment_type_name) {
                this.whole_equipment_type_name = whole_equipment_type_name;
            }

            public String getWhole_equipment_name() {
                return whole_equipment_name;
            }

            public void setWhole_equipment_name(String whole_equipment_name) {
                this.whole_equipment_name = whole_equipment_name;
            }

            public int getOrganization_id() {
                return organization_id;
            }

            public void setOrganization_id(int organization_id) {
                this.organization_id = organization_id;
            }

            public String getWhole_equipment_location() {
                return whole_equipment_location;
            }

            public void setWhole_equipment_location(String whole_equipment_location) {
                this.whole_equipment_location = whole_equipment_location;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }

        public static class MotorInfoBean implements Serializable {
            /**
             * cooling_way_name : IC411
             * smart_switch_id : 31
             * q30_alarm : 100
             * kbz : 0.65
             * q5_alarm : 100
             * electric_motor_name : 4b皮带机1电机
             * rated_current : 167
             * installation_id : 9
             * installation_year : 2010.02.06
             * equipment_type_id : 24
             * filter_equipment_id : 5
             * energy_efficiency_grade_id : 4
             * pole_number_id : 2
             * zd_alarm : 4.5
             * kkz : 0.15
             * pole_number_name : 4
             * rated_voltage_name : 380V
             * equipment_type_name : 三相异步电机
             * create_time : 1516245114000
             * rated_speed_name : 1500
             * control_equipment_name : 直接启动
             * brand_name : 湘潭电机厂
             * organization_name : 供料车间
             * sort : 0
             * energy_efficiency_grade_name : 普通能效
             * stn : 5
             * io_alarm : 110
             * brand_id : 38
             * electric_instrument_id : 7
             * filter_equipment_name : 滤波器
             * control_equipment_id : 16
             * cooling_way_id : 8
             * whole_equipment_name : 4b皮带机1
             * organization_id : 51
             * monitor_instrument_name : 震动传感器
             * electric_motor_description : 要改
             * status : 1
             * smart_switch_name : 智能开关
             * rated_efficiency : 0.942
             * update_time : 1520402547000
             * model_number_id : 70
             * installation_name : 0
             * kqz : 0.35
             * series_name : Y2
             * model_number_name : Y2-280M-4
             * rated_speed_id : 10
             * rated_noload_loss : 1.995
             * whole_equipment_id : 24
             * tkz : 10
             * rated_power : 90
             * electric_instrument_name : 电力仪表
             * electric_motor_id : 13
             * tem_alarm : 65
             * kzz : 0.95
             * series_id : 15
             * rated_voltage_id : 2
             * monitor_instrument_id : 26
             */

            private String cooling_way_name;
            private int smart_switch_id;
            private int q30_alarm;
            private double kbz;
            private int q5_alarm;
            private String electric_motor_name;
            private double rated_current;
            private int installation_id;
            private String installation_year;
            private int equipment_type_id;
            private int filter_equipment_id;
            private int energy_efficiency_grade_id;
            private int pole_number_id;
            private double zd_alarm;
            private double kkz;
            private String pole_number_name;
            private String rated_voltage_name;
            private String equipment_type_name;
            private long create_time;
            private String rated_speed_name;
            private String control_equipment_name;
            private String brand_name;
            private String organization_name;
            private int sort;
            private String energy_efficiency_grade_name;
            private int stn;
            private int io_alarm;
            private int brand_id;
            private int electric_instrument_id;
            private String filter_equipment_name;
            private int control_equipment_id;
            private int cooling_way_id;
            private String whole_equipment_name;
            private int organization_id;
            private String monitor_instrument_name;
            private String electric_motor_description;
            private int status;
            private String smart_switch_name;
            private double rated_efficiency;
            private long update_time;
            private int model_number_id;
            private String installation_name;
            private double kqz;
            private String series_name;
            private String model_number_name;
            private int rated_speed_id;
            private double rated_noload_loss;
            private int whole_equipment_id;
            private int tkz;
            private double rated_power;
            private String electric_instrument_name;
            private int electric_motor_id;
            private int tem_alarm;
            private double kzz;
            private int series_id;
            private int rated_voltage_id;
            private int monitor_instrument_id;

            public String getCooling_way_name() {
                return cooling_way_name;
            }

            public void setCooling_way_name(String cooling_way_name) {
                this.cooling_way_name = cooling_way_name;
            }

            public int getSmart_switch_id() {
                return smart_switch_id;
            }

            public void setSmart_switch_id(int smart_switch_id) {
                this.smart_switch_id = smart_switch_id;
            }

            public int getQ30_alarm() {
                return q30_alarm;
            }

            public void setQ30_alarm(int q30_alarm) {
                this.q30_alarm = q30_alarm;
            }

            public double getKbz() {
                return kbz;
            }

            public void setKbz(double kbz) {
                this.kbz = kbz;
            }

            public int getQ5_alarm() {
                return q5_alarm;
            }

            public void setQ5_alarm(int q5_alarm) {
                this.q5_alarm = q5_alarm;
            }

            public String getElectric_motor_name() {
                return electric_motor_name;
            }

            public void setElectric_motor_name(String electric_motor_name) {
                this.electric_motor_name = electric_motor_name;
            }

            public double getRated_current() {
                return rated_current;
            }

            public void setRated_current(double rated_current) {
                this.rated_current = rated_current;
            }

            public int getInstallation_id() {
                return installation_id;
            }

            public void setInstallation_id(int installation_id) {
                this.installation_id = installation_id;
            }

            public String getInstallation_year() {
                return installation_year;
            }

            public void setInstallation_year(String installation_year) {
                this.installation_year = installation_year;
            }

            public int getEquipment_type_id() {
                return equipment_type_id;
            }

            public void setEquipment_type_id(int equipment_type_id) {
                this.equipment_type_id = equipment_type_id;
            }

            public int getFilter_equipment_id() {
                return filter_equipment_id;
            }

            public void setFilter_equipment_id(int filter_equipment_id) {
                this.filter_equipment_id = filter_equipment_id;
            }

            public int getEnergy_efficiency_grade_id() {
                return energy_efficiency_grade_id;
            }

            public void setEnergy_efficiency_grade_id(int energy_efficiency_grade_id) {
                this.energy_efficiency_grade_id = energy_efficiency_grade_id;
            }

            public int getPole_number_id() {
                return pole_number_id;
            }

            public void setPole_number_id(int pole_number_id) {
                this.pole_number_id = pole_number_id;
            }

            public double getZd_alarm() {
                return zd_alarm;
            }

            public void setZd_alarm(double zd_alarm) {
                this.zd_alarm = zd_alarm;
            }

            public double getKkz() {
                return kkz;
            }

            public void setKkz(double kkz) {
                this.kkz = kkz;
            }

            public String getPole_number_name() {
                return pole_number_name;
            }

            public void setPole_number_name(String pole_number_name) {
                this.pole_number_name = pole_number_name;
            }

            public String getRated_voltage_name() {
                return rated_voltage_name;
            }

            public void setRated_voltage_name(String rated_voltage_name) {
                this.rated_voltage_name = rated_voltage_name;
            }

            public String getEquipment_type_name() {
                return equipment_type_name;
            }

            public void setEquipment_type_name(String equipment_type_name) {
                this.equipment_type_name = equipment_type_name;
            }

            public long getCreate_time() {
                return create_time;
            }

            public void setCreate_time(long create_time) {
                this.create_time = create_time;
            }

            public String getRated_speed_name() {
                return rated_speed_name;
            }

            public void setRated_speed_name(String rated_speed_name) {
                this.rated_speed_name = rated_speed_name;
            }

            public String getControl_equipment_name() {
                return control_equipment_name;
            }

            public void setControl_equipment_name(String control_equipment_name) {
                this.control_equipment_name = control_equipment_name;
            }

            public String getBrand_name() {
                return brand_name;
            }

            public void setBrand_name(String brand_name) {
                this.brand_name = brand_name;
            }

            public String getOrganization_name() {
                return organization_name;
            }

            public void setOrganization_name(String organization_name) {
                this.organization_name = organization_name;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getEnergy_efficiency_grade_name() {
                return energy_efficiency_grade_name;
            }

            public void setEnergy_efficiency_grade_name(String energy_efficiency_grade_name) {
                this.energy_efficiency_grade_name = energy_efficiency_grade_name;
            }

            public int getStn() {
                return stn;
            }

            public void setStn(int stn) {
                this.stn = stn;
            }

            public int getIo_alarm() {
                return io_alarm;
            }

            public void setIo_alarm(int io_alarm) {
                this.io_alarm = io_alarm;
            }

            public int getBrand_id() {
                return brand_id;
            }

            public void setBrand_id(int brand_id) {
                this.brand_id = brand_id;
            }

            public int getElectric_instrument_id() {
                return electric_instrument_id;
            }

            public void setElectric_instrument_id(int electric_instrument_id) {
                this.electric_instrument_id = electric_instrument_id;
            }

            public String getFilter_equipment_name() {
                return filter_equipment_name;
            }

            public void setFilter_equipment_name(String filter_equipment_name) {
                this.filter_equipment_name = filter_equipment_name;
            }

            public int getControl_equipment_id() {
                return control_equipment_id;
            }

            public void setControl_equipment_id(int control_equipment_id) {
                this.control_equipment_id = control_equipment_id;
            }

            public int getCooling_way_id() {
                return cooling_way_id;
            }

            public void setCooling_way_id(int cooling_way_id) {
                this.cooling_way_id = cooling_way_id;
            }

            public String getWhole_equipment_name() {
                return whole_equipment_name;
            }

            public void setWhole_equipment_name(String whole_equipment_name) {
                this.whole_equipment_name = whole_equipment_name;
            }

            public int getOrganization_id() {
                return organization_id;
            }

            public void setOrganization_id(int organization_id) {
                this.organization_id = organization_id;
            }

            public String getMonitor_instrument_name() {
                return monitor_instrument_name;
            }

            public void setMonitor_instrument_name(String monitor_instrument_name) {
                this.monitor_instrument_name = monitor_instrument_name;
            }

            public String getElectric_motor_description() {
                return electric_motor_description;
            }

            public void setElectric_motor_description(String electric_motor_description) {
                this.electric_motor_description = electric_motor_description;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getSmart_switch_name() {
                return smart_switch_name;
            }

            public void setSmart_switch_name(String smart_switch_name) {
                this.smart_switch_name = smart_switch_name;
            }

            public double getRated_efficiency() {
                return rated_efficiency;
            }

            public void setRated_efficiency(double rated_efficiency) {
                this.rated_efficiency = rated_efficiency;
            }

            public long getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(long update_time) {
                this.update_time = update_time;
            }

            public int getModel_number_id() {
                return model_number_id;
            }

            public void setModel_number_id(int model_number_id) {
                this.model_number_id = model_number_id;
            }

            public String getInstallation_name() {
                return installation_name;
            }

            public void setInstallation_name(String installation_name) {
                this.installation_name = installation_name;
            }

            public double getKqz() {
                return kqz;
            }

            public void setKqz(double kqz) {
                this.kqz = kqz;
            }

            public String getSeries_name() {
                return series_name;
            }

            public void setSeries_name(String series_name) {
                this.series_name = series_name;
            }

            public String getModel_number_name() {
                return model_number_name;
            }

            public void setModel_number_name(String model_number_name) {
                this.model_number_name = model_number_name;
            }

            public int getRated_speed_id() {
                return rated_speed_id;
            }

            public void setRated_speed_id(int rated_speed_id) {
                this.rated_speed_id = rated_speed_id;
            }

            public double getRated_noload_loss() {
                return rated_noload_loss;
            }

            public void setRated_noload_loss(double rated_noload_loss) {
                this.rated_noload_loss = rated_noload_loss;
            }

            public int getWhole_equipment_id() {
                return whole_equipment_id;
            }

            public void setWhole_equipment_id(int whole_equipment_id) {
                this.whole_equipment_id = whole_equipment_id;
            }

            public int getTkz() {
                return tkz;
            }

            public void setTkz(int tkz) {
                this.tkz = tkz;
            }

            public double getRated_power() {
                return rated_power;
            }

            public void setRated_power(double rated_power) {
                this.rated_power = rated_power;
            }

            public String getElectric_instrument_name() {
                return electric_instrument_name;
            }

            public void setElectric_instrument_name(String electric_instrument_name) {
                this.electric_instrument_name = electric_instrument_name;
            }

            public int getElectric_motor_id() {
                return electric_motor_id;
            }

            public void setElectric_motor_id(int electric_motor_id) {
                this.electric_motor_id = electric_motor_id;
            }

            public int getTem_alarm() {
                return tem_alarm;
            }

            public void setTem_alarm(int tem_alarm) {
                this.tem_alarm = tem_alarm;
            }

            public double getKzz() {
                return kzz;
            }

            public void setKzz(double kzz) {
                this.kzz = kzz;
            }

            public int getSeries_id() {
                return series_id;
            }

            public void setSeries_id(int series_id) {
                this.series_id = series_id;
            }

            public int getRated_voltage_id() {
                return rated_voltage_id;
            }

            public void setRated_voltage_id(int rated_voltage_id) {
                this.rated_voltage_id = rated_voltage_id;
            }

            public int getMonitor_instrument_id() {
                return monitor_instrument_id;
            }

            public void setMonitor_instrument_id(int monitor_instrument_id) {
                this.monitor_instrument_id = monitor_instrument_id;
            }
        }

        public static class ApfPfcInfoBean implements Serializable{
            /**
             * electric_motor_name : 4#炉粒化器水泵电机
             * equipment_classification_name : 滤波补偿设备
             * equipment_type_name : 滤波器
             * create_time : 1520486461000
             * electric_motor_id : 6
             * channel : C4
             * brand_name : 智光
             * equipment_classification_id : 20
             * brand_id : 42
             * series_id : 27
             * slave : B7
             * equipment_type_id : 20
             * gateway_device_id : 11
             * update_time : 1520486461000
             * model_number_id : 83
             * filter_compensation_description : 4号滤波备注
             * filter_compensation_name : 滤波器
             * series_name : ZG-dSVC
             * model_number_name : ZG-dSVC-5MVar
             * filter_compensation_id : 6
             * sn : 2-26001-171218-00005
             * status : 1
             */

            private String electric_motor_name;
            private String equipment_classification_name;
            private String equipment_type_name;
            private long create_time;
            private int electric_motor_id;
            private String channel;
            private String brand_name;
            private int equipment_classification_id;
            private int brand_id;
            private int series_id;
            private String slave;
            private int equipment_type_id;
            private int gateway_device_id;
            private long update_time;
            private int model_number_id;
            private String filter_compensation_description;
            private String filter_compensation_name;
            private String series_name;
            private String model_number_name;
            private int filter_compensation_id;
            private String sn;
            private int status;

            public String getElectric_motor_name() {
                return electric_motor_name;
            }

            public void setElectric_motor_name(String electric_motor_name) {
                this.electric_motor_name = electric_motor_name;
            }

            public String getEquipment_classification_name() {
                return equipment_classification_name;
            }

            public void setEquipment_classification_name(String equipment_classification_name) {
                this.equipment_classification_name = equipment_classification_name;
            }

            public String getEquipment_type_name() {
                return equipment_type_name;
            }

            public void setEquipment_type_name(String equipment_type_name) {
                this.equipment_type_name = equipment_type_name;
            }

            public long getCreate_time() {
                return create_time;
            }

            public void setCreate_time(long create_time) {
                this.create_time = create_time;
            }

            public int getElectric_motor_id() {
                return electric_motor_id;
            }

            public void setElectric_motor_id(int electric_motor_id) {
                this.electric_motor_id = electric_motor_id;
            }

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public String getBrand_name() {
                return brand_name;
            }

            public void setBrand_name(String brand_name) {
                this.brand_name = brand_name;
            }

            public int getEquipment_classification_id() {
                return equipment_classification_id;
            }

            public void setEquipment_classification_id(int equipment_classification_id) {
                this.equipment_classification_id = equipment_classification_id;
            }

            public int getBrand_id() {
                return brand_id;
            }

            public void setBrand_id(int brand_id) {
                this.brand_id = brand_id;
            }

            public int getSeries_id() {
                return series_id;
            }

            public void setSeries_id(int series_id) {
                this.series_id = series_id;
            }

            public String getSlave() {
                return slave;
            }

            public void setSlave(String slave) {
                this.slave = slave;
            }

            public int getEquipment_type_id() {
                return equipment_type_id;
            }

            public void setEquipment_type_id(int equipment_type_id) {
                this.equipment_type_id = equipment_type_id;
            }

            public int getGateway_device_id() {
                return gateway_device_id;
            }

            public void setGateway_device_id(int gateway_device_id) {
                this.gateway_device_id = gateway_device_id;
            }

            public long getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(long update_time) {
                this.update_time = update_time;
            }

            public int getModel_number_id() {
                return model_number_id;
            }

            public void setModel_number_id(int model_number_id) {
                this.model_number_id = model_number_id;
            }

            public String getFilter_compensation_description() {
                return filter_compensation_description;
            }

            public void setFilter_compensation_description(String filter_compensation_description) {
                this.filter_compensation_description = filter_compensation_description;
            }

            public String getFilter_compensation_name() {
                return filter_compensation_name;
            }

            public void setFilter_compensation_name(String filter_compensation_name) {
                this.filter_compensation_name = filter_compensation_name;
            }

            public String getSeries_name() {
                return series_name;
            }

            public void setSeries_name(String series_name) {
                this.series_name = series_name;
            }

            public String getModel_number_name() {
                return model_number_name;
            }

            public void setModel_number_name(String model_number_name) {
                this.model_number_name = model_number_name;
            }

            public int getFilter_compensation_id() {
                return filter_compensation_id;
            }

            public void setFilter_compensation_id(int filter_compensation_id) {
                this.filter_compensation_id = filter_compensation_id;
            }

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
        }

        public static class ControlMachineInfoBean implements Serializable {
            /**
             * electric_motor_name : 4#炉粒化器水泵电机
             * control_equipment_installation_time : 2017-02-15
             * control_mode_id : 8
             * output_voltage_class_id : 7
             * channel : C1
             * control_signal_name : 模拟量
             * control_mode_name : V/F控制
             * slave : B1
             * equipment_type_id : 17
             * update_time : 1518665123000
             * model_number_id : 74
             * series_name : Atv71
             * model_number_name : Atv71-90
             * bypass_scheme_name : 手动
             * sn : 2-23107-161214-00049_lpjiuyang
             * etavsd : 0.92
             * equipment_classification_name : 控制设备
             * rated_voltage_name : 380V
             * rated_power : 90
             * equipment_type_name : 变频器
             * create_time : 1514251368000
             * control_equipment_name : 变频器
             * electric_motor_id : 6
             * brand_name : 施耐德
             * output_voltage_class_name : 380V
             * sort : 0
             * equipment_classification_id : 18
             * brand_id : 33
             * series_id : 12
             * gateway_device_id : 6
             * control_equipment_description : 其它
             * rated_voltage_id : 2
             * control_equipment_id : 9
             * control_equipment_location : 其它
             * etah : 0.097
             * bypass_scheme_id : 1
             * control_signal_id : 3
             * status : 1
             */

            private String electric_motor_name;
            private String control_equipment_installation_time;
            private int control_mode_id;
            private int output_voltage_class_id;
            private String channel;
            private String control_signal_name;
            private String control_mode_name;
            private String slave;
            private int equipment_type_id;
            private long update_time;
            private int model_number_id;
            private String series_name;
            private String model_number_name;
            private String bypass_scheme_name;
            private String sn;
            private double etavsd;
            private String equipment_classification_name;
            private String rated_voltage_name;
            private double rated_power;
            private String equipment_type_name;
            private long create_time;
            private String control_equipment_name;
            private int electric_motor_id;
            private String brand_name;
            private String output_voltage_class_name;
            private int sort;
            private int equipment_classification_id;
            private int brand_id;
            private int series_id;
            private int gateway_device_id;
            private String control_equipment_description;
            private int rated_voltage_id;
            private int control_equipment_id;
            private String control_equipment_location;
            private double etah;
            private int bypass_scheme_id;
            private int control_signal_id;
            private int status;

            public String getElectric_motor_name() {
                return electric_motor_name;
            }

            public void setElectric_motor_name(String electric_motor_name) {
                this.electric_motor_name = electric_motor_name;
            }

            public String getControl_equipment_installation_time() {
                return control_equipment_installation_time;
            }

            public void setControl_equipment_installation_time(String control_equipment_installation_time) {
                this.control_equipment_installation_time = control_equipment_installation_time;
            }

            public int getControl_mode_id() {
                return control_mode_id;
            }

            public void setControl_mode_id(int control_mode_id) {
                this.control_mode_id = control_mode_id;
            }

            public int getOutput_voltage_class_id() {
                return output_voltage_class_id;
            }

            public void setOutput_voltage_class_id(int output_voltage_class_id) {
                this.output_voltage_class_id = output_voltage_class_id;
            }

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public String getControl_signal_name() {
                return control_signal_name;
            }

            public void setControl_signal_name(String control_signal_name) {
                this.control_signal_name = control_signal_name;
            }

            public String getControl_mode_name() {
                return control_mode_name;
            }

            public void setControl_mode_name(String control_mode_name) {
                this.control_mode_name = control_mode_name;
            }

            public String getSlave() {
                return slave;
            }

            public void setSlave(String slave) {
                this.slave = slave;
            }

            public int getEquipment_type_id() {
                return equipment_type_id;
            }

            public void setEquipment_type_id(int equipment_type_id) {
                this.equipment_type_id = equipment_type_id;
            }

            public long getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(long update_time) {
                this.update_time = update_time;
            }

            public int getModel_number_id() {
                return model_number_id;
            }

            public void setModel_number_id(int model_number_id) {
                this.model_number_id = model_number_id;
            }

            public String getSeries_name() {
                return series_name;
            }

            public void setSeries_name(String series_name) {
                this.series_name = series_name;
            }

            public String getModel_number_name() {
                return model_number_name;
            }

            public void setModel_number_name(String model_number_name) {
                this.model_number_name = model_number_name;
            }

            public String getBypass_scheme_name() {
                return bypass_scheme_name;
            }

            public void setBypass_scheme_name(String bypass_scheme_name) {
                this.bypass_scheme_name = bypass_scheme_name;
            }

            public String getSn() {
                return sn;
            }

            public void setSn(String sn) {
                this.sn = sn;
            }

            public double getEtavsd() {
                return etavsd;
            }

            public void setEtavsd(double etavsd) {
                this.etavsd = etavsd;
            }

            public String getEquipment_classification_name() {
                return equipment_classification_name;
            }

            public void setEquipment_classification_name(String equipment_classification_name) {
                this.equipment_classification_name = equipment_classification_name;
            }

            public String getRated_voltage_name() {
                return rated_voltage_name;
            }

            public void setRated_voltage_name(String rated_voltage_name) {
                this.rated_voltage_name = rated_voltage_name;
            }

            public double getRated_power() {
                return rated_power;
            }

            public void setRated_power(double rated_power) {
                this.rated_power = rated_power;
            }

            public String getEquipment_type_name() {
                return equipment_type_name;
            }

            public void setEquipment_type_name(String equipment_type_name) {
                this.equipment_type_name = equipment_type_name;
            }

            public long getCreate_time() {
                return create_time;
            }

            public void setCreate_time(long create_time) {
                this.create_time = create_time;
            }

            public String getControl_equipment_name() {
                return control_equipment_name;
            }

            public void setControl_equipment_name(String control_equipment_name) {
                this.control_equipment_name = control_equipment_name;
            }

            public int getElectric_motor_id() {
                return electric_motor_id;
            }

            public void setElectric_motor_id(int electric_motor_id) {
                this.electric_motor_id = electric_motor_id;
            }

            public String getBrand_name() {
                return brand_name;
            }

            public void setBrand_name(String brand_name) {
                this.brand_name = brand_name;
            }

            public String getOutput_voltage_class_name() {
                return output_voltage_class_name;
            }

            public void setOutput_voltage_class_name(String output_voltage_class_name) {
                this.output_voltage_class_name = output_voltage_class_name;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public int getEquipment_classification_id() {
                return equipment_classification_id;
            }

            public void setEquipment_classification_id(int equipment_classification_id) {
                this.equipment_classification_id = equipment_classification_id;
            }

            public int getBrand_id() {
                return brand_id;
            }

            public void setBrand_id(int brand_id) {
                this.brand_id = brand_id;
            }

            public int getSeries_id() {
                return series_id;
            }

            public void setSeries_id(int series_id) {
                this.series_id = series_id;
            }

            public int getGateway_device_id() {
                return gateway_device_id;
            }

            public void setGateway_device_id(int gateway_device_id) {
                this.gateway_device_id = gateway_device_id;
            }

            public String getControl_equipment_description() {
                return control_equipment_description;
            }

            public void setControl_equipment_description(String control_equipment_description) {
                this.control_equipment_description = control_equipment_description;
            }

            public int getRated_voltage_id() {
                return rated_voltage_id;
            }

            public void setRated_voltage_id(int rated_voltage_id) {
                this.rated_voltage_id = rated_voltage_id;
            }

            public int getControl_equipment_id() {
                return control_equipment_id;
            }

            public void setControl_equipment_id(int control_equipment_id) {
                this.control_equipment_id = control_equipment_id;
            }

            public String getControl_equipment_location() {
                return control_equipment_location;
            }

            public void setControl_equipment_location(String control_equipment_location) {
                this.control_equipment_location = control_equipment_location;
            }

            public double getEtah() {
                return etah;
            }

            public void setEtah(double etah) {
                this.etah = etah;
            }

            public int getBypass_scheme_id() {
                return bypass_scheme_id;
            }

            public void setBypass_scheme_id(int bypass_scheme_id) {
                this.bypass_scheme_id = bypass_scheme_id;
            }

            public int getControl_signal_id() {
                return control_signal_id;
            }

            public void setControl_signal_id(int control_signal_id) {
                this.control_signal_id = control_signal_id;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}
