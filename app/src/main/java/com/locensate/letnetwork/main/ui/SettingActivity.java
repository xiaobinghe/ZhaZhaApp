package com.locensate.letnetwork.main.ui;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.locensate.letnetwork.App;
import com.locensate.letnetwork.Constant;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.utils.SpUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author xiaobinghe
 */


public class SettingActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {

    @BindView(R.id.iv_title_only_back)
    ImageView mIvTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView mTvTitleOnlyBack;
    @BindView(R.id.tb_accept_notice)
    CheckBox mTbAcceptNotice;
    @BindView(R.id.rl_switch_notification)
    RelativeLayout mRlSwitchNotification;
    @BindView(R.id.tb_voice_order)
    CheckBox mTbVoiceOrder;
    @BindView(R.id.rl_switch_sound)
    RelativeLayout mRlSwitchSound;
    @BindView(R.id.tb_shake_order)
    CheckBox mTbShakeOrder;
    @BindView(R.id.rl_switch_vibrate)
    RelativeLayout mRlSwitchVibrate;
    @BindView(R.id.ll_msg_setting)
    LinearLayout mLlMsgSetting;
    @BindView(R.id.fl_clear_alert)
    FrameLayout mFlClearAlert;
    @BindView(R.id.fl_clear_energy)
    FrameLayout mFlClearEnergy;
    @BindView(R.id.fl_clear_order)
    FrameLayout mFlClearOrder;
    @BindView(R.id.fl_clear_remind)
    FrameLayout mFlClearRemind;

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initView() {
        mTvTitleOnlyBack.setText("设置");
        mTbAcceptNotice.setChecked(SpUtil.getBoolean(App.getApplication(), Constant.ACCEPT_NOTICE, true));
        mTbShakeOrder.setChecked(SpUtil.getBoolean(App.getApplication(), Constant.SHAKE_NOTICE, true));
        mTbVoiceOrder.setChecked(SpUtil.getBoolean(App.getApplication(), Constant.VOICE_NOTICE, true));
        mTbAcceptNotice.setOnCheckedChangeListener(this);
        mTbShakeOrder.setOnCheckedChangeListener(this);
        mTbVoiceOrder.setOnCheckedChangeListener(this);
    }

    @OnClick(R.id.iv_title_only_back)
    public void onViewClicked() {
        finish();
    }

    /**
     * 消息通知开关监听
     *
     * @param compoundButton 开关
     * @param b              值
     */
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.tb_accept_notice:
                SpUtil.saveBoolean(App.getApplication(), Constant.ACCEPT_NOTICE, b);
                break;
            case R.id.tb_shake_order:
                SpUtil.saveBoolean(App.getApplication(), Constant.SHAKE_NOTICE, b);
                break;
            case R.id.tb_voice_order:
                SpUtil.saveBoolean(App.getApplication(), Constant.VOICE_NOTICE, b);
                break;
            default:
                break;
        }
    }
}
