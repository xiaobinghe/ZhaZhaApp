package com.locensate.letnetwork.main.ui.addorder.addmachine;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.MachineEntity;

import java.util.List;

/**
 * $String
 *
 * @author xiaobinghe
 */
public class AddMachineRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<MachineEntity> data;
    private final Context context;

    private MachineEntity selected;

    public enum ITEM_TYPE {
        TYPE_GROUP,
        TYPE_SINGLE
    }

    @Override
    public int getItemViewType(int position) {
        return position >= 0 ? ITEM_TYPE.TYPE_SINGLE.ordinal() : ITEM_TYPE.TYPE_GROUP.ordinal();
    }

    public AddMachineRvAdapter(List<MachineEntity> data, Context activity) {
        this.data = data;
        this.context = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.TYPE_GROUP.ordinal()) {
            return new AddMachineGroupViewHolder(View.inflate(context, R.layout.layout_add_machine_group, null));
        } else {
            return new AddMachineSingleViewHolder(View.inflate(context, R.layout.layout_add_machine_single, null));
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof AddMachineGroupViewHolder) {
            ((AddMachineGroupViewHolder) holder).tvGroup.setText(data.get(position).getName());
        } else if (holder instanceof AddMachineSingleViewHolder) {
            if (selected != null && selected.getName().equals(data.get(position).getName())) {
                ((AddMachineSingleViewHolder) holder).llSingle.setBackgroundColor(ContextCompat.getColor(context, R.color.font_blue_tab));
                ((AddMachineSingleViewHolder) holder).tvSingle.setTextColor(App.getApplication().getResources().getColor(R.color.white));
            }else{
                ((AddMachineSingleViewHolder) holder).llSingle.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                ((AddMachineSingleViewHolder) holder).tvSingle.setTextColor(App.getApplication().getResources().getColor(R.color.font_black));

            }

            ((AddMachineSingleViewHolder) holder).tvSingle.setText(data.get(position).getName());

            ((AddMachineSingleViewHolder) holder).llSingle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selected = data.get(position);
                    notifyDataSetChanged();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    /**
     * 获取选中的设备*
     *
     * @return 选中设备@Link{MachineEntity}
     */
    public MachineEntity getSelecedMachine() {
        return selected;
    }
}
