package com.textile.client.login.contract

import com.game.base.mvp.BasePresenter
import com.game.base.net.OkHttpConfig

class LoginPresenterImpl : BasePresenter<LoginContract.ILoginView>(),LoginContract.LoginPresenter{


    override fun forgetPwd() {
    }

    override fun startLogin(phone: String, pwd: String) {
    }

}