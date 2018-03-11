package com.locensate.letnetwork.bean;

import java.io.Serializable;


/**
 * $String
 *
 * @author xiaobinghe
 */

public class MotorEfficiencyBaseEntity implements Serializable {


    /**
     * operCode : 1
     * data : {"power_consumption":897.6000000000006,"electrical_fee":673.2000000000005,"no_loading_power":0.012444444444444444,"estimate_save_power":0,"running_time":65209,"power_use_ratio":0.9367722399468019}
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

    public static class DataBean {
        /**
         * power_consumption : 897.6000000000006
         * electrical_fee : 673.2000000000005
         * no_loading_power : 0.012444444444444444
         * estimate_save_power : 0
         * running_time : 65209
         * power_use_ratio : 0.9367722399468019
         */

        private double power_consumption;
        private double electrical_fee;
        private double no_loading_power;
        private double estimate_save_power;
        private int running_time;
        private double power_use_ratio;

        public double getPower_consumption() {
            return power_consumption;
        }

        public void setPower_consumption(double power_consumption) {
            this.power_consumption = power_consumption;
        }

        public double getElectrical_fee() {
            return electrical_fee;
        }

        public void setElectrical_fee(double electrical_fee) {
            this.electrical_fee = electrical_fee;
        }

        public double getNo_loading_power() {
            return no_loading_power;
        }

        public void setNo_loading_power(double no_loading_power) {
            this.no_loading_power = no_loading_power;
        }

        public double getEstimate_save_power() {
            return estimate_save_power;
        }

        public void setEstimate_save_power(double estimate_save_power) {
            this.estimate_save_power = estimate_save_power;
        }

        public int getRunning_time() {
            return running_time;
        }

        public void setRunning_time(int running_time) {
            this.running_time = running_time;
        }

        public double getPower_use_ratio() {
            return power_use_ratio;
        }

        public void setPower_use_ratio(double power_use_ratio) {
            this.power_use_ratio = power_use_ratio;
        }
    }
}
