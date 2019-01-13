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

    fun createClearCollBody(): RequestBody {
        val jsonObject = JsonObject()
        jsonObject.addProperty("type", 0)
        return RequestBody.create(mediaType, jsonObject.toString())
    }
}