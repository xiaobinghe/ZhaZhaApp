package com.locensate.letnetwork.view.multigridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.main.ui.fragments.machine.GridItem;
import com.locensate.letnetwork.entity.MultiSectionEntity;
import com.locensate.letnetwork.view.NoScrollGridview;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 *
 * @author xiaobinghe
 */

public class MultiSectionAdapter extends BaseAdapter {

    private final List<MultiSectionEntity> lists;
    private final Context context;

    public MultiSectionAdapter(Context mContext, List<MultiSectionEntity> lists) {
        this.context = mContext;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists == null ? 0 : lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_multi_grid, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final MultiSectionEntity multiSectionEntity = lists.get(position);
        viewHolder.tvItemGrid.setText(multiSectionEntity.getTitle());
        final GridAdapter gridAdapter = new GridAdapter(context);
        viewHolder.attrListGrid.setAdapter(gridAdapter);
        gridAdapter.notifyDataSetChanged(multiSectionEntity.isFolder, multiSectionEntity.getItems());
        viewHolder.ivMultiGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (multiSectionEntity.isFolder) {
                    viewHolder.ivMultiGrid.setImageResource(R.mipmap.sort_common_down);
                } else {
                    viewHolder.ivMultiGrid.setImageResource(R.mipmap.sort_common_up);
                }
                gridAdapter.notifyDataSetChanged(!multiSectionEntity.isFolder, multiSectionEntity.getItems());
                multiSectionEntity.setFolder(!multiSectionEntity.isFolder);
            }
        });
        viewHolder.attrListGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GridItem gridItem = multiSectionEntity.getItems().get(position);
                gridItem.setChecked(!gridItem.isChecked);

            }
        });
        return convertView;
    }


    static class ViewHolder {
        @BindView(R.id.tv_item_grid)
        TextView tvItemGrid;
        @BindView(R.id.iv_multi_grid)
        ImageView ivMultiGrid;
        @BindView(R.id.attr_list_grid)
        NoScrollGridview attrListGrid;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
