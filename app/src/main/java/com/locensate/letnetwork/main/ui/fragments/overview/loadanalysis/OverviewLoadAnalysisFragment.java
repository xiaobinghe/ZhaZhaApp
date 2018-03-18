package com.locensate.letnetwork.main.ui.fragments.overview.loadanalysis;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
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


public class OverviewLoadAnalysisFragment extends BaseFragment<OverviewLoadAnalysisPresenter, OverviewLoadAnalysisModel> implements OverviewLoadAnalysisContract.View, OnChartValueSelectedListener {
    @BindView(R.id.pie_overview_contain)
    PieChart pieOverviewContain;
    @BindView(R.id.ll_empty)
    LinearLayout mLlEmpty;
    @BindView(R.id.ll_light)
    LinearLayout mLlLight;
    @BindView(R.id.ll_half)
    LinearLayout mLlHalf;
    @BindView(R.id.ll_heavy)
    LinearLayout mLlHeavy;
    @BindView(R.id.ll_over)
    LinearLayout mLlOver;
    @BindView(R.id.ll_stop)
    LinearLayout mLlStop;
    @BindView(R.id.tv_no_load_rate)
    TextView mTvNoLoadRate;
    @BindView(R.id.tv_no_load_count)
    TextView mTvNoLoadCount;
    @BindView(R.id.tv_no_load_power_rate)
    TextView mTvNoLoadPowerRate;
    @BindView(R.id.tv_light_load_rate)
    TextView mTvLightLoadRate;
    @BindView(R.id.tv_light_load_count)
    TextView mTvLightLoadCount;
    @BindView(R.id.tv_light_load_power_rate)
    TextView mTvLightLoadPowerRate;
    @BindView(R.id.tv_half_load_rate)
    TextView mTvHalfLoadRate;
    @BindView(R.id.tv_half_load_count)
    TextView mTvHalfLoadCount;
    @BindView(R.id.tv_half_load_power_rate)
    TextView mTvHalfLoadPowerRate;
    @BindView(R.id.tv_heavy_load_rate)
    TextView mTvHeavyLoadRate;
    @BindView(R.id.tv_heavy_load_count)
    TextView mTvHeavyLoadCount;
    @BindView(R.id.tv_heavy_load_power_rate)
    TextView mTvHeavyLoadPowerRate;
    @BindView(R.id.tv_over_load_rate)
    TextView mTvOverLoadRate;
    @BindView(R.id.tv_over_load_count)
    TextView mTvOverLoadCount;
    @BindView(R.id.tv_over_load_power_rate)
    TextView mTvOverLoadPowerRate;
    @BindView(R.id.tv_stop_load_rate)
    TextView mTvStopLoadRate;
    @BindView(R.id.tv_stop_load_count)
    TextView mTvStopLoadCount;
    @BindView(R.id.tv_stop_load_power_rate)
    TextView mTvStopLoadPowerRate;

    private Typeface tf;
    private String[] mParties = new String[]{"空载", "轻载", "半载", "重载", "过载", "停止"};
    //private String[] mParties = new String[]{"0-20%", "20-40%", "40-60%", "60-80%", "80-100%", "100%以上"};
    private int organizationId;
    private long startMills;
    private long endMills;

    /*public static OverviewLoadAnalysisFragment getInstance(String range) {
        if (null == overviewLoadAnalysisFragment) {
            overviewLoadAnalysisFragment = new OverviewLoadAnalysisFragment();
            Bundle bundle = new Bundle();
            bundle.putString("range", range);
            overviewLoadAnalysisFragment.setArguments(bundle);
        }
        return overviewLoadAnalysisFragment;
    }*/

