package com.locensate.letnetwork.bean;

import java.io.Serializable;

/**
 * $String
 *
 * @author xiaobinghe
 */

public class EntpBean implements Serializable{
    private String id;
    private String name;

    public EntpBean(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
