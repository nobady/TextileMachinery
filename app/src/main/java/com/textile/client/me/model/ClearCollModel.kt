package com.textile.client.me.model

data class ClearCollModel(
    val code: Int,
    val `data`: Data,
    val message: String
)

data class Data(val any: Any)