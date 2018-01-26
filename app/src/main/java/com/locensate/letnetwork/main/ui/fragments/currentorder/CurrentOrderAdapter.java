package com.locensate.letnetwork.main.ui.fragments.currentorder;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.OrderItemEntity;

import java.util.List;

/**
 *
 * @author xiaobinghe
 */


class CurrentOrderAdapter extends BaseQuickAdapter<OrderItemEntity, BaseViewHolder> {
    public CurrentOrderAdapter(int item_current_order, List<OrderItemEntity> data) {
        super(item_current_order, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, OrderItemEntity orderItemEntity) {
        baseViewHolder.setText(R.id.tv_current_order_num, orderItemEntity.getNum() + ".")
                .setText(R.id.tv_current_order_machine_id, orderItemEntity.getOrderId())
                .setText(R.id.tv_current_order_machine_name, orderItemEntity.getMachineName())
                .setText(R.id.tv_current_order_des, orderItemEntity.getOrderDes())
                .setText(R.id.tv_current_order_location, orderItemEntity.getLocation())
                .setText(R.id.tv_current_order_time, orderItemEntity.getTime())
                .setText(R.id.tv_current_order_dir, "负责人：" + orderItemEntity.getDir());
    }
}
