package com.locensate.letnetwork.main.ui.fragments.overview.healthyanalysis;

import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

/**
 * @author xiaobinghe
 */


public class OverviewHealthyAnalysisModel implements OverviewHealthyAnalysisContract.Model {
    private String[] mParties = new String[]{"健康", "较好", "较差", "差"};
    private float[] percents = new float[]{16.7f, 37.5f, 37.5f, 8.3f};
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
//                ToastUtil.show("Healthy");
//                LogUtil.e("Healthy:", "--------------" + s);
//            }
//        });


        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry((float) (Math.random() * 100) + 20, "经济运行"));
        pieEntries.add(new PieEntry((float) (Math.random() * 100) + 20, "非经济运行"));
        pieEntries.add(new PieEntry((float) (Math.random() * 100) + 20, "合理运行"));
        return pieEntries;
    }

    @Override
    public ArrayList<PieEntry> initMockData() {
           ArrayList<PieEntry> entries = new ArrayList<>();
        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < 4; i++) {
            entries.add(new PieEntry(percents[i], mParties[i]));
        }
        return entries;
    }
}
