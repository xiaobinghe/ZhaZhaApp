package com.locensate.letnetwork.entity;

import java.io.Serializable;
import java.util.List;

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
 * 时间： 2017/5/17 9:37
 * <p>
 * 修改历史：
 * <p>
 * 修改时间：
 * <p>
 * 修改描述：
 * <p>
 * -------------------------------------
 */
public class RepairEntity implements Serializable {

    public String des;
    public String person;
    public String time;
    public String path;
    public String id;
    public List<MachineEntity> machines;


    public RepairEntity(String des, String person, String time) {
        this.des = des;
        this.person = person;
        this.time = time;
    }


    public RepairEntity(String des, String person, String time, String path, String id, List<MachineEntity> machines) {
        this.des = des;
        this.person = person;
        this.time = time;
        this.path = path;
        this.id = id;
        this.machines = machines;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MachineEntity> getMachines() {
        return machines;
    }

    public void setMachines(List<MachineEntity> machines) {
        this.machines = machines;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
