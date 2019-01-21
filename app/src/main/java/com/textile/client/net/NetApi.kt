package com.textile.client.net

import com.textile.client.forum.model.ForumModel
import com.textile.client.login.model.BaseModel
import com.textile.client.login.model.LoginModel
import com.textile.client.mall.model.BannerModel
import com.textile.client.mall.model.CategoryModel
import com.textile.client.me.model.ClearCollModel
import com.textile.client.me.model.CollectDemandModel
import com.textile.client.me.model.UpdatePhoneModel
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * 所有请求的定义
 * Created by lff on 2019/1/10.
 */
interface NetApi {

    /*用户相关*/
    @POST("login")
    fun login(@Body body: RequestBody): Observable<BaseModel<LoginModel>>

    @POST("sendVerificationCode")
    fun getVerificationCode(@Body body: RequestBody): Observable<BaseModel<LoginModel>>

    @POST("register")
    fun register(@Body body: RequestBody): Observable<BaseModel<LoginModel>>

    @POST("user/updatePassword")
    fun resetPwd(@Body body: RequestBody): Observable<BaseModel<LoginModel>>

    /*商城*/
    @POST("banner/GetTotalList")
    fun getBannerList(@Body body: RequestBody): Observable<BaseModel<BannerModel>>

    @POST("category/getCategoryList")
    fun getCategoryList(): Observable<BaseModel<CategoryModel>>

    /*论坛*/
    @POST("community/GetList")
    fun getForumList(@Body body: RequestBody): Observable<BaseModel<ForumModel>>

    @POST("userCollection/emptyCollection")
    fun clearCollected(@Body body: RequestBody): Observable<BaseModel<ClearCollModel>>

    @POST("user/updatePhone")
    fun updatePhone(@Body body: RequestBody): Observable<BaseModel<UpdatePhoneModel>>

    @POST("user/updatePassword")
    fun updatePassword(@Body body: RequestBody): Observable<BaseModel<ClearCollModel>>

    @POST("userCollection/listDemandCollect")
    fun getListDemandCollect(@Body body: RequestBody):Observable<BaseModel<CollectDemandModel>>

}