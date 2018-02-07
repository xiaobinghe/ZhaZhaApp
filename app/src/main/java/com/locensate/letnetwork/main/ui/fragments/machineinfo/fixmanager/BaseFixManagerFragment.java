package com.locensate.letnetwork.main.ui.fragments.machineinfo.fixmanager;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseFragment;
import com.locensate.letnetwork.view.timepick.MyTimePickerView;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 设备信息-baseFragment
 *
 * @author xiaobinghe
 */


public abstract class BaseFixManagerFragment extends BaseFragment {

    public Date endDate;
    public Date startDate;
    public boolean isClose = true;
    @BindView(R.id.srl_fix)
    SwipeRefreshLayout mSrlFix;
    @BindView(R.id.rv_fix_order)
    RecyclerView mRvFixOrder;
    Unbinder unbinder;
    private OnRefreshComplete complete;
    private MyTimePickerView mStartPicker;
    private MyTimePickerView mEndPicker;


    @Override
    public int getInflaterView() {
        return R.layout.fragment_fix_order;
    }

    @Override
    protected void initView() {
     /*   try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            endDate = simpleDateFormat.parse(mTvFixOrderTimeContentEnd.getText().toString());
            startDate = simpleDateFormat.parse(mTvFixOrderTimeContentStart.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
*/
        mSrlFix.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData(new OnRefreshComplete() {
                    @Override
                    public void complete() {
                        try {
                            Thread.sleep(2000);
                            mSrlFix.setRefreshing(false);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        fillRVData(mRvFixOrder);
    }

    /**
     * 刷新数据
     *
     * @param onRefreshComplete 刷新完成监听器
     */
    protected abstract void refreshData(OnRefreshComplete onRefreshComplete);

    protected void fillRVData(RecyclerView rvFixOrder) {
        rvFixOrder.setLayoutManager(new LinearLayoutManager(getContext()));
        rvFixOrder.setAdapter(getAdapter());
        addClickListener(rvFixOrder);
    }

    /**
     * 获取适配器
     *
     * @return RecyclerView的适配器
     */
    protected abstract RecyclerView.Adapter getAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view

        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        if (rootView != null) {
            unbinder = ButterKnife.bind(this, rootView);
            return rootView;
        }
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public interface OnRefreshComplete {
        /**
         * 当刷新数据完成是调用
         */
        void complete();
    }

    /**
     * 设置对RecycleView的点击事件监听
     *
     * @param rvFixOrder recyclerView
     */
    protected abstract void addClickListener(RecyclerView rvFixOrder);
  /*  @OnClick({R.id.ll_fix_time_select, R.id.ll_fix_order_time_start, R.id.ll_fix_order_time_end, R.id.ll_fix_order_selected})
    public void onClick(View view) {
        Calendar instance = Calendar.getInstance();
        instance.set(2010, 0, 1);
        switch (view.getId()) {
            case R.id.ll_fix_time_select:
                if (isClose) {
                    mLlFixOrderSelected.setVisibility(View.VISIBLE);
                    mIvFixOrderUpDown.setImageResource(R.drawable.up_gray);
                    isClose = false;
                } else {
                    mLlFixOrderSelected.setVisibility(View.GONE);
                    mIvFixOrderUpDown.setImageResource(R.drawable.drop_gray);
                    isClose = true;
                }
                break;
            case R.id.ll_fix_order_time_start:
                if (mStartPicker == null) {
                    mStartPicker = PickViewUtils.getInstance().getYMDPicker(getActivity(), instance, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            LogUtil.e(TAG, "compare-------==" + DateUtils.compareDate(date, endDate));
                            if (DateUtils.compareDate(date, endDate) != -1)
                                ToastUtil.show(R.string.remind_time_select_before);
                            else {
                                startDate = date;
                                mTvFixOrderTimeContentStart.setText(DateUtils.getTime(date, "天"));
                            }
                        }
                    });
                }
                mStartPicker.show();
                break;
            case R.id.ll_fix_order_time_end:
                if (null == mEndPicker) {
                    mEndPicker = PickViewUtils.getInstance().getYMDPicker(getActivity(), instance, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            if (DateUtils.compareDate(date, startDate) != 1)
                                ToastUtil.show(R.string.remind_time_select);
                            else {
                                endDate = date;
                                mTvFixOrderTimeContentEnd.setText(DateUtils.getTime(date, "天"));
                            }
                        }
                    });
                }
                mEndPicker.show();
                break;
            case R.id.ll_fix_alert_selected:
                break;
        }
    }*/
}
