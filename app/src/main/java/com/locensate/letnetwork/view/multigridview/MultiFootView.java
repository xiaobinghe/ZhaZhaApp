package com.locensate.letnetwork.view.multigridview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.locensate.letnetwork.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 * @author xiaobinghe
 */


public class MultiFootView extends LinearLayout implements View.OnClickListener {
    @BindView(R.id.bt_multi_grid_cancel)
    Button btMultiGridCancel;
    @BindView(R.id.bt_multi_grid_complete)
    Button btMultiGridComplete;
    private Context context;
    private OnClickSelector onClickSelector;

    public MultiFootView(Context context) {
        this(context,null);
    }

    public MultiFootView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MultiFootView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MultiFootView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }


    private void initView(Context context) {
        this.context = context;
        inflate(context, R.layout.foot_section_multigrid, null);
    }

    @OnClick({R.id.bt_multi_grid_cancel, R.id.bt_multi_grid_complete})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_multi_grid_cancel:
                onClickSelector.onClickCancel();
                break;
            case R.id.bt_multi_grid_complete:
                onClickSelector.onClickComplet();
                break;
        }
    }

    public void setOnClickSelector(OnClickSelector selector) {
        this.onClickSelector = selector;
    }

    interface OnClickSelector {
        void onClickCancel();

        void onClickComplet();
    }
}
