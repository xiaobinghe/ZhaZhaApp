package com.locensate.letnetwork.main.ui.login;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatCheckBox;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.locensate.letnetwork.App;
import com.locensate.letnetwork.AppManager;
import com.locensate.letnetwork.Constant;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.SpUtil;
import com.locensate.letnetwork.utils.ToastUtil;
import com.locensate.letnetwork.bean.Login;
import com.locensate.letnetwork.main.ui.home.HomeActivity;

import butterknife.BindView;
import butterknife.OnClick;


/**
 *
 * @author xiaobinghe
 */


public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.View {


    @BindView(R.id.iv_title_only_back)
    ImageView ivTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView tvTitleOnlyBack;
    @BindView(R.id.user_name)
    EditText userName;
    @BindView(R.id.user_psw)
    EditText userPsw;
    @BindView(R.id.cb_remember_psw)
    AppCompatCheckBox cbRememberPsw;
    @BindView(R.id.btn_login)
    Button btnLogin;


    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        tvTitleOnlyBack.setText("登录");
    }

    private void login() {
        String name = userName.getText().toString();
        String psw = userPsw.getText().toString();
        String msg = TextUtils.isEmpty(name) ? "用户名不能为空" : TextUtils.isEmpty(psw) ? "密码不能为空" : "";
        if (!TextUtils.isEmpty(msg)) {
            ToastUtil.show(msg);
        } else {
            mPresenter.login(new Login(name, psw));
        }
    }

    @Override
    public void loginSuccess() {
        startActivity(new Intent(App.getApplication(), HomeActivity.class));
        finishCurrent();
    }

    @Override
    public void showMsg(String s) {
        Snackbar.make(btnLogin, s, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void initData() {
        boolean isCheck = SpUtil.getBoolean(this, Constant.REMEMBER_PSW, false);
        LogUtil.e(TAG, "+++++++=============" + isCheck);
        cbRememberPsw.setChecked(isCheck);
        userName.setText(SpUtil.getString(this, Constant.USER_NAME, ""));
        userPsw.setText(SpUtil.getString(this, Constant.USER_PSW, ""));
    }

    public void finishCurrent() {
        boolean isChecked = cbRememberPsw.isChecked();
        SpUtil.saveString(this, Constant.USER_NAME, isChecked ? userName.getText().toString() : "");
        SpUtil.saveString(this, Constant.USER_PSW, isChecked ? userPsw.getText().toString() : "");
        SpUtil.saveBoolean(this, Constant.REMEMBER_PSW, isChecked);
        finish();
    }


    @OnClick({R.id.iv_title_only_back, R.id.btn_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_title_only_back:
                AppManager.finishAll();
                break;
            case R.id.btn_login:
                login();
                break;
            default:
                break;
        }
    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
            }
            login();
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    /**
     *
     * @param v     view
     * @param event event
     * @return true or false
     */
    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof AutoCompleteTextView)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
