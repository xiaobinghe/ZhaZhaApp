package com.locensate.letnetwork.main.ui.fragments.overview.rateanalysis;

import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;


/**
 * @author xiaobinghe
 */


public class OverviewRateAnalysisModel implements OverviewRateAnalysisContract.Model {

    private String[] mParties = new String[]{"经济", "合理", "非经济", "停止"};
    private float[] piePercent = new float[]{41.6f, 16.7f, 33.3f, 8.4f};

    @Override
    public ArrayList<PieEntry> initMockData() {

        ArrayList<PieEntry> entries = new ArrayList<>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < 6; i++) {
            entries.add(new PieEntry(piePercent[i], mParties[i]));
        }
        return entries;
    }
}
