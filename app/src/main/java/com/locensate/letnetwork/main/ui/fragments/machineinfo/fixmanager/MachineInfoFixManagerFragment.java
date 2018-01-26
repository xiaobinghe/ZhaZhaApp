package com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseFragment;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.main.ui.machineinfo.MachineInfoActivity;
import com.locensate.letnetwork.view.SmoothViewPage;

import java.util.List;

import butterknife.BindView;

/**
 *  
 * @author xiaobinghe
 */

public class MachineInfoFixManagerFragment extends BaseFragment<MachineInfoFixManagerPresenter, MachineInfoFixManagerModel> implements MachineInfoFixManagerContract.View, ViewPager.OnPageChangeListener {
    @BindView(R.id.vp_machine_fix_manager)
    SmoothViewPage vpMachineFixManager;
    @BindView(R.id.tl_machine_fix_manager)
    TabLayout tlMachineFixManager;

    private boolean hasStop = false;
    private String machineName;
    private Bundle mMachineInfo;
    private String machineId;

    /*public static Fragment getInstance(String machineData) {
        if (fixRecord == null) {
            fixRecord = new MachineInfoFixManagerFragment();
            Bundle bundle = new Bundle();
            bundle.putString("machineName", machineData);
            fixRecord.setArguments(bundle);
        }

        return fixRecord;
    }*/

    @Override
    protected void initView() {

    }

    @Override
    public int getInflaterView() {
        return R.layout.fragment_fix_recrd;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void fillData(List<Fragment> fragments) {
        MachineInfoActivity context = (MachineInfoActivity) getActivity();
        mMachineInfo = context.getMachineInfo();
        machineName = mMachineInfo.getString("machineName");
        machineId = mMachineInfo.getString("machineId");
        LogUtil.e("hasStop", "++++++++++++++++++++=======" + hasStop);
        vpMachineFixManager.setAdapter(new MachineInfoFixManagerVpAdapter(getChildFragmentManager(), fragments));
        vpMachineFixManager.addOnPageChangeListener(this);
        tlMachineFixManager.post(new Runnable() {
            @Override
            public void run() {
                tlMachineFixManager.setupWithViewPager(vpMachineFixManager);
            }
        });
    }


    @Override
    public String getMachineName() {
        return machineName;
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        hasStop = true;
        LogUtil.e("hasStop", "onDestroy++++++++++++++++++++=======" + hasStop);

    }

    @Override
    public void onResume() {
        super.onResume();
        hasStop = false;
        LogUtil.e("hasStop", "onResume++++++++++++++++++++=======" + hasStop);

    }

    @Override
    public void onDestroyView() {
        vpMachineFixManager.setAdapter(null);
        super.onDestroyView();
    }
}
