package com.locensate.letnetwork.entity;

/**
 *
 * @author xiaobinghe
 */

public class AlertItemEntity {

    public String machineName;
    public String time;
    public String des;
    public String location;
    public String rank;
    public boolean reset;

    public AlertItemEntity(String machineName, String time, String des, String location, String rank, boolean reset) {
        this.machineName = machineName;
        this.time = time;
        this.des = des;
        this.location = location;
        this.rank = rank;
        this.reset = reset;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public boolean isReset() {
        return reset;
    }

    public void setReset(boolean reset) {
        this.reset = reset;
    }
}
