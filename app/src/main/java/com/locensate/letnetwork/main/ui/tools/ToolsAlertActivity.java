package com.locensate.letnetwork.main.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.entity.FilterEntity;
import com.locensate.letnetwork.entity.FilterMark;
import com.locensate.letnetwork.entity.MessageEntity;
import com.locensate.letnetwork.main.ui.AlertDetailActivity;
import com.locensate.letnetwork.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xiaobinghe
 */

public class ToolsAlertActivity extends BaseToolsActivity {


    @Override
    protected Activity getActivity() {
        return this;
    }

    @Override
    protected CharSequence setTitle() {
        return "工具-报警";
    }

    @Override
    protected RecyclerView.Adapter setRVAdapter() {
        AlertMessageAdapter adapter=  new AlertMessageAdapter(R.layout.item_message_alert_fragment, getItems());
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MessageEntity item = (MessageEntity) baseQuickAdapter.getItem(i);
                Intent intent = new Intent(getActivity(), AlertDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("alertMsg", item);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return adapter;
    }

    @Override
    protected void setRefreshListener(final SwipeRefreshLayout swipeRefreshLayout) {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    swipeRefreshLayout.setRefreshing(false);

                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    }
                };
                runnable.run();
            }
        });
    }
    private List<MessageEntity> getItems() {
        ArrayList<MessageEntity> initDate = new ArrayList<>();
        initDate.add(new MessageEntity("", "输入端缺相", "中石化/北京分公司/储油车间", "通风机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()), "high", 1, false));
        initDate.add(new MessageEntity("", "启动限流", "八一钢铁厂/北京分公司/不锈钢一车间", "冲压机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()), "low", 4, false));
        initDate.add(new MessageEntity("", "皮带机一天运行24小时不停机，存在较多的空载运行", "空分集团/福建分公司/压缩机车间", "卷板机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()), "high", 1, false));
        initDate.add(new MessageEntity("", "三相不平衡", "罗圣森特/北京总部/试验车间", "通风机", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()), "low", 3, false));
        initDate.add(new MessageEntity("", "输入端缺相", "罗圣森特/北京总部/软启生产车间", "空调设备", (String) DateUtils.getData("yy-MM-dd HH:mm", DateUtils.getCurrentTimeMillis()), "low", 2, false));
        return initDate;
    }

    @Override
    protected ArrayList<FilterEntity> getFilterData() {
        ArrayList<FilterEntity> entities = new ArrayList<>();
        entities.add(new FilterEntity(true, "报警等级"));
        entities.add(new FilterEntity(new FilterMark("高", false)));
        entities.add(new FilterEntity(new FilterMark("低", false)));

        entities.add(new FilterEntity(true, "报警状态"));
        entities.add(new FilterEntity(new FilterMark("已消除", false)));
        entities.add(new FilterEntity(new FilterMark("未消除", false)));

        entities.add(new FilterEntity(true, "控制设备类型"));
        entities.add(new FilterEntity(new FilterMark("变频器", false)));
        entities.add(new FilterEntity(new FilterMark("软启动器", false)));
        entities.add(new FilterEntity(new FilterMark("SGY", false)));
        entities.add(new FilterEntity(new FilterMark("智能开关", false)));
        entities.add(new FilterEntity(new FilterMark("综保", false)));
        entities.add(new FilterEntity(new FilterMark("滤波设置", false)));
        entities.add(new FilterEntity(new FilterMark("其他", false)));


        return entities;
    }


    private class AlertMessageAdapter extends BaseQuickAdapter<MessageEntity, BaseViewHolder> {
        public AlertMessageAdapter(int item_message_fragment, List<MessageEntity> items) {
            super(item_message_fragment, items);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, MessageEntity messageEntity) {
            baseViewHolder.setText(R.id.tv_alert_message, messageEntity.getDes())
                    .setText(R.id.tv_alert_occur_time, messageEntity.getTime())
                    .setText(R.id.tv_alert_machine_path, messageEntity.getPath())
                    .setText(R.id.tv_alert_machine, messageEntity.getName())
                    .setVisible(R.id.fl_alert_level, false)
                    .setText(R.id.tv_alert_msg_num, String.valueOf(messageEntity.getNum()));
            if ("low".equals(messageEntity.getLevel())) {
                baseViewHolder.setBackgroundColor(R.id.ll_alert_level, getResources().getColor(R.color.alert_low));
            } else {
                baseViewHolder.setBackgroundColor(R.id.ll_alert_level, getResources().getColor(R.color.alert_high));
            }

        }
    }
}
