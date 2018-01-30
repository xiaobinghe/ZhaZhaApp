package com.locensate.letnetwork.bean;

import java.io.Serializable;
import java.util.List;


/**
 * $String
 *
 * @author xiaobinghe
 */

public class DeviceInfoEntity implements Serializable {

    /**
     * operCode : 1
     * data : {"wholeEquipmentId":1,"wholeEquipmentName":"运料主皮带机","wholeEquipmentDescription":"运料主皮带机","wholeEquipmentLocation":"配电室","wholeEquipmentType":{"wholeEquipmentTypeId":3,"wholeEquipmentTypeName":"皮带机","wholeEquipmentTypeDescription":"皮带机"},"organization":{"organizationId":4,"subWholeEquipment":null},"electricMotorList":[{"sort":0,"status":1,"createTime":"2017-07-23 14:49:26.0","updateTime":"2017-07-23 14:51:13.0","electricMotorId":1,"electricMotorName":"测试电机","electricMotorDescription":"测试电机说明","organizationId":4,"wholeEquipmentId":1,"wholeEquipmentName":"运料主皮带机","equipmentTypeId":8,"brandId":8,"seriesId":1,"modelNumberId":11,"energyEfficiencyGradeId":0,"coolingWayId":0,"ratedSpeedId":0,"poleNumberId":0,"ratedVoltageId":0,"ratedCurrent":0,"ratedEfficiency":0,"ratedNoloadLoss":0,"ratedPower":0,"kkz":0,"kqz":0,"kbz":0,"stn":0,"installationId":1,"monitorInstrumentId":0,"filterEquipmentId":0}]}
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
         * wholeEquipmentId : 1
         * wholeEquipmentName : 运料主皮带机
         * wholeEquipmentDescription : 运料主皮带机
         * wholeEquipmentLocation : 配电室
         * wholeEquipmentType : {"wholeEquipmentTypeId":3,"wholeEquipmentTypeName":"皮带机","wholeEquipmentTypeDescription":"皮带机"}
         * organization : {"organizationId":4,"subWholeEquipment":null}
         * electricMotorList : [{"sort":0,"status":1,"createTime":"2017-07-23 14:49:26.0","updateTime":"2017-07-23 14:51:13.0","electricMotorId":1,"electricMotorName":"测试电机","electricMotorDescription":"测试电机说明","organizationId":4,"wholeEquipmentId":1,"wholeEquipmentName":"运料主皮带机","equipmentTypeId":8,"brandId":8,"seriesId":1,"modelNumberId":11,"energyEfficiencyGradeId":0,"coolingWayId":0,"ratedSpeedId":0,"poleNumberId":0,"ratedVoltageId":0,"ratedCurrent":0,"ratedEfficiency":0,"ratedNoloadLoss":0,"ratedPower":0,"kkz":0,"kqz":0,"kbz":0,"stn":0,"installationId":1,"monitorInstrumentId":0,"filterEquipmentId":0}]
         */

        private int wholeEquipmentId;
        private String wholeEquipmentName;
        private String wholeEquipmentDescription;
        private String wholeEquipmentLocation;
        private WholeEquipmentTypeBean wholeEquipmentType;
        private OrganizationBean organization;
        private List<ElectricMotorListBean> electricMotorList;

        public void setWholeEquipmentId(int wholeEquipmentId) {
            this.wholeEquipmentId = wholeEquipmentId;
        }

        public void setWholeEquipmentName(String wholeEquipmentName) {
            this.wholeEquipmentName = wholeEquipmentName;
        }

        public void setWholeEquipmentDescription(String wholeEquipmentDescription) {
            this.wholeEquipmentDescription = wholeEquipmentDescription;
        }

        public void setWholeEquipmentLocation(String wholeEquipmentLocation) {
            this.wholeEquipmentLocation = wholeEquipmentLocation;
        }

        public void setWholeEquipmentType(WholeEquipmentTypeBean wholeEquipmentType) {
            this.wholeEquipmentType = wholeEquipmentType;
        }

        public void setOrganization(OrganizationBean organization) {
            this.organization = organization;
        }

        public void setElectricMotorList(List<ElectricMotorListBean> electricMotorList) {
            this.electricMotorList = electricMotorList;
        }

        public int getWholeEquipmentId() {
            return wholeEquipmentId;
        }

        public String getWholeEquipmentName() {
            return wholeEquipmentName;
        }

