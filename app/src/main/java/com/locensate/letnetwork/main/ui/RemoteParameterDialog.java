package com.locensate.letnetwork.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 *  
 * @author xiaobinghe
 */

public class RemoteParameterDialog extends BaseActivity {

    @BindView(R.id.tv_parameter_label)
    TextView tvParameterLabel;
    @BindView(R.id.tv_parameter_code)
    TextView tvParameterCode;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.tv_rang)
    TextView tvRang;
    @BindView(R.id.tv_unit)
    TextView tvUnit;
    @BindView(R.id.textView10)
    TextView textView10;
    @BindView(R.id.rv_set_values)
    RecyclerView rvSetValues;
    @BindView(R.id.activity_remote_parameter_dialog)
    RelativeLayout activityRemoteParameterDialog;
    private String parameterId;
    private String parameterLabel;
    private List<String> sets;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_remote_parameter_dialog;
    }

    @Override
    public void initView() {
        Intent data = getIntent();
        parameterId = data.getStringExtra("parameterId");
        parameterLabel = data.getStringExtra("parameterLabel");
        tvParameterLabel.setText(parameterLabel);
        tvRang.setText("0-1");
        tvParameterCode.setText("P002");
        tvUnit.setText("1");
        rvSetValues.setLayoutManager(new LinearLayoutManager(this));
        rvSetValues.setAdapter(new ParameterSetRVAdapter(R.layout.item_parameter_set, getSets()));
    }

    public List<String> getSets() {
        sets = new ArrayList<>();
        sets.add("0-过载保护关闭");
        sets.add("1-过载保护打开");
        return sets;
    }

    private class ParameterSetRVAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public ParameterSetRVAdapter(int item_parameter_set, List<String> sets) {
            super(item_parameter_set, sets);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, String data) {
            baseViewHolder.setText(R.id.tv_parameter_set_value, data);
        }
    }
}
