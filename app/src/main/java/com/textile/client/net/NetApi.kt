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
import com.textile.client.shop_car.model.ConfirmOrderModel
import com.textile.client.shop_car.model.MyAddressModel
import com.textile.client.shop_car.model.ProductDetailModel
import com.textile.client.shop_car.model.ShopCartModel
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

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

    @GET("product/GetProductDetail")
    fun getProductDetail(@Body body: RequestBody):Observable<BaseModel<ProductDetailModel>>

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

    @POST("shoppingCart/removeProduct")
    fun removeShopCartProduct(@Body body: RequestBody):Observable<BaseModel<JsonObject>>

    /*订单*/
    @POST("order/shoppingCartPurchase")
    fun getConfrimOrderList(@Body body: RequestBody):Observable<BaseModel<ConfirmOrderModel>>

    @POST("community/getTechnicalCommunicationDetails")
    fun loadDetail(@Body body: RequestBody): Observable<BaseModel<DetailModel>>

    @GET("user/v1.0/search/{searchKey}")
    fun searchUser(@Path("searchKey") searchKey: String): Observable<BaseModel<ArrayList<String>>>

    /*地址*/
    @POST("user/userAddressList")
    fun getUserAddressList():Observable<BaseModel<List<MyAddressModel>>>

}