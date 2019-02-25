package com.textile.client.shop_car.contract

import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter
import com.textile.client.shop_car.model.ConfirmOrderModel
import com.textile.client.shop_car.model.ShopCartModel

/**
 * Created by admin on 2019/2/25.
 */
interface ConfrimOrderContract {

    interface IConfirmOrderView:IBaseView{
        fun showUserAddress(userAddress: ConfirmOrderModel.UserAddress)
        fun showProductList(productVOS: List<ConfirmOrderModel.ProductVOS>)
        fun showAllMoney(allMoney: Int)
        fun setModifyProductNumberSuccess()
    }

    interface IConfirmOrderPresenter:IPresenter<IConfirmOrderView>{

        fun getShoppingCartList(dataList:List<ShopCartModel.ListData>)
        fun modifyProductNumber(productId: Int, type: Int)
    }
}