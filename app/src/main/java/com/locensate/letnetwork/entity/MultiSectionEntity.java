package com.locensate.letnetwork.entity;

import com.locensate.letnetwork.main.ui.fragments.machine.GridItem;

import java.util.List;

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
 * 时间： 2017/1/3 14:43
 * <p>
 * 修改历史：
 * <p>
 * 修改时间：
 * <p>
 * 修改描述：
 * <p>
 * -------------------------------------
 */
public class MultiSectionEntity {
    public List<GridItem> items;
    public String title;
    public String id;
    public boolean isFolder;

    public boolean isFolder() {
        return isFolder;
    }

    public void setFolder(boolean folder) {
        isFolder = folder;
    }

    public List<GridItem> getItems() {
        return items;
    }

    public void setItems(List<GridItem> items) {
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MultiSectionEntity(String id, List<GridItem> items, String title, boolean isFolder) {
        this.id = id;
        this.items = items;
        this.title = title;
        this.isFolder = isFolder;
    }


}
