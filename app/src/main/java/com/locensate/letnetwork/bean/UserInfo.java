package com.locensate.letnetwork.bean;

import java.io.Serializable;

/**
 * 用户信息
 *
 * @author xiaob
 */
public class UserInfo implements Serializable {


    /**
     * operCode : 1
     * msg : 修改用户成功
     * data : {"loginPassword":"用户登录密码","organization":{"organizationId":1},"realName":"真实姓名","userAvatar":"用户头像地址","userEmail":"用户新乡","userId":"用户id","userTel":"用户电话"}
     */

    private int operCode;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * loginPassword : 用户登录密码
         * organization : {"organizationId":1}
         * realName : 真实姓名
         * userAvatar : 用户头像地址
         * userEmail : 用户新乡
         * userId : 用户id
         * userTel : 用户电话
         */


        private String loginPassword;
        private OrganizationBean organization;
        private String realName;
        private String userAvatar;
        private String userEmail;
        private long userId;
        private String userTel;

        public DataBean(String userAvatar, long userId) {
            this.userAvatar = userAvatar;
            this.userId = userId;
        }

        public String getLoginPassword() {
            return loginPassword;
        }

        public void setLoginPassword(String loginPassword) {
            this.loginPassword = loginPassword;
        }

        public OrganizationBean getOrganization() {
            return organization;
        }

        public void setOrganization(OrganizationBean organization) {
            this.organization = organization;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getUserAvatar() {
            return userAvatar;
        }

        public void setUserAvatar(String userAvatar) {
            this.userAvatar = userAvatar;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getUserTel() {
            return userTel;
        }

        public void setUserTel(String userTel) {
            this.userTel = userTel;
        }

        public static class OrganizationBean {
            /**
             * organizationId : 1
             */

            private int organizationId;

            public int getOrganizationId() {
                return organizationId;
            }

            public void setOrganizationId(int organizationId) {
                this.organizationId = organizationId;
            }
        }
    }
}
