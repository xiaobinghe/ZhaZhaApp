package com.locensate.letnetwork.view.markView;

import android.content.Context;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.utils.LogUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiaobinghe
 */

public class MyMarkerView extends MarkerView {

    private final long startTime;
    private TextView tvContentX;
    private TextView tvContentY;

    private SimpleDateFormat mFormat = new SimpleDateFormat("MM/dd HH:mm:ss");

    public MyMarkerView(Context context, int layoutResource, long startTime) {
        super(context, layoutResource);
        this.startTime = startTime;
        tvContentX = (TextView) findViewById(R.id.tvContentX);
        tvContentY = (TextView) findViewById(R.id.tvContentY);
    }

    // callbacks everytime the MarkerView is redrawn, can be used to update the
    // content (user-interface)
    @Override
    public void refreshContent(Entry e, Highlight highlight) {

        if (e instanceof CandleEntry) {

            CandleEntry ce = (CandleEntry) e;

            tvContentX.setText("" + Utils.formatNumber(ce.getHigh(), 0, true));
        } else {

//            tvContent.setText("" + Utils.formatNumber(e.getY(), 0, true));

            LogUtil.e("MarkView", "-----------" + new Date(startTime + (long) e.getX()));
            tvContentX.setText("X:" + mFormat.format(new Date(startTime + (long) e.getX())));
            tvContentY.setText("Y:" + e.getY());
        }

        super.refreshContent(e, highlight);
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }
}
