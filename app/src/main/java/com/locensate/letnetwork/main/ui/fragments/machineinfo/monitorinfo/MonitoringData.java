package com.locensate.letnetwork.main.ui.fragments.machineinfo.monitorinfo;

import com.chad.library.adapter.base.entity.SectionEntity;


/**
 * @author xiaobinghe
 */

public class MonitoringData extends SectionEntity {

    public boolean isReadBreak;
    public boolean isRemoteParameter;
    private String monitorEquipmentName;

    public MonitoringData(boolean isHeader, String monitorEquipmentName, String header, boolean isReadBreak, boolean isRemoteParameter) {
        super(isHeader, header);
        this.isReadBreak = isReadBreak;
        this.monitorEquipmentName = monitorEquipmentName;
        this.isRemoteParameter = isRemoteParameter;
    }

    public MonitoringData(RunningStateEntity entity) {
        super(entity);
    }

    public String getMonitorEquipmentName() {
        return monitorEquipmentName;
    }

    public void setMonitorEquipmentName(String monitorEquipmentName) {
        this.monitorEquipmentName = monitorEquipmentName;
    }

    public boolean isReadBreak() {
        return isReadBreak;
    }

    public void setReadBreak(boolean readBreak) {
        isReadBreak = readBreak;
    }

    public boolean isRemoteParameter() {
        return isRemoteParameter;
    }

    public void setRemoteParameter(boolean remoteParameter) {
        isRemoteParameter = remoteParameter;
    }
}
