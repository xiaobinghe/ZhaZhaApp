package com.locensate.letnetwork.main.ui.login;

import com.locensate.letnetwork.api.Api;
import com.locensate.letnetwork.base.RxSchedulers;
import com.locensate.letnetwork.bean.Login;
import com.locensate.letnetwork.bean._User;

import io.reactivex.Observable;

/**
 *
 * @author xiaobinghe
 */


public class LoginModel implements LoginContract.Model {

    @Override
    public Observable<_User> login(Login login) {
        return Api.getInstance().service.login(login).compose(RxSchedulers.<_User>applyObservableAsync());
    }
}
