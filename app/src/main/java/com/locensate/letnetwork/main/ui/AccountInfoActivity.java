package com.locensate.letnetwork.main.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.AppManager;
import com.locensate.letnetwork.Constant;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.api.Api;
import com.locensate.letnetwork.base.BaseActivity;
import com.locensate.letnetwork.base.RxSchedulers;
import com.locensate.letnetwork.bean.Logout;
import com.locensate.letnetwork.bean.OnlyMsg;
import com.locensate.letnetwork.bean._User;
import com.locensate.letnetwork.main.ui.login.LoginActivity;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.SpUtil;
import com.locensate.letnetwork.utils.ToastUtil;
import com.locensate.letnetwork.view.ModernDialog;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 *  
 * @author xiaobinghe
 */

public class AccountInfoActivity extends BaseActivity {


    @BindView(R.id.iv_title_only_back)
    ImageView ivTitleOnlyBack;
    @BindView(R.id.tv_title_only_back)
    TextView tvTitleOnlyBack;
    @BindView(R.id.iv_account_nickname)
    TextView ivAccountNickname;
    @BindView(R.id.ll_account_nickname)
    LinearLayout llAccountNickname;
    @BindView(R.id.iv_account_name)
    TextView ivAccountName;
    @BindView(R.id.ll_account_sex)
    LinearLayout llAccountSex;
    @BindView(R.id.iv_account_tel)
    TextView ivAccountTel;
    @BindView(R.id.ll_account_phone)
    LinearLayout llAccountPhone;
    @BindView(R.id.tv_account_email)
    TextView tvAccountEmail;
    @BindView(R.id.ll_account_job)
    LinearLayout llAccountJob;
    @BindView(R.id.tv_account_enterprise)
    TextView tvAccountEnterprise;
    @BindView(R.id.ll_account_rq)
    LinearLayout llAccountRq;
    @BindView(R.id.ll_reset_psw)
    LinearLayout llResetPsw;
    @BindView(R.id.ll_account_email)
    LinearLayout llAccountEmail;
    @BindView(R.id.ll_exit)
    LinearLayout llExit;
    @BindView(R.id.ll_account_enterprise)
    LinearLayout llAccountEnterprise;
    @BindView(R.id.activity_account_info)
    LinearLayout activityAccountInfo;
    private CompositeDisposable mCompositeDisposable;

    @Override
    public int getLayoutId() {
        return R.layout.activity_account_info;
    }

    @Override
    public void initView() {
        _User user = new Gson().fromJson(SpUtil.getString(App.getApplication(), Constant.USER, ""), _User.class);

        mCompositeDisposable = new CompositeDisposable();
        tvTitleOnlyBack.setText("账户信息");
    }


    @OnClick({R.id.iv_title_only_back, R.id.ll_reset_psw, R.id.ll_exit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_title_only_back:
                finish();
                break;
            case R.id.ll_reset_psw:
                startActivity(ResetPswActivity.class);
                break;
            case R.id.ll_exit:
                ModernDialog dialog = new ModernDialog(this, R.layout.activity_exit_login, new int[]{R.id.btt_exit_okay, R.id.btt_exit_cancel});
                dialog.show();
                dialog.setOnModernItemClickListener(new ModernDialog.OnModernDialogItemClickListener() {
                    @Override
                    public void modernItemClickListener(ModernDialog dialog, View v) {
                        switch (v.getId()) {
                            case R.id.btt_exit_okay:
                                startActivity(new Intent(App.getApplication(), LoginActivity.class));


                                String uuid = SpUtil.getString(App.getApplication(), Constant.UUID, "");
                                mCompositeDisposable.add(Api.getInstance().service.logout(new Logout(uuid)).compose(RxSchedulers.<OnlyMsg>applyObservableAsync()).subscribe(new Consumer<OnlyMsg>() {
                                    @Override
                                    public void accept(@NonNull OnlyMsg onlyMsg) throws Exception {
                                        if (onlyMsg.getOperCode() == 1) {
                                            AppManager.clear();
                                            startActivity(new Intent(App.getApplication(), LoginActivity.class));
                                        } else {
                                            ToastUtil.show(onlyMsg.getMsg());
                                        }
                                        LogUtil.e(TAG, "onlymsg----" + onlyMsg.getMsg());
                                    }
                                }, new Consumer<Throwable>() {
                                    @Override
                                    public void accept(@NonNull Throwable throwable) throws Exception {
                                        LogUtil.e(TAG, "error----" + throwable.getMessage());
                                        ToastUtil.show("登出异常");
                                    }
                                }));
                                break;
                            case R.id.btt_exit_cancel:
                                break;
                            default:
                                dialog.dismiss();
                                break;
                        }
                    }
                });
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }
}
