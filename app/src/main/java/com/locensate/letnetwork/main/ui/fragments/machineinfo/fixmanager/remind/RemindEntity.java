package com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.remind;

import com.locensate.letnetwork.entity.MachineEntity;

import java.io.Serializable;
import java.util.List;

/**
 *  
 * @author xiaobinghe
 */

public class RemindEntity implements Serializable{
    public String des;
    public String person;
    public String time;
    public String type;
    public List<MachineEntity> machines;
    public String path;

    public RemindEntity(String des, String person, String time, String type) {
        this.des = des;
        this.person = person;
        this.time = time;
        this.type = type;
    }

    public RemindEntity(String des, String person, String time, String type, List<MachineEntity> machines, String path) {
        this.des = des;
        this.person = person;
        this.time = time;
        this.type = type;
        this.machines = machines;
        this.path = path;
    }


    public List<MachineEntity> getMachines() {
        return machines;
    }

    public void setMachines(List<MachineEntity> machines) {
        this.machines = machines;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
