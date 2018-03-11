package com.locensate.letnetwork.main.ui.fragments.machineinfo.healthmanager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.lib.WheelView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseFragment;
import com.locensate.letnetwork.bean.MachineInfoHealthyManagerEntity;
import com.locensate.letnetwork.main.ui.HealthDetailActivity;
import com.locensate.letnetwork.main.ui.machineinfo.MachineInfoActivity;
import com.locensate.letnetwork.utils.Constance;
import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.PickViewUtils;
import com.locensate.letnetwork.view.timepick.MyTimePickerView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 设备-健康管理
 *
 * @author xiaobinghe
 */

public class MachineInfoHealthyManagerFragment extends BaseFragment<MachineInfoHealthyManagerPresenter, MachineInfoHealthyManagerModel> implements MachineInfoHealthyManagerContract.View, OnChartGestureListener {


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
    @BindView(R.id.pie_machine_temp)
    PieChart mPieMachineTemp;
    @BindView(R.id.tv_max_temp)
    TextView mTvMaxTemp;
    @BindView(R.id.tv_machine_health_max_temp)
    TextView mTvMachineHealthMaxTemp;
    @BindView(R.id.tv_machine_health_max_temp_date)
    TextView mTvMachineHealthMaxTempDate;
    @BindView(R.id.tv_machine_health_max_temp_time)
    TextView mTvMachineHealthMaxTempTime;
    @BindView(R.id.ll_max_temp)
    LinearLayout mLlMaxTemp;
    @BindView(R.id.pie_machine_health_shark)
    PieChart mPieMachineHealthShark;
    @BindView(R.id.tv_shark)
    TextView mTvShark;
    @BindView(R.id.tv_machine_health_max_shark_value)
    TextView mTvMachineHealthMaxSharkValue;
    @BindView(R.id.tv_machine_health_max_shark_date)
    TextView mTvMachineHealthMaxSharkDate;
    @BindView(R.id.tv_machine_health_max_shark_time)
    TextView mTvMachineHealthMaxSharkTime;
    @BindView(R.id.ll_shark)
    LinearLayout mLlShark;
    @BindView(R.id.pie_machine_health_elect_hotter_q5)
    PieChart mPieMachineHealthElectHotterQ5;
    @BindView(R.id.tv_electric_hot_q5)
    TextView mTvElectricHotQ5;
    @BindView(R.id.tv_machine_health_max_electric_hotter_value_q5)
    TextView mTvMachineHealthMaxElectricHotterValueQ5;
    @BindView(R.id.tv_machine_health_max_electric_hotter_date_q5)
    TextView mTvMachineHealthMaxElectricHotterDateQ5;
    @BindView(R.id.tv_machine_health_max_electric_hotter_time_q5)
    TextView mTvMachineHealthMaxElectricHotterTimeQ5;
    @BindView(R.id.ll_electric_over_hot)
    LinearLayout mLlElectricOverHot;
    @BindView(R.id.pie_machine_health_elect_hotter_q30)
    PieChart mPieMachineHealthElectHotterQ30;
    @BindView(R.id.tv_electric_hot_q30)
    TextView mTvElectricHotQ30;
    @BindView(R.id.tv_machine_health_max_electric_hotter_value_q30)
    TextView mTvMachineHealthMaxElectricHotterValueQ30;
    @BindView(R.id.tv_machine_health_max_electric_hotter_date_q30)
    TextView mTvMachineHealthMaxElectricHotterDateQ30;
    @BindView(R.id.tv_machine_health_max_electric_hotter_time_q30)
    TextView mTvMachineHealthMaxElectricHotterTimeQ30;
    @BindView(R.id.ll_electric_over_hot_q30)
    LinearLayout mLlElectricOverHotQ30;
    @BindView(R.id.pie_machine_health_start_count)
    PieChart mPieMachineHealthStartCount;
    @BindView(R.id.tv_max_start_count)
    TextView mTvMaxStartCount;
    @BindView(R.id.tv_machine_health_max_start_value)
    TextView mTvMachineHealthMaxStartValue;
    @BindView(R.id.tv_machine_health_max_start_date)
    TextView mTvMachineHealthMaxStartDate;
    @BindView(R.id.tv_machine_health_max_start_time)
    TextView mTvMachineHealthMaxStartTime;
    @BindView(R.id.ll_max_start_count)
    LinearLayout mLlMaxStartCount;
    @BindView(R.id.pie_machine_health_current_over)
    PieChart mPieMachineHealthCurrentOver;
    @BindView(R.id.tv_over_current)
    TextView mTvOverCurrent;
    @BindView(R.id.tv_machine_health_max_current_value)
    TextView mTvMachineHealthMaxCurrentValue;
    @BindView(R.id.tv_machine_health_max_current_date)
    TextView mTvMachineHealthMaxCurrentDate;
    @BindView(R.id.tv_machine_health_max_current_time)
    TextView mTvMachineHealthMaxCurrentTime;
    @BindView(R.id.ll_over_current)
    LinearLayout mLlOverCurrent;
    @BindView(R.id.tv_title_score)
    TextView mTvTitleScore;
    @BindView(R.id.iv_healthy_status)
    ImageView mIvHealthyStatus;
    private String timeShow;
    private OptionsPickerView mTimeTypePicker;
    private MyTimePickerView mHourPicker;
    private MyTimePickerView mMouthPicker;
    private MyTimePickerView mWeekPicker;
    private MyTimePickerView mDayPicker;
    private boolean initComplete = false;


