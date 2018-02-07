package com.locensate.letnetwork.view.expandableview;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 *
 * @author xiaobinghe
 */

public class Level2Item implements MultiItemEntity {
    private  int organizationId;
    public String title;
    public String subtitle;
    public boolean selected;

    public Level2Item(String title, String subtitle, boolean selected, int organizationId) {
        this.title = title;
        this.subtitle = subtitle;
        this.selected = selected;
        this.organizationId=organizationId;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    @Override
    public int getItemType() {
        return ExpandableItemAdapter.TYPE_LEVEL_2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "Level2Item{" +
                "title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                '}';
    }
}
