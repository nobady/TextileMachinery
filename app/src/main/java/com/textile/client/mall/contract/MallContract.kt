package com.textile.client.mall.contract

import com.game.base.mvp.BasePresenter
import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter
import com.textile.client.mall.model.BannerModel
import com.textile.client.mall.model.CategoryModel

/**
 * Created by lff on 2019/1/15.
 */
interface MallContract {

    companion object {
        val BANNER_LUNTAN = 1
        val BANNER_MALL = 2
        val BANNER_MALL_BD = 3
    }

    interface IMallView:IBaseView{
        fun setBannerData(type:Int,bannerList: List<BannerModel.ListData>)
        fun setCategoryData(mCategoryList: List<CategoryModel.ListData>)
    }

    interface IMallPresenter:IPresenter<IMallView>{
         fun getBannerList(bannerTypeEnum:Int)
        fun getCategoryList()
    }
}