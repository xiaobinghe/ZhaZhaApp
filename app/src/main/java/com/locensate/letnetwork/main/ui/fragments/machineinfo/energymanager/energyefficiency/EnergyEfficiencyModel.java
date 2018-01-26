package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager.energyefficiency;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;


/**
 *  
 * @author xiaobinghe
 */


public class EnergyEfficiencyModel implements EnergyEfficiencyContract.Model {
    private String[] mParties = {"经济运行", "合理运行", "停止运行", "非经济运行"};


    @Override
    public ArrayList<PieEntry> getPieData() {
        ArrayList<PieEntry> entries = new ArrayList<>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < mParties.length; i++) {
            entries.add(new PieEntry(getPiePercent()[i], mParties[i]));
        }
        return entries;
    }

    @Override
    public List<List<Entry>> getLineData() {
        List<List<Entry>> lineDatas = new ArrayList<>();
        lineDatas.add(getEntry1());
        lineDatas.add(getEntry2());
        lineDatas.add(getEntry3());
        return lineDatas;
    }

    @Override
    public String[] getLineLabels() {
        String[] dataSets = {"运行效率", "合理运行界定值", "经济运行界定值"};
        return dataSets;
    }

    public float[] getPiePercent() {
        float[] piePercent = new float[4];
        piePercent[0] = 0.3f;
        piePercent[1] = 1.4f;
        piePercent[2] = 95.5f;
        piePercent[3] = 2.8f;
        return piePercent;
    }

    private ArrayList<Entry> getEntry3() {

        ArrayList<Entry> data3 = new ArrayList<Entry>();

        for (int i = 0; i < 300; i++) {
            float val = 0.9f * 5;
            data3.add(new Entry(i, val));
        }

        return data3;
    }

    private ArrayList<Entry> getEntry2() {
        ArrayList<Entry> data2 = new ArrayList<Entry>();

        for (int i = 0; i < 300; i++) {
            float val = 0.5f * 5;
            data2.add(new Entry(i, val));
//            if(i == 10) {
//                yVals2.add(new Entry(i, val + 50));
//            }
        }
        return data2;
    }

    private ArrayList<Entry> getEntry1() {
        ArrayList<Entry> data1 = new ArrayList<Entry>();

        for (int i = 0; i < 300; i++) {
            float val = (float) (Math.random() + 1) / 2;
            data1.add(new Entry(i, val * 5));
        }
        return data1;
    }




}
