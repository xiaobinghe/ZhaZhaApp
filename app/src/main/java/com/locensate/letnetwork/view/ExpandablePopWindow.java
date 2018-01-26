package com.locensate.letnetwork.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.utils.DisplayUtil;
import com.locensate.letnetwork.view.expandableview.ExpandableItemAdapter;

import java.util.List;

/**
 *
 * @author xiaobinghe
 */


public class ExpandablePopWindow extends PopupWindow {


    private RecyclerView rvExpandable;

    public ExpandablePopWindow(final Activity context, List<MultiItemEntity> entities) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View conentView = inflater.inflate(R.layout.layout_expandable_view, null);


        // 设置SelectPicPopupWindow的View
        this.setContentView(conentView);
        // 设置SelectPicPopupWindow弹出窗体的宽
//        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        int width = DisplayUtil.SCREEN_WIDTH_PIXELS * 2 / 3;
        this.setWidth(width);
        // 设置SelectPicPopupWindow弹出窗体的高
        int height = DisplayUtil.SCREEN_HEIGHT_PIXELS * 2 / 3;

//        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setHeight(height);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
        this.update();
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0000000000);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(dw);

        // 设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.custom_dialog_style);

        rvExpandable = (RecyclerView) conentView.findViewById(R.id.rv_expandable_view);
        rvExpandable.setLayoutManager(new LinearLayoutManager(context));
        ExpandableItemAdapter adapter = new ExpandableItemAdapter(entities, context);
        rvExpandable.setAdapter(adapter);
        adapter.expand(0, false, true);

    }


    /**
     * 显示popupWindow
     *
     * @param parent
     */
    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            // 以下拉方式显示popupwindow
            this.showAsDropDown(parent, 5, 0);
        } else {
            this.dismiss();
        }
    }

    //点击事件回调
    public interface OnItemClickListener {
        void onClick(int position);
    }

    public String getPath() {
        ExpandableItemAdapter adapter = (ExpandableItemAdapter) rvExpandable.getAdapter();
        adapter.getsGroupName();
        return adapter.getsGroupName();
    }
}
