package com.locensate.letnetwork.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.lib.WheelView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.view.timepick.MyTimePickerView;

import java.util.Calendar;
import java.util.List;


/**
 *
 * @author xiaobinghe
 */


public class PickViewUtils {


    private OptionsPickerView mTimeTypeDialog;
    private OptionsPickerView mWHMPicker;

    public OptionsPickerView getYWPicker(Activity context, OptionsPickerView.OnOptionsSelectListener listener, List<String> options1Items, List<List<String>> options2Items) {
        OptionsPickerView yearWeek = new OptionsPickerView.Builder(context, listener).setLabels("年", "周", "")
                .setDividerColor(context.getResources().getColor(R.color.font_deep_blue))
                .setTextColorCenter(context.getResources().getColor(R.color.font_deep_blue))
                .setDividerType(WheelView.DividerType.FILL)
                .setCancelText(context.getResources().getString(R.string.cancel))
                .setSubmitText(context.getResources().getString(R.string.okay))
                .setSubCalSize(16)
                .setContentTextSize(16)
                .setLineSpacingMultiplier(2.0f)
                .setSubmitColor(context.getResources().getColor(R.color.font_deep_blue))
                .setCancelColor(context.getResources().getColor(R.color.font_deep_blue))
                .build();

        yearWeek.setPicker(options1Items, options2Items);
        return yearWeek;
    }

    public MyTimePickerView getYMPicker(Activity context, Calendar startDate, MyTimePickerView.OnTimeSelectListener listener) {

        return new MyTimePickerView.Builder(context, listener)
                .setCancelText(context.getResources().getString(R.string.cancel))
                .setSubmitText(context.getResources().getString(R.string.okay))
                .setSubmitColor(context.getResources().getColor(R.color.white))
                .setCancelColor(context.getResources().getColor(R.color.font_deep_blue))
                .setSubCalSize(16)
                .isCyclic(true)
                .isDialog(true)
                .setContentSize(16)
                .setLineSpacingMultiplier(2.0f)
                .setDividerType(WheelView.DividerType.FILL)
                .setLabel("", "", "", "", "", "")
                .setDividerColor(context.getResources().getColor(R.color.font_deep_blue))
                .setTextColorCenter(context.getResources().getColor(R.color.font_deep_blue))
                .setType(MyTimePickerView.Type.YEAR_MONTH)
                .setRangDate(startDate, Calendar.getInstance())
                .setDate(Calendar.getInstance())
                .build();
    }

    public MyTimePickerView getYMDPicker(Activity context, Calendar startDate, MyTimePickerView.OnTimeSelectListener listener) {
        /**
         *  年月日选择器
         */

        return new MyTimePickerView.Builder(context, listener)
                .setCancelText(context.getString(R.string.cancel))
                .setSubmitText(context.getString(R.string.okay))
                .setSubmitColor(context.getResources().getColor(R.color.white))
                .setCancelColor(context.getResources().getColor(R.color.font_deep_blue))
                .isCyclic(true)
                .isDialog(true)
                .setSubCalSize(16)
                .setContentSize(16)
                .setLineSpacingMultiplier(2.0f)
                .setLabel("", "", "", "", "", "")
                .setDividerColor(context.getResources().getColor(R.color.font_deep_blue))
                .setTextColorCenter(context.getResources().getColor(R.color.font_deep_blue))
                .setType(MyTimePickerView.Type.YEAR_MONTH_DAY)
                .setRangDate(startDate, Calendar.getInstance())
                .setDate(Calendar.getInstance())
                .build();
    }

    public MyTimePickerView getYMDPicker(Activity context, Calendar startDate, Calendar endData, MyTimePickerView.OnTimeSelectListener listener) {
        /**
         *  年月日选择器
         */


        return new MyTimePickerView.Builder(context, listener)
                .setCancelText(context.getString(R.string.cancel))
                .setSubmitText(context.getString(R.string.okay))
                .setSubmitColor(context.getResources().getColor(R.color.white))
                .setCancelColor(context.getResources().getColor(R.color.font_deep_blue))
                .isCyclic(true)
                .isDialog(true)
                .setSubCalSize(16)
                .setContentSize(16)
                .setLineSpacingMultiplier(2.0f)
                .setLabel("", "", "", "", "", "")
                .setDividerColor(context.getResources().getColor(R.color.font_deep_blue))
                .setTextColorCenter(context.getResources().getColor(R.color.font_deep_blue))
                .setType(MyTimePickerView.Type.YEAR_MONTH_DAY)
                .setRangDate(startDate, endData)
                .setDate(Calendar.getInstance())
                .build();
    }

