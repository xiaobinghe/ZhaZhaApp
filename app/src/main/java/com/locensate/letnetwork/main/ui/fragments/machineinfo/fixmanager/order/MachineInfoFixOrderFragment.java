package com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.OrderMsgEntity;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.BaseFixManagerFragment;
import com.locensate.letnetwork.main.ui.orderdetail.OrderDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xiaobinghe
 */

public class MachineInfoFixOrderFragment extends BaseFixManagerFragment {
    private boolean isAddListener = false;
    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void refreshData(BaseFixManagerFragment.OnRefreshComplete onRefreshComplete) {
        onRefreshComplete.complete();
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        FixOrderAdapter adapter= new FixOrderAdapter(R.layout.item_fix_order_msg, getOrderList());
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                OrderMsgEntity item = (OrderMsgEntity) baseQuickAdapter.getItem(i);
                Intent intent = new Intent(getActivity(), OrderDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("order", item);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        return adapter;
    }

    @Override
    protected void addClickListener(RecyclerView rvFixOrder) {
    }

    @Override
    protected void lazyLoad() {

    }

    public List<OrderMsgEntity> getOrderList() {
        List<OrderMsgEntity> orders = new ArrayList<>();

        orders.add(new OrderMsgEntity("变频器起动时报警停机，检查线路没问题，启动两次均失败。", "罗圣森特/一车间", "李俊", "2017-08-12  12:23", 0));
        orders.add(new OrderMsgEntity("变频运行中超温报警，但钳表测量电流不足60%。", "罗圣森特/一车间", "李俊", "2017-08-05  10:36", 0));
        orders.add(new OrderMsgEntity("变频器起动报警，电阻充电失败，请协助。", "罗圣森特/一车间", "李俊", "2017-07-25  15:15", 0));
        orders.add(new OrderMsgEntity("SGY运行中输出端缺相报警，已检查线路没有断开。", "罗圣森特/一车间", "李俊", "2017-07-19  16:20", 0));
        orders.add(new OrderMsgEntity("变频器运行中跳闸，未看到故障码，请协助。", "罗圣森特/一车间", "李俊", "2017-07-13  09:55", 0));
        return orders;
    }

}
