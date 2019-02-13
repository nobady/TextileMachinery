package com.textile.client.net

import com.textile.client.forum.model.ForumModel
import com.textile.client.login.model.LoginModel
import com.textile.client.mall.model.BannerModel
import com.textile.client.mall.model.BrandModel
import com.textile.client.mall.model.CategoryModel
import com.textile.client.mall.model.HotModel
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

    @POST("product/GetHotProductList")
    fun getHotProductList(@Body body: RequestBody):Observable<BaseModel<HotModel>>

    @POST("product/GetCategoryProductList")
    fun getCategoryProductList(@Body body: RequestBody):Observable<BaseModel<CategoryModel>>

    //分类产品页面中的 分类接口
    @POST("brand/GetBrandByCategory")
    fun getBrandData(@Body body: RequestBody):Observable<BaseModel<BrandModel>>


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