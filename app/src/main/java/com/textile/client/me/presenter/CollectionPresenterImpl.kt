package com.textile.client.me.presenter

import android.util.Log
import com.game.base.mvp.BasePresenter
import com.game.base.net.RxHttpUtil
import com.game.base.utils.toast
import com.textile.client.me.contract.CollectionContract
import com.textile.client.me.model.ClearCollModel
import com.textile.client.net.DataObserver
import com.textile.client.net.NetApi
import com.textile.client.net.Transformer
import com.textile.client.utils.RequestbodyUtil

/**
 * Created by bo on 2019/1/10.
 */
class CollectionPresenterImpl : BasePresenter<CollectionContract.ICollectionView>(),
    CollectionContract.ICollectionPresenter {
    override fun clearCollected() {
        getView()?.showLoading()
        RequestbodyUtil.createClearCollBody().let {
            RxHttpUtil.createApi(NetApi::class.java)
                ?.clearCollected(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe {
                    object : DataObserver<ClearCollModel>(getView()?.getContext()!!) {
                        override fun onSuccess(data: ClearCollModel) {
                            getView()?.dismissLoading()
                            getView()?.getContext()?.toast("清空成功")
                            Log.i("clearCollected", data.toString())
                        }

                        override fun onError(msg: String) {
                            getView()?.dismissLoading()
                        }

                    }
                }
        }
    }
}