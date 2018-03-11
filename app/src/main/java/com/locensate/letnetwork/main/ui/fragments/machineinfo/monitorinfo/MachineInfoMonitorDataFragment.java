package com.locensate.letnetwork.main.ui.fragments.machineinfo.monitorinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseFragment;
import com.locensate.letnetwork.base.RxSchedulers;
import com.locensate.letnetwork.main.ui.RemoteParameterActivity;
import com.locensate.letnetwork.main.ui.dataanalysis.DataAnalysisActivity;
import com.locensate.letnetwork.main.ui.machineinfo.MachineInfoActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;

/**
 * @author xiaobinghe
 */

public class MachineInfoMonitorDataFragment extends BaseFragment<MachineInfoMonitorDataPresenter, MachineInfoMonitorDataModel> implements MachineInfoMonitorDataContract.View {

    @BindView(R.id.rv_machine_monitor)
    RecyclerView rvMachineMonitor;
    private MachineMonitorRvAdapter monitorRVAdapter;
    private Bundle mMachineInfo;
    private String machineName;
    private long motorId;
    private boolean initComplete = false;
    private CompositeDisposable mCompositeDisposable;

    @Override
    protected void initView() {
        MachineInfoActivity context = (MachineInfoActivity) getActivity();
        mMachineInfo = context.getMachineInfo();
        machineName = mMachineInfo.getString("machineName");
        motorId = mMachineInfo.getLong("motorId");
        rvMachineMonitor.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        monitorRVAdapter = new MachineMonitorRvAdapter(R.layout.item_section_content, R.layout.item_section_head, new ArrayList<MonitoringData>(), getContext());
        monitorRVAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Bundle bundle = new Bundle();
                MonitoringData item = (MonitoringData) baseQuickAdapter.getItem(i);
                if (!item.isHeader) {
                    RunningStateEntity data = (RunningStateEntity) item.t;
                    bundle.putSerializable("parameter", data);
                    skipHistoryData(bundle);
                }
            }
        });

        monitorRVAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MonitoringData item = (MonitoringData) baseQuickAdapter.getItem(i);
                skipRemoteParameter();
            }
        });

        rvMachineMonitor.setAdapter(monitorRVAdapter);

        mCompositeDisposable = new CompositeDisposable();

        Observable<Long> observable = Observable.interval(10 * 1000, TimeUnit.MILLISECONDS).doOnNext(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                mPresenter.initData();
            }
        });
        DisposableObserver disposable = getDisposable();
        observable.compose(RxSchedulers.<Long>applyObservableAsync()).subscribe(disposable);
        mCompositeDisposable.add(disposable);
        initComplete = true;
    }

    @Override
    public int getInflaterView() {
        return R.layout.fragment_running_state;
    }

    @Override
    protected void lazyLoad() {
        if (initComplete) {

        }
    }

    @Override
    public void fillData(List<MonitoringData> data) {
        monitorRVAdapter.replaceData(data);
    }

    @Override
    public long getMotorId() {
        return motorId;
    }

    @Override
    public void onDestroyView() {
        rvMachineMonitor.setAdapter(null);
        mCompositeDisposable.clear();
        super.onDestroyView();
    }

    private void skipHistoryData(Bundle bundle) {
        Intent intent = new Intent(App.getApplication(), DataAnalysisActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void skipRemoteParameter() {
        Intent intent = new Intent(getActivity(), RemoteParameterActivity.class);
        startActivity(intent);
    }

    private DisposableObserver getDisposable() {
        return new DisposableObserver<Long>() {
            @Override
            public void onNext(Long kanBanDataEntity) {
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }


}
