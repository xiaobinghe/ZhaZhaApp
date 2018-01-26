package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyfgp;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseFragment;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.CustomBarData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author xiaobinghe
 */

public class EnergyFengGuPingFragment extends BaseFragment<EnergyFengGuPingPresenter, EnergyFengGuPingModel> implements EnergyFengGuPingConstract.View {
    @BindView(R.id.pie_energy_feng_gu_ping)
    PieChart pieChart;
    @BindView(R.id.tv_energy_feng_eff)
    TextView tvEnergyFengEff;
    @BindView(R.id.tv_energy_feng_percent)
    TextView tvEnergyFengPercent;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.tv_energy_gu_eff)
    TextView tvEnergyGuEff;
    @BindView(R.id.tv_energy_gu_percent)
    TextView tvEnergyGuPercent;
    @BindView(R.id.tv_energy_ping_eff)
    TextView tvEnergyPingEff;
    @BindView(R.id.tv_energy_ping_percent)
    TextView tvEnergyPingPercent;
    @BindView(R.id.rb_energy_1)
    RadioButton rbEnergy1;
    @BindView(R.id.rb_energy_2)
    RadioButton rbEnergy2;
    @BindView(R.id.rg_energy_feng_gu_ping)
    RadioGroup rgEnergyFengGuPing;
    @BindView(R.id.lc_energy_feng_gu_ping)
    LineChart lineChart;
    @BindView(R.id.cbc_energy_feng_gu_ping)
    CombinedChart combinedChart;
    @BindView(R.id.ll_energy_feng_gu_ping_time_compare)
    LinearLayout llEnergyTimeCompare;
    @BindView(R.id.ll_energy_feng_gu_ping_electric)
    LinearLayout llEnergyLoseElectric;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Typeface tf;
    private float[] piePercent = new float[3];
    private String[] mParties = {"峰电", "谷电", "平电"};
    private String timeType = "";

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
  /*  public static EnergyFengGuPingFragment newInstance(String param1, String param2) {
        if (null == energyFragment) {
            energyFragment = new EnergyFengGuPingFragment();
            Bundle args = new Bundle();
            energyFragment.setArguments(args);
        }
        return energyFragment;
    }*/
    @Override
    public int getInflaterView() {
        return R.layout.fragment_energy_feng_gu_ping;
    }

    @Override
    protected void initView() {
        rgEnergyFengGuPing.check(R.id.rb_energy_1);
        rgEnergyFengGuPing.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_energy_1 && llEnergyLoseElectric.getVisibility() != View.VISIBLE) {
                    llEnergyLoseElectric.setVisibility(View.VISIBLE);
                    llEnergyTimeCompare.setVisibility(View.GONE);
                } else if (checkedId == R.id.rb_energy_2 && llEnergyTimeCompare.getVisibility() != View.VISIBLE) {
                    llEnergyLoseElectric.setVisibility(View.GONE);
                    llEnergyTimeCompare.setVisibility(View.VISIBLE);
                }
            }
        });
        fillLineData();
        fillPieData();
        fillCombineData();
    }


    private void fillCombineData() {
        combinedChart.getDescription().setEnabled(false);
        combinedChart.setBackgroundColor(Color.WHITE);
        combinedChart.setDrawGridBackground(false);
        combinedChart.setDrawBarShadow(true);
        combinedChart.setHighlightFullBarEnabled(false);

        // draw bars behind lines
        combinedChart.setDrawOrder(new CombinedChart.DrawOrder[]{
                CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.LINE
        });

        combinedChart.animateXY(1400, 1400);
        Legend l = combinedChart.getLegend();
        l.setTextColor(getResources().getColor(R.color.font_content));
        l.setTextSize(10f);
        l.setWordWrapEnabled(true);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);

        YAxis rightAxis = combinedChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        rightAxis.setAxisMaximum(1.2f);
        rightAxis.setTextColor(getResources().getColor(R.color.font_content));

        YAxis leftAxis = combinedChart.getAxisLeft();
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        leftAxis.setAxisMaximum(60f);
        leftAxis.setTextColor(getResources().getColor(R.color.font_content));
        XAxis xAxis = combinedChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawGridLines(false);
        xAxis.setTextColor(getResources().getColor(R.color.font_content));
        xAxis.setAxisMinimum(0f);
        xAxis.setAxisMaximum(24f);
        xAxis.setGranularity(1f);

//        xAxis.setValueFormatter(new IAxisValueFormatter() {
//            @Override
//            public String getFormattedValue(float value, AxisBase axis) {
//                return mMonths[(int) value % mMonths.length];
//            }
//        });

        CombinedData data = new CombinedData();

        data.setData(generateLineData());
        data.setData(generateBarData());
