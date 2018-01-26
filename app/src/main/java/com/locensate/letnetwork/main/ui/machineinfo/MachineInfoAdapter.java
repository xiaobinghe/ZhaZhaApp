package com.locensate.letnetwork.main.ui.machineinfo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 *
 * @author xiaobinghe
 */

public class MachineInfoAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments;
    private String[] tabs = {"能效管理", "健康管理", "运维管理", "监测数据", "设备信息"};

    public MachineInfoAdapter(FragmentManager supportFragmentManager, Fragment[] fragments) {
        super(supportFragmentManager);
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
        return tabs[position];
    }
}
