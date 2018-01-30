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
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.api.Api;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.base.RxSchedulers;
import com.locensate.letnetwork.bean.RemoteParamEntity;
import com.locensate.letnetwork.utils.ToastUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import io.reactivex.functions.Consumer;

/**
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
    private String[] mParamValues;
    private List<String> mValues = new ArrayList<>();
    private ParameterSetRVAdapter paramAdapter;

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


        initData();
        rvSetValues.setLayoutManager(new LinearLayoutManager(this));
        paramAdapter = new ParameterSetRVAdapter(R.layout.item_parameter_set, mValues);
        rvSetValues.setAdapter(paramAdapter);
    }

    private void initData() {
        Api.getInstance().service.getKeyParamConfig(2).compose(RxSchedulers.<RemoteParamEntity>applyObservableAsync()).subscribe(new Consumer<RemoteParamEntity>() {
            @Override
            public void accept(RemoteParamEntity remoteParamEntity) throws Exception {

                RemoteParamEntity.DataBean dataBean = remoteParamEntity.getData();
                tvParameterLabel.setText(dataBean.getKeyParamDescription());
                tvRang.setText(dataBean.getKeyParamScope());
                tvParameterCode.setText(dataBean.getGatewayParam());
                tvUnit.setText(dataBean.getKeyParamUnit());
                mParamValues = dataBean.getKeyParamValueDescription().split(";");
                updata();
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                ToastUtil.show(App.getApplication().getString(R.string.load_fail));
            }
        });

    }

    public void updata() {
        mValues = Arrays.asList(mParamValues);
        paramAdapter.notifyDataSetChanged();
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
