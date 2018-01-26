package com.locensate.letnetwork.main.ui.addorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.locensate.letnetwork.Constant;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.utils.LogUtil;

import butterknife.BindView;

/**
 * 添加工单
 *
 * @author xiaobinghe
 */

public class AddOrderActivity extends BaseActivity {

    @BindView(R.id.iv_title_only_back)
    ImageView mIvTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView mTvTitleOnlyBack;
    @BindView(R.id.fl_contain)
    FrameLayout mFlContain;
    private OnHideKeyboardListener listener;

    @Override
    public int getLayoutId() {
        return R.layout.activity_create_order;
    }

    @Override
    public void initView() {
        String machineName = getIntent().getStringExtra("machineName");
        mTvTitleOnlyBack.setText("创建工单");

        AddOrderFragment addOrderFragment = new AddOrderFragment();
        Bundle bundle = new Bundle();
        bundle.putString("machineName", machineName);
        addOrderFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_contain, addOrderFragment).show(addOrderFragment).commit();
    }

    /**
     * 返回数据
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constant.REQUEST_ADD_MACHINE_FROM_ADD_ORDER && resultCode == Constant.RESULT_ADD_MACHINE_TO_ADD_ORDER) {
            // TODO: 2018/1/22 取出返回的设备

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (listener != null) {
            LogUtil.e(TAG, "--------ev------" + ev.getAction());
            if (ev.getAction() == MotionEvent.ACTION_DOWN) {
                LogUtil.e(TAG, "-----------hideKeyboard-----" + listener.hideKeyboard());
                if (listener.hideKeyboard()) {
                    return false;
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    public void setOnHideKeyboardListener(OnHideKeyboardListener listener) {
        this.listener = listener;
    }
}
