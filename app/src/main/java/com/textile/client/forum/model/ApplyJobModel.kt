package com.textile.client.forum.model

data class ApplyJobModel(
    val current: Int,
    val list: List<X>,
    val size: Int,
    val total: Int
){
    data class X(
        val age: Int,
        val avatar: String,
        val collectionStatus: Int,
        val content: String,
        val createAt: String,
        val education: String,
        val expectedSalary: String,
        val hidePhone: Int,
        val id: Int,
        val imageType: Int,
        val imageUrls: List<String>,
        val location: String,
        val name: String,
        val title: String,
        val userId: Int,
        val userPhone: String,
        val workExperience: String
    )
}