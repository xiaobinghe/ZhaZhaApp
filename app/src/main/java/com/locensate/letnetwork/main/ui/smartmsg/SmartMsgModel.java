package com.locensate.letnetwork.main.ui.smartmsg;

import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.entity.SmartMsgEntity;

import java.util.ArrayList;
import java.util.List;

/**
 *  
 * @author xiaobinghe
 */

public class SmartMsgModel implements SmartMsgConstract.Model {


    private static ArrayList<SmartMsgEntity> list;

    @Override
    public List<SmartMsgEntity> getInitData() {
        list = new ArrayList<>();
        list.add(new SmartMsgEntity("中石化/北京分公司/储油车间", "通风机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()),"空载10分钟", 1));
        list.add(new SmartMsgEntity("八一钢铁厂/北京分公司/不锈钢一车间", "冲压机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()), "运行温度过高",1));
        list.add(new SmartMsgEntity("空分集团/福建分公司/压缩机车间", "卷板机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()),"连续启动频繁", 1));
        list.add(new SmartMsgEntity("罗圣森特/北京分公司/试验车间", "通风机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()), "负载波动过大",1));
        list.add(new SmartMsgEntity("费尔福德/中国分公司/北京总经销部", "空冷设备", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()),"空载", 1));
        return list;
    }

    public static int getListSize(){
        return 5;
    }
}
