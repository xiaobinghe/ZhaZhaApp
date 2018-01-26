package com.locensate.letnetwork.view.filterview.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.bean.MachineFilterTag;
import com.locensate.letnetwork.view.filterview.ui.OnClickListenerWrapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 *  
 * @author xiaobinghe
 */

public class ScreeningListAdapter extends SimpleBaseAdapter<MachineFilterTag.DataBean.ValsBean> {
    private List<MachineFilterTag.DataBean.ValsBean> chickList;

    public ScreeningListAdapter(Context context, List<MachineFilterTag.DataBean.ValsBean> data) {
        super(context, data);
        chickList = new ArrayList<>();
    }

    @Override
    public int getItemResource() {
        return R.layout.item_right_sideslip_child_layout;
    }

    @Override
    public View getItemView(final int position, View convertView, ViewHolder holder) {
        TextView mubTv = holder.getView(R.id.brand_list_Tv);
        CheckBox brandCb = holder.getView(R.id.select_brand_cb);
        LinearLayout brandLay = holder.getView(R.id.select_brand_lay);
        final MachineFilterTag.DataBean.ValsBean topBrand = getData().get(position);

        brandCb.setVisibility(topBrand.isChick() ? View.VISIBLE : View.GONE);
        mubTv.setText((topBrand.getVal()));
        brandCb.setChecked(topBrand.isChick());

        brandLay.setOnClickListener(new OnClickListenerWrapper() {
            @Override
            protected void onSingleClick(View v) {
                boolean isSelect = !topBrand.isChick();
                // 再将当前选择CB的实际状态
                topBrand.setChick(isSelect);
                notifyDataSetChanged();

                if (isSelect) {
                    if (removeDuplicate(getAdapterChick()).size() >= 9) {
                        // ToastUtil.showSingleToast("抱歉，最多只能选择9个");
                        topBrand.setChick(false);
                        notifyDataSetChanged();
                        return;
                    } else {
                        removeDuplicate(getAdapterChick()).add(topBrand);
                    }

                } else {
                    removeDuplicate(getAdapterChick()).remove(topBrand);
                }
                mBack.setupClick();
            }

        });
        return convertView;
    }


    //去除重复数据
    public List<MachineFilterTag.DataBean.ValsBean> removeDuplicate(List<MachineFilterTag.DataBean.ValsBean> list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }

    public List<MachineFilterTag.DataBean.ValsBean> getAdapterChick() {
        return chickList;
    }

    public ClickBack mBack;

    public interface ClickBack {
        void setupClick();
    }

    public void setClickBack(ClickBack mBack) {
        this.mBack = mBack;
    }

    public boolean isEmptyAfterTrim(String s) {
        return TextUtils.isEmpty(s) || TextUtils.isEmpty(s.trim()) || "null".equals(s);
    }
}
