package com.locensate.letnetwork.view.expandableview;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;


/**
 *
 * @author xiaobinghe
 */

public class Level0Item extends AbstractExpandableItem<Level1Item> implements MultiItemEntity {
    private  int organizationId;
    public String title;
    public String subTitle;

    public Level0Item(String title, String subTitle, int organizationId) {
        this.subTitle = subTitle;
        this.title = title;
        this.organizationId = organizationId;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    @Override
    public int getItemType() {
        return ExpandableItemAdapter.TYPE_LEVEL_0;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public String toString() {
        return "Level0Item{" +
                "title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                '}';
    }
}