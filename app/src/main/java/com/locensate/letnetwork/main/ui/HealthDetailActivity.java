package com.locensate.letnetwork.main.ui;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.api.Api;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.base.RxSchedulers;
import com.locensate.letnetwork.bean.HealthOverDataEntity;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.ToastUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
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
    @BindView(R.id.tv_item_c)
    TextView mTvItemC;
    private String mType;
    private long mStartTime;
    private long mEndTime;
    private long mMotorId;
    private HealthDetailAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_health_detail;
    }

    @Override
    public void initView() {
        Bundle extras = getIntent().getExtras();
        mType = extras.getString("type");
        mStartTime = extras.getLong("startTime");
        mEndTime = extras.getLong("endTime");
        mMotorId = extras.getLong("motorId");
        LogUtil.e(TAG, "------------mType==" + mType);
        mTvItem1.setText("时间");
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new HealthDetailAdapter(R.layout.item_health_detail, new ArrayList<HealthOverDataEntity.DataBean>());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.bindToRecyclerView(mRecyclerView);
        getObservableData().compose(RxSchedulers.<HealthOverDataEntity>applyObservableAsync()).subscribe(new Consumer<HealthOverDataEntity>() {
            @Override
            public void accept(HealthOverDataEntity healthOverDataEntity) throws Exception {
                List<HealthOverDataEntity.DataBean> data = healthOverDataEntity.getData();
                if (null == data || data.size() == 0) {
                    mAdapter.setEmptyView(R.layout.layout_no_data);
                } else {
                    mAdapter.addData(data);
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                LogUtil.e("OverFlagData", "-" + throwable.toString());
                ToastUtil.show(R.string.data_load_fail);
            }
        });
    }

    private Observable<HealthOverDataEntity> getObservableData() {
        switch (mType) {
            case "over_temp":
                mTvTitle.setText("温度超标情况");
                mTvItemC.setText("位置");
                mTvItem2.setText("每小时最大值");
                return Api.getInstance().service.getOverTempData(mMotorId, mStartTime, mEndTime);
            case "shark":
                mTvTitle.setText("振动超标情况");
                mTvItemC.setText("位置");
                mTvItem2.setText("每小时最大值");
                return Api.getInstance().service.getSharkData(mMotorId, mStartTime, mEndTime);
            case "electric_hot":
                mTvTitle.setText("5分钟电子过热情况");
                mTvItem2.setText("每小时最大值");
                return Api.getInstance().service.getElectricHotterQ5(mMotorId, mStartTime, mEndTime);
            case "electric_hot_q30":
                mTvTitle.setText("30分钟电子过热情况");
                mTvItem2.setText("每小时最大值");
                return Api.getInstance().service.getElectricHotterQ30(mMotorId, mStartTime, mEndTime);
            case "maxStartCount":
                mTvTitle.setText("每小时启动次数超标情况");
                mTvItem2.setText("每小时次数");
                return Api.getInstance().service.getStartCountData(mMotorId, mStartTime, mEndTime);
            case "over_current":
                mTvTitle.setText("过流情况");
                mTvItem2.setText("每小时最大值");
                return Api.getInstance().service.getOverCurrentData(mMotorId, mStartTime, mEndTime);
            default:
                return null;
        }
    }
/*

    private List<HealthOverDataEntity> getData() {
        String tempHour = "00";
        String temp = "";
        ArrayList<HealthOverDataEntity.DataBean> healthDetailBeen = new ArrayList<>();
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
                    healthDetailBeen.add(new HealthOverDataEntity.DataBean("", temp + "  " + tempHour + ":00", String.valueOf(new Random().nextInt() + 6)));
                    break;
                case "electric_hot":
                    healthDetailBeen.add(new HealthOverDataEntity.DataBean("", temp + "  " + tempHour + ":" + (int) ((Math.random() * 50) + 10), (double) (Math.random() * 60 + 90) + "%"));
                    break;
                case "over_current":
                    healthDetailBeen.add(new HealthOverDataEntity.DataBean("", temp + "  " + tempHour + ":" + (int) ((Math.random() * 50) + 10), (double) (Math.random() * 20 + 100) + "%"));
                    break;
                case "over_temp":
                    healthDetailBeen.add(new HealthOverDataEntity.DataBean( temp + "  " + tempHour + ":" + (int) ((Math.random() * 50) + 10), (double) (Math.random() * 65) + "℃"));
                    break;
                default:
                    break;
            }
        }

        return healthDetailBeen;
    }

*/

    @OnClick(R.id.iv_close)
    public void onViewClicked() {
        finish();
    }

    private class HealthDetailAdapter extends BaseQuickAdapter<HealthOverDataEntity.DataBean, BaseViewHolder> {
        public HealthDetailAdapter(int layoutResId, ArrayList<HealthOverDataEntity.DataBean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, HealthOverDataEntity.DataBean healthDetailBean) {
            LogUtil.e(TAG, "------------mType==" + mType);

            DecimalFormat df = new DecimalFormat("0.0");
            baseViewHolder.setText(R.id.tv_time, healthDetailBean.getTime().substring(2));

            switch (mType) {
                case "over_temp":
                    baseViewHolder.setText(R.id.tv_value, df.format(healthDetailBean.getValue()) + "℃")
                            .setText(R.id.tv_location, healthDetailBean.getType());
                    break;
                case "shark":
                    baseViewHolder.setText(R.id.tv_value, df.format(healthDetailBean.getValue()))
                            .setText(R.id.tv_location, healthDetailBean.getType());
                    break;
                case "electric_hot":
                case "electric_hot_q30":
                    baseViewHolder.setText(R.id.tv_value, df.format(healthDetailBean.getValue() * 100) + "%");
                    break;
                case "maxStartCount":
                    baseViewHolder.setText(R.id.tv_value, (int) healthDetailBean.getValue() + "次");
                    break;
                case "over_current":
                    baseViewHolder.setText(R.id.tv_value, df.format(healthDetailBean.getValue()) + "A");
                    break;
                default:
                    break;

            }

        }
    }
}
