package com.textile.client.mall.contract

import com.game.base.mvp.BasePresenter
import com.game.base.net.RxHttpUtil
import com.textile.client.mall.model.BannerModel
import com.textile.client.mall.model.CategoryModel
import com.textile.client.net.DataObserver
import com.textile.client.net.NetApi
import com.textile.client.net.Transformer
import com.textile.client.utils.RequestbodyUtil
import io.reactivex.disposables.Disposable

/**
 * Created by lff on 2019/1/15.
 */
class MallPresenterImpl : BasePresenter<MallContract.IMallView>(), MallContract.IMallPresenter {


    override fun getCategoryList() {
        RxHttpUtil.createApi(NetApi::class.java)
            ?.getCategoryList()
            ?.compose(Transformer.switchSchedulers())
            ?.subscribe(object : DataObserver<CategoryModel>(true, getView()?.getContext()!!) {
                override fun onSuccess(data: CategoryModel) {
                    getView()?.setCategoryData(data.list)
                }

                override fun onSubscribe(d: Disposable) {
                    super.onSubscribe(d)
                    addSubscription(d)
                }
            })
    }

    override fun getBannerList(bannerTypeEnum: Int) {
        RequestbodyUtil.createBannerListBody(bannerTypeEnum)?.let {
            RxHttpUtil.createApi(NetApi::class.java)
                ?.getBannerList(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe(object :DataObserver<BannerModel>(true,getView()?.getContext()!!){
                    override fun onSuccess(data: BannerModel) {
                        getView()?.setBannerData(bannerTypeEnum,data.list)
                    }
                    override fun onSubscribe(d: Disposable) {
                        super.onSubscribe(d)
                        addSubscription(d)
                    }
                })
        }
    }
}