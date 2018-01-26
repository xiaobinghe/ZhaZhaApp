package com.locensate.letnetwork.main.ui.tools.toolsorder;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.OrderMsgEntity;

import java.util.List;

/**
 *  
 * @author xiaobinghe
 */

public class ToolsOrderRVAdapter extends BaseQuickAdapter<OrderMsgEntity,BaseViewHolder> {


    public ToolsOrderRVAdapter(int layoutResId, List<OrderMsgEntity> data) {
        super(layoutResId, data);
    }

    /**
     * @param baseViewHolder
     * @param
     */
    @Override
    protected void convert(BaseViewHolder baseViewHolder, OrderMsgEntity entity) {
            baseViewHolder.setText(R.id.tv_order_person,entity.getName())
                    .setText(R.id.tv_order_time,entity.getTime())
                    .setText(R.id.tv_order_des,entity.getDes())
                    .setText(R.id.tv_order_machine,"测试水泵")
                    .setText(R.id.tv_order_machine_path,entity.getAddress());
    }
}
