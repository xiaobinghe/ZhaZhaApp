package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyLoad;

import android.graphics.Color;
import android.support.annotation.NonNull;
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
import com.locensate.letnetwork.view.markView.CommonMarkerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author xiaobinghe
 */

public class EnergyLoadFragment extends BaseFragment<EnergyLoadPresenter, EnergyLoadModel> implements EnergyLoadContract.View, OnChartValueSelectedListener {

    @BindView(R.id.tv_energy_load_current_efficiency)
    TextView tvEnergyLoadCurrentEfficiency;
    @BindView(R.id.tv_energy_load_average_efficiency)
    TextView tvEnergyLoadAverageEfficiency;
    @BindView(R.id.pie_energy_efficiency)
    PieChart pieLoad;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.tv_energy_load_time1)
    TextView tvEnergyLoadTime1;
    @BindView(R.id.tv_energy_load_percent1)
    TextView tvEnergyLoadPercent1;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.tv_energy_load_time2)
    TextView tvEnergyLoadTime2;
    @BindView(R.id.tv_energy_load_percent2)
    TextView tvEnergyLoadPercent2;
    @BindView(R.id.tv_energy_load_time3)
    TextView tvEnergyLoadTime3;
    @BindView(R.id.tv_energy_load_percent3)
    TextView tvEnergyLoadPercent3;
    @BindView(R.id.tv_energy_load_time4)
    TextView tvEnergyLoadTime4;
    @BindView(R.id.tv_energy_load_percent4)
    TextView tvEnergyLoadPercent4;
    @BindView(R.id.tv_energy_load_time5)
    TextView tvEnergyLoadTime5;
    @BindView(R.id.tv_energy_load_percent5)
    TextView tvEnergyLoadPercent5;
    @BindView(R.id.tv_energy_load_time6)
    TextView tvEnergyLoadTime6;
    @BindView(R.id.tv_energy_load_percent6)
    TextView tvEnergyLoadPercent6;
    @BindView(R.id.lc_energy_load)
    LineChart lineLoad;
    @BindView(R.id.ll_energy_lose_electric)
    LinearLayout llEnergyLoseElectric;
    @BindView(R.id.rb_percent)
    RadioButton mRbPercent;
    @BindView(R.id.rb_load_type)
    RadioButton mRbLoadType;
    @BindView(R.id.rg_switch)
    RadioGroup mRgSwitch;
    @BindView(R.id.bar_chart)
    BarChart mBarChart;
    @BindView(R.id.ll_load_type)
    LinearLayout mLlLoadType;
    @BindView(R.id.ll_percent)
    LinearLayout mLlPercent;
    @BindView(R.id.iv_switch)
    ImageView mIvSwitch;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EnergyLoadFragment.
     */
 /*   public static EnergyLoadFragment newInstance(String param1, String param2) {
        if (null == fragment) {
            fragment = new EnergyLoadFragment();
            Bundle args = new Bundle();
            fragment.setArguments(args);
        }
        return fragment;
    }*/
    @Override
    public int getInflaterView() {
        return R.layout.fragment_energy_load;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void initView() {
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
        initBarData();
        initPieData();
        initLineData();
    }

    /**
     * 初始化BarChart，配置基本属性
     */
    private void initBarData() {
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
        pieLoad.setUsePercentValues(true);
        //添加饼图的描述是否可用
        pieLoad.getDescription().setEnabled(false);
//        //添加饼图描述
//        Description desc = new Description();
//        //设置饼图描述的内容
//        desc.setText("画饼充饥");
//        //描述内容显示的位置有left，right，center可供选择
//        desc.setTextAlign(Paint.Align.CENTER);
//        //设置饼图描述
//        pieLoad.setDescription(desc);
//        pieLoad.setExtraOffsets(5, 10, 5, 5);
        pieLoad.setDragDecelerationEnabled(true);
//        pieLoad.setDrawSliceText(false);
        //设置滑动摩擦系数
        pieLoad.setDragDecelerationFrictionCoef(0.98f);
        //字体类型
//        tf = Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Regular.ttf");
        //设置中心显示的文字类型
//        pieLoad.setCenterTextTypeface(Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Light.ttf"));
        //设置中心显示的文字
//        pieLoad.setCenterText(generateCenterSpannableText());
        //设置饼图左上右下的偏移量
        pieLoad.setExtraOffsets(0.f, 0.f, 0.f, 0.f);
        //饼图是否空心
        pieLoad.setDrawHoleEnabled(false);
        //饼图空心处的颜色
//        pieLoad.setHoleColor(Color.WHITE);
        //饼图中心处阴影部分的颜色
//        pieLoad.setTransparentCircleColor(Color.WHITE);
        //阴影部分的透明度（0-225）
//        pieLoad.setTransparentCircleAlpha(110);
        //饼图上的标签颜色
//        pieLoad.setEntryLabelColor(Color.BLACK);
        //饼图上标签可用性
        pieLoad.setDrawEntryLabels(false);
        //饼图中心圆的半径
//        pieLoad.setHoleRadius(60f);
        //饼图阴影部分圆的半径
//        pieLoad.setTransparentCircleRadius(65f);
        //饼图中心文字可用性
//        pieLoad.setDrawCenterText(true);
        //绘制饼图的起始点，默认为270度
        pieLoad.setRotationAngle(270f);
        // 设置饼图是否可以被滑动
        pieLoad.setRotationEnabled(true);
        //设置选中后是否高亮突出显示
        pieLoad.setHighlightPerTapEnabled(false);

        // pieLoad.setUnit(" €");
        // pieLoad.setDrawUnitsInChart(true);

        // 添加选中监听
        pieLoad.setOnChartValueSelectedListener(this);

        pieLoad.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // pieLoad.spin(2000, 0, 360);

        Legend l = pieLoad.getLegend();
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
        lineLoad.getDescription().setEnabled(false);

        // 设置触摸手势可用
        lineLoad.setTouchEnabled(true);

        //滑动摩擦系数
        lineLoad.setDragDecelerationFrictionCoef(0.9f);

        // enable scaling and dragging
        lineLoad.setDragEnabled(true);
        lineLoad.setScaleEnabled(true);
        lineLoad.setDrawGridBackground(false);
        lineLoad.setHighlightPerDragEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        lineLoad.setPinchZoom(true);

        // set an alternative background color
        lineLoad.setBackgroundColor(getResources().getColor(R.color.white));

        // TODO: 2017/6/27 add data


        lineLoad.animateX(2500);
        // get the legend (only possible after setting data)图例
        Legend l = lineLoad.getLegend();

        // modify the legend ...
        l.setForm(Legend.LegendForm.LINE);
//        l.setTypeface(mTfLight);
        l.setTextSize(10f);
        l.setTextColor(getResources().getColor(R.color.font_content));
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
//        l.setYOffset(11f);

        XAxis xAxis = lineLoad.getXAxis();
//        xAxis.setTypeface(mTfLight);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(10f);
        xAxis.setAxisMaximum(23f);
        xAxis.setAxisMinimum(0f);
        xAxis.setTextColor(getResources().getColor(R.color.font_content));
        xAxis.setDrawGridLines(true);
        xAxis.setDrawAxisLine(true);

        YAxis leftAxis = lineLoad.getAxisLeft();
//        leftAxis.setTypeface(mTfLight);
        leftAxis.setTextColor(getResources().getColor(R.color.font_content));
        leftAxis.setAxisMaximum(120f);
        leftAxis.setAxisMinimum(0f);
        leftAxis.setDrawAxisLine(true);
        leftAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return (int) value + "%";
            }
        });

        leftAxis.setDrawGridLines(true);
        leftAxis.setGranularityEnabled(true);
        YAxis rightAxis = lineLoad.getAxisRight();
