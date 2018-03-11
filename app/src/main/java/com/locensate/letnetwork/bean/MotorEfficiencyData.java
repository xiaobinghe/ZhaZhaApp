package com.locensate.letnetwork.bean;

import java.io.Serializable;


/**
 * $String
 *
 * @author xiaobinghe
 */

public class MotorEfficiencyData implements Serializable {

    /**
     * operCode : 1
     * data : {"stop_time":224,"current_efficiency":0,"diseconomic_running_time":19291,"easonable_running_time":8490,"default_efficiency":0.942,"average_efficiency":0.9264156740161823,"economic_running_time":37204}
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

    public static class DataBean implements Serializable{
        /**
         * stop_time : 224
         * current_efficiency : 0.0
         * diseconomic_running_time : 19291
         * easonable_running_time : 8490
         * default_efficiency : 0.942
         * average_efficiency : 0.9264156740161823
         * economic_running_time : 37204
         */

        private long stop_time;
        private double current_efficiency;
        private long diseconomic_running_time;
        private long easonable_running_time;
        private double default_efficiency;
        private double average_efficiency;
        private long economic_running_time;

        public long getStop_time() {
            return stop_time;
        }

        public void setStop_time(long stop_time) {
            this.stop_time = stop_time;
        }

        public double getCurrent_efficiency() {
            return current_efficiency;
        }

        public void setCurrent_efficiency(double current_efficiency) {
            this.current_efficiency = current_efficiency;
        }

        public long getDiseconomic_running_time() {
            return diseconomic_running_time;
        }

        public void setDiseconomic_running_time(long diseconomic_running_time) {
            this.diseconomic_running_time = diseconomic_running_time;
        }

        public long getEasonable_running_time() {
            return easonable_running_time;
        }

        public void setEasonable_running_time(long easonable_running_time) {
            this.easonable_running_time = easonable_running_time;
        }

        public double getDefault_efficiency() {
            return default_efficiency;
        }

        public void setDefault_efficiency(double default_efficiency) {
            this.default_efficiency = default_efficiency;
        }

        public double getAverage_efficiency() {
            return average_efficiency;
        }

        public void setAverage_efficiency(double average_efficiency) {
            this.average_efficiency = average_efficiency;
        }

        public long getEconomic_running_time() {
            return economic_running_time;
        }

        public void setEconomic_running_time(long economic_running_time) {
            this.economic_running_time = economic_running_time;
        }
    }
}
