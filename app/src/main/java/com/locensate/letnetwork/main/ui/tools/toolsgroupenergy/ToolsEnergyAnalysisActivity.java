package com.locensate.letnetwork.main.ui.tools.toolsgroupenergy;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.lib.WheelView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.utils.Constance;
import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.utils.PickViewUtils;
import com.locensate.letnetwork.entity.GroupEnergyEntity;
import com.locensate.letnetwork.view.ExpandablePopWindow;
import com.locensate.letnetwork.view.expandableview.Level0Item;
import com.locensate.letnetwork.view.expandableview.Level1Item;
import com.locensate.letnetwork.view.expandableview.Level2Item;
import com.locensate.letnetwork.view.timepick.MyTimePickerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *  
 * @author xiaobinghe
 */

public class ToolsEnergyAnalysisActivity extends BaseActivity {

    @BindView(R.id.iv_title_only_back)
    ImageView ivTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView tvTitleOnlyBack;
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
    @BindView(R.id.rv_group_energy)
    RecyclerView rvGroupEnergy;
    @BindView(R.id.tv_group)
    TextView mTvGroup;
    @BindView(R.id.ll_group)
    LinearLayout mLlGroup;
    private ExpandablePopWindow expandablePopwindow;
    private String timeShow;
    private OptionsPickerView mTimeTypePicker;
    private MyTimePickerView mYearPicker;
    private MyTimePickerView mMouthPicker;
    private MyTimePickerView mWeekPicker;
    private MyTimePickerView mDayPicker;

    @Override
    public int getLayoutId() {
        return R.layout.activity_tools_energy_analysis;
    }

    @Override
    public void initView() {
        tvTitleOnlyBack.setText("工具-班组能效");
        rvGroupEnergy.setLayoutManager(new LinearLayoutManager(this));
        rvGroupEnergy.setAdapter(new GroupEnergyRVAdapter(R.layout.item_group_energy, getData()));
        rvGroupEnergy.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void SimpleOnItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                GroupEnergyEntity item = (GroupEnergyEntity) baseQuickAdapter.getItem(i);
                View inflate = View.inflate(mContext, R.layout.layout_class_group_pop, null);
                TextView classBelong = (TextView) inflate.findViewById(R.id.tv_class_belong);
                TextView classType = (TextView) inflate.findViewById(R.id.tv_class_type);
                classBelong.setText(item.getGroupBelong());
                classType.setText(item.getWorkType());
                PopupWindow popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setOutsideTouchable(true);
                ColorDrawable dw = new ColorDrawable(0000000000);
                popupWindow.setBackgroundDrawable(dw);
                popupWindow.showAsDropDown(view, 0, 0);
            }
        });
    }


    @OnClick({R.id.iv_title_only_back, R.id.ll_circle_type, R.id.ll_circle_time, R.id.tv_group})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_title_only_back:
                finish();
                break;
            case R.id.ll_circle_type:
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
                break;
            case R.id.ll_circle_time:
                timeShow = tvCircleType.getText().toString();
                showPicker();
                break;
            case R.id.tv_group:
                showPop(getGroupTree());
                break;
        }
    }

    private void showPicker() {
        Calendar instance = Calendar.getInstance();
        instance.set(2010, 0, 1);
        switch (timeShow) {
            case "小时":
                if (null == mYearPicker) {
                    mYearPicker = PickViewUtils.getInstance().getYMDHPicker(this, instance, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            tvCircleTime.setText(DateUtils.getTime(date, timeShow));
                        }
                    });
                }
                mYearPicker.show();
                break;
            case "月":
                if (null == mMouthPicker) {
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
                if (null == mWeekPicker) {
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
                if (null == mDayPicker) {
                    mDayPicker = PickViewUtils.getInstance().getWeekPicker(this, instance, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            tvCircleTime.setText(DateUtils.getTime(date, timeShow));
                        }
                    });
                }
                mDayPicker.show();
                break;
        }
    }

    private void showPop(ArrayList<MultiItemEntity> groupTree) {
        if (null == expandablePopwindow) {
            expandablePopwindow = new ExpandablePopWindow(this, groupTree);
        }
        expandablePopwindow.showPopupWindow(mTvGroup);
//        WindowOptionUtil.darkBackGround(0.4f, this);
        expandablePopwindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
//                WindowOptionUtil.darkBackGround(1f, ToolsEnergyAnalysisActivity.this);
                mTvGroup.setText(expandablePopwindow.getPath());
            }
        });
    }

    private ArrayList<MultiItemEntity> getGroupTree() {
        int lv0Count = 5;
        int lv1Count = 3;
        int personCount = 4;

        String[] nameList = {"焦化厂", "炼钢厂", "烧结厂", "不锈钢厂", "国际贸易公司"};
        String[] lv0List = {"一车间", "二车间", "三车间"};
        String[] lv1List = {"一班", "二班", "三班", "四班"};
        ArrayList<MultiItemEntity> res = new ArrayList<>();
        res.add(new Level0Item("全部", "全部", 0));
        for (int i = 0; i < lv0Count; i++) {
            Level0Item lv0 = new Level0Item(nameList[i], nameList[i], 0);

            for (int j = 0; j < lv1Count; j++) {
                Level1Item lv1 = new Level1Item(lv0List[j], "", 0);
                for (int k = 0; k < personCount; k++) {
                    lv1.addSubItem(new Level2Item(lv1List[k], null, false, 0));
                }
                lv0.addSubItem(lv1);
            }
            res.add(lv0);
        }

        return res;
    }

    public List<GroupEnergyEntity> getData() {
        ArrayList<GroupEnergyEntity> entities = new ArrayList<>();

        entities.add(new GroupEnergyEntity("" + 1, "微粉一班", "180h", "0.889", "36000", "微粉车间", "4班8小时制"));
        entities.add(new GroupEnergyEntity("" + 2, "微粉二班", "175h", "0.901", "33260", "微粉车间", "4班8小时制"));
        entities.add(new GroupEnergyEntity("" + 3, "微粉三班", "180h", "0.900", "35650", "微粉车间", "4班8小时制"));
        entities.add(new GroupEnergyEntity("" + 4, "微粉四班", "180h", "0.887", "35778", "微粉车间", "4班8小时制"));

        entities.add(new GroupEnergyEntity("" + 4, "运输一班", "150h", "0.895", "30000", "运输车间", "4班8小时制"));
        entities.add(new GroupEnergyEntity("" + 4, "运输二班", "120h", "0.908", "26000", "运输车间", "4班8小时制"));
        entities.add(new GroupEnergyEntity("" + 4, "运输三班", "145h", "0.889", "29145", "运输车间", "4班8小时制"));
        entities.add(new GroupEnergyEntity("" + 4, "运输四班", "138h", "0.905", "27325", "运输车间", "4班8小时制"));

        return entities;
    }
}
