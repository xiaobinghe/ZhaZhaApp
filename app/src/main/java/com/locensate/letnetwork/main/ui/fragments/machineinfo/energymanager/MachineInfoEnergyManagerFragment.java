package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.lib.WheelView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseFragment;
import com.locensate.letnetwork.bean.MotorEfficiencyBaseEntity;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyLoad.EnergyLoadFragment;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyefficiency.EnergyEfficiencyFragment;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyfgp.EnergyFengGuPingFragment;
import com.locensate.letnetwork.main.ui.machineinfo.MachineInfoActivity;
import com.locensate.letnetwork.utils.Constance;
import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.utils.PickViewUtils;
import com.locensate.letnetwork.view.MyViewPager;
import com.locensate.letnetwork.view.timepick.MyTimePickerView;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 设备管理
 *
 * @author xiaobinghe
 */

public class MachineInfoEnergyManagerFragment extends BaseFragment<MachineInfoEnergyManagerPresenter, MachineInfoEnergyManagerModel> implements MachineInfoEnergyManagerContract.View, OnChartValueSelectedListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.up_down)
    ImageView mUpDown;
    @BindView(R.id.time_type_content)
    TextView mTimeTypeContent;
    @BindView(R.id.time_type)
    FrameLayout mTimeType;
    @BindView(R.id.tv_time_value)
    TextView mTvTimeValue;
    @BindView(R.id.time_value)
    LinearLayout mTimeValue;
    @BindView(R.id.tv_running_time)
    TextView mTvRunningTime;
    @BindView(R.id.tv_empty_load_electric_used)
    TextView mTvEmptyLoadElectricUsed;
    @BindView(R.id.textView8)
    TextView mTextView8;
    @BindView(R.id.tv_use_power)
    TextView mTvUsePower;
    @BindView(R.id.tv_estimation_electric_count)
    TextView mTvEstimationElectricCount;
    @BindView(R.id.tv_electric_fee)
    TextView mTvElectricFee;
    @BindView(R.id.tv_estimation_electric_rate)
    TextView mTvEstimationElectricRate;
    @BindView(R.id.tl_machine_energy_analysis)
    TabLayout mTlMachineEnergyAnalysis;
    @BindView(R.id.vp_machine_energy_analysis)
    MyViewPager mVpMachineEnergyAnalysis;
    private String timeShow;
    private OptionsPickerView mTimeTypePicker;
    private MyTimePickerView mHourPicker;
    private MyTimePickerView mMouthPicker;
    private MyTimePickerView mWeekPicker;
    private MyTimePickerView mDayPicker;
    private boolean initComplete = false;
    private Fragment[] fragments = {new EnergyEfficiencyFragment(), new EnergyLoadFragment(), new EnergyFengGuPingFragment()};

    @Override
    public int getInflaterView() {
        return R.layout.fragment_energy_analysis;
    }

    @Override
    protected void onVisible() {
        super.onVisible();
    }

    @Override
    protected void lazyLoad() {
        if (initComplete) {

        }
    }

    @Override
    public void initView() {
        timeShow = "周";
        mTimeTypeContent.setText(timeShow);
        initComplete = true;
    }

    @Override
    public void initData() {
        mVpMachineEnergyAnalysis.setOffscreenPageLimit(3);
        mVpMachineEnergyAnalysis.setAdapter(new MachineEnergyPageAdapter(this.getChildFragmentManager(), fragments));
        mVpMachineEnergyAnalysis.addOnPageChangeListener(this);
        mTlMachineEnergyAnalysis.post(new Runnable() {
            @Override
            public void run() {
                mTlMachineEnergyAnalysis.setupWithViewPager(mVpMachineEnergyAnalysis);
            }
        });
    }


    @Override
    public void initTimeTypeAndValue(String type, Date[] startAndEnd) {
        mTimeTypeContent.setText(type);
        mTvTimeValue.setText(DateUtils.getTime(startAndEnd[0], type) + "/" + DateUtils.getTime(startAndEnd[1], type));

    }

    @Override
    public void fillBaseData(MotorEfficiencyBaseEntity.DataBean data) {

        if (data != null) {
            DecimalFormat df = new DecimalFormat("0.00");
            double running_time = data.getRunning_time();
            double electrical_fee = data.getElectrical_fee();
            double estimate_save_power = data.getEstimate_save_power();
            double no_loading_power = data.getNo_loading_power();
            double power_use_ratio = data.getPower_use_ratio();
            double power_consumption = data.getPower_consumption();
            mTvRunningTime.setText(df.format((float)running_time / 3600) + "h");
            mTvUsePower.setText(df.format(power_consumption) + "kWh");
            mTvElectricFee.setText(df.format(electrical_fee) + "元");
            mTvEmptyLoadElectricUsed.setText(df.format(no_loading_power) + "kWh");
            mTvEstimationElectricCount.setText(df.format(estimate_save_power) + "kWh");
            mTvEstimationElectricRate.setText(df.format(power_use_ratio * 100) + "%");
        } else {
            mTvRunningTime.setText("——");
            mTvUsePower.setText("——");
            mTvElectricFee.setText("——");
            mTvEmptyLoadElectricUsed.setText("——");
            mTvEstimationElectricCount.setText("——");
            mTvEstimationElectricRate.setText("——");
        }
    }

    @Override
    public Fragment[] getChildFragments() {
        return fragments;
    }

    @Override
    public String getTimeType() {
        return timeShow;
    }


    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    @OnClick({R.id.time_type, R.id.time_value})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.time_type:
                if (null == mTimeTypePicker) {
                    final List<String> timeTypes = Constance.array2List(Constance.timeType);
                    mTimeTypePicker = new OptionsPickerView.Builder(getActivity(), new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            mTimeTypeContent.setText(timeTypes.get(options1));
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
                timeShow = mTimeTypeContent.getText().toString();
                showPicker();
                break;
            default:
                break;
        }
    }


    private void showPicker() {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        instance.set(2010, 0, 1);
        switch (timeShow) {
            case "小时":
                if (null == mHourPicker) {
                    mHourPicker = PickViewUtils.getInstance().getYMDHPicker(getActivity(), instance, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            mTvTimeValue.setText(DateUtils.getTime(date, timeShow));
                            mPresenter.setTimeRange(date.getTime(), date.getTime() + 3599000L);
                        }
                    });
                }
                mHourPicker.show();
                break;
            case "月":
                if (null == mMouthPicker) {
                    mMouthPicker = PickViewUtils.getInstance().getYMPicker(getActivity(), instance, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            mTvTimeValue.setText(DateUtils.getTime(date, timeShow));

                            //获取当前月第一天
                            Calendar c = Calendar.getInstance();
                            c.setTime(date);
                            c.add(Calendar.MONTH, 0);
                            c.set(Calendar.DAY_OF_MONTH, 1);
                            long startMills = c.getTimeInMillis();
                            //获取当前月最后一天
                            Calendar ca = Calendar.getInstance();
                            ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
                            long endMills = ca.getTimeInMillis();
                            mPresenter.setTimeRange(startMills, endMills);
                        }
                    });
                }
                mMouthPicker.show();
                break;
            case "周":
                if (null == mWeekPicker) {
                    mWeekPicker = PickViewUtils.getInstance().getWeekPicker(getActivity(), instance, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            Date[] firstAndEnd = DateUtils.getFirstAndEndDayDateOfWeek(date);
                            mTvTimeValue.setText(DateUtils.getTime(firstAndEnd[0], timeShow) + "/" + DateUtils.getTime(firstAndEnd[1], timeShow));
                            mPresenter.setTimeRange(firstAndEnd[0].getTime(), firstAndEnd[1].getTime() + 86400000L);
                        }
                    });
                }
                mWeekPicker.show();
                break;
            case "天":
                if (null == mDayPicker) {
                    mDayPicker = PickViewUtils.getInstance().getWeekPicker(getActivity(), instance, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            mTvTimeValue.setText(DateUtils.getTime(date, timeShow));
                            mPresenter.setTimeRange(date.getTime(), date.getTime() + 86399000L);
                        }
                    });
                }
                mDayPicker.show();
                break;
            default:
                break;
        }
    }


    @Override
    public long getMotorId() {
        return ((MachineInfoActivity) getActivity()).getMachineInfo().getLong("motorId");
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onDestroyView() {
        mVpMachineEnergyAnalysis.setAdapter(null);
        super.onDestroyView();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
