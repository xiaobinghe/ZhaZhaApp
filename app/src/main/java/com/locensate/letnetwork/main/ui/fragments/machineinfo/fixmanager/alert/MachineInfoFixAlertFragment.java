package com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.alert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.MessageEntity;
import com.locensate.letnetwork.main.ui.AlertDetailActivity;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.BaseFixManagerFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 设备信息-报警
 *
 * @author xiaobinghe
 */

public class MachineInfoFixAlertFragment extends BaseFixManagerFragment {
    private boolean isAddListener = false;
    private FixAlertRvAdapter mRvAdapter;


    /*
        public static Fragment getInstance(String machineName) {
            if (machineInfoFixAlertFragment == null) {
                machineInfoFixAlertFragment = new MachineInfoFixAlertFragment();
                Bundle bundle = new Bundle();
                bundle.putString("machineName", machineName);
                machineInfoFixAlertFragment.setArguments(bundle);
            }
            return machineInfoFixAlertFragment;
        }
    */
    @Override
    protected void refreshData(OnRefreshComplete onRefreshComplete) {
        // TODO: 2017/7/19 refresh data!
        onRefreshComplete.complete();
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        mRvAdapter = new FixAlertRvAdapter(getContext(), R.layout.item_fix_alert_fragment, getAlertList());
        mRvAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MessageEntity item = (MessageEntity) baseQuickAdapter.getItem(i);
                Intent intent = new Intent(getActivity(), AlertDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("alertMsg", item);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        mRvAdapter.setEnableLoadMore(true);
        return mRvAdapter;
    }

    @Override
    protected void addClickListener(RecyclerView rvFixOrder) {

    }

    public List<MessageEntity> getAlertList() {
        ArrayList<MessageEntity> alerts = new ArrayList<>();
        Calendar instance = Calendar.getInstance();


        for (int i = 0; i < 3; i++) {
            instance.add(Calendar.DAY_OF_YEAR, -1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String format = sdf.format(instance.getTime());
            int randomH = (int) (Math.random() * 24);
            alerts.add(new MessageEntity("", "输入端缺相", "罗圣森特一车间", "SGY", format + " " + ((randomH < 10 || randomH == 0) ? "0" + randomH : randomH) + ":" +
                    (int) (Math.random() * 10 + 40), "high", 0, false));
            alerts.add(new MessageEntity("", "过流", "罗圣森特一车间", "MM430", format + " " + ((randomH < 10 || randomH == 0) ? "0" + randomH : randomH) + ":" +
                    (int) (Math.random() * 10 + 20), "low", 0, false));
            alerts.add(new MessageEntity("", "温度过高", "罗圣森特一车间", "MM430", format + " " + ((randomH < 10 || randomH == 0) ? "0" + randomH : randomH) + ":" +
                    (int) (Math.random() * 10 + 10), "low", 0, false));
        }
        return alerts;
    }
}
