package com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.repair;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.RepairEntity;
import com.locensate.letnetwork.main.ui.RepairDetailActivity;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.BaseFixManagerFragment;
import com.locensate.letnetwork.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *  
 * @author xiaobinghe
 */

public class MachineInfoFixRepairFragment extends BaseFixManagerFragment {
    private boolean isAddListener = false;


   /* public static Fragment getInstance(String machineId) {
        if (null == machineInfoFixRepairFragment) {
            machineInfoFixRepairFragment = new MachineInfoFixRepairFragment();
            Bundle bundle = new Bundle();
            bundle.putString("machineId", machineId);
            machineInfoFixRepairFragment.setArguments(bundle);
        }
        return machineInfoFixRepairFragment;
    }*/

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void lazyLoad() {

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
        FixRepairRvAdapter adapter= new FixRepairRvAdapter(R.layout.item_fix_order_msg, getFixRepairList());
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

    public List<RepairEntity> getFixRepairList() {
        List<RepairEntity> entities = new ArrayList<>();

        entities.add(new RepairEntity("更换输入B相接触器", "孙国庆", (String) DateUtils.getData("2017-05-12 12:30", System.currentTimeMillis() - 20000)));
        entities.add(new RepairEntity("更换机柜风机", "张航", (String) DateUtils.getData("2017-05-12 12:30", DateUtils.getCurrentTimeMillis() - 30000)));
        entities.add(new RepairEntity("输入端线路松动，紧固", "李玉凡", (String) DateUtils.getData("2017-05-12 12:30", DateUtils.getCurrentTimeMillis() - 32000)));
        entities.add(new RepairEntity("电机端子盒线路松动", "王强", (String) DateUtils.getData("2017-05-12 12:30", DateUtils.getCurrentTimeMillis() - 38000)));
        entities.add(new RepairEntity("更换了柜门启动按钮", "张航", (String) DateUtils.getData("2017-05-12 12:30", DateUtils.getCurrentTimeMillis() - 50000)));


        return entities;
    }
}
