package com.textile.client.login.model

data class BaseModel<T>(
    val code: Int,
    val `data`: T,
    val message: String
)