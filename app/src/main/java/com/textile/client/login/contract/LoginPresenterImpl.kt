package com.textile.client.login.contract

import com.game.base.mvp.BasePresenter
import com.game.base.net.RxHttpUtil
import com.game.base.utils.toActivityFinish
import com.game.base.utils.toast
import com.textile.client.home.ui.HomeActivity
import com.textile.client.login.LoginUtil
import com.textile.client.login.model.LoginModel
import com.textile.client.login.model.UserPrefs
import com.textile.client.net.DataObserver
import com.textile.client.net.NetApi
import com.textile.client.net.Transformer
import com.textile.client.utils.RequestbodyUtil
import io.reactivex.disposables.Disposable

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
                ?.subscribe(object : DataObserver<LoginModel>(true,getView()?.getContext()!!) {
                    override fun onSuccess(data: LoginModel) {
                        getView()?.dismissLoading()
                        UserPrefs.getInstance.setUser(data)
                        //登录成功，设置网络参数
                        LoginUtil.initHttpConfig()
                        getView()?.getContext()?.toActivityFinish(HomeActivity::class.java)
                    }

                    override fun onError(msg: String) {
                        getView()?.dismissLoading()
                    }

                    override fun onSubscribe(d: Disposable) {
                        addSubscription(d)
                    }
                })
        }
    }
}