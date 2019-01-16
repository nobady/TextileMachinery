package com.textile.client.mall.contract

import com.game.base.mvp.BasePresenter
import com.game.base.net.RxHttpUtil
import com.game.base.utils.LogUtil
import com.game.base.utils.toast
import com.textile.client.mall.model.BannerModel
import com.textile.client.net.DataObserver
import com.textile.client.net.NetApi
import com.textile.client.net.Transformer
import com.textile.client.utils.RequestbodyUtil

/**
 * Created by lff on 2019/1/15.
 */
class MallPresenterImpl():BasePresenter<MallContract.IMallView>(),MallContract.IMallPresenter {

    override fun getBannerList(bannerTypeEnum: Int) {
        RequestbodyUtil.createBannerListBody(bannerTypeEnum)?.let {
            RxHttpUtil.createApi(NetApi::class.java)
                ?.getBannerList(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe(object :DataObserver<BannerModel>(true,getView()?.getContext()!!){
                    override fun onSuccess(data: BannerModel) {
                        LogUtil.logV("${data.list.size}")
                    }

                    override fun onError(msg: String) {
                    }

                })
        }
    }
}