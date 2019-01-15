package com.textile.client.login.model

/**
 * Updated by lff on 2019-01-15
 */
data class LoginModel(
    var phone: String,
    var sex: String,
    var image: String,
    var invitationCode: String,
    var level: String,
    var language: Int,
    var integralNum: String,
    var rowVersion: String,
    var token: String,
    var collectionNum: Int,
    var orderNum: Int
)