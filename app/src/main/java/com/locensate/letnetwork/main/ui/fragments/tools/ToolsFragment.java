package com.locensate.letnetwork.main.ui.fragments.tools;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseFragment;
import com.locensate.letnetwork.main.ui.tools.ToolsKanBanActivity;
import com.locensate.letnetwork.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author xiaobinghe
 */


public class ToolsFragment extends BaseFragment {


    @BindView(R.id.iv_title_only_back)
    ImageView ivTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView tvTitleOnlyBack;
    @BindView(R.id.tv_tools_look_board)
    TextView tvToolsLookBoard;
    @BindView(R.id.tv_tools_feng_gu_ping)
    TextView tvToolsFengGuPing;
    @BindView(R.id.tv_tools_group_energy_efficiency)
    TextView tvToolsGroupEnergyEfficiency;
    @BindView(R.id.tv_tools_alert)
    TextView tvToolsAlert;
    @BindView(R.id.tv_tools_energy_efficiency)
    TextView tvToolsEnergyEfficiency;
    @BindView(R.id.tv_tools_order)
    TextView tvToolsOrder;
    @BindView(R.id.tv_tools_remind)
    TextView tvToolsRemind;
    @BindView(R.id.tv_tools_repair)
    TextView tvToolsRepair;
    @BindView(R.id.tv_tools_routing)
    TextView tvToolsRouting;
    private boolean initC = false;


    @Override
    public int getInflaterView() {
        initC = true;
        return R.layout.fragment_tools;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void initView() {
        ivTitleOnlyBack.setVisibility(View.INVISIBLE);
        tvTitleOnlyBack.setText("工具");
    }

    @OnClick({R.id.tv_tools_look_board, R.id.tv_tools_feng_gu_ping, R.id.tv_tools_group_energy_efficiency, R.id.tv_tools_alert, R.id.tv_tools_energy_efficiency, R.id.tv_tools_order, R.id.tv_tools_remind, R.id.tv_tools_repair, R.id.tv_tools_routing})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_tools_look_board:
                startActivity(new Intent(mContext, ToolsKanBanActivity.class));
                break;
            case R.id.tv_tools_feng_gu_ping:
                ToastUtil.show("敬请期待");
//                startActivity(new Intent(mContext, ToolsFengGuPingActivity.class));
                break;
            case R.id.tv_tools_group_energy_efficiency:
                ToastUtil.show("敬请期待");

//                startActivity(new Intent(mContext, ToolsEnergyAnalysisActivity.class));
                break;
            case R.id.tv_tools_alert:
                ToastUtil.show("敬请期待");

//                startActivity(new Intent(mContext, ToolsAlertActivity.class));
                break;
            case R.id.tv_tools_energy_efficiency:
                ToastUtil.show("敬请期待");

//                Intent energyDate = new Intent(mContext, ToolsOrderActivity.class);
//                energyDate.putExtra("orderType", "energyEfficiency");
//                startActivity(energyDate);
                break;
            case R.id.tv_tools_order:
                ToastUtil.show("敬请期待");

//                Intent orderData = new Intent(mContext, ToolsOrderActivity.class);
//                orderData.putExtra("orderType", "order");
//                startActivity(orderData);
                break;
            case R.id.tv_tools_remind:
                ToastUtil.show("敬请期待");

//                startActivity(new Intent(mContext, ToolsRemindActivity.class));
                break;
            case R.id.tv_tools_repair:
                ToastUtil.show("敬请期待");

//                startActivity(new Intent(mContext, ToolsRepairActivity.class));
                break;
            case R.id.tv_tools_routing:
                ToastUtil.show("敬请期待");

//                startActivity(new Intent(mContext, ToolsRiPlanActivity.class));
                break;
            default:
                break;
        }
    }
}
