package com.locensate.letnetwork.view.filterview.adapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.bean.MachineFilterTag;
import com.locensate.letnetwork.view.filterview.ui.AutoMeasureHeightGridView;
import com.locensate.letnetwork.view.filterview.ui.OnClickListenerWrapper;

import java.util.ArrayList;
import java.util.List;


/**
 * RightSideslipLayAdapter
 *
 * @author xiaobinghe
 */

public class RightSideslipLayAdapter extends SimpleBaseAdapter<MachineFilterTag.DataBean> {

    public RightSideslipLayAdapter(Context context, List<MachineFilterTag.DataBean> data) {
        super(context, data);
    }

    @Override
    public int getItemResource() {
        return R.layout.item_right_sideslip_lay;
    }


    @Override
    public View getItemView(int position, View convertView, ViewHolder holder) {
        TextView itemFrameTitleTv = holder.getView(R.id.item_frameTv);
        TextView itemFrameSelectTv = holder.getView(R.id.item_selectTv);
        LinearLayout layoutItem = holder.getView(R.id.item_select_lay);
        AutoMeasureHeightGridView itemFrameGv = holder.getView(R.id.item_selectGv);
        itemFrameGv.setVisibility(View.VISIBLE);
        MachineFilterTag.DataBean mAttr = getData().get(position);
        itemFrameTitleTv.setText(mAttr.getKey());
        itemFrameSelectTv.setText(mAttr.getShowStr());
        if (mAttr.getVals() != null) {
            convertView.setVisibility(View.VISIBLE);
            if (mAttr.getIsOpen()) {
                itemFrameSelectTv.setTag(itemFrameGv);
                itemFrameSelectTv.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_up_prodcatelist, 0);
                fillLv2CateViews(mAttr, mAttr.getVals(), itemFrameGv);
                layoutItem.setTag(itemFrameGv);
            } else {
                if (mAttr.getVals().size() > 3) {
                    fillLv2CateViews(mAttr, mAttr.getVals().subList(0, 3), itemFrameGv);
                } else {
                    fillLv2CateViews(mAttr, mAttr.getVals(), itemFrameGv);
                }
                itemFrameSelectTv.setText(mAttr.getShowStr());
                itemFrameSelectTv.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_down_prodcatelist, 0);
                layoutItem.setTag(itemFrameGv);
                itemFrameSelectTv.setVisibility(View.VISIBLE);
            }
            layoutItem.setOnClickListener(onClickListener);
        } else {
            convertView.setVisibility(View.GONE);
        }
        itemFrameGv.setTag(position);
        return convertView;
    }

    private void fillLv2CateViews(final MachineFilterTag.DataBean mAttr, List<MachineFilterTag.DataBean.ValsBean> list,
                                  AutoMeasureHeightGridView childLvGV) {
        final RightSideslipLayChildAdapter mChildAdapter;
        if (mAttr.getSelectVals() == null) {
            mAttr.setSelectVals(new ArrayList<MachineFilterTag.DataBean.ValsBean>());
        }
        if (childLvGV.getAdapter() == null) {
            mChildAdapter = new RightSideslipLayChildAdapter(context, list, mAttr.getSelectVals());
            childLvGV.setAdapter(mChildAdapter);
        } else {
            mChildAdapter = (RightSideslipLayChildAdapter) childLvGV.getAdapter();
            mAttr.setSelectVals(mAttr.getSelectVals());
            mChildAdapter.setSeachData(mAttr.getSelectVals());
            mChildAdapter.replaceAll(list);
        }

        mChildAdapter.setSlidLayFrameChildCallBack(new RightSideslipLayChildAdapter.SlidLayFrameChildCallBack() {
            @Override
            public void CallBackSelectData(List<MachineFilterTag.DataBean.ValsBean> seachData) {
                mAttr.setShowStr(setupSelectStr(seachData));
                mAttr.setSelectVals(seachData);
                notifyDataSetChanged();
                selechDataCallBack.setupAttr(setupSelectDataStr(seachData), mAttr.getKey());

            }
        });
        mChildAdapter.setShowPopCallBack(new RightSideslipLayChildAdapter.ShowPopCallBack() {
            @Override
            public void setupShowPopCallBack(List<MachineFilterTag.DataBean.ValsBean> seachData) {
                mAttr.setSelectVals(seachData);
                mAttr.setShowStr(setupSelectStr(seachData));
                mSelechMoreCallBack.setupMore(seachData);
            }
        });

    }

    private String setupSelectStr(List<MachineFilterTag.DataBean.ValsBean> data) {
        StringBuilder builder = new StringBuilder();
        if (data != null) {
            for (int i = 0; i < data.size(); i++) {
                if (data.size() == 1) {
                    builder.append(data.get(i).getVal());
                } else {
                    if (i == data.size() - 1) {
                        builder.append(data.get(i).getVal());
                    } else {
                        builder.append(data.get(i).getVal() + ",");
                    }
                }

            }
            return new String(builder);
        } else {
            return "";
        }
    }

    private List<String> setupSelectDataStr(List<MachineFilterTag.DataBean.ValsBean> data) {
        List<String> mSelectData = new ArrayList<String>();
        if (data != null) {
            for (int i = 0; i < data.size(); i++) {
                mSelectData.add(data.get(i).getVal());
            }
            return mSelectData;
        } else {
            return null;
        }

    }


    OnClickListenerWrapper onClickListener = new OnClickListenerWrapper() {
        @Override
        protected void onSingleClick(View v) {
            int id = v.getId();
            if (id == R.id.item_select_lay) {
                AutoMeasureHeightGridView childLv3GV = (AutoMeasureHeightGridView) v.getTag();
                int pos = (int) childLv3GV.getTag();
                MachineFilterTag.DataBean itemdata = data.get(pos);
                boolean isSelect = !itemdata.isOpen();
                // 再将当前选择CB的实际状态
                itemdata.setIsOpen(isSelect);
                notifyDataSetChanged();
            }
        }
    };

    public interface SelechDataCallBack {
        void setupAttr(List<String> mSelectData, String key);
    }

    public SelechDataCallBack selechDataCallBack;

    public void setAttrCallBack(SelechDataCallBack m) {
        selechDataCallBack = m;
    }

    public interface SelechMoreCallBack {
        void setupMore(List<MachineFilterTag.DataBean.ValsBean> da);
    }

    public SelechMoreCallBack mSelechMoreCallBack;

    public void setMoreCallBack(SelechMoreCallBack m) {
        mSelechMoreCallBack = m;

    }
}
