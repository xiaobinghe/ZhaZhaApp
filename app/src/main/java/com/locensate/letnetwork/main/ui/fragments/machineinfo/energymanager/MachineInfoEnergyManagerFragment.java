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
import com.locensate.letnetwork.utils.Constance;
import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.utils.PickViewUtils;
import com.locensate.letnetwork.view.MyViewPager;
import com.locensate.letnetwork.view.timepick.MyTimePickerView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 设备管理
 *
 * @author xiaobinghe
 */

public class MachineInfoEnergyManagerFragment extends BaseFragment<MachineInfoEnergyManagerPresenter, MachineInfoEnergyManagerModel> implements MachineInfoEnergyManagerContract.View, OnChartValueSelectedListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.up_down)
    ImageView upDown;
    @BindView(R.id.time_type)
    FrameLayout timeType;
    @BindView(R.id.tv_time_value)
    TextView tvTimeValue;
    @BindView(R.id.time_value)
    LinearLayout timeValue;
    @BindView(R.id.tv_lose_elect)
    TextView tvLoseElect;
    @BindView(R.id.tv_running_time)
    TextView tvRunningTime;
    @BindView(R.id.tl_machine_energy_analysis)
    TabLayout tlMachineEnergyAnalysis;
    @BindView(R.id.vp_machine_energy_analysis)
    MyViewPager vpMachineEnergyAnalysis;
    @BindView(R.id.time_type_content)
    TextView mTimeTypeContent;
    private String timeShow;
    private OptionsPickerView mTimeTypePicker;
    private MyTimePickerView mHourPicker;
    private MyTimePickerView mMouthPicker;
    private MyTimePickerView mWeekPicker;
    private MyTimePickerView mDayPicker;
    private boolean initComplete = false;

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
        mTimeTypeContent.setText("月");
        tvTimeValue.setText("2017-07");
        initComplete = true;
    }

    @Override
    public void initData(Fragment[] fragments) {
        vpMachineEnergyAnalysis.setAdapter(new MachineEnergyPageAdapter(this.getChildFragmentManager(), fragments));
        vpMachineEnergyAnalysis.addOnPageChangeListener(this);
        tlMachineEnergyAnalysis.post(new Runnable() {
            @Override
            public void run() {
                tlMachineEnergyAnalysis.setupWithViewPager(vpMachineEnergyAnalysis);
            }
        });
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
        Calendar instance = Calendar.getInstance();
        instance.set(2010, 0, 1);
        switch (timeShow) {
            case "小时":
                if (null == mHourPicker) {
                    mHourPicker = PickViewUtils.getInstance().getYMDHPicker(getActivity(), instance, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            tvTimeValue.setText(DateUtils.getTime(date, timeShow));
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
                            tvTimeValue.setText(DateUtils.getTime(date, timeShow));
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
                            tvTimeValue.setText(DateUtils.getTime(firstAndEnd[0], timeShow) + "/" + DateUtils.getTime(firstAndEnd[1], timeShow));
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
                            tvTimeValue.setText(DateUtils.getTime(date, timeShow));
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
        vpMachineEnergyAnalysis.setAdapter(null);
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
