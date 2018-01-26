package com.locensate.letnetwork.main.ui;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.entity.RepairEntity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *  
 * @author xiaobinghe
 */

public class RepairDetailActivity extends BaseActivity {

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
    private RepairEntity mRepair;

    @Override
    public int getLayoutId() {
        return R.layout.activity_repair_detail;
    }

    @Override
    public void initView() {
        tvTitleOnlyBack.setText("维修详情");
        mRepair = (RepairEntity) getIntent().getExtras().getSerializable("repair");
    }
    @OnClick(R.id.iv_title_only_back)
    public void onClick() {
        finish();
    }
}
