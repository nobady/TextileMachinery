package com.textile.client.login.contract

import com.game.base.mvp.BasePresenter
import com.game.base.net.RxHttpUtil
import com.game.base.utils.LogUtil
import com.textile.client.login.model.LoginModel
import com.textile.client.net.DataObserver
import com.textile.client.net.NetApi
import com.textile.client.net.Transformer
import com.textile.client.utils.RequestbodyUtil

class LoginPresenterImpl : BasePresenter<LoginContract.ILoginView>(),LoginContract.LoginPresenter{


    override fun forgetPwd() {
    }

    override fun startLogin(phone: String, pwd: String) {
        getView()?.showLoading()

        RequestbodyUtil.createLoginBody(phone,pwd)?.let {
            RxHttpUtil
                .createApi(NetApi::class.java)
                ?.login(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe { object : DataObserver<LoginModel>(getView()?.getContext()!!){
                    override fun onSuccess(data: LoginModel) {
                        getView()?.dismissLoading()
                        LogUtil.logV(data.phone)
                        //跳转到首页
                    }

                    override fun onError(msg: String) {
                        getView()?.dismissLoading()
                        LogUtil.logV(msg)
                    }
                } }
        }
    }

}