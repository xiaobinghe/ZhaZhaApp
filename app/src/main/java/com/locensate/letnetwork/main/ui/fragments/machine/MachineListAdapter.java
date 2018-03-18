package com.locensate.letnetwork.main.ui.fragments.machine;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.bean.MotorListEntity;

import java.text.DecimalFormat;
import java.util.List;


/**
 * 设备列表
 *
 * @author xiaobinghe
 */

public class MachineListAdapter extends BaseQuickAdapter<MotorListEntity.DataBean.ListBean, BaseViewHolder> {

    private final Context context;

    public MachineListAdapter(Context context, int item_machine_list, List<MotorListEntity.DataBean.ListBean> machines) {
        super(item_machine_list, machines);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder machineViewHolder, MotorListEntity.DataBean.ListBean machineBean) {
        DecimalFormat df = new DecimalFormat("0.000");
        DecimalFormat dfInt = new DecimalFormat("0");

        machineViewHolder.setText(R.id.tv_machine_item_name, machineBean.getMachine_name())
                .setText(R.id.tv_machine_item_path, machineBean.getOrganization())
                .setText(R.id.tv_machine_item_control_machine, "控制设备：" + machineBean.getControl_equipment_model())
                .setText(R.id.tv_machine_item_average_efficiency, machineBean.getIs_measure() == 1 ? df.format(machineBean.getAverage_efficiency()) : "--")
                .setText(R.id.tv_machine_item_default_power, isInt(machineBean)?dfInt.format(machineBean.getRated_power()):String.valueOf(machineBean.getRated_power()))
                .setText(R.id.tv_machine_item_health_code, machineBean.getIs_measure() == 1 ? dfInt.format(machineBean.getHealth_score()) : "--")
                .setVisible(R.id.iv_machine_item_is_impotent, machineBean.getIs_important() == 1)
                .setVisible(R.id.tv_machine_item_is_measure, machineBean.getIs_measure() == 1)
                .addOnClickListener(R.id.cv_machine);
    }

    private boolean isInt(MotorListEntity.DataBean.ListBean machineBean) {
        double rated_power = machineBean.getRated_power();
        int power = (int) rated_power;
        return rated_power==power;
    }
}
