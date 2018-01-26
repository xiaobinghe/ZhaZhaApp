package com.locensate.letnetwork.bean;

import java.io.Serializable;

/**
 * $String
 *
 * @author xiaobinghe
 */

public class ImportantMachine implements Serializable {


    /**
     * createTime : string
     * id : 0
     * important : true
     * isImportant : true
     * sort : 0
     * status : 0
     * updateTime : string
     * userId : 0
     * wholeEquipmentId : 0
     */

    private String createTime;
    private int id;
    private boolean important;
    private boolean isImportant;
    private int sort;
    private int status;
    private String updateTime;
    private int userId;
    private int wholeEquipmentId;

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public void setIsImportant(boolean isImportant) {
        this.isImportant = isImportant;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setWholeEquipmentId(int wholeEquipmentId) {
        this.wholeEquipmentId = wholeEquipmentId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public int getId() {
        return id;
    }

    public boolean getImportant() {
        return important;
    }

    public boolean getIsImportant() {
        return isImportant;
    }

    public int getSort() {
        return sort;
    }

    public int getStatus() {
        return status;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public int getUserId() {
        return userId;
    }

    public int getWholeEquipmentId() {
        return wholeEquipmentId;
    }
}
