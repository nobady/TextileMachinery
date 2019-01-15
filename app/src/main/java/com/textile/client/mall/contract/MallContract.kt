package com.textile.client.mall.contract

import com.game.base.mvp.BasePresenter
import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter

/**
 * Created by lff on 2019/1/15.
 */
interface MallContract {
    enum class BannerType{
        BANNER_LUNTAN,
        BANNER_MALL,
        BANNER_MALL_BD
    }

    interface IMallView:IBaseView{}

    interface IMallPresenter:IPresenter<IMallView>{
         fun getBannerList(bannerTypeEnum:Int)
    }
}