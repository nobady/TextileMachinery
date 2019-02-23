package com.textile.client.forum.presenter

import com.game.base.mvp.BasePresenter
import com.game.base.net.RxHttpUtil
import com.textile.client.forum.contract.DetailContract
import com.textile.client.forum.model.DetailModel
import com.textile.client.net.DataObserver
import com.textile.client.net.NetApi
import com.textile.client.net.Transformer
import com.textile.client.utils.RequestbodyUtil

class DetailPresenterImpl : BasePresenter<DetailContract.IDetailView>(), DetailContract.IDetailPresenter {
    override fun loadDetail(itemId: String) {
        RequestbodyUtil.createDetail(itemId).let {
            RxHttpUtil.createApi(NetApi::class.java)
                ?.loadDetail(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe(object : DataObserver<DetailModel>(true, getView()?.getContext()!!) {
                    override fun onSuccess(data: DetailModel) {

                    }
                })
        }
    }
}