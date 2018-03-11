package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyLoad;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseFragment;
import com.locensate.letnetwork.bean.MotorEfficiencyLoadEntity;
import com.locensate.letnetwork.utils.AggLinkedUtil;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.view.markView.CommonMarkerView;
import com.locensate.letnetwork.view.markView.MyMarkerView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author xiaobinghe
 */

public class EnergyLoadFragment extends BaseFragment<EnergyLoadPresenter, EnergyLoadModel> implements EnergyLoadContract.View, OnChartValueSelectedListener {

    @BindView(R.id.tv_energy_load_current_efficiency)
    TextView mTvEnergyLoadCurrentEfficiency;
    @BindView(R.id.tv_energy_load_average_efficiency)
    TextView mTvEnergyLoadAverageEfficiency;
    @BindView(R.id.rb_percent)
    RadioButton mRbPercent;
    @BindView(R.id.rb_load_type)
    RadioButton mRbLoadType;
    @BindView(R.id.rg_switch)
    RadioGroup mRgSwitch;
    @BindView(R.id.pie_energy_efficiency)
    PieChart mPieEnergyEfficiency;
    @BindView(R.id.tv_no_load_time)
    TextView mTvNoLoadTime;
    @BindView(R.id.tv_no_load_percent)
    TextView mTvNoLoadPercent;
    @BindView(R.id.tv_light_load_time)
    TextView mTvLightLoadTime;
    @BindView(R.id.tv_light_percent)
    TextView mTvLightPercent;
    @BindView(R.id.tv_half_load_time)
    TextView mTvHalfLoadTime;
    @BindView(R.id.tv_half_load_percent)
    TextView mTvHalfLoadPercent;
    @BindView(R.id.textView6)
    TextView mTextView6;
    @BindView(R.id.tv_heavy_load_time)
    TextView mTvHeavyLoadTime;
    @BindView(R.id.tv_heavy_load_percent)
    TextView mTvHeavyLoadPercent;
    @BindView(R.id.textView4)
    TextView mTextView4;
    @BindView(R.id.tv_over_load_time)
    TextView mTvOverLoadTime;
    @BindView(R.id.tv_overload_percent)
    TextView mTvOverloadPercent;
    @BindView(R.id.tv_stop_time)
    TextView mTvStopTime;
    @BindView(R.id.tv_stop_percent)
    TextView mTvStopPercent;
    @BindView(R.id.ll_load_type)
    LinearLayout mLlLoadType;
    @BindView(R.id.bar_chart)
    BarChart mBarChart;
    @BindView(R.id.ll_percent)
    LinearLayout mLlPercent;
    @BindView(R.id.iv_switch)
    ImageView mIvSwitch;
    @BindView(R.id.lc_energy_load)
    LineChart mLcEnergyLoad;
    @BindView(R.id.ll_energy_lose_electric)
    LinearLayout mLlEnergyLoseElectric;

    private long motorId;
    private long startMills;
    private long endMills;
    //    private String[] barChartX = {"10", "20", "30", "40", "50", "60", "70", "80", "90", "100", "110", "120", ">120"};
    private String[] barChartX = {"0-10", "10-20", "20-30", "30-40", "40-50", "50-60", "60-70", "70-80", "80-90", "90-100", "100-110", "110-120", ">120"};
    private boolean isCompleteInitUI = false;
    private String timeType;
    private String mAgg;
    private String mSampling;
    private String mInterpolation;

    @Override
    public int getInflaterView() {
        return R.layout.fragment_energy_load;
    }

    @Override
    protected void lazyLoad() {
        if (isCompleteInitUI) {
            mPresenter.requestData(motorId, startMills, endMills);
        }

    }

