package com.locensate.letnetwork.main.ui.fragments.historyorder;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.OrderItemEntity;

import java.util.List;

/**
 *  
 * @author xiaobinghe
 */

public class HistoryOrderAdapter extends BaseQuickAdapter<OrderItemEntity, BaseViewHolder> {
    public HistoryOrderAdapter(int item_history_order, List<OrderItemEntity> data) {
        super(item_history_order, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, OrderItemEntity orderItemEntity) {
        baseViewHolder.setText(R.id.tv_history_order_num, orderItemEntity.getNum() + ".")
                .setText(R.id.tv_history_order_des, orderItemEntity.getOrderDes())
                .setText(R.id.tv_history_order_location, orderItemEntity.getLocation())
                .setText(R.id.tv_history_order_machine_id, orderItemEntity.getOrderId())
                .setText(R.id.tv_history_order_machine_name, orderItemEntity.getMachineName())
                .setText(R.id.tv_history_order_time, orderItemEntity.getTime())
                .setTag(R.id.tv_history_order_dir, orderItemEntity.getDir());
    }

}
