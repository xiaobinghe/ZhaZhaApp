package com.locensate.letnetwork.bean;

import java.io.Serializable;
import java.util.List;


/**
 * $String
 *
 * @author xiaobinghe
 */

public class ControlDeviceReadParams implements Serializable {


    /**
     * operCode : 1
     * data : [{"sort":0,"status":1,"createTime":"2017-12-01 10:32:03.0","updateTime":"2018-01-29 15:26:40.0","gatewayDataReadId":3,"equipmentClassification":{"equipmentClassificationId":18,"equipmentClassificationName":"控制设备"},"equipmentType":{"equipmentTypeId":19,"equipmentTypeName":"Fairford控制器"},"gatewayDataReadParam":"MC-Io","gatewayDataReadParamDescription":"输出电流"},{"sort":0,"status":1,"createTime":"2017-12-01 10:33:17.0","updateTime":"2017-12-01 10:33:17.0","gatewayDataReadId":5,"equipmentClassification":{"equipmentClassificationId":18,"equipmentClassificationName":"控制设备"},"equipmentType":{"equipmentTypeId":19,"equipmentTypeName":"Fairford控制器"},"gatewayDataReadParam":"MC-P1","gatewayDataReadParamDescription":"输出功率"},{"sort":0,"status":1,"createTime":"2018-01-29 15:28:56.0","updateTime":"2018-01-29 15:28:56.0","gatewayDataReadId":33,"equipmentClassification":{"equipmentClassificationId":18,"equipmentClassificationName":"控制设备"},"equipmentType":{"equipmentTypeId":19,"equipmentTypeName":"Fairford控制器"},"gatewayDataReadParam":"MC-Q","gatewayDataReadParamDescription":"无功功率"},{"sort":0,"status":1,"createTime":"2017-12-01 10:27:15.0","updateTime":"2018-01-29 15:26:29.0","gatewayDataReadId":2,"equipmentClassification":{"equipmentClassificationId":18,"equipmentClassificationName":"控制设备"},"equipmentType":{"equipmentTypeId":19,"equipmentTypeName":"Fairford控制器"},"gatewayDataReadParam":"DK-last_fault_code","gatewayDataReadParamDescription":"最近故障代码"},{"sort":0,"status":1,"createTime":"2017-12-01 10:32:27.0","updateTime":"2017-12-01 10:32:27.0","gatewayDataReadId":4,"equipmentClassification":{"equipmentClassificationId":18,"equipmentClassificationName":"控制设备"},"equipmentType":{"equipmentTypeId":19,"equipmentTypeName":"Fairford控制器"},"gatewayDataReadParam":"MS-Pfo","gatewayDataReadParamDescription":"功率因数"},{"sort":0,"status":1,"createTime":"2017-12-01 10:33:47.0","updateTime":"2017-12-01 10:33:47.0","gatewayDataReadId":6,"equipmentClassification":{"equipmentClassificationId":18,"equipmentClassificationName":"控制设备"},"equipmentType":{"equipmentTypeId":19,"equipmentTypeName":"Fairford控制器"},"gatewayDataReadParam":"MS-Tvsd","gatewayDataReadParamDescription":"温度"}]
     */

    private int operCode;
    private List<DataBean> data;

    public void setOperCode(int operCode) {
        this.operCode = operCode;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public int getOperCode() {
        return operCode;
    }

    public List<DataBean> getData() {
        return data;
    }

    public static class DataBean {
        /**
         * sort : 0
         * status : 1
         * createTime : 2017-12-01 10:32:03.0
         * updateTime : 2018-01-29 15:26:40.0
         * gatewayDataReadId : 3
         * equipmentClassification : {"equipmentClassificationId":18,"equipmentClassificationName":"控制设备"}
         * equipmentType : {"equipmentTypeId":19,"equipmentTypeName":"Fairford控制器"}
         * gatewayDataReadParam : MC-Io
         * gatewayDataReadParamDescription : 输出电流
         */

        private int sort;
        private int status;
        private String createTime;
        private String updateTime;
        private int gatewayDataReadId;
        private EquipmentClassificationBean equipmentClassification;
        private EquipmentTypeBean equipmentType;
        private String gatewayDataReadParam;
        private String gatewayDataReadParamDescription;

        public void setSort(int sort) {
            this.sort = sort;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setGatewayDataReadId(int gatewayDataReadId) {
            this.gatewayDataReadId = gatewayDataReadId;
        }

        public void setEquipmentClassification(EquipmentClassificationBean equipmentClassification) {
            this.equipmentClassification = equipmentClassification;
        }

        public void setEquipmentType(EquipmentTypeBean equipmentType) {
            this.equipmentType = equipmentType;
        }

        public void setGatewayDataReadParam(String gatewayDataReadParam) {
            this.gatewayDataReadParam = gatewayDataReadParam;
        }

        public void setGatewayDataReadParamDescription(String gatewayDataReadParamDescription) {
            this.gatewayDataReadParamDescription = gatewayDataReadParamDescription;
        }

        public int getSort() {
            return sort;
        }

        public int getStatus() {
            return status;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public int getGatewayDataReadId() {
            return gatewayDataReadId;
        }

        public EquipmentClassificationBean getEquipmentClassification() {
            return equipmentClassification;
        }

        public EquipmentTypeBean getEquipmentType() {
            return equipmentType;
        }

        public String getGatewayDataReadParam() {
            return gatewayDataReadParam;
        }

        public String getGatewayDataReadParamDescription() {
            return gatewayDataReadParamDescription;
        }

        public static class EquipmentClassificationBean {
            /**
             * equipmentClassificationId : 18
             * equipmentClassificationName : 控制设备
             */

            private int equipmentClassificationId;
            private String equipmentClassificationName;

            public void setEquipmentClassificationId(int equipmentClassificationId) {
                this.equipmentClassificationId = equipmentClassificationId;
            }

            public void setEquipmentClassificationName(String equipmentClassificationName) {
                this.equipmentClassificationName = equipmentClassificationName;
            }

            public int getEquipmentClassificationId() {
                return equipmentClassificationId;
            }

            public String getEquipmentClassificationName() {
                return equipmentClassificationName;
            }
        }

        public static class EquipmentTypeBean {
            /**
             * equipmentTypeId : 19
             * equipmentTypeName : Fairford控制器
             */

            private int equipmentTypeId;
            private String equipmentTypeName;

            public void setEquipmentTypeId(int equipmentTypeId) {
                this.equipmentTypeId = equipmentTypeId;
            }

            public void setEquipmentTypeName(String equipmentTypeName) {
                this.equipmentTypeName = equipmentTypeName;
            }

            public int getEquipmentTypeId() {
                return equipmentTypeId;
            }

            public String getEquipmentTypeName() {
                return equipmentTypeName;
            }
        }
    }
}