    @Override
    public int getInflaterView() {
        return R.layout.fragment_machine_health;
    }

    @Override
    public void initView() {
        mTvTitleScore.setText("——");
        initComplete = true;
    }

    @Override
    protected void lazyLoad() {
        if (initComplete) {
//            mPresenter.initData();
        }
    }


    @Override
    public void fillData(MachineInfoHealthyManagerEntity.DataBean data, ArrayList<PieEntry> pieTempData, ArrayList<PieEntry> pieSharkData, ArrayList<PieEntry> pieElectHotterQ5, ArrayList<PieEntry> pieElectHotterQ30, ArrayList<PieEntry> pieStartCount, ArrayList<PieEntry> pieCurrentOver) {
        boolean tempEmpty = false;
        boolean sharkEmpty = false;
        boolean q5Empty = false;
        boolean q30Empty = false;
        boolean startEmpty = false;
        boolean ioEmpty = false;

        fillPie(pieTempData, mPieMachineTemp);
        fillPie(pieSharkData, mPieMachineHealthShark);
        fillPie(pieElectHotterQ5, mPieMachineHealthElectHotterQ5);
        fillPie(pieElectHotterQ30, mPieMachineHealthElectHotterQ30);
        fillPie(pieStartCount, mPieMachineHealthStartCount);
        fillPie(pieCurrentOver, mPieMachineHealthCurrentOver);
        if (data != null) {
            DecimalFormat df = new DecimalFormat("0.00");
            double sco = data.getSco();
            showColorScore(sco);
            mTvTitleScore.setText(df.format(sco));

            if (data.getTem_max_time() == 0) {
                tempEmpty = true;
            }
            Date tempDate = new Date(data.getTem_max_time());
            mTvMachineHealthMaxTemp.setText("最大值：" + (tempEmpty ? "——" : (data.getTem_max() + "℃")));
            mTvMachineHealthMaxTempDate.setText(tempEmpty ? "——" : DateUtils.getTime(tempDate, "天"));
            mTvMachineHealthMaxTempTime.setText(tempEmpty ? "——" : DateUtils.getTime(tempDate, "时分秒"));
            if (data.getZd_max_time() == 0) {
                sharkEmpty = true;
            }
            Date sharkDate = new Date(data.getZd_max_time());
            mTvMachineHealthMaxSharkValue.setText("最大值：" + (sharkEmpty ? "——" : (df.format(data.getZd_max()) + "mm/s")));
            mTvMachineHealthMaxSharkDate.setText(sharkEmpty ? "——" : DateUtils.getTime(sharkDate, "天"));
            mTvMachineHealthMaxSharkTime.setText(sharkEmpty ? "——" : DateUtils.getTime(sharkDate, "时分秒"));
            if (data.getQ5_max_time() == 0) {
                q5Empty = true;
            }
            Date q5Date = new Date(data.getQ5_max_time());
            mTvMachineHealthMaxElectricHotterValueQ5.setText("最大值：" + (q5Empty ? "——" : (df.format(data.getQ5_max() * 100) + "%")));
            mTvMachineHealthMaxElectricHotterDateQ5.setText(q5Empty ? "——" : DateUtils.getTime(q5Date, "天"));
            mTvMachineHealthMaxElectricHotterTimeQ5.setText(q5Empty ? "——" : DateUtils.getTime(q5Date, "时分秒"));
            if (data.getQ30_max_time() == 0) {
                q30Empty = true;
            }
            Date q30Date = new Date(data.getQ30_max_time());
            mTvMachineHealthMaxElectricHotterValueQ30.setText("最大值：" + (q30Empty ? "——" : (df.format(data.getQ30_max() * 100) + "%")));
            mTvMachineHealthMaxElectricHotterDateQ30.setText(q30Empty ? "——" : DateUtils.getTime(q30Date, "天"));
            mTvMachineHealthMaxElectricHotterTimeQ30.setText(q30Empty ? "——" : DateUtils.getTime(q30Date, "时分秒"));
            if (data.getMax_start_time() == 0) {
                startEmpty = true;
            }
            Date startCountDate = new Date(data.getMax_start_time());
            mTvMachineHealthMaxStartValue.setText("最大值：" + (startEmpty ? "——" : (data.getMax_start() + "次")));
            mTvMachineHealthMaxStartDate.setText(startEmpty ? "——" : DateUtils.getTime(startCountDate, "天"));
            mTvMachineHealthMaxStartTime.setText(startEmpty ? "——" : DateUtils.getTime(startCountDate, "时分秒"));
            if (data.getIo_max_time() == 0) {
                ioEmpty = true;
            }
            Date ioDate = new Date(data.getIo_max_time());
            mTvMachineHealthMaxCurrentValue.setText("最大值：" + (ioEmpty ? "——" : (df.format(data.getIo_max()) + "A")));
            mTvMachineHealthMaxCurrentDate.setText(ioEmpty ? "——" : DateUtils.getTime(ioDate, "天"));
            mTvMachineHealthMaxCurrentTime.setText(ioEmpty ? "——" : DateUtils.getTime(ioDate, "时分秒"));
        }
    }

