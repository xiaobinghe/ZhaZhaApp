package com.locensate.letnetwork.main.ui.fragments.overview;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.lib.WheelView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.Constant;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseFragment;
import com.locensate.letnetwork.bean.OverviewMotor;
import com.locensate.letnetwork.main.ui.message.MessageActivity;
import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.utils.PickViewUtils;
import com.locensate.letnetwork.utils.SpUtil;
import com.locensate.letnetwork.view.ExpandablePopWindow;
import com.locensate.letnetwork.view.timepick.MyTimePickerView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author xiaobinghe
 */


public class OverviewFragment extends BaseFragment<OverviewPresenter, OverviewModel> implements OverviewContract.View {
    @BindView(R.id.fl_over_view_content)
    FrameLayout flOverViewContent;
    @BindView(R.id.tv_root_file)
    TextView tvRootFile;
    @BindView(R.id.vp_overview_contain)
    ViewPager vpOverviewContain;
    @BindView(R.id.tv_alert_overview)
    TextView tvAlertOverview;
    @BindView(R.id.iv_root_file)
    ImageView ivRootFile;
    @BindView(R.id.iv_title_search)
    ImageView ivTitleSearch;
    @BindView(R.id.up_down)
    ImageView upDown;
    @BindView(R.id.iv_point1)
    ImageView ivPoint1;
    @BindView(R.id.iv_point2)
    ImageView ivPoint2;
    @BindView(R.id.iv_point3)
    ImageView ivPoint3;
    @BindView(R.id.time_type)
    FrameLayout timeType;
    @BindView(R.id.tv_time_value)
    TextView tvTimeValue;
    @BindView(R.id.time_value)
    LinearLayout timeValue;
    @BindView(R.id.tv_energy_overview)
    TextView tvEnergyOverview;
    @BindView(R.id.tv_order_overview)
    TextView tvOrderOverview;
    @BindView(R.id.tv_remind_overview)
    TextView tvRemindOverview;
    @BindView(R.id.time_type_content)
    TextView timeTypeContent;
    @BindView(R.id.fl_alert)
    FrameLayout mFlAlert;
    @BindView(R.id.fl_energy)
    FrameLayout mFlEnergy;
    @BindView(R.id.fl_order)
    FrameLayout mFlOrder;
    @BindView(R.id.fl_remind)
    FrameLayout mFlRemind;
    @BindView(R.id.tv_motor_count)
    TextView mTvMotorCount;
    @BindView(R.id.tv_motor_power_total)
    TextView mTvMotorPowerTotal;
    @BindView(R.id.tv_machine_measure)
    TextView mTvMachineMeasure;
    @BindView(R.id.tv_machine_power_total)
    TextView mTvMachinePowerTotal;
    private ImageView[] points = new ImageView[3];
    private int currentPage = 0;
    private ArrayList<String> timeTypes = new ArrayList<>();
    private Calendar startDate = Calendar.getInstance();
    private ExpandablePopWindow expandablePopwindow;
    public static String mGroupName = SpUtil.getString(App.getApplication(), Constant.ENTERPRISE_NAME, "某钢厂");
    private OptionsPickerView mTimeTypePicker;
    private MyTimePickerView mYmPicker;
    private MyTimePickerView mWeekPicker;
    private MyTimePickerView mYmdPicker;
    private MyTimePickerView mYmdhPicker;

    @Override
    public int getInflaterView() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initView() {
        points[0] = ivPoint1;
        points[1] = ivPoint2;
        points[2] = ivPoint3;
        startDate.set(2010, 0, 1);
        initTimeType();
    }

    private void initTimeType() {
        timeTypes.add("小时");
        timeTypes.add("天");
        timeTypes.add("周");
        timeTypes.add("月");
    }


    @Override
    protected void lazyLoad() {


    }

    @Override
    public void initData(OverviewMotor overviewMotor) {
        mTvMachineMeasure.setText("计量设备/" + overviewMotor.getData().getMeasureCount() + "台");
        mTvMachinePowerTotal.setText("总装机功率/" + overviewMotor.getData().getMeasurePowerCount() + "kW");
        mTvMotorCount.setText("电机/" + overviewMotor.getData().getMotorCount() + "台");
        mTvMotorPowerTotal.setText("总装机功率/" + overviewMotor.getData().getPowerCount() + "kW");
        tvRootFile.setText(mGroupName);
    }

