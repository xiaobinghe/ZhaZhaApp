package com.locensate.letnetwork.entity;

import java.io.Serializable;

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
 * 时间： 2017/5/31 12:07
 * <p>
 * 修改历史：
 * <p>
 * 修改时间：
 * <p>
 * 修改描述：
 * <p>
 * -------------------------------------
 */

public class RoutingEntity implements Serializable{
    public String machineName;
    public String routingId;
    public String time;
    public String routingDes;
    public String location;
    public String dir;


    public RoutingEntity(String machineName, String routingId, String time, String routingDes, String location, String dir) {
        this.machineName = machineName;
        this.routingId = routingId;
        this.time = time;
        this.routingDes = routingDes;
        this.location = location;
        this.dir = dir;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getRoutingId() {
        return routingId;
    }

    public void setRoutingId(String routingId) {
        this.routingId = routingId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRoutingDes() {
        return routingDes;
    }

    public void setRoutingDes(String routingDes) {
        this.routingDes = routingDes;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
}
