package com.locensate.letnetwork.view.multigridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.main.ui.fragments.machine.GridItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;


/**
 *
 * @author xiaobinghe
 */


public class GridAdapter extends BaseAdapter {

    private final Context context;
    private List<GridItem> data = new ArrayList<>();

    public GridAdapter(Context context) {
        this.context = context;

    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.holder_item_multigrid, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final GridItem gridItem = data.get(position);

        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void notifyDataSetChanged(boolean isFolder, List<GridItem> items) {
        if (items == null || 0 == items.size()) return;
        data.clear();
        if (isFolder || items.size() < 5) {
            data.addAll(items);
        } else {
            data.add(items.get(0));
            data.add(items.get(1));
            data.add(items.get(2));
        }
        notifyDataSetChanged();
    }

    static class ViewHolder {
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}