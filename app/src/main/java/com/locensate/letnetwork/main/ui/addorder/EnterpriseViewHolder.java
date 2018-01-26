package com.locensate.letnetwork.main.ui.addorder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.locensate.letnetwork.R;

/**
 * $String
 *
 * @author xiaobinghe
 */

public class EnterpriseViewHolder extends RecyclerView.ViewHolder {

    public  TextView textView;

    public EnterpriseViewHolder(View itemView) {
        super(itemView);
        this.textView= (TextView) itemView.findViewById(R.id.tv_drop);
    }
}
