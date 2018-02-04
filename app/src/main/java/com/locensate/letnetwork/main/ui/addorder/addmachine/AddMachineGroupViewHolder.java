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

public class AddMachineGroupViewHolder extends RecyclerView.ViewHolder {

    public TextView tvGroup;
    public LinearLayout llGroup;

    public AddMachineGroupViewHolder(View itemView) {
        super(itemView);
        tvGroup = itemView.findViewById(R.id.tv_machine_group);
        llGroup = itemView.findViewById(R.id.ll_machine_group);
    }
}
