package com.locensate.letnetwork.main.ui.dataanalysis;

import com.github.mikephil.charting.data.Entry;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.RxSchedulers;
import com.locensate.letnetwork.bean.MonitorEquipmentHistoryData;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.ToastUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * @author xiaobinghe
 */

public class DataAnalysisPresenter extends DataAnalysisContract.Presenter {

    @Override
    public void onStart() {
        mView.initData();
    }


    @Override
    public void setUp(long id, String rangeType, String tagName, Date startDate) {
        if (App.isMock) {
            mView.fillChartData(mModel.getData());
            return;
        }

        long startMill = startDate.getTime();
        long endMill;
        switch (rangeType) {
            case "minute":
                endMill = startMill + 600000L;
                break;
            case "hour":
                endMill = startMill + 3600000L;
                break;
            case "day":
                endMill = startMill + 86400000L;
                break;
            case "week":
                endMill = startMill + 604800000L;
                break;
            case "mouth":
                endMill = startMill + 2592000000L;
                break;
            default:
                endMill = startMill + 600000L;
                break;
        }


        mModel.getOriginData(id, rangeType, tagName, startMill, endMill).compose(RxSchedulers.<MonitorEquipmentHistoryData>applyObservableAsync()).map(new Function<MonitorEquipmentHistoryData, List<Entry>>() {

            @Override
            public List<Entry> apply(MonitorEquipmentHistoryData monitorEquipmentHistoryData) throws Exception {
                LogUtil.e("MonitorEquipmentEntity", "--------------------" + monitorEquipmentHistoryData.toString());
                List<Entry> entries = new ArrayList<>();
                List<MonitorEquipmentHistoryData.DataBean> data = monitorEquipmentHistoryData.getData();
                for (int i = 0; i < data.size(); i++) {
                    MonitorEquipmentHistoryData.DataBean dataBean = data.get(i);
                    entries.add(new Entry(dataBean.getTime() - mModel.getStartTime(), (float) dataBean.getValue()));
                }
                return entries;
            }
        }).subscribe(new Consumer<List<Entry>>() {
            @Override
            public void accept(List<Entry> entries) throws Exception {
                LogUtil.e("MonitorEquipmentEntity", "--------------------" + entries.get(0).getY() + "---" + entries.get(0).getX());
                mView.fillChartData(entries);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                ToastUtil.show(App.getApplication().getString(R.string.load_fail_retry));
            }
        });
    }
}
