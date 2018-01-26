package com.locensate.letnetwork.main.ui.fragments.overview.healthyanalysis;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

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
import com.locensate.letnetwork.base.RxBus;
import com.locensate.letnetwork.main.ui.MachineListActivity;
import com.locensate.letnetwork.main.ui.fragments.overview.OverviewFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *  
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
    private Typeface tf;
    private String[] mParties = new String[]{"健康", "较好", "较差", "差"};
    private float[] percents = new float[]{16.7f, 37.5f, 37.5f, 8.3f};
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

    }

    @Override
    protected void onVisible() {

    }

    @Override
    protected void lazyLoad() {

    }


    @Override
    public void fillData(ArrayList<PieEntry> pieEntries) {

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
//        Description desc = new Description();
//        desc.setText("we are super man");
//        pieChart.setDescription(desc);
//        pieChart.setExtraOffsets(5, 10, 5, 5);

        tf = Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Regular.ttf");
        pieChart.setDragDecelerationFrictionCoef(0.98f);
        pieChart.setDragDecelerationEnabled(true);

        pieChart.setCenterTextTypeface(Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Light.ttf"));
//        pieChart.setCenterText(generateCenterSpannableText());
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

//        pieChart.setCenterText(generateCenterSpannableText());
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

        setData(4, 100);

//         pieChart.spin(2000, 0, 360);

        Legend l = pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(false);
    }

    private CharSequence generateCenterSpannableText() {
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

    private void setData(int count, int range) {
        ArrayList<PieEntry> entries = new ArrayList<>();
        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < count; i++) {
            entries.add(new PieEntry(percents[i], mParties[i]));
        }

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
        String filter;
        String status;
        switch (view.getId()) {
            case R.id.ll_health:
                filter = "health";
                status=mParties[0];
                break;
            case R.id.ll_good:
                filter = "good";
                status=mParties[1];
                break;
            case R.id.ll_worse:
                filter = "worse";
                status=mParties[2];
                break;
            case R.id.ll_worst:
                filter = "worst";
                status=mParties[3];
                break;
            default:
                filter = "health";
                status=mParties[0];
                break;
        }

        Intent intent = new Intent(App.getApplication(), MachineListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("filter", filter);
        bundle.putString("ranges", OverviewFragment.mGroupName);
        bundle.putString("status",status);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unRegister();
    }
}
