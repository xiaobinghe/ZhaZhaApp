package com.locensate.letnetwork.main.ui.ordermsg;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.utils.LogUtil;

import butterknife.BindView;

/**
 * orderMsg
 *
 * @author xiaobinghe
 */

public class OrderMsgActivity extends BaseActivity<OrderMsgPresenter, OrderMsgModel> implements OrderMsgContract.View {


    @BindView(R.id.title_toolbar)
    TextView titleToolbar;
    @BindView(R.id.appbar_toolbar)
    Toolbar appbarToolbar;
    @BindView(R.id.rv_order_msg)
    RecyclerView rvOrderMsg;
    @BindView(R.id.ib_toolbar_back)
    ImageButton ibToolbarBack;
    private OrderMsgAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_order_msg;
    }

    @Override
    public void initView() {
        LogUtil.e(TAG, "================工单消息界面创建了");
        titleToolbar.setText("工单消息");
        ibToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        rvOrderMsg.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OrderMsgAdapter(R.layout.item_message_fragment, mModel.getInitDate());
        rvOrderMsg.setAdapter(adapter);
    }
}