    @Override
    protected void initView() {
        isCompleteInitUI = true;
        mRgSwitch.check(R.id.rb_load_type);
        mRgSwitch.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_percent:
                        mLlLoadType.setVisibility(View.GONE);
                        mLlPercent.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rb_load_type:
                        mLlLoadType.setVisibility(View.VISIBLE);
                        mLlPercent.setVisibility(View.GONE);
                        break;
                }
            }
        });
        mTvNoLoadPercent.setText("——");
        mTvLightPercent.setText("——");
        mTvHalfLoadPercent.setText("——");
        mTvHeavyLoadPercent.setText("——");
        mTvOverloadPercent.setText("——");
        mTvStopPercent.setText("——");

        mTvNoLoadTime.setText("——");
        mTvLightLoadTime.setText("——");
        mTvHalfLoadTime.setText("——");
        mTvHeavyLoadTime.setText("——");
        mTvOverLoadTime.setText("——");
        mTvStopTime.setText("——");

        initBarData();
        initPieData();
        initLineData();
    }

    /**
     * 初始化BarChart，配置基本属性
     */
    private void initBarData() {
        mBarChart.setNoDataText("暂无数据");
        mBarChart.setDrawBarShadow(false);
        mBarChart.setDrawValueAboveBar(false);
        mBarChart.setDrawingCacheBackgroundColor(getResources().getColor(R.color.gray_line));
        mBarChart.getDescription().setEnabled(false);
        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
//        mBarChart.setMaxVisibleValueCount(60);
        // 设置缩放是否只能x轴和y轴一起作用，true，两手指一起作用x轴和y轴缩放都生效，false：x轴和y轴分开生效
        mBarChart.setPinchZoom(true);
        // 设置无数据文本的颜色
        mBarChart.setNoDataTextColor(getResources().getColor(R.color.font_gray));
        // 设置是否显示网格背景
        mBarChart.setDrawGridBackground(false);
//         mBarChart.setDrawYLabels(false);
    }

    /**
     * 初始化PieChart，配置基本属性
     */
    private void initPieData() {
        mPieEnergyEfficiency.setUsePercentValues(true);
        mPieEnergyEfficiency.setNoDataText("暂无数据");
        //添加饼图的描述是否可用
        mPieEnergyEfficiency.getDescription().setEnabled(false);
//        //添加饼图描述
//        Description desc = new Description();
//        //设置饼图描述的内容
//        desc.setText("画饼充饥");
//        //描述内容显示的位置有left，right，center可供选择
//        desc.setTextAlign(Paint.Align.CENTER);
//        //设置饼图描述
//        mPieEnergyEfficiency.setDescription(desc);
//        mPieEnergyEfficiency.setExtraOffsets(5, 10, 5, 5);
        mPieEnergyEfficiency.setDragDecelerationEnabled(true);
//        mPieEnergyEfficiency.setDrawSliceText(false);
        //设置滑动摩擦系数
        mPieEnergyEfficiency.setDragDecelerationFrictionCoef(0.98f);
        //字体类型
//        tf = Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Regular.ttf");
        //设置中心显示的文字类型
//        mPieEnergyEfficiency.setCenterTextTypeface(Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Light.ttf"));
        //设置中心显示的文字
//        mPieEnergyEfficiency.setCenterText(generateCenterSpannableText());
        //设置饼图左上右下的偏移量
        mPieEnergyEfficiency.setExtraOffsets(0.f, 0.f, 0.f, 0.f);
        //饼图是否空心
        mPieEnergyEfficiency.setDrawHoleEnabled(false);
        //饼图空心处的颜色
//        mPieEnergyEfficiency.setHoleColor(Color.WHITE);
        //饼图中心处阴影部分的颜色
//        mPieEnergyEfficiency.setTransparentCircleColor(Color.WHITE);
        //阴影部分的透明度（0-225）
//        mPieEnergyEfficiency.setTransparentCircleAlpha(110);
        //饼图上的标签颜色
//        mPieEnergyEfficiency.setEntryLabelColor(Color.BLACK);
        //饼图上标签可用性
        mPieEnergyEfficiency.setDrawEntryLabels(false);
        //饼图中心圆的半径
//        mPieEnergyEfficiency.setHoleRadius(60f);
        //饼图阴影部分圆的半径
//        mPieEnergyEfficiency.setTransparentCircleRadius(65f);
        //饼图中心文字可用性
//        mPieEnergyEfficiency.setDrawCenterText(true);
        //绘制饼图的起始点，默认为270度
        mPieEnergyEfficiency.setRotationAngle(270f);
        // 设置饼图是否可以被滑动
        mPieEnergyEfficiency.setRotationEnabled(true);
        //设置选中后是否高亮突出显示
        mPieEnergyEfficiency.setHighlightPerTapEnabled(false);

        // mPieEnergyEfficiency.setUnit(" €");
        // mPieEnergyEfficiency.setDrawUnitsInChart(true);

        // 添加选中监听
        mPieEnergyEfficiency.setOnChartValueSelectedListener(this);

        mPieEnergyEfficiency.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // mPieEnergyEfficiency.spin(2000, 0, 360);

        Legend l = mPieEnergyEfficiency.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(false);
    }

    /**
     * 初始化LineChart，配置基本属性
     */
    private void initLineData() {
        // 设置描述是否可用
        mLcEnergyLoad.getDescription().setEnabled(false);

        mLcEnergyLoad.setNoDataText("暂无数据");
        // 设置触摸手势可用
        mLcEnergyLoad.setTouchEnabled(true);

        //滑动摩擦系数
        mLcEnergyLoad.setDragDecelerationFrictionCoef(0.9f);

        // enable scaling and dragging
        mLcEnergyLoad.setDragEnabled(true);
        mLcEnergyLoad.setScaleEnabled(true);
        mLcEnergyLoad.setDrawGridBackground(false);
        mLcEnergyLoad.setHighlightPerDragEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        mLcEnergyLoad.setPinchZoom(true);

        // set an alternative background color
        mLcEnergyLoad.setBackgroundColor(getResources().getColor(R.color.white));

        mLcEnergyLoad.animateX(2500);
        // get the legend (only possible after setting data)图例
        Legend l = mLcEnergyLoad.getLegend();

        // modify the legend ...
        l.setForm(Legend.LegendForm.LINE);
        l.setTextSize(10f);
        l.setTextColor(getResources().getColor(R.color.font_content));
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);

        XAxis xAxis = mLcEnergyLoad.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(10f);
        xAxis.setTextColor(getResources().getColor(R.color.font_content));
        xAxis.setDrawGridLines(true);
        xAxis.setDrawAxisLine(true);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            private SimpleDateFormat mFormat = new SimpleDateFormat("MM/dd HH:mm");

            @Override
            public String getFormattedValue(float value, AxisBase axis) {

                LogUtil.e("getFormattedValue", "------value---" + value);
                long m = (long) (value + startMills);
                return mFormat.format(new Date(m));
            }
        });


        YAxis rightAxis = mLcEnergyLoad.getAxisRight();
        rightAxis.setAxisMaximum(0f);
        rightAxis.setAxisMinimum(0f);
        rightAxis.setTextColor(getResources().getColor(R.color.white));
        rightAxis.setDrawGridLines(false);
        rightAxis.setDrawZeroLine(false);
        rightAxis.setGranularityEnabled(false);

        YAxis leftAxis = mLcEnergyLoad.getAxisLeft();
        leftAxis.setTextColor(getResources().getColor(R.color.font_content));
        leftAxis.setDrawAxisLine(true);

        leftAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return (int) value * 100 + "%";
            }
        });
        leftAxis.setDrawGridLines(true);
        leftAxis.setGranularityEnabled(true);

    }


    @Override
    public void setBarData(ArrayList<BarEntry> barData) {


        float tempMax = barData.get(0).getY();
        float tempMin = barData.get(0).getY();
        for (int i = 0; i < barData.size(); i++) {
            float yVals = barData.get(i).getY();
            if (tempMax < yVals) {
                tempMax = yVals;
            }
            if (tempMin > yVals) {
                tempMin = yVals;
            }
        }

        /**
         * x轴标签相关设置
         */

        // 标签格式
        IAxisValueFormatter xAxisFormatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                LogUtil.e("getFormattedValue", "------" + value + "---------" + axis.mEntryCount);
                return getLabelString(value);
            }
        };
        XAxis xAxis = mBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        // 设置标签的字体样式