//        data.setValueTypeface(mTfLight);

        xAxis.setAxisMaximum(data.getXMax() + 0.25f);
        data.setDrawValues(false);
        combinedChart.setData(data);
        combinedChart.invalidate();

    }

    private LineData generateLineData() {

        LineData d = new LineData();
        LineDataSet set = new LineDataSet(getElectricPrice(), "电费单价");
        set.setColor(getResources().getColor(R.color.pie_orange));
        set.setDrawCircles(true);
        set.setCircleColorHole(getResources().getColor(R.color.pie_orange));
        set.setLineWidth(2f);
        set.setValueTextSize(10f);
        set.setCircleColor(getResources().getColor(R.color.pie_orange));
        set.setCircleRadius(1f);
        set.setMode(LineDataSet.Mode.LINEAR);
        set.setFillColor(getResources().getColor(R.color.pie_orange));
        set.setDrawValues(false);
        set.setValueTextSize(10f);
        set.setValueTextColor(Color.rgb(240, 238, 70));
        set.setAxisDependency(YAxis.AxisDependency.RIGHT);
        d.addDataSet(set);

        return d;
    }

    private BarData generateBarData() {
        ArrayList<BarEntry> entries2 = new ArrayList<BarEntry>();

        for (int index = 0; index < 24; index++) {
            // stacked
            entries2.add(new BarEntry(0, new float[]{getRandom(13, 12), getRandom(13, 12)}));
        }

        BarDataSet set1 = new BarDataSet(getBarEntry1(), "累计耗电量");
        set1.setColor(getResources().getColor(R.color.font_blue_tab));
        set1.setValueTextColor(getResources().getColor(R.color.font_blue_tab));
        set1.setValueTextSize(10f);
        set1.setDrawValues(false);

        set1.setBarShadowColor(getResources().getColor(R.color.white));
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);


