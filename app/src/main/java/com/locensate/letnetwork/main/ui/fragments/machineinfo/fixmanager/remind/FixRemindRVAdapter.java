package com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.remind;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;


/**
 * @author xiaobinghe
 */

class FixRemindRvAdapter extends BaseQuickAdapter<RemindEntity, BaseViewHolder> {

    FixRemindRvAdapter(int item, List<RemindEntity> remindList) {
        super(item, remindList);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, RemindEntity remindEntity) {
        View convertView = baseViewHolder.getConvertView();
        AutoUtils.autoSize(convertView);
        baseViewHolder.setText(R.id.tv_fix_remind_des, remindEntity.getDes())
                .setText(R.id.tv_fix_remind_person, remindEntity.getPerson())
                .setText(R.id.tv_fix_remind_time, remindEntity.getType() + "   " + remindEntity.getTime());
    }
}
