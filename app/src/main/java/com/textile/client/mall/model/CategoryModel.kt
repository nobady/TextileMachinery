package com.textile.client.mall.model

/**
 * Updated by lff on 2019-01-16
 */
data class CategoryModel(var list: List<ListData>) {
    data class ListData(
        var id: String,
        var createAt: Long,
        var lastEditAt: Long,
        var createId: Int,
        var lastEditId: Int,
        var deleted: Int,
        var name: String,
        var ename: String,
        var image: String
    )
}