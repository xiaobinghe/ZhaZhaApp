package com.locensate.letnetwork.entity;

import java.io.Serializable;


/**
 * 设备
 *
 * @author xiaobinghe
 */

public class MachineEntity implements Serializable {
    public String id;
    public String name;


    public MachineEntity(String id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "MachineEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
