package com.locensate.letnetwork.bean;

import java.io.Serializable;

/**
 * $String
 *
 * @author xiaobinghe
 */

public class OverviewMotor implements Serializable{


    /**
     * operCode : 1
     * data : {"motorCount":18,"powerCount":884.5,"measurePowerCount":880.5,"measureCount":15}
     */

    private int operCode;
    private DataBean data;

    public void setOperCode(int operCode) {
        this.operCode = operCode;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getOperCode() {
        return operCode;
    }

    public DataBean getData() {
        return data;
    }

    public static class DataBean {
        /**
         * motorCount : 18
         * powerCount : 884.5
         * measurePowerCount : 880.5
         * measureCount : 15
         */

        private int motorCount;
        private double powerCount;
        private double measurePowerCount;
        private int measureCount;

        public void setMotorCount(int motorCount) {
            this.motorCount = motorCount;
        }

        public void setPowerCount(double powerCount) {
            this.powerCount = powerCount;
        }

        public void setMeasurePowerCount(double measurePowerCount) {
            this.measurePowerCount = measurePowerCount;
        }

        public void setMeasureCount(int measureCount) {
            this.measureCount = measureCount;
        }

        public int getMotorCount() {
            return motorCount;
        }

        public double getPowerCount() {
            return powerCount;
        }

        public double getMeasurePowerCount() {
            return measurePowerCount;
        }

        public int getMeasureCount() {
            return measureCount;
        }
    }
}
