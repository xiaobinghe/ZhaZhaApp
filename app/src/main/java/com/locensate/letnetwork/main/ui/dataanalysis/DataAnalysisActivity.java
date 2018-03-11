package com.locensate.letnetwork.main.ui.dataanalysis;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.monitorinfo.RunningStateEntity;
import com.locensate.letnetwork.utils.AggLinkedUtil;
import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.PickViewUtils;
import com.locensate.letnetwork.view.markView.MyMarkerView;
import com.locensate.letnetwork.view.timepick.MyTimePickerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 数据分析
 *
 * @author xiaobinghe
 */

public class DataAnalysisActivity extends BaseActivity<DataAnalysisPresenter, DataAnalysisModel> implements DataAnalysisContract.View, OnChartValueSelectedListener {

    @BindView(R.id.iv_title_only_back)
    ImageView ivTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView tvTitleOnlyBack;
    @BindView(R.id.time_type_content)
    TextView tvTimeType;
    @BindView(R.id.fl_time_type)
    FrameLayout flTimeType;
    @BindView(R.id.tv_time_value)
    TextView tvTimeValue;
    @BindView(R.id.ll_time_value)
    LinearLayout llTimeValue;
    @BindView(R.id.tv_label)
    TextView tvLabel;
    @BindView(R.id.lc_line_data_analysis)
    LineChart mChart;
    private LineDataSet dataSet;
    private RunningStateEntity parameter;
    private List<String> timeTypes = new ArrayList<>();
    private long deviceId = 9L;
    private String tagName;
    private Calendar mCurrentDate;
    private Calendar mStartCalendar;
    private MyTimePickerView mTimePickerView;
    private OptionsPickerView mTimeTypePicker;
    private long endTime;
    private long startTime;

    @Override
    public int getLayoutId() {
        return R.layout.activity_data_analysis;
    }


    @Override
    public void initView() {
        parameter = (RunningStateEntity) getIntent().getExtras().getSerializable("parameter");
        tagName = parameter.getKey();
        tvTitleOnlyBack.setText(tagName);
        tvLabel.setText(tagName);
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        mCurrentDate = Calendar.getInstance();
        mCurrentDate.setTime(new Date(System.currentTimeMillis() - 600000L));
        mStartCalendar = Calendar.getInstance();
        mStartCalendar.set(2017, 0, 1);
        initLineChart();
    }

