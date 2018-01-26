package com.locensate.letnetwork.view;

import android.content.Context;
import android.support.v7.widget.AppCompatSpinner;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.utils.DisplayUtil;

import java.util.ArrayList;

/**
 *
 * @author xiaobinghe
 */


public class HeadBar extends LinearLayout {
    private AppCompatSpinner spHead;


    public HeadBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_head_bar, this);
        spHead = (AppCompatSpinner) inflate.findViewById(R.id.sp_head_bar);
    }

    public void setSpHeadAdapter(Context context, ArrayList<String> list) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spHead.setAdapter(adapter);
        spHead.setDropDownVerticalOffset(DisplayUtil.dp2px(-50));
        spHead.setDrawingCacheBackgroundColor(getResources().getColor(R.color.white));
    }

    public AppCompatSpinner getSpHead() {
        return spHead;
    }


}
