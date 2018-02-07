package com.locensate.letnetwork.view.expandableview;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @author xiaobinghe
 */

public class Level1Item extends AbstractExpandableItem<Level2Item> implements MultiItemEntity {
    private int orgnizationId;
    public String title;
    public String subTitle;

    public Level1Item(String title, String subTitle, int organizationId) {
        this.subTitle = subTitle;
        this.title = title;
        this.orgnizationId = organizationId;
    }

    public int getOrgnizationId() {
        return orgnizationId;
    }

    public void setOrgnizationId(int orgnizationId) {
        this.orgnizationId = orgnizationId;
    }

    @Override
    public int getItemType() {
        return ExpandableItemAdapter.TYPE_LEVEL_1;
    }

    @Override
    public int getLevel() {
        return 1;
    }

    @Override
    public String toString() {
        return "Level1Item{" +
                "title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                '}';
    }
}