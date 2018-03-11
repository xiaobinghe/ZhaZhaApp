package com.locensate.letnetwork.bean;

import java.io.Serializable;
import java.util.List;


/**
 * $String
 *
 * @author xiaobinghe
 */

public class KanBanDataEntity implements Serializable {

    /**
     * operCode : 1
     * data : {"motor_count":28,"power_count":2895,"total_page":6,"page_num":1,"motor_list":[{"P1":0,"ETA":0,"rated_power":17,"Q5":0,"IO":0,"whole_equipment_name":"1B皮带机3","electric_motor_id":17,"organization_name":"供料车间","BETA":0,"Q30":0,"running_status":"停止"},{"P1":0,"ETA":0,"rated_power":37,"Q5":0,"IO":0,"whole_equipment_name":"1B皮带机4","electric_motor_id":18,"organization_name":"供料车间","BETA":0,"Q30":0,"running_status":"停止"},{"P1":31.472,"ETA":0.927696899766903,"rated_power":37,"Q5":0.875387311129804,"IO":57.104,"whole_equipment_name":"1B皮带机5","electric_motor_id":19,"organization_name":"供料车间","BETA":0.7890939683638911,"Q30":0.6419374413396617,"running_status":"运行"},{"P1":20.496,"ETA":0.9228270490396129,"rated_power":37,"Q5":0.34520237472566234,"IO":38.944,"whole_equipment_name":"1B皮带机2","electric_motor_id":16,"organization_name":"供料车间","BETA":0.5111963026247541,"Q30":0.18217729751314923,"running_status":"运行"},{"P1":0,"ETA":0,"rated_power":37,"Q5":0,"IO":0,"whole_equipment_name":"1B皮带机8","electric_motor_id":20,"organization_name":"供料车间","BETA":0,"Q30":0,"running_status":"停止"}],"page_size":5}
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

    public static class DataBean {
        /**
         * motor_count : 28
         * power_count : 2895
         * total_page : 6
         * page_num : 1
         * motor_list : [{"P1":0,"ETA":0,"rated_power":17,"Q5":0,"IO":0,"whole_equipment_name":"1B皮带机3","electric_motor_id":17,"organization_name":"供料车间","BETA":0,"Q30":0,"running_status":"停止"},{"P1":0,"ETA":0,"rated_power":37,"Q5":0,"IO":0,"whole_equipment_name":"1B皮带机4","electric_motor_id":18,"organization_name":"供料车间","BETA":0,"Q30":0,"running_status":"停止"},{"P1":31.472,"ETA":0.927696899766903,"rated_power":37,"Q5":0.875387311129804,"IO":57.104,"whole_equipment_name":"1B皮带机5","electric_motor_id":19,"organization_name":"供料车间","BETA":0.7890939683638911,"Q30":0.6419374413396617,"running_status":"运行"},{"P1":20.496,"ETA":0.9228270490396129,"rated_power":37,"Q5":0.34520237472566234,"IO":38.944,"whole_equipment_name":"1B皮带机2","electric_motor_id":16,"organization_name":"供料车间","BETA":0.5111963026247541,"Q30":0.18217729751314923,"running_status":"运行"},{"P1":0,"ETA":0,"rated_power":37,"Q5":0,"IO":0,"whole_equipment_name":"1B皮带机8","electric_motor_id":20,"organization_name":"供料车间","BETA":0,"Q30":0,"running_status":"停止"}]
         * page_size : 5
         */

        private int motor_count;
        private double power_count;
        private int total_page;
        private int page_num;
        private int page_size;
        private List<MotorListBean> motor_list;

        public int getMotor_count() {
            return motor_count;
        }

        public void setMotor_count(int motor_count) {
            this.motor_count = motor_count;
        }

        public double getPower_count() {
            return power_count;
        }

        public void setPower_count(double power_count) {
            this.power_count = power_count;
        }

        public int getTotal_page() {
            return total_page;
        }

        public void setTotal_page(int total_page) {
            this.total_page = total_page;
        }

        public int getPage_num() {
            return page_num;
        }

        public void setPage_num(int page_num) {
            this.page_num = page_num;
        }

        public int getPage_size() {
            return page_size;
        }

        public void setPage_size(int page_size) {
            this.page_size = page_size;
        }

        public List<MotorListBean> getMotor_list() {
            return motor_list;
        }

        public void setMotor_list(List<MotorListBean> motor_list) {
            this.motor_list = motor_list;
        }

        public static class MotorListBean {
            /**
             * P1 : 0
             * ETA : 0
             * rated_power : 17
             * Q5 : 0
             * IO : 0
             * whole_equipment_name : 1B皮带机3
             * electric_motor_id : 17
             * organization_name : 供料车间
             * BETA : 0
             * Q30 : 0
             * running_status : 停止
             */

            private double P1;
            private double ETA;
            private double rated_power;
            private double Q5;
            private double IO;
            private String whole_equipment_name;
            private long electric_motor_id;
            private String organization_name;
            private double BETA;
            private double Q30;
            private String running_status;

            public double getP1() {
                return P1;
            }

            public void setP1(double P1) {
                this.P1 = P1;
            }

            public double getETA() {
                return ETA;
            }

            public void setETA(double ETA) {
                this.ETA = ETA;
            }

            public double getRated_power() {
                return rated_power;
            }

            public void setRated_power(double rated_power) {
                this.rated_power = rated_power;
            }

            public double getQ5() {
                return Q5;
            }

            public void setQ5(double Q5) {
                this.Q5 = Q5;
            }

            public double getIO() {
                return IO;
            }

            public void setIO(double IO) {
                this.IO = IO;
            }

            public String getWhole_equipment_name() {
                return whole_equipment_name;
            }

            public void setWhole_equipment_name(String whole_equipment_name) {
                this.whole_equipment_name = whole_equipment_name;
            }

            public long getElectric_motor_id() {
                return electric_motor_id;
            }

            public void setElectric_motor_id(long electric_motor_id) {
                this.electric_motor_id = electric_motor_id;
            }

            public String getOrganization_name() {
                return organization_name;
            }

            public void setOrganization_name(String organization_name) {
                this.organization_name = organization_name;
            }

            public double getBETA() {
                return BETA;
            }

            public void setBETA(double BETA) {
                this.BETA = BETA;
            }

            public double getQ30() {
                return Q30;
            }

            public void setQ30(double Q30) {
                this.Q30 = Q30;
            }

            public String getRunning_status() {
                return running_status;
            }

            public void setRunning_status(String running_status) {
                this.running_status = running_status;
            }
        }
    }
}
