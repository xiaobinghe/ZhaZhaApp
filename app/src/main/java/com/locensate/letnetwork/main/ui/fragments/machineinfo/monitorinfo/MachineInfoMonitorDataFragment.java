package com.locensate.letnetwork.main.ui.fragments.machineinfo.monitorinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseFragment;
import com.locensate.letnetwork.main.ui.RemoteParameterActivity;
import com.locensate.letnetwork.main.ui.dataanalysis.DataAnalysisActivity;
import com.locensate.letnetwork.main.ui.machineinfo.MachineInfoActivity;
import com.locensate.letnetwork.utils.LogUtil;

import java.util.List;

import butterknife.BindView;

/**
 * @author xiaobinghe
 */

public class MachineInfoMonitorDataFragment extends BaseFragment<MachineInfoMonitorDataPresenter, MachineInfoMonitorDataModel> implements MachineInfoMonitorDataContract.View {

    @BindView(R.id.rv_machine_monitor)
    RecyclerView rvMachineMonitor;
    private MachineMonitorRvAdapter monitorRVAdapter;
    private boolean isAddListener = false;
    private Bundle mMachineInfo;
    private String machineName;
    private String machineId;
/*
    public static Fragment getInstance(String machineData) {
        if (instance == null) {
            instance = new MachineInfoMonitorDataFragment();
            Bundle bundle = new Bundle();
            bundle.putString("MachineName", machineData);
            instance.setArguments(bundle);
        }
        return instance;
    }*/

    @Override
    protected void initView() {

    }

    @Override
    public int getInflaterView() {
        return R.layout.fragment_running_state;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void fillData(List<MonitoringData> datas) {
        MachineInfoActivity context = (MachineInfoActivity) getActivity();
        mMachineInfo = context.getMachineInfo();
        machineName = mMachineInfo.getString("machineName");
        machineId = mMachineInfo.getString("machineId");
        rvMachineMonitor.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        monitorRVAdapter = new MachineMonitorRvAdapter(R.layout.item_section_content, R.layout.item_section_head, datas, getContext());
        rvMachineMonitor.setAdapter(monitorRVAdapter);


        if (!isAddListener) {
            rvMachineMonitor.addOnItemTouchListener(new OnItemClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    MonitoringData item = (MonitoringData) baseQuickAdapter.getItem(position);
                    skipRemoteParameter();
                }


                @Override
                public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    Bundle bundle = new Bundle();
                    MonitoringData item = (MonitoringData) baseQuickAdapter.getItem(i);
                    LogUtil.e(TAG, "--------------position===" + i);
                    if (!item.isHeader && i != 1) {
                        RunningStateEntity data = (RunningStateEntity) item.t;
                        bundle.putSerializable("parameter", data);
                        skipHistoryData(bundle);
                    }


                    //                AppManager.skipActivityWithData(DataAnalysisActivity.class, bundle, getActivity());
                }
            });
            isAddListener = true;
        }
    }

    private void skipHistoryData(Bundle bundle) {
        Intent intent = new Intent(App.getApplication(), DataAnalysisActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void skipRemoteParameter() {
        Intent intent = new Intent(getActivity(), RemoteParameterActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        rvMachineMonitor.setAdapter(null);
        super.onDestroyView();
    }
}