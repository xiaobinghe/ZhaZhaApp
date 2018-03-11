package com.locensate.letnetwork.utils;

import com.locensate.letnetwork.Constant;

/**
 * $String
 *
 * @author xiaobinghe
 */

public class AggLinkedUtil {

    public static String getAgg(String timeType) {
        switch (timeType) {
            case "十分钟":
                return "";
            case "一小时":
            case "一天":
            case "一周":
            case "一月":
                return Constant.AGG_AVG;
            default:
                return Constant.AGG_AVG;
        }
    }


    public static String getSampling(String timeType) {
        switch (timeType) {
            case "十分钟":
                return "";
            case "一小时":
            case "小时":
                return "10 second";
            case "一天":
            case "天":
                return "5 minute";
            case "一周":
            case "周":
                return "30 minute";
            case "一月":
            case "月":
                return "24 hour";
            default:
                return "";
        }
    }

    public static String getInterpolation(String timeType) {
        switch (timeType) {
            case "十分钟":
            case "一小时":
            case "小时":
                return "2 second";
            case "一天":
            case "天":
                return "10 second";
            case "一周":
            case "周":
                return "15 second";
            case "一月":
            case "月":
                return "1 minute";
            default:
                return "2 second";
        }
    }
}
