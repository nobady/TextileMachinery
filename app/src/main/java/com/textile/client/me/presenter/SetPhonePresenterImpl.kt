package com.textile.client.me.presenter

import com.game.base.mvp.BasePresenter
import com.game.base.net.RxHttpUtil
import com.textile.client.me.contract.SetPhoneContract
import com.textile.client.me.model.ClearCollModel
import com.textile.client.net.DataObserver
import com.textile.client.net.NetApi
import com.textile.client.net.Transformer
import com.textile.client.utils.RequestbodyUtil

/**
 * Created by bo on 2019/1/15.
 */
class SetPhonePresenterImpl : BasePresenter<SetPhoneContract.ISetPhoneView>(), SetPhoneContract.ISetPhonePresenter {
    override fun setPhoneCommit(phoneNum: String, password: String) {
        getView()?.showLoading()
        RequestbodyUtil.createUpdatePhoneBody(phoneNum, password).let {
            RxHttpUtil.createApi(NetApi::class.java)?.updatePhone(it)
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
}