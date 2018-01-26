package com.locensate.letnetwork.main.ui.fragments.machineinfo.monitorinfo;

import android.content.Context;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;

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
                .setText(R.id.tv_section_head_key, monitoringData.header)
                .setTextColor(R.id.tv_section_head_key, context.getResources().getColor(readBreak ? R.color.red_warn : R.color.font_deep_blue))
                .setVisible(R.id.tv_section_head_value, remoteParameter)
                .addOnClickListener(R.id.tv_section_head_value);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MonitoringData monitoringData) {
        RunningStateEntity data = (RunningStateEntity) monitoringData.t;
        boolean isbreak = data.isbreak();
        baseViewHolder.setText(R.id.tv_section_content_key, data.getKey())
                .setText(R.id.tv_section_content_value, data.getValue())
                .setTextColor(R.id.tv_section_content_key, context.getResources().getColor(isbreak ? R.color.font_light_gray : R.color.font_content))
                .setTextColor(R.id.tv_section_content_value, context.getResources().getColor(isbreak ? R.color.font_light_gray : R.color.font_content));
    }
}
