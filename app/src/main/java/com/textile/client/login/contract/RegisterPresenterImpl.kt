package com.textile.client.login.contract

import com.game.base.mvp.BasePresenter
import com.game.base.net.RxHttpUtil
import com.game.base.utils.toActivityFinish
import com.game.base.utils.toast
import com.textile.client.R
import com.textile.client.home.ui.HomeActivity
import com.textile.client.login.LoginUtil
import com.textile.client.login.model.LoginModel
import com.textile.client.login.model.UserPrefs
import com.textile.client.net.DataObserver
import com.textile.client.net.NetApi
import com.textile.client.net.Transformer
import com.textile.client.utils.RequestbodyUtil
import io.reactivex.disposables.Disposable

/**
 * Created by lff on 2019/1/14.
 */
class RegisterPresenterImpl : BasePresenter<RegisterContract.IRegisterView>(), RegisterContract.RegisterPresenter {

    override fun resetPwd(phone: String, pwd: String, code: String) {
        getView()?.showLoading()
        RequestbodyUtil.createRegisterBody(phone, pwd, code)?.let {
            RxHttpUtil.createApi(NetApi::class.java)?.resetPwd(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe(object : DataObserver<LoginModel>(getView()?.getContext()!!) {
                    override fun onSuccess(data: LoginModel) {
                        getView()?.dismissLoading()
                        getView()?.getContext()?.toast(R.string.toast_reset_pwd_success)
                    }

                    override fun onError(msg: String) {
                        getView()?.dismissLoading()
                    }
                })
        }

    }


    override fun getCode(phone: String) {
        getView()?.showCountView()
        RequestbodyUtil.createGetVerificationCodeBody(phone)?.let {
            RxHttpUtil.createApi(NetApi::class.java)
                ?.getVerificationCode(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe(object : DataObserver<LoginModel>(getView()?.getContext()!!) {
                    override fun onSuccess(data: LoginModel) {
                        getView()?.getContext()?.toast(R.string.send_get_code_success)
                    }

                    override fun onError(msg: String) {
                        getView()?.resetCountView()
                    }

                    override fun onSubscribe(d: Disposable) {
                        addSubscription(d)
                    }
                })
        }

    }

    override fun register(phone: String, pwd: String, code: String) {
        getView()?.showLoading()
        RequestbodyUtil.createRegisterBody(phone, pwd, code)?.let {
            RxHttpUtil.createApi(NetApi::class.java)
                ?.register(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe(object : DataObserver<LoginModel>(getView()?.getContext()!!) {
                    override fun onSuccess(data: LoginModel) {
                        getView()?.dismissLoading()
                        getView()?.getContext()?.toast(R.string.register_success)
                        UserPrefs.getInstance.setUser(data)
                        //登录成功，设置网络参数
                        LoginUtil.initHttpConfig()
                        getView()?.getContext()?.toActivityFinish(HomeActivity::class.java)
                    }

                    override fun onError(msg: String) {
                        getView()?.resetCountView()
                        getView()?.dismissLoading()
                        getView()?.getContext()?.toast(msg)
                    }
                })
        }
    }

}