//        xAxis.setTypeface(mTfLight);
        xAxis.setDrawGridLines(false);
        // 设置最小缩放的距离
        xAxis.setGranularity(1f);

        xAxis.setLabelCount(barData.size());
        // 设置标签的颜色
        xAxis.setTextColor(getResources().getColor(R.color.font_content));
        // 设置标签的格式：可自定义
        xAxis.setValueFormatter(xAxisFormatter);


        /**
         * y轴标签相关设置
         */
        IAxisValueFormatter custom = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                DecimalFormat df = new DecimalFormat("0.0");
                return df.format(value) + "h";
            }
        };

        YAxis leftAxis = mBarChart.getAxisLeft();

        leftAxis.setLabelCount(8, false);
        leftAxis.setValueFormatter(custom);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setTextColor(getResources().getColor(R.color.font_content));
        // 设置顶轴空间
        leftAxis.setSpaceTop(5f);
        leftAxis.setAxisMinimum(0);
        leftAxis.setAxisMaximum(tempMax + tempMax * 0.15f);


        YAxis rightAxis = mBarChart.getAxisRight();
        rightAxis.setDrawGridLines(false);

        rightAxis.setLabelCount(8, false);
        rightAxis.setValueFormatter(custom);
        rightAxis.setSpaceTop(15f);
        rightAxis.setAxisMaximum(0f);
        rightAxis.setAxisMinimum(0f);

        /**
         * 设置图例
         */
        Legend l = mBarChart.getLegend();
        // 设置图例在垂直方向上的对齐方式
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        // 设置图例在横向的对齐方式
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setForm(Legend.LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(10f);
        l.setTextColor(getResources().getColor(R.color.font_content));
        l.setXEntrySpace(4f);
        // l.setExtra(ColorTemplate.VORDIPLOM_COLORS, new String[] { "abc",
        // "def", "ghj", "ikl", "mno" });
        // l.setCustom(ColorTemplate.VORDIPLOM_COLORS, new String[] { "abc",
        // "def", "ghj", "ikl", "mno" });

        CommonMarkerView mv = new CommonMarkerView(getContext(), R.layout.custom_marker_view);
        mv.setChartView(mBarChart); // For bounds control
        mBarChart.setMarker(mv); // Set the marker to the charts


        BarDataSet set1;

        if (mBarChart.getData() != null &&
                mBarChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) mBarChart.getData().getDataSetByIndex(0);
            set1.setValues(barData);
            mBarChart.getData().notifyDataChanged();
            mBarChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(barData, "负载百分比");
            set1.setColors(getContext().getResources().getColor(R.color.font_blue_tab));
            set1.setDrawValues(false);
            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);
            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
