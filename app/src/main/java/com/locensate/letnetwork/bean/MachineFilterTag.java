package com.locensate.letnetwork.bean;

import java.io.Serializable;
import java.util.List;

/**
 * $String
 *
 * @author xiaobinghe
 */

public class MachineFilterTag implements Serializable {

    /**
     * operCode : 1
     * data : [{"isOpen":true,"singleCheck":0,"key":"经济运行","vals":[{"val":"经济运行"},{"val":"合理运行"},{"val":"非经济运行"}],"open":true},{"isOpen":true,"singleCheck":0,"key":"平均负载","vals":[{"val":"0-10%"},{"val":"10-20%"},{"val":"20-30%"},{"val":"30-40%"},{"val":"40-50%"},{"val":"50-60%"},{"val":"60-70%"},{"val":"70-80%"},{"val":"80-90%"},{"val":"90-100%"},{"val":"100%以上"}],"open":true},{"isOpen":true,"singleCheck":0,"key":"健康管理","vals":[{"val":"好"},{"val":"较好"},{"val":"较差"},{"val":"差"}],"open":true},{"isOpen":true,"singleCheck":0,"key":"开工率","vals":[{"val":"停机（0）"},{"val":"0-20%"},{"val":"20-40%"},{"val":"40-60%"},{"val":"60-80%"},{"val":"80%以上"}],"open":true},{"isOpen":true,"singleCheck":0,"key":"功率范围","vals":[{"val":"0-30"},{"val":"30-75"},{"val":"75-160"},{"val":"160-315"},{"val":"315-500"},{"val":"500-1000"},{"val":"1000-3000"},{"val":"3000以上"}],"open":true},{"isOpen":true,"singleCheck":0,"key":"设备类型","vals":[{"val":"风机"},{"val":"水泵"},{"val":"皮带机"},{"val":"破碎机"},{"val":"搅拌机"},{"val":"飞剪"},{"val":"空压机"},{"val":"冷剪"},{"val":"油泵"}],"open":true},{"isOpen":true,"singleCheck":0,"key":"电机类型","vals":[{"val":"三相异步电机"},{"val":"单相异步电机"}],"open":true},{"isOpen":true,"singleCheck":0,"key":"电压等级","vals":[{"val":"220V"},{"val":"380V"},{"val":"660V"},{"val":"3000V"},{"val":"6000V"},{"val":"10000v"}],"open":true},{"isOpen":true,"singleCheck":0,"key":"能效等级","vals":[{"val":"1级能效"},{"val":"2级能效"},{"val":"3级能效"},{"val":"普通能效"},{"val":"低效"}],"open":true},{"isOpen":true,"singleCheck":0,"key":"控制设备类型","vals":[{"val":"直接启动"},{"val":"星角启动"},{"val":"自耦启动"},{"val":"其他"},{"val":"变频器"},{"val":"软起动器"},{"val":"Fairford控制器"}],"open":true},{"isOpen":true,"singleCheck":0,"key":"安装时间","vals":[{"val":"1年"},{"val":"1-3年"},{"val":"3-6年"},{"val":"6-10年"},{"val":"10年以上"}],"open":true},{"isOpen":true,"singleCheck":0,"key":"经济运行","vals":[{"val":"经济运行"},{"val":"合理运行"},{"val":"非经济运行"}],"open":true},{"isOpen":true,"singleCheck":0,"key":"平均负载","vals":[{"val":"0-10%"},{"val":"10-20%"},{"val":"20-30%"},{"val":"30-40%"},{"val":"40-50%"},{"val":"50-60%"},{"val":"60-70%"},{"val":"70-80%"},{"val":"80-90%"},{"val":"90-100%"},{"val":"100%以上"}],"open":true},{"isOpen":true,"singleCheck":0,"key":"健康管理","vals":[{"val":"好"},{"val":"较好"},{"val":"较差"},{"val":"差"}],"open":true},{"isOpen":true,"singleCheck":0,"key":"开工率","vals":[{"val":"停机（0）"},{"val":"0-20%"},{"val":"20-40%"},{"val":"40-60%"},{"val":"60-80%"},{"val":"80%以上"}],"open":true},{"isOpen":true,"singleCheck":0,"key":"功率范围","vals":[{"val":"0-30"},{"val":"30-75"},{"val":"75-160"},{"val":"160-315"},{"val":"315-500"},{"val":"500-1000"},{"val":"1000-3000"},{"val":"3000以上"}],"open":true},{"isOpen":true,"singleCheck":0,"key":"设备类型","vals":[{"val":"风机"},{"val":"水泵"},{"val":"皮带机"},{"val":"破碎机"},{"val":"搅拌机"},{"val":"飞剪"},{"val":"空压机"},{"val":"冷剪"},{"val":"油泵"}],"open":true},{"isOpen":true,"singleCheck":0,"key":"电机类型","vals":[{"val":"三相异步电机"},{"val":"单相异步电机"}],"open":true},{"isOpen":true,"singleCheck":0,"key":"电压等级","vals":[{"val":"220V"},{"val":"380V"},{"val":"660V"},{"val":"3000V"},{"val":"6000V"},{"val":"10000v"}],"open":true},{"isOpen":true,"singleCheck":0,"key":"能效等级","vals":[{"val":"1级能效"},{"val":"2级能效"},{"val":"3级能效"},{"val":"普通能效"},{"val":"低效"}],"open":true},{"isOpen":true,"singleCheck":0,"key":"控制设备类型","vals":[{"val":"直接启动"},{"val":"星角启动"},{"val":"自耦启动"},{"val":"其他"},{"val":"变频器"},{"val":"软起动器"},{"val":"Fairford控制器"}],"open":true},{"isOpen":true,"singleCheck":0,"key":"安装时间","vals":[{"val":"1年"},{"val":"1-3年"},{"val":"3-6年"},{"val":"6-10年"},{"val":"10年以上"}],"open":true}]
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

    public static class DataBean implements Serializable{
        /**
         * isOpen : true
         * singleCheck : 0
         * key : 经济运行
         * vals : [{"val":"经济运行"},{"val":"合理运行"},{"val":"非经济运行"}]
         * open : true
         */