    @Override
    public void fillContain(Fragment[] containFragment) {
        vpOverviewContain.setOffscreenPageLimit(3);
        vpOverviewContain.setAdapter(new OverviewContainPageAdapter(getChildFragmentManager(), containFragment));
        vpOverviewContain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
                for (int i = 0; i < points.length; i++) {
                    if (currentPage == i) {
                        points[i].setImageResource(R.drawable.page_point);
                    } else {
                        points[i].setImageResource(R.drawable.page_point_gray);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public String getRangeItem() {
        return tvRootFile.getText().toString();
    }

    @Override
    public void showPop(List<MultiItemEntity> groupTree) {
        if (null == expandablePopwindow) {
            expandablePopwindow = new ExpandablePopWindow(getActivity(), groupTree);
            expandablePopwindow.setAnimationStyle(R.style.MyPopAnim);
        }
        fitPopupWindowOverStatusBar(true);
        expandablePopwindow.showPopupWindow(ivRootFile);
        expandablePopwindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                String temp = expandablePopwindow.getPath();
                if (temp != null) {
                    mGroupName = temp;
                }
                tvRootFile.setText(mGroupName);
            }
        });
    }

    @OnClick({R.id.iv_root_file, R.id.time_type, R.id.time_value, R.id.fl_alert, R.id.fl_energy, R.id.fl_order, R.id.fl_remind})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_root_file:
                mPresenter.showPop();
                break;
            case R.id.time_type:
                if (null == mTimeTypePicker) {
                    mTimeTypePicker = new OptionsPickerView.Builder(getActivity(), new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            timeTypeContent.setText(timeTypes.get(options1));
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
                            .setSubmitColor(getActivity().getResources().getColor(R.color.font_deep_blue))
                            .setCancelColor(getActivity().getResources().getColor(R.color.font_deep_blue))
                            .setDividerType(WheelView.DividerType.FILL)
                            .setTitleBgColor(getActivity().getResources().getColor(R.color.bg))
                            .setLineSpacingMultiplier(2.0f)
                            .setSubCalSize(16)
                            .setContentTextSize(16)
                            .setDividerColor(getActivity().getResources().getColor(R.color.font_deep_blue))
                            .setTextColorCenter(getActivity().getResources().getColor(R.color.font_deep_blue))
                            .isDialog(true).build();
                    mTimeTypePicker.setPicker(timeTypes);
                }
                mTimeTypePicker.show();
                break;
            case R.id.time_value:
                showPickers(timeTypeContent.getText().toString());
                break;
            case R.id.fl_alert:
                Intent alertData = new Intent(App.getApplication(), MessageActivity.class);
                alertData.putExtra("msgType", 0);
                startActivity(alertData);
                break;
            case R.id.fl_energy:
                Intent energyData = new Intent(App.getApplication(), MessageActivity.class);
                energyData.putExtra("msgType", 1);
                startActivity(energyData);
                break;
            case R.id.fl_order:
                Intent orderData = new Intent(App.getApplication(), MessageActivity.class);
                orderData.putExtra("msgType", 2);
                startActivity(orderData);
                break;
            case R.id.fl_remind:
                Intent remindData = new Intent(App.getApplication(), MessageActivity.class);
                remindData.putExtra("msgType", 3);
                startActivity(remindData);
                break;
            default:
                break;
        }
    }

    private void showPickers(final String text) {
        if (text.equals("月")) {
             /*月*/
            if (null == mYmPicker) {
                mYmPicker = PickViewUtils.getInstance().getYMPicker(getActivity(), startDate, new MyTimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tvTimeValue.setText(DateUtils.getTime(date, text));
                    }
                });
            }
            mYmPicker.show();

        } else if (text.equals("周")) {
            /*周*/
            if (null == mWeekPicker) {
                mWeekPicker = PickViewUtils.getInstance().getWeekPicker(getActivity(), startDate, new MyTimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        Date[] firstAndEnd = DateUtils.getFirstAndEndDayDateOfWeek(date);
                        tvTimeValue.setText(DateUtils.getTime(firstAndEnd[0], text) + "/" + DateUtils.getTime(firstAndEnd[1], text));
                    }
                });
            }
            mWeekPicker.show();

        } else if (text.equals("天")) {
            /*天*/
            if (null == mYmPicker) {
                mYmdPicker = PickViewUtils.getInstance().getYMDPicker(getActivity(), startDate, new MyTimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tvTimeValue.setText(DateUtils.getTime(date, text));
                    }
                });
            }
            mYmdPicker.show();

        } else if (text.equals("小时")) {
            /*小时*/
            if (null == mYmdhPicker) {
                mYmdhPicker = PickViewUtils.getInstance().getYMDHPicker(getActivity(), startDate, new MyTimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tvTimeValue.setText(DateUtils.getTime(date, text));
                    }
                });
            }
            mYmdhPicker.show();
        } else {
            throw new IllegalArgumentException("日期类型不匹配");
        }
    }

    public void fitPopupWindowOverStatusBar(boolean needFullScreen) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                Field mLayoutInScreen = PopupWindow.class.getDeclaredField("mLayoutInScreen");
                mLayoutInScreen.setAccessible(true);
                mLayoutInScreen.set(expandablePopwindow, needFullScreen);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
