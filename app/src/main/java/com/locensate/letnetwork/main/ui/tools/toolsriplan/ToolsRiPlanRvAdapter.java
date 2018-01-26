package com.locensate.letnetwork.main.ui.tools.toolsriplan;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.RoutingEntity;

import java.util.List;

/**
 *
 * @author xiaobinghe
 */

public class ToolsRiPlanRvAdapter extends BaseQuickAdapter<RoutingEntity, BaseViewHolder> {
     ToolsRiPlanRvAdapter(int layoutResId, List<RoutingEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, RoutingEntity routingEntity) {
        baseViewHolder.setText(R.id.tv_order_machine, routingEntity.getMachineName())
                .setText(R.id.tv_order_machine_path, routingEntity.getLocation())
                .setText(R.id.tv_order_time, routingEntity.getTime())
                .setText(R.id.tv_order_des, routingEntity.getRoutingDes())
                .setText(R.id.tv_order_person, routingEntity.getDir());

    }
}
