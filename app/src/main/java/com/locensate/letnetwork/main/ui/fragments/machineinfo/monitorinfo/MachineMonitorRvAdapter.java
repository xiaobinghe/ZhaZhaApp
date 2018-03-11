package com.locensate.letnetwork.main.ui.fragments.machineinfo.monitorinfo;

import android.content.Context;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.utils.LogUtil;

import java.text.DecimalFormat;
import java.util.List;

/**
 * @author xiaobinghe
 */

public class MachineMonitorRvAdapter extends BaseSectionQuickAdapter<MonitoringData, BaseViewHolder> {

    private final Context context;

    MachineMonitorRvAdapter(int layoutResId, int sectionHeadResId, List<MonitoringData> data, Context context) {
        super(layoutResId, sectionHeadResId, data);
        this.context = context;
    }

    @Override
    protected void convertHead(BaseViewHolder baseViewHolder, MonitoringData monitoringData) {

        boolean readBreak = monitoringData.isReadBreak();
        boolean remoteParameter = monitoringData.isRemoteParameter();

        baseViewHolder.setVisible(R.id.iv_section_head_warn, readBreak)
                .setText(R.id.tv_section_head_key, monitoringData.getMonitorEquipmentName() + "  " + monitoringData.header)
                .setTextColor(R.id.tv_section_head_key, context.getResources().getColor(readBreak ? R.color.red_warn : R.color.font_deep_blue))
                .setVisible(R.id.tv_section_head_value, remoteParameter)
                .addOnClickListener(R.id.tv_section_head_value);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MonitoringData monitoringData) {
        RunningStateEntity data = (RunningStateEntity) monitoringData.t;
        DecimalFormat df = new DecimalFormat("0.000");
        String header = data.getHeader();
        LogUtil.e("RunningStateEntity", "---Value--" + data.getValue());
        baseViewHolder.setText(R.id.tv_section_content_key, data.getKey());

        if (data.getValue() == 88888888) {
            baseViewHolder.setText(R.id.tv_section_content_value, "—");
        } else if (header.equals("电机统计数据")) {
            switch (data.getKey()) {
                case "轴功率":
                    baseViewHolder.setText(R.id.tv_section_content_value, df.format(data.getValue()) + "kW");
                    break;
                case "近5分钟电子过热":
                    LogUtil.e("getValue", "-------" + data.getValue());
                    baseViewHolder.setText(R.id.tv_section_content_value, df.format(data.getValue() * 100) + "%");
                    break;
                case "近30分钟电子过热":
                    LogUtil.e("getValue", "-------" + data.getValue());

                    baseViewHolder.setText(R.id.tv_section_content_value, df.format(data.getValue() * 100) + "%");
                    break;
                case "实时负载率":
                    LogUtil.e("getValue", "-------" + data.getValue());
                    baseViewHolder.setText(R.id.tv_section_content_value, df.format(data.getValue()) + "");
                    break;
                case "实时效率":
                    LogUtil.e("getValue", "-------" + data.getValue());
                    baseViewHolder.setText(R.id.tv_section_content_value, df.format(data.getValue()) + "");
                    break;
                case "总运行时间":
                    baseViewHolder.setText(R.id.tv_section_content_value, df.format(data.getValue() / 3600) + "h");
                    break;
                case "总运行耗电量":
                    baseViewHolder.setText(R.id.tv_section_content_value, df.format(data.getValue()) + "kWh");
                    break;
                case "总启动次数":
                    baseViewHolder.setText(R.id.tv_section_content_value, (int) data.getValue() + "次");
                    break;
                default:
                    break;
            }
        } else {
            baseViewHolder.setText(R.id.tv_section_content_value, df.format(data.getValue()) + (data.getUnit() == null ? "" : data.getUnit()));
        }
    }
}
