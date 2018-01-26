package com.locensate.letnetwork.main.ui.fragments.machineinfo.monitorinfo;

import java.io.Serializable;

/**
 *  
 * @author xiaobinghe
 */

public class RunningStateEntity implements Serializable {

    public String id;
    public String key;
    public String value;
    public String unit;
    public boolean isBreak;


    public RunningStateEntity(String id, String key, String value, boolean isBreak) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.isBreak = isBreak;
    }

    public RunningStateEntity(String id, String key, String value, String unit, boolean isBreak) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.unit = unit;
        this.isBreak = isBreak;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public boolean isBreak() {
        return isBreak;
    }

    public void setBreak(boolean aBreak) {
        isBreak = aBreak;
    }

    public boolean isbreak() {
        return isBreak;
    }

    public void setIsbreak(boolean isbreak) {
        this.isBreak = isbreak;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
