package com.locensate.letnetwork.main.ui.tools.toolsorder;

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
import com.locensate.letnetwork.entity.FilterEntity;
import com.locensate.letnetwork.entity.FilterMark;
import com.locensate.letnetwork.entity.OrderMsgEntity;
import com.locensate.letnetwork.main.ui.orderdetail.OrderDetailActivity;
import com.locensate.letnetwork.main.ui.tools.BaseToolsActivity;

import java.util.ArrayList;
import java.util.List;


/**
 *  
 * @author xiaobinghe
 */

public class ToolsOrderActivity extends BaseToolsActivity {

    private String mOrderType;

    @Override
    protected Activity getActivity() {
        return this;
    }

    @Override
    protected CharSequence setTitle() {
        mOrderType = getIntent().getStringExtra("orderType");
        return mOrderType.equals("order") ? "工具-工单" : "工具-能效";
    }

    @Override
    protected RecyclerView.Adapter setRVAdapter() {
        return new ToolsOrderRVAdapter(R.layout.item_tools_order, mOrderType.equals("order") ? getOrderData() : getEnergyData());
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
                OrderMsgEntity item = (OrderMsgEntity) baseQuickAdapter.getItem(i);
                Intent intent = new Intent(getApplication(), OrderDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("order", item);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    /**
     * @author xiaobinghe
     * @time
     * @describe 获取筛选标签数据
     */
    @Override
    protected List<FilterEntity> getFilterData() {

        ArrayList<FilterEntity> entities = new ArrayList<>();
        entities.add(new FilterEntity(true, "工单状态"));
        entities.add(new FilterEntity(new FilterMark("待处理", false)));
        entities.add(new FilterEntity(new FilterMark("已完成", false)));
        entities.add(new FilterEntity(new FilterMark("已评价", false)));

        entities.add(new FilterEntity(true, "控制设备类型"));
        entities.add(new FilterEntity(new FilterMark("变频器", false)));
        entities.add(new FilterEntity(new FilterMark("软启动器", false)));
        entities.add(new FilterEntity(new FilterMark("SGY", false)));
        entities.add(new FilterEntity(new FilterMark("智能开关", false)));
        entities.add(new FilterEntity(new FilterMark("自耦", false)));
        entities.add(new FilterEntity(new FilterMark("直接启动", false)));

        entities.add(new FilterEntity(true, "评价等级"));
        entities.add(new FilterEntity(new FilterMark("未评价", false)));
        entities.add(new FilterEntity(new FilterMark("非常满意", false)));
        entities.add(new FilterEntity(new FilterMark("满意", false)));
        entities.add(new FilterEntity(new FilterMark("一般", false)));
        entities.add(new FilterEntity(new FilterMark("不满意", false)));
        entities.add(new FilterEntity(new FilterMark("非常不满意", false)));


        return entities;
    }

    /*工單数据*/
    public List<OrderMsgEntity> getOrderData() {
        List<OrderMsgEntity> orders = new ArrayList<>();

        orders.add(new OrderMsgEntity("变频器起动时报警停机，检查线路没问题，启动两次均失败。", "罗圣森特/一车间", "李俊", "2017-08-12  12:23", 0));
        orders.add(new OrderMsgEntity("变频运行中超温报警，但钳表测量电流不足60%。", "罗圣森特/一车间", "李俊", "2017-08-05  10:36", 0));
        orders.add(new OrderMsgEntity("变频器起动报警，电阻充电失败，请协助。", "罗圣森特/一车间", "李俊", "2017-07-25  15:15", 0));
        orders.add(new OrderMsgEntity("SGY运行中输出端缺相报警，已检查线路没有断开。", "罗圣森特/一车间", "李俊", "2017-07-19  16:20", 0));
        orders.add(new OrderMsgEntity("变频器运行中跳闸，未看到故障码，请协助。", "罗圣森特/一车间", "李俊", "2017-07-13  09:55", 0));
        return orders;
    }

    /*能效数据*/
    public List<OrderMsgEntity> getEnergyData() {

        List<OrderMsgEntity> energys = new ArrayList<>();
        energys.add(new OrderMsgEntity("运行效率低，但设备是带载运行，请协助分析。", "某厂/三车间", "张芬芳", "2017-07-23  12:23", 0));
        energys.add(new OrderMsgEntity("长时间低效率运行，请提供解决方案。", "某厂/三车间", "张芬芳", "2017-07-12  09:15", 0));
        energys.add(new OrderMsgEntity("设备存在空载运行，低效率运行。", "某厂/三车间", "张芬芳", "2017-07-03  15:25", 0));
        energys.add(new OrderMsgEntity("设备更换高效电机后，实际能效仍然较低。", "某厂/三车间", "张芬芳", "2017-06-25  11:33", 0));
        energys.add(new OrderMsgEntity("运行效率低，请协助分析。", "某厂/三车间", "张芬芳", "2017-06-10  12:51", 0));
        return energys;
    }
}
