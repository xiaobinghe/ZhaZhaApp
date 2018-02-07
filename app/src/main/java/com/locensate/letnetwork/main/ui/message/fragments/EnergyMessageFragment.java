package com.locensate.letnetwork.main.ui.message.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.OrderMsgEntity;
import com.locensate.letnetwork.main.ui.message.MessageBaseFragment;
import com.locensate.letnetwork.main.ui.orderdetail.OrderDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 *  
 * @author xiaobinghe
 */

public class EnergyMessageFragment extends MessageBaseFragment {
    private static EnergyMessageFragment instance;
    private boolean isAddListener = false;

    public static EnergyMessageFragment getInstance() {
        if (null == instance) {instance = new EnergyMessageFragment();}
        return instance;
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        EnergyMessageAdapter adapter= new EnergyMessageAdapter(R.layout.item_message_energy_fragment, getItems());
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

    private List<OrderMsgEntity> getItems() {


        List<OrderMsgEntity> energys = new ArrayList<>();
        energys.add(new OrderMsgEntity("运行效率低，但设备是带载运行，请协助分析。", "某厂/三车间", "张芬芳", "2017-07-23  12:23", 0));
        energys.add(new OrderMsgEntity("长时间低效率运行，请提供解决方案。", "某厂/三车间", "张芬芳", "2017-07-12  09:15", 0));
        energys.add(new OrderMsgEntity("设备存在空载运行，低效率运行。", "某厂/三车间", "张芬芳", "2017-07-03  15:25", 0));
        energys.add(new OrderMsgEntity("设备更换高效电机后，实际能效仍然较低。", "某厂/三车间", "张芬芳", "2017-06-25  11:33", 0));
        energys.add(new OrderMsgEntity("运行效率低，请协助分析。", "某厂/三车间", "张芬芳", "2017-06-10  12:51", 0));
        return energys;
    }

    @Override
    protected void lazyLoad() {

    }

    private class EnergyMessageAdapter extends BaseQuickAdapter<OrderMsgEntity, BaseViewHolder> {
        public EnergyMessageAdapter(int item_message_fragment, List<OrderMsgEntity> items) {
            super(item_message_fragment, items);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, OrderMsgEntity entity) {
            if (entity.getNum() == 0) {
                baseViewHolder.setVisible(R.id.rl_energy_msg_num, false);
            } else {
                baseViewHolder.setVisible(R.id.rl_energy_msg_num, true);

            }

            baseViewHolder.setText(R.id.tv_energy_message, entity.getDes())
                    .setText(R.id.tv_energy_machine_path, entity.getAddress())
                    .setText(R.id.tv_energy_msg_num, String.valueOf(entity.getNum()))
                    .setText(R.id.tv_energy_machine, entity.getName())
                    .setText(R.id.tv_energy_occur_time, entity.getTime());
        }
    }
}
