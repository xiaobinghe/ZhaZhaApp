package com.locensate.letnetwork.main.ui;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.lib.WheelView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.utils.PickViewUtils;
import com.locensate.letnetwork.entity.MachineEntity;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager.remind.RemindEntity;
import com.locensate.letnetwork.view.ModifyDeletePop;
import com.locensate.letnetwork.view.timepick.MyTimePickerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author xiaobinghe
 */

public class AddRemindActivity extends BaseActivity {

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
    @BindView(R.id.et_remind_content)
    EditText etRemindContent;
    @BindView(R.id.tv_content_count)
    TextView tvContentCount;
    @BindView(R.id.btn_commit)
    Button btnCommit;
    @BindView(R.id.activity_add_remind)
    LinearLayout activityAddRemind;
    private ModifyDeletePop pop;
    private RemindEntity remindEntity;
    private String machineName;
    private boolean isEntity = true;
    private StringBuffer buffer;
    private List<String> selections = new ArrayList<>();
    private List<String> weeks = new ArrayList<>();
    private List<List<String>> hours = new ArrayList<>();
    private List<List<String>> dayHours = new ArrayList<>();
    private List<List<List<String>>> mins = new ArrayList<>();
    private List<List<List<String>>> dayMins = new ArrayList<>();
    private List<String> days = new ArrayList<>();
    private String[] dayLaybels = {"日", "时", "分"};
    private String[] weekLaybels = {"周", "时", "分"};
    private OptionsPickerView mTimeTypePicker;
    private MyTimePickerView mMyTimePickerView;
    private MyTimePickerView mHmPicker;
    private OptionsPickerView mWhm;
    private OptionsPickerView mDhm;

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_remind;
    }

    @Override
    public void initView() {
        initBaseData();
        remindEntity = (RemindEntity) getIntent().getExtras().getSerializable("remind");
        if (null == remindEntity) {
            machineName = getIntent().getExtras().getString("machineName");
            isEntity = false;
        } else {
            List<MachineEntity> machines = remindEntity.getMachines();
            buffer = new StringBuffer(remindEntity.getPath());
            for (MachineEntity entity : machines) {
                buffer.append(entity.getName()).append(";");
            }
        }
        tvLinkedMachines.setText(isEntity ? buffer.toString() : machineName);
        Calendar instance = Calendar.getInstance();
        instance.getTime().toString();
        tvCircleTime.setText(isEntity ? remindEntity.getTime() : DateUtils.getTime(new Date(), "2017-08-15 09:00"));
        tvCircleType.setText(isEntity ? remindEntity.getType() : "一次");
        etRemindContent.setText(isEntity ? remindEntity.getDes() : "");
        tvTitleOnlyBack.setText("添加提醒");
    }

    private void initBaseData() {
        selections.add("一次");
        selections.add("每天");
        selections.add("每周");
        selections.add("每月");
        weeks.add("周一");
        weeks.add("周二");
        weeks.add("周三");
        weeks.add("周四");
        weeks.add("周五");
        weeks.add("周六");
        weeks.add("周天");
        for (int i = 1; i < 32; i++) {
            List<List<String>> temp1 = new ArrayList<>();
            List<String> temp2 = new ArrayList<>();
            for (int j = 0; j < 24; j++) {
                List<String> tempMin = new ArrayList<>();
                for (int k = 0; k < 60; k++) {
                    tempMin.add(String.valueOf(i));
                }
                temp1.add(tempMin);
                temp2.add(String.valueOf(j));
            }
            dayMins.add(temp1);
            dayHours.add(temp2);
            days.add(String.valueOf(i));
        }
        for (int i = 0; i < weeks.size(); i++) {
            ArrayList<String> s = new ArrayList<>();
            List<List<String>> temps = new ArrayList<>();
            for (int j = 0; j < 24; j++) {
                s.add(String.valueOf(j));
                List<String> minis = new ArrayList<>();
                for (int k = 0; k < 60; k++) {
                    minis.add(String.valueOf(k));
                }
                temps.add(minis);
            }
            hours.add(s);
            mins.add(temps);
        }
    }


    @OnClick({R.id.iv_title_only_back, R.id.ll_circle_type, R.id.ll_circle_time, R.id.iv_add_linked_machines, R.id.btn_commit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_title_only_back:
                finish();
                break;
            case R.id.ll_circle_type:
                if (null == mTimeTypePicker) {
                    mTimeTypePicker = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            tvCircleType.setText(selections.get(options1));
                        }
                    }).setLayoutRes(R.layout.layout_time_type_select, new CustomListener() {
                        @Override
                        public void customLayout(View v) {
                            Button cancel = (Button) v.findViewById(R.id.btt_cancel);
                            Button okay = (Button) v.findViewById(R.id.btt_okay);
                            (v.findViewById(R.id.pick_head)).setVisibility(View.GONE);
                            okay.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mTimeTypePicker.returnData();
                                }
                            });
                            cancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mTimeTypePicker.dismiss();
                                }
                            });
                        }
                    })
                            .setSubmitColor(this.getResources().getColor(R.color.font_deep_blue))
                            .setCancelColor(this.getResources().getColor(R.color.font_deep_blue))
                            .setDividerType(WheelView.DividerType.FILL)
                            .setTitleBgColor(this.getResources().getColor(R.color.bg))
                            .setLineSpacingMultiplier(2.0f)
                            .setSubCalSize(16)
                            .setContentTextSize(16)
                            .setDividerColor(this.getResources().getColor(R.color.font_deep_blue))
                            .setTextColorCenter(this.getResources().getColor(R.color.font_deep_blue))
                            .isDialog(true).build();
                    mTimeTypePicker.setPicker(selections);
                }
                mTimeTypePicker.show();
                break;
            case R.id.ll_circle_time:
                switchTimePicker();
                break;
            case R.id.iv_add_linked_machines:
                break;
            case R.id.btn_commit:
                finish();
                break;
            default:
                break;
        }
    }

    private void switchTimePicker() {
        Calendar endData = Calendar.getInstance();
        endData.set(2018, 0, 1);
        String pickerType = tvCircleType.getText().toString();
        switch (pickerType) {
            case "一次":
                if (null == mMyTimePickerView) {
                    mMyTimePickerView = PickViewUtils.getInstance().getYMDHMPicker(this, Calendar.getInstance(), endData, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            tvCircleTime.setText(DateUtils.getTime(date, ""));
                        }
                    });
                }
                mMyTimePickerView.show();
                break;
            case "每天":
                if (null == mHmPicker) {
                    mHmPicker = PickViewUtils.getInstance().getHMPicker(this, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            tvCircleTime.setText(DateUtils.getTime(date, "时分"));
                        }
                    });
                }
                mHmPicker.show();
                break;
            case "每周":
                //                        LogUtil.e(TAG, "optionsl====" + options1 + "----options2====" + options2 + "----options3===" + options3);
                if (null == mWhm) {
                    mWhm = PickViewUtils.getInstance().getWHM(this, weekLaybels, new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            //                        LogUtil.e(TAG, "optionsl====" + options1 + "----options2====" + options2 + "----options3===" + options3);
                            tvCircleTime.setText(weeks.get(options1) + "  " + hours.get(options1).get(options2) + ":" + mins.get(options1).get(options2).get(options3));
                        }
                    });
                    mWhm.setPicker(weeks, hours, mins);
                }
                mWhm.show();
                break;
            case "每月":
                if (null == mDhm) {
                    mDhm = PickViewUtils.getInstance().getWHM(this, dayLaybels, new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            tvCircleTime.setText(days.get(options1) + "日  " + dayHours.get(options1).get(options2) + ":" + dayMins.get(options1).get(options2).get(options3));
                        }
                    });
                    mDhm.setPicker(days, dayHours, dayMins);
                }
                mDhm.show();
                break;
        }

    }
}
