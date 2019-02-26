package com.textile.client.shop_car.presenter

import com.game.base.mvp.BasePresenter
import com.game.base.net.RxHttpUtil
import com.textile.client.R
import com.textile.client.net.DataObserver
import com.textile.client.net.NetApi
import com.textile.client.net.Transformer
import com.textile.client.shop_car.contract.MyAddressContract
import com.textile.client.shop_car.model.MyAddressModel
import io.reactivex.disposables.Disposable

/**
 * Created by admin on 2019/2/26.
 */
class MyAddressPresenterImpl:BasePresenter<MyAddressContract.IMyAddressView>(),
    MyAddressContract.IMyAddressPresenter {

    override fun getUserAddressList() {
        RxHttpUtil.createApi(NetApi::class.java)
            ?.getUserAddressList()
            ?.compose(Transformer.switchSchedulers())
            ?.subscribe(object :DataObserver<List<MyAddressModel>>(true,true,getView()?.getContext()!!){
                override fun onSuccess(data: List<MyAddressModel>) {
                    if (data.isEmpty()){
                        getView()?.showEmptyLayout()
                    }else{
                        getView()?.showUserAddressList(data)
                        getView()?.showDefaultAddress(data[0])
                    }

                }

                override fun onSubscribe(d: Disposable) {
                    super.onSubscribe(d)
                    addSubscription(d)
                }

            })
    }
}