package com.locensate.letnetwork.main.ui.fragments.machine;

import com.google.gson.Gson;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.Constant;
import com.locensate.letnetwork.api.Api;
import com.locensate.letnetwork.bean.ImportantMachine;
import com.locensate.letnetwork.bean.MachineFilterTag;
import com.locensate.letnetwork.bean.MotorListEntity;
import com.locensate.letnetwork.bean.Organizations;
import com.locensate.letnetwork.bean._User;
import com.locensate.letnetwork.entity.FilterEntity;
import com.locensate.letnetwork.entity.MultiSection;
import com.locensate.letnetwork.entity.MultiSectionEntity;
import com.locensate.letnetwork.entity.RangeChildEntity;
import com.locensate.letnetwork.utils.SpUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * -------------------------------------
 * <p>
 * 项目名称： MotorTesting
 * <p>
 * 版权：locensate.com 版权所有 2016
 * <p>
 * 公司主页：http://www.locensate.com/
 * <p>
 * 描述：
 * <p>
 * 作者： xiaobinghe
 * <p>
 * 时间： 2016/12/22 9:48
 * <p>
 * 修改历史：
 * <p>
 * 修改时间：
 * <p>
 * 修改描述：
 * <p>
 * -------------------------------------
 */
public class MachineModel implements MachineContract.Model {

    private List<MultiSectionEntity> multiSectionEntity;
    public List<RangeChildEntity> getRangeChildEntity() {
        List<RangeChildEntity> list = new ArrayList<>();
        //第一项
        RangeChildEntity rangeChildEntity = new RangeChildEntity();
        List<String> childList = new ArrayList<>();
        rangeChildEntity.desc = "全部";
        rangeChildEntity.child = childList;
        list.add(rangeChildEntity);

        List<String> first = new ArrayList<>();
        rangeChildEntity = new RangeChildEntity();
        rangeChildEntity.desc = "鞍钢集团";
        first.add("鞍山铸钢有限公司");
        first.add("鞍钢朝阳钢铁有限公司");
        first.add("鞍钢钢绳有限公司");
        first.add("鞍钢冷轧钢有限公司");
        first.add("鞍钢控股有限公司");
        first.add("鞍钢外贸有限公司");
        rangeChildEntity.child = first;
        list.add(rangeChildEntity);

        //第二项
        rangeChildEntity = new RangeChildEntity();
        rangeChildEntity.desc = "宝钢集团";
        List<String> second = new ArrayList<>();
        second.add("宝钢股份");
        second.add("宝钢金属");
        second.add("宝钢工程");
        second.add("宝钢化工");
        rangeChildEntity.child = second;
        list.add(rangeChildEntity);

        //第三项
        rangeChildEntity = new RangeChildEntity();
        rangeChildEntity.desc = "沙钢集团";
        List<String> third = new ArrayList<>();
        third.add("安阳永兴钢铁厂");
        third.add("江苏沙钢集团");
        third.add("沙钢国际贸易有限公司");
        third.add("沙钢投资控股公司");
        rangeChildEntity.child = third;
        list.add(rangeChildEntity);

        childList.addAll(first);
        childList.addAll(second);
        childList.addAll(third);
        return list;
    }


    public List<MultiSection> getRangeChildEntites() {
        List<MultiSection> lists = new ArrayList<>();
        lists.add(new MultiSection(true, "电压等级"));
        lists.add(new MultiSection("400V"));
        lists.add(new MultiSection("690V"));
        lists.add(new MultiSection("3KV"));
        lists.add(new MultiSection("6KV"));
        lists.add(new MultiSection("9KV"));
        lists.add(new MultiSection("10KV"));
        lists.add(new MultiSection(true, "设备类型"));
        lists.add(new MultiSection("风机"));
        lists.add(new MultiSection("输送"));
        lists.add(new MultiSection("压缩机"));
        lists.add(new MultiSection("其他"));
        lists.add(new MultiSection(true, "监控设备"));
        lists.add(new MultiSection("变频器"));
        lists.add(new MultiSection("软启动器"));
        lists.add(new MultiSection("SGY"));
        lists.add(new MultiSection("计量仪表"));
        lists.add(new MultiSection("智能开关"));
        lists.add(new MultiSection("其他仪表"));
        lists.add(new MultiSection(true, "功率"));
        lists.add(new MultiSection("90以下"));
        lists.add(new MultiSection("90-200"));
        lists.add(new MultiSection("200-315"));
        lists.add(new MultiSection("315以上"));
        return lists;
    }


    public List[] getGridData() {
        List[] lists = new List[4];
        List<String> list1 = new ArrayList();
        list1.add("400V");
        list1.add("690V");
        list1.add("3KV");
        list1.add("6KV");
        list1.add("9KV");
        list1.add("10KV");
        List<String> list2 = new ArrayList();
        list2.add("风机");
        list2.add("水泵");
        list2.add("输送");
        list2.add("压缩机");
        list2.add("其他");
        List<String> list3 = new ArrayList();
        list3.add("变频器");
        list3.add("软启动器");
        list3.add("SGY");
        list3.add("计量仪表");
        list3.add("智能开关");
        list3.add("其他仪表");
        List<String> list4 = new ArrayList();
        list4.add("90以下");
        list4.add("90-200");
        list4.add("200-315");
        list4.add("315以上");
        lists[0] = list1;
        lists[1] = list2;
        lists[2] = list3;
        lists[3] = list4;
        return lists;
    }

