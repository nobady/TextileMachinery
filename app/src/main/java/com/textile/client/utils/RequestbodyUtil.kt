package com.textile.client.utils

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.textile.client.shop_car.model.ShopCartModel
import okhttp3.MediaType
import okhttp3.RequestBody

/**
 * Created by Administrator on 2019/1/11.
 */
object RequestbodyUtil {

    private val mediaType = MediaType.parse("application/json; charset=utf-8")

    fun createLoginBody(phone: String, pwd: String): RequestBody {

        val jsonObject = JsonObject()
        jsonObject.addProperty("phone", phone)
        jsonObject.addProperty("password", pwd)
        return RequestBody.create(mediaType, jsonObject.toString())
    }

    fun createGetVerificationCodeBody(phone: String): RequestBody {
        val jsonObject = JsonObject()
        jsonObject.addProperty("phone", phone)
        return RequestBody.create(mediaType, jsonObject.toString())
    }

    fun createRegisterBody(phone: String, pwd: String, code: String): RequestBody {

        val jsonObject = JsonObject()
        jsonObject.addProperty("phone", phone)
        jsonObject.addProperty("password", pwd)
        jsonObject.addProperty("code", code)
        return RequestBody.create(mediaType, jsonObject.toString())
    }

    fun createBannerListBody(type: Int): RequestBody {
        val jsonObject = JsonObject()
        jsonObject.addProperty("bannerTypeEnum", type)
        return RequestBody.create(mediaType, jsonObject.toString())
    }

    fun createHotProductListBody(pageIndex: Int, pageSize: Int): RequestBody {
        val jsonObject = JsonObject()
        val pageJson = JsonObject()
        pageJson.addProperty("pageIndex", pageIndex)
        pageJson.addProperty("pageSize", pageSize)
        jsonObject.add("page", pageJson)
        return RequestBody.create(mediaType, jsonObject.toString())
    }

    fun createModifyProductNumber(productId: Int, type: Int): RequestBody {
        val jsonObject = JsonObject()
        jsonObject.addProperty("productId", productId)
        jsonObject.addProperty("type", type)
        return RequestBody.create(mediaType, jsonObject.toString())
    }

    fun createDeleteShopCartProductBody(productId: Int):RequestBody{
        val jsonArray = JsonArray()
        jsonArray.add(productId)
        val jsonObject = JsonObject()
        jsonObject.add("productIds",jsonArray)
        return RequestBody.create(mediaType, jsonObject.toString())
    }

    fun createBrandDataBody(categoryId: String): RequestBody {
        val jsonObject = JsonObject()
        jsonObject.addProperty("categoryId", categoryId)
        return RequestBody.create(mediaType, jsonObject.toString())
    }

    fun createCategoryProductListBody(
        brandId: Int,
        categoryId: String,
        priceAsc: Boolean,
        pageIndex: Int,
        pageSize: Int
    ): RequestBody {
        val jsonObject = JsonObject()
        val pageJson = JsonObject()
        pageJson.addProperty("pageIndex", pageIndex)
        pageJson.addProperty("pageSize", pageSize)
        jsonObject.add("page", pageJson)
        jsonObject.addProperty("brandId", brandId)
        jsonObject.addProperty("categoryId", categoryId)
        jsonObject.addProperty("priceAsc", priceAsc)
        return RequestBody.create(mediaType, jsonObject.toString())
    }

    fun createForumListBody(): RequestBody {
        val jsonObject = JsonObject()
        jsonObject.addProperty("categoryBrandId", 0)
        val pageJson = JsonObject()
        pageJson.addProperty("pageIndex", 1)
        pageJson.addProperty("pageSize", 10)
        jsonObject.add("page", pageJson)
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

    fun createSetPasswordBody(phoneNum: String, password: String, code: String): RequestBody {
        val jsonObject = JsonObject()
        jsonObject.addProperty("phone", phoneNum)
        jsonObject.addProperty("password", password)
        jsonObject.addProperty("code", code)
        return RequestBody.create(mediaType, jsonObject.toString())
    }

    fun createCollectDemandList(): RequestBody {
        val jsonObject = JsonObject()
        jsonObject.addProperty("categoryBrandId", 0)
        val pageJson = JsonObject()
        pageJson.addProperty("pageIndex", 1)
        pageJson.addProperty("pageSize", 10)
        jsonObject.add("page", pageJson)
        return RequestBody.create(mediaType, jsonObject.toString())
    }

    fun createTechExchangeList(): RequestBody {
        val jsonObject = JsonObject()
        jsonObject.addProperty("categoryBrandId", 0)
        val pageJson = JsonObject()
        pageJson.addProperty("pageIndex", 1)
        pageJson.addProperty("pageSize", 10)
        jsonObject.add("page", pageJson)
        return RequestBody.create(mediaType, jsonObject.toString())
    }


    fun createDetail(itemId: String): RequestBody {
        val jsonObject = JsonObject()
        jsonObject.addProperty("id", itemId)
        return RequestBody.create(mediaType, jsonObject.toString())
    }

    fun createConfirmOrderBody(dataList:List<ShopCartModel.ListData>):RequestBody{

        val jsonArray = JsonArray()
        dataList.forEach {
            val jsonObject = JsonObject()
            jsonObject.addProperty("amount",it.amount)
            jsonObject.addProperty("productId",it.id)
            jsonArray.add(jsonObject)
        }
        val jsonObject = JsonObject()
        jsonObject.add("shoppingCartProducts",jsonArray)
        return RequestBody.create(mediaType, jsonObject.toString())
    }


}