    @Override
    public int getInflaterView() {
        return R.layout.fragment_overview_load;
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

    private void initChartConfig() {
        pieOverviewContain.setUsePercentValues(true);
        pieOverviewContain.getDescription().setEnabled(false);
        pieOverviewContain.setNoDataText("暂无数据");
//        Description desc = new Description();
//        desc.setText("we are super man");
//        pieOverviewContain.setDescription(desc);
//        pieOverviewContain.setExtraOffsets(5, 10, 5, 5);
        pieOverviewContain.setDragDecelerationFrictionCoef(0.98f);

        tf = Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Regular.ttf");

        pieOverviewContain.setCenterTextTypeface(Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Light.ttf"));
//        pieOverviewContain.setCenterText(generateCenterSpannableText());

        pieOverviewContain.setExtraOffsets(0.f, 0.f, 0.f, 0.f);
        pieOverviewContain.setDrawHoleEnabled(true);
        pieOverviewContain.setHoleColor(Color.WHITE);

        pieOverviewContain.setDrawSliceText(false);
        pieOverviewContain.setTransparentCircleColor(Color.WHITE);
        pieOverviewContain.setTransparentCircleAlpha(110);

        pieOverviewContain.setEntryLabelColor(Color.BLACK);

        pieOverviewContain.setHoleRadius(60f);
        pieOverviewContain.setTransparentCircleRadius(65f);

        pieOverviewContain.setDrawCenterText(true);

        pieOverviewContain.setRotationAngle(0);
        // enable rotation of the chart by touch
        pieOverviewContain.setRotationEnabled(true);
        pieOverviewContain.setHighlightPerTapEnabled(false);
//        pieOverviewContain.setCenterText(generateCenterSpannableText());
        pieOverviewContain.setCenterText("负载");
        pieOverviewContain.setCenterTextSize(16f);

        pieOverviewContain.setRotationAngle(270f);
        // pieOverviewContain.setUnit(" €");
        // pieOverviewContain.setDrawUnitsInChart(true);

        // add a selection listener
        pieOverviewContain.setOnChartValueSelectedListener(this);

        pieOverviewContain.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // pieOverviewContain.spin(2000, 0, 360);

        Legend l = pieOverviewContain.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(false);
    }

    @Override
    public void setData(ArrayList<PieEntry> entries) {

        PieDataSet dataSet = new PieDataSet(entries, "Election Results");
        dataSet.setSliceSpace(0f);
        dataSet.setSelectionShift(5f);
        // add a lot of colors
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(getResources().getColor(R.color.pie_orange));
        colors.add(getResources().getColor(R.color.pie_yellow));
        colors.add(getResources().getColor(R.color.pie_blue));
        colors.add(getResources().getColor(R.color.pie_green));
        colors.add(getResources().getColor(R.color.pie_red));
        colors.add(getResources().getColor(R.color.pie_gray));

        dataSet.setColors(colors);
        //dataSet.setSelectionShift(0f);

        dataSet.setValueLinePart1OffsetPercentage(80.f);
        dataSet.setValueLinePart1Length(0.2f);
        dataSet.setDrawValues(false);
        dataSet.setValueLinePart2Length(0.4f);
        //dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.BLACK);
        data.setValueTypeface(tf);
        pieOverviewContain.setData(data);

        // undo all highlights
        pieOverviewContain.highlightValues(null);

        pieOverviewContain.invalidate();
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    @OnClick({R.id.ll_empty, R.id.ll_light, R.id.ll_half, R.id.ll_heavy, R.id.ll_over, R.id.ll_stop})
    public void onViewClicked(View view) {
        if (true){
            return;
        }
        String filter;
        String status;
        switch (view.getId()) {
            case R.id.ll_empty:
                filter = "empty";
                status = mParties[0];
                break;
            case R.id.ll_light:
                filter = "light";
                status = mParties[1];

                break;
            case R.id.ll_half:
                filter = "half";
                status = mParties[2];

                break;
            case R.id.ll_heavy:
                filter = "heavy";
                status = mParties[3];

                break;
            case R.id.ll_over:
                filter = "over";
                status = mParties[4];

                break;
            case R.id.ll_stop:
                filter = "stop";
                status = mParties[5];

                break;
            default:
                filter = "empty";
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

    @Override
    public void setNumData(String[] counts, String[] powerRates, String[] countRate) {
        mTvNoLoadCount.setText(counts[0]);
        mTvNoLoadPowerRate.setText(powerRates[0]);
        mTvNoLoadRate.setText(countRate[0]);
        mTvLightLoadCount.setText(counts[1]);
        mTvLightLoadPowerRate.setText(powerRates[1]);
        mTvLightLoadRate.setText(countRate[1]);
        mTvHalfLoadCount.setText(counts[2]);
        mTvHalfLoadPowerRate.setText(powerRates[2]);
        mTvHalfLoadRate.setText(countRate[2]);
        mTvHeavyLoadCount.setText(counts[3]);
        mTvHeavyLoadPowerRate.setText(powerRates[3]);
        mTvHeavyLoadRate.setText(countRate[3]);
        mTvOverLoadCount.setText(counts[4]);
        mTvOverLoadPowerRate.setText(powerRates[4]);
        mTvOverLoadRate.setText(countRate[4]);
        mTvStopLoadCount.setText(counts[5]);
        mTvStopLoadPowerRate.setText(powerRates[5]);
        mTvStopLoadRate.setText(countRate[5]);
    }

    @Override
    public void setNoData() {
        mTvNoLoadCount.setText("——");
        mTvNoLoadPowerRate.setText("——");
        mTvNoLoadRate.setText("——");
        mTvLightLoadCount.setText("——");
        mTvLightLoadPowerRate.setText("——");
        mTvLightLoadRate.setText("——");
        mTvHalfLoadCount.setText("——");
        mTvHalfLoadPowerRate.setText("——");
        mTvHalfLoadRate.setText("——");
        mTvHeavyLoadCount.setText("——");
        mTvHeavyLoadPowerRate.setText("——");
        mTvHeavyLoadRate.setText("——");
        mTvOverLoadCount.setText("——");
        mTvOverLoadPowerRate.setText("——");
        mTvOverLoadRate.setText("——");
        mTvStopLoadCount.setText("——");
        mTvStopLoadPowerRate.setText("——");
        mTvStopLoadRate.setText("——");
    }
}
