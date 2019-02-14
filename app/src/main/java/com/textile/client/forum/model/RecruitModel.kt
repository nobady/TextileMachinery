package com.textile.client.forum.model

data class RecruitModel(
    val current: Int,
    val list: List<X>,
    val size: Int,
    val total: Int
) {
    data class X(
        val avatar: String,
        val collectionStatus: Int,
        val company: String,
        val content: String,
        val createAt: String,
        val expectedSalary: String,
        val financingStage: String,
        val hidePhone: Int,
        val id: Int,
        val imageType: Int,
        val imageUrls: List<String>,
        val jobDetails: String,
        val location: String,
        val name: String,
        val phone: String,
        val remark: String,
        val skillRequirement: String,
        val title: String,
        val userId: Int,
        val userPhone: String
    )
}