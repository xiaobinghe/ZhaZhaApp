package com.locensate.letnetwork.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author xiaobinghe
 */

public class DateUtils {

    private DateUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 输入日期获取对应的日期
     *
     * @param sdfTo    获取的日期类型，Date对象，long 毫秒值，String 字符串日期
     * @param defValue 输入要转换的日期，Date对象，long 毫秒值，String 字符串日期
     * @return 要求获取的类型的日期
     */
    public static Object getData(String sdfTo, Date defValue) {
        return getData(sdfTo, null, defValue);
    }

    /**
     * 输入日期获取对应的日期
     *
     * @param sdfTo    获取的日期类型，Date对象，long 毫秒值，String 字符串日期
     * @param defValue 输入要转换的日期，Date对象，long 毫秒值，String 字符串日期
     * @return 要求获取的类型的日期
     */
    public static Object getData(String sdfTo, long defValue) {
        return getData(sdfTo, null, defValue);
    }

    /**
     * 输入日期获取对应的日期
     *
     * @param sdfTo    获取的日期类型，Date对象，long 毫秒值，String 字符串日期
     * @param sdfFrom  输入要转换的日期类型，Date对象，long 毫秒值，String 字符串日期
     * @param defValue 输入要转换的日期，Date对象，long 毫秒值，String 字符串日期
     * @return 要求获取的类型的日期
     */
    public static Object getData(String sdfTo, String sdfFrom, Object defValue) {
        String type = defValue.getClass().getSimpleName();
        Date date;
        if ("Integer".equals(type) || "Long".equals(type)) {
            date = new Date((Long) defValue);
        } else if ("Date".equals(type)) {
            date = (Date) defValue;
        } else if ("String".equals(type)) {
            SimpleDateFormat sdf = new SimpleDateFormat(sdfFrom);
            try {
                date = sdf.parse((String) defValue);
            } catch (ParseException e) {
                throw new RuntimeException("the date type parse exception!");
            }

        } else {
            throw new RuntimeException("the date type illgel!");
        }
        if (DateType.DATE.equals(sdfTo)) {
            return date;
        } else if (DateType.DATETIME.equals(sdfTo)) {
            return date.getTime();
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(sdfTo);
            return sdf.format(date);
        }

    }

    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 比较两个日期的大小（-2转换异常0相等1大于-1小于）
     */
    public static int compareDate(Date dateF, Date dateS) {
        try {
            if (dateF.getTime() > dateS.getTime()) {
                return 1;
            } else if (dateF.getTime() < dateS.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return -2;
        }

    }

    /**
     * 获得指定年和月的天数
     */
    public static int getMonthLastDay(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        /** 把日期设置为当月第一天 */
        a.set(Calendar.DATE, 1);
        /** 日期回滚一天，也就是最后一天 */
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 获得指定天在当月的天索引
     */
    public static int getDayOfMonth(Date date) {
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        aCalendar.setTime(date);
        int day = aCalendar.getActualMaximum(Calendar.DATE);
        return day;
    }


    /**
     * 获取当天是星期几
     */
    public static String getDateToWeek(Date date) {
        Calendar c = Calendar.getInstance(Locale.CHINA);
        c.setTime(date);
        String mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
        if ("1".equals(mWay)) {
            mWay = "天";
        } else if ("2".equals(mWay)) {
            mWay = "一";
        } else if ("3".equals(mWay)) {
            mWay = "二";
        } else if ("4".equals(mWay)) {
            mWay = "三";
        } else if ("5".equals(mWay)) {
            mWay = "四";
        } else if ("6".equals(mWay)) {
            mWay = "五";
        } else if ("7".equals(mWay)) {
            mWay = "六";
        }
        return "周" + mWay;
    }

    /**
     * 返回某日所属周的第一天和最后一天
     *
     * @param date
     * @param
     * @return
     */
    public static Date[] getFirstAndEndDayDateOfWeek(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置时间格式
        Date[] dates = new Date[2];
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        LogUtil.e("getFirstDayDateofWeek", "要计算日期为:" + sdf.format(cal.getTime()));//输出要计算日期

        //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }

        cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一

        int day = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);//根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        System.out.println("所在周星期一的日期：" + sdf.format(cal.getTime()));
        System.out.println(cal.getFirstDayOfWeek() + "-" + day + "+6=" + (cal.getFirstDayOfWeek() - day + 6));
        dates[0] = cal.getTime();
        cal.add(Calendar.DATE, 6);
        System.out.println("所在周星期日的日期：" + sdf.format(cal.getTime()));
        dates[1] = cal.getTime();
        return dates;
    }

    public static String getTime(Date date, String timeType1) {

        SimpleDateFormat simpleDateFormat;
        switch (timeType1) {
            case "小时":
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH时");
                break;
            case "时分":
                simpleDateFormat = new SimpleDateFormat("HH:mm");
                break;
            case "时分秒":
                simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                break;
            case "天":
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                break;
            case "周":
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                break;
            case "月":
                simpleDateFormat = new SimpleDateFormat("yyyy-MM");
                break;
            case "":
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                break;
            default:
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                break;
        }
        return simpleDateFormat.format(date);
    }

    public static int getMondayPlus() {
        Calendar cd = Calendar.getInstance();
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1) {
            return -6;
        } else {
            return 2 - dayOfWeek;
        }
    }

    // 获得当前周- 周一的日期
    public static String getCurrentMonday() {
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }


    // 获得当前周- 周日  的日期
    public static String getPreviousSunday() {
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 6);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    // 获得当前月--开始日期
    public static String getMinMonthDate(String date) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(date));
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            return dateFormat.format(calendar.getTime());
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 获得当前月--结束日期
    public static String getMaxMonthDate(String date) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(date));
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            return dateFormat.format(calendar.getTime());
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    static class DateType {

        /**
         * 输出类型 Date
         */
        public static String DATE = "DATE";
        /**
         * 输出类型 Datetime
         */
        public static String DATETIME = "DATETIME";
        /**
         * 输出类型
         */
        public static String sdf_yyyyMMddHHmmss = "yyyyMMddHHmmss";
        public static String sdf_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
        public static String sdf_yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";
        public static String sdf_yyyy_MM_dd = "yyyy-MM-dd";
        public static String sdf_HH_mm_ss = "HH:mm:ss";
        public static String sdf_yyyy = "yyyy";
        public static String sdf_MM = "MM";
        public static String sdf_dd = "dd";
        public static String sdf_HH_mm = "HH:mm";
    }

}
