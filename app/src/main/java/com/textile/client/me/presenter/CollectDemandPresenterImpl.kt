package com.textile.client.me.presenter

import com.game.base.mvp.BasePresenter
import com.game.base.net.RxHttpUtil
import com.textile.client.me.contract.CollectDemandContract
import com.textile.client.me.model.CollectDemandModel
import com.textile.client.net.DataObserver
import com.textile.client.net.NetApi
import com.textile.client.net.Transformer
import com.textile.client.utils.RequestbodyUtil

class CollectDemandPresenterImpl : BasePresenter<CollectDemandContract.ICollectDemandView>(),
    CollectDemandContract.ICollectDemandPresenter {
    override fun getListDemandCollect() {
        RequestbodyUtil.createCollectDemandList().let {
            RxHttpUtil.createApi(NetApi::class.java)
                ?.getListDemandCollect(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe(object : DataObserver<CollectDemandModel>(true, getView()?.getContext()!!) {
                    override fun onSuccess(data: CollectDemandModel) {
                        getView()?.getListSuccess(data)
                    }
                })
        }
    }

}