        public String getWholeEquipmentDescription() {
            return wholeEquipmentDescription;
        }

        public String getWholeEquipmentLocation() {
            return wholeEquipmentLocation;
        }

        public WholeEquipmentTypeBean getWholeEquipmentType() {
            return wholeEquipmentType;
        }

        public OrganizationBean getOrganization() {
            return organization;
        }

        public List<ElectricMotorListBean> getElectricMotorList() {
            return electricMotorList;
        }

        public static class WholeEquipmentTypeBean {
            /**
             * wholeEquipmentTypeId : 3
             * wholeEquipmentTypeName : 皮带机
             * wholeEquipmentTypeDescription : 皮带机
             */

            private int wholeEquipmentTypeId;
            private String wholeEquipmentTypeName;
            private String wholeEquipmentTypeDescription;

            public void setWholeEquipmentTypeId(int wholeEquipmentTypeId) {
                this.wholeEquipmentTypeId = wholeEquipmentTypeId;
            }

            public void setWholeEquipmentTypeName(String wholeEquipmentTypeName) {
                this.wholeEquipmentTypeName = wholeEquipmentTypeName;
            }

            public void setWholeEquipmentTypeDescription(String wholeEquipmentTypeDescription) {
                this.wholeEquipmentTypeDescription = wholeEquipmentTypeDescription;
            }

            public int getWholeEquipmentTypeId() {
                return wholeEquipmentTypeId;
            }

            public String getWholeEquipmentTypeName() {
                return wholeEquipmentTypeName;
            }

            public String getWholeEquipmentTypeDescription() {
                return wholeEquipmentTypeDescription;
            }
        }

        public static class OrganizationBean {
            /**
             * organizationId : 4
             * subWholeEquipment : null
             */

            private int organizationId;
            private Object subWholeEquipment;

            public void setOrganizationId(int organizationId) {
                this.organizationId = organizationId;
            }

            public void setSubWholeEquipment(Object subWholeEquipment) {
                this.subWholeEquipment = subWholeEquipment;
            }

            public int getOrganizationId() {
                return organizationId;
            }

            public Object getSubWholeEquipment() {
                return subWholeEquipment;
            }
        }

        public static class ElectricMotorListBean {
            /**
             * sort : 0
             * status : 1
             * createTime : 2017-07-23 14:49:26.0
             * updateTime : 2017-07-23 14:51:13.0
             * electricMotorId : 1
             * electricMotorName : 测试电机
             * electricMotorDescription : 测试电机说明
             * organizationId : 4
             * wholeEquipmentId : 1
             * wholeEquipmentName : 运料主皮带机
             * equipmentTypeId : 8
             * brandId : 8
             * seriesId : 1
             * modelNumberId : 11
             * energyEfficiencyGradeId : 0
             * coolingWayId : 0
             * ratedSpeedId : 0
             * poleNumberId : 0
             * ratedVoltageId : 0
             * ratedCurrent : 0
             * ratedEfficiency : 0
             * ratedNoloadLoss : 0
             * ratedPower : 0
             * kkz : 0
             * kqz : 0
             * kbz : 0
             * stn : 0
             * installationId : 1
             * monitorInstrumentId : 0
             * filterEquipmentId : 0
             */

            private int sort;
            private int status;
            private String createTime;
            private String updateTime;
            private int electricMotorId;
            private String electricMotorName;
            private String electricMotorDescription;
            private int organizationId;
            private int wholeEquipmentId;
            private String wholeEquipmentName;
            private int equipmentTypeId;
            private int brandId;
            private int seriesId;
            private int modelNumberId;
            private int energyEfficiencyGradeId;
            private int coolingWayId;
            private int ratedSpeedId;
            private int poleNumberId;
            private int ratedVoltageId;
            private int ratedCurrent;
            private int ratedEfficiency;
            private int ratedNoloadLoss;
            private int ratedPower;
            private int kkz;
            private int kqz;
            private int kbz;
            private int stn;
            private int installationId;
            private int monitorInstrumentId;
            private int filterEquipmentId;

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

            public void setElectricMotorId(int electricMotorId) {
                this.electricMotorId = electricMotorId;
            }

            public void setElectricMotorName(String electricMotorName) {
                this.electricMotorName = electricMotorName;
            }

            public void setElectricMotorDescription(String electricMotorDescription) {
                this.electricMotorDescription = electricMotorDescription;
            }

