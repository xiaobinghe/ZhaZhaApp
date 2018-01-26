package com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.routing;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.RoutingEntity;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 *
 * @author xiaobinghe
 */

public class FixRoutingRvAdapter extends BaseQuickAdapter<RoutingEntity,BaseViewHolder> {
     FixRoutingRvAdapter(int item_fix_order_msg, List<RoutingEntity> routingList) {
        super(item_fix_order_msg,routingList);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, RoutingEntity routingEntity) {
        View convertView = baseViewHolder.getConvertView();
        AutoUtils.autoSize(convertView);
        baseViewHolder.setText(R.id.tv_fix_order_des,routingEntity.getRoutingDes())
                .setText(R.id.tv_fix_order_person,routingEntity.getDir())
                .setText(R.id.tv_fix_order_time,routingEntity.getTime());
    }
}
