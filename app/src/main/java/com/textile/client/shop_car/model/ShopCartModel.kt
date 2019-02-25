package com.textile.client.shop_car.model

import java.io.Serializable

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
        var money: Int,
        var name: String,
        var isChecked:Boolean,
        var type:Int  //加数量（1）或者减数量（2）
    ):Serializable
}