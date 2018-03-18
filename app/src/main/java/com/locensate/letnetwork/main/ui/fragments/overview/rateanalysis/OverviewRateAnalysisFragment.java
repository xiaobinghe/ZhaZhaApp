package com.locensate.letnetwork.main.ui.fragments.overview.rateanalysis;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
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
import com.github.mikephil.charting.utils.ColorTemplate;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseFragment;
import com.locensate.letnetwork.main.ui.MachineListActivity;
import com.locensate.letnetwork.main.ui.fragments.overview.OverviewFragment;
import com.locensate.letnetwork.utils.LogUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * @author xiaobinghe
 */

public class OverviewRateAnalysisFragment extends BaseFragment<OverviewRateAnalysisPresenter, OverviewRateAnalysisModel> implements OverviewRateAnalysisContract.View, OnChartValueSelectedListener {
    @BindView(R.id.pie_overview_contain)
    PieChart pieChart;
    @BindView(R.id.ll_economic)
    LinearLayout mLlEconomic;
    @BindView(R.id.ll_reasonable)
    LinearLayout mLlReasonable;
    @BindView(R.id.ll_uneconomic)
    LinearLayout mLlUneconomic;
    @BindView(R.id.ll_stop)
    LinearLayout mLlStop;
    @BindView(R.id.view2)
    View mView2;
    @BindView(R.id.imageView)
    ImageView mImageView;
    @BindView(R.id.tv_economy_rate)
    TextView mTvEconomyRate;
    @BindView(R.id.tv_economy_count)
    TextView mTvEconomyCount;
    @BindView(R.id.tv_economy_power_rate)
    TextView mTvEconomyPowerRate;
    @BindView(R.id.tv_rational_rate)
    TextView mTvRationalRate;
    @BindView(R.id.tv_rational_count)
    TextView mTvRationalCount;
    @BindView(R.id.tv_rational_power_rate)
    TextView mTvRationalPowerRate;
    @BindView(R.id.tv_uneconomic_rate)
    TextView mTvUneconomicRate;
    @BindView(R.id.tv_uneconomic_count)
    TextView mTvUneconomicCount;
    @BindView(R.id.tv_uneconomic_power_rate)
    TextView mTvUneconomicPowerRate;
    @BindView(R.id.tv_stop_rate)
    TextView mTvStopRate;
    @BindView(R.id.tv_stop_count)
    TextView mTvStopCount;
    @BindView(R.id.tv_stop_power_rate)
    TextView mTvStopPowerRate;

    private Typeface tf;
    private String[] mParties = new String[]{"经济", "合理", "非经济", "停止"};
    private int organizationId;
    private long startMills;
    private long endMills;

    @Override
    public int getInflaterView() {
        return R.layout.fragment_overview_contain;
    }

    @Override
    protected void initView() {
        initChartConfig();
    }

    @Override
    protected void onVisible() {
        super.onVisible();
    }


    @Override
    protected void lazyLoad() {
        LogUtil.e("lazyLoad:", "-------------lazyLoad");
    }

    public void initChartConfig() {
        pieChart.setUsePercentValues(true);
        //添加饼图的描述是否可用
        pieChart.getDescription().setEnabled(false);
        pieChart.setNoDataText("暂无数据");
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

        //字体类型
        tf = Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Regular.ttf");

        //设置中心显示的文字类型
        pieChart.setCenterTextTypeface(Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Light.ttf"));
        //设置中心显示的文字
//        pieChart.setCenterText(generateCenterSpannableText());
        pieChart.setCenterText("能效");
        pieChart.setCenterTextSize(16f);
        //设置饼图左上右下的偏移量
        pieChart.setExtraOffsets(0.f, 0.f, 0.f, 0.f);
        //饼图是否空心
        pieChart.setDrawHoleEnabled(true);
        //饼图空心处的颜色
        pieChart.setHoleColor(Color.WHITE);
        //饼图中心处阴影部分的颜色
        pieChart.setTransparentCircleColor(Color.WHITE);
        //阴影部分的透明度（0-225）
        pieChart.setTransparentCircleAlpha(110);
        //饼图上的标签颜色
        pieChart.setEntryLabelColor(Color.BLACK);
        //饼图上标签可用性
        pieChart.setDrawEntryLabels(false);
        //饼图中心圆的半径
        pieChart.setHoleRadius(60f);
        //饼图阴影部分圆的半径
        pieChart.setTransparentCircleRadius(65f);
        //饼图中心文字可用性
        pieChart.setDrawCenterText(true);
        //绘制饼图的起始点，默认为270度
        pieChart.setRotationAngle(270f);
        // 设置饼图是否可以被滑动
        pieChart.setRotationEnabled(true);
        //设置选中后是否高亮突出显示
        pieChart.setHighlightPerTapEnabled(false);

        // pieChart.setUnit(" €");
        // pieChart.setDrawUnitsInChart(true);

        // 添加选中监听
        pieChart.setOnChartValueSelectedListener(this);
        pieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // pieChart.spin(2000, 0, 360);

        Legend l = pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(false);
    }

    @Override
    public void setData(ArrayList<PieEntry> entries) {

        PieDataSet dataSet = new PieDataSet(entries, "Election Results");
        dataSet.setDrawValues(false);

        dataSet.setSliceSpace(0f);
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(getResources().getColor(R.color.pie_green));
        colors.add(getResources().getColor(R.color.pie_yellow));
        colors.add(getResources().getColor(R.color.pie_orange));
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

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    @OnClick({R.id.ll_economic, R.id.ll_reasonable, R.id.ll_uneconomic, R.id.ll_stop})
    public void onViewClicked(View view) {
        if (true) {
            return;
        }
        String filter;
        String status;
        switch (view.getId()) {
            case R.id.ll_economic:
                filter = "economic";
                status = mParties[0];
                break;
            case R.id.ll_reasonable:
                filter = "reasonable";
                status = mParties[1];
                break;
            case R.id.ll_uneconomic:
                filter = "uneconomic";
                status = mParties[2];
                break;
            case R.id.ll_stop:
                filter = "stop";
                status = mParties[3];
                break;
            default:
                filter = "economic";
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
        mTvEconomyCount.setText(counts[0]);
        mTvEconomyPowerRate.setText(powerRates[0]);
        mTvEconomyRate.setText(countRate[0]);
        mTvRationalCount.setText(counts[1]);
        mTvRationalPowerRate.setText(powerRates[1]);
        mTvRationalRate.setText(countRate[1]);
        mTvUneconomicCount.setText(counts[2]);
        mTvUneconomicPowerRate.setText(powerRates[2]);
        mTvUneconomicRate.setText(countRate[2]);
        mTvStopCount.setText(counts[3]);
        mTvStopPowerRate.setText(powerRates[3]);
        mTvStopRate.setText(countRate[3]);
    }

    @Override
    public void setNoData() {
        mTvEconomyCount.setText("——");
        mTvEconomyPowerRate.setText("——");
        mTvEconomyRate.setText("——");
        mTvRationalCount.setText("——");
        mTvRationalPowerRate.setText("——");
        mTvRationalRate.setText("——");
        mTvUneconomicCount.setText("——");
        mTvUneconomicPowerRate.setText("——");
        mTvUneconomicRate.setText("——");
        mTvStopCount.setText("——");
        mTvStopPowerRate.setText("——");
        mTvStopRate.setText("——");
    }
}
