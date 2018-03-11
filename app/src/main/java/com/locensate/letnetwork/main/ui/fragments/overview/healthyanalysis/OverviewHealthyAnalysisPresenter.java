package com.locensate.letnetwork.main.ui.fragments.overview.healthyanalysis;

import com.github.mikephil.charting.data.PieEntry;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.api.Api;
import com.locensate.letnetwork.base.RxSchedulers;
import com.locensate.letnetwork.bean.OverviewHealthAnalysisEntity;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.ToastUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;

import io.reactivex.functions.Consumer;

/**
 * @author xiaobinghe
 */

public class OverviewHealthyAnalysisPresenter extends OverviewHealthyAnalysisContract.Presenter {

    @Override
    public void onStart() {
        if (App.isMock) {
            mView.setData(mModel.initMockData());
            return;
        }
        requestData(mView.getOrganizationId(), mView.getStartMills(), mView.getEndMills());
    }

    public void requestData(final int organizationId, long startTime, long endTime) {
        Api.getInstance().service.getHealthyAnalysisData(organizationId, startTime, endTime).compose(RxSchedulers.<OverviewHealthAnalysisEntity>applyObservableAsync()).subscribe(new Consumer<OverviewHealthAnalysisEntity>() {
            @Override
            public void accept(OverviewHealthAnalysisEntity overviewHealthAnalysisEntity) throws Exception {
                LogUtil.e("OverviewHealthAnalysisEntity", "-----------" + overviewHealthAnalysisEntity.toString() + "----" + organizationId);
                dispatchData(overviewHealthAnalysisEntity);
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

    private void dispatchData(OverviewHealthAnalysisEntity overviewHealthAnalysisEntity) {
        OverviewHealthAnalysisEntity.DataBean data = overviewHealthAnalysisEntity.getData();
        int best_status_count = data.getBest_status_count();
        int better_status_count = data.getBetter_status_count();
        int worse_status_count = data.getWorse_status_count();
        int worst_status_count = data.getWorst_status_count();
        double best_status_power = data.getBest_status_power();
        double better_status_power = data.getBetter_status_power();
        double worse_status_power = data.getWorse_status_power();
        double worst_status_power = data.getWorst_status_power();
        int sumCount = best_status_count + better_status_count + worse_status_count + worst_status_count;
        double sumPower = best_status_power + better_status_power + worse_status_power + worst_status_power;
        if (sumCount == 0) {
            mView.setNoData();
            mView.setData(null);
            return;
        }
        DecimalFormat df = new DecimalFormat("0.0");

        String[] counts = {String.valueOf(best_status_count), String.valueOf(better_status_count), String.valueOf(worse_status_count), String.valueOf(worst_status_count)};

        String[] powerRates = {df.format(best_status_power * 100 / (float) sumPower) + "%", df.format(better_status_power * 100 / (float) sumPower) + "%",
                df.format(worse_status_power * 100 / (float) sumPower) + "%", df.format(worst_status_power * 100 / (float) sumPower) + "%"};

        String[] countRate = {df.format(best_status_count * 100 / (float) sumCount) + "%", df.format(better_status_count * 100 / (float) sumCount) + "%",
                df.format(worse_status_count * 100 / (float) sumCount) + "%", df.format(worst_status_count * 100 / (float) sumCount) + "%"};

        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry((float) (best_status_count / (float) sumCount), "健康"));
        pieEntries.add(new PieEntry((float) (better_status_count / (float) sumCount), "较好"));
        pieEntries.add(new PieEntry((float) (worse_status_count / (float) sumCount), "较差"));
        pieEntries.add(new PieEntry((float) (worst_status_count / (float) sumCount), "差"));
        mView.setNumData(counts, powerRates, countRate);
        mView.setData(pieEntries);
    }
}
