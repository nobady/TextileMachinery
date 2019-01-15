package com.textile.client.net

import com.textile.client.login.model.LoginModel
import com.textile.client.me.model.ClearCollModel
import io.reactivex.Observable
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * 所有请求的定义
 * Created by lff on 2019/1/10.
 */
interface NetApi {

    /*用户相关*/
    @POST("login")
    fun login(@Body body: RequestBody): Observable<ResponseBody>

    @POST("sendVerificationCode")
    fun getVerificationCode(@Body body: RequestBody):Observable<ResponseBody>

    @POST("register")
    fun register(@Body body: RequestBody):Observable<ResponseBody>

    @POST("user/updatePassword")
    fun resetPwd(@Body body: RequestBody):Observable<ResponseBody>

    /*商城*/
    @POST("banner/GetTotalList")
    fun getBannerList(@Body body: RequestBody):Observable<ResponseBody>

    @POST("userCollection/emptyCollection")
    fun clearCollected(@Body body: RequestBody): Observable<ResponseBody>
}