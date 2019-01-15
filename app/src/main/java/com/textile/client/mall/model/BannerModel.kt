package com.textile.client.mall.model

/**
 * Updated by lff on 2019-01-15
 */
data class BannerModel(var list: List<ListData>) {
    data class ListData(
        var id: String,
        var createAt: Long,
        var lastEditAt: Long,
        var createId: Int,
        var lastEditId: Int,
        var deleted: Int,
        var title: String,
        var content: String,
        var orderNum: Int,
        var image: String,
        var detailUrl: String,
        var bannerType: Int
    )
}