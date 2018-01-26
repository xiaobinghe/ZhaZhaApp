package com.locensate.letnetwork.main.ui.fragments.overview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 *
 * @author xiaobinghe
 */

public class OverviewContainPageAdapter extends FragmentPagerAdapter {
    private final Fragment[] fragments;

    public OverviewContainPageAdapter(FragmentManager fm, Fragment[] fragments) {
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
}
