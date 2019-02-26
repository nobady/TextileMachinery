package com.textile.client.shop_car.contract

import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter
import com.textile.client.shop_car.model.MyAddressModel

/**
 * Created by admin on 2019/2/26.
 */
interface MyAddressContract {
    interface IMyAddressView:IBaseView{
        fun showUserAddressList(dataList: List<MyAddressModel>)
        fun showEmptyLayout()
        fun showDefaultAddress(myAddressModel: MyAddressModel)
    }

    interface IMyAddressPresenter:IPresenter<IMyAddressView>{
        fun getUserAddressList()
    }
}