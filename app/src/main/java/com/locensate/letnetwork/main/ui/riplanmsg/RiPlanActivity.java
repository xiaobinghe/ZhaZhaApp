package com.locensate.letnetwork.main.ui.riplanmsg;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;

import butterknife.BindView;

/**
 *
 * @author xiaobinghe
 */

public class RiPlanActivity extends BaseActivity<RiPlanPresenter, RiPlanMsgModel> implements RiPlanMsgContract.View {
    @BindView(R.id.ib_toolbar_back)
    ImageButton ibToolbarBack;
    @BindView(R.id.title_toolbar)
    TextView titleToolbar;
    @BindView(R.id.appbar_toolbar)
    Toolbar appbarToolbar;
    @BindView(R.id.rv_riplan_msg)
    RecyclerView rvRiplanMsg;
    @BindView(R.id.srl_riplan_msg)
    SwipeRefreshLayout srlRiplanMsg;

    @Override
    public int getLayoutId() {
        return R.layout.activity_riplan;
    }

    @Override
    public void initView() {
        titleToolbar.setText("巡检计划");
        ibToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        srlRiplanMsg.setRefreshing(false);
        srlRiplanMsg.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {srlRiplanMsg.setRefreshing(false);}
        });
        rvRiplanMsg.setLayoutManager(new LinearLayoutManager(this));
        rvRiplanMsg.setAdapter(new RiPlanMsgAdapter(R.layout.item_message_fragment,mModel.getInitData()));
    }
}
