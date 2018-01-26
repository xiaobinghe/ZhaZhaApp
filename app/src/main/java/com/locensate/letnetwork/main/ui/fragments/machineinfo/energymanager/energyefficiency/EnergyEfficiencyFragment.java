package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyefficiency;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseFragment;
import com.locensate.letnetwork.main.ui.EnlargeEnergyEfficiency;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 * @author xiaobinghe
 */

public class EnergyEfficiencyFragment extends BaseFragment<EnergyEfficiencyPresenter, EnergyEfficiencyModel> implements EnergyEfficiencyContract.View {

    @BindView(R.id.tv_energy_current_efficiency)
    TextView tvEnergyCurrentEfficiency;
    @BindView(R.id.tv_energy_average_efficiency)
    TextView tvEnergyAverageEfficiency;
    @BindView(R.id.pie_energy_efficiency)
    PieChart pieEfficiency;
    @BindView(R.id.tv_energy_efficiency_time1)
    TextView tvEnergyEfficiencyTime1;
    @BindView(R.id.tv_energy_efficiency_percent1)
    TextView tvEnergyEfficiencyPercent1;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.tv_energy_efficiency_time2)
    TextView tvEnergyEfficiencyTime2;
    @BindView(R.id.tv_energy_efficiency_percent2)
    TextView tvEnergyEfficiencyPercent2;
    @BindView(R.id.tv_energy_efficiency_time3)
    TextView tvEnergyEfficiencyTime3;
    @BindView(R.id.tv_energy_efficiency_percent3)
    TextView tvEnergyEfficiencyPercent3;
    @BindView(R.id.tv_energy_efficiency_time4)
    TextView tvEnergyEfficiencyTime4;
    @BindView(R.id.tv_energy_efficiency_percent4)
    TextView tvEnergyEfficiencyPercent4;
    @BindView(R.id.lc_energy_efficiency)
    LineChart lineEfficiency;
    @BindView(R.id.ll_energy_lose_electric)
    LinearLayout llEnergyLoseElectric;
    @BindView(R.id.iv_switch)
    ImageView ivSwitch;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EnergyEfficiencyFragment.
     */
    /*public static EnergyEfficiencyFragment newInstance() {
        if (null == sFragment) {
            sFragment = new EnergyEfficiencyFragment();
            Bundle args = new Bundle();
            sFragment.setArguments(args);
        }
        return sFragment;
    }*/
    @Override
    public int getInflaterView() {
        return R.layout.fragment_energy_efficiency;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void initView() {
        initPieData();
        initLineData();
    }

    private void initPieData() {
        pieEfficiency.setUsePercentValues(true);
        //添加饼图的描述是否可用
        pieEfficiency.getDescription().setEnabled(false);
//        //添加饼图描述
//        Description desc = new Description();
//        //设置饼图描述的内容
//        desc.setText("画饼充饥");
//        //描述内容显示的位置有left，right，center可供选择
//        desc.setTextAlign(Paint.Align.CENTER);
//        //设置饼图描述
//        pieEfficiency.setDescription(desc);

//        pieEfficiency.setExtraOffsets(5, 10, 5, 5);

        pieEfficiency.setDragDecelerationEnabled(true);

//        pieEfficiency.setDrawSliceText(false);

        //设置滑动摩擦系数
        pieEfficiency.setDragDecelerationFrictionCoef(0.98f);

        //字体类型
//        tf = Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Regular.ttf");

        //设置中心显示的文字类型
//        pieEfficiency.setCenterTextTypeface(Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Light.ttf"));
        //设置中心显示的文字
//        pieEfficiency.setCenterText(generateCenterSpannableText());
        //设置饼图左上右下的偏移量
        pieEfficiency.setExtraOffsets(0.f, 0.f, 0.f, 0.f);
        //饼图是否空心
        pieEfficiency.setDrawHoleEnabled(false);
        //饼图空心处的颜色
//        pieEfficiency.setHoleColor(Color.WHITE);
        //饼图中心处阴影部分的颜色
//        pieEfficiency.setTransparentCircleColor(Color.WHITE);
        //阴影部分的透明度（0-225）
//        pieEfficiency.setTransparentCircleAlpha(110);
        //饼图上的标签颜色
//        pieEfficiency.setEntryLabelColor(Color.BLACK);
        //饼图上标签可用性
        pieEfficiency.setDrawEntryLabels(false);
        //饼图中心圆的半径
//        pieEfficiency.setHoleRadius(60f);
        //饼图阴影部分圆的半径
//        pieEfficiency.setTransparentCircleRadius(65f);
        //饼图中心文字可用性
//        pieEfficiency.setDrawCenterText(true);
        //绘制饼图的起始点，默认为270度
        pieEfficiency.setRotationAngle(270f);
        // 设置饼图是否可以被滑动
        pieEfficiency.setRotationEnabled(true);
        //设置选中后是否高亮突出显示
        pieEfficiency.setHighlightPerTapEnabled(false);

        // pieEfficiency.setUnit(" €");
        // pieEfficiency.setDrawUnitsInChart(true);

        // 添加选中监听


        // TODO: 2017/6/27 set Data

        pieEfficiency.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // pieEfficiency.spin(2000, 0, 360);

        Legend l = pieEfficiency.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(false);
    }

    private void initLineData() {
        // 设置描述是否可用
        lineEfficiency.getDescription().setEnabled(false);

        // 设置触摸手势可用
        lineEfficiency.setTouchEnabled(true);

        //滑动摩擦系数
        lineEfficiency.setDragDecelerationFrictionCoef(0.9f);

        // enable scaling and dragging
        lineEfficiency.setDragEnabled(true);
        lineEfficiency.setScaleEnabled(true);
        lineEfficiency.setDrawGridBackground(false);
        lineEfficiency.setHighlightPerDragEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        lineEfficiency.setPinchZoom(true);

        // set an alternative background color
        lineEfficiency.setBackgroundColor(getResources().getColor(R.color.white));

        // add data
//        setLineData(getDataSets(), getEntry1(), getEntry2(), getEntry3(), getColors());

        lineEfficiency.animateX(2500);

        // get the legend (only possible after setting data)
        Legend l = lineEfficiency.getLegend();

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


    }


    @Override
    public void setPieData(ArrayList<PieEntry> pieData) {


        PieDataSet dataSet = new PieDataSet(pieData, "Election Results");
        dataSet.setDrawValues(false);

        dataSet.setSliceSpace(0f);
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<>();
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
        pieEfficiency.setData(data);

        // undo all highlights
        pieEfficiency.highlightValues(null);

        pieEfficiency.invalidate();
    }


    @Override
    public void setLineData(List<List<Entry>> lineData, String[] lineLabels) {
        List<Entry> entries1 = lineData.get(0);
        List<Entry> entries2 = lineData.get(1);
        List<Entry> entries3 = lineData.get(2);


        XAxis xAxis = lineEfficiency.getXAxis();
//        xAxis.setTypeface(mTfLight);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(10f);
        xAxis.setAxisMaximum(entries1.size());
        xAxis.setAxisMinimum(0);
        xAxis.setTextColor(getResources().getColor(R.color.font_content));
        xAxis.setDrawGridLines(true);
        xAxis.setDrawAxisLine(true);

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Light.ttf");

        YAxis leftAxis = lineEfficiency.getAxisLeft();
//        leftAxis.setTypeface(mTfLight);
        leftAxis.setTextColor(getResources().getColor(R.color.font_content));
        leftAxis.setTypeface(tf);
        leftAxis.setAxisMaximum(5.0f);
        leftAxis.setAxisMinimum(-0.0f);
        leftAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return String.valueOf(value / 5);
            }
        });
        leftAxis.setDrawGridLines(true);
        leftAxis.setDrawAxisLine(true);
        leftAxis.setGranularityEnabled(true);

        YAxis rightAxis = lineEfficiency.getAxisRight();
