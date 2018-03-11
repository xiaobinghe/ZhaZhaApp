package com.locensate.letnetwork.bean;


import java.io.Serializable;
import java.util.List;

/**
 *
 * @author xiaobinghe
 */


public class HealthOverDataEntity implements Serializable{


    /**
     * operCode : 1
     * data : [{"time":"2018-03-02 01:06:00","value":0.6009628491998041},{"time":"2018-03-02 08:09:00","value":0.6793126633280345},{"time":"2018-03-02 10:59:00","value":0.6373911787761802},{"time":"2018-03-02 11:09:00","value":0.6662636366229617}]
     */

    private int operCode;
    private List<DataBean> data;

    public int getOperCode() {
        return operCode;
    }

    public void setOperCode(int operCode) {
        this.operCode = operCode;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * time : 2018-03-02 01:06:00
         * value : 0.6009628491998041
         */

        private String time;
        private String type;
        private double value;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }
}
