package com.locensate.letnetwork.entity;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 *
 * @author xiaobinghe
 */


public class FilterEntity extends SectionEntity<FilterMark> {
    public FilterEntity(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public FilterEntity(FilterMark s) {
        super(s);
    }
}
