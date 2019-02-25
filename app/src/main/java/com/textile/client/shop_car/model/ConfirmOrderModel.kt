package com.textile.client.shop_car.model

/**
 * Updated by admin on 2019-02-25
 */
data class ConfirmOrderModel(
    var userAddress: UserAddress,
    var status: String,
    var productVOS: List<ProductVOS>
) {
    data class UserAddress(
        var id: String,
        var receiver: String,
        var phone: String,
        var address: String,
        var province: String,
        var city: String,
        var district: String
    )

    data class ProductVOS(
        var id: Int,
        var name: String,
        var model: String,
        var money: Int,
        var imageUrl: String,
        var amount: Int,
        var expressName: String,
        var address: String,
        var freight: String,
        var companyLogoUrl: String,
        var companyName: String,
        var type:Int//1,加，2，减
    )
}