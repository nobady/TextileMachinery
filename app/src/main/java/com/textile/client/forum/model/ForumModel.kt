package com.textile.client.forum.model

data class ForumModel(
    val current: Int = 0,
    val list: List<X> = listOf(),
    val size: Int = 0,
    val total: Int = 0
) {
    data class X(
        val categoryBrandId: Int = 0,
        val categoryId: Int = 0,
        val collectNum: Int = 0,
        val commentNum: Int = 0,
        val content: String = "",
        val createAt: String = "",
        val id: Int = 0,
        val imageType: Int = 0,
        val modeId: Int = 0,
        val title: String = "",
        val uploadFiles: List<UploadFile> = listOf(),
        val userId: Int = 0,
        val userImage: String = ""
    ) {
        data class UploadFile(
            val createAt: String = "",
            val createId: Int = 0,
            val deleted: Int = 0,
            val fileType: Int = 0,
            val id: String = "",
            val lastEditAt: String = "",
            val lastEditId: Int = 0,
            val mimeType: String = "",
            val objectId: Int = 0,
            val objectType: Int = 0,
            val size: Int = 0,
            val title: String = "",
            val url: String = ""
        )
    }
}