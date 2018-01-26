package com.locensate.letnetwork.main.ui.orderdetail;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.entity.OrderCommunicate;

import java.util.Date;
import java.util.List;


/**
 *  
 * @author xiaobinghe
 */

public class OrderDetailRvAdapter extends BaseQuickAdapter<OrderCommunicate, BaseViewHolder> {

    public OrderDetailRvAdapter(int layoutResId, List<OrderCommunicate> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, OrderCommunicate orderCommunicate) {

        String dateToWeek = DateUtils.getDateToWeek(new Date(orderCommunicate.getDate()));
        String data = (String) DateUtils.getData("yyyy年MM月dd日 HH:mm", orderCommunicate.getDate());
        baseViewHolder.setText(R.id.tv_communicate_date, "7月23日")
                .setText(R.id.tv_communicate_week, "周日")
                .setText(R.id.tv_communicate_time,"15:23")
                .setText(R.id.tv_communicate_person,orderCommunicate.getPerson())
                .setText(R.id.tv_communicate_content, orderCommunicate.getContent());


    }
}
