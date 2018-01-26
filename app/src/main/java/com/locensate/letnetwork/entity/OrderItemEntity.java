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
 * 时间： 2017/1/16 22:30
 * <p>
 * 修改历史：
 * <p>
 * 修改时间：
 * <p>
 * 修改描述：
 * <p>
 * -------------------------------------
 */
public class OrderItemEntity {
    public int num;
    public String machineName;
    public String orderId;
    public String time;
    public String orderDes;
    public String location;
    public String dir;
    public String status;

    public OrderItemEntity(int num, String machineName, String orderId, String time, String orderDes, String location, String dir, String status) {
        this.num = num;
        this.machineName = machineName;
        this.orderId = orderId;
        this.time = time;
        this.orderDes = orderDes;
        this.location = location;
        this.dir = dir;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOrderDes() {
        return orderDes;
    }

    public void setOrderDes(String orderDes) {
        this.orderDes = orderDes;
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
