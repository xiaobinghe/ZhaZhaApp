package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager;

import android.support.v4.app.Fragment;

import com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyefficiency.EnergyEfficiencyFragment;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyfgp.EnergyFengGuPingFragment;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyLoad.EnergyLoadFragment;


/**
 *
 * @author xiaobinghe
 */

public class MachineInfoEnergyManagerModel implements MachineInfoEnergyManagerContract.Model {

    @Override
    public Fragment[] getFragments() {
        Fragment[] fragments = new Fragment[3];
        fragments[0] = new EnergyEfficiencyFragment();
        fragments[1] = new EnergyLoadFragment();
        fragments[2] = new EnergyFengGuPingFragment();
        return fragments;
    }
}
