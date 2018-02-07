package com.locensate.letnetwork.main.ui.fragments.overview;

import android.support.v4.app.Fragment;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.Gson;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.Constant;
import com.locensate.letnetwork.api.Api;
import com.locensate.letnetwork.bean.OverviewMotor;
import com.locensate.letnetwork.utils.SpUtil;
import com.locensate.letnetwork.bean.Organizations;
import com.locensate.letnetwork.bean._User;
import com.locensate.letnetwork.entity.MsgEntity;
import com.locensate.letnetwork.main.ui.fragments.overview.healthyanalysis.OverviewHealthyAnalysisFragment;
import com.locensate.letnetwork.main.ui.fragments.overview.loadanalysis.OverviewLoadAnalysisFragment;
import com.locensate.letnetwork.main.ui.fragments.overview.rateanalysis.OverviewRateAnalysisFragment;
import com.locensate.letnetwork.view.expandableview.Level0Item;
import com.locensate.letnetwork.view.expandableview.Level1Item;
import com.locensate.letnetwork.view.expandableview.Level2Item;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;


/**
 * @author xiaobinghe
 */


public class OverviewModel implements OverviewContract.Model {

    @Override
    public List<MsgEntity> getItemRealEntity() {
        //2、查询数据库返回真实数据
        return null;
    }

    @Override
    public ArrayList<String> getRange() {
        ArrayList<String> ranges = new ArrayList<>();
        ranges.add("沙钢/烧结厂/一车间");
        ranges.add("沙钢/烧结厂/二车间");
        ranges.add("沙钢/烧结厂/三车间");
        ranges.add("沙钢/烧结厂/无尘车间");
        return ranges;
    }

    @Override
    public Fragment[] getContainFragment(String rangeItem) {
        Fragment[] fragments = new Fragment[3];
        fragments[0] = new OverviewRateAnalysisFragment();
        fragments[1] = new OverviewLoadAnalysisFragment();
        fragments[2] = new OverviewHealthyAnalysisFragment();
        return fragments;
    }

    @Override
    public ArrayList<MultiItemEntity> getGroupTree() {
        int lv0Count = 5;
        int lv1Count = 3;
        int personCount = 4;

        String[] nameList = {"焦化厂", "炼钢厂", "烧结厂", "不锈钢厂", "国际贸易公司"};
        String[] lv0List = {"一车间", "二车间", "三车间"};
        String[] lv1List = {"一班", "二班", "三班", "四班"};
        ArrayList<MultiItemEntity> res = new ArrayList<>();
        res.add(new Level0Item("全部", "全部", 0));
        for (int i = 0; i < lv0Count; i++) {
            Level0Item lv0 = new Level0Item(nameList[i], "", 0);

            for (int j = 0; j < lv1Count; j++) {
                Level1Item lv1 = new Level1Item(lv0List[j], nameList[i], 0);
                for (int k = 0; k < personCount; k++) {
                    lv1.addSubItem(new Level2Item(lv1List[k], new StringBuilder(nameList[i]).append("/").append(lv0List[j]).toString(), false, 0));
                }
                lv0.addSubItem(lv1);
            }
            res.add(lv0);
        }
        return res;
    }

    @Override
    public Observable<OverviewMotor> getBaseDate(int organizationId) {
        return Api.getInstance().service.getMotorOverview(organizationId);
    }

    @Override
    public Observable<Organizations> getOrganizations() {
        _User user = new Gson().fromJson(SpUtil.getString(App.getApplication(), Constant.USER, ""), _User.class);
        return Api.getInstance().service.getOrganizations(user.getData().getUserId());
    }
}
