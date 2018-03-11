package com.locensate.letnetwork.main.ui.fragments.overview.rateanalysis;

import com.github.mikephil.charting.data.PieEntry;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.api.Api;
import com.locensate.letnetwork.base.RxSchedulers;
import com.locensate.letnetwork.bean.OverviewEfficiencyAnalysisEntity;
import com.locensate.letnetwork.utils.ToastUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;

import io.reactivex.functions.Consumer;

/**
 * @author xiaobinghe
 */


public class OverviewRateAnalysisPresenter extends OverviewRateAnalysisContract.Presenter {
    @Override
    public void onStart() {
        if (App.isMock) {
            mView.setData(mModel.initMockData());
            return;
        }
        requestData(mView.getOrganizationId(), mView.getStartMills(), mView.getEndMills());
    }

    @Override
    public void requestData(int organizationId, long startMills, long endMills) {
        Api.getInstance().service.getEfficiencyAnalysisData(organizationId, startMills, endMills).compose(RxSchedulers.<OverviewEfficiencyAnalysisEntity>applyObservableAsync()).subscribe(new Consumer<OverviewEfficiencyAnalysisEntity>() {
            @Override
            public void accept(OverviewEfficiencyAnalysisEntity overviewEfficiencyAnalysisEntity) throws Exception {
                dispatchData(overviewEfficiencyAnalysisEntity);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mView.setNoData();
                mView.setData(null);
                ToastUtil.show(R.string.load_fail);
            }
        });
    }

    private void dispatchData(OverviewEfficiencyAnalysisEntity overviewEfficiencyAnalysisEntity) {
        OverviewEfficiencyAnalysisEntity.DataBean data = overviewEfficiencyAnalysisEntity.getData();
        int economy_running_count = data.getEconomy_running_count();
        double economy_running_power = data.getEconomy_running_power();
        int rational_running_count = data.getRational_running_count();
        double rational_running_power = data.getRational_running_power();
        int uneconomic_running_count = data.getUneconomic_running_count();
        double uneconomic_running_power = data.getUneconomic_running_power();
        int stop_running_count = data.getStop_running_count();
        double stop_running_power = data.getStop_running_power();
        int sumCount = economy_running_count + rational_running_count + uneconomic_running_count + stop_running_count;

        if (sumCount < 1) {
            mView.setNoData();
            mView.setData(null);
            return;
        }
        double sumPower = economy_running_power + rational_running_power + uneconomic_running_power + stop_running_power;
        DecimalFormat df = new DecimalFormat("0.0");

        String[] powerRates = {df.format(economy_running_power * 100 / (float) sumPower) + "%", df.format(rational_running_power * 100 / (float) sumPower) + "%",
                df.format(uneconomic_running_power * 100 / (float) sumPower) + "%", df.format(stop_running_power * 100 / (float) sumPower) + "%"};

        String[] countRate = {df.format(economy_running_count * 100 / (float) sumCount) + "%", df.format(rational_running_count * 100 / (float) sumCount) + "%",
                df.format(uneconomic_running_count * 100 / (float) sumCount) + "%", df.format(stop_running_count * 100 / (float) sumCount) + "%"};

        String[] counts = {String.valueOf(economy_running_count), String.valueOf(rational_running_count), String.valueOf(uneconomic_running_count), String.valueOf(stop_running_count)};


        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry((float) (economy_running_count / (float) sumCount), "经济"));
        pieEntries.add(new PieEntry((float) (rational_running_count / (float) sumCount), "合理"));
        pieEntries.add(new PieEntry((float) (uneconomic_running_count / (float) sumCount), "非经济"));
        pieEntries.add(new PieEntry((float) (stop_running_count / (float) sumCount), "停止"));
        mView.setNumData(counts, powerRates, countRate);
        mView.setData(pieEntries);
    }
}
