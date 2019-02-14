package com.textile.client.shop_car.model

/**
 * Created by lff on 2019-02-14
 */
data class ShopCartModel(var list: List<ShopCartModel.ListData>) {
    data class ListData(
        var id: Int,
        var imageUrl: String,
        var model: String,
        var money: String,
        var name: String
    )
}