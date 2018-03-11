package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyfgp;

import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

/**
 * @author xiaobinghe
 */


public class EnergyFengGuPingModel implements EnergyFengGuPingConstract.Model {
    private float[] piePercent = new float[3];
    private String[] mParties = {"峰电", "谷电", "平电"};

    public ArrayList<PieEntry> getPieMockData() {

        initPieData();
        ArrayList<PieEntry> entries = new ArrayList<>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < 3; i++) {
            entries.add(new PieEntry(piePercent[i], mParties[i]));
        }
        return entries;
    }

    private void initPieData() {
        piePercent[0] = 47.3f;
        piePercent[1] = 20.2f;
        piePercent[2] = 32.5f;

    }

}
