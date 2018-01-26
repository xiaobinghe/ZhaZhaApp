package com.locensate.letnetwork.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.gson.Gson;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.FilterEntries;

/**
 * $String
 *
 * @author xiaobinghe
 */
public class FilterView extends FrameLayout {
    private final Context context;
    private String dJson = "";
    private RecyclerView mRvFilter;
    private Button mReset;
    private Button mComplete;
    private FilterAdapter mFilterAdapter;
    private FilterEntries attrs;

    public FilterView(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    private BaseSingleClickListener singleClickListener = new BaseSingleClickListener() {
        @Override
        void onSingleClick(View view) {
            switch (view.getId()) {
                case R.id.btt_filter_reset:
                    resetDate();
                case R.id.btt_filter_okay:
                    mCallbackCloseDrawer.closeDrawer();
                    break;
                default:
                    break;
            }
        }
    };

    private void resetDate() {
        for (FilterEntries.FirstLevels first : attrs.getFirst()) {
            for (FilterEntries.FirstLevels.SecondLevels second : first.getSelected()) {
                second.setSelected(false);
            }
        }
    }

    private CallbackCloseDrawer mCallbackCloseDrawer;


    public void setCallbackCloseDrawer(CallbackCloseDrawer callbackCloseDrawer) {
        this.mCallbackCloseDrawer = callbackCloseDrawer;

    }

    public interface CallbackCloseDrawer {
        /**
         * 关闭drawer
         */
        void closeDrawer();
    }

    private void initView() {
        View.inflate(context, R.layout.layout_filter, this);
        mRvFilter = (RecyclerView) findViewById(R.id.rv_filter);
        mReset = (Button) findViewById(R.id.btt_filter_reset);
        mComplete = (Button) findViewById(R.id.btt_filter_okay);
        mReset.setOnClickListener(singleClickListener);
        mComplete.setOnClickListener(singleClickListener);
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        attrs = new Gson().fromJson(dJson, FilterEntries.class);
        if (null == mFilterAdapter) {
            mRvFilter.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
            mFilterAdapter = new FilterAdapter(context);
        } else {
            mFilterAdapter.replaceAll(attrs.getFirst());
        }
    }

    public void setdJson(String dJson) {
        this.dJson = dJson;
        setUpRecyclerView();
    }
}
