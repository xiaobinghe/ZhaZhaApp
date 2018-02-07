package com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.remind;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.MachineEntity;
import com.locensate.letnetwork.main.ui.RemindDetailActivity;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.BaseFixManagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 *  
 * @author xiaobinghe
 */

public class MachineInfoFixRemindFragment extends BaseFixManagerFragment{
    private boolean isAddListener = false;



 /*   public static Fragment getInstance(String machineId) {
        if (null == machineInfoFixRemindFragment) {
            machineInfoFixRemindFragment = new MachineInfoFixRemindFragment();
            Bundle bundle = new Bundle();
            bundle.putString("machineId", machineId);
            machineInfoFixRemindFragment.setArguments(bundle);
        }
        return machineInfoFixRemindFragment;
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
    protected void addClickListener(RecyclerView rvFixOrder) {

    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        FixRemindRvAdapter adapter=    new FixRemindRvAdapter(R.layout.item_fix_remind_msg, getRemindList());
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RemindEntity item = (RemindEntity) baseQuickAdapter.getItem(i);
                Intent intent = new Intent(getActivity(), RemindDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("remind", item);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return adapter;
    }

    @Override
    protected void lazyLoad() {

    }
    public List<RemindEntity> getRemindList() {
        ArrayList<RemindEntity> remindEntities = new ArrayList<>();
        ArrayList<MachineEntity> machines = new ArrayList<>();
        machines.add(new MachineEntity("", "全部设备"));
        remindEntities.add(new RemindEntity("柜门清洁", "李国良", "10:00", "每周一", machines, "焦化厂/一车间"));
        remindEntities.add(new RemindEntity("设备运行状况确定", "李国良", "9:00", "每天", machines, "焦化厂/一车间"));
        remindEntities.add(new RemindEntity("设备点检", "李国良", "31日", "每月", machines, "焦化厂/一车间"));
        remindEntities.add(new RemindEntity("设备耗电量确认", "李国良", "17:00", "每天", machines, "焦化厂/一车间"));
        return remindEntities;

    }
}
