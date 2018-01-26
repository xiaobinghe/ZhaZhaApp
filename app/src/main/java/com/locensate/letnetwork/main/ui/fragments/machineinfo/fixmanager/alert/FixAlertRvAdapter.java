package com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.alert;

import android.content.Context;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.Constant;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.MessageEntity;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * alertAdapter
 *
 * @author xiaobinghe
 */
class FixAlertRvAdapter extends BaseQuickAdapter<MessageEntity, BaseViewHolder> {


    private Context context;

    protected FixAlertRvAdapter(Context context, int itemLayout, List<MessageEntity> alertList) {
        super(itemLayout, alertList);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, MessageEntity messageEntity) {
        View convertView = viewHolder.getConvertView();
        AutoUtils.autoSize(convertView);
        context.getResources();
        viewHolder.setText(R.id.tv_fix_alert_machine_name, messageEntity.getName())
                .setText(R.id.tv_fix_alert_des, messageEntity.getDes())
                .setText(R.id.tv_fix_alert_time, messageEntity.getTime());
        if (Constant.ALERT_HIGH.equals(messageEntity.getLevel())) {
            viewHolder.setImageResource(R.id.iv_fix_alert_level, R.drawable.btn_alarm1);
        } else {
            viewHolder.setImageResource(R.id.iv_fix_alert_level, R.drawable.btn_alarm4);
        }
    }
}
