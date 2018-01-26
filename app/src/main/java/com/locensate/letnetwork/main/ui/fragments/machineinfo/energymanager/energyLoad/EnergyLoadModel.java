package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyLoad;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

/**
 * @author xiaobinghe
 */


public class EnergyLoadModel implements EnergyLoadContract.Model {


    private String[] mParties = {"重载", "过载", "空载", "停止", "轻载", "半载"};

    @Override
    public ArrayList<BarEntry> getBarData() {
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        float start = 1f;
        for (int i = (int) start; i < start + 7; i++) {
            float mult = (20 + 1);
            float val = (float) (Math.random() * mult * 3.6 < 40 ? 40 : Math.random() * mult * 3.6);
            barEntries.add(new BarEntry(i, val));
        }
        return barEntries;
    }

    @Override
    public ArrayList<PieEntry> getPieData() {
        ArrayList<PieEntry> entries = new ArrayList<>();
        float[] percent = getPercent();
        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < percent.length; i++) {
            entries.add(new PieEntry(percent[i], mParties[i]));
        }
        return entries;
    }

    @Override
    public ArrayList<Entry> getLineData() {
        ArrayList<Entry> entries = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            entries.add(new Entry(i, (float) (Math.random() * 40)));
        }
        return entries;
    }

    @Override
    public String[] getDataLabels() {
        String[] dataSet = {"负载率"};
        return dataSet;
    }

    private float[] getPercent() {
        float[] piePercent = new float[6];
        piePercent[0] = 1.4f;
        piePercent[1] = 0.3f;
        piePercent[2] = 13.9f;
        piePercent[3] = 2.8f;
        piePercent[4] = 60.8f;
        piePercent[5] = 20.8f;
        return piePercent;
    }

}
