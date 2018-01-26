package com.locensate.letnetwork.main.ui.fragments.machine;

/**
 *  
 * @author xiaobinghe
 */


public class GridItem {
    public boolean isChecked;
    public String title;

    public GridItem(boolean isChecked, String title) {
        this.isChecked = isChecked;
        this.title = title;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
