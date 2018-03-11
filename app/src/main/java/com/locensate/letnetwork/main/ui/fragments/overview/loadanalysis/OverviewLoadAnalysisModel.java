package com.locensate.letnetwork.main.ui.fragments.overview.loadanalysis;

import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

/**
 *
 * @author xiaobinghe
 */


public class OverviewLoadAnalysisModel implements OverviewLoadAnalysisContract.Model {

    private String[] mParties = new String[]{"0-20%", "20-40%", "40-60%", "60-80%", "80-100%", "100%以上"};
    private float[] percents = new float[]{10f, 35.8f, 4.2f, 40f, 1.7f, 8.3f};
    @Override
    public ArrayList<PieEntry> initData() {

        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < 6; i++) {
            entries.add(new PieEntry(percents[i], mParties[i]));
        }
        return entries;
    }
}
