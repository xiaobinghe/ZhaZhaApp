package com.locensate.letnetwork.main.ui.deletemsg;

import android.content.Context;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.MessageEntity;

import java.util.ArrayList;

/**
 *
 * @author xiaobinghe
 */

public class RvDeleteAlertAdapter extends BaseQuickAdapter<MessageEntity, BaseViewHolder> {
    private final Context context;
    private final TextView tvNum;
    private final int page;

    public RvDeleteAlertAdapter(Context context, int item_message_fragment, ArrayList<MessageEntity> messages, TextView tvNum, int page) {
        super(item_message_fragment, messages);
        this.context = context;
        this.tvNum = tvNum;
        this.page = page;
    }


    @Override
    protected void convert(BaseViewHolder baseViewHolder, final MessageEntity messageEntity) {
        if (messageEntity.getNum() == 0) {
            baseViewHolder.setVisible(R.id.rl_order_msg_num, false);
        } else {
            baseViewHolder.setVisible(R.id.rl_order_msg_num, true);
        }
        baseViewHolder.setVisible(R.id.checkbox_item, true)
                .setChecked(R.id.checkbox_item, messageEntity.isChecked())
                .setText(R.id.tv_order_message, messageEntity.getDes())
                .setText(R.id.tv_order_occur_time, messageEntity.getTime())
                .setText(R.id.tv_order_machine_path, messageEntity.getPath())
                .setText(R.id.tv_order_machine, messageEntity.getName())
                .setText(R.id.tv_order_msg_num, String.valueOf(messageEntity.getNum()))
                .setVisible(R.id.rl_order_msg_num, false)
                .addOnClickListener(R.id.checkbox_item);
        if (page == 0) {
            if ("low".equals(messageEntity.getLevel())) {
                baseViewHolder.setBackgroundColor(R.id.ll_order_level, context.getResources().getColor(R.color.alert_low));
            } else {
                baseViewHolder.setBackgroundColor(R.id.ll_order_level, context.getResources().getColor(R.color.alert_high));
            }
        }
    }
}
