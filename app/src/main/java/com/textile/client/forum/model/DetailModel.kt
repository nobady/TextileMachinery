package com.textile.client.forum.model

data class DetailModel(
    val avatar: String,
    val collectionCount: Int,
    val collectionStatus: Int,
    val commentCount: Int,
    val content: String,
    val coverUrl: String,
    val createAt: String,
    val id: Int,
    val imageType: Int,
    val imageUrls: List<String>,
    val name: String,
    val userId: Int,
    val userPhone: String
)