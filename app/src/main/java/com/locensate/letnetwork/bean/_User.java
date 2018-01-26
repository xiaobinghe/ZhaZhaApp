package com.locensate.letnetwork.bean;

import java.io.Serializable;


/**
 *  用户
 * @author xiaobinghe
 */

public class _User implements Serializable {


    /**
     * operCode : 1
     * data : {"userId":1,"uuid":"d93843e7-e6bf-4ef1-80d5-e968d013ca5f","realName":"王克","userAvatar":"/files/uploadfile/1501046368910.jpg","organization":{"organizationId":0,"subWholeEquipment":null},"role":{"roleId":1,"roleName":"沙钢管理员","roleDescription":"沙钢管理员"}}
     */

    private int operCode;
    private DataBean data;

    public void setOperCode(int operCode) {
        this.operCode = operCode;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getOperCode() {
        return operCode;
    }

    public DataBean getData() {
        return data;
    }

    public static class DataBean {
        /**
         * userId : 1
         * uuid : d93843e7-e6bf-4ef1-80d5-e968d013ca5f
         * realName : 王克
         * userAvatar : /files/uploadfile/1501046368910.jpg
         * organization : {"organizationId":0,"subWholeEquipment":null}
         * role : {"roleId":1,"roleName":"沙钢管理员","roleDescription":"沙钢管理员"}
         */

        private int userId;
        private String uuid;
        private String realName;
        private String userAvatar;
        private OrganizationBean organization;
        private RoleBean role;

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public void setUserAvatar(String userAvatar) {
            this.userAvatar = userAvatar;
        }

        public void setOrganization(OrganizationBean organization) {
            this.organization = organization;
        }

        public void setRole(RoleBean role) {
            this.role = role;
        }

        public int getUserId() {
            return userId;
        }

        public String getUuid() {
            return uuid;
        }

        public String getRealName() {
            return realName;
        }

        public String getUserAvatar() {
            return userAvatar;
        }

        public OrganizationBean getOrganization() {
            return organization;
        }

        public RoleBean getRole() {
            return role;
        }

        public static class OrganizationBean {
            /**
             * organizationId : 0
             * subWholeEquipment : null
             */

            private int organizationId;
            private Object subWholeEquipment;

            public void setOrganizationId(int organizationId) {
                this.organizationId = organizationId;
            }

            public void setSubWholeEquipment(Object subWholeEquipment) {
                this.subWholeEquipment = subWholeEquipment;
            }

            public int getOrganizationId() {
                return organizationId;
            }

            public Object getSubWholeEquipment() {
                return subWholeEquipment;
            }
        }

        public static class RoleBean {
            /**
             * roleId : 1
             * roleName : 沙钢管理员
             * roleDescription : 沙钢管理员
             */

            private int roleId;
            private String roleName;
            private String roleDescription;

            public void setRoleId(int roleId) {
                this.roleId = roleId;
            }

            public void setRoleName(String roleName) {
                this.roleName = roleName;
            }

            public void setRoleDescription(String roleDescription) {
                this.roleDescription = roleDescription;
            }

            public int getRoleId() {
                return roleId;
            }

            public String getRoleName() {
                return roleName;
            }

            public String getRoleDescription() {
                return roleDescription;
            }
        }
    }
}
