package com.locensate.letnetwork.main.ui.smartmsg;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.entity.SmartMsgEntity;

import java.util.List;

/**
 *  
 * @author xiaobinghe
 */

public class SmartMsgAdapter extends BaseQuickAdapter<SmartMsgEntity, BaseViewHolder> {
    public SmartMsgAdapter(int item_msg_smart, List<SmartMsgEntity> initData) {
        super(item_msg_smart, initData);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, SmartMsgEntity smartMsgEntity) {

    }
}
