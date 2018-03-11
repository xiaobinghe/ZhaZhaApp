package com.locensate.letnetwork.bean;

import java.io.Serializable;


/**
 * $String
 *
 * @author xiaobinghe
 */

public class MotorEfficiencyLoadEntity implements Serializable {

    /**
     * operCode : 1
     * data : {"current_loading":0.6868019844162572,"heavy_loading_time":"0L","stop_time":"86398572L","over_loading_time":"0L","average_loading":0,"no_loading_time":"0L","light_loading_time":"1428L","half_load_time":"0L"}
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
         * current_loading : 0.6868019844162572
         * heavy_loading_time : 0L
         * stop_time : 86398572L
         * over_loading_time : 0L
         * average_loading : 0.0
         * no_loading_time : 0L
         * light_loading_time : 1428L
         * half_load_time : 0L
         */

        private double current_loading;
        private long heavy_loading_time;
        private long stop_time;
        private long over_loading_time;
        private double average_loading;
        private long no_loading_time;
        private long light_loading_time;
        private long half_load_time;

        public double getCurrent_loading() {
            return current_loading;
        }

        public void setCurrent_loading(double current_loading) {
            this.current_loading = current_loading;
        }

        public long getHeavy_loading_time() {
            return heavy_loading_time;
        }

        public void setHeavy_loading_time(long heavy_loading_time) {
            this.heavy_loading_time = heavy_loading_time;
        }

        public long getStop_time() {
            return stop_time;
        }

        public void setStop_time(long stop_time) {
            this.stop_time = stop_time;
        }

        public long getOver_loading_time() {
            return over_loading_time;
        }

        public void setOver_loading_time(long over_loading_time) {
            this.over_loading_time = over_loading_time;
        }

        public double getAverage_loading() {
            return average_loading;
        }

        public void setAverage_loading(double average_loading) {
            this.average_loading = average_loading;
        }

        public long getNo_loading_time() {
            return no_loading_time;
        }

        public void setNo_loading_time(long no_loading_time) {
            this.no_loading_time = no_loading_time;
        }

        public long getLight_loading_time() {
            return light_loading_time;
        }

        public void setLight_loading_time(long light_loading_time) {
            this.light_loading_time = light_loading_time;
        }

        public long getHalf_load_time() {
            return half_load_time;
        }

        public void setHalf_load_time(long half_load_time) {
            this.half_load_time = half_load_time;
        }
    }
}
