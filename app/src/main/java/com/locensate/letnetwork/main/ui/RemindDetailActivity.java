package com.locensate.letnetwork.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.remind.RemindEntity;
import com.locensate.letnetwork.view.ModernDialog;
import com.locensate.letnetwork.view.ModifyDeletePop;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *  
 * @author xiaobinghe
 */

public class RemindDetailActivity extends BaseActivity {
    @BindView(R.id.iv_normal_title_back)
    ImageView ivNormalTitleBack;
    @BindView(R.id.tv_normal_title_content)
    TextView tvNormalTitleContent;
    @BindView(R.id.iv_normal_title_more)
    ImageView ivNormalTitleMore;
    @BindView(R.id.tv_remind_data)
    TextView tvRemindData;
    @BindView(R.id.tv_remind_time_hour)
    TextView tvRemindTimeHour;
    @BindView(R.id.tv_remind_time_minute)
    TextView tvRemindTimeMinute;
    @BindView(R.id.tv_linked_machines)
    TextView tvLinkedMachines;
    @BindView(R.id.tv_remind_content)
    TextView tvRemindContent;
    @BindView(R.id.activity_remind_des)
    LinearLayout activityRemindDes;

    private ModifyDeletePop pop;
    private RemindEntity remindEntity;
    private ModernDialog mDialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_remind_des;
    }

    @Override
    public void initView() {
        tvNormalTitleContent.setText("提醒详情");
        remindEntity = (RemindEntity) getIntent().getSerializableExtra("remind");
    }

    @OnClick({R.id.iv_normal_title_back, R.id.iv_normal_title_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_normal_title_back:
                finish();
                break;
            case R.id.iv_normal_title_more:
                if (null == pop) {
                    pop = new ModifyDeletePop(this, R.layout.layout_modify_delete_pop, new ModifyDeletePop.OnItemClickListener() {
                        @Override
                        public void onClick(int position) {
                            switch (position) {
                                case 0:
                                    Intent intent = new Intent(getApplication(), AddRemindActivity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putSerializable("remind", remindEntity);
                                    intent.putExtras(bundle);
                                    startActivity(intent);
                                    break;
                                case 1:
                                    mDialog = new ModernDialog(RemindDetailActivity.this, R.layout.dialog_delete, new int[]{R.id.dialog_sure, R.id.dialog_cancel});
                                    mDialog.show();
                                    mDialog.setMessage("确定删除该提醒？");
                                    mDialog.setOnModernItemClickListener(new ModernDialog.OnModernDialogItemClickListener() {
                                        @Override
                                        public void modernItemClickListener(ModernDialog dialog, View v) {
                                            switch (v.getId()) {
                                                case R.id.dialog_sure:
                                                    finish();
                                                    break;
                                                case R.id.dialog_cancel:
                                                    break;
                                            }
                                        }
                                    });
                                    break;
                            }
                        }
                    });
                }
                pop.showPopupWindow(ivNormalTitleMore);
                break;
        }
    }
}
