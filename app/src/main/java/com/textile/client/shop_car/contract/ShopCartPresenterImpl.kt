package com.textile.client.shop_car.contract

import com.game.base.mvp.BasePresenter
import com.game.base.net.RxHttpUtil
import com.textile.client.net.DataObserver
import com.textile.client.net.NetApi
import com.textile.client.net.Transformer
import com.textile.client.shop_car.model.ShopCartModel
import io.reactivex.disposables.Disposable

/**
 * Created by lff on 2019/2/14.
 */
class ShopCartPresenterImpl:BasePresenter<ShopCartContract.IShopCartView>(),ShopCartContract.IShopCartPresenter {

    override fun getShopCartList() {
        RxHttpUtil.createApi(NetApi::class.java)
            ?.getShopCartList()
            ?.compose(Transformer.switchSchedulers())
            ?.subscribe(object :DataObserver<ShopCartModel>(true,true,getView()?.getContext()!!){
                override fun onSuccess(data: ShopCartModel) {
                    getView()?.setShopCartData(data.list)
                }

                override fun onSubscribe(d: Disposable) {
                    super.onSubscribe(d)
                    addSubscription(d)
                }
            })
    }
}