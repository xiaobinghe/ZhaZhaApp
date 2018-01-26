package com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * adapter of machine info
 *
 * @author xiaobinghe
 */

public class MachineInfoFixManagerVpAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    private String[] tabs = {"报警", "工单", "巡检", "维修", "能效", "提醒"};

    public MachineInfoFixManagerVpAdapter(FragmentManager childFragmentManager, List<Fragment> fragments) {
        super(childFragmentManager);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
