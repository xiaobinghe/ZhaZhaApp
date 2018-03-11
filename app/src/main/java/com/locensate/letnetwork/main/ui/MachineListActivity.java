package com.locensate.letnetwork.main.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.bean.MachineDataBean;
import com.locensate.letnetwork.bean.MotorListEntity;
import com.locensate.letnetwork.main.ui.fragments.machine.MachineListAdapter;
import com.locensate.letnetwork.main.ui.machineinfo.MachineInfoActivity;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.view.ModernDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MachineListActivity extends BaseActivity {

    @BindView(R.id.iv_title_only_back)
    ImageView mIvTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView mTvTitleOnlyBack;
    @BindView(R.id.rv_machine_list)
    RecyclerView mRvMachineList;
    @BindView(R.id.srl_machine_list_machine)
    SwipeRefreshLayout mSrlMachineListMachine;
    private String mFilter;
    private MachineListAdapter adapter;
    private String mRange;
    private boolean isAddListener = false;
    private ModernDialog dialog;
    private String mStatus;

    @Override
    public int getLayoutId() {
        return R.layout.activity_machine_list;
    }

    @Override
    public void initView() {
        mFilter = getIntent().getExtras().getString("filter");
        mRange = getIntent().getExtras().getString("ranges");
        mStatus = getIntent().getExtras().getString("status");

        LogUtil.e(TAG, "mRange--------" + mRange);
        mTvTitleOnlyBack.setText(mRange + " - " + mStatus);

        mSrlMachineListMachine.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSrlMachineListMachine.setRefreshing(false);
            }
        });
        mRvMachineList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MachineListAdapter(this, R.layout.item_machine_list, getMachines());
        if (!isAddListener) {
            adapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    final MachineDataBean item = (MachineDataBean) baseQuickAdapter.getItem(i);
                    isMarkImportantMachine(item);
                    return false;
                }
            });
            adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    MachineDataBean item = (MachineDataBean) baseQuickAdapter.getItem(i);
                    Intent intent = new Intent(App.getApplication(), MachineInfoActivity.class);
                    intent.putExtra("machineId", item.getId());
                    intent.putExtra("machineName", item.getName());
                    startActivity(intent);
                }
            });
            isAddListener = true;
        }
        mRvMachineList.setAdapter(adapter);

    }

    private void isMarkImportantMachine(final MachineDataBean item) {
        dialog = new ModernDialog(this, R.layout.dialog_delete, new int[]{R.id.dialog_sure, R.id.dialog_cancel});
//        WindowOptionUtil.darkBackGround(0.6f, getActivity());
        dialog.show();


        if (!item.isImportant()) {
            dialog.setMessage("将 " + item.getName() + " 标记为我关注的设备");
        } else {
            dialog.setMessage("取消关注" + item.getName());
        }
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
//                WindowOptionUtil.darkBackGround(1.0f, getActivity());
            }
        });
        dialog.setOnModernItemClickListener(new ModernDialog.OnModernDialogItemClickListener() {
            @Override
            public void modernItemClickListener(ModernDialog dialog, View v) {
                switch (v.getId()) {
                    case R.id.dialog_sure:
                        item.setImportant(!item.isImportant());
                        dialog.dismiss();
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.dialog_cancel:
                        break;
                }
            }
        });
    }


    private List<MotorListEntity.DataBean.ListBean> getMachines() {
        List<MotorListEntity.DataBean.ListBean> machines = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            machines.add(new MotorListEntity.DataBean.ListBean(0.9,0,1,1,55,"工料车间","变频器",75,"除尘风机电机","380v","除尘风机"));
        }


        return machines;
    }


    @OnClick(R.id.iv_title_only_back)
    public void onViewClicked() {
        finish();
    }


}