            public void setOrganizationId(int organizationId) {
                this.organizationId = organizationId;
            }

            public void setWholeEquipmentId(int wholeEquipmentId) {
                this.wholeEquipmentId = wholeEquipmentId;
            }

            public void setWholeEquipmentName(String wholeEquipmentName) {
                this.wholeEquipmentName = wholeEquipmentName;
            }

            public void setEquipmentTypeId(int equipmentTypeId) {
                this.equipmentTypeId = equipmentTypeId;
            }

            public void setBrandId(int brandId) {
                this.brandId = brandId;
            }

            public void setSeriesId(int seriesId) {
                this.seriesId = seriesId;
            }

            public void setModelNumberId(int modelNumberId) {
                this.modelNumberId = modelNumberId;
            }

            public void setEnergyEfficiencyGradeId(int energyEfficiencyGradeId) {
                this.energyEfficiencyGradeId = energyEfficiencyGradeId;
            }

            public void setCoolingWayId(int coolingWayId) {
                this.coolingWayId = coolingWayId;
            }

            public void setRatedSpeedId(int ratedSpeedId) {
                this.ratedSpeedId = ratedSpeedId;
            }

            public void setPoleNumberId(int poleNumberId) {
                this.poleNumberId = poleNumberId;
            }

            public void setRatedVoltageId(int ratedVoltageId) {
                this.ratedVoltageId = ratedVoltageId;
            }

            public void setRatedCurrent(int ratedCurrent) {
                this.ratedCurrent = ratedCurrent;
            }

            public void setRatedEfficiency(int ratedEfficiency) {
                this.ratedEfficiency = ratedEfficiency;
            }

            public void setRatedNoloadLoss(int ratedNoloadLoss) {
                this.ratedNoloadLoss = ratedNoloadLoss;
            }

            public void setRatedPower(int ratedPower) {
                this.ratedPower = ratedPower;
            }

            public void setKkz(int kkz) {
                this.kkz = kkz;
            }

            public void setKqz(int kqz) {
                this.kqz = kqz;
            }

            public void setKbz(int kbz) {
                this.kbz = kbz;
            }

            public void setStn(int stn) {
                this.stn = stn;
            }

            public void setInstallationId(int installationId) {
                this.installationId = installationId;
            }

            public void setMonitorInstrumentId(int monitorInstrumentId) {
                this.monitorInstrumentId = monitorInstrumentId;
            }

            public void setFilterEquipmentId(int filterEquipmentId) {
                this.filterEquipmentId = filterEquipmentId;
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

            public int getElectricMotorId() {
                return electricMotorId;
            }

            public String getElectricMotorName() {
                return electricMotorName;
            }

            public String getElectricMotorDescription() {
                return electricMotorDescription;
            }

            public int getOrganizationId() {
                return organizationId;
            }

            public int getWholeEquipmentId() {
                return wholeEquipmentId;
            }

            public String getWholeEquipmentName() {
                return wholeEquipmentName;
            }

            public int getEquipmentTypeId() {
                return equipmentTypeId;
            }

            public int getBrandId() {
                return brandId;
            }

            public int getSeriesId() {
                return seriesId;
            }

            public int getModelNumberId() {
                return modelNumberId;
            }

            public int getEnergyEfficiencyGradeId() {
                return energyEfficiencyGradeId;
            }

            public int getCoolingWayId() {
                return coolingWayId;
            }

            public int getRatedSpeedId() {
                return ratedSpeedId;
            }

            public int getPoleNumberId() {
                return poleNumberId;
            }

            public int getRatedVoltageId() {
                return ratedVoltageId;
            }

            public int getRatedCurrent() {
                return ratedCurrent;
            }

            public int getRatedEfficiency() {
                return ratedEfficiency;
            }

            public int getRatedNoloadLoss() {
                return ratedNoloadLoss;
            }

            public int getRatedPower() {
                return ratedPower;
            }

            public int getKkz() {
                return kkz;
            }

            public int getKqz() {
                return kqz;
            }

            public int getKbz() {
                return kbz;
            }

            public int getStn() {
                return stn;
            }

            public int getInstallationId() {
                return installationId;
            }

            public int getMonitorInstrumentId() {
                return monitorInstrumentId;
            }

            public int getFilterEquipmentId() {
                return filterEquipmentId;
            }
        }
    }
}
