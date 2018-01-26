package com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager;

import android.support.v4.app.Fragment;

import com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.alert.MachineInfoFixAlertFragment;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.energyefficiency.MachineInfoFixEnergyEfficiencyFragment;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.order.MachineInfoFixOrderFragment;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.remind.MachineInfoFixRemindFragment;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.repair.MachineInfoFixRepairFragment;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.routing.MachineInfoFixRoutingFragment;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xiaobinghe
 */

public class MachineInfoFixManagerModel implements MachineInfoFixManagerContract.Model {
    @Override
    public List<Fragment> getFragments() {
        List<Fragment> fragments=new ArrayList<>();
        fragments.add(new MachineInfoFixAlertFragment());
        fragments.add(new MachineInfoFixOrderFragment());
        fragments.add(new MachineInfoFixRoutingFragment());
        fragments.add(new MachineInfoFixRepairFragment());
        fragments.add(new MachineInfoFixEnergyEfficiencyFragment());
        fragments.add(new MachineInfoFixRemindFragment());
        return fragments;
    }
}
