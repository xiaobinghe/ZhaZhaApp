package com.locensate.letnetwork.bean;

import java.io.Serializable;

/**
 * $String
 *
 * @author xiaobinghe
 */

public class OverviewHealthAnalysisEntity implements Serializable{

    /**
     * operCode : 1
     * data : {"worse_status_power":0,"worst_status_power":0,"better_status_count":0,"best_status_power":312,"best_status_count":3,"better_status_power":0,"worse_status_count":0,"worst_status_count":0}
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

    public  class DataBean implements Serializable{
        /**
         * worse_status_power : 0.0
         * worst_status_power : 0.0
         * better_status_count : 0
         * best_status_power : 312.0
         * best_status_count : 3
         * better_status_power : 0.0
         * worse_status_count : 0
         * worst_status_count : 0
         */

        private double worse_status_power;
        private double worst_status_power;
        private int better_status_count;
        private double best_status_power;
        private int best_status_count;
        private double better_status_power;
        private int worse_status_count;
        private int worst_status_count;

        public double getWorse_status_power() {
            return worse_status_power;
        }

        public void setWorse_status_power(double worse_status_power) {
            this.worse_status_power = worse_status_power;
        }

        public double getWorst_status_power() {
            return worst_status_power;
        }

        public void setWorst_status_power(double worst_status_power) {
            this.worst_status_power = worst_status_power;
        }

        public int getBetter_status_count() {
            return better_status_count;
        }

        public void setBetter_status_count(int better_status_count) {
            this.better_status_count = better_status_count;
        }

        public double getBest_status_power() {
            return best_status_power;
        }

        public void setBest_status_power(double best_status_power) {
            this.best_status_power = best_status_power;
        }

        public int getBest_status_count() {
            return best_status_count;
        }

        public void setBest_status_count(int best_status_count) {
            this.best_status_count = best_status_count;
        }

        public double getBetter_status_power() {
            return better_status_power;
        }

        public void setBetter_status_power(double better_status_power) {
            this.better_status_power = better_status_power;
        }

        public int getWorse_status_count() {
            return worse_status_count;
        }

        public void setWorse_status_count(int worse_status_count) {
            this.worse_status_count = worse_status_count;
        }

        public int getWorst_status_count() {
            return worst_status_count;
        }

        public void setWorst_status_count(int worst_status_count) {
            this.worst_status_count = worst_status_count;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "worse_status_power=" + worse_status_power +
                    ", worst_status_power=" + worst_status_power +
                    ", better_status_count=" + better_status_count +
                    ", best_status_power=" + best_status_power +
                    ", best_status_count=" + best_status_count +
                    ", better_status_power=" + better_status_power +
                    ", worse_status_count=" + worse_status_count +
                    ", worst_status_count=" + worst_status_count +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "OverviewHealthAnalysisEntity{" +
                "operCode=" + operCode +
                ", data=" + data +
                '}';
    }

}