    public List<MultiSectionEntity> getMultiSectionEntity() {
        multiSectionEntity = new ArrayList<>();
        List<GridItem> vacts = new ArrayList<>();
        vacts.add(new GridItem(false, "400V"));
        vacts.add(new GridItem(false, "690V"));
        vacts.add(new GridItem(false, "3KV"));
        vacts.add(new GridItem(false, "6KV"));
        vacts.add(new GridItem(false, "9KV"));
        multiSectionEntity.add(new MultiSectionEntity("0", vacts, "电压等级", true));
        List<GridItem> machTypes = new ArrayList<>();
        machTypes.add(new GridItem(false, "风机"));
        machTypes.add(new GridItem(false, "水泵"));
        machTypes.add(new GridItem(false, "输送"));
        machTypes.add(new GridItem(false, "压缩机"));
        machTypes.add(new GridItem(false, "其他"));
        multiSectionEntity.add(new MultiSectionEntity("0", machTypes, "设备类型", true));
        List<GridItem> scans = new ArrayList<>();
        scans.add(new GridItem(false, "变频器"));
        scans.add(new GridItem(false, "SGY"));
        scans.add(new GridItem(false, "软启动器"));
        scans.add(new GridItem(false, "智能开关"));
        scans.add(new GridItem(false, "计量仪表"));
        scans.add(new GridItem(false, "其他仪表"));
        multiSectionEntity.add(new MultiSectionEntity("0", scans, "监控设备", true));
        List<GridItem> avs = new ArrayList<>();
        avs.add(new GridItem(false, "90以下"));
        avs.add(new GridItem(false, "90-200"));
        avs.add(new GridItem(false, "200-315"));
        multiSectionEntity.add(new MultiSectionEntity("0", avs, "功率", false));
        return multiSectionEntity;
    }

    @Override
    public List<String> getMachines() {
        List<String> list = new ArrayList<String>();
        list.add("中央空分电机");
        list.add("皮带机");
        list.add("循环风机");
        list.add("除尘风机");
        list.add("空冷壁风机");
        list.add("二次空冷风机");
        return list;
    }

    @Override
    public List<MotorListEntity.DataBean.ListBean> getMachineList() {
        List<MotorListEntity.DataBean.ListBean> machines = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
                machines.add(new MotorListEntity.DataBean.ListBean(0.9,0,1,1,55,"工料车间","变频器",75,"除尘风机电机","380v","除尘风机"));
        }

        return machines;
    }


    @Override
    public Observable<Organizations> getOrganizations() {
        _User user = new Gson().fromJson(SpUtil.getString(App.getApplication(), Constant.USER, ""), _User.class);
        return Api.getInstance().service.getOrganizations(user.getData().getUserId());
    }

    @Override
    public Observable postImpotantMachine(MotorListEntity.DataBean.ListBean item) {
        return Api.getInstance().service.postImportantMachine(new ImportantMachine());
    }

    @Override
    public Observable<MachineFilterTag> getFilterTags() {
        return Api.getInstance().service.getFilterTags();
    }

    @Override
    public MachineFilterTag getFilterDefault() {
        String str = "{\"operCode\": 1,\"data\": [{\"isOpen\": true,\"single_check\": 0,\"key\": \"运行效率\", \"vals\": [ { \"val\": \"经济运行\"}, {\"val\": \"非经济运行\" }, {\"val\": \"合理运行\" }]},{\"single_check\": 0,\"key\": \"平均负载\", \"vals\": [{ \"val\": \"空载\"},{ \"val\": \"轻载\"},{ \"val\": \"半载\"},{ \"val\": \"重载\"},{ \"val\": \"过载\"}],\"open\": true}," +
                "{\"isOpen\": false,\"single_check\": 0,\"key\": \"健康分析\", \"vals\": [{ \"val\": \"好\"},{ \"val\": \"较好\"},{ \"val\": \"较差\"},{ \"val\": \"差\"}],\"open\": false}," +
                "{\"isOpen\": false,\"single_check\": 0,\"key\": \"能效等级\", \"vals\": [{\"val\": \"一级能效\"},{\"val\": \"二级能效\"},{\"val\": \"三级能效\"},{\"val\": \"普通能效\"},{\"val\": \"低效\"},{\"val\": \"其他\"}],\"open\": false},{\"isOpen\": false, \"single_check\": 0, \"key\": \"控制类型\",\"vals\": [{\"val\": \"变频器\" },{\"val\": \"软启动器\" },{\"val\": \"直接启动\" },{\"val\": \"星角启动\" },{\"val\": \"其他\" }],\"open\": false}," +
                "{\"isOpen\": false,\"single_check\": 0,\"key\": \"功率范围\", \"vals\": [{ \"val\": \"0-90\"},{ \"val\": \"90-180\"},{ \"val\": \"180-250\"},{ \"val\": \"250-380\"},{ \"val\": \"380以上\"}],\"open\": false},{\"isOpen\": false,\"single_check\": 0,\"key\": \"电压等级\", \"vals\": [{ \"val\": \"9kv\"},{ \"val\": \"6kv\"},{ \"val\": \"3kv\"},{ \"val\": \"380v\"},{ \"val\": \"220v\"}],\"open\": false},{\"isOpen\": false,\"single_check\": 0,\"key\": \"设备类型\", \"vals\": [{ \"val\": \"风机\"},{ \"val\": \"水泵\"},{ \"val\": \"压缩机\"},{ \"val\": \"其他\"}],\"open\": false},{\"isOpen\": false,\"single_check\": 0,\"key\": \"安装时间\", \"vals\": [{ \"val\": \"1年内\"},{ \"val\": \"2-5年\"},{ \"val\": \"6-10年\"},{ \"val\": \"10年以上\"}],\"open\": false}]}";
        return new Gson().fromJson(str,MachineFilterTag.class);
    }

    public List<FilterEntity> getFilterData() {
        return null;
    }
}
