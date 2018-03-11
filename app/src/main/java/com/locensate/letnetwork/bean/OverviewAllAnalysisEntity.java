package com.locensate.letnetwork.bean;

import java.io.Serializable;


/**
 * $String
 *
 * @author xiaobinghe
 */

public class OverviewAllAnalysisEntity implements Serializable {

    /**
     * operCode : 1
     * data : {"average_loading":0.4283097767248985,"average_efficiency_total":0.8995340737520753,"power_consumption_total":5720.500000000003,"no_loading_consumption_total":2379.1503083333323}
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
         * average_loading : 0.4283097767248985
         * average_efficiency_total : 0.8995340737520753
         * power_consumption_total : 5720.500000000003
         * no_loading_consumption_total : 2379.1503083333323
         */

        private double average_loading;
        private double average_efficiency_total;
        private double power_consumption_total;
        private double no_loading_consumption_total;

        public double getAverage_loading() {
            return average_loading;
        }

        public void setAverage_loading(double average_loading) {
            this.average_loading = average_loading;
        }

        public double getAverage_efficiency_total() {
            return average_efficiency_total;
        }

        public void setAverage_efficiency_total(double average_efficiency_total) {
            this.average_efficiency_total = average_efficiency_total;
        }

        public double getPower_consumption_total() {
            return power_consumption_total;
        }

        public void setPower_consumption_total(double power_consumption_total) {
            this.power_consumption_total = power_consumption_total;
        }

        public double getNo_loading_consumption_total() {
            return no_loading_consumption_total;
        }

        public void setNo_loading_consumption_total(double no_loading_consumption_total) {
            this.no_loading_consumption_total = no_loading_consumption_total;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "average_loading=" + average_loading +
                    ", average_efficiency_total=" + average_efficiency_total +
                    ", power_consumption_total=" + power_consumption_total +
                    ", no_loading_consumption_total=" + no_loading_consumption_total +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "OverviewAllAnalysisEntity{" +
                "operCode=" + operCode +
                ", data=" + data +
                '}';
    }
}
