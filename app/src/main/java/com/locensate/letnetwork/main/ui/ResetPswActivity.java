package com.locensate.letnetwork.main.ui;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.locensate.letnetwork.App;
import com.locensate.letnetwork.Constant;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.utils.SpUtil;
import com.locensate.letnetwork.utils.ToastUtil;
import com.locensate.letnetwork.main.ui.login.LoginActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *  
 * @author xiaobinghe
 */

public class ResetPswActivity extends BaseActivity {

    @BindView(R.id.iv_title_only_back)
    ImageView mIvTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView mTvTitleOnlyBack;
    @BindView(R.id.et_old_psw)
    EditText mEtOldPsw;
    @BindView(R.id.et_new_psw)
    EditText mEtNewPsw;
    @BindView(R.id.et_new_psw_repeat)
    EditText mEtNewPswRepeat;
    @BindView(R.id.btn_commit)
    Button mBtnCommit;
    @BindView(R.id.activity_reset_psw)
    LinearLayout mActivityResetPsw;

    @Override
    public int getLayoutId() {
        return R.layout.activity_reset_psw;
    }

    @Override
    public void initView() {
        mTvTitleOnlyBack.setText("修改密码");

    }

    @OnClick({R.id.iv_title_only_back, R.id.btn_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_title_only_back:
                finish();
                break;
            case R.id.btn_commit:
                if (!SpUtil.getString(App.getApplication(), Constant.USER_PSW, "").equals(mEtOldPsw.getText().toString())) {
                    ToastUtil.show("请输入正确的原密码");
                    mEtOldPsw.setText("");
                    mEtOldPsw.setFocusable(true);
                } else if (!mEtNewPsw.getText().toString().equals(mEtNewPswRepeat.getText().toString())) {
                    ToastUtil.show("两次输入不一致，请重新输入");
                    mEtNewPswRepeat.setText("");
                    mEtNewPswRepeat.setFocusable(true);
                } else if (SpUtil.getString(App.getApplication(), Constant.USER_PSW, "").equals(mEtNewPsw.getText().toString())) {
                    ToastUtil.show("新密码和原始密码一致，请重新输入");
                    mEtNewPsw.setText("");
                    mEtNewPswRepeat.setText("");
                    mEtNewPsw.setFocusable(true);
                } else {
                    SpUtil.saveString(App.getApplication(), Constant.USER_PSW, mEtNewPsw.getText().toString());
                    Snackbar.make(mBtnCommit, "密码修改成功，请重新登录", Snackbar.LENGTH_INDEFINITE).setAction("登录", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(LoginActivity.class);
                        }
                    }).show();
                }
                break;
        }
    }
}
