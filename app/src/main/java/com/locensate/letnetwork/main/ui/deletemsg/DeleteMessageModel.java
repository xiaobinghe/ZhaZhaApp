package com.locensate.letnetwork.main.ui.deletemsg;

import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.entity.MessageEntity;

import java.util.ArrayList;


/**
 *
 * @author xiaobinghe
 */


public class DeleteMessageModel implements DeleteMessageContract.Model {

    @Override
    public ArrayList<MessageEntity> getAlertMsg() {
        ArrayList<MessageEntity> alertMsgEntities = new ArrayList<>();
        alertMsgEntities.add(new MessageEntity("", "输入端缺相", "中石化/北京分公司/储油车间", "通风机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()), "high", 1, false));
        alertMsgEntities.add(new MessageEntity("", "启动限流", "八一钢铁厂/北京分公司/不锈钢一车间", "冲压机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()), "low", 1, false));
        alertMsgEntities.add(new MessageEntity("", "皮带机一天运行24小时不停机，存在较多的空载运行", "空分集团/福建分公司/压缩机车间", "卷板机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()), "high", 1, false));
        alertMsgEntities.add(new MessageEntity("", "三相不平衡", "罗圣森特/北京分公司/试验车间", "通风机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()), "low", 1, false));
        alertMsgEntities.add(new MessageEntity("", "三相不平衡", "费尔福德/中国分公司/北京总经销部", "空冷设备", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()), "high", 1, false));
        return alertMsgEntities;
    }

    @Override
    public ArrayList<MessageEntity> getEnergyMsg() {
        ArrayList<MessageEntity> items = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            items.add(new MessageEntity("工单有更新", "实验车间" + i + "罗圣森特", "测试电机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()), i % 4, false));
        }
        return items;
    }

    @Override
    public ArrayList<MessageEntity> getOrderMsg() {
        ArrayList<MessageEntity> items = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            items.add(new MessageEntity("工单有更新", "实验车间" + i + "罗圣森特", "测试电机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()), i % 4 + 1, false));

        }
        return items;
    }

    @Override
    public ArrayList<MessageEntity> getRemindMsg() {
        ArrayList<MessageEntity> items = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            items.add(new MessageEntity("实验车间电表需要维修", "实验车间" + i + "罗圣森特", "测试电机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()), i % 4 + 1, false));

        }
        return items;
    }
}