        private boolean isOpen;
        private int singleCheck;
        private String key;
        private boolean open;
        private List<ValsBean> vals;
        //设置选中的数据
        private List<ValsBean> SelectVals;

        public List<ValsBean> getSelectVals() {
            return SelectVals;
        }

        public void setSelectVals(List<ValsBean> selectVals) {
            SelectVals = selectVals;
        }

        private String showStr = "";

        public boolean isOpen() {
            return isOpen;
        }

        public String getShowStr() {
            return showStr;
        }

        public void setShowStr(String showStr) {
            this.showStr = showStr;
        }

        public void setIsOpen(boolean isOpen) {
            this.isOpen = isOpen;
        }

        public void setSingleCheck(int singleCheck) {
            this.singleCheck = singleCheck;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public void setOpen(boolean open) {
            this.open = open;
        }

        public void setVals(List<ValsBean> vals) {
            this.vals = vals;
        }

        public boolean getIsOpen() {
            return isOpen;
        }

        public int getSingleCheck() {
            return singleCheck;
        }

        public String getKey() {
            return key;
        }

        public boolean getOpen() {
            return open;
        }

        public List<ValsBean> getVals() {
            return vals;
        }

        public static class ValsBean implements Serializable{
            /**
             * val : 经济运行
             */

            private String val;
            private boolean isChick;

            public boolean isChick() {
                return isChick;
            }

            public void setChick(boolean chick) {
                isChick = chick;
            }

            public void setVal(String val) {
                this.val = val;
            }

            public String getVal() {
                return val;
            }
        }
    }
}
