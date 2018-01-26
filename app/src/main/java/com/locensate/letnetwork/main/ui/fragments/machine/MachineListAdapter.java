package com.locensate.letnetwork.main.ui.fragments.machine;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.bean.MachineDataBean;

import java.util.List;


/**
 * 设备列表
 *
 * @author xiaobinghe
 */

public class MachineListAdapter extends BaseQuickAdapter<MachineDataBean, BaseViewHolder> {

    private final Context context;

    public MachineListAdapter(Context context, int item_machine_list, List<MachineDataBean> machines) {
        super(item_machine_list, machines);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder machineViewHolder, MachineDataBean machineBean) {
        machineViewHolder.setText(R.id.tv_machine_item_name, machineBean.getName())
                .setText(R.id.tv_machine_item_path, machineBean.getPath())
                .setText(R.id.tv_machine_item_control_machine, "控制设备：" + machineBean.getControlMachine())
                .setText(R.id.tv_machine_item_average_efficiency, machineBean.isMeasure() ? machineBean.getEfficiencyAverage() : "--")
                .setText(R.id.tv_machine_item_default_power, machineBean.getDefaultPower())
                .setText(R.id.tv_machine_item_health_code, machineBean.isMeasure() ? machineBean.getHealthCode() : "--")
                .setVisible(R.id.iv_machine_item_is_impotent, machineBean.isImportant())
                .setVisible(R.id.tv_machine_item_is_measure, machineBean.isMeasure())
                .addOnClickListener(R.id.cv_machine);
    }
}
