package com.locensate.letnetwork.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 组织结构
 *
 * @author xiaobinghe
 */


public class Organizations implements Serializable {

    /**
     * operCode : 1
     * data : [{"sort":0,"status":1,"organizationId":1,"organizationName":"沙钢","organizationDescription":"沙钢","organizationDepth":1,"subOrganization":[{"sort":0,"status":1,"organizationId":3,"organizationName":"焦化厂","organizationDescription":"焦化厂","organizationDepth":2,"organizationParentId":1,"leaf":false},{"sort":0,"status":1,"organizationId":2,"organizationName":"烧结厂","organizationDescription":"烧结厂","organizationDepth":2,"subOrganization":[{"sort":0,"status":1,"organizationId":5,"organizationName":"老线","organizationDescription":"老线","organizationDepth":3,"organizationParentId":2,"leaf":true},{"sort":0,"status":1,"organizationId":4,"organizationName":"新线","organizationDescription":"新线","organizationDepth":3,"organizationParentId":2,"leaf":true}],"organizationParentId":1,"leaf":true}],"organizationParentId":0,"leaf":false}]
     */

    private int operCode;
    private List<DataBean> data;

    public int getOperCode() {
        return operCode;
    }

    public void setOperCode(int operCode) {
        this.operCode = operCode;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * sort : 0
         * status : 1
         * organizationId : 1
         * organizationName : 沙钢
         * organizationDescription : 沙钢
         * organizationDepth : 1
         * subOrganization : [{"sort":0,"status":1,"organizationId":3,"organizationName":"焦化厂","organizationDescription":"焦化厂","organizationDepth":2,"organizationParentId":1,"leaf":false},{"sort":0,"status":1,"organizationId":2,"organizationName":"烧结厂","organizationDescription":"烧结厂","organizationDepth":2,"subOrganization":[{"sort":0,"status":1,"organizationId":5,"organizationName":"老线","organizationDescription":"老线","organizationDepth":3,"organizationParentId":2,"leaf":true},{"sort":0,"status":1,"organizationId":4,"organizationName":"新线","organizationDescription":"新线","organizationDepth":3,"organizationParentId":2,"leaf":true}],"organizationParentId":1,"leaf":true}]
         * organizationParentId : 0
         * leaf : false
         */

        private int sort;
        private int status;
        private int organizationId;
        private String organizationName;
        private String organizationDescription;
        private int organizationDepth;
        private int organizationParentId;
        private boolean leaf;
        private List<SubOrganizationBeanX> subOrganization;

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getOrganizationId() {
            return organizationId;
        }

        public void setOrganizationId(int organizationId) {
            this.organizationId = organizationId;
        }

        public String getOrganizationName() {
            return organizationName;
        }

        public void setOrganizationName(String organizationName) {
            this.organizationName = organizationName;
        }

        public String getOrganizationDescription() {
            return organizationDescription;
        }

        public void setOrganizationDescription(String organizationDescription) {
            this.organizationDescription = organizationDescription;
        }

        public int getOrganizationDepth() {
            return organizationDepth;
        }

        public void setOrganizationDepth(int organizationDepth) {
            this.organizationDepth = organizationDepth;
        }

        public int getOrganizationParentId() {
            return organizationParentId;
        }

        public void setOrganizationParentId(int organizationParentId) {
            this.organizationParentId = organizationParentId;
        }

        public boolean isLeaf() {
            return leaf;
        }

        public void setLeaf(boolean leaf) {
            this.leaf = leaf;
        }

        public List<SubOrganizationBeanX> getSubOrganization() {
            return subOrganization;
        }

        public void setSubOrganization(List<SubOrganizationBeanX> subOrganization) {
            this.subOrganization = subOrganization;
        }

        public static class SubOrganizationBeanX {
            /**
             * sort : 0
             * status : 1
             * organizationId : 3
             * organizationName : 焦化厂
             * organizationDescription : 焦化厂
             * organizationDepth : 2
             * organizationParentId : 1
             * leaf : false
             * subOrganization : [{"sort":0,"status":1,"organizationId":5,"organizationName":"老线","organizationDescription":"老线","organizationDepth":3,"organizationParentId":2,"leaf":true},{"sort":0,"status":1,"organizationId":4,"organizationName":"新线","organizationDescription":"新线","organizationDepth":3,"organizationParentId":2,"leaf":true}]
             */

            private int sort;
            private int status;
            private int organizationId;
            private String organizationName;
            private String organizationDescription;
            private int organizationDepth;
            private int organizationParentId;
            private boolean leaf;
            private List<SubOrganizationBean> subOrganization;

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getOrganizationId() {
                return organizationId;
            }

            public void setOrganizationId(int organizationId) {
                this.organizationId = organizationId;
            }

            public String getOrganizationName() {
                return organizationName;
            }

            public void setOrganizationName(String organizationName) {
                this.organizationName = organizationName;
            }

            public String getOrganizationDescription() {
                return organizationDescription;
            }

            public void setOrganizationDescription(String organizationDescription) {
                this.organizationDescription = organizationDescription;
            }

            public int getOrganizationDepth() {
                return organizationDepth;
            }

            public void setOrganizationDepth(int organizationDepth) {
                this.organizationDepth = organizationDepth;
            }

            public int getOrganizationParentId() {
                return organizationParentId;
            }

            public void setOrganizationParentId(int organizationParentId) {
                this.organizationParentId = organizationParentId;
            }

            public boolean isLeaf() {
                return leaf;
            }

            public void setLeaf(boolean leaf) {
                this.leaf = leaf;
            }

            public List<SubOrganizationBean> getSubOrganization() {
                return subOrganization;
            }

            public void setSubOrganization(List<SubOrganizationBean> subOrganization) {
                this.subOrganization = subOrganization;
            }

            public static class SubOrganizationBean {
                /**
                 * sort : 0
                 * status : 1
                 * organizationId : 5
                 * organizationName : 老线
                 * organizationDescription : 老线
                 * organizationDepth : 3
                 * organizationParentId : 2
                 * leaf : true
                 */

                private int sort;
                private int status;
                private int organizationId;
                private String organizationName;
                private String organizationDescription;
                private int organizationDepth;
                private int organizationParentId;
                private boolean leaf;

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public int getOrganizationId() {
                    return organizationId;
                }

                public void setOrganizationId(int organizationId) {
                    this.organizationId = organizationId;
                }

                public String getOrganizationName() {
                    return organizationName;
                }

                public void setOrganizationName(String organizationName) {
                    this.organizationName = organizationName;
                }

                public String getOrganizationDescription() {
                    return organizationDescription;
                }

                public void setOrganizationDescription(String organizationDescription) {
                    this.organizationDescription = organizationDescription;
                }

                public int getOrganizationDepth() {
                    return organizationDepth;
                }

                public void setOrganizationDepth(int organizationDepth) {
                    this.organizationDepth = organizationDepth;
                }

                public int getOrganizationParentId() {
                    return organizationParentId;
                }

                public void setOrganizationParentId(int organizationParentId) {
                    this.organizationParentId = organizationParentId;
                }

                public boolean isLeaf() {
                    return leaf;
                }

                public void setLeaf(boolean leaf) {
                    this.leaf = leaf;
                }
            }
        }
    }
}