    private void initLineChart() {
        // 设置描述是否可用
        mChart.getDescription().setEnabled(false);
        // 设置触摸手势可用
        mChart.setTouchEnabled(true);
        mChart.setNoDataText("暂无数据");
        //滑动摩擦系数
        mChart.setDragDecelerationFrictionCoef(0.9f);

       /*設置允许被拖动*/
        mChart.setDragEnabled(true);
        /*设置是否允许被缩放*/
        mChart.setScaleEnabled(true);
        /*设置网格背景*/
        mChart.setDrawGridBackground(false);
        /*设置视图绘制动画*/
        mChart.animateX(2000);
        /*如果设置为true，x,y轴用手指可以同时缩放，如果为假，他们可以独立缩放，默认为false*/
        mChart.setPinchZoom(true);
        mChart.setBackgroundColor(getResources().getColor(R.color.white));
        mChart.setContentDescription("无数据");
        /*图例*/
        Legend l = mChart.getLegend();
        /*图例是否被显示*/
        l.setEnabled(false);
        /*x轴对象*/
        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(10f);
        xAxis.setTextColor(getResources().getColor(R.color.font_content));
        xAxis.setDrawGridLines(true);
        xAxis.setDrawAxisLine(true);
        /*在缩放时设置轴的最小间隔。不允许轴向下方限制。这可以用于在缩放时避免标签复制。*/
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            private SimpleDateFormat mFormat = new SimpleDateFormat("MM/dd HH:mm");

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                long m = (long) (mModel.getStartTime() + value);
                return mFormat.format(new Date(m));
            }
        });


        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setTextColor(getResources().getColor(R.color.font_content));
        leftAxis.setDrawGridLines(true);
        leftAxis.setGranularityEnabled(true);
        leftAxis.setDrawAxisLine(true);

        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setTextColor(getResources().getColor(R.color.font_content));
        rightAxis.setDrawGridLines(false);
        rightAxis.setDrawZeroLine(false);
        rightAxis.setGranularityEnabled(false);

    }

    @Override
    public void fillChartData(List<Entry> data) {
        mChart.resetTracking();
        // create a dataset and give it a type
        dataSet = new LineDataSet(data, parameter.getKey());
        dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);

        // set the line to be drawn like this "- - - - - -"
        dataSet.setLineWidth(1.5f);
        dataSet.setDrawCircles(false);
        dataSet.setHighLightColor(getResources().getColor(R.color.line_yellow));
        dataSet.setDrawValues(false);
        dataSet.setColor(getResources().getColor(R.color.line_yellow));
        dataSet.setDrawCircleHole(false);
        dataSet.setMode(LineDataSet.Mode.LINEAR);

        LineData lineData = new LineData(dataSet);
        // set data
        mChart.setData(lineData);
        mChart.invalidate();
        mChart.animateX(2000);
        MyMarkerView mv = new MyMarkerView(this, R.layout.layout_my_marker_view, mModel.getStartTime());
        mv.setChartView(mChart);
        mChart.setMarker(mv);
    }

    @Override
    public void initData() {
        timeTypes.add("十分钟");
        timeTypes.add("一小时");
        timeTypes.add("一天");
        timeTypes.add("一周");
        timeTypes.add("一月");
        startTime = mCurrentDate.getTimeInMillis();
        endTime = startTime + 600000L;
        tvTimeValue.setText(DateUtils.getTime(new Date(startTime), ""));
        mPresenter.setUp(parameter.getId(), parameter.getName(), startTime, endTime, AggLinkedUtil.getAgg(tvTimeType.getText().toString()), AggLinkedUtil.getSampling(tvTimeType.getText().toString()), AggLinkedUtil.getInterpolation(tvTimeType.getText().toString()));
    }

    @Override
    public void onNothingSelected() {

    }

    @OnClick({R.id.iv_title_only_back, R.id.ll_time_value, R.id.fl_time_type})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_title_only_back:
                finish();
                break;
            case R.id.ll_time_value:
                if (mTimePickerView == null) {
                    mTimePickerView = PickViewUtils.getInstance().getYMDHMPicker(this, mStartCalendar, mCurrentDate, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            startTime = date.getTime();
                            tvTimeValue.setText(DateUtils.getTime(date, ""));
                            mPresenter.setUp(parameter.getId(), parameter.getName(), startTime, getEndTime(), AggLinkedUtil.getAgg(tvTimeType.getText().toString()), AggLinkedUtil.getSampling(tvTimeType.getText().toString()), AggLinkedUtil.getInterpolation(tvTimeType.getText().toString()));
                        }
                    });
                }
                mTimePickerView.show();
                break;
            case R.id.fl_time_type:
                if (mTimeTypePicker == null) {
                    mTimeTypePicker = PickViewUtils.getInstance().getTimeType(this, timeTypes, new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            LogUtil.e("pickview ", "--------option1" + options1 + "---option2---" + options2 + "-----option3----" + options3);
                            tvTimeType.setText(timeTypes.get(options1));
                            mPresenter.setUp(parameter.getId(), parameter.getName(), startTime, getEndTime(), AggLinkedUtil.getAgg(tvTimeType.getText().toString()), AggLinkedUtil.getSampling(tvTimeType.getText().toString()), AggLinkedUtil.getInterpolation(tvTimeType.getText().toString()));
                        }
                    });
                }
                mTimeTypePicker.show();
                break;
            default:
                break;
        }
    }

    private long getEndTime() {
        long end;
        switch (tvTimeType.getText().toString()) {
            case "十分钟":
                end = startTime + 599000L;
                break;
            case "一小时":
                end = startTime + 3599000L;
                break;
            case "一天":
                end = startTime + 86399000L;
                break;
            case "一周":
                end = startTime + 604799000L;
                break;
            case "一月":
                end = startTime + 2591999000L;
                break;
            default:
                end = startTime + 599000L;
                break;
        }
        if (end > System.currentTimeMillis()) {
            end = System.currentTimeMillis();
        }
        return end;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.e(TAG, "DataAnalysis destroy!");
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }
}
