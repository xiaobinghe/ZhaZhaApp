package com.locensate.letnetwork.main.ui.riplanmsg;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.entity.RiplanMsgEntity;

import java.util.List;

/**
 *  
 * @author xiaobinghe
 */

public class RiPlanMsgAdapter extends BaseQuickAdapter<RiplanMsgEntity, BaseViewHolder> {

    public RiPlanMsgAdapter(int layoutResId, List<RiplanMsgEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, RiplanMsgEntity riplanMsgEntity) {

    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }
}
