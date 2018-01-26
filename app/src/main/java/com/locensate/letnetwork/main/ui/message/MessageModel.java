package com.locensate.letnetwork.main.ui.message;

import android.support.v4.app.Fragment;

import com.locensate.letnetwork.main.ui.message.fragments.AlertMessageFragment;
import com.locensate.letnetwork.main.ui.message.fragments.EnergyMessageFragment;
import com.locensate.letnetwork.main.ui.message.fragments.OrderMessageFragment;
import com.locensate.letnetwork.main.ui.message.fragments.RemindMessageFragment;

/**
 *  
 * @author xiaobinghe
 */

public class MessageModel implements MessageContract.Model {
    @Override
    public Fragment[] getMessageFragments() {
        Fragment[] fragments = new Fragment[4];
        fragments[0] = AlertMessageFragment.getInstance();
        fragments[1] = EnergyMessageFragment.getInstance();
        fragments[2] = OrderMessageFragment.getInstance();
        fragments[3] = RemindMessageFragment.getInstance();
        return fragments;
    }
}
