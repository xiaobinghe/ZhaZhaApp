package com.locensate.letnetwork.main.ui.tools;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.Gson;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.Constant;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.api.Api;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.base.RxSchedulers;
import com.locensate.letnetwork.bean.KanBanDataEntity;
import com.locensate.letnetwork.bean.Organizations;
import com.locensate.letnetwork.bean._User;
import com.locensate.letnetwork.main.ui.fragments.overview.OverviewModel;
import com.locensate.letnetwork.main.ui.machineinfo.MachineInfoActivity;
import com.locensate.letnetwork.main.ui.search.SearchActivity;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.OrganizationsOption;
import com.locensate.letnetwork.utils.SpUtil;
import com.locensate.letnetwork.utils.ToastUtil;
import com.locensate.letnetwork.view.ExpandablePopWindow;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;

/**
 * @author xiaobinghe
 */

public class ToolsKanBanActivity extends BaseActivity {

    @BindView(R.id.iv_title_only_back)
    ImageView ivTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView tvTitleOnlyBack;
    @BindView(R.id.tv_machine_path)
    TextView tvMachinePath;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.rv_kan_ban)
    RecyclerView rvKanBan;
    @BindView(R.id.srl_kan_ban)
    SwipeRefreshLayout srlKanBan;
    @BindView(R.id.activity_kan_ban)
    LinearLayout activityKanBan;
    @BindView(R.id.iv_left)
    ImageView mIvLeft;
    @BindView(R.id.tv_center)
    TextView mTvCenter;
    @BindView(R.id.iv_right)
    ImageView mIvRight;
    private ExpandablePopWindow expandablePopwindow;
    private KanBanRVAdapter mAdapter;
    private int pageSize = 10;
    private int pageNum = 1;
    private long organizationId;
    private int mTotalPage = 1;
    private boolean isRefresh = false;
    private String organizationName;
    private List<MultiItemEntity> mEntities = new ArrayList<>();
    private CompositeDisposable mCompositeDisposable;

    @Override
    public int getLayoutId() {
        return R.layout.activity_kan_ban;
    }

    @Override
    public void initView() {
        tvTitleOnlyBack.setText("工具-看板");
        srlKanBan.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isRefresh = true;
                request(organizationId, pageNum, pageSize);
            }
        });
        _User user = new Gson().fromJson(SpUtil.getString(App.getApplication(), Constant.USER, ""), _User.class);
        organizationId = user.getData().getOrganization().getOrganizationId();
        organizationName = SpUtil.getString(App.getApplication(), Constant.ENTERPRISE_NAME, "某钢厂");
        tvMachinePath.setText(organizationName);
        rvKanBan.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new KanBanRVAdapter(R.layout.layout_item_kan_ban, new ArrayList<KanBanDataEntity.DataBean.MotorListBean>());
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                KanBanDataEntity.DataBean.MotorListBean bean = (KanBanDataEntity.DataBean.MotorListBean) baseQuickAdapter.getData().get(i);
                Intent intent = new Intent(App.getApplication(), MachineInfoActivity.class);
                Bundle bundle = new Bundle();
                LogUtil.e("motorId", "-----------" + bean.getElectric_motor_id());
                bundle.putLong("motorId", bean.getElectric_motor_id());
                bundle.putString("machineName", bean.getWhole_equipment_name());
                bundle.putInt("pageNum", 3);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        mAdapter.setEnableLoadMore(false);
        rvKanBan.setAdapter(mAdapter);

        mCompositeDisposable = new CompositeDisposable();
        requestOrganization();
        request(organizationId, pageNum, pageSize);

        Observable<Long> observable = Observable.interval(10 * 1000, TimeUnit.MILLISECONDS).doOnNext(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                request(organizationId, pageNum, pageSize);
            }
        });
        DisposableObserver disposable = getDisposable();
        observable.compose(RxSchedulers.<Long>applyObservableAsync()).subscribe(disposable);
        mCompositeDisposable.add(disposable);
    }

    private DisposableObserver getDisposable() {
        return new DisposableObserver<Long>() {
            @Override
            public void onNext(Long kanBanDataEntity) {
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }

    private void requestOrganization() {

        new OverviewModel().getOrganizations().compose(RxSchedulers.<Organizations>applyObservableAsync()).subscribe(new Consumer<Organizations>() {
            @Override
            public void accept(Organizations organizations) throws Exception {
                if (null != organizations) {
                    organizationName = organizations.getData().get(0).getOrganizationName();
                    tvMachinePath.setText(organizationName);
                    mEntities = OrganizationsOption.handleOrganizations(organizations);
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        });

    }

    private void request(long organizationId, int pageNum, int pageSize) {
        Api.getInstance().service.getKanBanData(organizationId, pageNum, pageSize).compose(RxSchedulers.<KanBanDataEntity>applyObservableAsync()).subscribe(new Consumer<KanBanDataEntity>() {
            @Override
            public void accept(KanBanDataEntity kanBanDataEntity) throws Exception {
                KanBanDataEntity.DataBean data = kanBanDataEntity.getData();
                handleData(data);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                ToastUtil.show("暂无数据");
            }
        });
    }

    private void handleData(KanBanDataEntity.DataBean data) {
        if (null == data) {
            ToastUtil.show("暂无数据");
            return;
        }
        mTotalPage = data.getTotal_page();
        pageNum = data.getPage_num();
        if (mTotalPage == 0) {
            mTotalPage = 1;
        }
        if (pageNum > mTotalPage) {
            pageNum = mTotalPage;
        }
        mTvCenter.setText(pageNum + "/" + mTotalPage);
        List<KanBanDataEntity.DataBean.MotorListBean> beanList = data.getMotor_list();
        mAdapter.replaceData(beanList);
        if (isRefresh) {
            srlKanBan.setRefreshing(false);
            isRefresh = false;
        }
    }

    private void showPop(List<MultiItemEntity> groupTree) {
        if (null == expandablePopwindow) {
            expandablePopwindow = new ExpandablePopWindow(this, groupTree);
            expandablePopwindow.setAnimationStyle(R.style.MyPopAnim);
        }
        expandablePopwindow.showAsDropDown(tvMachinePath, 20, 0);
        expandablePopwindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                String temp = expandablePopwindow.getPath();
                if (temp != null) {
                    organizationName = temp;
                    organizationId = expandablePopwindow.getOrganizationId();
                    tvMachinePath.setText(organizationName);
                    request(organizationId, pageNum, pageSize);
                }
            }
        });
    }

    @OnClick({R.id.iv_title_only_back, R.id.tv_machine_path, R.id.iv_search, R.id.iv_left, R.id.iv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_title_only_back:
                finish();
                break;
            case R.id.tv_machine_path:
                if (App.isMock) {
                    showPop(new OverviewModel().getGroupTree());
                    break;
                }
                showPop(mEntities);
                break;
            case R.id.iv_search:
                ToastUtil.show(R.string.function_uncomplete);
                Intent intent = new Intent(App.getApplication(), SearchActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("target", "tools_kanban");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.iv_left:
                LogUtil.e("left", "---pageNum=" + pageNum + "-------------pageSize=" + pageSize + "------------totalPage=" + mTotalPage);
                if (pageNum > 1) {
                    --pageNum;
                    isRefresh = true;
                    srlKanBan.setRefreshing(true);
                    request(organizationId, pageNum, pageSize);
                } else {
                    ToastUtil.show("已经是第一页");
                }
                break;
            case R.id.iv_right:
                LogUtil.e("right", "---pageNum=" + pageNum + "-------------pageSize=" + pageSize + "------------totalPage=" + mTotalPage);
                if (pageNum < mTotalPage) {
                    ++pageNum;
                    srlKanBan.setRefreshing(true);
                    isRefresh = true;
                    request(organizationId, pageNum, pageSize);
                } else {
                    ToastUtil.show("已经是最后一页");
                }
                break;
            default:
                break;
        }
    }

    private class KanBanRVAdapter extends BaseQuickAdapter<KanBanDataEntity.DataBean.MotorListBean, BaseViewHolder> {
        public KanBanRVAdapter(int layoutResId, ArrayList<KanBanDataEntity.DataBean.MotorListBean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, KanBanDataEntity.DataBean.MotorListBean motorListBean) {
            DecimalFormat df = new DecimalFormat("0.00");
            DecimalFormat dfL = new DecimalFormat("0.000");
            baseViewHolder.setText(R.id.tv_machine, motorListBean.getWhole_equipment_name())
                    .setText(R.id.tv_machine_path, motorListBean.getOrganization_name())
                    .setText(R.id.tv_default_power, motorListBean.getRated_power() + "kW")
                    .setText(R.id.tv_real_power, df.format(motorListBean.getP1()) + "kW")
                    .setText(R.id.tv_running_current, df.format(motorListBean.getIO()) + "A")
                    .setText(R.id.tv_real_load_rate, df.format(motorListBean.getBETA() * 100) + "%")
                    .setText(R.id.tv_real_efficiency, dfL.format(motorListBean.getETA()) + "")
                    .setText(R.id.tv_electric_hot, df.format(motorListBean.getQ30() * 100) + "%")
//                    .setTextColor(R.id.tv_electric_hot, motorListBean.isInterrupt() ? getResources().getColor(R.color.font_content_gray) : getResources().getColor(R.color.font_content))
//                    .setTextColor(R.id.tv_real_efficiency, motorListBean.isInterrupt() ? getResources().getColor(R.color.font_content_gray) : getResources().getColor(R.color.font_content))
//                    .setTextColor(R.id.tv_real_load_rate, motorListBean.isInterrupt() ? getResources().getColor(R.color.font_content_gray) : getResources().getColor(R.color.font_content))
//                    .setTextColor(R.id.tv_running_current, motorListBean.isInterrupt() ? getResources().getColor(R.color.font_content_gray) : getResources().getColor(R.color.font_content))
//                    .setTextColor(R.id.tv_real_power, motorListBean.isInterrupt() ? getResources().getColor(R.color.font_content_gray) : getResources().getColor(R.color.font_content))
//                    .setTextColor(R.id.tv_default_power, motorListBean.isInterrupt() ? getResources().getColor(R.color.font_content_gray) : getResources().getColor(R.color.font_content))
//                    .setTextColor(R.id.tv_electric_hot_below, motorListBean.isInterrupt() ? getResources().getColor(R.color.font_gray) : getResources().getColor(R.color.font_content))
//                    .setTextColor(R.id.tv_electric_hot_below_, motorListBean.isInterrupt() ? getResources().getColor(R.color.font_gray) : getResources().getColor(R.color.font_content))
//                    .setTextColor(R.id.tv_real_efficiency_below, motorListBean.isInterrupt() ? getResources().getColor(R.color.font_gray) : getResources().getColor(R.color.font_content))
//                    .setTextColor(R.id.tv_real_load_rate_below, motorListBean.isInterrupt() ? getResources().getColor(R.color.font_gray) : getResources().getColor(R.color.font_content))
//                    .setTextColor(R.id.tv_running_current_below, motorListBean.isInterrupt() ? getResources().getColor(R.color.font_gray) : getResources().getColor(R.color.font_content))
//                    .setTextColor(R.id.tv_real_power_below, motorListBean.isInterrupt() ? getResources().getColor(R.color.font_gray) : getResources().getColor(R.color.font_content))
//                    .setTextColor(R.id.tv_default_power_below, motorListBean.isInterrupt() ? getResources().getColor(R.color.font_gray) : getResources().getColor(R.color.font_content))
                    .setVisible(R.id.iv_interrupt, false)
                    .addOnClickListener(R.id.ll_kanban_item)
                    .setBackgroundColor(R.id.ll_alert_level, selectColor(motorListBean.getRunning_status()));
        }

        private int selectColor(String status) {
            Resources resources = getResources();
            if ("停止".equals(status)) {
                return resources.getColor(R.color.alert_stop);
            } else if ("".equals(status)) {
                return resources.getColor(R.color.alert_high);
            } else if ("low".equals(status)) {
                return resources.getColor(R.color.alert_low);
            } else {
                return resources.getColor(R.color.normal_green);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }
}
