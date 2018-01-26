package com.locensate.letnetwork.main.ui.dataanalysis;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xiaobinghe
 */

public class DataAnalysisModel implements DataAnalysisContract.Model {
    @Override
    public List<Entry> getData() {

        ArrayList<Entry> entries = new ArrayList<>();

        for (int i = 0; i <300; i++) {
            entries.add(new Entry(i, (int) (Math.random() * 65) + 40));
        }
        return entries;
    }
}
