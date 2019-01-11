package com.game.base.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by lff on 2019/1/11.
 */
class RetrofitClient private constructor(){

    companion object {
        fun getInstance() = SingletonHolder.holder
    }
    private object SingletonHolder{
        val holder = RetrofitClient()
    }

    private lateinit var okHttpClient:OkHttpClient
    private lateinit var mRetrofitBuilder: Retrofit.Builder

    init {
        initDefaultOkhttpClient()
        initDefaultRetrofit()
    }

    private fun initDefaultRetrofit(){
        mRetrofitBuilder = Retrofit.Builder()

        val callAdapterFactors = RetorfitConfig.getInstance().getCallAdapterFactors()
        val convertFactor = RetorfitConfig.getInstance().getConvertFactor()

        if (callAdapterFactors.size>0) {
            callAdapterFactors.forEach { mRetrofitBuilder.addCallAdapterFactory(it) }
        }else{
            mRetrofitBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        }

        if (convertFactor.size>0){
            convertFactor.forEach { mRetrofitBuilder.addConverterFactory(it) }
        }else{
            mRetrofitBuilder.addConverterFactory(GsonConverterFactory.create())
        }

    }

    private fun initDefaultOkhttpClient(){
        val builder = OkHttpClient.Builder()
        builder.readTimeout(10,TimeUnit.SECONDS)
        builder.writeTimeout(10,TimeUnit.SECONDS)
        builder.readTimeout(10,TimeUnit.SECONDS)

        builder.retryOnConnectionFailure(true)

        builder.addInterceptor(DefaultLogInterceptor())

        okHttpClient = builder.build()
    }

    fun getRetrofitBuilder() = mRetrofitBuilder

    fun getRetrofit(): Retrofit? {
        OkHttpConfig.getInstance().getOkhttpCilent()?.let { return mRetrofitBuilder.client(it).build() }
        OkHttpConfig.getInstance().getOkhttpCilent()?:let { return mRetrofitBuilder.client(okHttpClient).build() }
        return null
    }

}