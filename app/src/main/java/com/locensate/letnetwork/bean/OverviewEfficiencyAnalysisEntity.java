package com.locensate.letnetwork.bean;

import java.io.Serializable;

/**
 * $String
 *
 * @author xiaobinghe
 */

public class OverviewEfficiencyAnalysisEntity implements Serializable {

    /**
     * operCode : 1
     * data : {"stop_running_power":90,"rational_running_power":0,"stop_running_count":1,"economy_running_power":222,"economy_running_count":2,"uneconomic_running_count":0,"uneconomic_running_power":0,"rational_running_count":0}
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

    public class DataBean implements Serializable {
        /**
         * stop_running_power : 90.0
         * rational_running_power : 0.0
         * stop_running_count : 1
         * economy_running_power : 222.0
         * economy_running_count : 2
         * uneconomic_running_count : 0
         * uneconomic_running_power : 0.0
         * rational_running_count : 0
         */

        private double stop_running_power;
        private double rational_running_power;
        private int stop_running_count;
        private double economy_running_power;
        private int economy_running_count;
        private int uneconomic_running_count;
        private double uneconomic_running_power;
        private int rational_running_count;

        public double getStop_running_power() {
            return stop_running_power;
        }

        public void setStop_running_power(double stop_running_power) {
            this.stop_running_power = stop_running_power;
        }

        public double getRational_running_power() {
            return rational_running_power;
        }

        public void setRational_running_power(double rational_running_power) {
            this.rational_running_power = rational_running_power;
        }

        public int getStop_running_count() {
            return stop_running_count;
        }

        public void setStop_running_count(int stop_running_count) {
            this.stop_running_count = stop_running_count;
        }

        public double getEconomy_running_power() {
            return economy_running_power;
        }

        public void setEconomy_running_power(double economy_running_power) {
            this.economy_running_power = economy_running_power;
        }

        public int getEconomy_running_count() {
            return economy_running_count;
        }

        public void setEconomy_running_count(int economy_running_count) {
            this.economy_running_count = economy_running_count;
        }

        public int getUneconomic_running_count() {
            return uneconomic_running_count;
        }

        public void setUneconomic_running_count(int uneconomic_running_count) {
            this.uneconomic_running_count = uneconomic_running_count;
        }

        public double getUneconomic_running_power() {
            return uneconomic_running_power;
        }

        public void setUneconomic_running_power(double uneconomic_running_power) {
            this.uneconomic_running_power = uneconomic_running_power;
        }

        public int getRational_running_count() {
            return rational_running_count;
        }

        public void setRational_running_count(int rational_running_count) {
            this.rational_running_count = rational_running_count;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "stop_running_power=" + stop_running_power +
                    ", rational_running_power=" + rational_running_power +
                    ", stop_running_count=" + stop_running_count +
                    ", economy_running_power=" + economy_running_power +
                    ", economy_running_count=" + economy_running_count +
                    ", uneconomic_running_count=" + uneconomic_running_count +
                    ", uneconomic_running_power=" + uneconomic_running_power +
                    ", rational_running_count=" + rational_running_count +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "OverviewEfficiencyAnalysisEntity{" +
                "operCode=" + operCode +
                ", data=" + data +
                '}';
    }
}
