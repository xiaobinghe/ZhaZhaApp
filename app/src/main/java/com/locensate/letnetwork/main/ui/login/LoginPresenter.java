package com.locensate.letnetwork.main.ui.login;

import com.google.gson.Gson;
import com.locensate.letnetwork.App;
import com.locensate.letnetwork.Constant;
import com.locensate.letnetwork.R;
import com.locensate.letnetwork.bean.Login;
import com.locensate.letnetwork.bean._User;
import com.locensate.letnetwork.utils.LogUtil;
import com.locensate.letnetwork.utils.SpUtil;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

import static android.content.ContentValues.TAG;


/**
 * @author xiaobinghe
 */


public class LoginPresenter extends LoginContract.Presenter {
    @Override
    public void onStart() {
        mView.initData();
    }

    @Override
    public void login(Login login) {
        mCompositeSubscription.add(mModel.login(login).subscribe(new Consumer<_User>() {
            @Override
            public void accept(@NonNull _User user) throws Exception {
                LogUtil.e("login", user.getData().toString());
                SpUtil.saveString(App.getApplication(), Constant.USER, new Gson().toJson(user));
                SpUtil.saveString(App.getApplication(), Constant.UUID, user.getData().getUuid());
//                SpUtil.saveString(App.getApplication(), Constant.ENTERPRISE_NAME, user.getData().getOrganization().getSubWholeEquipment());
                SpUtil.saveInt(App.getApplication(), Constant.ENTERPRISE_ID, user.getData().getOrganization().getOrganizationId());
                mView.loginSuccess();
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                LogUtil.e(TAG, "--------------" + throwable);
                mView.showMsg(App.getApplication().getResources().getString(R.string.load_out_time));
            }
        }));
    }
}
