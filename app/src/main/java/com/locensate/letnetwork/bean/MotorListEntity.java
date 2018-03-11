package com.locensate.letnetwork.bean;

import java.io.Serializable;
import java.util.List;


/**
 * $String
 *
 * @author xiaobinghe
 */

public class MotorListEntity implements Serializable {

    /**
     * operCode : 1
     * data : {"motor_count":19,"power_count":2016.5,"list":[{"average _efficiency":0,"is_important":0,"motor_id":17,"is_measure":1,"rated_power":18.5,"organization":"供料车间","control_equipment_model":"直接启动","health_score":30,"name":"1B皮带机3电机","voltage_level":"380V","machine_name":"1B皮带机3"},{"average _efficiency":0.891841655638341,"is_important":0,"motor_id":18,"is_measure":1,"rated_power":37,"organization":"供料车间","control_equipment_model":"直接启动","health_score":30,"name":"1B皮带机4电机","voltage_level":"380V","machine_name":"1B皮带机4"},{"average _efficiency":0.9202028590752418,"is_important":0,"motor_id":16,"is_measure":1,"rated_power":37,"organization":"供料车间","control_equipment_model":"直接启动","health_score":30,"name":"1B皮带机2电机","voltage_level":"380V","machine_name":"1B皮带机2"},{"average _efficiency":0,"is_important":0,"motor_id":20,"is_measure":1,"rated_power":37,"organization":"供料车间","control_equipment_model":"直接启动","health_score":30,"name":"1B皮带机8","voltage_level":"380V","machine_name":"1B皮带机8"},{"average _efficiency":0.9089978640774378,"is_important":0,"motor_id":19,"is_measure":1,"rated_power":37,"organization":"供料车间","control_equipment_model":"直接启动","health_score":30,"name":"1B皮带机5电机","voltage_level":"380V","machine_name":"1B皮带机5"}]}
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
         * motor_count : 19
         * power_count : 2016.5
         * list : [{"average _efficiency":0,"is_important":0,"motor_id":17,"is_measure":1,"rated_power":18.5,"organization":"供料车间","control_equipment_model":"直接启动","health_score":30,"name":"1B皮带机3电机","voltage_level":"380V","machine_name":"1B皮带机3"},{"average _efficiency":0.891841655638341,"is_important":0,"motor_id":18,"is_measure":1,"rated_power":37,"organization":"供料车间","control_equipment_model":"直接启动","health_score":30,"name":"1B皮带机4电机","voltage_level":"380V","machine_name":"1B皮带机4"},{"average _efficiency":0.9202028590752418,"is_important":0,"motor_id":16,"is_measure":1,"rated_power":37,"organization":"供料车间","control_equipment_model":"直接启动","health_score":30,"name":"1B皮带机2电机","voltage_level":"380V","machine_name":"1B皮带机2"},{"average _efficiency":0,"is_important":0,"motor_id":20,"is_measure":1,"rated_power":37,"organization":"供料车间","control_equipment_model":"直接启动","health_score":30,"name":"1B皮带机8","voltage_level":"380V","machine_name":"1B皮带机8"},{"average _efficiency":0.9089978640774378,"is_important":0,"motor_id":19,"is_measure":1,"rated_power":37,"organization":"供料车间","control_equipment_model":"直接启动","health_score":30,"name":"1B皮带机5电机","voltage_level":"380V","machine_name":"1B皮带机5"}]
         */

        private int motor_count;
        private double power_count;
        private List<ListBean> list;

        public int getMotor_count() {
            return motor_count;
        }

        public void setMotor_count(int motor_count) {
            this.motor_count = motor_count;
        }

        public double getPower_count() {
            return power_count;
        }

        public void setPower_count(double power_count) {
            this.power_count = power_count;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable {

            private double average_efficiency;
            private int is_important;
            private long motor_id;
            private int is_measure;
            private double rated_power;
            private String organization;
            private String control_equipment_model;
            private double health_score;
            private String name;
            private String voltage_level;
            private String machine_name;

            public ListBean(double average_efficiency, int is_important, int motor_id, int is_measure, double rated_power, String organization, String control_equipment_model, double health_score, String name, String voltage_level, String machine_name) {
                this.average_efficiency = average_efficiency;
                this.is_important = is_important;
                this.motor_id = motor_id;
                this.is_measure = is_measure;
                this.rated_power = rated_power;
                this.organization = organization;
                this.control_equipment_model = control_equipment_model;
                this.health_score = health_score;
                this.name = name;
                this.voltage_level = voltage_level;
                this.machine_name = machine_name;
            }

            public double getAverage_efficiency() {
                return average_efficiency;
            }

            public void setAverage_efficiency(double average_efficiency) {
                this.average_efficiency = average_efficiency;
            }

            public int getIs_important() {
                return is_important;
            }

            public void setIs_important(int is_important) {
                this.is_important = is_important;
            }

            public long getMotor_id() {
                return motor_id;
            }

            public void setMotor_id(long motor_id) {
                this.motor_id = motor_id;
            }

            public int getIs_measure() {
                return is_measure;
            }

            public void setIs_measure(int is_measure) {
                this.is_measure = is_measure;
            }

            public double getRated_power() {
                return rated_power;
            }

            public void setRated_power(double rated_power) {
                this.rated_power = rated_power;
            }

            public String getOrganization() {
                return organization;
            }

            public void setOrganization(String organization) {
                this.organization = organization;
            }

            public String getControl_equipment_model() {
                return control_equipment_model;
            }

            public void setControl_equipment_model(String control_equipment_model) {
                this.control_equipment_model = control_equipment_model;
            }

            public double getHealth_score() {
                return health_score;
            }

            public void setHealth_score(double health_score) {
                this.health_score = health_score;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getVoltage_level() {
                return voltage_level;
            }

            public void setVoltage_level(String voltage_level) {
                this.voltage_level = voltage_level;
            }

            public String getMachine_name() {
                return machine_name;
            }

            public void setMachine_name(String machine_name) {
                this.machine_name = machine_name;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "average_efficiency=" + average_efficiency +
                        ", is_important=" + is_important +
                        ", motor_id=" + motor_id +
                        ", is_measure=" + is_measure +
                        ", rated_power=" + rated_power +
                        ", organization='" + organization + '\'' +
                        ", control_equipment_model='" + control_equipment_model + '\'' +
                        ", health_score=" + health_score +
                        ", name='" + name + '\'' +
                        ", voltage_level='" + voltage_level + '\'' +
                        ", machine_name='" + machine_name + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "motor_count=" + motor_count +
                    ", power_count=" + power_count +
                    ", list=" + list +
                    '}';
        }

    }

    @Override
    public String toString() {
        return "MotorListEntity{" +
                "operCode=" + operCode +
                ", data=" + data +
                '}';
    }
}
