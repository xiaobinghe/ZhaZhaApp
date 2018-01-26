package com.locensate.letnetwork.main.ui.message.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.entity.MessageEntity;
import com.locensate.letnetwork.main.ui.AlertDetailActivity;
import com.locensate.letnetwork.main.ui.message.MessageBaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 *  
 * @author xiaobinghe
 */


public class AlertMessageFragment extends MessageBaseFragment {
    private static AlertMessageFragment instance;

    private boolean isAddListener = false;

    public static AlertMessageFragment getInstance() {
        if (null == instance) {
            instance = new AlertMessageFragment();
        }
        return instance;
    }

    @Override
    protected void addClickListener(RecyclerView rvAlertMessage) {
        if (!isAddListener) {
            rvAlertMessage.addOnItemTouchListener(new OnItemClickListener() {
                @Override
                public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    MessageEntity item = (MessageEntity) baseQuickAdapter.getItem(i);
                    Intent intent = new Intent(getActivity(), AlertDetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("alertMsg", item);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
            isAddListener = true;
        }
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        return new AlertMessageAdapter(R.layout.item_message_alert_fragment, getItems());
    }

    @Override
    protected void lazyLoad() {

    }

    public List<MessageEntity> getItems() {
        ArrayList<MessageEntity> initDate = new ArrayList<>();
        initDate.add(new MessageEntity("", "输入端缺相", "一车间/烧结厂/某钢厂", "通风机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()), "high", 1, false));
        initDate.add(new MessageEntity("", "启动限流", "一车间/烧结厂/某钢厂", "冲压机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()-5600000L), "low", 4, false));
        initDate.add(new MessageEntity("", "温度过高", "一车间/烧结厂/某钢厂", "卷板机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()-7200000L), "high", 1, false));
        initDate.add(new MessageEntity("", "三相不平衡", "一车间/烧结厂/某钢厂", "通风机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()-10800000L), "low", 3, false));
        initDate.add(new MessageEntity("", "输入端缺相", "一车间/烧结厂/某钢厂", "空调设备", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()-13600000L), "low", 2, false));
        return initDate;
    }

    private class AlertMessageAdapter extends BaseQuickAdapter<MessageEntity, BaseViewHolder> {
        public AlertMessageAdapter(int item_message_fragment, List<MessageEntity> items) {
            super(item_message_fragment, items);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, MessageEntity messageEntity) {
            baseViewHolder.setText(R.id.tv_alert_message, messageEntity.getDes())
                    .setText(R.id.tv_alert_occur_time, messageEntity.getTime())
                    .setText(R.id.tv_alert_machine_path, messageEntity.getPath())
                    .setText(R.id.tv_alert_machine, messageEntity.getName())
                    .setText(R.id.tv_alert_msg_num, String.valueOf(messageEntity.getNum()));
            if ("low".equals(messageEntity.getLevel())) {
                baseViewHolder.setBackgroundColor(R.id.ll_alert_level, getResources().getColor(R.color.alert_low));
            } else {
                baseViewHolder.setBackgroundColor(R.id.ll_alert_level, getResources().getColor(R.color.alert_high));
            }

        }
    }
}
