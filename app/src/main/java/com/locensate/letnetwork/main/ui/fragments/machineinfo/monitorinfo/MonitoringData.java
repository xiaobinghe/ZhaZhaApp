package com.locensate.letnetwork.main.ui.fragments.machineinfo.monitorinfo;

import com.chad.library.adapter.base.entity.SectionEntity;


/**
 *  
 * @author xiaobinghe
 */

public class MonitoringData extends SectionEntity {

    public boolean isReadBreak;
    public boolean isRemoteParameter;

    public MonitoringData(boolean isHeader, String header, boolean isReadBreak, boolean isRemoteParameter) {
        super(isHeader, header);
        this.isReadBreak = isReadBreak;
        this.isRemoteParameter = isRemoteParameter;
    }

    public MonitoringData(RunningStateEntity entity) {
        super(entity);
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
