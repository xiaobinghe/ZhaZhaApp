package com.locensate.letnetwork.bean;

import java.io.Serializable;

/**
 * $String
 *
 * @author xiaobinghe
 */

public class OverviewLoadAnalysisEntity implements Serializable{

    /**
     * operCode : 1
     * data : {"half_loading_count":0,"heavy_loading_count":0,"stop_loading_power":90,"no_loading_count":0,"stop_loading_count":1,"over_loading_power":222,"no_loading_power":0,"light_loading_power":0,"light_loading_count":0,"over_loading_count":2,"heavy_loading_power":0,"half_loading_power":0}
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
         * half_loading_count : 0
         * heavy_loading_count : 0
         * stop_loading_power : 90.0
         * no_loading_count : 0
         * stop_loading_count : 1
         * over_loading_power : 222.0
         * no_loading_power : 0.0
         * light_loading_power : 0.0
         * light_loading_count : 0
         * over_loading_count : 2
         * heavy_loading_power : 0.0
         * half_loading_power : 0.0
         */

        private int half_loading_count;
        private int heavy_loading_count;
        private double stop_loading_power;
        private int no_loading_count;
        private int stop_loading_count;
        private double over_loading_power;
        private double no_loading_power;
        private double light_loading_power;
        private int light_loading_count;
        private int over_loading_count;
        private double heavy_loading_power;
        private double half_loading_power;

        public int getHalf_loading_count() {
            return half_loading_count;
        }

        public void setHalf_loading_count(int half_loading_count) {
            this.half_loading_count = half_loading_count;
        }

        public int getHeavy_loading_count() {
            return heavy_loading_count;
        }

        public void setHeavy_loading_count(int heavy_loading_count) {
            this.heavy_loading_count = heavy_loading_count;
        }

        public double getStop_loading_power() {
            return stop_loading_power;
        }

        public void setStop_loading_power(double stop_loading_power) {
            this.stop_loading_power = stop_loading_power;
        }

        public int getNo_loading_count() {
            return no_loading_count;
        }

        public void setNo_loading_count(int no_loading_count) {
            this.no_loading_count = no_loading_count;
        }

        public int getStop_loading_count() {
            return stop_loading_count;
        }

        public void setStop_loading_count(int stop_loading_count) {
            this.stop_loading_count = stop_loading_count;
        }

        public double getOver_loading_power() {
            return over_loading_power;
        }

        public void setOver_loading_power(double over_loading_power) {
            this.over_loading_power = over_loading_power;
        }

        public double getNo_loading_power() {
            return no_loading_power;
        }

        public void setNo_loading_power(double no_loading_power) {
            this.no_loading_power = no_loading_power;
        }

        public double getLight_loading_power() {
            return light_loading_power;
        }

        public void setLight_loading_power(double light_loading_power) {
            this.light_loading_power = light_loading_power;
        }

        public int getLight_loading_count() {
            return light_loading_count;
        }

        public void setLight_loading_count(int light_loading_count) {
            this.light_loading_count = light_loading_count;
        }

        public int getOver_loading_count() {
            return over_loading_count;
        }

        public void setOver_loading_count(int over_loading_count) {
            this.over_loading_count = over_loading_count;
        }

        public double getHeavy_loading_power() {
            return heavy_loading_power;
        }

        public void setHeavy_loading_power(double heavy_loading_power) {
            this.heavy_loading_power = heavy_loading_power;
        }

        public double getHalf_loading_power() {
            return half_loading_power;
        }

        public void setHalf_loading_power(double half_loading_power) {
            this.half_loading_power = half_loading_power;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "half_loading_count=" + half_loading_count +
                    ", heavy_loading_count=" + heavy_loading_count +
                    ", stop_loading_power=" + stop_loading_power +
                    ", no_loading_count=" + no_loading_count +
                    ", stop_loading_count=" + stop_loading_count +
                    ", over_loading_power=" + over_loading_power +
                    ", no_loading_power=" + no_loading_power +
                    ", light_loading_power=" + light_loading_power +
                    ", light_loading_count=" + light_loading_count +
                    ", over_loading_count=" + over_loading_count +
                    ", heavy_loading_power=" + heavy_loading_power +
                    ", half_loading_power=" + half_loading_power +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "OverviewLoadAnalysisEntity{" +
                "operCode=" + operCode +
                ", data=" + data +
                '}';
    }
}
