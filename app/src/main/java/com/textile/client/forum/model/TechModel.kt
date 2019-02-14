package com.textile.client.forum.model

data class TechModel(
    val current: Int,
    val list: ArrayList<X>,
    val size: Int,
    val total: Int
) {
    data class X(
        val avatar: String,
        val collectionCount: Int,
        val collectionStatus: Int,
        val commentCount: Int,
        val content: String,
        val createAt: String,
        val id: Int,
        val imageType: Int,
        val imageUrls: List<String>,
        val name: String,
        val userId: Int,
        val userPhone: String
    )
}