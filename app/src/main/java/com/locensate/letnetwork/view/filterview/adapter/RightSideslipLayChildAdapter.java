package com.locensate.letnetwork.view.filterview.adapter;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.bean.MachineFilterTag;
import com.locensate.letnetwork.view.filterview.ui.OnClickListenerWrapper;

import java.util.HashSet;
import java.util.List;


/**
 *
 * @author xiaobinghe
 */


public class RightSideslipLayChildAdapter extends SimpleBaseAdapter<MachineFilterTag.DataBean.ValsBean> {

    private List<MachineFilterTag.DataBean.ValsBean> seachData;

    public void setSeachData(List<MachineFilterTag.DataBean.ValsBean> seachData) {
        this.seachData = seachData;
    }

    public RightSideslipLayChildAdapter(Context context, List<MachineFilterTag.DataBean.ValsBean> data,
                                        List<MachineFilterTag.DataBean.ValsBean> selectVals) {
        super(context, data);
        this.seachData = selectVals;
    }

    @Override
    public int getItemResource() {
        return R.layout.gv_right_sideslip_child_layout;
    }

    @Override
    public View getItemView(final int position, View convertView, ViewHolder holder) {
        final CheckBox itemFrameRb = holder.getView(R.id.item_frameRb);


        MachineFilterTag.DataBean.ValsBean vals = getData().get(position);

        itemFrameRb.setText(vals.getVal());


        itemFrameRb.setTag(position);
        itemFrameRb.setChecked(vals.isChick());
        if ("查看更多 >".equals(vals.getVal())) {
            itemFrameRb.setBackgroundResource(0);
            itemFrameRb.setTextColor(itemFrameRb.getResources().getColor(R.color.colorPrimary));
        }
        itemFrameRb.setOnCheckedChangeListener(mOnCheckedChangeListener);
        return convertView;
    }

    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int position = (int) buttonView.getTag();
            final MachineFilterTag.DataBean.ValsBean vals = getData().get(position);
            buttonView.setOnClickListener(new OnClickListenerWrapper() {
                @Override
                protected void onSingleClick(View v) {
                    if ("查看更多 >".equals(vals.getVal())) {
                        mShowPopCallBack.setupShowPopCallBack(seachData);
                    }
                }
            });

            if (isChecked) {
                if ("查看更多 >".equals(vals.getVal())) {
                    return;
                }
                vals.setChick(true);
                seachData.add(vals);
            } else {
                if ("查看更多 >".equals(vals.getVal())) {
                    return;
                }
                vals.setChick(false);
                seachData.remove(vals);

            }
            notifyDataSetChanged();
            slidLayFrameChildCallBack.CallBackSelectData(removeDuplicate(seachData));


        }
    };
    //去除重复数据
    public List<MachineFilterTag.DataBean.ValsBean> removeDuplicate(List<MachineFilterTag.DataBean.ValsBean> list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }

    private SlidLayFrameChildCallBack slidLayFrameChildCallBack;

    public interface SlidLayFrameChildCallBack {
        void CallBackSelectData(List<MachineFilterTag.DataBean.ValsBean> seachData);
    }

    public void setSlidLayFrameChildCallBack(SlidLayFrameChildCallBack slidLayFrameChildCallBack) {
        this.slidLayFrameChildCallBack = slidLayFrameChildCallBack;
    }

    private ShowPopCallBack mShowPopCallBack;

    public interface ShowPopCallBack {
        void setupShowPopCallBack(List<MachineFilterTag.DataBean.ValsBean> seachData);
    }

    public void setShowPopCallBack(ShowPopCallBack mShowPopCallBack) {
        this.mShowPopCallBack = mShowPopCallBack;
    }

}