package com.locensate.letnetwork.main.ui.message;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 *  
 * @author xiaobinghe
 */

public class MessageVpAdapter extends FragmentPagerAdapter {
    private final Fragment[] fragments;

    public MessageVpAdapter(FragmentManager supportFragmentManager, Fragment[] fragments) {
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
}
