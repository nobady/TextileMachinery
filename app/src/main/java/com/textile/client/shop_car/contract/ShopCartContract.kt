package com.textile.client.shop_car.contract

import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter
import com.textile.client.shop_car.model.ShopCartModel

/**
 * Created by lff on 2019/2/14.
 */
interface ShopCartContract {
    interface IShopCartView:IBaseView {
        fun setShopCartData(dataList: List<ShopCartModel.ListData>)
    }

    interface IShopCartPresenter:IPresenter<IShopCartView>{
        fun getShopCartList()
    }
}