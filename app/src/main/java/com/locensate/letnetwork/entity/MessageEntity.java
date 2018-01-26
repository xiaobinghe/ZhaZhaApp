package com.locensate.letnetwork.entity;

import java.io.Serializable;

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
 * 时间： 2016/12/21 9:57
 * <p>
 * 修改历史：
 * <p>
 * 修改时间：
 * <p>
 * 修改描述：
 * <p>
 * -------------------------------------
 */
public class MessageEntity implements Serializable {
    public String id;
    public String name;
    public String time;
    public String level;
    public String des;
    public String path;
    public boolean isChecked;
    public int num;

    public MessageEntity(String id, String des, String path, String name, String time, String level, int num, boolean isChecked) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.level = level;
        this.des = des;
        this.num = num;
        this.path = path;
        this.isChecked = isChecked;
    }


    public MessageEntity(String des, String path, String name, String time, int num, boolean isChecked) {
        this.des = des;
        this.path = path;
        this.name = name;
        this.time = time;
        this.num = num;
        this.isChecked = isChecked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", level='" + level + '\'' +
                ", des='" + des + '\'' +
                ", num=" + num +
                '}';
    }
}
