package com.locensate.letnetwork.main.ui.tools;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.lib.WheelView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.github.mikephil.charting.charts.CombinedChart;
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
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.CustomBarData;
import com.locensate.letnetwork.main.ui.fragments.overview.OverviewModel;
import com.locensate.letnetwork.utils.Constance;
import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.utils.PickViewUtils;
import com.locensate.letnetwork.view.ExpandablePopWindow;
import com.locensate.letnetwork.view.timepick.MyTimePickerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author xiaobinghe
 */

public class ToolsFengGuPingActivity extends BaseActivity {


    @BindView(R.id.tv_circle_type)
    TextView tvCircleType;
    @BindView(R.id.iv_circle_type)
    ImageView ivCircleType;
    @BindView(R.id.ll_circle_type)
    LinearLayout llCircleType;
    @BindView(R.id.tv_circle_time)
    TextView tvCircleTime;
    @BindView(R.id.iv_circle_time)
    ImageView ivCircleTime;
    @BindView(R.id.ll_circle_time)
    LinearLayout llCircleTime;
    @BindView(R.id.cbc_energy_feng_gu_ping)
    CombinedChart combinedChart;
    @BindView(R.id.iv_title_only_back)
    ImageView ivTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView tvTitleOnlyBack;
    @BindView(R.id.tv_group)
    TextView mTvGroup;
    private String timeShow;
    private ExpandablePopWindow expandablePopwindow;
    private OptionsPickerView mTimeTypePicker;
    private MyTimePickerView mHourPicker;
    private MyTimePickerView mMouthPicker;
    private MyTimePickerView mWeekPicker;
    private MyTimePickerView mDayPicker;
    private String mGroupName;

    @Override
    public int getLayoutId() {
        return R.layout.activity_tools_feng_gu_ping;
    }

    @Override
    public void initView() {
        tvTitleOnlyBack.setText("工具-峰谷平");
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
        rightAxis.setAxisMinimum(0f);
        rightAxis.setAxisMaximum(1.3f);
        rightAxis.setDrawTopYLabelEntry(true);
        rightAxis.setTextColor(getResources().getColor(R.color.font_content));

        YAxis leftAxis = combinedChart.getAxisLeft();
        leftAxis.setAxisMinimum(0f);
        // TODO: 2017/8/29 获取最大值动态设置数值
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
        set.setLineWidth(3f);
        set.setValueTextSize(10f);
        set.setCircleColor(getResources().getColor(R.color.pie_orange));
        set.setCircleRadius(1.5f);
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
        float barSpace = 0.120f;
        float barWidth = 0.65f;
        // (0.45 + 0.02) * 2 + 0.06 = 1.00 -> interval per "group"

        //自定义的bardata，为单个数据源
        CustomBarData d = new CustomBarData();
        d.addDataSet(set1);
        d.setBarWidth(barWidth);
        // make this BarData object grouped
        d.barsSpace(0.0f, barSpace);
        d.setDrawValues(true);
        return d;
    }

    public List<BarEntry> getBarEntry1() {
        ArrayList<BarEntry> entries1 = new ArrayList<BarEntry>();

        for (int index = 0; index < 24; index++) {
            entries1.add(new BarEntry(0, getRandom(25, 25)));

        }
        return entries1;
    }

    protected float getRandom(float range, float startsfrom) {
        return (float) (Math.random() * range) + startsfrom;
    }

    private ArrayList<Entry> getElectricPrice() {
        ArrayList<Entry> data2 = new ArrayList<Entry>();

        float val;
        for (int i = 0; i < 24; i++) {
            if (i < 6 | i > 20) {
                val = 0.4f;
            } else if ((i > 5 && i < 8) || (i > 10 && i < 18)) {
                val = 0.8f;
            } else {
                val = 1.2f;
            }
            data2.add(new Entry(i, val));
        }
        return data2;
    }

    @OnClick({R.id.iv_title_only_back, R.id.ll_circle_type, R.id.ll_circle_time, R.id.tv_group})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_title_only_back:
                finish();
                break;
            case R.id.ll_circle_type:

