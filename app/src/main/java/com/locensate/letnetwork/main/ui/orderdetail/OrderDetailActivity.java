package com.locensate.letnetwork.main.ui.orderdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.locensate.letnetwork.App;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.entity.OrderCommunicate;
import com.locensate.letnetwork.entity.OrderMsgEntity;
import com.locensate.letnetwork.main.ui.AddCommunicationActivity;
import com.locensate.letnetwork.main.ui.AddEvaluateActivity;
import com.locensate.letnetwork.main.ui.machineinfo.MachineInfoActivity;
import com.locensate.letnetwork.utils.ToastUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author xiaobinghe
 */

public class OrderDetailActivity extends BaseActivity<OrderDetailPresenter, OrderDetailModel> implements OrderDetailContract.View {

    @BindView(R.id.iv_order_detail_back)
    ImageView mIvOrderDetailBack;
    @BindView(R.id.iv_order_detail_title)
    TextView mIvOrderDetailTitle;
    @BindView(R.id.iv_order_detail_com)
    TextView mIvOrderDetailCom;
    @BindView(R.id.rv_order_detail)
    RecyclerView mRvOrderDetail;
    @BindView(R.id.srl_order_detail)
    SwipeRefreshLayout mSrlOrderDetail;
    @BindView(R.id.activity_order_detail)
    LinearLayout mActivityOrderDetail;

    private OrderDetailRvAdapter detailRVAdapter;
    private String orderId;
    private int ON_RESULT = 0x1001;
    private ArrayList<OrderCommunicate> communicates;
    private boolean isCompleted = false;
    private boolean hasEvaluate = false;
    private int ON_EVALUATED = 0x1002;
    private OrderMsgEntity mOrderMsgEntity;
    private int orderStatus = 3;
    private View mProgress;
    private View mEvaluate;

