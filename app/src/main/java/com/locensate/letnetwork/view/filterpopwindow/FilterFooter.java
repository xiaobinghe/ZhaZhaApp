package com.locensate.letnetwork.view.filterpopwindow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.locensate.letnetwork.R;


/**
 *
 * @author xiaobinghe
 */

public class FilterFooter extends LinearLayout {
    private Context context;
    private Button okay;
    private Button reset;
    private FooterClickListener listener;

    public FilterFooter(Context context) {
        super(context);
        init(context);
    }

    public FilterFooter(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FilterFooter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.foot_section_multigrid, this);
        this.addView(inflate);
        okay = (Button) inflate.findViewById(R.id.bt_multi_grid_complete);
        reset = (Button) inflate.findViewById(R.id.bt_multi_grid_cancel);
        okay.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickOkay();
            }
        });
        reset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickReset();
            }
        });
    }

    interface FooterClickListener  {
        void onClickOkay();

        void onClickReset();
    }

    public void setClickListener(FooterClickListener listener) {
        this.listener = listener;
    }
}
