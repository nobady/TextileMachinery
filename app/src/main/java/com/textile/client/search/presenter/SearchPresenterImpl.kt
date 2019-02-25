package com.textile.client.search.presenter

import com.game.base.mvp.BasePresenter
import com.game.base.net.RxHttpUtil
import com.textile.client.net.DataObserver
import com.textile.client.net.NetApi
import com.textile.client.net.Transformer
import com.textile.client.search.contract.SearchContract

class SearchPresenterImpl : BasePresenter<SearchContract.ISearchView>(), SearchContract.ISearchPresenter {
    override fun searchUser(keyWord: String) {
        val headerMap = LinkedHashMap<String, String>()
        headerMap["Content-Type"] = "application/json; charset=utf-8"

        RxHttpUtil.createApi(NetApi::class.java)
            ?.searchUser(keyWord)
            ?.compose(Transformer.switchSchedulers())
            ?.subscribe(object : DataObserver<ArrayList<String>>(true, getView()?.getContext()!!) {
                override fun onSuccess(data: ArrayList<String>) {
                    getView()?.searchSuccess(data)
                }
            })
    }
}