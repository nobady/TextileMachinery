package com.textile.client.mall.contract

import com.game.base.mvp.BasePresenter
import com.game.base.net.RxHttpUtil
import com.textile.client.mall.model.BrandModel
import com.textile.client.mall.model.CategoryModel
import com.textile.client.mall.model.HotModel
import com.textile.client.net.DataObserver
import com.textile.client.net.NetApi
import com.textile.client.net.Transformer
import com.textile.client.utils.RequestbodyUtil
import io.reactivex.disposables.Disposable

/**
 * Created by lff on 2019/2/13.
 */
class ClassifyInfoPresenterImpl: BasePresenter<ClassifyInfoContract.IClassifyInfoView>(),ClassifyInfoContract.IClassifyInfoPresenter {

    private var pageIndex = 1

    override fun getBrandData(categoryId: String) {
        RequestbodyUtil.createBrandDataBody(categoryId).let {
            RxHttpUtil.createApi(NetApi::class.java)
                ?.getBrandData(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe(object :DataObserver<List<BrandModel>>(true,getView()?.getContext()!!){
                    override fun onSuccess(data: List<BrandModel>) {


                    }

                    override fun onSubscribe(d: Disposable) {
                        super.onSubscribe(d)
                        addSubscription(d)
                    }
                })
        }
    }

    override fun getCategoryList(brandId:Int, categoryId:String, priceAsc:Boolean) {
        RequestbodyUtil.createCategoryProductListBody(brandId,categoryId,priceAsc,pageIndex,10).let {
            RxHttpUtil.createApi(NetApi::class.java)?.getCategoryProductList(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe(object :DataObserver<HotModel>(true,true,getView()?.getContext()!!){
                    override fun onSuccess(data: HotModel) {
                        getView()?.setCategoryList(data.list)
                    }

                    override fun onSubscribe(d: Disposable) {
                        super.onSubscribe(d)
                        addSubscription(d)
                    }
                })
        }
    }
}