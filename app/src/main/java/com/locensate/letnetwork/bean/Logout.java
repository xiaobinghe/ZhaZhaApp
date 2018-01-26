package com.locensate.letnetwork.bean;

import java.io.Serializable;

/**
 * 登出
 *
 * @author xiaobinghe
 */


public class Logout implements Serializable {

    /**
     * uuid : d93843e7-e6bf-4ef1-80d5-e968d013ca5f
     */

    public String uuid;

    public Logout(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
