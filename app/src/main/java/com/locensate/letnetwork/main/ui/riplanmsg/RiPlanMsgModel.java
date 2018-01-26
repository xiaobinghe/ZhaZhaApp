package com.locensate.letnetwork.main.ui.riplanmsg;

import com.locensate.letnetwork.entity.RiplanMsgEntity;

import java.util.ArrayList;
import java.util.List;

/**
 *  
 * @author xiaobinghe
 */

public class RiPlanMsgModel implements RiPlanMsgContract.Model {

    private static List<RiplanMsgEntity> list;

    @Override
    public List<RiplanMsgEntity> getInitData() {
        list = new ArrayList<>();
//        list.add(new RiplanMsgEntity("中石化/北京分公司/储油车间", "通风机", " 内容：循环水泵电机控制柜、电机绝缘检测等。"));
//        list.add(new RiplanMsgEntity("八一钢铁厂/北京分公司/不锈钢一车间", "冲压机", "内容：皮带机液力耦合器的维护、配电柜清洁。"));
//        list.add(new RiplanMsgEntity("空分集团/福建分公司/压缩机车间", "卷板机", "内容：风机变频器控制柜的维护、清洁等。"));
//        list.add(new RiplanMsgEntity("罗圣森特/北京分公司/试验车间", "通风机", " 内容：设备维护、清洁等。"));
//        list.add(new RiplanMsgEntity("费尔福德/中国分公司/北京总经销部", "空冷设备", " 内容：设备维护、清洁等。"));
        return list;
    }

    public static int getListSize(){
        return 5;
    }
}
