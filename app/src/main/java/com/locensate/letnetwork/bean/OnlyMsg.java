package com.locensate.letnetwork.bean;

import java.io.Serializable;


/**
 * onlyMsg
 *
 * @author xiaobinghe
 */

public class OnlyMsg implements Serializable {

    /**
     * operCode : 1
     * msg :
     */

    public int operCode;
    public String msg;

    public int getOperCode() {
        return operCode;
    }

    public void setOperCode(int operCode) {
        this.operCode = operCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
