package com.locensate.letnetwork.entity;

/**
 *
 * @author xiaobinghe
 */

public class FilterMark {

    public String des;
    public boolean isChecked;

    public FilterMark(String des, boolean isChecked) {
        this.des = des;
        this.isChecked = isChecked;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
