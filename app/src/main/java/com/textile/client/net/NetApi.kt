package com.textile.client.net

import com.google.gson.JsonObject
import com.textile.client.forum.model.*
import com.textile.client.login.model.LoginModel
import com.textile.client.mall.model.BannerModel
import com.textile.client.mall.model.BrandModel
import com.textile.client.mall.model.CategoryModel
import com.textile.client.mall.model.HotModel
import com.textile.client.me.model.ClearCollModel
import com.textile.client.me.model.CollectDemandModel
import com.textile.client.me.model.UpdatePhoneModel
import com.textile.client.shop_car.model.ShopCartModel
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
    fun getHotProductList(@Body body: RequestBody): Observable<BaseModel<HotModel>>

    @POST("product/GetCategoryProductList")
    fun getCategoryProductList(@Body body: RequestBody): Observable<BaseModel<HotModel>>

    //分类产品页面中的 分类接口
    @POST("brand/GetBrandByCategory")
    fun getBrandData(@Body body: RequestBody): Observable<BaseModel<List<BrandModel>>>


    /*论坛*/
    @POST("community/GetList")
    fun getForumList(@Body body: RequestBody): Observable<BaseModel<ForumModel>>

    @POST("community/listTechnicalCommunication")
    fun getListTechnicalCommunication(@Body body: RequestBody): Observable<BaseModel<TechModel>>

    @POST("community/listDemand")
    fun getListDemand(@Body body: RequestBody): Observable<BaseModel<DemandModel>>

    @POST("community/listRecruitment")
    fun getListRecruitment(@Body body: RequestBody): Observable<BaseModel<RecruitModel>>

    @POST("community/listSupply")
    fun getListSupply(@Body body: RequestBody): Observable<BaseModel<SupplyModel>>

    @POST("community/listApplyJob")
    fun getListApplyJob(@Body body: RequestBody): Observable<BaseModel<ApplyJobModel>>

    @POST("userCollection/emptyCollection")
    fun clearCollected(@Body body: RequestBody): Observable<BaseModel<ClearCollModel>>

    @POST("user/updatePhone")
    fun updatePhone(@Body body: RequestBody): Observable<BaseModel<UpdatePhoneModel>>

    @POST("user/updatePassword")
    fun updatePassword(@Body body: RequestBody): Observable<BaseModel<ClearCollModel>>

    @POST("userCollection/listDemandCollect")
    fun getListDemandCollect(@Body body: RequestBody): Observable<BaseModel<CollectDemandModel>>

    /*购物车*/
    @POST("shoppingCart/shoppingCart")
    fun getShopCartList(): Observable<BaseModel<ShopCartModel>>

    @POST("shoppingCart/modifyProductNumber")
    fun modifyProductNumber(@Body body: RequestBody): Observable<BaseModel<JsonObject>>

    @POST("api/community/getTechnicalCommunicationDetails")
    fun loadDetail(@Body body: RequestBody): Observable<BaseModel<DetailModel>>

}