package com.textile.client.forum.model

data class ForumModel(
    val current: Int = 0,
    val list: List<X> = listOf(),
    val size: Int = 0, //每页显示条数
    val total: Int = 0 //总条数
) {
    data class X(
        val categoryBrandId: Int = 0,  //品牌分类Id
        val categoryId: Int = 0, //分类Id
        val collectNum: Int = 0, //收藏数
        val commentNum: Int = 0, //评论数
        val content: String = "", //内容
        val createAt: String = "", //创建时间
        val id: Int = 0, //
        val imageType: Int = 0, //  图片类型 1:无图片 2：图片 3：文字
        val modeId: Int = 0, //型号Id
        val title: String = "", //标题
        val uploadFiles: List<UploadFile> = listOf(),
        val userId: Int = 0, //用户Id
        val userImage: String = "" //用户图片
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