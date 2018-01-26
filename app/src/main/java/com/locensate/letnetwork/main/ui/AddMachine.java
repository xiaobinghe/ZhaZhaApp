package com.locensate.letnetwork.main.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 添加设备
 *
 * @author xiaobinghe
 */

public class AddMachine extends BaseActivity {

    @BindView(R.id.ib_toolbar_back)
    ImageButton mIbToolbarBack;
    @BindView(R.id.title_toolbar)
    TextView mTitleToolbar;
    @BindView(R.id.tv_complete)
    TextView mTvComplete;
    @BindView(R.id.appbar_toolbar)
    Toolbar mAppbarToolbar;
    @BindView(R.id.rv_machine_list)
    RecyclerView mRvMachineList;
    @BindView(R.id.activity_add_machine)
    LinearLayout mActivityAddMachine;

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_machine;
    }

    @Override
    public void initView() {
        mTvComplete.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.ib_toolbar_back, R.id.tv_complete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_toolbar_back:
                // TODO: 2018/1/22 返回数据
                break;
            case R.id.tv_complete:
                break;
            default:
                break;
        }
    }
}
