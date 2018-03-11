package com.locensate.letnetwork.main.ui.fragments.overview.loadanalysis;

import com.github.mikephil.charting.data.PieEntry;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.api.Api;
import com.locensate.letnetwork.base.RxSchedulers;
import com.locensate.letnetwork.bean.OverviewLoadAnalysisEntity;
import com.locensate.letnetwork.utils.ToastUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;

import io.reactivex.functions.Consumer;

/**
 * @author xiaobinghe
 */

public class OverviewLoadAnalysisPresenter extends OverviewLoadAnalysisContract.Presenter {

    //    private String[] mParties = new String[]{"空载", "轻载", "半载", "重载", "过载", "停止"};

    @Override
    public void onStart() {
        if (App.isMock) {
            mView.setData(mModel.initData());
            return;
        }

        requestData(mView.getOrganizationId(), mView.getStartMills(), mView.getEndMills());
    }

    @Override
    public void requestData(int organizationId, long startMills, long endMills) {
        Api.getInstance().service.getLoadAnalysisData(organizationId, startMills, endMills).compose(RxSchedulers.<OverviewLoadAnalysisEntity>applyObservableAsync()).subscribe(new Consumer<OverviewLoadAnalysisEntity>() {
            @Override
            public void accept(OverviewLoadAnalysisEntity overviewLoadAnalysisEntity) throws Exception {
                dispatchData(overviewLoadAnalysisEntity);
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

    private void dispatchData(OverviewLoadAnalysisEntity overviewLoadAnalysisEntity) {
        OverviewLoadAnalysisEntity.DataBean data = overviewLoadAnalysisEntity.getData();
        int half_loading_count = data.getHalf_loading_count();
        double half_loading_power = data.getHalf_loading_power();
        int light_loading_count = data.getLight_loading_count();
        double light_loading_power = data.getLight_loading_power();
        int heavy_loading_count = data.getHeavy_loading_count();
        double heavy_loading_power = data.getHeavy_loading_power();
        int over_loading_count = data.getOver_loading_count();
        double over_loading_power = data.getOver_loading_power();
        int no_loading_count = data.getNo_loading_count();
        double no_loading_power = data.getNo_loading_power();
        int stop_loading_count = data.getStop_loading_count();
        double stop_loading_power = data.getStop_loading_power();

        int sumCount = half_loading_count + light_loading_count + heavy_loading_count + over_loading_count + no_loading_count + stop_loading_count;

        if (sumCount<1){
            mView.setNoData();
            mView.setData(null);
            return;
        }
        double sumPower = half_loading_power + light_loading_power + heavy_loading_power + over_loading_power + no_loading_power + stop_loading_power;
        DecimalFormat df = new DecimalFormat("0.0");

        String[] powerRates = {df.format(no_loading_power * 100 / (float) sumPower) + "%", df.format(light_loading_power * 100 / (float) sumPower) + "%",
                df.format(half_loading_power * 100 / (float) sumPower) + "%", df.format(heavy_loading_power * 100 / (float) sumPower) + "%",
                df.format(over_loading_power * 100 / (float) sumPower) + "%", df.format(stop_loading_power * 100 / (float) sumPower) + "%"};

        String[] countRate = {df.format(no_loading_count * 100 / (float) sumCount) + "%", df.format(light_loading_count * 100 / (float) sumCount) + "%",
                df.format(half_loading_count * 100 / (float) sumCount) + "%", df.format(heavy_loading_count * 100 / (float) sumCount) + "%",
                df.format(over_loading_count * 100 / (float) sumCount) + "%", df.format(stop_loading_count * 100 / (float) sumCount) + "%"};

        String[] counts = {String.valueOf(no_loading_count), String.valueOf(light_loading_count), String.valueOf(half_loading_count),
                String.valueOf(heavy_loading_count), String.valueOf(over_loading_count), String.valueOf(stop_loading_count)};


        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry((float) (no_loading_count / (float) sumCount), "空载"));
        pieEntries.add(new PieEntry((float) (light_loading_count / (float) sumCount), "轻载"));
        pieEntries.add(new PieEntry((float) (half_loading_count / (float) sumCount), "半载"));
        pieEntries.add(new PieEntry((float) (heavy_loading_count / (float) sumCount), "重载"));
        pieEntries.add(new PieEntry((float) (over_loading_count / (float) sumCount), "过载"));
        pieEntries.add(new PieEntry((float) (stop_loading_count / (float) sumCount), "停止"));
        mView.setNumData(counts, powerRates, countRate);
        mView.setData(pieEntries);
    }
}
