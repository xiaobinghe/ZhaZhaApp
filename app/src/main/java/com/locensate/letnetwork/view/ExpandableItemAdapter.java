package com.locensate.letnetwork.view;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.view.expandableview.Level0Item;
import com.locensate.letnetwork.view.expandableview.Level1Item;
import com.locensate.letnetwork.view.expandableview.Level2Item;

import java.util.List;

/**
 * Created by luoxw on 2016/8/9.
 */
public class ExpandableItemAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    private static final String TAG = ExpandableItemAdapter.class.getSimpleName();

    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
    public static final int TYPE_LEVEL_2 = 2;

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
                        .setImageResource(R.id.iv_level0_foot, lv0.isExpanded() ? R.drawable.open_white : R.drawable.close_white)
                        .setOnItemClickListener(R.id.tv_level0_title, new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        })
                        .setOnItemClickListener(R.id.iv_level1_foot, new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                int pos = holder.getAdapterPosition();
                                Log.d(TAG, "Level 0 item pos: " + pos);
                                if (lv0.isExpanded()) {
                                    collapse(pos);
                                } else {
//                            if (pos % 3 == 0) {
//                                expandAll(pos, false);
//                            } else {
                                    expand(pos);
//                            }
                                }
                            }
                        });
                break;
            case TYPE_LEVEL_1:
                final Level1Item lv1 = (Level1Item) item;
                holder.setText(R.id.tv_level1_title, lv1.title)
//                        .setText(R.id.sub_title, lv1.subTitle)
                        .setImageResource(R.id.iv_level1_foot, lv1.isExpanded() ? R.drawable.open_white : R.drawable.close_white)
                        .setOnItemClickListener(R.id.iv_level1_foot, new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                int pos = holder.getAdapterPosition();
                                Log.d(TAG, "Level 1 item pos: " + pos);
                                if (lv1.isExpanded()) {
                                    collapse(pos, false);
                                } else {
                                    expand(pos, false);
                                }
                            }
                        })
                        .setOnItemClickListener(R.id.tv_level1_title, new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        });
                break;
            case TYPE_LEVEL_2:
                final Level2Item level2Item = (Level2Item) item;
                holder.setText(R.id.tv_level2_title, level2Item.title)
                        .setOnItemClickListener(R.id.tv_level1_title, new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                int pos = holder.getAdapterPosition();

                            }
                        });
                break;
            default:
                break;
        }
    }
}