    private void showColorScore(double sco) {
        if (sco == 100) {
            mIvHealthyStatus.setImageResource(R.drawable.healthy_blue);
        } else if (80 < sco && sco < 100) {
            mIvHealthyStatus.setImageResource(R.drawable.healthy_yellow);
        } else if ((50 < sco && sco < 80) || sco == 80) {
            mIvHealthyStatus.setImageResource(R.drawable.healthy_orange);
        } else {
            mIvHealthyStatus.setImageResource(R.drawable.healthy_red);
        }
    }

    @Override
    public void initTimeTypeAndValue(String timeType, Date[] startAndEnd) {
        mTimeTypeContent.setText(timeType);
        mTvTimeValue.setText(DateUtils.getTime(startAndEnd[0], timeType) + "/" + DateUtils.getTime(startAndEnd[1], timeType));
    }

    private void fillPie(ArrayList<PieEntry> pie1Data, PieChart pieChart) {
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setDragDecelerationFrictionCoef(0.98f);
        pieChart.setDragDecelerationEnabled(true);
        pieChart.setNoDataText("暂无数据");
        pieChart.setCenterTextTypeface(Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Light.ttf"));
//        pie1.setCenterText(generateCenterSpannableText());
        pieChart.setDrawSliceText(false);
        pieChart.setRotationAngle(270f);
        pieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);


        pieChart.setExtraOffsets(0.f, 0.f, 0.f, 0.f);
        pieChart.setDrawEntryLabels(false);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);

        pieChart.setTransparentCircleColor(Color.WHITE);
        pieChart.setTransparentCircleAlpha(110);
        pieChart.setHoleRadius(90f);
        pieChart.setTransparentCircleRadius(94f);

        pieChart.setDrawCenterText(true);
        pieChart.setCenterTextSize(16f);
        pieChart.setCenterTextColor(getResources().getColor(R.color.font_blue_deep));
        pieChart.setCenterTextTypeface(Typeface.DEFAULT_BOLD);
        DecimalFormat format = new DecimalFormat("##0");
        pieChart.setCenterText(format.format(pie1Data.get(0).getValue()));


//        pie1.setRotationAngle(0);
        // enable rotation of the chart by touch
        pieChart.setRotationEnabled(true);
        pieChart.setHighlightPerTapEnabled(false);

        // pie1.setUnit(" €");
        // pie1.setDrawUnitsInChart(true);

        // add a selection listener

        setPie1Data(pie1Data, pieChart);

//         pie1.spin(2000, 0, 360);

