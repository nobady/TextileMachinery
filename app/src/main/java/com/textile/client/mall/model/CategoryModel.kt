package com.textile.client.mall.model

/**
 * Updated by lff on 2019-02-13
 */
data class CategoryModel(
    var current: Int,
    var size: Int,
    var total: Int,
    var list: List<ListData>
) {
    data class ListData(
        var categoryBrandId: Int,
        var categoryId: Int,
        var companyId: String,
        var hotSort: Int,
        var id: Int,
        var imageType: Int,
        var imageUrl: String,
        var modeId: Int,
        var modeName: String,
        var name: String,
        var price: Int,
        var stock: Int,
        var warehouseId: Int
    )
}