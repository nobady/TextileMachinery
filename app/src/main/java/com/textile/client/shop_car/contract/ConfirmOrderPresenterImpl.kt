package com.textile.client.shop_car.contract

import com.game.base.mvp.BasePresenter
import com.game.base.net.RxHttpUtil
import com.google.gson.JsonObject
import com.textile.client.net.DataObserver
import com.textile.client.net.NetApi
import com.textile.client.net.Transformer
import com.textile.client.shop_car.model.ConfirmOrderModel
import com.textile.client.shop_car.model.ShopCartModel
import com.textile.client.utils.RequestbodyUtil
import io.reactivex.disposables.Disposable

/**
 * Created by admin on 2019/2/25.
 */
class ConfirmOrderPresenterImpl:BasePresenter<ConfrimOrderContract.IConfirmOrderView>(),ConfrimOrderContract.IConfirmOrderPresenter {

    private var productVOSList: List<ConfirmOrderModel.ProductVOS> = ArrayList()

    override fun modifyProductNumber(productId: Int, type: Int) {
        RequestbodyUtil.createModifyProductNumber(productId, type).let {
            RxHttpUtil.createApi(NetApi::class.java)
                ?.modifyProductNumber(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe(object :DataObserver<JsonObject>(true,getView()?.getContext()!!){
                    override fun onSuccess(data: JsonObject) {
                        getAllMoney(productVOSList)
                    }

                    override fun onSubscribe(d: Disposable) {
                        super.onSubscribe(d)
                        addSubscription(d)
                    }

                })
        }
    }


    override fun getShoppingCartList(dataList: List<ShopCartModel.ListData>) {

        RequestbodyUtil.createConfirmOrderBody(dataList).let {
            RxHttpUtil.createApi(NetApi::class.java)
                ?.getConfrimOrderList(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe(object :DataObserver<ConfirmOrderModel>(true,true,getView()?.getContext()!!){
                    override fun onSuccess(data: ConfirmOrderModel) {
                        productVOSList = data.productVOS
                        getView()?.showUserAddress(data.userAddress)
                        getView()?.showProductList(data.productVOS)
                        getAllMoney(data.productVOS)
                    }

                    override fun onSubscribe(d: Disposable) {
                        super.onSubscribe(d)
                        addSubscription(d)
                    }

                })
        }
    }

    private fun getAllMoney(dataList: List<ConfirmOrderModel.ProductVOS>){
        var allMoney = 0
        dataList.forEach {
            allMoney+=it.money*it.amount
        }
        getView()?.showAllMoney(allMoney)
    }


}