package com.locensate.letnetwork.main.ui.ordermsg;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.entity.OrderMsgEntity;

import java.util.List;


/**
 * @author xiaobinghe
 */

public class OrderMsgAdapter extends BaseQuickAdapter<OrderMsgEntity, BaseViewHolder> {

    OrderMsgAdapter(int item_msg_order, List<OrderMsgEntity> initDate) {
        super(item_msg_order, initDate);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, OrderMsgEntity orderMsgEntity) {

    }
}
