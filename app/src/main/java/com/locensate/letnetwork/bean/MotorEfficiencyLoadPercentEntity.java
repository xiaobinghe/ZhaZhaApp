package com.locensate.letnetwork.bean;

import java.io.Serializable;


/**
 * $String
 *
 * @author xiaobinghe
 */

public class MotorEfficiencyLoadPercentEntity implements Serializable {

    /**
     * operCode : 1
     * data : {"t5":12,"t100":324,"t110":280,"t90":1231,"t70":9608,"t151":0,"t80":5578,"t150":20,"t50":822,"t120":0,"t60":1882,"t85":2971,"t30":515,"t40":4360,"t95":299,"t65":7931,"t10":0,"t75":7728,"t20":16169,"t45":1428,"t55":1153,"t25":2148,"t35":526,"t15":0}
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
         * t5 : 12
         * t100 : 324
         * t110 : 280
         * t90 : 1231
         * t70 : 9608
         * t151 : 0
         * t80 : 5578
         * t150 : 20
         * t50 : 822
         * t120 : 0
         * t60 : 1882
         * t85 : 2971
         * t30 : 515
         * t40 : 4360
         * t95 : 299
         * t65 : 7931
         * t10 : 0
         * t75 : 7728
         * t20 : 16169
         * t45 : 1428
         * t55 : 1153
         * t25 : 2148
         * t35 : 526
         * t15 : 0
         */

        private int t5;
        private int t100;
        private int t110;
        private int t90;
        private int t70;
        private int t151;
        private int t80;
        private int t150;
        private int t50;
        private int t120;
        private int t60;
        private int t85;
        private int t30;
        private int t40;
        private int t95;
        private int t65;
        private int t10;
        private int t75;
        private int t20;
        private int t45;
        private int t55;
        private int t25;
        private int t35;
        private int t15;

        public int getT5() {
            return t5;
        }

        public void setT5(int t5) {
            this.t5 = t5;
        }

        public int getT100() {
            return t100;
        }

        public void setT100(int t100) {
            this.t100 = t100;
        }

        public int getT110() {
            return t110;
        }

        public void setT110(int t110) {
            this.t110 = t110;
        }

        public int getT90() {
            return t90;
        }

        public void setT90(int t90) {
            this.t90 = t90;
        }

        public int getT70() {
            return t70;
        }

        public void setT70(int t70) {
            this.t70 = t70;
        }

        public int getT151() {
            return t151;
        }

        public void setT151(int t151) {
            this.t151 = t151;
        }

        public int getT80() {
            return t80;
        }

        public void setT80(int t80) {
            this.t80 = t80;
        }

        public int getT150() {
            return t150;
        }

        public void setT150(int t150) {
            this.t150 = t150;
        }

        public int getT50() {
            return t50;
        }

        public void setT50(int t50) {
            this.t50 = t50;
        }

        public int getT120() {
            return t120;
        }

        public void setT120(int t120) {
            this.t120 = t120;
        }

        public int getT60() {
            return t60;
        }

        public void setT60(int t60) {
            this.t60 = t60;
        }

        public int getT85() {
            return t85;
        }

        public void setT85(int t85) {
            this.t85 = t85;
        }

        public int getT30() {
            return t30;
        }

        public void setT30(int t30) {
            this.t30 = t30;
        }

        public int getT40() {
            return t40;
        }

        public void setT40(int t40) {
            this.t40 = t40;
        }

        public int getT95() {
            return t95;
        }

        public void setT95(int t95) {
            this.t95 = t95;
        }

        public int getT65() {
            return t65;
        }

        public void setT65(int t65) {
            this.t65 = t65;
        }

        public int getT10() {
            return t10;
        }

        public void setT10(int t10) {
            this.t10 = t10;
        }

        public int getT75() {
            return t75;
        }

        public void setT75(int t75) {
            this.t75 = t75;
        }

        public int getT20() {
            return t20;
        }

        public void setT20(int t20) {
            this.t20 = t20;
        }

        public int getT45() {
            return t45;
        }

        public void setT45(int t45) {
            this.t45 = t45;
        }

        public int getT55() {
            return t55;
        }

        public void setT55(int t55) {
            this.t55 = t55;
        }

        public int getT25() {
            return t25;
        }

        public void setT25(int t25) {
            this.t25 = t25;
        }

        public int getT35() {
            return t35;
        }

        public void setT35(int t35) {
            this.t35 = t35;
        }

        public int getT15() {
            return t15;
        }

        public void setT15(int t15) {
            this.t15 = t15;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "t5=" + t5 +
                    ", t100=" + t100 +
                    ", t110=" + t110 +
                    ", t90=" + t90 +
                    ", t70=" + t70 +
                    ", t151=" + t151 +
                    ", t80=" + t80 +
                    ", t150=" + t150 +
                    ", t50=" + t50 +
                    ", t120=" + t120 +
                    ", t60=" + t60 +
                    ", t85=" + t85 +
                    ", t30=" + t30 +
                    ", t40=" + t40 +
                    ", t95=" + t95 +
                    ", t65=" + t65 +
                    ", t10=" + t10 +
                    ", t75=" + t75 +
                    ", t20=" + t20 +
                    ", t45=" + t45 +
                    ", t55=" + t55 +
                    ", t25=" + t25 +
                    ", t35=" + t35 +
                    ", t15=" + t15 +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MotorEfficiencyLoadPercentEntity{" +
                "operCode=" + operCode +
                ", data=" + data +
                '}';
    }
}
