package com.textile.client.net

import com.textile.client.login.model.LoginModel
import com.textile.client.me.model.ClearCollModel
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * 所有请求的定义
 * Created by lff on 2019/1/10.
 */
interface NetApi {

    @POST("login")
    fun login(@Body body: RequestBody): Observable<LoginModel>

    @POST("userCollection/emptyCollection")
    fun clearCollected(@Body body: RequestBody): Observable<ClearCollModel>
}