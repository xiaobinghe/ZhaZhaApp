package com.locensate.letnetwork.main.ui.addorder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.bean.EntpBean;

import java.util.List;


/**
 * $String
 *
 * @author xiaobinghe
 */

public class EnterpriseAdapter extends RecyclerView.Adapter<EnterpriseViewHolder> {

    private final Context context;
    private final List<EntpBean> enterprises;
    private SelectedListener selectedListener;

    public EnterpriseAdapter(Context context, List<EntpBean> entpBeen) {
        this.context = context;
        this.enterprises = entpBeen;
    }

    @Override
    public EnterpriseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EnterpriseViewHolder(View.inflate(context, R.layout.item_drop_list, null));
    }

    @Override
    public void onBindViewHolder(EnterpriseViewHolder holder, final int position) {
        holder.textView.setText(enterprises.get(position).getName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedListener.onSelect(enterprises.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return enterprises.size();
    }


    protected interface SelectedListener {
        /**
         * 当选中时调用
         *
         * @param entpBean entpbean
         */
        void onSelect(EntpBean entpBean);
    }

    public void setSelectListener(SelectedListener selectListener) {
        this.selectedListener = selectListener;

    }
}