    @Override
    public int getLayoutId() {
        return R.layout.activity_order_detail;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        orderId = intent.getStringExtra("orderId");
        mOrderMsgEntity = (OrderMsgEntity) intent.getExtras().getSerializable("order");
        mIvOrderDetailTitle.setText("能效");
        mRvOrderDetail.setLayoutManager(new LinearLayoutManager(this));
        communicates = new ArrayList<>();
//      communicates.add(new OrderCommunicate("", orderId, "李俊", System.currentTimeMillis() - 1200000L, "", "除尘风机电机出现异常，电机发烫，并伴有吱吱响声，现已停机。"));
        communicates.add(new OrderCommunicate("", orderId, "李俊", System.currentTimeMillis() - 1200000L, "", "我们需要查看这台设备详细的运行数据，查看过程不影响设备的使用。"));
        detailRVAdapter = new OrderDetailRvAdapter(R.layout.item_order_detail, communicates);
        addHeader(orderStatus);
        mRvOrderDetail.setAdapter(detailRVAdapter);
        mSrlOrderDetail.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSrlOrderDetail.setRefreshing(false);
                detailRVAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void initData() {

    }

    private void addHeader(int orderStatus) {
        detailRVAdapter.addHeaderView(getHeadBaseInfoView(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App.getApplication(), MachineInfoActivity.class);
                intent.putExtra("machineName", "空风机");
                intent.putExtra("machineId", "");
                startActivity(intent);
            }
        }));
        detailRVAdapter.addHeaderView(getHeadProgressView(orderStatus));
        // TODO: 2017/5/26  根据工单状态判断是否显示评价模块

        detailRVAdapter.addHeaderView(getHeadCommunicateTitle(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), AddCommunicationActivity.class);
                intent.putExtra("orderId", orderId);
                startActivityForResult(intent, ON_RESULT);
            }
        }));
    }

    public View getHeadCommunicateTitle(View.OnClickListener listener) {
        View view = getLayoutInflater().inflate(R.layout.layout_communicate_title, (ViewGroup) mRvOrderDetail.getParent(), false);
        TextView addCommunication = (TextView) view.findViewById(R.id.tv_add_communication);
        addCommunication.setOnClickListener(listener);
        return view;
    }

    private View getHeadProgressView(int status) {
        mProgress = getLayoutInflater().inflate(R.layout.layout_order_detail_head_progress, (ViewGroup) mRvOrderDetail.getParent(), false);
        updateProgress(status);
        return mProgress;
    }

    private void updateProgress(int status) {
        TextView tvCommit = (TextView) mProgress.findViewById(R.id.tv_commit);
        ImageView ivCommit = (ImageView) mProgress.findViewById(R.id.iv_commit);
        TextView tvGet = (TextView) mProgress.findViewById(R.id.tv_get);
        ImageView ivGet = (ImageView) mProgress.findViewById(R.id.iv_get);
        TextView tvHandle = (TextView) mProgress.findViewById(R.id.tv_handle);
        ImageView ivHandle = (ImageView) mProgress.findViewById(R.id.iv_handle);
        TextView tvComplete = (TextView) mProgress.findViewById(R.id.tv_complete);
        ImageView ivComplete = (ImageView) mProgress.findViewById(R.id.iv_complete);

        tvGet.setTextColor(status == 1 ? getResources().getColor(R.color.font_gray_blue) : getResources().getColor(R.color.font_deep_blue));
        ivGet.setImageResource(status == 1 ? R.drawable.shape_circle_progress_light_blue : R.drawable.shape_circle_progress_deep_blue);
        tvHandle.setTextColor(status == 2 || status == 1 ? getResources().getColor(R.color.font_gray_blue) : getResources().getColor(R.color.font_deep_blue));
        ivHandle.setImageResource(status == 2 || status == 1 ? R.drawable.shape_circle_progress_light_blue : R.drawable.shape_circle_progress_deep_blue);
        tvComplete.setTextColor(status == 2 || status == 1 || status == 3 ? getResources().getColor(R.color.font_gray_blue) : getResources().getColor(R.color.font_deep_blue));
        ivComplete.setImageResource(status == 2 || status == 1 || status == 3 ? R.drawable.shape_circle_progress_light_blue : R.drawable.shape_circle_progress_deep_blue);
    }

    private View getHeadEvaluateView(int star, String evaluateContent) {
        mEvaluate = getLayoutInflater().inflate(R.layout.layout_order_detail_head_evaluate, (ViewGroup) mRvOrderDetail.getParent(), false);
        updateEvaluate(star, evaluateContent);
        return mEvaluate;
    }

    private void updateEvaluate(int star, String evaluateContent) {
        LinearLayout llStars = (LinearLayout) mEvaluate.findViewById(R.id.ll_stars);
        ImageView star1 = (ImageView) mEvaluate.findViewById(R.id.iv_star1);
        ImageView star2 = (ImageView) mEvaluate.findViewById(R.id.iv_star2);
        ImageView star3 = (ImageView) mEvaluate.findViewById(R.id.iv_star3);
        ImageView star4 = (ImageView) mEvaluate.findViewById(R.id.iv_star4);
        ImageView star5 = (ImageView) mEvaluate.findViewById(R.id.iv_star5);
        TextView tvEvaluate = (TextView) mEvaluate.findViewById(R.id.tv_evaluate);

        llStars.setVisibility(hasEvaluate ? View.VISIBLE : View.GONE);
        tvEvaluate.setText(hasEvaluate ? evaluateContent : "工单已完成，暂无评价，请及时添加评价！");

        star2.setImageResource(star == 1 ? R.drawable.star_gray_ : R.drawable.star_yellow_);
        star3.setImageResource(star == 1 || star == 2 ? R.drawable.star_gray_ : R.drawable.star_yellow_);
        star4.setImageResource(star == 4 || star == 5 ? R.drawable.star_yellow_ : R.drawable.star_gray_);
        star5.setImageResource(star == 5 ? R.drawable.star_yellow_ : R.drawable.star_gray_);
    }

    public View getHeadBaseInfoView(View.OnClickListener listener) {
        View baseInfo = getLayoutInflater().inflate(R.layout.layout_order_detail_head, (ViewGroup) mRvOrderDetail.getParent(), false);
        TextView address = (TextView) baseInfo.findViewById(R.id.tv_order_detail_address);
        TextView creater = (TextView) baseInfo.findViewById(R.id.tv_order_detail_creater);
        TextView des = (TextView) baseInfo.findViewById(R.id.tv_order_detail_des);
        TextView enterprise = (TextView) baseInfo.findViewById(R.id.tv_order_detail_enterprise);
        TextView facilitator = (TextView) baseInfo.findViewById(R.id.tv_order_detail_facilitator);
        TextView machineName = (TextView) baseInfo.findViewById(R.id.tv_order_detail_machine_name);
        TextView time = (TextView) baseInfo.findViewById(R.id.tv_order_detail_time);
        TextView machinePath = (TextView) baseInfo.findViewById(R.id.tv_order_detail_machine_path);
        TextView orderDetail = (TextView) baseInfo.findViewById(R.id.order_detail);

        machineName.setText("主抽风机");
        machinePath.setText("一车间焦化厂");
        facilitator.setText("北京罗圣森特节能科技有限公司");
        enterprise.setText("某钢铁厂");
        address.setText("江苏省徐州");
        creater.setText("张芬芳");
//        des.setText("变频器运行过程中出现报警停机，报警显示输入端缺相，检查线路没有问题，请协助恢复设备正常运行。");
        des.setText(mOrderMsgEntity.getDes());
//        des.setText("132Kw皮带机，已更换高效电机，但生产原因，皮带机存在低负载或者是空载等待的工况，请问是否还有能效提升的空间，通过什么措施实现呢？前提是不影响我们的生产，请协助分析。");
        time.setText("2017-07-23  12:23");
        orderDetail.setOnClickListener(listener);
        return baseInfo;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == ON_RESULT && resultCode == 0x1002) {
            OrderCommunicate communicate = (OrderCommunicate) data.getExtras().getSerializable("communicate");
            communicates.add(communicate);
            detailRVAdapter.notifyDataSetChanged();
        } else if (requestCode == ON_EVALUATED && resultCode == AddEvaluateActivity.EVALUATED) {
//            detailRVAdapter.removeAllHeaderView();
            hasEvaluate = true;
            Bundle extras = data.getExtras();
//            extras.getInt("starCount");
//            addHeader(extras.getInt("starCount"), extras.getString("evaluateContent"), 4);
            updateEvaluate(extras.getInt("starCount"), extras.getString("evaluateContent"));
        }

    }

    @OnClick({R.id.iv_order_detail_back, R.id.iv_order_detail_com})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_order_detail_back:
                finish();
                break;
            case R.id.iv_order_detail_com:
                if (!isCompleted) {
                    if (orderStatus == 3) {
                        isCompleted = true;
                        mIvOrderDetailCom.setText("评价");
                        addEvaluateView();
                    } else {
                        ToastUtil.show("工单尚未处理，暂不能完成");
                    }
                } else {
                    startActivityForResult(new Intent(getApplication(), AddEvaluateActivity.class), ON_EVALUATED);
                }
                break;
            default:
                break;
        }
    }

    private void addEvaluateView() {
        updateProgress(4);
        if (isCompleted) {
            detailRVAdapter.addHeaderView(getHeadEvaluateView(0, ""), 2);
            detailRVAdapter.notifyDataSetChanged();
        }
    }
}
