package com.locensate.letnetwork.main.ui.fragments.overview.rateanalysis;

import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;


/**
 *
 * @author xiaobinghe
 */


public class OverviewRateAnalysisModel implements OverviewRateAnalysisContract.Model {
    @Override
    public ArrayList<PieEntry> initData() {
//        RxBus.get().register().map(new Function<Object, String>() {
//            @Override
//            public String apply(@NonNull Object o) throws Exception {
//                return (String) o;
//            }
//        }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(@NonNull String s) throws Exception {
//                    ToastUtil.show("RateAnalysis");
//                    LogUtil.e("RateAnalysis:", "--------------" + s);
//            }
//        });

        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry((float) (Math.random() * 100) + 20, "经济运行"));
        pieEntries.add(new PieEntry((float) (Math.random() * 100) + 20, "非经济运行"));
        pieEntries.add(new PieEntry((float) (Math.random() * 100) + 20, "合理运行"));
        return pieEntries;
    }
}
