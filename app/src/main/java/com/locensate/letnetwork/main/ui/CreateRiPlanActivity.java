package com.locensate.letnetwork.main.ui;

import android.app.DatePickerDialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.utils.PickViewUtils;
import com.locensate.letnetwork.utils.ToastUtil;
import com.locensate.letnetwork.view.timepick.MyTimePickerView;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;


/**
 *  
 * @author xiaobinghe
 */

public class CreateRiPlanActivity extends BaseActivity {

    @BindView(R.id.iv_title_only_back)
    ImageView mIvTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView mTvTitleOnlyBack;
    @BindView(R.id.tv_date)
    TextView mTvDate;
    @BindView(R.id.iv_circle_type)
    ImageView mIvCircleType;
    @BindView(R.id.ll_date)
    LinearLayout mLlDate;
    @BindView(R.id.tv_time)
    TextView mTvTime;
    @BindView(R.id.iv_circle_time)
    ImageView mIvCircleTime;
    @BindView(R.id.ll_time)
    LinearLayout mLlTime;
    @BindView(R.id.tv_linked_machines)
    TextView mTvLinkedMachines;
    @BindView(R.id.iv_add_linked_machines)
    ImageView mIvAddLinkedMachines;
    @BindView(R.id.et_routing_content)
    EditText mEtRoutingContent;
    @BindView(R.id.tv_content_count)
    TextView mTvContentCount;
    @BindView(R.id.btn_commit)
    Button mBtnCommit;
    @BindView(R.id.activity_add_remind)
    LinearLayout mActivityAddRemind;
    private String date;
    private String time;
    private DatePickerDialog datePickerDialog;
    private MyTimePickerView mYmdPicker;
    private MyTimePickerView mHmPicker;

    @Override
    public int getLayoutId() {
        return R.layout.activity_create_riplan;
    }

    @Override
    public void initView() {
        String machineName = getIntent().getStringExtra("machineName");
        mTvTitleOnlyBack.setText("添加巡检计划");
        date = mTvDate.getText().toString();
        time = mTvTime.getText().toString();
    }

    private boolean isEmpty() {
        return TextUtils.isEmpty(mEtRoutingContent.getText().toString());
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;

        }
        return onTouchEvent(ev);
    }

    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    @OnClick({R.id.iv_title_only_back, R.id.ll_date, R.id.ll_time, R.id.iv_add_linked_machines, R.id.btn_commit})
    public void onClick(View view) {
        Calendar calendar = Calendar.getInstance();
        switch (view.getId()) {
            case R.id.iv_title_only_back:
                finish();
                break;
            case R.id.ll_date:
                if (null==mYmdPicker) {
                    mYmdPicker = PickViewUtils.getInstance().getYMDPicker(this, Calendar.getInstance(), calendar, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            String data = (String) DateUtils.getData("2017-02-12", date);
                            mTvDate.setText(data);
                        }
                    });
                }
                mYmdPicker.show();
//                if (null == datePickerDialog) {
//                    datePickerDialog = new DatePickerDialog(this, R.style.AppTheme_AppDate, new DatePickerDialog.OnDateSetListener() {
//                        @Override
//                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                            date = year + "-" + (month + 1) + "-" + dayOfMonth;
//                            tvCircleType.setText(date);
//                        }
//                    }, 2017, 05, 01);
//                }
//                datePickerDialog.show();
                break;
            case R.id.ll_time:
                if (null==mHmPicker) {
                    mHmPicker = PickViewUtils.getInstance().getHMPicker(this, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            String time = (String) DateUtils.getData("mm:ss", date);
                            mTvTime.setText(time);
                        }
                    });
                }
                mHmPicker.show();
//                TimePickerDialog timePickerDialog = new TimePickerDialog(this, R.style.AppTheme_AppDate, new TimePickerDialog.OnTimeSetListener() {
//                    @Override
//                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                        time = hourOfDay + ":" + minute;
//                        tvCircleTime.setText(time);
//                    }
//                }, Integer.parseInt(time.split(":")[0]), Integer.parseInt(time.split(":")[1]), true);
//                timePickerDialog.show();
                break;
            case R.id.iv_add_linked_machines:
                break;
            case R.id.btn_commit:
                if (isEmpty()) ToastUtil.show("巡检内容不能为空!");
                else finish();
                break;
        }
    }
}