//        BarDataSet set2 = new BarDataSet(entries2, null);
//        set2.setColors(getResources().getColor(R.color.font_blue_tab));
//        set2.setValueTextColor(getResources().getColor(R.color.font_blue_tab));
//        set2.setValueTextSize(10f);
//        set2.setAxisDependency(YAxis.AxisDependency.LEFT);

        List<BarDataSet> barDataSets = new ArrayList<>();
        barDataSets.add(set1);
        float groupSpace = 0.06f;
        float barSpace = 0.120f; // x2 dataset
        float barWidth = 0.65f; // x2 dataset
        // (0.45 + 0.02) * 2 + 0.06 = 1.00 -> interval per "group"

        //自定义的bardata，为单个数据源
        CustomBarData d = new CustomBarData();
        d.addDataSet(set1);
        d.setBarWidth(barWidth);
        // make this BarData object grouped
        d.barsSpace(0.0f, barSpace); // start at x = 0
        d.setDrawValues(true);
        return d;
    }

    private void fillLineData() {
        // 设置描述是否可用
        lineChart.getDescription().setEnabled(false);

        // 设置触摸手势可用
        lineChart.setTouchEnabled(true);

        //滑动摩擦系数
        lineChart.setDragDecelerationFrictionCoef(0.9f);

        // enable scaling and dragging
        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(true);
        lineChart.setDrawGridBackground(false);
        lineChart.setHighlightPerDragEnabled(true);

        lineChart.animateX(2000);
        // if disabled, scaling can be done on x- and y-axis separately
        lineChart.setPinchZoom(true);

        // set an alternative background color
        lineChart.setBackgroundColor(getResources().getColor(R.color.white));

        // add data
        setLineData(24, 30, getDataSets(), getEntry1(), getEntry2(), getEntry3(), getColors());

        lineChart.animateX(2500);

        // get the legend (only possible after setting data)图例
        Legend l = lineChart.getLegend();

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

        XAxis xAxis = lineChart.getXAxis();
//        xAxis.setTypeface(mTfLight);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(10f);
        xAxis.setAxisMaximum(23);
        xAxis.setAxisMinimum(0);
        xAxis.setTextColor(getResources().getColor(R.color.font_content));
        xAxis.setDrawGridLines(true);
        xAxis.setDrawAxisLine(true);

        YAxis leftAxis = lineChart.getAxisLeft();
//        leftAxis.setTypeface(mTfLight);
        leftAxis.setTextColor(getResources().getColor(R.color.font_content));
        leftAxis.setAxisMaximum(60f);
        leftAxis.setDrawAxisLine(true);
        leftAxis.setAxisMinimum(0f);
        leftAxis.setDrawGridLines(true);
        leftAxis.setGranularityEnabled(true);

        YAxis rightAxis = lineChart.getAxisRight();
//        rightAxis.setTypeface(mTfLight);
        rightAxis.setTextColor(getResources().getColor(R.color.font_content));
        rightAxis.setAxisMaximum(0f);
        rightAxis.setAxisMinimum(0f);
        rightAxis.setDrawGridLines(false);
        rightAxis.setDrawZeroLine(false);
        rightAxis.setGranularityEnabled(false);
    }

    private ArrayList<Entry> getEntry3() {

        ArrayList<Entry> data3 = new ArrayList<Entry>();
        if (timeType.equals("小时") || timeType.equals("天")) {
            return data3;
        }
        for (int i = 0; i < 24; i++) {
            float val = (float) (Math.random() * 30) + 20;
            data3.add(new Entry(i, val));
        }
        return data3;
    }

    private ArrayList<Entry> getEntry2() {

        ArrayList<Entry> data2 = new ArrayList<Entry>();
        if (timeType.equals("小时") || timeType.equals("天")) {
            return data2;
        }
        float val;
        for (int i = 0; i < 24; i++) {
            val = (float) (Math.random() * 15) + 30;
            data2.add(new Entry(i, val));
        }
        return data2;
    }

    private ArrayList<Entry> getElectricPrice() {
        ArrayList<Entry> data2 = new ArrayList<Entry>();

        float val;
        for (int i = 0; i < 24; i++) {
            if (i <= 6 | i > 22) {
                val = 0.45f;
            } else {
                val = 0.75f;
            }
            data2.add(new Entry(i, val));
        }
        return data2;
    }

    private ArrayList<Entry> getEntry1() {
        ArrayList<Entry> data1 = new ArrayList<>();

        if (timeType.equals("小时") || timeType.equals("天")) {
            return data1;
        }
        float val = 0;
        for (int i = 0; i < 24; i++) {
            val = (float) (Math.random() * 40) + 10;
            data1.add(new Entry(i, val));
        }
        return data1;
    }

    private void setLineData(int count, float range, String[] dataSets, ArrayList<Entry> entries1, ArrayList<Entry> entries2, ArrayList<Entry> entries3, int[] dataColors) {


        LineDataSet set1, set2, set3;

        if (lineChart.getData() != null &&
                lineChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) lineChart.getData().getDataSetByIndex(0);
            set2 = (LineDataSet) lineChart.getData().getDataSetByIndex(1);
//            set3 = (LineDataSet) lineChart.getData().getDataSetByIndex(2);
            set1.setValues(entries1);
            set2.setValues(entries2);
//            set3.setValues(entries3);
            lineChart.getData().notifyDataChanged();
            lineChart.notifyDataSetChanged();
        } else {
            // create a dataset and give it a type
            set1 = new LineDataSet(entries1, dataSets[0]);

            set1.setAxisDependency(YAxis.AxisDependency.LEFT);
            set1.setColor(dataColors[0]);
            set1.setCircleColor(dataColors[0]);
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

            // create a dataset and give it a type
            set2 = new LineDataSet(entries2, dataSets[1]);
            set2.setAxisDependency(YAxis.AxisDependency.LEFT);
            set2.setColor(dataColors[1]);
            set2.setCircleColor(dataColors[1]);
            set2.setLineWidth(1.5f);
            set2.setDrawCircles(false);
            set2.setDrawValues(false);
            set2.setFillAlpha(65);
            set2.setFillColor(dataColors[1]);
            set2.setDrawCircleHole(false);
//            set2.setHighLightColor(Color.rgb(244, 117, 117));
            //set2.setFillFormatter(new MyFillFormatter(900f));

            set3 = new LineDataSet(entries3, dataSets[2]);
            set3.setAxisDependency(YAxis.AxisDependency.LEFT);
            set3.setColor(dataColors[2]);
            set3.setCircleColor(dataColors[2]);
            set3.setLineWidth(1.5f);
            set3.setDrawCircles(false);
            set3.setDrawValues(false);
            set3.setFillAlpha(65);
            set3.setFillColor(ColorTemplate.colorWithAlpha(Color.YELLOW, 200));
            set3.setDrawCircleHole(false);
            set3.setHighLightColor(Color.rgb(244, 117, 117));

            // create a data object with the datasets
            LineData data = new LineData(set1, set2, set3);
            data.setValueTextColor(Color.WHITE);
            data.setValueTextSize(10f);
            // set data
            lineChart.setData(data);
        }
    }

    @Override
    protected void lazyLoad() {

    }

    private void fillPieData() {
        initPieData();
        pieChart.setUsePercentValues(true);
        //添加饼图的描述是否可用
        pieChart.getDescription().setEnabled(false);
//        //添加饼图描述
//        Description desc = new Description();
//        //设置饼图描述的内容
//        desc.setText("画饼充饥");
//        //描述内容显示的位置有left，right，center可供选择
//        desc.setTextAlign(Paint.Align.CENTER);
//        //设置饼图描述
//        pieChart.setDescription(desc);

//        pieChart.setExtraOffsets(5, 10, 5, 5);

        pieChart.setDragDecelerationEnabled(true);

//        pieChart.setDrawSliceText(false);

        //设置滑动摩擦系数
        pieChart.setDragDecelerationFrictionCoef(0.98f);

        pieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        //字体类型
//        tf = Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Regular.ttf");

        //设置中心显示的文字类型
//        pieChart.setCenterTextTypeface(Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Light.ttf"));
        //设置中心显示的文字
//        pieChart.setCenterText(generateCenterSpannableText());
        //设置饼图左上右下的偏移量
        pieChart.setExtraOffsets(0.f, 0.f, 0.f, 0.f);
        //饼图是否空心
        pieChart.setDrawHoleEnabled(false);
        //饼图空心处的颜色
//        pieChart.setHoleColor(Color.WHITE);
        //饼图中心处阴影部分的颜色
//        pieChart.setTransparentCircleColor(Color.WHITE);
        //阴影部分的透明度（0-225）
//        pieChart.setTransparentCircleAlpha(110);
        //饼图上的标签颜色
//        pieChart.setEntryLabelColor(Color.BLACK);
        //饼图上标签可用性
        pieChart.setDrawEntryLabels(false);
        //饼图中心圆的半径
//        pieChart.setHoleRadius(60f);
        //饼图阴影部分圆的半径
//        pieChart.setTransparentCircleRadius(65f);
        //饼图中心文字可用性
//        pieChart.setDrawCenterText(true);
        //绘制饼图的起始点，默认为270度
        pieChart.setRotationAngle(270f);
        // 设置饼图是否可以被滑动
        pieChart.setRotationEnabled(true);
        //设置选中后是否高亮突出显示
        pieChart.setHighlightPerTapEnabled(false);

        // pieChart.setUnit(" €");
        // pieChart.setDrawUnitsInChart(true);

        // 添加选中监听
//        pieChart.setOnChartValueSelectedListener(this);

        setData(3, 100);

        // pieChart.spin(2000, 0, 360);

        Legend l = pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(false);
    }

    private void initPieData() {
        piePercent[0] = 47.3f;
        piePercent[1] = 20.2f;
        piePercent[2] = 32.5f;

    }

    private SpannableString generateCenterSpannableText() {

        SpannableString s = new SpannableString("120台\r\n功率1800kw");
        s.setSpan(new RelativeSizeSpan(1.5f), 0, 4, 0);
//        s.setSpan(new StyleSpan());
        s.setSpan(new StyleSpan(Typeface.DEFAULT_BOLD.getStyle()), 0, 4, 0);
        s.setSpan(new StyleSpan(Typeface.NORMAL), 4, s.length() - 5, 0);
        s.setSpan(new ForegroundColorSpan(Color.GRAY), 4, s.length() - 5, 0);
        s.setSpan(new RelativeSizeSpan(.65f), 4, s.length() - 6, 0);
        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 6, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(App.getApplication().getResources().getColor(R.color.red)), s.length() - 6, s.length(), 0);
        return s;
    }

    private void setData(int count, float range) {

        float mult = range;

        ArrayList<PieEntry> entries = new ArrayList<>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < count; i++) {
            entries.add(new PieEntry(piePercent[i], mParties[i]));
        }

        PieDataSet dataSet = new PieDataSet(entries, "Election Results");
        dataSet.setDrawValues(false);

        dataSet.setSliceSpace(0f);
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(getResources().getColor(R.color.pie_green));
        colors.add(getResources().getColor(R.color.pie_yellow));
        colors.add(getResources().getColor(R.color.pie_red));
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
        data.setValueTypeface(tf);
        pieChart.setData(data);

        // undo all highlights
        pieChart.highlightValues(null);

        pieChart.invalidate();
    }

    public String[] getDataSets() {
        String[] dataSets = {"峰电运行时间", "谷电运行时间", "平电运行时间"};
        return dataSets;
    }

    public int[] getColors() {
        Resources resources = getResources();
        int[] colors = {resources.getColor(R.color.pie_red), resources.getColor(R.color.pie_blue), resources.getColor(R.color.pie_orange)};
        return colors;
    }

    protected float getRandom(float range, float startsfrom) {
        return (float) (Math.random() * range) + startsfrom;
    }

    public List<BarEntry> getBarEntry1() {
        ArrayList<BarEntry> entries1 = new ArrayList<BarEntry>();

        for (int index = 0; index < 24; index++) {
            entries1.add(new BarEntry(0, getRandom(25, 25)));

        }
        return entries1;
    }
}