                showTimeTypePicker();
                break;
            case R.id.ll_circle_time:
                timeShow = tvCircleType.getText().toString();
                showPicker();
                break;
            case R.id.tv_group:
                showPop(new OverviewModel().getGroupTree());
                break;
            default:
                break;
        }
    }

    private void showTimeTypePicker() {
        if (null == mTimeTypePicker) {
            final List<String> timeTypes = Constance.array2List(Constance.timeType);
            mTimeTypePicker = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                @Override
                public void onOptionsSelect(int options1, int options2, int options3, View v) {
                    tvCircleType.setText(timeTypes.get(options1));
                }
            }).setLayoutRes(R.layout.layout_time_type_select, new CustomListener() {
                @Override
                public void customLayout(View v) {
                    Button cancel = (Button) v.findViewById(R.id.btt_cancel);
                    Button okay = (Button) v.findViewById(R.id.btt_okay);
                    (v.findViewById(R.id.pick_head)).setVisibility(View.GONE);
                    okay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mTimeTypePicker.returnData();
                        }
                    });
                    cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mTimeTypePicker.dismiss();
                        }
                    });
                }
            })
                    .setSubmitColor(getResources().getColor(R.color.font_deep_blue))
                    .setCancelColor(getResources().getColor(R.color.font_deep_blue))
                    .setDividerType(WheelView.DividerType.FILL)
                    .setTitleBgColor(getResources().getColor(R.color.bg))
                    .setLineSpacingMultiplier(2.0f)
                    .setSubCalSize(16)
                    .setContentTextSize(16)
                    .setDividerColor(getResources().getColor(R.color.font_deep_blue))
                    .setTextColorCenter(getResources().getColor(R.color.font_deep_blue))
                    .isDialog(true).build();
            mTimeTypePicker.setPicker(timeTypes);
        }
        mTimeTypePicker.show();
    }

    private void showPop(ArrayList<MultiItemEntity> groupTree) {
        if (null == expandablePopwindow) {
            expandablePopwindow = new ExpandablePopWindow(this, groupTree);
            expandablePopwindow.setAnimationStyle(R.style.MyPopAnim);
        }
        expandablePopwindow.showPopupWindow(mTvGroup);
        expandablePopwindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                String temp = expandablePopwindow.getPath();
                if (temp != null) {
                    mGroupName = temp;
                }
                mTvGroup.setText(mGroupName);
            }
        });
    }

    private void showPicker() {
        Calendar instance = Calendar.getInstance();
        instance.set(2010, 0, 1);
        switch (timeShow) {
            case "小时":
                if (mHourPicker == null) {
                    mHourPicker = PickViewUtils.getInstance().getYMDHPicker(this, instance, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            tvCircleTime.setText(DateUtils.getTime(date, timeShow));
                        }
                    });
                }
                mHourPicker.show();
                break;
            case "月":
                if (mMouthPicker == null) {
                    mMouthPicker = PickViewUtils.getInstance().getYMPicker(this, instance, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            tvCircleTime.setText(DateUtils.getTime(date, timeShow));
                        }
                    });
                }
                mMouthPicker.show();
                break;
            case "周":
                if (mWeekPicker == null) {
                    mWeekPicker = PickViewUtils.getInstance().getWeekPicker(this, instance, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            Date[] firstAndEnd = DateUtils.getFirstAndEndDayDateOfWeek(date);
                            tvCircleTime.setText(DateUtils.getTime(firstAndEnd[0], timeShow) + "/" + DateUtils.getTime(firstAndEnd[1], timeShow));
                        }
                    });
                }
                mWeekPicker.show();
                break;
            case "天":
                if (mDayPicker == null) {
                    mDayPicker = PickViewUtils.getInstance().getWeekPicker(this, instance, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            tvCircleTime.setText(DateUtils.getTime(date, timeShow));
                        }
                    });
                }
                mDayPicker.show();
                break;
            default:
                break;
        }
    }
}
