package com.locensate.letnetwork.main.ui;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.entity.RoutingEntity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *  
 * @author xiaobinghe
 */

public class RoutingDetailActivity extends BaseActivity {


    @BindView(R.id.iv_title_only_back)
    ImageView ivTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView tvTitleOnlyBack;
    @BindView(R.id.tv_person)
    TextView tvPerson;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_linked_machines)
    TextView tvLinkedMachines;
    @BindView(R.id.et_repair_content)
    TextView etRepairContent;
    @BindView(R.id.activity_add_remind)
    LinearLayout activityAddRemind;
    private RoutingEntity mRouting;

    @Override
    public int getLayoutId() {
        return R.layout.activity_routing_des;
    }

    @Override
    public void initView() {
        tvTitleOnlyBack.setText("巡检详情");
        mRouting = (RoutingEntity) getIntent().getExtras().getSerializable("routing");
    }

    @OnClick(R.id.iv_title_only_back)
    public void onClick() {
        finish();
    }
}
