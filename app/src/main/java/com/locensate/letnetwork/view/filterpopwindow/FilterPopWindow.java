package com.locensate.letnetwork.view.filterpopwindow;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.FilterEntity;
import com.locensate.letnetwork.utils.DisplayUtil;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.ToastUtil;

import java.util.List;

/**
 * @author xiaobinghe
 */


public class FilterPopWindow extends PopupWindow implements View.OnClickListener {

    private final RecyclerView rvFilter;
    private final List<FilterEntity> datas;
    private StringBuffer buffer = new StringBuffer();
    private final FilterRVAdapter filterRVAdapter;
    private Button bttOkay;
    private Button bttReset;

    public FilterPopWindow(Activity context, final List<FilterEntity> mData) {
        this.datas = mData;
        View inflate = context.getLayoutInflater().inflate(R.layout.layout_filter, null);
        this.setContentView(inflate);

        // 设置SelectPicPopupWindow弹出窗体的宽
//        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        int width = DisplayUtil.SCREEN_WIDTH_PIXELS * 5 / 6;
//        int width = DisplayUtil.SCREEN_WIDTH_PIXELS ;
        this.setWidth(width);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
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
        this.setAnimationStyle(R.style.animationFilter);


        rvFilter = (RecyclerView) inflate.findViewById(R.id.rv_filter);
        bttOkay = (Button) inflate.findViewById(R.id.btt_filter_okay);
        bttReset = (Button) inflate.findViewById(R.id.btt_filter_reset);

        bttOkay.setOnClickListener(this);
        bttReset.setOnClickListener(this);
        rvFilter.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        filterRVAdapter = new FilterRVAdapter(context, R.layout.layout_grid_item, R.layout.layout_grid_section, datas);
        rvFilter.setAdapter(filterRVAdapter);
        filterRVAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FilterEntity entity = datas.get(i);
                if (!entity.isHeader) {
                    entity.t.setChecked(!entity.t.isChecked());
                    baseQuickAdapter.notifyItemChanged(i);
                    if (entity.t.isChecked()) {
                        buffer.append(entity.t.getDes()).append("/");
                    }
                }
            }
        });
    }

    private void dismissPop() {
        this.dismiss();
    }

    public String getFilters() {
        return buffer.length() == 0 ? "" : buffer.toString();
    }

    public void show(View parent) {
        this.showAsDropDown(parent, 0, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btt_filter_okay:
                dismissPop();
                break;
            case R.id.btt_filter_reset:
                ToastUtil.show("Reset");
                resetData();
                break;
            default:
                break;
        }
    }

    private void resetData() {
        LogUtil.e("reset", "++++++++++++===========reset!");
        for (int i = 0; i < datas.size(); i++) {
            FilterEntity f = datas.get(i);
            if (!f.isHeader && f.t.isChecked()) {
                f.t.setChecked(false);
//                filterRVAdapter.notifyItemChanged(i);
            }
        }
        filterRVAdapter.notifyDataSetChanged();
        if (buffer.length() != 0) {
            buffer.delete(0, buffer.length());
        }
    }
}
