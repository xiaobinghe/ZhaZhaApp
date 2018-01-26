package com.locensate.letnetwork.entity;

/**
 * -------------------------------------
 * <p>
 * 项目名称： MotorTesting
 * <p>
 * 版权：locensate.com 版权所有 2016
 * <p>
 * 公司主页：http://www.locensate.com/
 * <p>
 * 描述：
 * <p>
 * 作者： xiaobinghe
 * <p>
 * 时间： 2017/5/31 15:41
 * <p>
 * 修改历史：
 * <p>
 * 修改时间：
 * <p>
 * 修改描述：
 * <p>
 * -------------------------------------
 */

public class RealTimeEntity {
    public String id;
    public String machineName;
    public String path;
    public String defaultPower;
    public String realPower;
    public String runningCurrent;
    public String realLoadRate;
    public String realEfficiency;
    public String electricHotQ30;
    public boolean isInterrupt;
    public String status;

    public RealTimeEntity(String id, String machineName, String path, String defaultPower, String realPower, String runningCurrent, String realLoadRate, String realEfficiency, String electricHotQ30, boolean isInterrupt, String status) {
        this.id = id;
        this.machineName = machineName;
        this.path = path;
        this.defaultPower = defaultPower;
        this.realPower = realPower;
        this.runningCurrent = runningCurrent;
        this.realLoadRate = realLoadRate;
        this.realEfficiency = realEfficiency;
        this.electricHotQ30 = electricHotQ30;
        this.isInterrupt = isInterrupt;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDefaultPower() {
        return defaultPower;
    }

    public void setDefaultPower(String defaultPower) {
        this.defaultPower = defaultPower;
    }

    public String getRealPower() {
        return realPower;
    }

    public void setRealPower(String realPower) {
        this.realPower = realPower;
    }

    public String getRunningCurrent() {
        return runningCurrent;
    }

    public void setRunningCurrent(String runningCurrent) {
        this.runningCurrent = runningCurrent;
    }

    public String getRealLoadRate() {
        return realLoadRate;
    }

    public void setRealLoadRate(String realLoadRate) {
        this.realLoadRate = realLoadRate;
    }

    public String getRealEfficiency() {
        return realEfficiency;
    }

    public void setRealEfficiency(String realEfficiency) {
        this.realEfficiency = realEfficiency;
    }

    public String getElectricHotQ30() {
        return electricHotQ30;
    }

    public void setElectricHotQ30(String electricHotQ30) {
        this.electricHotQ30 = electricHotQ30;
    }

    public boolean isInterrupt() {
        return isInterrupt;
    }

    public void setInterrupt(boolean interrupt) {
        isInterrupt = interrupt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
