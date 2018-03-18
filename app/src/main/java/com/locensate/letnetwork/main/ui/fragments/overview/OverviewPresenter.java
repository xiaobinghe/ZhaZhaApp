package com.locensate.letnetwork.main.ui.fragments.overview;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.Gson;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.Constant;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.api.Api;
import com.locensate.letnetwork.base.RxSchedulers;
import com.locensate.letnetwork.bean.Organizations;
import com.locensate.letnetwork.bean.OverviewAllAnalysisEntity;
import com.locensate.letnetwork.bean.OverviewMotor;
import com.locensate.letnetwork.bean._User;
import com.locensate.letnetwork.main.ui.fragments.overview.healthyanalysis.OverviewHealthyAnalysisFragment;
import com.locensate.letnetwork.main.ui.fragments.overview.loadanalysis.OverviewLoadAnalysisFragment;
import com.locensate.letnetwork.main.ui.fragments.overview.rateanalysis.OverviewRateAnalysisFragment;
import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.OrganizationsOption;
import com.locensate.letnetwork.utils.SpUtil;
import com.locensate.letnetwork.utils.ToastUtil;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import io.reactivex.functions.Consumer;

import static android.content.ContentValues.TAG;

/**
 * @author xiaobinghe
 */

public class OverviewPresenter extends OverviewContract.Presenter {
    public long startMills;
    public long endMills;
    public int organizationId;
    private List<MultiItemEntity> mEntities;
    private String mOrganizationName;

    @Override
    public void onStart() {
        if (App.isMock) {
            fillMonitorOverviewData(1);
            return;
        }
        mView.fillContain();
        _User user = new Gson().fromJson(SpUtil.getString(App.getApplication(), Constant.USER, ""), _User.class);
        organizationId = user.getData().getOrganization().getOrganizationId();
        Date date = new Date();
        Date[] startAndEnd = DateUtils.getFirstAndEndDayDateOfWeek(date);
        startMills = startAndEnd[0].getTime();
        endMills = startAndEnd[1].getTime();
//        fillMonitorOverviewData(organizationId);
        mView.initTimeTypeAndValue("周", startAndEnd);
        notifyChildFragments(organizationId, startMills, endMills);
        initOrganizations();
    }

    public void fillMonitorOverviewData(int organizationId) {
        if (App.isMock) {
            mView.fillContain();
            return;
        }
        mModel.getBaseDate(organizationId).compose(RxSchedulers.<OverviewMotor>applyObservableAsync()).subscribe(new Consumer<OverviewMotor>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull OverviewMotor overviewMotor) throws Exception {
                mView.initData(overviewMotor);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull Throwable throwable) throws Exception {
                ToastUtil.show(App.getApplication().getString(R.string.load_fail));
            }
        });
//        mView.fillContain(mModel.getContainFragment(mView.getRangeItem()));
    }

    @Override
    public void showPop() {
        if (App.isMock) {
            mView.showPop(mModel.getGroupTree());
            return;
        }
        mView.showPop(mEntities);
    }

    private void initOrganizations() {
        mModel.getOrganizations().compose(RxSchedulers.<Organizations>applyObservableAsync()).subscribe(new Consumer<Organizations>() {
            @Override
            public void accept(@NonNull Organizations organizations) throws Exception {
                LogUtil.e(TAG, "----------" + organizations.getOperCode() + "------" + organizations.toString());
                mOrganizationName = organizations.getData().get(0).getOrganizationName();
                SpUtil.saveString(App.getApplication(), Constant.ENTERPRISE_NAME, "——");
                mView.setTitleText(mOrganizationName);
                mEntities = OrganizationsOption.handleOrganizations(organizations);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                LogUtil.e(TAG, "------------" + throwable);
                ToastUtil.show("服务器开小差了，请稍后重试");
            }
        });
    }

    @Override
    public void setTimeRange(long startMills, long endMills) {
        if (this.startMills == startMills && this.endMills == endMills) {
            return;
        }
        this.startMills = startMills;
        this.endMills = endMills;
        notifyChildFragments(organizationId, startMills, endMills);
    }

    @Override
    public void setOrganizationId(int organizationId) {
        if (organizationId == this.organizationId) {
            return;
        }
        this.organizationId = organizationId;
        notifyChildFragments(organizationId, startMills, endMills);
    }

    @Override
    public void notifyChildFragments(int organizationId, long startMills, long endMills) {
        fillMonitorOverviewData(organizationId);
        fillOverAllAnalysisData(organizationId, startMills, endMills);
        Fragment[] fragments = mView.getChildFragments();
        ((OverviewRateAnalysisFragment) fragments[0]).acceptOrganizationId(organizationId, startMills, endMills);
        ((OverviewLoadAnalysisFragment) fragments[1]).acceptOrganizationId(organizationId, startMills, endMills);
        ((OverviewHealthyAnalysisFragment) fragments[2]).acceptOrganizationId(organizationId, startMills, endMills);
    }

    private void fillOverAllAnalysisData(int organizationId, long startMills, long endMills) {
        Api.getInstance().service.getOverAllAnalysisData(organizationId, startMills, endMills).compose(RxSchedulers.<OverviewAllAnalysisEntity>applyObservableAsync()).subscribe(new Consumer<OverviewAllAnalysisEntity>() {
            @Override
            public void accept(OverviewAllAnalysisEntity overviewAllAnalysisEntity) throws Exception {
                OverviewAllAnalysisEntity.DataBean dataBean = overviewAllAnalysisEntity.getData();
                dispatchData(dataBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                LogUtil.e("throwable", "----" + throwable.getCause() + "---------" + throwable.getMessage().toString() + "----" + throwable.getMessage());
                mView.fillAllAnalysisData("——", "——", "——", "——");
            }
        });

    }

    private void dispatchData(OverviewAllAnalysisEntity.DataBean dataBean) {
        double average_efficiency_total = dataBean.getAverage_efficiency_total();
        double average_loading = dataBean.getAverage_loading();
        double power_consumption_total = dataBean.getPower_consumption_total();
        double no_loading_consumption_total = dataBean.getNo_loading_consumption_total();
        DecimalFormat dfInt = new DecimalFormat("0");
        DecimalFormat dfFloat = new DecimalFormat("0.00");
        DecimalFormat dfL = new DecimalFormat("0.000");
        String powerConsumptionTotal = dfInt.format(power_consumption_total) + "kWh";
        String averageEfficiency = dfL.format(average_efficiency_total);
        String averageLoadRate = dfFloat.format(average_loading * 100) + "%";
        String noLoadConsumption = dfInt.format(no_loading_consumption_total) + "kWh";
        mView.fillAllAnalysisData(powerConsumptionTotal, averageEfficiency, averageLoadRate, noLoadConsumption);
    }
}
