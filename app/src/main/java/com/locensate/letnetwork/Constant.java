package com.locensate.letnetwork;


/**
 * @author xiaobinghe
 */


public class Constant {

    public static final boolean DEBUG = Boolean.parseBoolean("true");
    public static final String CONFIG = "sp";
    /**
     * 登录时是否记住密码
     */
    public static final String REMEMBER_PSW = "remember_psw";
    /**
     * 保存的用户名
     */
    public static final String USER_NAME = "user_name";
    /**
     * 保存的用户密码
     */
    public static final String USER_PSW = "user_psw";


    /**
     * Http config
     */
    public static final String BASE_URL = "http://139.224.237.93:8081/";

    /**
     * 登录是返回的用户信息
     */
    public static final String USER = "user";
    public static final String UUID = "uuid";
    /**
     * 企业ID
     */
    public static final String ENTERPRISE_ID = "enterprise_id";
    /**
     * 接受消息通知
     */
    public static final String ACCEPT_NOTICE = "accept_notice";
    /**
     * 振动提醒
     */
    public static final String SHAKE_NOTICE = "shake_notice";
    /**
     * 声音提醒
     */
    public static final String VOICE_NOTICE = "voice_notice";
    /**
     * 添加工单页面添加设备的请求码
     */
    public static final int REQUEST_ADD_MACHINE_FROM_ADD_ORDER = 0x3333;
    /**
     * 添加设备页面返回工单页面的返回码
     */
    public static final int RESULT_ADD_MACHINE_TO_ADD_ORDER = 0x4444;
    /**
     * 企业名
     */
    public static final String ENTERPRISE_NAME = "enterprise_name";

    /**
     * 报警级别：高报警/低报警
     */
    public static final String ALERT_HIGH = "high";
    public static final String ALERT_LOW = "low";


    /**
     * 升降序
     */
    public static final String ASC = "ASC";
    public static final String DESC = "DESC";
    /**
     * 聚合方式：max and avg
     */
    public static String AGG_MAX = "MAX";
    public static String AGG_AVG = "AVG";
}
