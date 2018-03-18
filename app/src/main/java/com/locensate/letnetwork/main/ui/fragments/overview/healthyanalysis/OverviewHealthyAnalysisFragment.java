package com.locensate.letnetwork.main.ui.fragments.overview.healthyanalysis;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseFragment;
import com.locensate.letnetwork.main.ui.MachineListActivity;
import com.locensate.letnetwork.main.ui.fragments.overview.OverviewFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author xiaobinghe
 */


public class OverviewHealthyAnalysisFragment extends BaseFragment<OverviewHealthyAnalysisPresenter, OverviewHealthyAnalysisModel> implements OverviewHealthyAnalysisContract.View, OnChartValueSelectedListener {
    @BindView(R.id.pie_overview_contain)
    PieChart pieChart;
    @BindView(R.id.imageView2)
    ImageView mImageView2;
    @BindView(R.id.imageView)
    ImageView mImageView;
    @BindView(R.id.ll_health)
    LinearLayout mLlHealth;
    @BindView(R.id.ll_good)
    LinearLayout mLlGood;
    @BindView(R.id.ll_worse)
    LinearLayout mLlWorse;
    @BindView(R.id.ll_worst)
    LinearLayout mLlWorst;
    @BindView(R.id.tv_best_rate)
    TextView mTvBestRate;
    @BindView(R.id.tv_best_count)
    TextView mTvBestCount;
    @BindView(R.id.tv_best_rate_power)
    TextView mTvBestRatePower;
    @BindView(R.id.tv_better_rate)
    TextView mTvBetterRate;
    @BindView(R.id.tv_better_count)
    TextView mTvBetterCount;
    @BindView(R.id.tv_better_rate_power)
    TextView mTvBetterRatePower;
    @BindView(R.id.tv_worse_rate)
    TextView mTvWorseRate;
    @BindView(R.id.tv_worse_count)
    TextView mTvWorseCount;
    @BindView(R.id.tv_worse_rate_power)
    TextView mTvWorseRatePower;
    @BindView(R.id.tv_worst_rate)
    TextView mTvWorstRate;
    @BindView(R.id.tv_worst_count)
    TextView mTvWorstCount;
    @BindView(R.id.tv_worst_rate_power)
    TextView mTvWorstRatePower;

    private Typeface tf;
    private String[] mParties = new String[]{"健康", "较好", "较差", "差"};
    private int organizationId = 1;
    private long startMills;
    private long endMills;


//    private String range = SpUtil.getString(App.getApplication(), Constant.ENTERPRISE_NAME, "");

   /* public static OverviewHealthyAnalysisFragment getInstance(String range) {
        if (null == overviewHealthyAnalysisFragment) {
            overviewHealthyAnalysisFragment = new OverviewHealthyAnalysisFragment();
            Bundle bundle = new Bundle();
            bundle.putString("range", range);
            overviewHealthyAnalysisFragment.setArguments(bundle);
        }
        return overviewHealthyAnalysisFragment;
    }*/


    @Override
    public int getInflaterView() {
        return R.layout.fragment_overview_healthy_analysis;
    }

    @Override
    protected void initView() {
        initChartConfig();
    }

    @Override
    protected void onVisible() {

    }

    @Override
    protected void lazyLoad() {

    }


    public void initChartConfig() {

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setNoDataText("暂无数据");
//        Description desc = new Description();
//        desc.setText("we are super man");
//        pieChart.setDescription(desc);
//        pieChart.setExtraOffsets(5, 10, 5, 5);

        tf = Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Regular.ttf");
        pieChart.setDragDecelerationFrictionCoef(0.98f);
        pieChart.setDragDecelerationEnabled(true);

        pieChart.setCenterTextTypeface(Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Light.ttf"));
        pieChart.setDrawSliceText(false);
        pieChart.setRotationAngle(270f);
        pieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);


        pieChart.setExtraOffsets(0.f, 0.f, 0.f, 0.f);
        pieChart.setDrawEntryLabels(false);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);

        pieChart.setTransparentCircleColor(Color.WHITE);
        pieChart.setTransparentCircleAlpha(110);

        pieChart.setEntryLabelColor(Color.BLACK);

        pieChart.setHoleRadius(60f);
        pieChart.setTransparentCircleRadius(65f);

