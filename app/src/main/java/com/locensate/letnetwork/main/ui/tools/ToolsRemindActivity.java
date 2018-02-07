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
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.FilterEntity;
import com.locensate.letnetwork.entity.MachineEntity;
import com.locensate.letnetwork.main.ui.RemindDetailActivity;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.remind.RemindEntity;
import com.locensate.letnetwork.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaobinghe
 */

public class ToolsRemindActivity extends BaseToolsActivity {

    @Override
    protected Activity getActivity() {
        return this;
    }

    @Override
    protected CharSequence setTitle() {
        return "工具-提醒";
    }

    @Override
    protected RecyclerView.Adapter setRVAdapter() {
        RemindRVAdapter adapter = new RemindRVAdapter(R.layout.item_tools_remind, getData());
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RemindEntity item = (RemindEntity) baseQuickAdapter.getItem(i);
                Intent intent = new Intent(getApplication(), RemindDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("remind", item);
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

    public List<RemindEntity> getData() {
        ArrayList<RemindEntity> entities = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            ArrayList<MachineEntity> machineEntities = new ArrayList<>();
            machineEntities.add(new MachineEntity("1", "一次除尘风机"));
            machineEntities.add(new MachineEntity("1", "循环水泵"));
            machineEntities.add(new MachineEntity("1", "空调机"));
            machineEntities.add(new MachineEntity("1", "二次除尘风机"));
            machineEntities.add(new MachineEntity("1", "二次除尘风机"));
            entities.add(new RemindEntity("检查设备运行状况", "彭旭", (String) DateUtils.getData("09:00", DateUtils.getCurrentTimeMillis()), "每天", machineEntities, "烧结厂/一车间"));
        }
        return entities;
    }


    private class RemindRVAdapter extends BaseQuickAdapter<RemindEntity, BaseViewHolder> {
        public RemindRVAdapter(int layoutResId, List<RemindEntity> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, RemindEntity remindEntity) {


            List<MachineEntity> machines = remindEntity.getMachines();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < machines.size(); i++) {
                if (i == machines.size() - 1) {
                    builder.append(machines.get(i).getName());
                } else {
                    builder.append(machines.get(i).getName()).append(",");
                }
            }
            baseViewHolder.setText(R.id.tv_remind_machine, builder.toString())
                    .setText(R.id.tv_remind_machine_path, remindEntity.getPath())
                    .setText(R.id.tv_remind_time_type, remindEntity.getType())
                    .setText(R.id.tv_remind_time, remindEntity.getTime())
                    .setText(R.id.tv_remind_des, remindEntity.getDes());
        }
    }
}
