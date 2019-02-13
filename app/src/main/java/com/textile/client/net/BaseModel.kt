package com.textile.client.net

data class BaseModel<T>(
    val code: Int,
    val `data`: T,
    val message: String
)