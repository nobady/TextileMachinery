package com.textile.client.net

/**
 * Created by lff on 2019-01-11
 */
data class BaseData<T>(
    var code: Int,
    var data: T,
    var message: String
)