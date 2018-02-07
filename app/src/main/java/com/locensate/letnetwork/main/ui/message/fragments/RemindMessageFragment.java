package com.locensate.letnetwork.main.ui.message.fragments;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.OrderMsgEntity;
import com.locensate.letnetwork.main.ui.RemindDetailActivity;
import com.locensate.letnetwork.main.ui.message.MessageBaseFragment;
import com.locensate.letnetwork.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * @author xiaobinghe
 */


public class RemindMessageFragment extends MessageBaseFragment {
    private static RemindMessageFragment instance;
    private boolean isAddClick = false;

    public static RemindMessageFragment getInstance() {
        if (null == instance) {
            instance = new RemindMessageFragment();
        }
        return instance;
    }
    @Override
    public RecyclerView.Adapter getAdapter() {
        RemindMessageAdapter adapter =
                new RemindMessageAdapter(R.layout.item_message_fragment, getItems());
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Intent intent = new Intent(getActivity(), RemindDetailActivity.class);
                intent.putExtra("remindId", "");
                startActivity(intent);
            }
        });
        return adapter;
    }

    private List<OrderMsgEntity> getItems() {
        ArrayList<OrderMsgEntity> items = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            items.add(new OrderMsgEntity("实验车间电表需要维修", "一车间/烧结厂/某钢厂", "测试电机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()), i % 4 + 1));

        }
        return items;
    }

    @Override
    protected void lazyLoad() {

    }

    private class RemindMessageAdapter extends BaseQuickAdapter<OrderMsgEntity, BaseViewHolder> {
        public RemindMessageAdapter(int item_message_fragment, List<OrderMsgEntity> items) {
            super(item_message_fragment, items);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, OrderMsgEntity entity) {
            if (entity.getNum() == 0) {
                baseViewHolder.setVisible(R.id.rl_order_msg_num, false);
            } else {
                baseViewHolder.setVisible(R.id.rl_order_msg_num, true);
            }

            baseViewHolder
                    .setText(R.id.tv_order_message, entity.getDes())
                    .setText(R.id.tv_order_occur_time, entity.getTime())
                    .setText(R.id.tv_order_machine_path, entity.getAddress())
                    .setText(R.id.tv_order_machine, entity.getName())
                    .setText(R.id.tv_order_msg_num, String.valueOf(entity.getNum()));
        }
    }
}
