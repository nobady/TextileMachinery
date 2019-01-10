package com.textile.client.net

import com.textile.client.login.model.LoginModel
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.*

/**
 * 所有请求的定义
 * Created by lff on 2019/1/10.
 */
interface NetApi {

    @POST("login")
    fun login(@Body body: RequestBody):Observable<LoginModel>


}