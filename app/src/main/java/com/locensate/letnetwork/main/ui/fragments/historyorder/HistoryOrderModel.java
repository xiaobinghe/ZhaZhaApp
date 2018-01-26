package com.locensate.letnetwork.main.ui.fragments.historyorder;

import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.entity.OrderItemEntity;

import java.util.ArrayList;
import java.util.List;

/**
 *  
 * @author xiaobinghe
 */

public class HistoryOrderModel implements HistoryOrderContract.Model {
    @Override
    public List<OrderItemEntity> getData() {
        ArrayList<OrderItemEntity> orderItemEntities = new ArrayList<>();
        int last = 23;
        for (int i = 0; i < 16; i++) {
            orderItemEntities.add(new OrderItemEntity(i + 1, "测试水泵" + i, "WO10B00" + last++, (String) DateUtils.getData("17-12-15 10:15", DateUtils.getCurrentTimeMillis()), "变频器无法启动，排查进出线均无问题，请问。。。", "分公司/分厂/分车间", "王猛", "已完成"));
        }
        return orderItemEntities;
    }
}
