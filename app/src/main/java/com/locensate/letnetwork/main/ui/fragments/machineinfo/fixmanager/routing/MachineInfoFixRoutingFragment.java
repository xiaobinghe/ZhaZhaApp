package com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.routing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.entity.RoutingEntity;
import com.locensate.letnetwork.main.ui.RoutingDetailActivity;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.BaseFixManagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 *  
 * @author xiaobinghe
 */

public class MachineInfoFixRoutingFragment extends BaseFixManagerFragment {
    private boolean isAddListener = false;


  /*  public static Fragment getInstance(String machineId) {
        if (null == machineInfoFixRoutingFragment) {
            machineInfoFixRoutingFragment = new MachineInfoFixRoutingFragment();
            Bundle bundle = new Bundle();
            bundle.putString("machineId", machineId);
            machineInfoFixRoutingFragment.setArguments(bundle);
        }
        return machineInfoFixRoutingFragment;
    }*/

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void refreshData(OnRefreshComplete onRefreshComplete) {
        onRefreshComplete.complete();
    }

    @Override
    protected FixRoutingRvAdapter getAdapter() {
        return new FixRoutingRvAdapter(R.layout.item_fix_order_msg, getData());
    }

    @Override
    protected void addClickListener(RecyclerView rvFixOrder) {
        if (!isAddListener) {
            rvFixOrder.addOnItemTouchListener(new OnItemClickListener() {
                @Override
                public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    RoutingEntity item = (RoutingEntity) baseQuickAdapter.getItem(i);
                    Intent intent = new Intent(App.getApplication(), RoutingDetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("routing", item);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
            isAddListener = true;
        }
    }

    private List<RoutingEntity> getData() {
        ArrayList<RoutingEntity> routingEntities = new ArrayList<>();

        routingEntities.add(new RoutingEntity("除尘风机", "" + 1, (String) DateUtils.getData("yyyy年MM月dd日", DateUtils.getCurrentTimeMillis()), "设备运行是否正常，例行检查。", "焦化厂/二车间", "李俊"));
        routingEntities.add(new RoutingEntity("除尘风机", "" + 2, (String) DateUtils.getData("yyyy年MM月dd日", DateUtils.getCurrentTimeMillis()), "运行例行检查，机柜清洁等。", "焦化厂/二车间", "李俊"));
        routingEntities.add(new RoutingEntity("除尘风机", "" + 3, (String) DateUtils.getData("yyyy年MM月dd日", DateUtils.getCurrentTimeMillis()), "散热风机、运行温度等。", "焦化厂/二车间", "李俊"));
        routingEntities.add(new RoutingEntity("除尘风机", "" + 4, (String) DateUtils.getData("yyyy年MM月dd日", DateUtils.getCurrentTimeMillis()), "管道是否通畅。", "焦化厂/二车间", "李俊"));
        routingEntities.add(new RoutingEntity("除尘风机", "" + 5, (String) DateUtils.getData("yyyy年MM月dd日", DateUtils.getCurrentTimeMillis()), "管道漏水等确认。", "焦化厂/二车间", "李俊"));

        return routingEntities;
    }
}
