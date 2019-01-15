package com.textile.client.me.presenter

import com.game.base.mvp.BasePresenter
import com.game.base.net.RxHttpUtil
import com.game.base.utils.toast
import com.textile.client.R
import com.textile.client.login.model.LoginModel
import com.textile.client.login.model.UserPrefs
import com.textile.client.me.contract.SetPhoneContract
import com.textile.client.me.model.ClearCollModel
import com.textile.client.me.model.UpdatePhoneModel
import com.textile.client.net.DataObserver
import com.textile.client.net.NetApi
import com.textile.client.net.Transformer
import com.textile.client.utils.RequestbodyUtil
import io.reactivex.disposables.Disposable

/**
 * Created by bo on 2019/1/15.
 */
class SetPhonePresenterImpl : BasePresenter<SetPhoneContract.ISetPhoneView>(), SetPhoneContract.ISetPhonePresenter {
    override fun getCode(phoneNum: String) {
            getView()?.showCountView()
            RequestbodyUtil.createGetVerificationCodeBody(phoneNum)?.let {
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

    override fun setPasswordCommit(phoneNum: String, password: String, code: String) {
        getView()?.showLoading()
        RequestbodyUtil.createSetPasswordBody(phoneNum, password, code).let {
            RxHttpUtil.createApi(NetApi::class.java)?.updatePassword(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe(
                    object : DataObserver<ClearCollModel>(getView()?.getContext()!!) {
                        override fun onSuccess(data: ClearCollModel) {
                            getView()?.dismissLoading()
                        }

                        override fun onError(msg: String) {
                            getView()?.dismissLoading()
                        }

                    }
                )
        }
    }

    override fun setPhoneCommit(phoneNum: String, password: String) {
        getView()?.showLoading()
        RequestbodyUtil.createUpdatePhoneBody(phoneNum, password).let {
            RxHttpUtil.createApi(NetApi::class.java)?.updatePhone(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe(
                    object : DataObserver<UpdatePhoneModel>(getView()?.getContext()!!) {
                        override fun onSuccess(data: UpdatePhoneModel) {
                            getView()?.dismissLoading()
                            UserPrefs.getInstance.updateToken(data.token)
                        }

                        override fun onError(msg: String) {
                            getView()?.dismissLoading()
                        }

                    }
                )
        }
    }
}