package com.locensate.letnetwork.main.ui.addorder.addmachine;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.locensate.letnetwork.R;

/**
 * $String
 *
 * @author xiaobinghe
 */

public class AddMachineSingleViewHolder extends RecyclerView.ViewHolder {

    public TextView tvSingle;
    public LinearLayout llSingle;

    public AddMachineSingleViewHolder(View itemView) {
        super(itemView);
        tvSingle = (TextView) itemView.findViewById(R.id.tv_machine_single);
        llSingle = (LinearLayout) itemView.findViewById(R.id.ll_machine_single);
    }
}
