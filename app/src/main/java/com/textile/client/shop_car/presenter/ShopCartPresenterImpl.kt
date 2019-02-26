package com.textile.client.shop_car.presenter

import com.game.base.mvp.BasePresenter
import com.game.base.net.RxHttpUtil
import com.google.gson.JsonObject
import com.textile.client.net.DataObserver
import com.textile.client.net.NetApi
import com.textile.client.net.Transformer
import com.textile.client.shop_car.contract.ShopCartContract
import com.textile.client.shop_car.model.ShopCartModel
import com.textile.client.utils.RequestbodyUtil
import io.reactivex.disposables.Disposable

/**
 * Created by lff on 2019/2/14.
 */
class ShopCartPresenterImpl:BasePresenter<ShopCartContract.IShopCartView>(),
    ShopCartContract.IShopCartPresenter {

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

    override fun modifyProductNumber(productId: Int, type: Int) {
        RequestbodyUtil.createModifyProductNumber(productId, type).let {
            RxHttpUtil.createApi(NetApi::class.java)
                ?.modifyProductNumber(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe(object :DataObserver<JsonObject>(true,getView()?.getContext()!!){
                    override fun onSuccess(data: JsonObject) {
                        getView()?.setModifyProductNumberSuccess()
                    }

                    override fun onSubscribe(d: Disposable) {
                        super.onSubscribe(d)
                        addSubscription(d)
                    }

                })
        }
    }

    override fun deleteProduct(position: Int, productId: Int) {
        RequestbodyUtil.createDeleteShopCartProductBody(position).let {
            RxHttpUtil.createApi(NetApi::class.java)
                ?.removeShopCartProduct(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe(object :DataObserver<JsonObject>(true,getView()?.getContext()!!){
                    override fun onSuccess(data: JsonObject) {
                        getView()?.setDeleteSuccess(position)
                    }

                    override fun onSubscribe(d: Disposable) {
                        super.onSubscribe(d)
                        addSubscription(d)
                    }

                })
        }
    }

    override fun getProductInfoById(productId: Int) {

    }

}