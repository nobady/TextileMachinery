package com.textile.client.login.contract

import com.game.base.mvp.BasePresenter

class LoginPresenterImpl : BasePresenter<LoginContract.ILoginView>(),LoginContract.LoginPresenter{


    override fun forgetPwd() {
    }

    override fun startLogin(phone: String, pwd: String) {


    }

}