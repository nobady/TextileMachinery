package com.textile.client.mall.contract

import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter
import com.textile.client.mall.model.BrandModel
import com.textile.client.mall.model.HotModel

/**
 * Created by lff on 2019/2/13.
 */
interface ClassifyInfoContract {
    interface IClassifyInfoView:IBaseView{
        fun setCategoryList(dataList: List<HotModel.ListData>)
        fun setBrandList(data: List<BrandModel>)
    }


    interface IClassifyInfoPresenter:IPresenter<IClassifyInfoView>{
        fun getCategoryList(brandId:Int,categoryId:String,priceAsc:Boolean)
        fun getBrandData(categoryId: String)
    }
}