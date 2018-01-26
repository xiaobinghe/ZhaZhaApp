package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 *
 * @author xiaobinghe
 */

public class MachineEnergyPageAdapter extends FragmentPagerAdapter {
    private Fragment[] fragments;
    private String[] titles = {"效率", "负载", "峰谷平"};


    public MachineEnergyPageAdapter(FragmentManager fm, Fragment[] fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
