package com.locensate.letnetwork.main.ui.fragments.machine;


import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.Gson;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.Constant;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.api.Api;
import com.locensate.letnetwork.base.RxSchedulers;
import com.locensate.letnetwork.bean.MachineFilterTag;
import com.locensate.letnetwork.bean.MotorListEntity;
import com.locensate.letnetwork.bean.Organizations;
import com.locensate.letnetwork.bean._User;
import com.locensate.letnetwork.main.ui.fragments.overview.OverviewModel;
import com.locensate.letnetwork.utils.DateUtils;
import com.locensate.letnetwork.utils.OrganizationsOption;
import com.locensate.letnetwork.utils.SpUtil;
import com.locensate.letnetwork.utils.ToastUtil;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * @author xiaobinghe
 */

public class MachinePresenter extends MachineContract.Presenter {

    private int organizationId;
    private long startMills;
    private long endMills;
    private List<MultiItemEntity> mOrganizations;
    private String mOrganizationName;

    @Override
    public void onStart() {

        _User user = new Gson().fromJson(SpUtil.getString(App.getApplication(), Constant.USER, ""), _User.class);
        organizationId = user.getData().getOrganization().getOrganizationId();

        Date date = new Date();
        Date[] startAndEnd = DateUtils.getFirstAndEndDayDateOfWeek(date);
        startMills = startAndEnd[0].getTime();
        endMills = startAndEnd[1].getTime();
        mView.initTimeTypeAndValue("周", startAndEnd);

        refreshList(1, 10, Constant.DESC);
        refreshFilter();
        initOrganization();
    }

    @Override
    public void showPop() {
        if (App.isMock) {
            mView.showPop(new OverviewModel().getGroupTree());
            return;
        }
        mView.showPop(mOrganizations);
    }

    private void initOrganization() {
        mModel.getOrganizations().compose(RxSchedulers.<Organizations>applyObservableAsync()).subscribe(new Consumer<Organizations>() {
            @Override
            public void accept(@NonNull Organizations organizations) throws Exception {
                mOrganizationName = organizations.getData().get(0).getOrganizationName();
                SpUtil.saveString(App.getApplication(), Constant.ENTERPRISE_NAME, "——");
                mOrganizations = OrganizationsOption.handleOrganizations(organizations);
                mView.setTitleText(mOrganizationName);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                ToastUtil.show(App.getApplication().getString(R.string.load_fail));
            }
        });
    }

    @Override
    public void markImportant(MotorListEntity.DataBean.ListBean item) {
        mModel.postImpotantMachine(item);
    }

    @Override
    public void refreshList(int pageNum, int pageSize, String sort) {

        if (App.isMock) {
            mView.fillData(mModel.getMachineList());
            return;
        }

        Api.getInstance().service.getMotorList(organizationId, startMills, endMills, pageNum, pageSize, sort).compose(RxSchedulers.<MotorListEntity>applyObservableAsync()).subscribe(new Consumer<MotorListEntity>() {
            @Override
            public void accept(MotorListEntity motorListEntity) throws Exception {

                MotorListEntity.DataBean data = motorListEntity.getData();
                analyzeData(data);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (mView.isRefresh()) {
                    mView.refreshFaild();
                } else {
                    mView.loadMoreFaild();
                }
                ToastUtil.show(App.getApplication().getString(R.string.load_fail));
            }
        });
    }

    private void analyzeData(MotorListEntity.DataBean data) {
        int motor_count = data.getMotor_count();
        double power_count = data.getPower_count();
        DecimalFormat df = new DecimalFormat("0");
        mView.statisticsData(motor_count, df.format(power_count));
        List<MotorListEntity.DataBean.ListBean> list = data.getList();
        if (mView.isRefresh()) {
            mView.refreshSuccess(list);
        } else {
            if (list == null || (list.size() == 0)) {
                mView.loadMoreFaild();
            } else {
                mView.loadMoreSuccess(list);
            }
        }

    }

    @Override
    public void refreshFilter() {
        if (App.isMock) {
            mView.fillFilter(mModel.getFilterDefault());
            return;
        }

        mModel.getFilterTags().compose(RxSchedulers.<MachineFilterTag>applyObservableAsync()).subscribe(new Consumer<MachineFilterTag>() {
            @Override
            public void accept(MachineFilterTag machineFilterTag) throws Exception {
                mView.fillFilter(machineFilterTag);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                ToastUtil.show(App.getApplication().getString(R.string.load_fail));
            }
        });
    }

    @Override
    public void setImportantMachine(String id, String importantMachine, boolean important) {
//        mView.showDialog(important);
//        isImprotant();
    }

    public void setOrganizationId(int organizationId) {
        if (organizationId == this.organizationId) {
            return;
        }
        this.organizationId = organizationId;
        refreshList(1, 10, mView.getSortType());
    }

    @Override
    public void setTimeRange(long startMills, long endMills) {
        if (this.startMills == startMills && this.endMills == endMills) {
            return;
        }
        this.startMills = startMills;
        this.endMills = endMills;
        refreshList(1, 10, mView.getSortType());
    }

}
