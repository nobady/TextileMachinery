package com.textile.client.utils

import com.google.gson.JsonObject
import okhttp3.MediaType
import okhttp3.RequestBody

/**
 * Created by Administrator on 2019/1/11.
 */
object RequestbodyUtil {

    private val mediaType = MediaType.parse("application/json; charset=utf-8")

    fun createLoginBody(phone: String, pwd: String): RequestBody? {

        val jsonObject = JsonObject()
        jsonObject.addProperty("phone", phone)
        jsonObject.addProperty("password", pwd)
        return RequestBody.create(mediaType, jsonObject.toString())
    }

    fun createGetVerificationCodeBody(phone: String): RequestBody? {
        val jsonObject = JsonObject()
        jsonObject.addProperty("phone", phone)
        return RequestBody.create(mediaType, jsonObject.toString())
    }

    fun createRegisterBody(phone: String, pwd: String, code: String): RequestBody? {

        val jsonObject = JsonObject()
        jsonObject.addProperty("phone", phone)
        jsonObject.addProperty("password", pwd)
        jsonObject.addProperty("code", code)
        return RequestBody.create(mediaType, jsonObject.toString())
    }

    fun createBannerListBody(type: Int): RequestBody? {
        val jsonObject = JsonObject()
        jsonObject.addProperty("bannerTypeEnum", type)
        return RequestBody.create(mediaType, jsonObject.toString())
    }

    fun createClearCollBody(): RequestBody {
        val jsonObject = JsonObject()
        jsonObject.addProperty("type", 0)
        return RequestBody.create(mediaType, jsonObject.toString())
    }

    fun createUpdatePhoneBody(phoneNum: String, password: String): RequestBody {
        val jsonObject = JsonObject()
        jsonObject.addProperty("phone", phoneNum)
        jsonObject.addProperty("password", password)
        return RequestBody.create(mediaType, jsonObject.toString())
    }

    fun createSetPasswordBody(phoneNum: String, password: String, code: String): RequestBody{
        val jsonObject = JsonObject()
        jsonObject.addProperty("phone", phoneNum)
        jsonObject.addProperty("password", password)
        jsonObject.addProperty("code", code)
        return RequestBody.create(mediaType, jsonObject.toString())
    }
}