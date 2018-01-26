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
 * 时间： 2016/12/21 12:13
 * <p>
 * 修改历史：
 * <p>
 * 修改时间：
 * <p>
 * 修改描述：
 * <p>
 * -------------------------------------
 */
public class SmartMsgEntity {
    public String des;
    public String name;
    public String address;
    public String time;
    public int num;

    public SmartMsgEntity(String address, String name, String time, String des, int num) {
        this.des = des;
        this.name = name;
        this.address = address;
        this.time = time;
        this.num = num;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;

    }

    @Override
    public String toString() {
        return "SmartMsgEntity{" +
                "des='" + des + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", time='" + time + '\'' +
                ", num=" + num +
                '}';
    }
}



