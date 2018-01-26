package com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.order;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.OrderMsgEntity;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 *
 * @author xiaobinghe
 */

public class FixOrderAdapter extends BaseQuickAdapter<OrderMsgEntity, BaseViewHolder> {

    public FixOrderAdapter(int layoutItem, List<OrderMsgEntity> orderList) {
        super(layoutItem, orderList);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, OrderMsgEntity entity) {
        View convertView = baseViewHolder.getConvertView();
        AutoUtils.autoSize(convertView);
        baseViewHolder.setText(R.id.tv_fix_order_des,entity.getDes())
                .setText(R.id.tv_fix_order_person,entity.getName())
                .setText(R.id.tv_fix_order_time,entity.getTime());
    }
}
