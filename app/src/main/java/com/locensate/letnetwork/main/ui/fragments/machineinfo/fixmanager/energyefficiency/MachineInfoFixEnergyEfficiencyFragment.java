package com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.energyefficiency;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.OrderMsgEntity;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.BaseFixManagerFragment;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.order.FixOrderAdapter;
import com.locensate.letnetwork.main.ui.orderdetail.OrderDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 *  
 * @author xiaobinghe
 */

public class MachineInfoFixEnergyEfficiencyFragment extends BaseFixManagerFragment {
    private boolean isAddListener = false;
    private FixOrderAdapter mAdapter;

   /* public static Fragment getInstance(String machineId) {
        if (null == machineInfoFixEnergyEfficiencyFragment) {
            machineInfoFixEnergyEfficiencyFragment = new MachineInfoFixEnergyEfficiencyFragment();
            Bundle bundle = new Bundle();
            bundle.putString("machineId", machineId);
            machineInfoFixEnergyEfficiencyFragment.setArguments(bundle);
        }
        return machineInfoFixEnergyEfficiencyFragment;
    }*/

    @Override
    protected void refreshData(OnRefreshComplete onRefreshComplete) {
        onRefreshComplete.complete();

    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        mAdapter = new FixOrderAdapter(R.layout.item_fix_order_msg, getEnergys());
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                OrderMsgEntity item = (OrderMsgEntity) baseQuickAdapter.getItem(i);
                Intent intent = new Intent(getActivity(), OrderDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("order",item);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return mAdapter;
    }

    @Override
    protected void addClickListener(RecyclerView rvFixOrder) {
    }


    public List<OrderMsgEntity> getEnergys() {
        List<OrderMsgEntity> energys = new ArrayList<>();
        energys.add(new OrderMsgEntity("运行效率低，但设备是带载运行，请协助分析。", "某厂/三车间", "张芬芳", "2017-07-23  12:23", 0));
        energys.add(new OrderMsgEntity("长时间低效率运行，请提供解决方案。", "某厂/三车间", "张芬芳", "2017-07-12  09:15", 0));
        energys.add(new OrderMsgEntity("设备存在空载运行，低效率运行。", "某厂/三车间", "张芬芳", "2017-07-03  15:25", 0));
        energys.add(new OrderMsgEntity("设备更换高效电机后，实际能效仍然较低。", "某厂/三车间", "张芬芳", "2017-06-25  11:33", 0));
        energys.add(new OrderMsgEntity("运行效率低，请协助分析。", "某厂/三车间", "张芬芳", "2017-06-10  12:51", 0));
        return energys;
    }

    @Override
    protected void lazyLoad() {

    }
}
