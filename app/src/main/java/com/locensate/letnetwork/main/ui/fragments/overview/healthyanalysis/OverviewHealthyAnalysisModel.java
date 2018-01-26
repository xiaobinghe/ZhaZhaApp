package com.locensate.letnetwork.main.ui.fragments.overview.healthyanalysis;

import com.github.mikephil.charting.data.PieEntry;
import com.locensate.letnetwork.base.RxBus;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.ToastUtil;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 *  
 * @author xiaobinghe
 */


public class OverviewHealthyAnalysisModel implements OverviewHealthyAnalysisContract.Model {
    @Override
    public ArrayList<PieEntry> initData() {
        RxBus.get().register().map(new Function<Object, String>() {
            @Override
            public String apply(@NonNull Object o) throws Exception {
                return (String) o;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                ToastUtil.show("Healthy");
                LogUtil.e("Healthy:", "--------------" + s);
            }
        });

        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry((float) (Math.random() * 100) + 20, "经济运行"));
        pieEntries.add(new PieEntry((float) (Math.random() * 100) + 20, "非经济运行"));
        pieEntries.add(new PieEntry((float) (Math.random() * 100) + 20, "合理运行"));
        return pieEntries;
    }
}
