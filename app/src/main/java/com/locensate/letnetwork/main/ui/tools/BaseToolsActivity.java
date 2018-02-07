package com.locensate.letnetwork.main.ui.tools;

import android.app.Activity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.utils.PickViewUtils;
import com.locensate.letnetwork.utils.ToastUtil;
import com.locensate.letnetwork.entity.FilterEntity;
import com.locensate.letnetwork.main.ui.search.SearchActivity;
import com.locensate.letnetwork.view.NormalMorePop;
import com.locensate.letnetwork.view.filterpopwindow.FilterPopWindow;
import com.locensate.letnetwork.view.timepick.MyTimePickerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * @author xiaobinghe
 */

public abstract class BaseToolsActivity extends BaseActivity {
    @BindView(R.id.iv_normal_title_back)
    ImageView mIvNormalTitleBack;
    @BindView(R.id.tv_normal_title_content)
    TextView mTvNormalTitleContent;
    @BindView(R.id.iv_normal_title_more)
    ImageView mIvNormalTitleMore;
    @BindView(R.id.tv_time_content_start)
    TextView mTvTimeContentStart;
    @BindView(R.id.tv_time_content_end)
    TextView mTvTimeContentEnd;
    @BindView(R.id.rv_tools_order_list)
    RecyclerView mRvToolsOrderList;
    @BindView(R.id.srl_tools_order)
    SwipeRefreshLayout mSrlToolsOrder;
    @BindView(R.id.ll_time_start)
    LinearLayout mLlTimeStart;
    @BindView(R.id.ll_time_end)
    LinearLayout mLlTimeEnd;
    private Date endDate;
    private Date startDate;
    private NormalMorePop morePop;
    private FilterPopWindow mFilterPopWindow;
    private MyTimePickerView mStartPicker;
    private MyTimePickerView mEndPicker;

    @Override
    public int getLayoutId() {
        return R.layout.activity_tools_order;
    }

    @Override
    public void initView() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            endDate = simpleDateFormat.parse(mTvTimeContentEnd.getText().toString());
            startDate = simpleDateFormat.parse(mTvTimeContentStart.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mTvNormalTitleContent.setText(setTitle());

        mSrlToolsOrder.setColorSchemeResources(R.color.pie_blue, R.color.pie_green, R.color.pie_red);
        setRefreshListener(mSrlToolsOrder);
        mRvToolsOrderList.setLayoutManager(new LinearLayoutManager(this));
        mRvToolsOrderList.setAdapter(setRVAdapter());
    }

    @OnClick({R.id.iv_normal_title_back, R.id.iv_normal_title_more, R.id.ll_time_start, R.id.ll_time_end})
    public void onViewClicked(View view) {
        Calendar instance = Calendar.getInstance();
        instance.set(2010, 0, 1);
        switch (view.getId()) {
            case R.id.iv_normal_title_back:
                this.finish();
                break;
            case R.id.iv_normal_title_more:
                showPop();
                break;
            case R.id.ll_time_start:
                // TODO: 2017/8/1 refresh data and UI
                if (null == mStartPicker) {
                    mStartPicker = PickViewUtils.getInstance().getYMDPicker(this, instance, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            if (DateUtils.compareDate(date, endDate) != -1) {
                                ToastUtil.show(R.string.remind_time_select_before);
                            } else {
                                startDate = date;
                                mTvTimeContentStart.setText(DateUtils.getTime(date, "天"));
                                // TODO: 2017/8/1 refresh data and UI

                            }
                        }
                    });
                }
                mStartPicker.show();
                break;
            case R.id.ll_time_end:
                // TODO: 2017/8/1 refresh data and UI
                if (null == mEndPicker) {
                    mEndPicker = PickViewUtils.getInstance().getYMDPicker(this, instance, new MyTimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            if (DateUtils.compareDate(date, startDate) != 1) {
                                ToastUtil.show(R.string.remind_time_select);
                            } else {
                                endDate = date;
                                mTvTimeContentEnd.setText(DateUtils.getTime(date, "天"));
                                // TODO: 2017/8/1 refresh data and UI

                            }
                        }
                    });
                }
                mEndPicker.show();
                break;
            default:
                break;
        }
    }

    private void showPop() {
        if (null == morePop) {
            morePop = new NormalMorePop(this, R.layout.layout_normal_more_pop, new NormalMorePop.OnItemClickListener() {
                @Override
                public void onClick(int position) {
                    switch (position) {
                        case 0:
                            startActivity(SearchActivity.class);
                            break;
                        case 1:
                            morePop.dismiss();
                            List<FilterEntity> filterData = getFilterData();
                            if (filterData != null) {
                                mFilterPopWindow = new FilterPopWindow(getActivity(), filterData);
                                mFilterPopWindow.show(mIvNormalTitleMore);
                            }
                            break;
                        case 2:
                            break;
                    }
                }
            });
        }
        morePop.showPopupWindow(mIvNormalTitleMore);
    }

    /**/
    protected abstract Activity getActivity();

    /*设置标题*/
    protected abstract CharSequence setTitle();

    /*设置recyclerView的适配器adapter*/
    protected abstract RecyclerView.Adapter setRVAdapter();

    /*设置刷新监听*/
    protected abstract void setRefreshListener(SwipeRefreshLayout swipeRefreshLayout);

    /*获取筛选的数据标签*/
    protected abstract List<FilterEntity> getFilterData();
}
