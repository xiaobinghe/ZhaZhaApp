package com.locensate.letnetwork.entity;


/**
 *
 * @author xiaobinghe
 */


public class GroupEnergyEntity {
    private String id;
    private String groupName;
    private String workTime;
    private String runningEfficiency;
    private String energyUsed;
    private String groupBelong;
    private String workType;


    public GroupEnergyEntity(String id, String groupName, String workTime, String runningEfficiency, String energyUsed, String groupBelong, String workType) {
        this.id = id;
        this.groupName = groupName;
        this.workTime = workTime;
        this.runningEfficiency = runningEfficiency;
        this.energyUsed = energyUsed;
        this.groupBelong = groupBelong;
        this.workType = workType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getRunningEfficiency() {
        return runningEfficiency;
    }

    public void setRunningEfficiency(String runningEfficiency) {
        this.runningEfficiency = runningEfficiency;
    }

    public String getEnergyUsed() {
        return energyUsed;
    }

    public void setEnergyUsed(String energyUsed) {
        this.energyUsed = energyUsed;
    }

    public String getGroupBelong() {
        return groupBelong;
    }

    public void setGroupBelong(String groupBelong) {
        this.groupBelong = groupBelong;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }
}
