package com.locensate.letnetwork.main.ui.tools;

import android.content.res.Resources;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.entity.RealTimeEntity;
import com.locensate.letnetwork.main.ui.search.SearchActivity;
import com.locensate.letnetwork.view.ExpandablePopWindow;
import com.locensate.letnetwork.view.expandableview.Level0Item;
import com.locensate.letnetwork.view.expandableview.Level1Item;
import com.locensate.letnetwork.view.expandableview.Level2Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *  
 * @author xiaobinghe
 */

public class ToolsKanBanActivity extends BaseActivity {

    @BindView(R.id.iv_title_only_back)
    ImageView ivTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView tvTitleOnlyBack;
    @BindView(R.id.tv_machine_path)
    TextView tvMachinePath;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.rv_kan_ban)
    RecyclerView rvKanBan;
    @BindView(R.id.srl_kan_ban)
    SwipeRefreshLayout srlKanBan;
    @BindView(R.id.activity_kan_ban)
    LinearLayout activityKanBan;
    private ExpandablePopWindow expandablePopwindow;

    @Override
    public int getLayoutId() {
        return R.layout.activity_kan_ban;
    }

    @Override
    public void initView() {
        tvTitleOnlyBack.setText("工具-看板");
        srlKanBan.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srlKanBan.setRefreshing(false);
            }
        });
        rvKanBan.setLayoutManager(new LinearLayoutManager(this));
        rvKanBan.setAdapter(new KanBanRVAdapter(R.layout.layout_item_kan_ban, getData()));
    }

    @OnClick({R.id.iv_title_only_back, R.id.tv_machine_path, R.id.iv_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_title_only_back:
                finish();
                break;
            case R.id.tv_machine_path:
                showPop(getGroupTree());
                break;
            case R.id.iv_search:
                startActivity(SearchActivity.class);
                break;
        }
    }

    private void showPop(ArrayList<MultiItemEntity> groupTree) {
        if (null == expandablePopwindow) {
            expandablePopwindow = new ExpandablePopWindow(this, groupTree);
        }
        expandablePopwindow.showPopupWindow(tvMachinePath);
//        WindowOptionUtil.darkBackGround(0.4f, this);
        expandablePopwindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
//                WindowOptionUtil.darkBackGround(1f, ToolsKanBanActivity.this);
                tvMachinePath.setText(expandablePopwindow.getPath());
            }
        });
    }

    private ArrayList<MultiItemEntity> getGroupTree() {
        int lv0Count = 5;
        int lv1Count = 3;
        int personCount = 4;

        String[] nameList = {"焦化厂", "炼钢厂", "烧结厂", "不锈钢厂", "国际贸易公司"};
        String[] lv0List = {"一车间", "二车间", "三车间"};
        String[] lv1List = {"一班", "二班", "三班", "四班"};
        ArrayList<MultiItemEntity> res = new ArrayList<>();
        res.add(new Level0Item("全部", "全部", 0));
        for (int i = 0; i < lv0Count; i++) {
            Level0Item lv0 = new Level0Item(nameList[i], nameList[i], 0);

            for (int j = 0; j < lv1Count; j++) {
                Level1Item lv1 = new Level1Item(lv0List[j], "", 0);
                for (int k = 0; k < personCount; k++) {
                    lv1.addSubItem(new Level2Item(lv1List[k], null, false, 0));
                }
                lv0.addSubItem(lv1);
            }
            res.add(lv0);
        }

        return res;
    }

    private List<RealTimeEntity> getData() {
        ArrayList<RealTimeEntity> entities = new ArrayList<>();
        entities.add(new RealTimeEntity("1", "运料主皮带机", "一车间配电室", "55kW", "15kW", "40A", "27%", "0.72", "56%", false, "normal"));
        entities.add(new RealTimeEntity("1", "一次除尘风机", "一车间配电室", "55kW", "35kW", "80A", "64%", "0.81", "60%", false, "normal"));
        entities.add(new RealTimeEntity("1", "二次风机", "一车间配电室", "55kW", "0kW", "0A", "0%", "0", "26%", false, "low"));
        entities.add(new RealTimeEntity("1", "循环水泵", "一车间配电室", "55kW", "0kW", "0A", "0%", "0", "19%", false, "stop"));
        entities.add(new RealTimeEntity("1", "空调机", "一车间配电室", "55kW", "22.8kW", "30A", "36%", "0.48", "56%", true, "high"));

        return entities;
    }

    private class KanBanRVAdapter extends BaseQuickAdapter<RealTimeEntity, BaseViewHolder> {
        public KanBanRVAdapter(int layoutResId, List<RealTimeEntity> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, RealTimeEntity realTimeEntity) {
            baseViewHolder.setText(R.id.tv_machine, realTimeEntity.getMachineName())
                    .setText(R.id.tv_machine_path, realTimeEntity.getPath())
                    .setText(R.id.tv_default_power, realTimeEntity.getDefaultPower())
                    .setText(R.id.tv_real_power, realTimeEntity.getRealPower())
                    .setText(R.id.tv_running_current, realTimeEntity.getRunningCurrent())
                    .setText(R.id.tv_real_load_rate, realTimeEntity.getRealLoadRate())
                    .setText(R.id.tv_real_efficiency, realTimeEntity.getRealEfficiency())
                    .setText(R.id.tv_electric_hot, realTimeEntity.getElectricHotQ30())
                    .setTextColor(R.id.tv_electric_hot, realTimeEntity.isInterrupt() ? getResources().getColor(R.color.font_content_gray) : getResources().getColor(R.color.font_content))
                    .setTextColor(R.id.tv_real_efficiency, realTimeEntity.isInterrupt() ? getResources().getColor(R.color.font_content_gray) : getResources().getColor(R.color.font_content))
                    .setTextColor(R.id.tv_real_load_rate, realTimeEntity.isInterrupt() ? getResources().getColor(R.color.font_content_gray) : getResources().getColor(R.color.font_content))
                    .setTextColor(R.id.tv_running_current, realTimeEntity.isInterrupt() ? getResources().getColor(R.color.font_content_gray) : getResources().getColor(R.color.font_content))
                    .setTextColor(R.id.tv_real_power, realTimeEntity.isInterrupt() ? getResources().getColor(R.color.font_content_gray) : getResources().getColor(R.color.font_content))
                    .setTextColor(R.id.tv_default_power, realTimeEntity.isInterrupt() ? getResources().getColor(R.color.font_content_gray) : getResources().getColor(R.color.font_content))
                    .setTextColor(R.id.tv_electric_hot_below, realTimeEntity.isInterrupt() ? getResources().getColor(R.color.font_gray) : getResources().getColor(R.color.font_content))
                    .setTextColor(R.id.tv_electric_hot_below_, realTimeEntity.isInterrupt() ? getResources().getColor(R.color.font_gray) : getResources().getColor(R.color.font_content))
                    .setTextColor(R.id.tv_real_efficiency_below, realTimeEntity.isInterrupt() ? getResources().getColor(R.color.font_gray) : getResources().getColor(R.color.font_content))
                    .setTextColor(R.id.tv_real_load_rate_below, realTimeEntity.isInterrupt() ? getResources().getColor(R.color.font_gray) : getResources().getColor(R.color.font_content))
                    .setTextColor(R.id.tv_running_current_below, realTimeEntity.isInterrupt() ? getResources().getColor(R.color.font_gray) : getResources().getColor(R.color.font_content))
                    .setTextColor(R.id.tv_real_power_below, realTimeEntity.isInterrupt() ? getResources().getColor(R.color.font_gray) : getResources().getColor(R.color.font_content))
                    .setTextColor(R.id.tv_default_power_below, realTimeEntity.isInterrupt() ? getResources().getColor(R.color.font_gray) : getResources().getColor(R.color.font_content))
                    .setVisible(R.id.iv_interrupt, realTimeEntity.isInterrupt())
                    .setBackgroundColor(R.id.ll_alert_level, realTimeEntity.isInterrupt() ? getResources().getColor(R.color.ground_line) : selectColor(realTimeEntity));


        }

        private int selectColor(RealTimeEntity realTimeEntity) {
            String status = realTimeEntity.getStatus();
            Resources resources = getResources();
            if ("stop".equals(status)) return resources.getColor(R.color.alert_stop);
            else if ("high".equals(status)) return resources.getColor(R.color.alert_high);
            else if ("low".equals(status)) return resources.getColor(R.color.alert_low);
            else return resources.getColor(R.color.normal_green);
        }
    }
}
