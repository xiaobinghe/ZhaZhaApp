package com.locensate.letnetwork.bean;

import java.io.Serializable;

/**
 * $String
 *
 * @author xiaobinghe
 */

public class RemoteParamEntity implements Serializable {


    /**
     * operCode : 1
     * data : {"sort":0,"status":1,"createTime":"2017-11-29 16:44:17.0","updateTime":"2018-01-29 18:14:54.0","keyParamId":2,"equipmentClassification":{"equipmentClassificationId":18,"equipmentClassificationName":"控制设备"},"equipmentType":{"equipmentTypeId":19,"equipmentTypeName":"Fairford控制器"},"brand":{"brandId":39,"brandName":"Fairford"},"series":{"seriesId":14,"seriesName":"SGY"},"gatewayParam":"DK-ts","keyParamDescription":"报警灵敏度","keyParamValueDescription":"0%最灵敏；100%最迟钝","keyParamUnit":"%","keyParamScope":"0-100%","keyParamCode":"44864or44863"}
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
         * sort : 0
         * status : 1
         * createTime : 2017-11-29 16:44:17.0
         * updateTime : 2018-01-29 18:14:54.0
         * keyParamId : 2
         * equipmentClassification : {"equipmentClassificationId":18,"equipmentClassificationName":"控制设备"}
         * equipmentType : {"equipmentTypeId":19,"equipmentTypeName":"Fairford控制器"}
         * brand : {"brandId":39,"brandName":"Fairford"}
         * series : {"seriesId":14,"seriesName":"SGY"}
         * gatewayParam : DK-ts
         * keyParamDescription : 报警灵敏度
         * keyParamValueDescription : 0%最灵敏；100%最迟钝
         * keyParamUnit : %
         * keyParamScope : 0-100%
         * keyParamCode : 44864or44863
         */

        private int sort;
        private int status;
        private String createTime;
        private String updateTime;
        private int keyParamId;
        private EquipmentClassificationBean equipmentClassification;
        private EquipmentTypeBean equipmentType;
        private BrandBean brand;
        private SeriesBean series;
        private String gatewayParam;
        private String keyParamDescription;
        private String keyParamValueDescription;
        private String keyParamUnit;
        private String keyParamScope;
        private String keyParamCode;

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

        public void setKeyParamId(int keyParamId) {
            this.keyParamId = keyParamId;
        }

        public void setEquipmentClassification(EquipmentClassificationBean equipmentClassification) {
            this.equipmentClassification = equipmentClassification;
        }

        public void setEquipmentType(EquipmentTypeBean equipmentType) {
            this.equipmentType = equipmentType;
        }

        public void setBrand(BrandBean brand) {
            this.brand = brand;
        }

        public void setSeries(SeriesBean series) {
            this.series = series;
        }

        public void setGatewayParam(String gatewayParam) {
            this.gatewayParam = gatewayParam;
        }

        public void setKeyParamDescription(String keyParamDescription) {
            this.keyParamDescription = keyParamDescription;
        }

        public void setKeyParamValueDescription(String keyParamValueDescription) {
            this.keyParamValueDescription = keyParamValueDescription;
        }

        public void setKeyParamUnit(String keyParamUnit) {
            this.keyParamUnit = keyParamUnit;
        }

        public void setKeyParamScope(String keyParamScope) {
            this.keyParamScope = keyParamScope;
        }

        public void setKeyParamCode(String keyParamCode) {
            this.keyParamCode = keyParamCode;
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

        public int getKeyParamId() {
            return keyParamId;
        }

        public EquipmentClassificationBean getEquipmentClassification() {
            return equipmentClassification;
        }

        public EquipmentTypeBean getEquipmentType() {
            return equipmentType;
        }

        public BrandBean getBrand() {
            return brand;
        }

        public SeriesBean getSeries() {
            return series;
        }

        public String getGatewayParam() {
            return gatewayParam;
        }

        public String getKeyParamDescription() {
            return keyParamDescription;
        }

        public String getKeyParamValueDescription() {
            return keyParamValueDescription;
        }

        public String getKeyParamUnit() {
            return keyParamUnit;
        }

        public String getKeyParamScope() {
            return keyParamScope;
        }

        public String getKeyParamCode() {
            return keyParamCode;
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

        public static class BrandBean {
            /**
             * brandId : 39
             * brandName : Fairford
             */

            private int brandId;
            private String brandName;

            public void setBrandId(int brandId) {
                this.brandId = brandId;
            }

            public void setBrandName(String brandName) {
                this.brandName = brandName;
            }

            public int getBrandId() {
                return brandId;
            }

            public String getBrandName() {
                return brandName;
            }
        }

        public static class SeriesBean {
            /**
             * seriesId : 14
             * seriesName : SGY
             */

            private int seriesId;
            private String seriesName;

            public void setSeriesId(int seriesId) {
                this.seriesId = seriesId;
            }

            public void setSeriesName(String seriesName) {
                this.seriesName = seriesName;
            }

            public int getSeriesId() {
                return seriesId;
            }

            public String getSeriesName() {
                return seriesName;
            }
        }
    }
}
