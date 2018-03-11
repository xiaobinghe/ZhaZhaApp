package com.locensate.letnetwork.main.ui.addorder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.main.ui.addorder.addmachine.AddMachineFragment;
import com.locensate.letnetwork.utils.LogUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.OnClick;

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
    private AddMachineFragment mAddMachineFragment;
    private AddOrderFragment mAddOrderFragment;

    @Override
    public int getLayoutId() {
        Map<String, String> str = new HashMap<>();
        Set<String> set = str.keySet();
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.err.println("");

        }
        return R.layout.activity_create_order;
    }

    @Override
    public void initView() {
        String machineName = getIntent().getStringExtra("machineName");
        mTvTitleOnlyBack.setText("创建工单");
        mAddOrderFragment = new AddOrderFragment();
        Bundle bundle = new Bundle();
        bundle.putString("machineName", machineName);
        mAddOrderFragment.setArguments(bundle);
        mAddMachineFragment = new AddMachineFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_contain, getFragmentByTag("addOrder"), "addOrder").add(R.id.fl_contain, getFragmentByTag("addMachine"), "addMachine").hide(mAddMachineFragment).show(mAddOrderFragment).commit();
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

    @OnClick(R.id.iv_title_only_back)
    public void onViewClicked() {
        finish();
    }

    public Fragment getFragmentByTag(String tag) {
        if ("addOrder".equals(tag)) {
            return mAddOrderFragment;
        } else {
            return mAddMachineFragment;
        }
    }
}
