package com.locensate.letnetwork.view.filterpopwindow;

import android.app.Activity;
import android.graphics.Color;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.FilterEntity;
import com.locensate.letnetwork.entity.FilterMark;

import java.util.List;

/**
 *
 * @author xiaobinghe
 */


public class FilterRVAdapter extends BaseSectionQuickAdapter<FilterEntity, BaseViewHolder> {
    private final Activity context;

    public FilterRVAdapter(Activity context, int layoutResId, int sectionHeadResId, List<FilterEntity> data) {
        super(layoutResId, sectionHeadResId, data);
        this.context=context;
    }

    @Override
    protected void convertHead(BaseViewHolder baseViewHolder, FilterEntity filterEntity) {
        baseViewHolder.setText(R.id.tv_filter_section, filterEntity.header);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, FilterEntity filterEntity) {
        FilterMark t = filterEntity.t;
        baseViewHolder.setText(R.id.tv_filter_item, t.getDes());
        if (t.isChecked()) {
            baseViewHolder.setTextColor(R.id.tv_filter_item, Color.WHITE)
                    .setBackgroundRes(R.id.cv_filter, R.drawable.shape_bg_filter_item_selected);

        } else {
            baseViewHolder.setTextColor(R.id.tv_filter_item, context.getResources().getColor(R.color.font_gray_font))
                    .setBackgroundRes(R.id.cv_filter,R.drawable.shape_bg_filter_item);

        }
    }
}
