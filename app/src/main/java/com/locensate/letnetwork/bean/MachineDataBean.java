package com.locensate.letnetwork.bean;


/**
 *
 * @author xiaobinghe
 */

public class MachineDataBean {
    private String name;
    private String controlMachine;
    private String path;
    private String voltageLevel;
    private String defaultPower;
    private String healthCode;
    private String efficiencyAverage;
    private boolean isImportant;
    private boolean isMeasure;
    private String id;

    public MachineDataBean(String name, String controlMachine, String path, String voltageLevel, String defaultPower, String healthCode, String efficiencyAverage, boolean isImportant, boolean isMeasure, String id) {
        this.name = name;
        this.controlMachine = controlMachine;
        this.path = path;
        this.voltageLevel = voltageLevel;
        this.defaultPower = defaultPower;
        this.healthCode = healthCode;
        this.efficiencyAverage = efficiencyAverage;
        this.isImportant = isImportant;
        this.isMeasure = isMeasure;
        this.id = id;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getVoltageLevel() {
        return voltageLevel;
    }

    public void setVoltageLevel(String voltageLevel) {
        this.voltageLevel = voltageLevel;
    }

    public String getDefaultPower() {
        return defaultPower;
    }

    public void setDefaultPower(String defaultPower) {
        this.defaultPower = defaultPower;
    }

    public String getHealthCode() {
        return healthCode;
    }

    public void setHealthCode(String healthCode) {
        this.healthCode = healthCode;
    }

    public String getEfficiencyAverage() {
        return efficiencyAverage;
    }

    public void setEfficiencyAverage(String efficiencyAverage) {
        this.efficiencyAverage = efficiencyAverage;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setImportant(boolean important) {
        isImportant = important;
    }

    public boolean isMeasure() {
        return isMeasure;
    }

    public void setMeasure(boolean isMeasure) {
        this.isMeasure = isMeasure;
    }

    public String getControlMachine() {
        return controlMachine;
    }

    public void setControlMachine(String controlMachine) {
        this.controlMachine = controlMachine;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
