package com.locensate.letnetwork.main.ui;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.api.Api;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.base.RxSchedulers;
import com.locensate.letnetwork.bean.RemoteParams;
import com.locensate.letnetwork.entity.RemoteParameterBean;
import com.locensate.letnetwork.entity.RemoteParameterEntity;
import com.locensate.letnetwork.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

/**
 * @author xiaobinghe
 */

public class RemoteParameterActivity extends BaseActivity {

    @BindView(R.id.rv_remote_parameter)
    RecyclerView rvRemoteParameter;
    @BindView(R.id.activity_remote_parameter)
    LinearLayout activityRemoteParameter;
    @BindView(R.id.iv_title_only_back)
    ImageView ivTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView tvTitleOnlyBack;

    @Override
    public int getLayoutId() {
        return R.layout.activity_remote_parameter;
    }

    @Override
    public void initView() {
        tvTitleOnlyBack.setText("远程参数");
        initData();
        rvRemoteParameter.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        rvRemoteParameter.setAdapter(new RemoteParameterRVAdapter(R.layout.item_remote_parameter, 0, getData()));
        rvRemoteParameter.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RemoteParameterEntity item = (RemoteParameterEntity) baseQuickAdapter.getItem(i);
                RemoteParameterBean parameterBean = item.t;
                ToastUtil.show(parameterBean.getLabel() + ":" + parameterBean.getValue());
                Intent intent = new Intent(RemoteParameterActivity.this, RemoteParameterDialog.class);
                intent.putExtra("parameterId", parameterBean.getId());
                intent.putExtra("parameterLabel", parameterBean.getLabel());
                startActivity(intent);
            }
        });
    }

    private void initData() {
        Api.getInstance().service.getRemoteParams(18, 18).compose(RxSchedulers.<RemoteParams>applyObservableAsync()).subscribe(new Consumer<RemoteParams>() {
            @Override
            public void accept(RemoteParams remoteParams) throws Exception {
                // TODO: 2018/1/30 解析数据


            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                ToastUtil.show(App.getApplication().getString(R.string.load_fail));
            }
        });
    }

    private List<RemoteParameterEntity> getData() {
        ArrayList<RemoteParameterEntity> entities = new ArrayList<>();
        entities.add(new RemoteParameterEntity(new RemoteParameterBean("0", "10%", "报警灵敏度")));
        entities.add(new RemoteParameterEntity(new RemoteParameterBean("0", "1", "前盖开启报警")));
        entities.add(new RemoteParameterEntity(new RemoteParameterBean("0", "1", "激活堵转保护")));
        entities.add(new RemoteParameterEntity(new RemoteParameterBean("0", "1", "激活过载保护")));
        entities.add(new RemoteParameterEntity(new RemoteParameterBean("0", "0", "激活欠载保护")));
        entities.add(new RemoteParameterEntity(new RemoteParameterBean("0", "1", "启动电流限制")));
        entities.add(new RemoteParameterEntity(new RemoteParameterBean("0", "1", "停止电流限制")));
        entities.add(new RemoteParameterEntity(new RemoteParameterBean("0", "1", "电机PTC报警")));
        entities.add(new RemoteParameterEntity(new RemoteParameterBean("0", "0", "远程启动报警")));
        entities.add(new RemoteParameterEntity(new RemoteParameterBean("0", "1", "电流传感器报警")));
        entities.add(new RemoteParameterEntity(new RemoteParameterBean("0", "1", "激活风扇报警")));
        entities.add(new RemoteParameterEntity(new RemoteParameterBean("0", "0", "通讯报警")));
        entities.add(new RemoteParameterEntity(new RemoteParameterBean("0", "1", "晶闸管触发报警")));
        entities.add(new RemoteParameterEntity(new RemoteParameterBean("0", "0", "电机端缺相")));
        entities.add(new RemoteParameterEntity(new RemoteParameterBean("0", "1", "热传感器报警")));
        entities.add(new RemoteParameterEntity(new RemoteParameterBean("0", "1", "外部报警")));
        entities.add(new RemoteParameterEntity(new RemoteParameterBean("0", "1", "输入端缺相")));
        entities.add(new RemoteParameterEntity(new RemoteParameterBean("0", "0", "运行1报警")));
        entities.add(new RemoteParameterEntity(new RemoteParameterBean("0", "0", "运行2报警")));
        entities.add(new RemoteParameterEntity(new RemoteParameterBean("0", "0", "关停报警")));

        return entities;
    }

    @OnClick(R.id.iv_title_only_back)
    public void onClick() {
        finish();
    }

    private class RemoteParameterRVAdapter extends BaseSectionQuickAdapter<RemoteParameterEntity, BaseViewHolder> {
        public RemoteParameterRVAdapter(int layoutResId, int sectionHeadResId, List<RemoteParameterEntity> data) {
            super(layoutResId, sectionHeadResId, data);
        }

        @Override
        protected void convertHead(BaseViewHolder baseViewHolder, RemoteParameterEntity remoteParameterEntity) {

        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, RemoteParameterEntity remoteParameterEntity) {
            RemoteParameterBean parameterBean = remoteParameterEntity.t;
            baseViewHolder.setText(R.id.tv_remote_parameter_value, parameterBean.getValue())
                    .setText(R.id.tv_remote_parameter_label, "—" + parameterBean.getLabel());
        }
    }
}