        Legend l = pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(false);
    }

    private void setPie1Data(ArrayList<PieEntry> entries, PieChart pieChart) {
        PieDataSet dataSet = new PieDataSet(entries, "Election Results");

        dataSet.setSliceSpace(0f);
        dataSet.setSelectionShift(5f);
        // add a lot of colors
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(getResources().getColor(R.color.pie_blue));
        colors.add(getResources().getColor(R.color.pie_yellow));
        colors.add(getResources().getColor(R.color.pie_orange));
        colors.add(getResources().getColor(R.color.pie_red));
        colors.add(getResources().getColor(R.color.pie_gray));
        dataSet.setDrawValues(false);
        if (entries.get(0).getValue() == 100) {
            dataSet.setColors(getBlueColors());
        } else if (entries.get(0).getValue() > 80) {
            dataSet.setColors(getOrangeColors());
        } else if (entries.get(0).getValue() >50) {
            dataSet.setColors(getRedColors());
        } else {
            dataSet.setColors(getGrayColor());
        }

        dataSet.setSelectionShift(0f);

        dataSet.setValueLinePart1OffsetPercentage(80.f);
        dataSet.setValueLinePart1Length(0.2f);
        dataSet.setValueLinePart2Length(0.4f);
        //dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        pieChart.setData(data);
        pieChart.highlightValues(null);
        pieChart.invalidate();
    }

    private int getGrayColor() {
        return getResources().getColor(R.color.gray_font);
    }

    public ArrayList<Integer> getBlueColors() {
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(getResources().getColor(R.color.pie_blue_sky));
        colors.add(getResources().getColor(R.color.pie_blue_sky_gray));
        colors.add(getResources().getColor(R.color.pie_blue_sky_gray));
        return colors;
    }

    public ArrayList<Integer> getOrangeColors() {
        ArrayList<Integer> orangeColors = new ArrayList<>();
        orangeColors.add(getResources().getColor(R.color.pie_orange_light));
        orangeColors.add(getResources().getColor(R.color.pie_orange_light_gray));
        orangeColors.add(getResources().getColor(R.color.pie_orange_light_gray));
        return orangeColors;
    }

    public ArrayList<Integer> getRedColors() {
        ArrayList<Integer> redColors = new ArrayList<>();
        redColors.add(getResources().getColor(R.color.pie_red_light));
        redColors.add(getResources().getColor(R.color.pie_red_light_gray));
        redColors.add(getResources().getColor(R.color.pie_red_light_gray));
        return redColors;
    }

    @OnClick({R.id.ll_electric_over_hot_q30, R.id.ll_max_temp, R.id.ll_shark, R.id.ll_max_start_count, R.id.ll_electric_over_hot, R.id.ll_over_current, R.id.time_type, R.id.time_value})
    public void onViewClicked(View view) {
        String detailType = "maxStartCount";
        switch (view.getId()) {
            case R.id.ll_max_temp:
                detailType = "over_temp";
                showDetail(detailType);
                break;
            case R.id.ll_shark:
                detailType = "shark";
                showDetail(detailType);
                break;
            case R.id.ll_electric_over_hot:
                detailType = "electric_hot";
                showDetail(detailType);
                break;
            case R.id.ll_electric_over_hot_q30:
                detailType = "electric_hot_q30";
                showDetail(detailType);
                break;
            case R.id.ll_max_start_count:
                detailType = "maxStartCount";
                showDetail(detailType);
                break;
            case R.id.ll_over_current:
                detailType = "over_current";
                showDetail(detailType);
                break;
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

    private void showDetail(String detailType) {
        Intent intent = new Intent(getActivity(), HealthDetailActivity.class);
        Bundle extras = new Bundle();
        extras.putString("type", detailType);
        extras.putLong("motorId", getMachineInfo().getLong("motorId"));
        extras.putLong("startTime", mPresenter.getStartMills());
        extras.putLong("endTime", mPresenter.getEndMills());
        intent.putExtras(extras);
        startActivity(intent);
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
                            //获取当前月最后一天
                            Calendar ca = Calendar.getInstance();
                            ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
                            mPresenter.setTimeRange(c.getTimeInMillis(), ca.getTimeInMillis());
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
                            mPresenter.setTimeRange(firstAndEnd[0].getTime(), firstAndEnd[1].getTime());
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
    public Bundle getMachineInfo() {
        return ((MachineInfoActivity) getActivity()).getMachineInfo();
    }

    @Override
    public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
        LogUtil.e("onChartGestureStart", "-------motionEvent-----" + me.getAction() + "---------chartGesture---" + lastPerformedGesture.toString());
    }

    @Override
    public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
        LogUtil.e("onChartGestureEnd", "-------motionEvent-----" + me.getAction() + "---------chartGesture---" + lastPerformedGesture.toString());

    }

    @Override
    public void onChartLongPressed(MotionEvent me) {
        LogUtil.e("onChartLongPressed", "-------motionEvent-----" + me.getAction());

    }

    @Override
    public void onChartDoubleTapped(MotionEvent me) {
        LogUtil.e("onChartDoubleTapped", "-------motionEvent-----" + me.getAction());

    }

    @Override
    public void onChartSingleTapped(MotionEvent me) {
        LogUtil.e("onChartSingleTapped", "-------motionEvent-----" + me.getAction());

    }

    @Override
    public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {
        LogUtil.e("onChartSingleTapped", "-------motionEvent-----" + me1.getAction() + "----------motionEvent---" + me2.getAction() + "---x---" + velocityX + "---y---" + velocityY);

    }

    @Override
    public void onChartScale(MotionEvent me, float scaleX, float scaleY) {
        LogUtil.e("onChartScale", "-------motionEvent-----" + me.getAction() + "---x---" + scaleX + "---y---" + scaleY);


    }

    @Override
    public void onChartTranslate(MotionEvent me, float dX, float dY) {
        LogUtil.e("onChartTranslate", "-------motionEvent-----" + me.getAction() + "---x---" + dX + "---y---" + dY);

    }
}
