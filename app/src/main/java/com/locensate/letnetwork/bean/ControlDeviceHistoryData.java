package com.locensate.letnetwork.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * $String
 *
 * @author xiaobinghe
 */

public class ControlDeviceHistoryData implements Serializable{


    /**
     * operCode : 1
     * data : [{"time":1517370446674,"value":22.1},{"time":1517370448674,"value":22.1},{"time":1517370450674,"value":22.1},{"time":1517370452674,"value":22.1},{"time":1517370454674,"value":22.1},{"time":1517370456674,"value":22.1},{"time":1517370458674,"value":22.1},{"time":1517370460674,"value":22.1},{"time":1517370462674,"value":22.1},{"time":1517370464674,"value":22.1},{"time":1517370466674,"value":22.1},{"time":1517370468674,"value":22.1},{"time":1517370470674,"value":22.1},{"time":1517370472674,"value":22.1},{"time":1517370474674,"value":22.1},{"time":1517370476674,"value":22.1},{"time":1517370478674,"value":22.1},{"time":1517370482000,"value":22.1},{"time":1517370484000,"value":22.1},{"time":1517370486000,"value":22.1},{"time":1517370488000,"value":22.1},{"time":1517370490000,"value":22.1},{"time":1517370492000,"value":22.1},{"time":1517370494000,"value":22.1},{"time":1517370496000,"value":22.1},{"time":1517370498000,"value":22.1},{"time":1517370500000,"value":22.1},{"time":1517370502000,"value":22.1},{"time":1517370504000,"value":22.1},{"time":1517370506000,"value":22.1},{"time":1517370508000,"value":22.1},{"time":1517370510000,"value":22.1},{"time":1517370512000,"value":22.1},{"time":1517370514000,"value":22.1},{"time":1517370516000,"value":22.1},{"time":1517370518000,"value":22.1},{"time":1517370520000,"value":22.1},{"time":1517370522000,"value":22.1},{"time":1517370524000,"value":22.1},{"time":1517370526000,"value":22.1},{"time":1517370528000,"value":22.1},{"time":1517370530000,"value":22.1},{"time":1517370532000,"value":22.1},{"time":1517370534000,"value":22.1},{"time":1517370536000,"value":22.1},{"time":1517370538000,"value":22.1},{"time":1517370540000,"value":22.1},{"time":1517370542000,"value":22.1},{"time":1517370544000,"value":22.1},{"time":1517370546000,"value":22.1},{"time":1517370546674,"value":22.1}]
     */

    private int operCode;
    private List<DataBean> data;

    public static ControlDeviceHistoryData objectFromData(String str) {

        return new Gson().fromJson(str, ControlDeviceHistoryData.class);
    }

    public static ControlDeviceHistoryData objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), ControlDeviceHistoryData.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<ControlDeviceHistoryData> arrayControlDeviceHistoryDataFromData(String str) {

        Type listType = new TypeToken<ArrayList<ControlDeviceHistoryData>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<ControlDeviceHistoryData> arrayControlDeviceHistoryDataFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<ControlDeviceHistoryData>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

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
         * time : 1517370446674
         * value : 22.1
         */

        private long time;
        private double value;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public static DataBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), DataBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<DataBean> arrayDataBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<DataBean> arrayDataBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<DataBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public void setTime(long time) {
            this.time = time;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public long getTime() {
            return time;
        }

        public double getValue() {
            return value;
        }
    }
}
