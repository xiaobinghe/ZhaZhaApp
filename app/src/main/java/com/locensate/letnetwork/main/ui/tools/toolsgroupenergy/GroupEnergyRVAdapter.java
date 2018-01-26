package com.locensate.letnetwork.main.ui.tools.toolsgroupenergy;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.GroupEnergyEntity;

import java.util.List;

/**
 *  
 * @author xiaobinghe
 */

public class GroupEnergyRVAdapter extends BaseQuickAdapter<GroupEnergyEntity, BaseViewHolder> {

    public GroupEnergyRVAdapter(int layoutResId, List<GroupEnergyEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, GroupEnergyEntity groupEnergyEntity) {
        baseViewHolder.setText(R.id.tv_group_class, groupEnergyEntity.getGroupName())
                .setText(R.id.tv_work_time, groupEnergyEntity.getWorkTime())
                .setText(R.id.tv_running_efficiency, groupEnergyEntity.getRunningEfficiency())
                .setText(R.id.tv_energy_used, groupEnergyEntity.getEnergyUsed())
                .addOnClickListener(R.id.fl_show_pop);
    }
}
