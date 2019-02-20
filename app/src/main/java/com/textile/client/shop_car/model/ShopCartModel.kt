package com.textile.client.shop_car.model

/**
 * Created by lff on 2019-02-14
 */
data class ShopCartModel(var list: List<ShopCartModel.ListData>) {
    data class ListData(
        var amount: Int,
        var deliveryAddress: String,
        var expressName: String,
        var freight: Int,
        var id: Int,
        var imageUrl: String,
        var model: String,
        var money: String,
        var name: String,
        var isChecked:Boolean,
        var type:Int  //加数量（1）或者减数量（0）
    )
}