package com.locensate.letnetwork.bean;

import java.io.Serializable;
import java.util.List;

/**
 * $String
 *
 * @author xiaobinghe
 */

public class ControlDeviceLatest implements Serializable {


    /**
     * operCode : 1
     * data : [{"metric":"MS_Pfs","field":"","fields":["value"],"tags":["cbsn"],"rawCount":1,"groups":[{"groupInfos":[""],"values":[[1517371318000,0,"C1_B1_2_26001_171218_00010"]]}],"truncated":false,"nextMarker":""}]
     */

    private int operCode;
    private List<DataBean> data;

    public void setOperCode(int operCode) {
        this.operCode = operCode;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public int getOperCode() {
        return operCode;
    }

    public List<DataBean> getData() {
        return data;
    }

    public static class DataBean {
        /**
         * metric : MS_Pfs
         * field :
         * fields : ["value"]
         * tags : ["cbsn"]
         * rawCount : 1
         * groups : [{"groupInfos":[""],"values":[[1517371318000,0,"C1_B1_2_26001_171218_00010"]]}]
         * truncated : false
         * nextMarker :
         */

        private String metric;
        private String field;
        private int rawCount;
        private boolean truncated;
        private String nextMarker;
        private List<String> fields;
        private List<String> tags;
        private List<GroupsBean> groups;

        public void setMetric(String metric) {
            this.metric = metric;
        }

        public void setField(String field) {
            this.field = field;
        }

        public void setRawCount(int rawCount) {
            this.rawCount = rawCount;
        }

        public void setTruncated(boolean truncated) {
            this.truncated = truncated;
        }

        public void setNextMarker(String nextMarker) {
            this.nextMarker = nextMarker;
        }

        public void setFields(List<String> fields) {
            this.fields = fields;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public void setGroups(List<GroupsBean> groups) {
            this.groups = groups;
        }

        public String getMetric() {
            return metric;
        }

        public String getField() {
            return field;
        }

        public int getRawCount() {
            return rawCount;
        }

        public boolean getTruncated() {
            return truncated;
        }

        public String getNextMarker() {
            return nextMarker;
        }

        public List<String> getFields() {
            return fields;
        }

        public List<String> getTags() {
            return tags;
        }

        public List<GroupsBean> getGroups() {
            return groups;
        }

        public static class GroupsBean {
            /**
             * groupInfos : [""]
             * values : [[1517371318000,0,"C1_B1_2_26001_171218_00010"]]
             */

            private List<String> groupInfos;
            private List<List<Long>> values;

            public void setGroupInfos(List<String> groupInfos) {
                this.groupInfos = groupInfos;
            }

            public void setValues(List<List<Long>> values) {
                this.values = values;
            }

            public List<String> getGroupInfos() {
                return groupInfos;
            }

            public List<List<Long>> getValues() {
                return values;
            }
        }
    }
}
