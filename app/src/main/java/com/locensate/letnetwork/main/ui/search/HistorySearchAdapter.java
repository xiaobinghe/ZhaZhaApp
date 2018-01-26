package com.locensate.letnetwork.main.ui.search;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.database.SearchHistoryDb;

import java.util.List;

/**
 *
 * @author xiaobinghe
 */

public class HistorySearchAdapter extends BaseAdapter {
    private List<SearchHistoryDb> data;
    private Context context;

    public HistorySearchAdapter(Context context, List<SearchHistoryDb> historyArray) {
        this.data = historyArray;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
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
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_history_search, null);
            viewHolder = new ViewHolder();
            viewHolder.history_search = (TextView) convertView.findViewById(R.id.tv_history_search_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.history_search.setText(data.get(position).getCont());
        return convertView;
    }

    class ViewHolder {
        public TextView history_search;
    }
}
