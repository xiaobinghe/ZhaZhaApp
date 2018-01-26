package com.locensate.letnetwork.main.ui.ordermsg;

import com.locensate.letnetwork.entity.OrderMsgEntity;

import java.util.ArrayList;
import java.util.List;


/**
 *  
 * @author xiaobinghe
 */

public class OrderMsgModel implements OrderMsgContract.Model {

    private static List<OrderMsgEntity> list;

    @Override
    public List<OrderMsgEntity> getInitDate() {
        list = new ArrayList<>();
//        list.add(new OrderMsgEntity("中石化/北京分公司/储油车间", "通风机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()), 1));
//        list.add(new OrderMsgEntity("八一钢铁厂/北京分公司/不锈钢一车间", "冲压机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()), 1));
//        list.add(new OrderMsgEntity("空分集团/福建分公司/压缩机车间", "卷板机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()), 1));
//        list.add(new OrderMsgEntity("罗圣森特/北京分公司/试验车间", "通风机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()), 1));
//        list.add(new OrderMsgEntity("费尔福德/中国分公司/北京总经销部", "空冷设备", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()), 1));
        return list;
    }

    public static int getListSize(){
        return 5;
    }
}
