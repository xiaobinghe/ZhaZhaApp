package com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.repair;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.RepairEntity;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 *  
 * @author xiaobinghe
 */

public class FixRepairRvAdapter extends BaseQuickAdapter<RepairEntity, BaseViewHolder> {
    public FixRepairRvAdapter(int item_fix_order_msg, List<RepairEntity> fixRepairList) {
        super(item_fix_order_msg, fixRepairList);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, RepairEntity repairEntity) {
        View convertView = baseViewHolder.getConvertView();
        AutoUtils.autoSize(convertView);
        baseViewHolder.setText(R.id.tv_fix_order_time, repairEntity.getTime())
                .setText(R.id.tv_fix_order_des, repairEntity.getDes())
                .setText(R.id.tv_fix_order_person, repairEntity.getPerson());
    }
}
