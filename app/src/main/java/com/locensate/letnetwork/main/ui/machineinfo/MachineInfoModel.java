package com.locensate.letnetwork.main.ui.machineinfo;

import android.support.v4.app.Fragment;

import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.machinedesinfo.MachineInfoDataFragment;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.MachineInfoEnergyManagerFragment;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.MachineInfoFixManagerFragment;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.healthmanager.MachineInfoHealthyManagerFragment;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.monitorinfo.MachineInfoMonitorDataFragment;

/**
 *
 * @author xiaobinghe
 */

public class MachineInfoModel implements MachineInfoContract.Model {

    @Override
    public Fragment[] getFragments() {
        LogUtil.e("fragments", "创建了" + "++++++++++++");
        Fragment[] fragments = new Fragment[5];
        fragments[4] = new MachineInfoDataFragment();
        fragments[3] = new MachineInfoMonitorDataFragment();
        fragments[2] = new MachineInfoFixManagerFragment();
        fragments[1] = new MachineInfoHealthyManagerFragment();
        fragments[0] = new MachineInfoEnergyManagerFragment();
        return fragments;
    }
}
