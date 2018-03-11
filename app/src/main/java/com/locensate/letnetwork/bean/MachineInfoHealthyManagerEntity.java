package com.locensate.letnetwork.bean;

import java.io.Serializable;


/**
 * $String
 *
 * @author xiaobinghe
 */

public class MachineInfoHealthyManagerEntity implements Serializable {

    /**
     * operCode : 1
     * data : {"q5_max":0.9684707872877001,"q30_max":0.6794053004091618,"sq30":1,"q30_max_time":1519973460000,"max_start":1,"zd_max":12.236,"sst":1,"sq5":1,"si":0.75,"max_start_time":1519894800000,"zd_max_time":1519971877000,"tem_max":288.32,"szd":0.2,"q5_max_time":1519972560000,"io_max_time":1519971310000,"tem_max_time":1519971666000,"sco":3.0000000000000004,"io_max":444.44,"stem":0.2}
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
         * q5_max : 0.9684707872877001
         * q30_max : 0.6794053004091618
         * sq30 : 1.0
         * q30_max_time : 1519973460000
         * max_start : 1
         * zd_max : 12.236
         * sst : 1.0
         * sq5 : 1.0
         * si : 0.75
         * max_start_time : 1519894800000
         * zd_max_time : 1519971877000
         * tem_max : 288.32
         * szd : 0.2
         * q5_max_time : 1519972560000
         * io_max_time : 1519971310000
         * tem_max_time : 1519971666000
         * sco : 3.0000000000000004
         * io_max : 444.44
         * stem : 0.2
         */

        private double q5_max;
        private double q30_max;
        private double sq30;
        private long q30_max_time;
        private int max_start;
        private double zd_max;
        private double sst;
        private double sq5;
        private double si;
        private long max_start_time;
        private long zd_max_time;
        private double tem_max;
        private double szd;
        private long q5_max_time;
        private long io_max_time;
        private long tem_max_time;
        private double sco;
        private double io_max;
        private double stem;

        public double getQ5_max() {
            return q5_max;
        }

        public void setQ5_max(double q5_max) {
            this.q5_max = q5_max;
        }

        public double getQ30_max() {
            return q30_max;
        }

        public void setQ30_max(double q30_max) {
            this.q30_max = q30_max;
        }

        public double getSq30() {
            return sq30;
        }

        public void setSq30(double sq30) {
            this.sq30 = sq30;
        }

        public long getQ30_max_time() {
            return q30_max_time;
        }

        public void setQ30_max_time(long q30_max_time) {
            this.q30_max_time = q30_max_time;
        }

        public int getMax_start() {
            return max_start;
        }

        public void setMax_start(int max_start) {
            this.max_start = max_start;
        }

        public double getZd_max() {
            return zd_max;
        }

        public void setZd_max(double zd_max) {
            this.zd_max = zd_max;
        }

        public double getSst() {
            return sst;
        }

        public void setSst(double sst) {
            this.sst = sst;
        }

        public double getSq5() {
            return sq5;
        }

        public void setSq5(double sq5) {
            this.sq5 = sq5;
        }

        public double getSi() {
            return si;
        }

        public void setSi(double si) {
            this.si = si;
        }

        public long getMax_start_time() {
            return max_start_time;
        }

        public void setMax_start_time(long max_start_time) {
            this.max_start_time = max_start_time;
        }

        public long getZd_max_time() {
            return zd_max_time;
        }

        public void setZd_max_time(long zd_max_time) {
            this.zd_max_time = zd_max_time;
        }

        public double getTem_max() {
            return tem_max;
        }

        public void setTem_max(double tem_max) {
            this.tem_max = tem_max;
        }

        public double getSzd() {
            return szd;
        }

        public void setSzd(double szd) {
            this.szd = szd;
        }

        public long getQ5_max_time() {
            return q5_max_time;
        }

        public void setQ5_max_time(long q5_max_time) {
            this.q5_max_time = q5_max_time;
        }

        public long getIo_max_time() {
            return io_max_time;
        }

        public void setIo_max_time(long io_max_time) {
            this.io_max_time = io_max_time;
        }

        public long getTem_max_time() {
            return tem_max_time;
        }

        public void setTem_max_time(long tem_max_time) {
            this.tem_max_time = tem_max_time;
        }

        public double getSco() {
            return sco;
        }

        public void setSco(double sco) {
            this.sco = sco;
        }

        public double getIo_max() {
            return io_max;
        }

        public void setIo_max(double io_max) {
            this.io_max = io_max;
        }

        public double getStem() {
            return stem;
        }

        public void setStem(double stem) {
            this.stem = stem;
        }
    }
}
