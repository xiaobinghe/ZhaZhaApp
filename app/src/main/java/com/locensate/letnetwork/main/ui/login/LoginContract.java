package com.locensate.letnetwork.main.ui.login;

import com.locensate.letnetwork.base.BaseModel;
import com.locensate.letnetwork.base.BasePresenter;
import com.locensate.letnetwork.base.BaseView;
import com.locensate.letnetwork.bean.Login;
import com.locensate.letnetwork.bean._User;

import io.reactivex.Observable;

/**
 * @author xiaobinghe
 */


public interface LoginContract {

    interface View extends BaseView {
        /**
         * login success
         */
        void loginSuccess();

        /**
         * show message for toast
         *
         * @param s the message
         */
        void showMsg(String s);

        /**
         * init data
         */
        void initData();

    }

    interface Model extends BaseModel {


        /**
         * 登录
         *
         * @param login
         * @return
         */
        Observable<_User> login(Login login);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        /**
         * login
         *
         * @param login the entry of login
         */
        abstract void login(Login login);


    }
}
