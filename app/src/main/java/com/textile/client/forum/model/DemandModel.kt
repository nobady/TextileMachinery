package com.textile.client.forum.model

data class DemandModel(
    val current: Int,
    val list: List<X>,
    val size: Int,
    val total: Int
) {
    data class X(
        val avatar: String,
        val collectionStatus: Int,
        val content: String,
        val createAt: String,
        val equipmentStatus: String,
        val expectedSalary: String,
        val hidePhone: Int,
        val id: Int,
        val imageType: Int,
        val imageUrls: List<String>,
        val location: String,
        val model: String,
        val name: String,
        val number: Int,
        val phone: String,
        val specification: String,
        val title: String,
        val userId: Int,
        val userPhone: String
    )
}