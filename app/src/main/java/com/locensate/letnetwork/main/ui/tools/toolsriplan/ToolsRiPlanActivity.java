package com.locensate.letnetwork.main.ui.tools.toolsriplan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.entity.FilterEntity;
import com.locensate.letnetwork.entity.RoutingEntity;
import com.locensate.letnetwork.main.ui.RoutingDetailActivity;
import com.locensate.letnetwork.main.ui.tools.BaseToolsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * -------------------------------------
 * <p>
 * 项目名称： MotorTesting
 * <p>
 * 版权：locensate.com 版权所有 2016
 * <p>
 * 公司主页：http://www.locensate.com/
 * <p>
 * 描述：
 * <p>
 * 作者： xiaobinghe
 * <p>
 * 时间： 2017/1/18 16:55
 * <p>
 * 修改历史：
 * <p>
 * 修改时间：
 * <p>
 * 修改描述：
 * <p>
 * -------------------------------------
 */
public class ToolsRiPlanActivity extends BaseToolsActivity {

    @Override
    protected Activity getActivity() {
        return this;
    }

    @Override
    protected CharSequence setTitle() {
        return "工具-巡检";
    }

    @Override
    protected RecyclerView.Adapter setRVAdapter() {
        return new ToolsRiPlanRvAdapter(R.layout.item_tools_order, getData());
    }

    @Override
    protected void setRefreshListener(final SwipeRefreshLayout swipeRefreshLayout) {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Runnable runnable = new Runnable() {
                    public void run() {
                        SystemClock.sleep(2000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                swipeRefreshLayout.setRefreshing(false);
                            }
                        });
                    }
                };
            }
        });
    }

    @Override
    protected void setItemClickListener(RecyclerView recyclerView) {
        recyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RoutingEntity item = (RoutingEntity) baseQuickAdapter.getItem(i);
                Intent intent = new Intent(getApplication(), RoutingDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("routing", item);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    protected List<FilterEntity> getFilterData() {
        return null;
    }

    private List<RoutingEntity> getData() {
        ArrayList<RoutingEntity> routingEntities = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            routingEntities.add(new RoutingEntity("除尘风机", "" + i, (String) DateUtils.getData("2017年05月26日", DateUtils.getCurrentTimeMillis()), "检查机柜", "焦化厂/二车间", "李俊"));
        }
        return routingEntities;
    }
}