    public MyTimePickerView getWeekPicker(Activity context, Calendar startDate, MyTimePickerView.OnTimeSelectListener listener) {
        /**
         *  年月日选择器
         */
        return new MyTimePickerView.Builder(context, listener)
                .setCancelText(context.getString(R.string.cancel))
                .setSubmitText(context.getString(R.string.okay))
                .setSubmitColor(context.getResources().getColor(R.color.white))
                .setCancelColor(context.getResources().getColor(R.color.font_deep_blue))
                .isCyclic(true)
                .isDialog(true)
                .setSubCalSize(16)
                .setContentSize(16)
                .setLineSpacingMultiplier(2.0f)
                .setLabel("", "", "", "", "", "")
                .setDividerColor(context.getResources().getColor(R.color.font_deep_blue))
                .setTextColorCenter(context.getResources().getColor(R.color.font_deep_blue))
                .setType(MyTimePickerView.Type.YEAR_MONTH_DAY)
                .setRangDate(startDate, Calendar.getInstance())
                .setDate(Calendar.getInstance())
                .build();
    }

    public MyTimePickerView getYMDHPicker(Activity context, Calendar startDate, MyTimePickerView.OnTimeSelectListener listener) {
        /**
         * 年月日时选择器
         */
        return new MyTimePickerView.Builder(context, listener).setDividerColor(context.getResources().getColor(R.color.font_deep_blue))
                .setCancelText("取消")
                .setSubmitText("确定")
                .setSubmitColor(context.getResources().getColor(R.color.white))
                .setCancelColor(context.getResources().getColor(R.color.font_deep_blue))
                .isCyclic(true)
                .setSubCalSize(16)
                .setContentSize(16)
                .setLineSpacingMultiplier(2.0f)
                .isDialog(true)
//                .isCenterLabel(true)
//                .setLabel(context.getString(R.string.year), context.getString(R.string.month), context.getString(R.string.day), context.getResources().getString(R.string.hour), "", "")
                .setLabel("", "", "", "", "", "")
                .setTextColorCenter(context.getResources().getColor(R.color.font_deep_blue))
                .setDividerType(WheelView.DividerType.FILL)
                .setType(MyTimePickerView.Type.YEAR_MONTH_DAY_HOUR)
                .setRangDate(startDate, Calendar.getInstance())
                .setDate(Calendar.getInstance())
                .build();
    }

    public MyTimePickerView getYMDHMPicker(Activity context, Calendar startDate, Calendar endData, MyTimePickerView.OnTimeSelectListener listener) {
        /**
         * 年月日时选择器
         */
        return new MyTimePickerView.Builder(context, listener).setDividerColor(context.getResources().getColor(R.color.font_deep_blue))
                .setCancelText("取消")
                .setSubmitText("确定")
                .setSubmitColor(context.getResources().getColor(R.color.white))
                .setCancelColor(context.getResources().getColor(R.color.font_deep_blue))
                .isCyclic(true)
                .setSubCalSize(16)
                .setContentSize(16)
                .setLineSpacingMultiplier(2.0f)
                .isDialog(true)
//                .isCenterLabel(true)
//                .setLabel(context.getString(R.string.year), context.getString(R.string.month), context.getString(R.string.day), context.getResources().getString(R.string.hour), "", "")
                .setLabel("", "", "", "", "", "")
                .setTextColorCenter(context.getResources().getColor(R.color.font_deep_blue))
                .setDividerType(WheelView.DividerType.FILL)
                .setType(MyTimePickerView.Type.YEAR_MONTH_DAY_HOUR_MIN)
                .setRangDate(startDate, endData)
                .setDate(Calendar.getInstance())
                .build();
    }

