package com.locensate.letnetwork.main.ui.dataanalysis;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.monitorinfo.RunningStateEntity;
import com.locensate.letnetwork.view.MyMarkerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 *  数据分析
 * @author xiaobinghe
 */

public class DataAnalysisActivity extends BaseActivity<DataAnalysisPresenter, DataAnalysisModel> implements DataAnalysisContract.View, OnChartValueSelectedListener {

    @BindView(R.id.iv_title_only_back)
    ImageView ivTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView tvTitleOnlyBack;
    @BindView(R.id.up_down)
    ImageView upDown;
    @BindView(R.id.time_type_content)
    TextView timeTypeContent;
    @BindView(R.id.time_type)
    FrameLayout timeType;
    @BindView(R.id.tv_time_value)
    TextView tvTimeValue;
    @BindView(R.id.time_value)
    LinearLayout timeValue;
    @BindView(R.id.tv_label)
    TextView tvLabel;
    @BindView(R.id.lc_line_data_analysis)
    LineChart lcLineDataAnalysis;
    private LineDataSet dataSetByIndex;
    private RunningStateEntity parameter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_data_analysis;
    }


    @Override
    public void initView() {
        parameter = (RunningStateEntity) getIntent().getExtras().getSerializable("parameter");
        tvTitleOnlyBack.setText(parameter.getKey());
        ivTitleOnlyBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvLabel.setText(parameter.getKey());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.e(TAG, "DataAnalysis destroy!");

    }

    private void fillLineData(List<Entry> data) {
        // 设置描述是否可用
        lcLineDataAnalysis.getDescription().setEnabled(false);

        // 设置触摸手势可用
        lcLineDataAnalysis.setTouchEnabled(true);

        //滑动摩擦系数
        lcLineDataAnalysis.setDragDecelerationFrictionCoef(0.9f);

        // enable scaling and dragging
        lcLineDataAnalysis.setDragEnabled(true);
        lcLineDataAnalysis.setScaleEnabled(true);
        lcLineDataAnalysis.setDrawGridBackground(false);
        lcLineDataAnalysis.setHighlightPerDragEnabled(true);

        lcLineDataAnalysis.animateX(2000);
        // if disabled, scaling can be done on x- and y-axis separately
        lcLineDataAnalysis.setPinchZoom(true);

        // set an alternative background color
        lcLineDataAnalysis.setBackgroundColor(getResources().getColor(R.color.white));

        // add data
        setLineData(data);

        lcLineDataAnalysis.animateX(2500);

        // get the legend (only possible after setting data)图例
        Legend l = lcLineDataAnalysis.getLegend();

        l.setEnabled(false);
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

        XAxis xAxis = lcLineDataAnalysis.getXAxis();
//        xAxis.setTypeface(mTfLight);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(10f);
        xAxis.setAxisMaximum(data.size());
        xAxis.setAxisMinimum(1);
        xAxis.setTextColor(getResources().getColor(R.color.font_content));
        xAxis.setDrawGridLines(true);
        xAxis.setDrawAxisLine(true);

        YAxis leftAxis = lcLineDataAnalysis.getAxisLeft();
//        leftAxis.setTypeface(mTfLight);
        leftAxis.setTextColor(getResources().getColor(R.color.font_content));
        float temp = 0f;
        for (int i = 0; i < data.size(); i++) {
            if (temp < data.get(i).getY())
                temp = data.get(i).getY();
        }
        leftAxis.setAxisMaximum(temp + temp / 5);
        leftAxis.setDrawAxisLine(true);
        leftAxis.setAxisMinimum(0f);
        leftAxis.setDrawGridLines(true);
        leftAxis.setGranularityEnabled(true);

        YAxis rightAxis = lcLineDataAnalysis.getAxisRight();
//        rightAxis.setTypeface(mTfLight);
        rightAxis.setTextColor(getResources().getColor(R.color.font_content));
        rightAxis.setAxisMaximum(0f);
        rightAxis.setAxisMinimum(0f);
        rightAxis.setDrawGridLines(false);
        rightAxis.setDrawZeroLine(false);
        rightAxis.setGranularityEnabled(false);
    }


    private void setLineData(List<Entry> data) {


        if (lcLineDataAnalysis.getData() != null &&
                lcLineDataAnalysis.getData().getDataSetCount() > 0) {
            dataSetByIndex = (LineDataSet) lcLineDataAnalysis.getData().getDataSetByIndex(0);
            dataSetByIndex.setValues(data);
            lcLineDataAnalysis.getData().notifyDataChanged();
            lcLineDataAnalysis.notifyDataSetChanged();
        } else {
            // create a dataset and give it a type
            dataSetByIndex = new LineDataSet(data, parameter.getKey());
            // set the line to be drawn like this "- - - - - -"
            dataSetByIndex.setLineWidth(1.5f);
            dataSetByIndex.setDrawCircles(false);
            dataSetByIndex.setHighLightColor(getResources().getColor(R.color.line_yellow));
            dataSetByIndex.setDrawValues(false);
            dataSetByIndex.setColor(getResources().getColor(R.color.line_yellow));
            dataSetByIndex.setDrawCircleHole(false);
            dataSetByIndex.setMode(LineDataSet.Mode.LINEAR);
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(dataSetByIndex); // add the datasets

            // create a data object with the datasets
            LineData lineData = new LineData(dataSets);

            // set data
            lcLineDataAnalysis.setData(lineData);
            lcLineDataAnalysis.animateX(3000);
            lcLineDataAnalysis.getDescription().setEnabled(false);
            MyMarkerView mv = new MyMarkerView(this, R.layout.custom_marker_view);
            mv.setChartView(lcLineDataAnalysis); // For bounds control
            lcLineDataAnalysis.setMarker(mv); // Set the marker to the chart

            // TODO: 2017/1/10 设置x轴在下方展示
            XAxis xAxis = lcLineDataAnalysis.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        }


    }

    @Override
    public void initData(List<Entry> data) {
        fillLineData(data);

    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}
