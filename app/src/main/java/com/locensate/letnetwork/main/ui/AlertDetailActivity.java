package com.locensate.letnetwork.main.ui;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.entity.MessageEntity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *  
 * @author xiaobinghe
 */

public class AlertDetailActivity extends BaseActivity {


    @BindView(R.id.fl_alert_level)
    FrameLayout flAlertLevel;
    @BindView(R.id.tv_alert_machine)
    TextView tvAlertMachine;
    @BindView(R.id.tv_alert_point)
    TextView tvAlertPoint;
    @BindView(R.id.tv_alert_des)
    TextView tvAlertDes;
    @BindView(R.id.tv_alert_machine_path)
    TextView tvAlertMachinePath;
    @BindView(R.id.tv_alert_time)
    TextView tvAlertTime;
    @BindView(R.id.activity_alert_des)
    LinearLayout activityAlertDes;
    @BindView(R.id.iv_title_only_back)
    ImageView ivTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView tvTitleOnlyBack;
    private MessageEntity alertMsg;

    @Override
    public int getLayoutId() {
        return R.layout.activity_alert_des;
    }

    @Override
    public void initView() {
        tvTitleOnlyBack.setText("报警详情");
//        alertMsg = (MessageEntity) getIntent().getExtras().getSerializable("alertMsg");
        alertMsg = (MessageEntity) getIntent().getSerializableExtra("alertMsg");
        flAlertLevel.setBackground(alertMsg.getLevel().equals("high") ? getResources().getDrawable(R.drawable.alert_high_bg) : getResources().getDrawable(R.drawable.alert_low_bg));
        tvAlertDes.setText(alertMsg.getDes());
//        tvAlertMachine.setText(alertMsg.getPath());
        tvAlertMachinePath.setText(alertMsg.getPath());
        tvAlertPoint.setText(alertMsg.getName());
        tvAlertTime.setText(alertMsg.getTime());
    }


    @OnClick(R.id.iv_title_only_back)
    public void onClick() {
        finish();
    }
}
