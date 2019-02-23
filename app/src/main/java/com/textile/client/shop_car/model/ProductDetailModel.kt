package com.textile.client.shop_car.model

/**
 * Created by admin on 2019-02-21
 */
data class ProductDetailModel(
    var categoryBrandId: Int,
    var categoryId: Int,
    var companyId: String,
    var content: String,
    var hotSort: Int,
    var id: Int,
    var imageType: Int,
    var modeId: Int,
    var modeName: String,
    var name: String,
    var price: Int,
    var stock: Int,
    var warehouseId: Int,
    var warehouseName: String,
    var uploadFiles: List<UploadFiles>
) {
    data class UploadFiles(
        var createAt: String,
        var createId: Int,
        var deleted: Int,
        var fileType: Int,
        var id: String,
        var lastEditAt: String,
        var lastEditId: Int,
        var mimeType: String,
        var objectId: Int,
        var objectType: Int,
        var size: Int,
        var title: String,
        var url: String
    )
}