    public MyTimePickerView getHMPicker(Activity context, MyTimePickerView.OnTimeSelectListener listener) {
        /**
         * 年月日时选择器
         */
        return new MyTimePickerView.Builder(context, listener).setDividerColor(context.getResources().getColor(R.color.font_deep_blue))
                .setCancelText("取消")
                .setSubmitText("确定")
                .setSubmitColor(context.getResources().getColor(R.color.white))
                .setCancelColor(context.getResources().getColor(R.color.font_deep_blue))
                .isCyclic(true)
                .setSubCalSize(16)
                .setContentSize(16)
                .setLineSpacingMultiplier(2.0f)
                .isDialog(true)
//                .isCenterLabel(true)
//                .setLabel(context.getString(R.string.year), context.getString(R.string.month), context.getString(R.string.day), context.getResources().getString(R.string.hour), "", "")
                .setLabel("", "", "", "", "", "")
                .setTextColorCenter(context.getResources().getColor(R.color.font_deep_blue))
                .setDividerType(WheelView.DividerType.FILL)
                .setType(MyTimePickerView.Type.HOURS_MINS)
//                .setRangDate(startDate, endData)
                .setDate(Calendar.getInstance())
                .build();
    }

    public OptionsPickerView getTimeType(Context context, final List<String> timeTypes, final OptionsPickerView.OnOptionsSelectListener listener) {
        mTimeTypeDialog = new OptionsPickerView.Builder(context, listener)
                .setLayoutRes(R.layout.layout_time_type_select, new CustomListener() {
                    @Override
                    public void customLayout(View v) {
                        Button cancel = (Button) v.findViewById(R.id.btt_cancel);
                        Button okay = (Button) v.findViewById(R.id.btt_okay);
                        (v.findViewById(R.id.pick_head)).setVisibility(View.GONE);
                        okay.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mTimeTypeDialog.returnData();
                            }
                        });
                        cancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mTimeTypeDialog.dismiss();
                            }
                        });
                    }
                })
                .setSubmitColor(context.getResources().getColor(R.color.font_deep_blue))
                .setCancelColor(context.getResources().getColor(R.color.font_deep_blue))
                .setDividerType(WheelView.DividerType.FILL)
                .setTitleBgColor(context.getResources().getColor(R.color.bg))
                .setLineSpacingMultiplier(2.0f)
                .setSubCalSize(16)
                .setContentTextSize(16)
                .setDividerColor(context.getResources().getColor(R.color.font_deep_blue))
                .setTextColorCenter(context.getResources().getColor(R.color.font_deep_blue))
                .isDialog(true)
                .build();
        mTimeTypeDialog.setPicker(timeTypes);
        return mTimeTypeDialog;
    }

    public OptionsPickerView getWHM(Activity context, final String[] laybles, final OptionsPickerView.OnOptionsSelectListener listener) {
        //                .setLabels(laybels[0], laybels[1], laybels[2])
        //                .setLabels(laybels[0], laybels[1], laybels[2])
        mWHMPicker = new OptionsPickerView.Builder(context, listener)
                .setLayoutRes(R.layout.layout_time_type_select, new CustomListener() {
                    @Override
                    public void customLayout(View v) {
                        Button cancel = (Button) v.findViewById(R.id.btt_cancel);
                        Button okay = (Button) v.findViewById(R.id.btt_okay);
                        ((TextView) v.findViewById(R.id.tv_option1)).setText(laybles[0]);
                        ((TextView) v.findViewById(R.id.tv_option2)).setText(laybles[1]);
                        ((TextView) v.findViewById(R.id.tv_option3)).setText(laybles[2]);
                        okay.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mWHMPicker.returnData();
                            }
                        });
                        cancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mWHMPicker.dismiss();
                            }
                        });
                    }
                })
//                .setLabels(laybels[0], laybels[1], laybels[2])
                .setSubmitColor(context.getResources().getColor(R.color.font_deep_blue))
                .setCancelColor(context.getResources().getColor(R.color.font_deep_blue))
                .setDividerType(WheelView.DividerType.FILL)
                .setTitleBgColor(context.getResources().getColor(R.color.bg))
                .setLineSpacingMultiplier(2.0f)
                .setSubCalSize(16)
                .setContentTextSize(16)
                .setDividerColor(context.getResources().getColor(R.color.font_deep_blue))
                .setTextColorCenter(context.getResources().getColor(R.color.font_deep_blue))
                .isDialog(true)
                .build();
        return mWHMPicker;
    }

    public static PickViewUtils getInstance() {
        return PickViewUtilsHelper.Instance;
    }

    private static class PickViewUtilsHelper {
        private static PickViewUtils Instance = new PickViewUtils();
    }
}
