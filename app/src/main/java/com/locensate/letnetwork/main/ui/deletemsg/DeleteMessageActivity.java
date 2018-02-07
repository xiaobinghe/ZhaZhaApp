package com.locensate.letnetwork.main.ui.deletemsg;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.entity.MessageEntity;
import com.locensate.letnetwork.entity.OrderMsgEntity;
import com.locensate.letnetwork.utils.LogUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 删除消息
 *
 * @author xiaobinghe
 */

public class DeleteMessageActivity extends BaseActivity<DeleteMessagePresenter, DeleteMessageModel> implements DeleteMessageContract.View {
    @BindView(R.id.iv_title_only_back)
    ImageView ivTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView tvTitleOnlyBack;
    @BindView(R.id.rv_delete_message)
    RecyclerView rvDeleteMessage;
    @BindView(R.id.checkbox_all)
    CheckBox checkboxAll;
    @BindView(R.id.tv_checked_num)
    TextView tvCheckedNum;
    @BindView(R.id.tv_total_num)
    TextView tvTotalNum;
    @BindView(R.id.bt_delete_okay)
    FrameLayout btDeleteOkay;
    @BindView(R.id.activity_delete_message)
    LinearLayout activityDeleteMessage;
    private int page;
    private ArrayList<MessageEntity> messages;
    private ArrayList<OrderMsgEntity> energyMsg;
    private ArrayList<OrderMsgEntity> orderMsg;
    private ArrayList<OrderMsgEntity> remindMsg;
    private RvDeleteAlertAdapter alertAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_delete_message;
    }

    @Override
    public void initView() {
        page = getIntent().getIntExtra("message", 0);
        tvTitleOnlyBack.setText("删除消息");
        checkboxAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    switch (page) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            setIsCheckedAll(true);
                            break;
                    }
                } else {
                    switch (page) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            setIsCheckedAll(false);
                            break;
                    }
                }
            }
        });
    }


    @Override
    public void initData() {
        rvDeleteMessage.setLayoutManager(new LinearLayoutManager(this));
        switch (page) {
            case 0:
                messages = mModel.getAlertMsg();
                break;
            case 1:
                messages = mModel.getEnergyMsg();
                break;
            case 2:
                messages = mModel.getOrderMsg();
                break;
            case 3:
                messages = mModel.getRemindMsg();
                break;
            default:
                break;
        }
        alertAdapter = new RvDeleteAlertAdapter(this, R.layout.item_message_fragment, messages, tvCheckedNum, page);
        rvDeleteMessage.setAdapter(alertAdapter);
        alertAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MessageEntity messageEntity = messages.get(i);
                if (messageEntity.isChecked()) {
                    messageEntity.setChecked(false);
                } else {
                    messageEntity.setChecked(true);
                }
                alertAdapter.notifyDataSetChanged();
                setCheckedNum();
            }
        });
        tvTotalNum.setText(String.valueOf(messages.size()));
    }

    private void setCheckedNum() {
        int checkedNm = 0;
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i).isChecked()) {
                checkedNm++;
            }
        }
        tvCheckedNum.setText(String.valueOf(checkedNm));
    }


    public void setIsCheckedAll(Boolean b) {
        for (int i = 0; i < messages.size(); i++) {
            messages.get(i).setChecked(b);
            LogUtil.e("setIsCheckedAll", "++++++++==========" + messages.get(i).isChecked());
        }
        if (b) {
            tvCheckedNum.setText(String.valueOf(messages.size()));
        } else {
            tvCheckedNum.setText(String.valueOf(0));
        }
        alertAdapter.notifyDataSetChanged();

    }


    @OnClick({R.id.iv_title_only_back, R.id.bt_delete_okay})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_title_only_back:
                finish();
                break;
            case R.id.bt_delete_okay:
                deleteMsg();
                break;
        }
    }

    private void deleteMsg() {
        for (int i = 0; i < messages.size(); i++) {
            MessageEntity msgEntity = messages.get(i);
            if (msgEntity.isChecked()) {
                messages.remove(msgEntity);
                i--;
            }
        }
        alertAdapter.notifyDataSetChanged();
        tvTotalNum.setText(String.valueOf(messages.size()));
        tvCheckedNum.setText(String.valueOf(0));
        checkboxAll.setChecked(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.iv_title_only_back)
    public void onClick() {
    }
}
