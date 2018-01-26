package com.locensate.letnetwork.main.ui.deletemsg;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.OrderMsgEntity;

import java.util.List;

/**
 *
 * @author xiaobinghe
 */

public class RvDeleteEnergyAdapter extends BaseQuickAdapter<OrderMsgEntity, BaseViewHolder> {
    private final Context context;
    private final List<OrderMsgEntity> eneryMsgs;

    public RvDeleteEnergyAdapter(Context context, int item_message_fragment, List<OrderMsgEntity> energyMsg) {
        super(item_message_fragment, energyMsg);
        this.context = context;
        this.eneryMsgs = energyMsg;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, OrderMsgEntity entity) {
        if (entity.getNum() == 0) {
            baseViewHolder.setVisible(R.id.rl_order_msg_num, false);
        } else {
            baseViewHolder.setVisible(R.id.rl_order_msg_num, true);
        }

        baseViewHolder.setVisible(R.id.checkbox_item, true)
                .setText(R.id.tv_order_message, entity.getDes())
                .setText(R.id.tv_order_occur_time, entity.getTime())
                .setText(R.id.tv_order_machine_path, entity.getAddress())
                .setText(R.id.tv_order_machine, entity.getName())
                .setText(R.id.tv_order_msg_num, String.valueOf(entity.getNum()));
    }
}
