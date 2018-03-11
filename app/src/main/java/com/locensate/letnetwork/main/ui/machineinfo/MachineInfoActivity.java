package com.locensate.letnetwork.main.ui.machineinfo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.locensate.letnetwork.AppManager;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.main.ui.AddRemindActivity;
import com.locensate.letnetwork.main.ui.AddRepairActivity;
import com.locensate.letnetwork.main.ui.CreateRiPlanActivity;
import com.locensate.letnetwork.main.ui.addorder.AddOrderActivity;
import com.locensate.letnetwork.view.MachineInfoPop;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 设备信息
 *
 * @author xiaobinghe
 */

public class MachineInfoActivity extends BaseActivity<MachineInfoPresenter, MachineInfoModel> implements MachineInfoContract.View {


    @BindView(R.id.iv_normal_title_back)
    ImageView ivNormalTitleAdd;
    @BindView(R.id.tv_normal_title_content)
    TextView tvNormalTitleContent;
    @BindView(R.id.iv_normal_title_more)
    ImageView ivNormalTitleMore;
    @BindView(R.id.tl_machine_info)
    TabLayout tlMachineInfo;
    @BindView(R.id.vp_machine_info_content)
    ViewPager vpMachineInfoContent;
    private String machineName;
    private long motorId;

    private MachineInfoPop machineInfoPop;
    private Bundle mExtras;

    @Override
    public int getLayoutId() {
        return R.layout.activity_machine_info;
    }

    @Override
    public void initView() {
        mExtras = getIntent().getExtras();
        machineName = mExtras.getString("machineName");
        motorId = mExtras.getLong("motorId");
        tvNormalTitleContent.setText(machineName);
    }

    @Override
    public void addVPAdapter(Fragment[] fragments) {
        vpMachineInfoContent.setOffscreenPageLimit(5);
        vpMachineInfoContent.setAdapter(new MachineInfoAdapter(this.getSupportFragmentManager(), fragments));
        tlMachineInfo.post(new Runnable() {
            @Override
            public void run() {
                tlMachineInfo.setupWithViewPager(vpMachineInfoContent);
                tlMachineInfo.setTabGravity(TabLayout.GRAVITY_FILL);
            }
        });
        tlMachineInfo.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void showPop() {
        if (null == machineInfoPop) {
            machineInfoPop = new MachineInfoPop(this, R.layout.layout_machine_info_pop, new MachineInfoPop.OnItemClickListener() {
                @Override
                public void onClick(int position) {
                    Bundle data = new Bundle();
                    data.putString("machineName", machineName);
                    switch (position) {
                        case 0:
                            AppManager.skipActivityWithData(AddOrderActivity.class, data, mContext);
                            break;
                        case 1:
                            AppManager.skipActivityWithData(AddRemindActivity.class, data, mContext);
                            break;
                        case 2:
                            AppManager.skipActivityWithData(AddOrderActivity.class, data, mContext);
                            break;
                        case 3:
                            AppManager.skipActivityWithData(CreateRiPlanActivity.class, data, mContext);
                            break;
                        case 4:
                            AppManager.skipActivityWithData(AddRepairActivity.class, data, mContext);
                            break;
                        default:
                            break;
                    }
                }
            });
        }
        machineInfoPop.showPopupWindow(ivNormalTitleMore);
    }

    @OnClick({R.id.iv_normal_title_back, R.id.iv_normal_title_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_normal_title_back:
                finish();
                break;
            case R.id.iv_normal_title_more:
                mPresenter.showPop();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        vpMachineInfoContent.setAdapter(null);
        super.onDestroy();
    }

    public Bundle getMachineInfo() {
        return mExtras;
    }
}
