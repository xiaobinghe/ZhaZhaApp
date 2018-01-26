package com.locensate.letnetwork.main.ui;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *  
 * @author xiaobinghe
 */

public class AddRepairActivity extends BaseActivity {

    @BindView(R.id.iv_title_only_back)
    ImageView ivTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView tvTitleOnlyBack;
    @BindView(R.id.tv_circle_type)
    TextView tvCircleType;
    @BindView(R.id.iv_circle_type)
    ImageView ivCircleType;
    @BindView(R.id.tv_circle_time)
    TextView tvCircleTime;
    @BindView(R.id.iv_circle_time)
    ImageView ivCircleTime;
    @BindView(R.id.tv_linked_machines)
    TextView tvLinkedMachines;
    @BindView(R.id.iv_add_linked_machines)
    ImageView ivAddLinkedMachines;
    @BindView(R.id.et_repair_content)
    EditText etRepairContent;
    @BindView(R.id.tv_content_count)
    TextView tvContentCount;
    @BindView(R.id.btn_commit)
    Button btnCommit;
    @BindView(R.id.activity_add_remind)
    LinearLayout activityAddRemind;

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_repair;
    }

    @Override
    public void initView() {
        tvTitleOnlyBack.setText("添加维修记录");

    }


    @OnClick({R.id.iv_title_only_back, R.id.iv_circle_type, R.id.iv_circle_time, R.id.btn_commit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_title_only_back:
                finish();
                break;
            case R.id.iv_circle_type:
                break;
            case R.id.iv_circle_time:
                break;
            case R.id.btn_commit:

                break;
            default:
                break;
        }
    }
}
