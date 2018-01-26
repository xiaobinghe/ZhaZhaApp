package com.locensate.letnetwork.main.ui;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.utils.LogUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *  
 * @author xiaobinghe
 */

public class EnlargeEnergyEfficiency extends BaseActivity {

    @BindView(R.id.iv_title_only_back)
    ImageView ivTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView tvTitleOnlyBack;
    @BindView(R.id.lc_energy_efficiency)
    LineChart lineChart;
    @BindView(R.id.ll_energy_lose_electric)
    LinearLayout llEnergyLoseElectric;
    @BindView(R.id.activity_enlager_energy_efficiency)
    LinearLayout activityEnlagerEnergyEfficiency;

    @Override
    public int getLayoutId() {
        LogUtil.e(TAG, String.valueOf(this.getTaskId()));
        return R.layout.activity_enlager_energy_efficiency;
    }

    @Override
    public void initView() {
        tvTitleOnlyBack.setText("效率分析");
        fillLineData();
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

        // if disabled, scaling can be done on x- and y-axis separately
        lineChart.setPinchZoom(true);

        // set an alternative background color
        lineChart.setBackgroundColor(getResources().getColor(R.color.white));

        // TODO: 2017/6/22 添加数据
        // add data
        setLineData(getDataSets(), getEntry1(), getEntry2(), getEntry3(), getColors());

        lineChart.animateX(2500);

        // get the legend (only possible after setting data)
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
        xAxis.setAxisMaximum(getEntry1().size());
        xAxis.setAxisMinimum(0);
        xAxis.setTextColor(getResources().getColor(R.color.font_content));
        xAxis.setDrawGridLines(true);
        xAxis.setDrawAxisLine(true);

        Typeface tf = Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf");

        YAxis leftAxis = lineChart.getAxisLeft();
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

        YAxis rightAxis = lineChart.getAxisRight();
//        rightAxis.setTypeface(mTfLight);
        rightAxis.setTextColor(Color.RED);
        rightAxis.setAxisMaximum(0);
        rightAxis.setAxisMinimum(0);
        rightAxis.setDrawGridLines(false);
        rightAxis.setDrawZeroLine(false);
        rightAxis.setGranularityEnabled(false);
    }

    private String[] getDataSets() {
        String[] dataSets = {"运行效率", "合理运行界定值", "经济运行界定值"};
        return dataSets;
    }

    public int[] getColors() {
        Resources resources = getResources();
        int[] colors = {resources.getColor(R.color.pie_red), resources.getColor(R.color.pie_blue), resources.getColor(R.color.pie_orange)};
        return colors;
    }

    private ArrayList<Entry> getEntry3() {

        ArrayList<Entry> data3 = new ArrayList<Entry>();

        for (int i = 0; i < 300; i++) {
            float val = 0.9f * 5;
            data3.add(new Entry(i, val));
        }

        return data3;
    }

    private ArrayList<Entry> getEntry2() {
        ArrayList<Entry> data2 = new ArrayList<Entry>();

        for (int i = 0; i < 300; i++) {
            float val = 0.5f * 5;
            data2.add(new Entry(i, val));
//            if(i == 10) {
//                yVals2.add(new Entry(i, val + 50));
//            }
        }
        return data2;
    }

    private ArrayList<Entry> getEntry1() {
        ArrayList<Entry> data1 = new ArrayList<Entry>();

        for (int i = 0; i < 300; i++) {
            float val = (float) (Math.random() + 1) / 2;
            data1.add(new Entry(i, val * 5));
        }
        return data1;
    }

    private void setLineData(String[] dataSets, ArrayList<Entry> entries1, ArrayList<Entry> entries2, ArrayList<Entry> entries3, int[] dataColors) {


        LineDataSet set1, set2, set3;

        if (lineChart.getData() != null &&
                lineChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) lineChart.getData().getDataSetByIndex(0);
            set2 = (LineDataSet) lineChart.getData().getDataSetByIndex(1);
            set3 = (LineDataSet) lineChart.getData().getDataSetByIndex(2);
            set1.setValues(entries1);
            set2.setValues(entries2);
            set3.setValues(entries3);
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
            set1.setDrawValues(false);
            set1.setFillColor(ColorTemplate.getHoloBlue());
            set1.setHighLightColor(Color.rgb(244, 117, 117));
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
//            set3.setHighLightColor(Color.rgb(244, 117, 117));

            // create a data object with the datasets
            LineData data = new LineData(set1, set2, set3);
            data.setValueTextColor(Color.WHITE);
            data.setValueTextSize(10f);

            // set data
            lineChart.setData(data);
        }
    }

    @OnClick(R.id.iv_title_only_back)
    public void onClick() {
        finish();
    }
}
