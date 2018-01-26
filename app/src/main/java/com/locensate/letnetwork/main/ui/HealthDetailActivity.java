package com.locensate.letnetwork.main.ui;

import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.entity.HealthDetailBean;
import com.locensate.letnetwork.utils.LogUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *  
 * @author xiaobinghe
 */

public class HealthDetailActivity extends BaseActivity {

    @BindView(R.id.iv_close)
    ImageView mIvClose;
    @BindView(R.id.tv_item1)
    TextView mTvItem1;
    @BindView(R.id.tv_item2)
    TextView mTvItem2;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.activity_health_detail)
    CardView mActivityHealthDetail;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private String mType;

    @Override
    public int getLayoutId() {
        return R.layout.activity_health_detail;
    }

    @Override
    public void initView() {
        mType = getIntent().getExtras().getString("type");
        LogUtil.e(TAG, "------------mType==" + mType);
        mTvItem1.setText("时间");
        switch (mType) {
            case "maxStartCount":
                mTvTitle.setText("电机每小时启动次数超标情况");
                mTvItem2.setText("电机每小时启动次数");
                break;
            case "electric_hot":
                mTvTitle.setText("电机每小时电子过热情况");
                mTvItem2.setText("电机每小时电子过热值");
                break;
            case "over_current":
                mTvTitle.setText("电机过流情况");
                mTvItem2.setText("过流值");
                break;
            case "over_temp":
                mTvTitle.setText("电机温度超标情况");
                mTvItem2.setText("温度值");
                break;
            default:
                break;

        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new HealthDetailAdapter(R.layout.item_health_detail, getData()));
    }

    private List<HealthDetailBean> getData() {
        String tempHour = "00";
        String temp = "";
        ArrayList<HealthDetailBean> healthDetailBeen = new ArrayList<>();
        Calendar instance = Calendar.getInstance();
        instance.set(2017, 07, 23);
        int year = instance.get(Calendar.YEAR);
        int mouth = instance.get(Calendar.MONTH);
        int day = instance.get(Calendar.DAY_OF_MONTH);
        int hour = instance.get(Calendar.HOUR_OF_DAY);
        int min = instance.get(Calendar.MINUTE);
        LogUtil.e(TAG, "------------year=" + year + "-----mouth==" + mouth + "-----day===" + day + "---hour==" + hour + "---min==" + min);

        for (int i = 0; i < 6; i++) {
            instance.add(Calendar.DATE, -1);
            mouth = instance.get(Calendar.MONTH);
            day = instance.get(Calendar.DAY_OF_MONTH);

            if (hour - i >= 0) {
                tempHour = (hour - i) > 9 ? String.valueOf(hour - i) : "0" + (hour - i);
            } else {
                tempHour = String.valueOf(hour - i + 24);
            }

            temp = year + "-" + mouth + "-" + day;

            switch (mType) {
                case "maxStartCount":
                    healthDetailBeen.add(new HealthDetailBean("", temp + "  " + tempHour + ":00", String.valueOf(new Random().nextInt() + 6)));
                    break;
                case "electric_hot":
                    healthDetailBeen.add(new HealthDetailBean("", temp + "  " + tempHour + ":" + (int) ((Math.random() * 50) + 10), (int) (Math.random() * 60 + 90) + "%"));
                    break;
                case "over_current":
                    healthDetailBeen.add(new HealthDetailBean("", temp + "  " + tempHour + ":" + (int) ((Math.random() * 50) + 10), (int) (Math.random() * 20 + 100) + "%"));
                    break;
                case "over_temp":
                    healthDetailBeen.add(new HealthDetailBean("", temp + "  " + tempHour + ":" + (int) ((Math.random() * 50) + 10), (int) (Math.random() * 65) + "℃"));
                    break;
                default:
                    break;
            }
        }

        return healthDetailBeen;
    }


    @OnClick(R.id.iv_close)
    public void onViewClicked() {
        finish();
    }

    private class HealthDetailAdapter extends BaseQuickAdapter<HealthDetailBean, BaseViewHolder> {
        public HealthDetailAdapter(int layoutResId, List<HealthDetailBean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, HealthDetailBean healthDetailBean) {
            LogUtil.e(TAG, "------------mType==" + mType);

            baseViewHolder.setText(R.id.tv_time, healthDetailBean.getTime())
                    .setText(R.id.tv_value, healthDetailBean.getValue());
        }
    }
}
