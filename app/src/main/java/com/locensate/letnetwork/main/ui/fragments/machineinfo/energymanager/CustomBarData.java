package com.locensate.letnetwork.main.ui.fragments.machineinfo.energymanager;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.List;

/**
 * barData
 *
 * @author xiaobinghe
 */


public class CustomBarData extends BarData {
    private float mBarWidth = 0.85f;

    public CustomBarData() {
        super();
    }

    public CustomBarData(IBarDataSet... dataSets) {
        super(dataSets);
    }

    public CustomBarData(List<IBarDataSet> dataSets) {
        super(dataSets);
    }


    public void barsSpace(float fromX, float barSpace) {
        IBarDataSet iBarDataSet = mDataSets.get(0);
        int entryCount = iBarDataSet.getEntryCount();
        float barSpaceHalf = barSpace / 2f;
        float barWidthHalf = mBarWidth / 2f;
        float interval = mDataSets.size() * (mBarWidth + barSpace);

        for (int i = 0; i < entryCount; i++) {

            float start = fromX;
            for (IBarDataSet set : mDataSets) {

                fromX += barSpaceHalf;
                fromX += barWidthHalf;

                if (i < set.getEntryCount()) {

                    BarEntry entry = set.getEntryForIndex(i);

                    if (entry != null) {
                        entry.setX(fromX);
                    }
                }

                fromX += barWidthHalf;
                fromX += barSpaceHalf;
            }

            float end = fromX;
            float innerInterval = end - start;
            float diff = interval - innerInterval;

            // correct rounding errors
            if (diff > 0 || diff < 0) {
                fromX += diff;
            }
        }

        notifyDataChanged();
    }

}