//        rightAxis.setTypeface(mTfLight);
        rightAxis.setTextColor(getResources().getColor(R.color.font_content));
        rightAxis.setAxisMaximum(0f);
        rightAxis.setAxisMinimum(0f);
        rightAxis.setDrawGridLines(false);
        rightAxis.setDrawZeroLine(false);
        rightAxis.setGranularityEnabled(false);
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
                return getString(value);
            }
        };
        XAxis xAxis = mBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        // 设置标签的字体样式
//        xAxis.setTypeface(mTfLight);
        xAxis.setDrawGridLines(false);
        // 设置最小缩放的距离
        xAxis.setGranularity(1f); // only intervals of 1 day

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
                return String.valueOf((int) value) + "h";
            }
        };

        YAxis leftAxis = mBarChart.getAxisLeft();
//        leftAxis.setTypeface(mTfLight);
        leftAxis.setLabelCount(8, false);
        leftAxis.setValueFormatter(custom);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setTextColor(getResources().getColor(R.color.font_content));
        // 设置顶轴空间
        leftAxis.setSpaceTop(5f);
        // TODO: 2017/6/26 设置最小范围
        leftAxis.setAxisMinimum((tempMax - tempMin) / 2);
        // TODO: 2017/6/26 设置最大范围
        leftAxis.setAxisMaximum(tempMax + tempMax * 0.15f); // this replaces setStartAtZero(true)

        YAxis rightAxis = mBarChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
//        rightAxis.setTypeface(mTfLight);
        rightAxis.setLabelCount(8, false);
        rightAxis.setValueFormatter(custom);
        rightAxis.setSpaceTop(15f);
        rightAxis.setAxisMaximum(0f);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

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
            data.setBarWidth(0.4f);
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
        colors.add(getResources().getColor(R.color.pie_green));
        colors.add(getResources().getColor(R.color.pie_yellow));
        colors.add(getResources().getColor(R.color.pie_red));
        colors.add(getResources().getColor(R.color.pie_gray));
        colors.add(getResources().getColor(R.color.pie_orange));
        colors.add(getResources().getColor(R.color.pie_blue));

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
        pieLoad.setData(data);

        // undo all highlights
        pieLoad.highlightValues(null);
        pieLoad.invalidate();
    }

    @Override
    public void setLineData(ArrayList<Entry> lineData, String[] dataLabels) {
        LineDataSet set1;
        if (lineLoad.getData() != null &&
                lineLoad.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) lineLoad.getData().getDataSetByIndex(0);
            set1.setValues(lineData);
            lineLoad.getData().notifyDataChanged();
            lineLoad.notifyDataSetChanged();
        } else {
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
            lineLoad.setData(data);
        }
    }

    @NonNull
    private String getString(float value) {
        String temp = new String();
        switch ((int) value) {
            case 1:
                temp = "0-20";
                break;
            case 2:
                temp = "20-40";
                break;
            case 3:
                temp = "40-60";
                break;
            case 4:
                temp = "60-80";
                break;
            case 5:
                temp = "80-100";
                break;
            case 6:
                temp = "100-120";
                break;
            case 7:
                temp = ">120";
                break;
        }
        return temp;
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
}
