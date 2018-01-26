package com.locensate.letnetwork.main.ui.smartmsg;

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

public class SmartMsgActivity extends BaseActivity<SmartMsgPresenter, SmartMsgModel> implements SmartMsgConstract.View {
    @BindView(R.id.ib_toolbar_back)
    ImageButton ibToolbarBack;
    @BindView(R.id.title_toolbar)
    TextView titleToolbar;
    @BindView(R.id.appbar_toolbar)
    Toolbar appbarToolbar;
    @BindView(R.id.rv_smart_msg)
    RecyclerView rvSmartMsg;
    @BindView(R.id.srl_smart_msg)
    SwipeRefreshLayout srlSmartMsg;

    @Override
    public int getLayoutId() {
        return R.layout.activity_smart_msg;
    }

    @Override
    public void initView() {
        titleToolbar.setText("智能分析");
        ibToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        srlSmartMsg.setRefreshing(false);
        srlSmartMsg.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {srlSmartMsg.setRefreshing(false);
            }
        });
        rvSmartMsg.setLayoutManager(new LinearLayoutManager(this));
        rvSmartMsg.setAdapter(new SmartMsgAdapter(R.layout.item_message_fragment,mModel.getInitData()));
    }

}
