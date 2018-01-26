package com.locensate.letnetwork.entity;

/**
 * -------------------------------------
 * <p>
 * 项目名称： MotorTesting
 * <p>
 * 版权：locensate.com 版权所有 2016
 * <p>
 * 公司主页：http://www.locensate.com/
 * <p>
 * 描述：
 * <p>
 * 作者： xiaobinghe
 * <p>
 * 时间： 2016/12/20 12:28
 * <p>
 * 修改历史：
 * <p>
 * 修改时间：
 * <p>
 * 修改描述：
 * <p>
 * -------------------------------------
 */
public class MsgEntity {
    public String title;
    public String time;
    public String des;
    public int msg_num;

    public MsgEntity(String title, String time, String des, int msg_num) {
        this.title = title;
        this.time = time;
        this.des = des;
        this.msg_num = msg_num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getMsg_num() {
        return msg_num;
    }

    public void setMsg_num(int msg_num) {
        this.msg_num = msg_num;
    }

    @Override
    public String toString() {
        return "MsgEntity{" +
                "title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", des='" + des + '\'' +
                ", msg_num=" + msg_num +
                '}';
    }
}
