package com.locensate.letnetwork.main.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.FilterEntity;
import com.locensate.letnetwork.entity.MachineEntity;
import com.locensate.letnetwork.entity.RepairEntity;
import com.locensate.letnetwork.main.ui.RepairDetailActivity;
import com.locensate.letnetwork.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaobinghe
 */

public class ToolsRepairActivity extends BaseToolsActivity {
    @Override
    protected Activity getActivity() {
        return this;
    }

    @Override
    protected CharSequence setTitle() {
        return "工具-维修";
    }

    @Override
    protected RecyclerView.Adapter setRVAdapter() {
        ToolsRepairRVAdapter adapter = new ToolsRepairRVAdapter(R.layout.item_tools_order, getData());
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RepairEntity item = (RepairEntity) baseQuickAdapter.getItem(i);
                Intent intent = new Intent(App.getApplication(), RepairDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("repair", item);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return adapter;
    }

    @Override
    protected void setRefreshListener(final SwipeRefreshLayout swipeRefreshLayout) {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Runnable runnable = new Runnable() {
                    public void run() {
                        SystemClock.sleep(2000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                swipeRefreshLayout.setRefreshing(false);
                            }
                        });
                    }
                };
            }
        });
    }

    @Override
    protected List<FilterEntity> getFilterData() {
        return null;
    }

    private List<RepairEntity> getData() {
        ArrayList<RepairEntity> entities = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            ArrayList<MachineEntity> machineEntities = new ArrayList<>();
            machineEntities.add(new MachineEntity("1", "一次除尘风机"));
            machineEntities.add(new MachineEntity("1", "循环水泵"));
            machineEntities.add(new MachineEntity("1", "空调机"));
            machineEntities.add(new MachineEntity("1", "二次除尘风机"));
            machineEntities.add(new MachineEntity("1", "二次除尘风机"));
            entities.add(new RepairEntity("更换电柜门安全锁。", "王虎旭", (String) DateUtils.getData("2017-02-12 12:30", System.currentTimeMillis()), "烧结厂/一车间", "" + i, machineEntities));
        }
        return entities;
    }

    private class ToolsRepairRVAdapter extends BaseQuickAdapter<RepairEntity, BaseViewHolder> {
        public ToolsRepairRVAdapter(int layoutResId, List<RepairEntity> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, RepairEntity repairEntity) {
            List<MachineEntity> machines = repairEntity.getMachines();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < machines.size(); i++) {
                if (i == machines.size() - 1) {
                    builder.append(machines.get(i).getName());
                } else {
                    builder.append(machines.get(i).getName()).append(",");
                }
            }
            baseViewHolder.setText(R.id.tv_order_machine, builder.toString())
                    .setText(R.id.tv_order_machine_path, repairEntity.getPath())
                    .setText(R.id.tv_order_des, repairEntity.getDes())
                    .setText(R.id.tv_order_time, repairEntity.getTime())
                    .setText(R.id.tv_order_person, repairEntity.getPerson());

        }
    }
}
