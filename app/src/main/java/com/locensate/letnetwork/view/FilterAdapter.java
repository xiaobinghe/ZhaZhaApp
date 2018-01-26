package com.locensate.letnetwork.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.locensate.letnetwork.R;

import java.util.List;


/**
 * $String
 *
 * @author xiaobinghe
 */
public class FilterAdapter<T> extends RecyclerView.Adapter<FilterViewHolder> {
    private Context context;
    private List<T> list;

    public FilterAdapter(Context context) {
        this.context = context;
    }

    @Override
    public FilterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FilterViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_grid_item, null));
    }

    @Override
    public void onBindViewHolder(FilterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void replaceAll(List<T> attrs) {
        if (list.size() > 0) {
            list.clear();
        }
        list.addAll(attrs);
        notifyDataSetChanged();
    }
}
