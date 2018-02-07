package com.locensate.letnetwork.view;

import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.view.expandableview.Level0Item;
import com.locensate.letnetwork.view.expandableview.Level1Item;
import com.locensate.letnetwork.view.expandableview.Level2Item;

import java.util.List;


/**
 * @author xiaobinghe
 */

public class ExpandableItemAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    private static final String TAG = ExpandableItemAdapter.class.getSimpleName();

    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
    public static final int TYPE_LEVEL_2 = 2;
    private String path;
    private SelectComplete selectComplete;


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ExpandableItemAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.item_expandable_lv0);
        addItemType(TYPE_LEVEL_1, R.layout.item_expandable_lv1);
        addItemType(TYPE_LEVEL_2, R.layout.item_expandable_lv2);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final MultiItemEntity item) {
        switch (holder.getItemViewType()) {
            case TYPE_LEVEL_0:
                final Level0Item lv0 = (Level0Item) item;
                holder.setText(R.id.tv_level0_title, lv0.title)
                        .setVisible(R.id.view_lv0, holder.getAdapterPosition() != (getItemCount() - 1))
                        .setVisible(R.id.iv_level0_foot, lv0.hasSubItem() ? true : false)
                        .setImageResource(R.id.iv_level0_foot, lv0.isExpanded() ? R.drawable.open_white : R.drawable.close_white);

                holder.getView(R.id.iv_level0_foot).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int pos = holder.getAdapterPosition();
                        Log.d(TAG, "Level 0 item pos: " + pos);
                        if (lv0.isExpanded()) {
                            collapse(pos);
                        } else {
                            expand(pos);
                        }
                    }
                });
                holder.getView(R.id.tv_level0_title).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        path = lv0.title;
                        selectComplete.onSelectComplete(path);
                    }
                });
                break;
            case TYPE_LEVEL_1:
                final Level1Item lv1 = (Level1Item) item;
                holder.setText(R.id.tv_level1_title, lv1.title)
//                        .setText(R.id.sub_title, lv1.subTitle)
                        .setVisible(R.id.iv_level1_foot, lv1.hasSubItem() ? true : false)
                        .setImageResource(R.id.iv_level1_foot, lv1.isExpanded() ? R.drawable.open : R.drawable.close);
                holder.getView(R.id.iv_level1_foot).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int pos = holder.getAdapterPosition();
                        Log.d(TAG, "Level 1 item pos: " + pos);
                        if (lv1.isExpanded()) {
                            collapse(pos, false);
                        } else {
                            expand(pos, false);
                        }
                    }
                });
                holder.getView(R.id.tv_level1_title).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        path = new StringBuilder(lv1.subTitle).append("/").append(lv1.title).toString();
                        selectComplete.onSelectComplete(path);
                    }
                });
                break;
            case TYPE_LEVEL_2:
                final Level2Item level2Item = (Level2Item) item;
                holder.setText(R.id.tv_level2_title, level2Item.title);
                holder.getView(R.id.tv_level2_title).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int pos = holder.getAdapterPosition();
                        path = new StringBuilder(level2Item.subtitle).append("/").append(level2Item.title).toString();
                        selectComplete.onSelectComplete(path);
                    }
                });
                break;
            default:
                break;
        }
    }


    interface SelectComplete {
        /**
         * select completed
         *
         * @param path
         */
        void onSelectComplete(String path);
    }

    public void setSelectComplete(SelectComplete selectComplete) {
        this.selectComplete = selectComplete;
    }
}
