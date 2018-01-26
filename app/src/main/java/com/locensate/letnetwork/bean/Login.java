package com.locensate.letnetwork.bean;

import java.io.Serializable;


/**
 * 登录
 *
 * @author xiaobinghe
 */


public class Login implements Serializable {
    public String loginName;
    public String loginPassword;

    public Login(String loginName, String loginPsw) {
        this.loginName = loginName;
        this.loginPassword = loginPsw;
    }
}