//        rightAxis.setTypeface(mTfLight);
        rightAxis.setTextColor(Color.RED);
        rightAxis.setAxisMaximum(0);
        rightAxis.setAxisMinimum(0);
        rightAxis.setDrawGridLines(false);
        rightAxis.setDrawZeroLine(false);
        rightAxis.setGranularityEnabled(false);

        LineDataSet set1, set2, set3;

        if (lineEfficiency.getData() != null &&
                lineEfficiency.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) lineEfficiency.getData().getDataSetByIndex(0);
            set2 = (LineDataSet) lineEfficiency.getData().getDataSetByIndex(1);
            set3 = (LineDataSet) lineEfficiency.getData().getDataSetByIndex(2);
            set1.setValues(entries1);
            set2.setValues(lineData.get(1));
            set3.setValues(lineData.get(2));
            lineEfficiency.getData().notifyDataChanged();
            lineEfficiency.notifyDataSetChanged();
        } else {
            // create a dataset and give it a type
            set1 = new LineDataSet(entries1, lineLabels[0]);

            set1.setAxisDependency(YAxis.AxisDependency.LEFT);
            set1.setColor(getColors()[0]);
            set1.setCircleColor(getColors()[0]);
            set1.setLineWidth(1.5f);
            set1.setFillAlpha(65);
            set1.setDrawCircles(false);
            set1.setDrawValues(false);
            set1.setFillColor(ColorTemplate.getHoloBlue());
            set1.setHighLightColor(Color.rgb(244, 117, 117));
            set1.setDrawCircleHole(false);
            //set1.setFillFormatter(new MyFillFormatter(0f));
            //set1.setDrawHorizontalHighlightIndicator(false);
            //set1.setVisible(false);
            //set1.setCircleHoleColor(Color.WHITE);

            // create a dataset and give it a type
            set2 = new LineDataSet(entries2, lineLabels[1]);
            set2.setAxisDependency(YAxis.AxisDependency.LEFT);
            set2.setColor(getColors()[1]);
            set2.setCircleColor(getColors()[1]);
            set2.setLineWidth(1.5f);
            set2.setDrawCircles(false);
            set2.setDrawValues(false);
            set2.setFillAlpha(65);
            set2.setFillColor(getColors()[1]);
            set2.setDrawCircleHole(false);
//            set2.setHighLightColor(Color.rgb(244, 117, 117));
            //set2.setFillFormatter(new MyFillFormatter(900f));

            set3 = new LineDataSet(entries3, lineLabels[2]);
            set3.setAxisDependency(YAxis.AxisDependency.LEFT);
            set3.setColor(getColors()[2]);
            set3.setCircleColor(getColors()[2]);
            set3.setLineWidth(1.5f);
            set3.setDrawCircles(false);
            set3.setDrawValues(false);
            set3.setFillAlpha(65);
            set3.setFillColor(ColorTemplate.colorWithAlpha(Color.YELLOW, 200));
            set3.setDrawCircleHole(false);
//            set3.setHighLightColor(Color.rgb(244, 117, 117));

            // create a data object with the datasets
            LineData data = new LineData(set1, set2, set3);
            data.setValueTextColor(Color.WHITE);
            data.setValueTextSize(10f);

            // set data
            lineEfficiency.setData(data);
        }
    }

    public int[] getColors() {
        Resources resources = getResources();
        int[] colors = {resources.getColor(R.color.pie_red), resources.getColor(R.color.pie_blue), resources.getColor(R.color.pie_orange)};
        return colors;
    }

    @OnClick(R.id.iv_switch)
    public void onClick() {
        startActivity(new Intent(getActivity(), EnlargeEnergyEfficiency.class));
    }
}
