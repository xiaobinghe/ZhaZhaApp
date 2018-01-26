package com.locensate.letnetwork.view.multigridview;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.utils.ToastUtil;
import com.locensate.letnetwork.entity.MultiSection;
import com.locensate.letnetwork.main.ui.fragments.machine.GridItem;
import com.locensate.letnetwork.entity.MultiSectionEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * @author xiaobinghe
 */

public class MultiGridView extends LinearLayout implements View.OnClickListener {
    @BindView(R.id.lv_multi_grid_view)
    ListView lvMultiGridView;
    private List<MultiSection> lists;
    private Context mContext;
    private List<MultiSectionEntity> multiData;
    private Button btCancel;
    private Button btComplete;
    private MultiSectionAdapter multiSectionAdapter;

    public MultiGridView(Context context) {
        this(context, null);
    }

    public MultiGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MultiGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MultiGridView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    /**
     * @param context
     */
    private void init(Context context) {
        this.mContext = context;
        setBackgroundColor(Color.WHITE);
        inflate(context, R.layout.layout_multi_grid, this);
        ButterKnife.bind(this, this);
    }

    public MultiGridView setGridData(List lists) {
        this.lists = lists;
        return this;
    }

    public MultiGridView build() {
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 4);
//        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                if (position == 0 || position == lists[0].size() + 1 || position == lists[0].size() + lists[1].size() + 2 || position == lists[0].size() + lists[1].size() + lists[2].size() + 3) {
//                    return 4;
//                }
//                return 1;
//            }
//        });
//        rvMultiGridView.setLayoutManager(gridLayoutManager);
//        rvMultiGridView.setAdapter(new MultiGridViewAdapter(getContext(), lists, this));

//        rvMultiGridView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
//        SectionAdapter sectionAdapter = new SectionAdapter(R.layout.holder_item_multigrid, R.layout.holder_title_multigrid, lists);
////        View foot = View.inflate(mContext, R.layout.foot_section_multigrid, null);
//
//        rvMultiGridView.addOnItemTouchListener(new OnItemClickListener() {
//            @Override
//            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
//                MultiSection multiSection = lists.get(i);
//                if (multiSection.isHeader) return;
//                else view.setSelected(true);
//            }
//        });
//        rvMultiGridView.setAdapter(sectionAdapter);
//        MultiFootView multiFootView = new MultiFootView(mContext);
//        sectionAdapter.addFooterView(multiFootView);

        multiSectionAdapter = new MultiSectionAdapter(mContext, multiData);
        View foot = View.inflate(mContext, R.layout.foot_section_multigrid, null);
        btCancel = (Button) foot.findViewById(R.id.bt_multi_grid_cancel);
        btComplete = (Button) foot.findViewById(R.id.bt_multi_grid_complete);
        btCancel.setOnClickListener(this);
        btComplete.setOnClickListener(this);
        lvMultiGridView.setAdapter(multiSectionAdapter);
        lvMultiGridView.addFooterView(foot);

        return this;
    }

    public MultiGridView setMultiData(List<MultiSectionEntity> multiData) {
        this.multiData = multiData;
        return this;
    }

    /***
     * @param view
     */
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_multi_grid_cancel:
                ToastUtil.show("Cancel");
                for (int i = 0; i < multiData.size(); i++) {
                    List<GridItem> item = multiData.get(i).getItems();
                    for (int j = 0; j < item.size(); j++) {
                        GridItem gridItem = item.get(j);
                        gridItem.setChecked(false);
                    }
                }
                multiSectionAdapter.notifyDataSetChanged();
                break;
            case R.id.bt_multi_grid_complete:
                ToastUtil.show("Complete");
                HashMap<String, List<String>> multiItems = new HashMap<>();
                for (int i = 0; i < multiData.size(); i++) {
                    List<GridItem> item = multiData.get(i).getItems();
                    ArrayList<String> items = new ArrayList<>();
                    for (int j = 0; j < item.size(); j++) {
                        GridItem gridItem = item.get(j);
                        if (gridItem.isChecked) {
                            items.add(gridItem.getTitle());
                        }
                    }
                    multiItems.put(multiData.get(i).getTitle(), items);
                }

                String toJson = new Gson().toJson(multiItems);
                break;
        }
    }

    private class SectionAdapter extends BaseSectionQuickAdapter<MultiSection, BaseViewHolder> {

        public SectionAdapter(int layoutResId, int sectionHeadResId, List data) {
            super(layoutResId, sectionHeadResId, data);
        }

        @Override
        protected void convertHead(BaseViewHolder baseViewHolder, MultiSection multiSection) {
            baseViewHolder.setText(R.id.tv_holder_title, multiSection.header);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, MultiSection multiSection) {
        }
    }
}
