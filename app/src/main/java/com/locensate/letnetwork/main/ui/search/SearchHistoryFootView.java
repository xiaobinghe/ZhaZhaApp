package com.locensate.letnetwork.main.ui.search;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.locensate.letnetwork.R;

/**
 *
 * @author xiaobinghe
 */

public class SearchHistoryFootView extends View {
    public SearchHistoryFootView(Context context) {
        super(context);
        initView(context);
    }

    public SearchHistoryFootView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public SearchHistoryFootView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SearchHistoryFootView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        View view = View.inflate(context, R.layout.layout_history_search_foot, null);
        TextView btt = (TextView) view.findViewById(R.id.bt_history_clear);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return true;
    }
}