//            data.setValueTypeface(mTfLight);
            data.setBarWidth(0.6f);
            mBarChart.setData(data);
        }
    }

    @Override
    public void setPieData(ArrayList<PieEntry> pieData) {
        PieDataSet dataSet = new PieDataSet(pieData, "Election Results");
        dataSet.setDrawValues(false);

        dataSet.setSliceSpace(0f);
        dataSet.setSelectionShift(5f);

        // add a lot of colors
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(getResources().getColor(R.color.pie_red));
        colors.add(getResources().getColor(R.color.pie_orange));
        colors.add(getResources().getColor(R.color.pie_blue));
        colors.add(getResources().getColor(R.color.pie_green));
        colors.add(getResources().getColor(R.color.pie_yellow));
        colors.add(getResources().getColor(R.color.pie_gray));

        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);
        //dataSet.setSelectionShift(0f);

        dataSet.setValueLinePart1OffsetPercentage(80.f);
        dataSet.setValueLinePart1Length(0.2f);
        dataSet.setValueLinePart2Length(0.4f);
        //dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(6f);
        data.setValueTextColor(Color.BLACK);
        mPieEnergyEfficiency.setData(data);

        // undo all highlights
        mPieEnergyEfficiency.highlightValues(null);
        mPieEnergyEfficiency.invalidate();
    }

    @Override
    public void setLineData(List<Entry> lineData, String[] dataLabels) {
        mLcEnergyLoad.resetTracking();
        LineDataSet set1;

        // create a dataset and give it a type
        set1 = new LineDataSet(lineData, dataLabels[0]);
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);
        set1.setColor(getResources().getColor(R.color.pie_red));
        set1.setCircleColor(getResources().getColor(R.color.pie_red));
        set1.setLineWidth(1.5f);
        set1.setFillAlpha(65);
        set1.setDrawCircles(false);
        set1.setFillColor(ColorTemplate.getHoloBlue());
        set1.setHighLightColor(Color.rgb(244, 117, 117));
        set1.setDrawValues(false);
        set1.setDrawCircleHole(false);
        //set1.setFillFormatter(new MyFillFormatter(0f));
        //set1.setDrawHorizontalHighlightIndicator(false);
        //set1.setVisible(false);
        //set1.setCircleHoleColor(Color.WHITE);


        // create a data object with the datasets
        LineData data = new LineData(set1);
        data.setValueTextColor(Color.WHITE);
        data.setValueTextSize(10f);
        // set data
        mLcEnergyLoad.setData(data);

        mLcEnergyLoad.animateX(2000);
        MyMarkerView mv = new MyMarkerView(getContext(), R.layout.layout_my_marker_view, startMills);
        mv.setChartView(mLcEnergyLoad);
        mLcEnergyLoad.setMarker(mv);
    }

    @Override
    public void setLoadRate(MotorEfficiencyLoadEntity.DataBean data, long sumSecond, String average_loading, String current_loading) {
        mTvEnergyLoadCurrentEfficiency.setText(current_loading);
        mTvEnergyLoadAverageEfficiency.setText(average_loading);
        DecimalFormat df = new DecimalFormat("0.0");
        DecimalFormat dfh = new DecimalFormat("0.0");
        long no_loading_time = data.getNo_loading_time();
        long light_loading_time = data.getLight_loading_time();
        long half_load_time = data.getHalf_load_time();
        long heavy_loading_time = data.getHeavy_loading_time();
        long over_loading_time = data.getOver_loading_time();
        long stop_time = sumSecond - no_loading_time - light_loading_time - half_load_time - heavy_loading_time - over_loading_time;
        if (stop_time < 0) {
            stop_time = 0;
        }
        mTvNoLoadPercent.setText((sumSecond == 0 ? 0 : df.format((no_loading_time * 100) / sumSecond)) + "%");
        mTvLightPercent.setText((sumSecond == 0 ? 0 : df.format((light_loading_time * 100) / sumSecond)) + "%");
        mTvHalfLoadPercent.setText((sumSecond == 0 ? 0 : df.format((half_load_time * 100) / sumSecond)) + "%");
        mTvHeavyLoadPercent.setText((sumSecond == 0 ? 0 : df.format((heavy_loading_time * 100) / sumSecond)) + "%");
        mTvOverloadPercent.setText((sumSecond == 0 ? 0 : df.format((over_loading_time * 100) / sumSecond)) + "%");
        mTvStopPercent.setText((sumSecond == 0 ? 0 : df.format((stop_time * 100) / sumSecond)) + "%");


        mTvNoLoadTime.setText(dfh.format(no_loading_time / (float) 3600) + "h");
        mTvLightLoadTime.setText(dfh.format(light_loading_time / (float) 3600) + "h");
        mTvHalfLoadTime.setText(dfh.format(half_load_time / (float) 3600) + "h");
        mTvHeavyLoadTime.setText(dfh.format(heavy_loading_time / (float) 3600) + "h");
        mTvOverLoadTime.setText(dfh.format(over_loading_time / (float) 3600) + "h");
        mTvStopTime.setText(dfh.format(stop_time / (float) 3600) + "h");


    }


    private String getLabelString(float value) {
        return barChartX[(int) value - 1];
    }


    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }


    @OnClick(R.id.iv_switch)
    public void onClick() {

    }

    public void notifyData(long motorId, long startMills, long endMills, String timeType) {
        if (motorId == this.motorId && startMills == this.startMills && endMills == this.endMills) {
            return;
        }
        this.motorId = motorId;
        this.startMills = startMills;
        this.endMills = endMills;
        this.timeType = timeType;

        LogUtil.e("LoadMills", "motorId=" + motorId + "---startMills=" + startMills + "----------endMills=" + endMills + "---------timeType=" + timeType);
        mAgg = AggLinkedUtil.getAgg(timeType);
        mSampling = AggLinkedUtil.getSampling(timeType);
        mInterpolation = AggLinkedUtil.getInterpolation(timeType);

        if (null != mPresenter) {
            mPresenter.requestData(motorId, startMills, handleDate(endMills, startMills));
            mPresenter.requestHistory(motorId, "BETA", startMills, endMills, mAgg, mSampling, mInterpolation);
        }
    }

    private long handleDate(long endMills, long startMills) {
        long cu = System.currentTimeMillis();
        if ((endMills + 6000) < cu) {
            return endMills;
        }
        Date currentDate = new Date(cu);
        int minutes = currentDate.getMinutes();
        if (minutes > 1 || minutes == 1) {
            currentDate.setMinutes(0);
            currentDate.setSeconds(0);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);
            calendar.set(Calendar.SECOND, -1);
            long lastTime = calendar.getTimeInMillis();
            if (startMills > lastTime) {
                lastTime = startMills;
            }
            LogUtil.e("Calendar", "-----lastTime=" + lastTime + "----endMills=" + endMills);
            return lastTime;
        } else {
            currentDate.setMinutes(0);
            currentDate.setSeconds(0);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);
            calendar.set(Calendar.SECOND, -3601);
            long lastTime = calendar.getTimeInMillis();
            if (startMills > lastTime) {
                lastTime = startMills;
            }
            LogUtil.e("Calendar2", "-----lastTime=" + lastTime + "----endMills=" + endMills);
            return lastTime;
        }
    }

    @Override
    public void pullRequest() {
        mPresenter.requestData(motorId, startMills, endMills);
        mPresenter.requestHistory(motorId, "BETA", startMills, endMills, mAgg, mSampling, mInterpolation);
    }

}
