package com.locensate.letnetwork.view.expandableview;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.Constant;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.utils.SpUtil;

import java.util.List;

import static com.locensate.letnetwork.R.drawable.expand;


/**
 * @author xiaobinghe
 */


public class ExpandableItemAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    private static final String TAG = ExpandableItemAdapter.class.getSimpleName();

    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
    public static final int TYPE_LEVEL_2 = 2;

    public static StringBuilder showFiles;
    private final Context context;
    private final List<MultiItemEntity> data;
    private int isExpandedPos = 0;/*记录一级菜单展开的位置*/
    private int isExpandedPosLv1 = -1;/*记录二级菜单展开的位置*/
    private int selectPosition = -1;//The position of the selected item记录三级菜单被选中的位置

    public String s2;
    public String s1;
    public String s0 = SpUtil.getString(App.getApplication(), Constant.ENTERPRISE_NAME, "");
    private String sGroupName = SpUtil.getString(App.getApplication(), Constant.ENTERPRISE_NAME, "");
    private boolean child0Select = false;//marked second level selected
    private boolean child1Select = false;//标记第三极被选中
    private boolean isSelect1 = false;
    private boolean selectSubItem = false;//标记二级菜单无子item项的选中
    private boolean select0 = false;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ExpandableItemAdapter(List<MultiItemEntity> data, Context context) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.item_expandable_lv0);
        addItemType(TYPE_LEVEL_1, R.layout.item_expandable_lv1);
        addItemType(TYPE_LEVEL_2, R.layout.item_expandable_lv2);
        this.data = data;
        this.context = context;
    }


    @Override
    protected void convert(final BaseViewHolder holder, final MultiItemEntity item) {
        switch (holder.getItemViewType()) {
            case TYPE_LEVEL_0:
                final Level0Item lv0 = (Level0Item) item;
                holder.setText(R.id.tv_level0_title, lv0.title)
                        .setVisible(R.id.view_lv0, holder.getAdapterPosition() != (getItemCount() - 1))
                        .setImageResource(R.id.iv_level0_foot, !lv0.hasSubItem() ? 0 : lv0.isExpanded() ? R.drawable.open_white : R.drawable.close_white)
                        .setBackgroundColor(R.id.ll_expand_item_lv0, (lv0.isExpanded() || (!lv0.hasSubItem() && select0)) && !child0Select ? context.getResources().getColor(R.color.font_blue_tab) : context.getResources().getColor(R.color.bg_head));
                holder.itemView.setOnClickListener(new View.OnClickListener() {


                                                       @Override
                                                       public void onClick(View v) {
                                                           int pos = holder.getAdapterPosition();
                                                           s0 = lv0.title;
                                                           Log.e(TAG, "Level 0 item pos: " + pos + "((Level0Item) item).title========" + lv0.title);
                                                           /*选中项既是展开项*/
                                                           if (lv0.isExpanded()) {
                                                               /*关闭子条目下的展开项*/
                                                               collapseLv1();
                                                               /*关闭子条目*/
                                                               collapse(pos, false, true);
                                                               /*记录展开条目的位置*/
                                                               isExpandedPos = 0;
                                                               Log.e(TAG, "Level 0 item pos: " + pos + "((Level0Item) item).title========false");
                                                           } else {/*选中条目为关闭状态时*/
                                                               if (lv0.hasSubItem()) {
                                                                   select0 = false;
                                                                   /*已有其他展开条目*/
                                                                   if (isExpandedPos > 0) {
                                                                       /*当选中条目在已展开条目的下方时*/
                                                                       if (isExpandedPos < pos) {
                                                                           /*先展开选中条目*/
                                                                           expand(pos, false, true);
                                                                           Log.e(TAG, "expand: " + expand);
                                                                           /*关闭展开条目下自条目的展开项*/
                                                                           int collapse1 = collapseLv1();
                                                                           Log.e(TAG, "collapse1: " + collapse1);
                                                                           /*关闭展开条目*/
                                                                           int collapse2 = collapse(isExpandedPos, false, true);
                                                                           Log.e(TAG, "collapse2: " + collapse2);
                                                                           /*记录展开条目的位置*/
                                                                           isExpandedPos = pos - collapse1 - collapse2;
                                                                           Log.e(TAG, "isExpandedPos: " + isExpandedPos + "==isExpandedPos==" + isExpandedPos);

                                                                       } else {/*当选中条目在已展开条目的上方时*/
                                                                           /*关闭展开条目下的自条目的展开项*/
                                                                           collapseLv1();
                                                                           /*关闭展开条目*/
                                                                           collapse(isExpandedPos, false, true);
                                                                           /*展开选中条目*/
                                                                           expand(pos, false, true);
                                                                           /*记录展开条目的位置*/
                                                                           isExpandedPos = pos;
                                                                           Log.e(TAG, "expand+========: " + isExpandedPos);
                                                                       }
                                                                   } else {/*无其他展开条目*/
                                                                       /*展开选中条目*/
                                                                       expand(pos, false, true);
                                                                       /*记录展开条目的位置*/
                                                                       isExpandedPos = pos;
                                                                   }
                                                               } else {
                                                                   select0 = true;
                                                                   if (isExpandedPos > 0 && isExpandedPos != pos) {
                                                                       collapseLv1();
                                                                       collapse(isExpandedPos, false, false);
                                                                   }
                                                                   isExpandedPos = pos;
                                                                   notifyDataSetChanged();
                                                               }
                                                               Log.e(TAG, "Level 0 item pos: " + pos + "((Level0Item) item).title========true++++++++++++++expand=" + isExpandedPos);
                                                           }
                                                           sGroupName = new StringBuilder().append(s0).toString();
                                                           Log.e(TAG, "convert: isExpandedPos=" + isExpandedPos);
                                                       }
                                                   }
                );
                break;
            case TYPE_LEVEL_1:
                final Level1Item lv1 = (Level1Item) item;
                holder.setText(R.id.tv_level1_title, lv1.title)
//                        .setText(R.id.tv_level1_subtitle, lv1.subTitle)
//                        .setBackgroundColor(R.id.ll_expand_item_lv1, !lv1.hasSubItem() ? context.getResources().getColor(R.color.ground_line) : lv1.isExpanded() && child1Select == false ? context.getResources().getColor(R.color.font_blue_tab) : context.getResources().getColor(R.color.ground_line))
                        .setBackgroundColor(R.id.ll_expand_item_lv1, (lv1.isExpanded() || (!lv1.hasSubItem() && selectSubItem)) && child0Select && !child1Select ? context.getResources().getColor(R.color.font_blue_tab) : context.getResources().getColor(R.color.ground_line))
                        .setImageResource(R.id.iv_level1_foot, lv1.hasSubItem() ? lv1.isExpanded() ? R.drawable.open : R.drawable.close : 0);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                                                       @Override
                                                       public void onClick(View v) {
                                                           int pos = holder.getAdapterPosition();
                                                           s1 = lv1.title;
                                                           resetItem3Status();/*重置3级item项未选中*/
                                                           Log.e(TAG, "Level 0 item pos: " + pos + "((Level0Item) item).title========" + lv1.title);
                                                           /*选中项既是展开项*/
                                                           if (lv1.isExpanded()) {
                                                               /*取消二级菜单选中*/
                                                               child0Select = false;
                                                               /*取消三级菜单选中*/
                                                               child1Select = false;
                                                               /*关闭展开项*/
                                                               collapse(pos, false, true);
                                                               /*记录展开项*/
                                                               isExpandedPosLv1 = -1;
                                                               Log.e(TAG, "Level 0 item pos: " + pos + "((Level0Item) item).title========false");
                                                               sGroupName = new StringBuilder().append(s0).toString();
                                                           } else {/*选中项不是展开项*/
                                                               child0Select = true;
                                                               /*设置二级菜单选中*/
                                                               if (lv1.hasSubItem()) {
                                                                   /*无子item项取消选中*/
                                                                   selectSubItem = false;
                                                                   /*已有其他展开项*/
                                                                   if (isExpandedPosLv1 > -1) {
                                                                       resetItem3Status();
                                                                       /*选中项在已展开项下方*/
                                                                       if (isExpandedPosLv1 < pos) {
                                                                           /*关闭展开项*/
                                                                           int collapse = collapse(isExpandedPosLv1, false, true);
                                                                           /*记录展开项位置*/
                                                                           isExpandedPosLv1 = pos - collapse;
                                                                           /*展开选中项*/
                                                                           expand(pos - collapse, false, true);
                                                                       } else {/*选中项在已展开项上方*/
                                                                           /*关闭展开项*/
                                                                           collapse(isExpandedPosLv1, false, true);
                                                                           /*记录展开项位置*/
                                                                           isExpandedPosLv1 = pos;
                                                                           /*展开选中项*/
                                                                           expand(pos, false, true);
                                                                           Log.e(TAG, "onClick: isthere?==true");
                                                                       }
                                                                   } else {/*无其他展开项*/
                                                                       /*展开选中项*/
                                                                       expand(pos, false, true);
                                                                       /*记录展开项位置*/
                                                                       isExpandedPosLv1 = pos;
                                                                   }
                                                               } else {
                                                                   if (isExpandedPosLv1 > -1 && isExpandedPosLv1 != pos) {
                                                                       child1Select = false;
                                                                       resetItem3Status();
                                                                       /*关闭展开项*/
                                                                       collapse(isExpandedPosLv1, false, true);
                                                                   }
                                                                   /*设置无子item项选中*/
                                                                   selectSubItem = true;
                                                                   isExpandedPosLv1 = pos;
                                                                   notifyDataSetChanged();
                                                               }
                                                               sGroupName = new StringBuilder().append(s0).append("/").append(s1).toString();
                                                           }
                                                           Log.e(TAG, "convert: isExpandedPos=" + isExpandedPosLv1);
                                                       }
                                                   }
                );
                break;
            case TYPE_LEVEL_2:
                final Level2Item level2Item = (Level2Item) item;
                holder.setText(R.id.tv_level2_title, level2Item.title)
                        .setBackgroundColor(R.id.ll_expand_item_lv2, level2Item.isSelected() ? context.getResources().getColor(R.color.font_blue_tab) : context.getResources().getColor(R.color.bg));
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        child1Select = true;
                        resetItem3Status();
                        level2Item.setSelected(!level2Item.isSelected());
                        s2 = level2Item.title;
                        selectPosition = holder.getAdapterPosition();
                        sGroupName = new StringBuilder().append(s0).append("/").append(s1).append("/").append(s2).toString();
                        notifyDataSetChanged();
                    }
                });
                break;
            default:
                break;
        }
    }

    /**
     * Cancel the selected item of third level
     */
    private void resetItem3Status() {
        if (-1 != selectPosition) {
            Level2Item selectedItem = (Level2Item) getItem(selectPosition);
            selectedItem.setSelected(false);
            selectPosition = -1;
        }
    }

    public String getsGroupName() {
        return sGroupName;
    }

    private int collapseLv1() {
        child1Select = false;
        resetItem3Status();
        if (isExpandedPosLv1 > -1) {
            child0Select = false;
            selectSubItem = false;
            int collapse = collapse(isExpandedPosLv1, false, true);
            isExpandedPosLv1 = -1;
            return collapse;
        } else {
            return 0;
        }
    }
}
