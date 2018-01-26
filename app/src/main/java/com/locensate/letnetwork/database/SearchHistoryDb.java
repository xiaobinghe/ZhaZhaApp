package com.locensate.letnetwork.database;

import org.litepal.crud.DataSupport;

/**
 * 数据库
 *
 * @author xiaobinghe
 */

public class SearchHistoryDb extends DataSupport {

    public long id;
    public String time;
    public String cont;
    public String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