        pieChart.setDrawCenterText(true);

        pieChart.setCenterText("健康");
        pieChart.setCenterTextSize(16f);

//        pieChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        pieChart.setRotationEnabled(true);
        pieChart.setHighlightPerTapEnabled(false);

        // pieChart.setUnit(" €");
        // pieChart.setDrawUnitsInChart(true);

        // add a selection listener
        pieChart.setOnChartValueSelectedListener(this);
        pieChart.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                return false;
            }
        });
//         pieChart.spin(2000, 0, 360);

        Legend l = pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(false);
    }


    @Override
    public void setNumData(String[] counts, String[] powerRates, String[] countRate) {
        mTvBestRate.setText(countRate[0]);
        mTvBestCount.setText(counts[0]);
        mTvBestRatePower.setText(powerRates[0]);
        mTvBetterRate.setText(countRate[1]);
        mTvBetterCount.setText(counts[1]);
        mTvBetterRatePower.setText(powerRates[1]);
        mTvWorseRate.setText(countRate[2]);
        mTvWorseCount.setText(counts[2]);
        mTvWorseRatePower.setText(powerRates[2]);
        mTvWorstRate.setText(countRate[3]);
        mTvWorstCount.setText(counts[3]);
        mTvWorstRatePower.setText(powerRates[3]);
    }

    @Override
    public void setNoData() {
        mTvBestRate.setText("——");
        mTvBestCount.setText("——");
        mTvBestRatePower.setText("——");
        mTvBetterRate.setText("——");
        mTvBetterCount.setText("——");
        mTvBetterRatePower.setText("——");
        mTvWorseRate.setText("——");
        mTvWorseCount.setText("——");
        mTvWorseRatePower.setText("——");
        mTvWorstRate.setText("——");
        mTvWorstCount.setText("——");
        mTvWorstRatePower.setText("——");
    }

    @Override
    public void setData(ArrayList<PieEntry> entries) {

        PieDataSet dataSet = new PieDataSet(entries, "Election Results");

        dataSet.setSliceSpace(0f);
        dataSet.setSelectionShift(5f);


        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<Integer>();

        colors.add(getResources().getColor(R.color.pie_green));
        colors.add(getResources().getColor(R.color.pie_yellow));
        colors.add(getResources().getColor(R.color.pie_orange));
        colors.add(getResources().getColor(R.color.pie_red));
        dataSet.setDrawValues(false);
        dataSet.setColors(colors);
        //dataSet.setSelectionShift(0f);

        dataSet.setValueLinePart1OffsetPercentage(80.f);
        dataSet.setValueLinePart1Length(0.2f);
        dataSet.setValueLinePart2Length(0.4f);
        //dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.BLACK);
        data.setValueTypeface(tf);
        pieChart.setData(data);
        // undo all highlights
        pieChart.highlightValues(null);
        pieChart.invalidate();
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    @OnClick({R.id.ll_health, R.id.ll_good, R.id.ll_worse, R.id.ll_worst})
    public void onViewClicked(View view) {
        if (true) {
            return;
        }
        String filter;
        String status;
        switch (view.getId()) {
            case R.id.ll_health:
                filter = "health";
                status = mParties[0];
                break;
            case R.id.ll_good:
                filter = "good";
                status = mParties[1];
                break;
            case R.id.ll_worse:
                filter = "worse";
                status = mParties[2];
                break;
            case R.id.ll_worst:
                filter = "worst";
                status = mParties[3];
                break;
            default:
                filter = "health";
                status = mParties[0];
                break;
        }

        Intent intent = new Intent(App.getApplication(), MachineListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("filter", filter);
        bundle.putString("ranges", OverviewFragment.mGroupName);
        bundle.putString("status", status);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void acceptOrganizationId(int organizationId, long startMills, long endMills) {
        this.organizationId = organizationId;
        this.startMills = startMills;
        this.endMills = endMills;
        if (null != mPresenter) {
            mPresenter.requestData(organizationId, startMills, endMills);
        }
    }

    @Override
    public int getOrganizationId() {
        return organizationId;
    }

    @Override
    public long getStartMills() {
        return startMills;
    }

    @Override
    public long getEndMills() {
        return endMills;
    }
}
