package com.locensate.letnetwork.main.ui.fragments.machineinfo.healthmanager;

import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

/**
 * 设备-健康管理
 *
 * @author xiaobinghe
 */

public class MachineInfoHealthyManagerModel implements MachineInfoHealthyManagerContract.Model {

    @Override
    public ArrayList<PieEntry> getPieTempData() {
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(80f));
        pieEntries.add(new PieEntry(20f));
        return pieEntries;
    }

    @Override
    public ArrayList<PieEntry> getPieSharkData() {
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(70f));
        pieEntries.add(new PieEntry(30f));
        return pieEntries;
    }

    @Override
    public ArrayList<PieEntry> getPieElectHotterData() {
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(70f));
        pieEntries.add(new PieEntry(30f));
        return pieEntries;
    }

    @Override
    public ArrayList<PieEntry> getPieStartCountData() {
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(85f));
        pieEntries.add(new PieEntry(15f));
        return pieEntries;
    }

    @Override
    public ArrayList<PieEntry> getPieCurrentOverData() {
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(85f));
        pieEntries.add(new PieEntry(15f));
        return pieEntries;
    }

    @Override
    public ArrayList<PieEntry> getPieElectHotter30Data() {
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(70f));
        pieEntries.add(new PieEntry(30f));
        return pieEntries;
    }
}
