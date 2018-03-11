package com.locensate.letnetwork.main.ui.fragments.machineinfo.monitorinfo;

import java.io.Serializable;

/**
 * @author xiaobinghe
 */

public class RunningStateEntity implements Serializable {

    private long id;
    private String key;
    private double value;
    private String unit;
    private boolean isBreak;
    private String header;
    private String name;

    public RunningStateEntity(long id, String key, double value, boolean isBreak) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.isBreak = isBreak;
    }

    public RunningStateEntity(long id, String name, String header, String key, double value, String unit, boolean isBreak) {
        this.id = id;
        this.name = name;
        this.header = header;
        this.key = key;
        this.value = value;
        this.unit = unit;
        this.isBreak = isBreak;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
